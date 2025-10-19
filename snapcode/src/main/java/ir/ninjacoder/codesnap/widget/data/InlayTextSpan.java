package ir.ninjacoder.codesnap.widget.data;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.ReplacementSpan;

public class InlayTextSpan extends ReplacementSpan {

  public enum Mode {
    INLINE,
    ABOVE_LINE
  }

  private final String hint;
  private final int backgroundColor;
  private final int textColor;
  private final float padding;
  private final Mode mode;

  public InlayTextSpan(String hint, int backgroundColor, int textColor, Mode mode) {
    this.hint = hint;
    this.backgroundColor = backgroundColor;
    this.textColor = textColor;
    this.padding = 10f;
    this.mode = mode;
  }

  @Override
  public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
    float textWidth = paint.measureText(text, start, end);
    if (mode == Mode.INLINE) {
      float hintWidth = paint.measureText(" " + hint) + padding * 2;
      return (int) (textWidth + hintWidth);
    } else {
      return (int) textWidth;
    }
  }

  @Override
  public void draw(
      Canvas canvas,
      CharSequence text,
      int start,
      int end,
      float x,
      int top,
      int y,
      int bottom,
      Paint paint) {

    // رنگ اصلی
    int originalColor = paint.getColor();
    if (text instanceof Spanned) {
      Spanned spanned = (Spanned) text;
      ForegroundColorSpan[] spans = spanned.getSpans(start, end, ForegroundColorSpan.class);
      if (spans != null && spans.length > 0) {
        originalColor = spans[spans.length - 1].getForegroundColor();
      }
    }

    Paint textPaint = new Paint(paint);
    textPaint.setColor(originalColor);
    canvas.drawText(text, start, end, x, y, textPaint);

    // رسم hint
    Paint hintPaint = new Paint(paint);
    hintPaint.setColor(textColor);
    hintPaint.setTextSize(paint.getTextSize() * 0.8f);
    hintPaint.setAntiAlias(true);

    if (mode == Mode.INLINE) {
      float textWidth = textPaint.measureText(text, start, end);
      float hintWidth = hintPaint.measureText(" " + hint) + padding * 2;
      float ascent = paint.ascent();
      float descent = paint.descent();

      RectF rect =
          new RectF(
              x + textWidth + padding / 2, y + ascent, x + textWidth + hintWidth, y + descent);

      Paint bgPaint = new Paint(paint);
      bgPaint.setColor(backgroundColor);
      bgPaint.setAntiAlias(true);
      canvas.drawRoundRect(rect, 12f, 12f, bgPaint);

      canvas.drawText(" " + hint, x + textWidth + padding, y, hintPaint);

    } else if (mode == Mode.ABOVE_LINE) {
      // 🎯 حالت بالای متن (چسبیده به ابتدای خط)
      float hintYOffset = -paint.getTextSize() * 0.8f; // فاصله از متن اصلی
      float startX = x ;
      if (startX < 0) startX = x; // ایمنی

      float bgWidth = hintPaint.measureText(hint) + padding * 2;
      float bgHeight = hintPaint.getTextSize() * 1.4f;

      RectF rect = new RectF(startX, y + hintYOffset - bgHeight, startX + bgWidth, y + hintYOffset);

      Paint bgPaint = new Paint(paint);
      bgPaint.setColor(backgroundColor);
      bgPaint.setAntiAlias(true);
      canvas.drawRoundRect(rect, 12f, 12f, bgPaint);

      canvas.drawText(hint, startX + padding, y + hintYOffset - padding / 2, hintPaint);
    }
  }
}
