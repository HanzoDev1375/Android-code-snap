package ir.ninjacoder.codesnap.Utils;

import android.text.SpannableStringBuilder;
import ir.ninjacoder.codesnap.LangType;
import ir.ninjacoder.codesnap.bracket.BracketManager;
import ir.ninjacoder.codesnap.bracket.BracketPosition;
import ir.ninjacoder.codesnap.colorhelper.ColorHelper;
import ir.ninjacoder.codesnap.widget.data.SpanStyler;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

public class CodeHighlighterRuby implements Highlighter {

  private static final Pattern RUBY_PATTERN =
      Pattern.compile(
          // Strings (با اولویت بالا)
          "(\"[^\"]*\"|'[^']*')"
              + "|"
              +
              // Comments
              "(#.*)"
              + "|"
              +
              // Words before colon (مثل name:)
              "(\\w+)(:)"
              + "|"
              +
              // Class/Module names after keywords
              "\\b(class|module|def)\\s+([a-zA-Z_]\\w*)"
              + "|"
              +
              // Keywords
              "\\b(alias|and|BEGIN|begin|break|case|def|defined\\?|do|else|elsif|END|end|ensure|false|for|if|in|next|nil|not|or|redo|rescue|retry|return|self|super|then|true|undef|unless|until|when|while|yield|__FILE__|__LINE__)\\b"
              + "|"
              +
              // Numbers
              "(-?\\b\\d+(?:\\.\\d+)?(?:[eE][+-]?\\d+)?\\b)"
              + "|"
              +
              // Instance variables
              "(@@?[a-zA-Z_]\\w*)"
              + "|"
              +
              // Global variables
              "(\\$[a-zA-Z_]\\w*)"
              + "|"
              +
              // Symbols
              "(?:^|\\s)(:[:$@]?[a-zA-Z_]\\w*)"
              + "|"
              +
              // Operators and brackets
              "([{}()\\[\\].,;:|&^~!?=+\\-*/%<>])"
              + "|"
              +
              // Whitespace
              "(\\s+)");

  @Override
  public SpannableStringBuilder highlight(LangType types, String code, ColorHelper color)
      throws Exception {
    SpanStyler span = SpanStyler.create();
    BracketManager manager = new BracketManager();
    List<BracketPosition> bracketPositions = new ArrayList<>();

    Matcher matcher = RUBY_PATTERN.matcher(code);
    int lastIndex = 0;

    while (matcher.find()) {
      // متن بین matchها
      if (matcher.start() > lastIndex) {
        String betweenText = code.substring(lastIndex, matcher.start());
        span.addNullText(betweenText);
      }

      String matched = matcher.group();

      // تشخیص نوع توکن بر اساس گروه‌ها
      if (matcher.group(1) != null) {
        // رشته‌ها
        span.text(matched, color.getStrings());
      } else if (matcher.group(2) != null) {
        // کامنت‌ها
        span.text(matched, color.getComment());
      } else if (matcher.group(3) != null && matcher.group(4) != null) {
        // کلمه قبل از colon (مثل name:)
        String word = matcher.group(3);
        String colon = matcher.group(4);

        span.text(word, color.getSymbol()); // کلمه قبل از : با رنگ symbol
        span.text(colon, color.getOperator()); // : با رنگ operator
      } else if (matcher.group(5) != null && matcher.group(6) != null) {
        // class/module/def با نام بعدی
        String keyword = matcher.group(5);
        String name = matcher.group(6);

        span.text(keyword, color.getKeyword());
        span.text(" ", color.getTextnormal());
        span.text(name, color.getLastsymi()); // نام کلاس/ماژول/متد
      } else if (matcher.group(7) != null) {
        // کلمات کلیدی معمولی
        span.text(matched, color.getKeyword());
      } else if (matcher.group(8) != null) {
        // اعداد
        span.text(matched, color.getHtmlattr());
      } else if (matcher.group(9) != null) {
        // متغیرهای instance
        span.text(matched, color.getVariable());
      } else if (matcher.group(10) != null) {
        // متغیرهای global
        span.text(matched, color.getMethod());
      } else if (matcher.group(11) != null) {
        // Symbols عمومی
        span.text(matched, color.getSymbol());
      } else if (matcher.group(12) != null) {
        // عملگرها و براکت‌ها
        if (isBracket(matched)) {
          bracketPositions.add(
              new BracketPosition(
                  matcher.start(), matcher.end(), matched.charAt(0), getBracketType(matched)));
        }
        span.text(matched, color.getOperator());
      } else if (matcher.group(13) != null) {
        // فاصله‌ها
        span.addNullText(matched);
      } else {
        // متن معمولی
        span.addNullText(matched);
      }

      lastIndex = matcher.end();
    }

    // متن باقی‌مانده در انتها
    if (lastIndex < code.length()) {
      span.addNullText(code.substring(lastIndex));
    }

    // براکت رنگی
    manager.setRainbowBracketsEnabled(true);
    if (!bracketPositions.isEmpty()) {
      manager.applyRainbowBrackets(span, bracketPositions);
    }

    return span;
  }

  private boolean isBracket(String text) {
    return text.equals("{")
        || text.equals("}")
        || text.equals("[")
        || text.equals("]")
        || text.equals("(")
        || text.equals(")");
  }

  private int getBracketType(String bracket) {
    switch (bracket) {
      case "{":
        return 1;
      case "}":
        return 2;
      case "[":
        return 3;
      case "]":
        return 4;
      case "(":
        return 5;
      case ")":
        return 6;
      default:
        return 0;
    }
  }
}
