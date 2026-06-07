package ir.ninjacoder.code.markwon;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

public class TypefaceSpanCompat extends MetricAffectingSpan {
  private final Typeface typeface;

  public TypefaceSpanCompat(Typeface typeface) {
    this.typeface = typeface;
  }

  @Override
  public void updateDrawState(TextPaint tp) {
    apply(tp);
  }

  @Override
  public void updateMeasureState(TextPaint tp) {
    apply(tp);
  }

  private void apply(TextPaint paint) {
    paint.setTypeface(typeface);
  }
}
