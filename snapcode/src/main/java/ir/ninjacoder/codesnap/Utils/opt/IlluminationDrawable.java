/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ir.ninjacoder.codesnap.Utils.opt;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.Keep;
import androidx.core.graphics.ColorUtils;
import ir.ninjacoder.codesnap.R;
import org.xmlpull.v1.XmlPullParser;
import java.util.ArrayList;

public class IlluminationDrawable extends Drawable {

  private static final long BACKGROUND_ANIM_DURATION = 370L;

  private int[] themeAttrs = null;
  private float cornerRadiusOverride = -1f;
  private float cornerRadius = 0f;
  private int highlightColor = Color.TRANSPARENT;
  private float[] tmpHsl = new float[3];
  private Paint paint = new Paint();
  private float highlight = 0f;
  private ArrayList<LightSourceDrawable> lightSources = new ArrayList<>();

  private int backgroundColor = Color.TRANSPARENT;
  private ValueAnimator backgroundAnimation = null;

  private final TimeInterpolator FAST_OUT_LINEAR_IN = new PathInterpolator(0.4f, 0f, 1f, 1f);

  public IlluminationDrawable() {}

  public float getCornerRadius() {
    return cornerRadiusOverride >= 0 ? cornerRadiusOverride : cornerRadius;
  }

  @Override
  public void draw(Canvas canvas) {
    RectF rect = new RectF(0, 0, getBounds().width(), getBounds().height());
    canvas.drawRoundRect(rect, getCornerRadius(), getCornerRadius(), paint);
  }

  @Override
  public void getOutline(Outline outline) {
    outline.setRoundRect(getBounds(), getCornerRadius());
  }

  @Override
  public int getOpacity() {
    return PixelFormat.TRANSPARENT;
  }

  @Override
  public void inflate(
      Resources r, XmlPullParser parser, AttributeSet attrs, Resources.Theme theme) {
    TypedArray a = r.obtainAttributes(attrs, new int[0]);
    a.recycle();
  }

  @Override
  public boolean canApplyTheme() {
    return false;
  }

  @Override
  public void setColorFilter(ColorFilter colorFilter) {
    throw new UnsupportedOperationException("Color filters are not supported");
  }

  @Override
  public void setAlpha(int alpha) {
    if (alpha == paint.getAlpha()) {
      return;
    }

    paint.setAlpha(alpha);
    invalidateSelf();

    for (LightSourceDrawable lightSource : lightSources) {
      lightSource.setAlpha(alpha);
    }
  }

  @Override
  public int getAlpha() {
    return paint.getAlpha();
  }

  public void setXfermode(Xfermode mode) {
    if (mode == paint.getXfermode()) {
      return;
    }

    paint.setXfermode(mode);
    invalidateSelf();
  }

  private void animateBackground() {
    ColorUtils.colorToHSL(backgroundColor, tmpHsl);
    float L = tmpHsl[2];
    tmpHsl[2] = constrain(L < 1f - highlight ? L + highlight : L - highlight, 0f, 1f);

    final int initialBackground = paint.getColor();
    final int initialHighlight = highlightColor;
    final int finalHighlight = ColorUtils.HSLToColor(tmpHsl);

    if (backgroundAnimation != null) {
      backgroundAnimation.cancel();
    }

    backgroundAnimation = ValueAnimator.ofFloat(0f, 1f);
    backgroundAnimation.setDuration(BACKGROUND_ANIM_DURATION);
    backgroundAnimation.setInterpolator(FAST_OUT_LINEAR_IN);
    backgroundAnimation.addUpdateListener(
        animation -> {
          float progress = (float) animation.getAnimatedValue();
          paint.setColor(blendARGB(initialBackground, backgroundColor, progress));
          highlightColor = blendARGB(initialHighlight, finalHighlight, progress);
          for (LightSourceDrawable lightSource : lightSources) {
            lightSource.setHighlightColor(highlightColor);
          }
          invalidateSelf();
        });
    backgroundAnimation.addListener(
        new AnimatorListenerAdapter() {
          @Override
          public void onAnimationEnd(Animator animation) {
            backgroundAnimation = null;
          }
        });
    backgroundAnimation.start();
  }

  @Override
  public void setTintList(ColorStateList tint) {
    super.setTintList(tint);
    if (tint != null) {
      backgroundColor = tint.getDefaultColor();
      animateBackground();
    }
  }

  public void registerLightSource(View lightSource) {
    Drawable background = lightSource.getBackground();
    Drawable foreground = lightSource.getForeground();

    if (background instanceof LightSourceDrawable) {
      registerLightSource((LightSourceDrawable) background);
    } else if (foreground instanceof LightSourceDrawable) {
      registerLightSource((LightSourceDrawable) foreground);
    }
  }

  private void registerLightSource(LightSourceDrawable lightSource) {
    lightSource.setAlpha(paint.getAlpha());
    lightSources.add(lightSource);
  }

  public void setCornerRadiusOverride(Float cornerRadius) {
    cornerRadiusOverride = cornerRadius != null ? cornerRadius : -1f;
    invalidateSelf();
  }

  // Helper methods
  private float constrain(float amount, float low, float high) {
    return amount < low ? low : (amount > high ? high : amount);
  }

  private int blendARGB(int color1, int color2, float ratio) {
    final float inverseRatio = 1f - ratio;
    float a = (Color.alpha(color1) * inverseRatio) + (Color.alpha(color2) * ratio);
    float r = (Color.red(color1) * inverseRatio) + (Color.red(color2) * ratio);
    float g = (Color.green(color1) * inverseRatio) + (Color.green(color2) * ratio);
    float b = (Color.blue(color1) * inverseRatio) + (Color.blue(color2) * ratio);
    return Color.argb((int) a, (int) r, (int) g, (int) b);
  }
}
