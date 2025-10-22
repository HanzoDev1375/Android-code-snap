package ir.ninjacoder.codesnap.widget.data;

import android.text.TextPaint;
import android.text.style.CharacterStyle;

class ShadowSpan extends CharacterStyle {
  private final float radius;
  private final float dx;
  private final float dy;
  private final int shadowColor;

  public ShadowSpan(float radius, float dx, float dy, int shadowColor) {
    this.radius = radius;
    this.dx = dx;
    this.dy = dy;
    this.shadowColor = shadowColor;
  }

  @Override
  public void updateDrawState(TextPaint tp) {
    tp.setShadowLayer(radius, dx, dy, shadowColor);
  }
}
