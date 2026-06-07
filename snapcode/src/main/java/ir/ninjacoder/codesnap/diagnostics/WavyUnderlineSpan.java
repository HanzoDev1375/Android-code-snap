package ir.ninjacoder.codesnap.diagnostics;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class WavyUnderlineSpan extends ReplacementSpan {

  private final int waveColor;

  public WavyUnderlineSpan(DiagnosticsState state) {
    this.waveColor = state.getColor();
  }

  @Override
  public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {

    return Math.round(paint.measureText(text, start, end));
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

    float width = paint.measureText(text, start, end);

    float waveY = y + 4;

    Paint wavePaint = new Paint(paint);
    wavePaint.setColor(waveColor);
    wavePaint.setStyle(Paint.Style.STROKE);
    wavePaint.setStrokeWidth(2f);
    wavePaint.setAntiAlias(true);

    Path path = new Path();
    path.moveTo(x, waveY);

    float wavelength = 12f;
    float amplitude = 3f;

    for (float dx = 0; dx < width; dx += wavelength) {
      path.rQuadTo(wavelength / 4, -amplitude, wavelength / 2, 0);
      path.rQuadTo(wavelength / 4, amplitude, wavelength / 2, 0);
    }

    canvas.drawPath(path, wavePaint);
  }

  private void drawWavyUnderline(
      Canvas canvas, float x, int baseline, CharSequence text, int start, int end, Paint paint) {

    float width = paint.measureText(text, start, end);

    float waveY = baseline + paint.getStrokeWidth() + 3;

    Paint wavePaint = new Paint(paint);
    wavePaint.setColor(waveColor);
    wavePaint.setStyle(Paint.Style.STROKE);
    wavePaint.setStrokeWidth(2f);
    wavePaint.setAntiAlias(true);

    Path path = new Path();
    path.moveTo(x, waveY);

    float wavelength = 12f;
    float amplitude = 3f;

    for (float dx = 0; dx < width; dx += wavelength) {
      path.rQuadTo(wavelength / 4, -amplitude, wavelength / 2, 0);
      path.rQuadTo(wavelength / 4, amplitude, wavelength / 2, 0);
    }

    canvas.drawPath(path, wavePaint);
  }
}
