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
    // اول HTML tags چون پیچیده‌تره
    new HighlightRule(Pattern.compile("</?[a-zA-Z][^>]*>"), 8), // HTML tags
    new HighlightRule(Pattern.compile("`{3}[\\s\\S]*?`{3}"), 3), // Code blocks
    new HighlightRule(Pattern.compile("!?\\[.*?\\]\\(.*?\\)"), 4), // Links - ساده‌شده
    new HighlightRule(Pattern.compile("^#{1,6}\\s+.*$", Pattern.MULTILINE), 1), // Headers
    new HighlightRule(
        Pattern.compile("\\*\\*\\*.*?\\*\\*\\*|\\*\\*.*?\\*\\*|\\*.*?\\*"), 2), // Bold/Italic
    new HighlightRule(Pattern.compile("`[^`]*`"), 3), // Inline code
    new HighlightRule(Pattern.compile("^\\s*[-*+]\\s+"), 5), // List bullets
    new HighlightRule(Pattern.compile("^\\s*\\d+\\.\\s+"), 5), // Numbered lists
    new HighlightRule(Pattern.compile("\\[[ x]\\]"), 6), 
    // الگوی جدید برای خط تیره‌های عمومی
    new HighlightRule(Pattern.compile("-"), 9) // همه خط تیره‌ها
  };

  @Override
  public SpannableStringBuilder highlight(LangType types, String code, ColorHelper color) {
    SpannableStringBuilder builder = new SpannableStringBuilder(code);

    for (HighlightRule rule : RULES) {
      Matcher matcher = rule.pattern.matcher(code);
      while (matcher.find()) {
        int ruleColor = getColorForRule(rule.type, color);
        
        // برای الگوی شماره 9 (خط تیره) فقط در موارد خاص رنگی شود
        if (rule.type == 9) {
          int position = matcher.start();
          String matchedText = matcher.group();
          
          // فقط اگر خط تیره باشد و در موقعیت مناسب باشد
          if ("-".equals(matchedText)) {
            // بررسی کن که این خط تیره بخشی از یک الگوی دیگر نباشد
            if (!isPartOfOtherPattern(code, position)) {
              builder.setSpan(
                  new ForegroundColorSpan(ruleColor),
                  position,
                  position + 1,
                  Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
          }
        } else {
          builder.setSpan(
              new ForegroundColorSpan(ruleColor),
              matcher.start(),
              matcher.end(),
              Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
      }
    }

    return builder;
  }

  // بررسی می‌کند که آیا کاراکتر در موقعیت داده شده بخشی از الگوی دیگر است یا نه
  private boolean isPartOfOtherPattern(String code, int position) {
    // اگر خط تیره بخشی از این الگوها باشد، آن را رنگی نکن
    String surroundingText = getSurroundingText(code, position, 10);
    
    // بررسی برای الگوهای دیگر
    if (surroundingText.matches(".*\\[.*\\].*")) return true; // بخشی از لینک
    if (surroundingText.matches(".*`.*`.*")) return true; // بخشی از کد
    if (surroundingText.matches(".*\\*.*\\*.*")) return true; // بخشی از bold/italic
    if (surroundingText.matches(".*<!--.*-->.*")) return true; // بخشی از کامنت HTML
    
    return false;
  }

  private String getSurroundingText(String text, int position, int contextLength) {
    int start = Math.max(0, position - contextLength);
    int end = Math.min(text.length(), position + contextLength + 1);
    return text.substring(start, end);
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
      case 8:
        return color.getHtmlkeyword(); // HTML tags
      case 9:
        return color.getLastsymi(); // خط تیره
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