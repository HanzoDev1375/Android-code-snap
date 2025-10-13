package ir.ninjacoder.code.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.style.ReplacementSpan;
import androidx.annotation.NonNull;

public class InlaySpan extends ReplacementSpan {
  private final String text;
  private final int textColor;
  private final float textSize;
  private final int backgroundColor;
  private int width = -1;

  public InlaySpan(String text, int textColor, float textSize, int backgroundColor) {
    this.text = text;
    this.textColor = textColor;
    this.textSize = textSize;
    this.backgroundColor = backgroundColor;
  }

  @Override
  public int getSize(
      @NonNull Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
    if (width == -1) {
      Paint tempPaint = new Paint(paint);
      tempPaint.setTextSize(textSize);
      width = (int) tempPaint.measureText(this.text) + 16; // 8px padding from each side
    }
    return width;
  }

  @Override
  public void draw(
      @NonNull Canvas canvas,
      CharSequence text,
      int start,
      int end,
      float x,
      int top,
      int y,
      int bottom,
      @NonNull Paint paint) {

    // ذخیره تنظیمات فعلی paint
    float oldTextSize = paint.getTextSize();
    int oldColor = paint.getColor();
    Paint.Style oldStyle = paint.getStyle();

    // اندازه‌گیری متن
    paint.setTextSize(textSize);
    float textWidth = paint.measureText(this.text);
    int totalWidth = (int) textWidth + 16;

    // رسم پس‌زمینه اگر شفاف نیست
    if (backgroundColor != 0) {
      paint.setColor(backgroundColor);
      paint.setStyle(Paint.Style.FILL);
      Rect bounds = new Rect((int) x, top, (int) (x + totalWidth), bottom);
      canvas.drawRect(bounds, paint);
    }

    // رسم متن
    paint.setColor(textColor);
    paint.setStyle(Paint.Style.FILL);

    // محاسبه موقعیت عمودی برای وسط‌چین
    Paint.FontMetrics metrics = paint.getFontMetrics();
    float textHeight = metrics.descent - metrics.ascent;
    float textY = y + ((bottom - top - textHeight) / 2) - metrics.descent;

    canvas.drawText(this.text, x + 8, textY, paint);

    // بازگردانی تنظیمات paint
    paint.setTextSize(oldTextSize);
    paint.setColor(oldColor);
    paint.setStyle(oldStyle);
  }
}
