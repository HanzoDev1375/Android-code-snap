package ir.ninjacoder.codesnap.Utils;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import ir.ninjacoder.codesnap.LangType;
import ir.ninjacoder.codesnap.colorhelper.ColorHelper;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeHighlighterMarkdown implements Highlighter {

  private static final HighlightRule[] RULES = {
    new HighlightRule(Pattern.compile("<!--[\\s\\S]*?-->"), 7), // HTML Comments
    new HighlightRule(Pattern.compile("</?[a-zA-Z][^>]*>"), 8), // HTML tags
    new HighlightRule(Pattern.compile("`{3}[\\s\\S]*?`{3}"), 3), // Code blocks
    new HighlightRule(Pattern.compile("!?\\[.*?\\]\\(.*?\\)"), 4), // Links
    new HighlightRule(Pattern.compile("^#{1,6}\\s+.*$", Pattern.MULTILINE), 1), // Headers
    new HighlightRule(
        Pattern.compile("\\*\\*\\*.*?\\*\\*\\*|\\*\\*.*?\\*\\*|\\*.*?\\*"), 2), // Bold/Italic
    new HighlightRule(Pattern.compile("`[^`]*`"), 3), // Inline code
    new HighlightRule(Pattern.compile("^\\s*[-*+]\\s+.*$", Pattern.MULTILINE), 5), // List bullets
    new HighlightRule(Pattern.compile("^\\s*\\d+\\.\\s+.*$", Pattern.MULTILINE), 5), // Numbered lists
    new HighlightRule(Pattern.compile("\\[[ x]\\]"), 6), // Checkboxes
    new HighlightRule(Pattern.compile("---"), 9) // Horizontal rules
  };

  @Override
  public SpannableStringBuilder highlight(LangType types, String code, ColorHelper color) {
    SpannableStringBuilder builder = new SpannableStringBuilder(code);

    for (HighlightRule rule : RULES) {
      Matcher matcher = rule.pattern.matcher(code);
      while (matcher.find()) {
        int ruleColor = getColorForRule(rule.type, color);
        builder.setSpan(
            new ForegroundColorSpan(ruleColor),
            matcher.start(),
            matcher.end(),
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
      }
    }

    return builder;
  }

  private int getColorForRule(int type, ColorHelper color) {
    switch (type) {
      case 1:
        return color.getSymbol(); // Headers
      case 2:
        return color.getOperator(); // Bold/Italic
      case 3:
        return color.getComment(); // Code
      case 4:
        return color.getSymbol(); // Links
      case 5:
        return color.getCsskeyword(); // Lists
      case 6:
        return color.getOperator(); // Checkboxes
      case 7:
        return color.getComment(); // HTML Comments
      case 8:
        return color.getHtmlkeyword(); // HTML tags
      case 9:
        return color.getLastsymi(); // Horizontal rules
      default:
        return color.getTextnormal();
    }
  }

  static class HighlightRule {
    Pattern pattern;
    int type;

    HighlightRule(Pattern pattern, int type) {
      this.pattern = pattern;
      this.type = type;
    }
  }
}