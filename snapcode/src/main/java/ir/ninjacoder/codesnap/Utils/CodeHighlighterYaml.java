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

public class CodeHighlighterYaml implements Highlighter {

  private static final Pattern YAML_PATTERN =
      Pattern.compile(
          // Comments
          "(#.*$)"
              + "|"
              +
              // Strings (quoted)
              "(\"(?:\\\\.|[^\\\\\"])*\"|'(?:\\\\.|[^\\\\'])*')"
              + "|"
              +
              // Booleans and null
              "(\\b(?:true|false|yes|no|on|off|null)\\b)"
              + "|"
              +
              // Numbers
              "(-?\\b(?:\\d+(?:\\.\\d*)?(?:[eE][+-]?\\d+)?|\\.\\d+(?:[eE][+-]?\\d+)?)\\b)"
              + "|"
              +
              // Keys (before colon)
              "(\\b\\w+(?=\\s*:))"
              + "|"
              +
              // Operators and punctuation
              "([\\{\\}\\[\\],:>-])"
              + "|"
              +
              // Whitespace
              "(\\s+)");

  private static final Pattern COLOR_PATTERN =
      Pattern.compile("#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})", Pattern.CASE_INSENSITIVE);

  @Override
  public SpannableStringBuilder highlight(LangType types, String code, ColorHelper color)
      throws Exception {
    SpanStyler span = SpanStyler.create();
    BracketManager manager = new BracketManager();
    List<BracketPosition> bracketPositions = new ArrayList<>();
    int currentPosition = 0;

    // Split by lines to handle YAML structure better
    String[] lines = code.split("\n", -1);
    int lineStartPosition = 0;

    for (String line : lines) {
      if (line.isEmpty()) {
        span.addNullText("\n");
        lineStartPosition++;
        continue;
      }

      Matcher matcher = YAML_PATTERN.matcher(line);
      int lastIndex = 0;
      boolean inList = line.trim().startsWith("-");

      while (matcher.find()) {
        if (matcher.start() > lastIndex) {
          span.addNullText(line.substring(lastIndex, matcher.start()));
          currentPosition += (matcher.start() - lastIndex);
        }

        String matched = matcher.group();
        int absolutePosition = lineStartPosition + matcher.start();

        // Handle brackets
        if (matcher.group(6) != null && isBracket(matched)) {
          bracketPositions.add(
              new BracketPosition(
                  absolutePosition,
                  absolutePosition + matched.length(),
                  matched.charAt(0),
                  getBracketType(matched)));
        }

        if (matcher.group(1) != null) {
          // Comments
          span.text(matched, color.getComment());
        } else if (matcher.group(2) != null) {
          // Strings - check if it's a color
          if (isColorValue(matched)) {
            applyColorBackground(span, matched, absolutePosition);
          } else {
            span.text(matched, color.getStrings());
          }
        } else if (matcher.group(3) != null) {
          // Booleans and null
          span.text(matched, color.getKeyword());
        } else if (matcher.group(4) != null) {
          // Numbers
          span.text(matched, color.getOperator());
        } else if (matcher.group(5) != null) {
          // Keys
          span.text(matched, color.getKeyword());
        } else if (matcher.group(6) != null) {
          // Operators and punctuation
          span.text(matched, color.getOperator());
        } else if (matcher.group(7) != null) {
          // Whitespace
          span.addNullText(matched);
        }

        currentPosition += matched.length();
        lastIndex = matcher.end();
      }

      if (lastIndex < line.length()) {
        span.addNullText(line.substring(lastIndex));
      }

      span.addNullText("\n");
      lineStartPosition += line.length() + 1; // +1 for newline
      currentPosition = lineStartPosition;
    }

    // Remove last newline if it was added
    SpannableStringBuilder ssb = span;
    if (ssb.length() > 0 && ssb.charAt(ssb.length() - 1) == '\n') {
      ssb.delete(ssb.length() - 1, ssb.length());
    }

    manager.setRainbowBracketsEnabled(true);
    if (!bracketPositions.isEmpty()) {
      manager.applyRainbowBrackets(span, bracketPositions);
    }

    return span;
  }

  private boolean isColorValue(String text) {
    if (text == null || text.length() < 3) return false;
    // Remove quotes from string
    String cleanText = text.replaceAll("^['\"]|['\"]$", "").trim();
    return COLOR_PATTERN.matcher(cleanText).matches();
  }

  private void applyColorBackground(SpanStyler span, String colorText, int position) {
    try {
      // Remove quotes
      String cleanColor = colorText.replaceAll("^['\"]|['\"]$", "");
      int backgroundColor = Color.parseColor(cleanColor);

      // Choose appropriate text color
      int textColor = isColorLight(backgroundColor) ? Color.BLACK : Color.WHITE;

      // Add text with color
      span.text(colorText, textColor);

      // Apply background color
      SpannableStringBuilder ssb = span;
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
