package ir.ninjacoder.codesnap.markdownpreview;

import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.URLSpan;
import android.graphics.DashPathEffect;
import android.view.View;

public class DottedUnderlineSpan extends URLSpan {

  public DottedUnderlineSpan(String url) {
    super(url);
  }

  @Override
  public void updateDrawState(TextPaint ds) {
    super.updateDrawState(ds);
    ds.setUnderlineText(false);
    ds.setStyle(Paint.Style.STROKE);
    ds.setPathEffect(new DashPathEffect(new float[] {4, 8}, 0));
    ds.setColor(ds.linkColor);
  }
}
