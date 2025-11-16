package ir.ninjacoder.codesnap.widget.ghostide;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RotateDrawable;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.slider.Slider;
import android.util.AttributeSet;
import ir.ninjacoder.codesnap.R;

public class SliderCompat extends Slider {

  protected SliderShape sh = SliderShape.COOKIE12;
  protected int resid = 0;
  protected int colorSlider = R.attr.colorPrimary;

  public SliderCompat(Context c) {
    super(c);
    init();
  }

  public SliderCompat(Context c, AttributeSet set) {
    super(c, set);
    init();
  }

  void init() {
    updateState();
    addOnChangeListener(
        (slider, value, fromuser) -> {
          animateRotateDrawable(value);
        });
  }

  private void animateRotateDrawable(float newValue) {
    setTrackActiveTintList(
        ColorStateList.valueOf(MaterialColors.getColor(this, colorSlider, Color.RED)));

    Drawable cookieDrawable = getContext().getDrawable(resid);
    if (cookieDrawable != null) {
      RotateDrawable rotateDrawable = new RotateDrawable();
      rotateDrawable.setDrawable(cookieDrawable);
      rotateDrawable.setFromDegrees(0);
      rotateDrawable.setToDegrees(360);
      rotateDrawable.setPivotX(0.5f);
      rotateDrawable.setPivotY(0.5f);
      float progress = (newValue - getValueFrom()) / (getValueTo() - getValueFrom());
      int level = (int) (progress * 10000);
      rotateDrawable.setLevel(level);

      rotateDrawable.setTint(MaterialColors.getColor(this, colorSlider, 0));
      rotateDrawable.setTintMode(PorterDuff.Mode.SRC_IN);

      setCustomThumbDrawable(rotateDrawable);
    }
  }

  public SliderShape getSh() {
    return this.sh;
  }

  public void setSh(SliderShape sh) {
    this.sh = sh;
    updateState();
  }

  void updateState() {
    if (sh == SliderShape.COOKIE12) {
      resid = R.drawable.material_shape_cookie_12;
    }
    animateRotateDrawable(getValue());
  }

  public int getColorSlider() {
    return this.colorSlider;
  }

  public void setColorSlider(int colorSlider) {
    this.colorSlider = colorSlider;
    animateRotateDrawable(getValue());
  }
}
