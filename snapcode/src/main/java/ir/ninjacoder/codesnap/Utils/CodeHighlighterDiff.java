package ir.ninjacoder.codesnap.Utils;

import android.graphics.Color;
import androidx.core.graphics.ColorUtils;
import ir.ninjacoder.codesnap.LangType;
import ir.ninjacoder.codesnap.antlr4.diff.DiffLexer;
import ir.ninjacoder.codesnap.colorhelper.ColorHelper;
import android.text.SpannableStringBuilder;
import ir.ninjacoder.codesnap.widget.data.SpanStyler;
import java.io.StringReader;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;

public class CodeHighlighterDiff implements Highlighter {

  @Override
  public SpannableStringBuilder highlight(LangType types, String code, ColorHelper color)
      throws Exception {

    SpanStyler span = SpanStyler.create();
    DiffLexer lexer = new DiffLexer(CharStreams.fromReader(new StringReader(code)));

    Token token;

    while ((token = lexer.nextToken()) != null) {
      int type = token.getType();
      String text = token.getText();

      if (type == DiffLexer.EOF) {
        break;
      }

      switch (type) {
        case DiffLexer.WS:
        case DiffLexer.NEWLINE:
          span.addNullText(text);
          break;

        case DiffLexer.DIFF:
          // پس‌زمینه آبی با آلفا برای کلمه کلیدی
          span.textWithBackground(
              text, Color.parseColor("#FF99FF77"), ColorUtils.setAlphaComponent(Color.parseColor("#FF99FF77"), 64));
          break;

        case DiffLexer.INDEX:
          // پس‌زمینه بنفش با آلفا برای متغیر
          span.textWithBackground(
              text, Color.parseColor("#FFFCC8B1"), ColorUtils.setAlphaComponent(Color.parseColor("#FFFCC8B1"), 64));
          break;

        case DiffLexer.OLD_FILE:
        case DiffLexer.NEW_FILE:
          // پس‌زمینه سبز با آلفا برای فایل‌ها
          span.textWithBackground(
              text, Color.GREEN, ColorUtils.setAlphaComponent(Color.GREEN, 32));
          break;

        case DiffLexer.HUNK_HEADER:
          // پس‌زمینه نارنجی با آلفا برای هدر hunk
          span.textWithBackground(
              text, Color.parseColor("#FFFF9800"), ColorUtils.setAlphaComponent(Color.parseColor("#FFFF9800"), 64) // نارنجی
              );
          break;

        case DiffLexer.ADDED_LINE:
          // پس‌زمینه سبز بسیار کم‌رنگ برای خطوط اضافه شده
          span.textWithBackground(text, Color.GREEN, ColorUtils.setAlphaComponent(Color.GREEN, 32));
          break;

        case DiffLexer.REMOVED_LINE:
          // پس‌زمینه قرمز بسیار کم‌رنگ برای خطوط حذف شده
          span.textWithBackground(text, Color.RED, ColorUtils.setAlphaComponent(Color.RED, 32));
          break;

        case DiffLexer.CONTEXT_LINE:
          // پس‌زمینه خاکستری با آلفا برای خطوط context
          span.textWithBackground(
              text, Color.CYAN, ColorUtils.setAlphaComponent(Color.GRAY, 50));
          break;

        case DiffLexer.NO_NEWLINE:
          // پس‌زمینه زرد با آلفا برای no newline
          span.textWithBackground(
              text, Color.YELLOW, ColorUtils.setAlphaComponent(Color.YELLOW, 64));
          break;

        default:
          // پس‌زمینه خیلی کم‌رنگ برای متن معمولی
          span.textWithBackground(
              text, color.getTextnormal(), ColorUtils.setAlphaComponent(color.getTextnormal(), 16));
          break;
      }
    }

    return span;
  }
}
