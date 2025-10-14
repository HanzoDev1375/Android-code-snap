package ir.ninjacoder.codesnap.Utils;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

public class ColorUtil {

  static int max = 99;

  public static Drawable get(int color) {
    var it =
        new MaterialShapeDrawable(
            ShapeAppearanceModel.builder().setAllCorners(CornerFamily.ROUNDED, max).build());
    it.setFillColor(ColorStateList.valueOf(color));
    return it;
  }
}
