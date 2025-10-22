package ir.ninjacoder.codesnap.Utils;

import android.text.SpannableStringBuilder;
import android.graphics.Color;
import android.text.style.BackgroundColorSpan;
import ir.ninjacoder.codesnap.LangType;
import ir.ninjacoder.codesnap.bracket.BracketManager;
import ir.ninjacoder.codesnap.bracket.BracketPosition;
import ir.ninjacoder.codesnap.colorhelper.ColorHelper;
import ir.ninjacoder.codesnap.widget.data.SpanStyler;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

public class CodeHighlighterJson implements Highlighter {

  private static final Pattern JSON_PATTERN =
      Pattern.compile(
          "(\"(?:\\\\.|[^\\\\\"])*\")"
              + // همه رشته‌ها
              "|(\\b(?:true|false|null)\\b)"
              + // boolean و null
              "|(-?\\b(?:0x[\\dA-Fa-f]+|\\d+(?:\\.\\d*)?(?:[eE][+-]?\\d+)?)\\b)"
              + // اعداد
              "|([\\{\\}\\[\\],:])"
              + // عملگرها و براکت‌ها
              "|(\\s+)" // فضاهای خالی
          );

  private static final Pattern COLOR_PATTERN =
      Pattern.compile("#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3,8})", Pattern.CASE_INSENSITIVE);

  @Override
  public SpannableStringBuilder highlight(LangType types, String code, ColorHelper color)
      throws Exception {
    SpanStyler span = SpanStyler.create();
    BracketManager manager = new BracketManager();
    List<BracketPosition> bracketPositions = new ArrayList<>();
    int currentPosition = 0;
    boolean nextStringIsValue = false;

    Matcher matcher = JSON_PATTERN.matcher(code);
    int lastIndex = 0;

    while (matcher.find()) {
      if (matcher.start() > lastIndex) {
        span.addNullText(code.substring(lastIndex, matcher.start()));
        currentPosition += (matcher.start() - lastIndex);
      }

      String matched = matcher.group();

      if (matcher.group(4) != null && isBracket(matched)) {
        bracketPositions.add(
            new BracketPosition(
                currentPosition,
                currentPosition + matched.length(),
                matched.charAt(0),
                getBracketType(matched)));
      }

      if (matcher.group(1) != null) {
        if (nextStringIsValue) {
          // اگر رنگ هست، بک‌گراند رنگی اعمال کن
          if (isColorValue(matched)) {
            applyColorBackground(span, matched, currentPosition);
          } else {
            span.text(matched, color.getStrings());
          }
          nextStringIsValue = false;
        } else {
          span.text(matched, color.getKeyword());
        }
      } else if (matcher.group(2) != null) {
        span.text(matched, color.getKeyword());
        nextStringIsValue = false;
      } else if (matcher.group(3) != null) {
        span.text(matched, color.getOperator());
        nextStringIsValue = false;
      } else if (matcher.group(4) != null) {
        span.text(matched, color.getOperator());
        if (matched.equals(":")) {
          nextStringIsValue = true;
        } else {
          nextStringIsValue = false;
        }
      } else if (matcher.group(5) != null) {
        span.addNullText(matched);
      }

      currentPosition += matched.length();
      lastIndex = matcher.end();
    }

    if (lastIndex < code.length()) {
      span.addNullText(code.substring(lastIndex));
    }

    manager.setRainbowBracketsEnabled(true);
    if (!bracketPositions.isEmpty()) {
      manager.applyRainbowBrackets(span, bracketPositions);
    }

    return span;
  }

  private boolean isColorValue(String text) {
    if (text == null || text.length() < 3) return false;
    String cleanText = text.replace("\"", "").trim();
    return COLOR_PATTERN.matcher(cleanText).matches();
  }

  private void applyColorBackground(SpanStyler span, String colorText, int position) {
    try {
      String cleanColor = colorText.replace("\"", "");
      int backgroundColor = Color.parseColor(cleanColor);

      // تشخیص رنگ متن مناسب
      int textColor = isColorLight(backgroundColor) ? Color.BLACK : Color.WHITE;

      // اول متن رو با رنگ مناسب اضافه کن
      span.text(colorText, textColor);

      // سپس بک‌گراند رو اعمال کن
      var ssb = span;
      if (ssb != null) {
        int start = ssb.length() - colorText.length();
        int end = ssb.length();
        ssb.setSpan(
            new BackgroundColorSpan(backgroundColor),
            start,
            end,
            SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
      }

    } catch (IllegalArgumentException e) {
      span.text(colorText, Color.WHITE);
    }
  }

  private boolean isColorLight(int color) {
    int red = Color.red(color);
    int green = Color.green(color);
    int blue = Color.blue(color);
    double brightness = (red * 0.299 + green * 0.587 + blue * 0.114);
    return brightness > 128;
  }

  private boolean isBracket(String text) {
    return text.equals("{") || text.equals("}") || text.equals("[") || text.equals("]");
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
      default:
        return 0;
    }
  }
}
