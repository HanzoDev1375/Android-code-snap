package ir.ninjacoder.codesnap.widget.data;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.graphics.Paint;
import android.text.style.MetricAffectingSpan;

public class CustomTypefaceSpan extends MetricAffectingSpan {
  private final Typeface typeface;

  public CustomTypefaceSpan(Typeface typeface) {
    this.typeface = typeface;
  }

  @Override
  public void updateDrawState(TextPaint ds) {
    applyCustomTypeface(ds);
  }

  @Override
  public void updateMeasureState(TextPaint paint) {
    applyCustomTypeface(paint);
  }

  private void applyCustomTypeface(Paint paint) {
    Typeface old = paint.getTypeface();
    int oldStyle = old != null ? old.getStyle() : 0;
    int fakeStyle = oldStyle & ~typeface.getStyle();

    if ((fakeStyle & Typeface.BOLD) != 0) {
      paint.setFakeBoldText(true);
    }
    if ((fakeStyle & Typeface.ITALIC) != 0) {
      paint.setTextSkewX(-0.25f);
    }
    paint.setTypeface(typeface);
  }
}
