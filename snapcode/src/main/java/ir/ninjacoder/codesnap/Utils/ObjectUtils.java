package ir.ninjacoder.codesnap.Utils;

import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import org.antlr.v4.runtime.Lexer;

public class ObjectUtils {
  public static boolean getNextLexer(Lexer lexer, char item) {
    return lexer._input.LA(1) == item;
  }

  public static void animIconShow(boolean show, ImageView v) {
    if (show) {
      v.setVisibility(View.VISIBLE);
      v.setScaleX(0.5f);
      v.setScaleY(0.5f);
      v.setAlpha(0f);
      v.animate()
          .scaleX(1f)
          .scaleY(1f)
          .alpha(1f)
          .setDuration(400)
          .setInterpolator(new OvershootInterpolator(0.8f))
          .start();
    } else {

      v.animate()
          .scaleX(0.7f)
          .scaleY(0.7f)
          .alpha(0f)
          .setDuration(300)
          .setInterpolator(new AccelerateInterpolator())
          .withEndAction(
              () -> {
                v.setVisibility(View.INVISIBLE);
                v.setScaleX(1f);
                v.setScaleY(1f);
                v.setAlpha(1f);
              })
          .start();
    }
  }

  public static void animIcon(ImageView v, int newIconRes) {
    // انیمیشن خروج
    v.animate()
        .scaleX(0.7f)
        .scaleY(0.7f)
        .alpha(0f)
        .setDuration(150)
        .setInterpolator(new AccelerateInterpolator())
        .withEndAction(
            () -> {
              
              v.setImageResource(newIconRes);
              v.setScaleX(0.5f);
              v.setScaleY(0.5f);
              v.animate()
                  .scaleX(1f)
                  .scaleY(1f)
                  .alpha(1f)
                  .setDuration(200)
                  .setInterpolator(new OvershootInterpolator(0.8f))
                  .start();
            })
        .start();
  }
}
