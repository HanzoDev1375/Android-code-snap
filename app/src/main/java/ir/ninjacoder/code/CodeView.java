package ir.ninjacoder.code;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;

public class CodeView extends View {
  Paint p ;
  public CodeView(Context f) {
    super(f);
    p.clearShadowLayer();
  }
}
