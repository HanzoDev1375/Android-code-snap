package ir.ninjacoder.codesnap.Utils.opt;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.Keep;
import androidx.core.graphics.ColorUtils;
import ir.ninjacoder.codesnap.R;

import org.xmlpull.v1.XmlPullParser;

public class LightSourceDrawable extends Drawable {
  private static final long RIPPLE_ANIM_DURATION = 800L;
  private static final float RIPPLE_DOWN_PROGRESS = 0.05f;
  private static final long RIPPLE_CANCEL_DURATION = 200L;
  private static final float[] GRADIENT_STOPS = new float[] {0.2f, 1f};

  // متد lerp جایگزین
  private float lerp(float start, float stop, float amount) {
    return start + (stop - start) * amount;
  }

  // Interpolator جایگزین
  private final TimeInterpolator LINEAR_OUT_SLOW_IN = new PathInterpolator(0f, 0f, 0.2f, 1f);

  private static class RippleData {
    float x = 0f;
    float y = 0f;
    float alpha = 0f;
    float progress = 0f;
    float minSize = 20f;
    float maxSize = 200f;
    float highlight = 0.5f;
  }

  private boolean pressed = false;
  private int[] themeAttrs = null;
  private final RippleData rippleData = new RippleData();
  private final Paint paint = new Paint();
  private int highlightColor = Color.WHITE;
  private boolean active = false;
  private Animator rippleAnimation = null;

  public LightSourceDrawable() {}

  public int getHighlightColor() {
    return highlightColor;
  }

  public void setHighlightColor(int value) {
    if (highlightColor == value) return;
    highlightColor = value;
    invalidateSelf();
  }
  public void setRippleMinSize(float minSize) {
    rippleData.minSize = minSize;
    invalidateSelf();
  }

  public void setRippleMaxSize(float maxSize) {
    rippleData.maxSize = maxSize;
    invalidateSelf();
  }

  public void setHighlightIntensity(float intensity) {
    rippleData.highlight = intensity;
    invalidateSelf();
  }

  @Override
  public void draw(Canvas canvas) {
    // استفاده از متد lerr داخلی
    float radius = lerp(rippleData.minSize, rippleData.maxSize, rippleData.progress);
    int centerColor = ColorUtils.setAlphaComponent(highlightColor, (int) (rippleData.alpha * 255));
    paint.setShader(
        new RadialGradient(
            rippleData.x,
            rippleData.y,
            radius,
            new int[] {centerColor, Color.TRANSPARENT},
            GRADIENT_STOPS,
            Shader.TileMode.CLAMP));
    canvas.drawCircle(rippleData.x, rippleData.y, radius, paint);
  }

  @Override
  public void getOutline(Outline outline) {
    // No bounds
  }

  @Override
  public int getOpacity() {
    return PixelFormat.TRANSPARENT;
  }

  

  @Override
  public void setColorFilter(ColorFilter colorFilter) {
    throw new UnsupportedOperationException("Color filters are not supported");
  }

  @Override
  public void setAlpha(int alpha) {
    if (alpha == paint.getAlpha()) return;
    paint.setAlpha(alpha);
    invalidateSelf();
  }

  private void illuminate() {
    rippleData.alpha = 1f;
    invalidateSelf();

    if (rippleAnimation != null) {
      rippleAnimation.cancel();
    }

    ValueAnimator alphaAnimator = ValueAnimator.ofFloat(1f, 0f);
    alphaAnimator.setStartDelay(133);
    alphaAnimator.setDuration(RIPPLE_ANIM_DURATION - alphaAnimator.getStartDelay());
    alphaAnimator.setInterpolator(LINEAR_OUT_SLOW_IN);
    alphaAnimator.addUpdateListener(
        animation -> {
          rippleData.alpha = (float) animation.getAnimatedValue();
          invalidateSelf();
        });

    ValueAnimator progressAnimator = ValueAnimator.ofFloat(rippleData.progress, 1f);
    progressAnimator.setDuration(RIPPLE_ANIM_DURATION);
    progressAnimator.setInterpolator(LINEAR_OUT_SLOW_IN);
    progressAnimator.addUpdateListener(
        animation -> {
          rippleData.progress = (float) animation.getAnimatedValue();
          invalidateSelf();
        });

    AnimatorSet animatorSet = new AnimatorSet();
    animatorSet.playTogether(alphaAnimator, progressAnimator);
    animatorSet.addListener(
        new AnimatorListenerAdapter() {
          @Override
          public void onAnimationEnd(Animator animation) {
            rippleData.progress = 0f;
            rippleAnimation = null;
            invalidateSelf();
          }
        });

    rippleAnimation = animatorSet;
    animatorSet.start();
  }

  @Override
  public void setHotspot(float x, float y) {
    rippleData.x = x;
    rippleData.y = y;
    if (active) invalidateSelf();
  }

  @Override
  public boolean isStateful() {
    return true;
  }

  @Override
  public boolean hasFocusStateSpecified() {
    return true;
  }

  @Override
  public boolean isProjected() {
    return true;
  }

  @Override
  public Rect getDirtyBounds() {
    float radius = lerp(rippleData.minSize, rippleData.maxSize, rippleData.progress);
    return new Rect(
        (int) (rippleData.x - radius),
        (int) (rippleData.y - radius),
        (int) (rippleData.x + radius),
        (int) (rippleData.y + radius));
  }

  @Override
  protected boolean onStateChange(int[] stateSet) {
    boolean wasPressed = pressed;
    boolean enabled = false;
    pressed = false;
    boolean focused = false;
    boolean hovered = false;

    for (int state : stateSet) {
      if (state == android.R.attr.state_enabled) enabled = true;
      else if (state == android.R.attr.state_focused) focused = true;
      else if (state == android.R.attr.state_pressed) pressed = true;
      else if (state == android.R.attr.state_hovered) hovered = true;
    }

    boolean newActive = enabled && (pressed || focused || hovered);
    if (active != newActive) {
      active = newActive;

      if (active) {
        if (rippleAnimation != null) rippleAnimation.cancel();
        rippleData.alpha = 1f;
        rippleData.progress = RIPPLE_DOWN_PROGRESS;
      } else {
        if (rippleAnimation != null) rippleAnimation.cancel();
        ValueAnimator cancelAnimator = ValueAnimator.ofFloat(rippleData.alpha, 0f);
        cancelAnimator.setDuration(RIPPLE_CANCEL_DURATION);
        cancelAnimator.setInterpolator(LINEAR_OUT_SLOW_IN);
        cancelAnimator.addUpdateListener(
            animation -> {
              rippleData.alpha = (float) animation.getAnimatedValue();
              invalidateSelf();
            });
        cancelAnimator.addListener(
            new AnimatorListenerAdapter() {
              private boolean cancelled = false;

              @Override
              public void onAnimationCancel(Animator animation) {
                cancelled = true;
              }

              @Override
              public void onAnimationEnd(Animator animation) {
                if (!cancelled) {
                  rippleData.progress = 0f;
                  rippleData.alpha = 0f;
                  rippleAnimation = null;
                  invalidateSelf();
                }
              }
            });
        rippleAnimation = cancelAnimator;
        cancelAnimator.start();
      }
      invalidateSelf();
    }

    if (wasPressed && !pressed) {
      illuminate();
    }

    return super.onStateChange(stateSet);
  }
}
