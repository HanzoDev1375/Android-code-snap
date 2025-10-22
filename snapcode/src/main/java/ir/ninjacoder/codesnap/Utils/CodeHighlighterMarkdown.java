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

public class CodeHighlighterMarkdown implements Highlighter {
  private ColorHelper colors;
  private static final Pattern BLOCK_PATTERN =
      Pattern.compile(
          "^(?: {4}|\\t).+$|"
              + // Indented code blocks
              "^(?:```).*$|"
              + // Code fences
              "^(?:>\\s*)+.*$|"
              + // Blockquotes
              "^(?:\\s*)(?:[*+-]|\\d+\\.)(?=\\s).*$|"
              + // Lists
              "^(?:\\s*)([*-])(?:\\s*\\1){2,}(?=\\s*$)|"
              + // Horizontal rules
              "^(?:\\s*)#+.+$|"
              + // Headers with #
              "^(?:\\w+.*)(?:\\r?\\n|\\r)(?:=+|-+)$", // Headers with === or ---
          Pattern.MULTILINE);

  private static final Pattern INLINE_PATTERN =
      Pattern.compile(
          // Bold and italic (from Prism4j)
          "(^|[^\\\\])(\\*\\*|__)(?:(?:\\r?\\n|\\r)(?!\\r?\\n|\\r)|.)+?\\2|"
              + // bold
              "(^|[^\\\\])([*_])(?:(?:\\r?\\n|\\r)(?!\\r?\\n|\\r)|.)+?\\3|"
              + // italic
              // URLs and links (from Prism4j)
              "!?\\[[^\\]]+\\](?:\\([^\\s)]+(?:[\\t ]+\"(?:\\\\.|[^\"\\\\])*\")?\\)| ?\\[[^\\]\\n]*\\])|"
              +
              // Inline code
              "``.+?``|`[^`\\n]+`|"
              +
              // Strikethrough
              "~~[^~]+~~",
          Pattern.MULTILINE);

  @Override
  public SpannableStringBuilder highlight(LangType types, String code, ColorHelper color)
      throws Exception {
    SpanStyler span = SpanStyler.create();
    BracketManager manager = new BracketManager();
    List<BracketPosition> bracketPositions = new ArrayList<>();
    colors = color;
    String[] lines = code.split("\n", -1);

    for (int i = 0; i < lines.length; i++) {
      String line = lines[i];

      if (line.isEmpty()) {
        if (i < lines.length - 1) {
          span.addNullText("\n");
        }
        continue;
      }

      // پردازش خط به خط
      processLine(span, line, color, i, lines);

      // newline برای خطوط به جز آخرین خط
      if (i < lines.length - 1) {
        span.addNullText("\n");
      }
    }

    return span;
  }

  private void processLine(
      SpanStyler span, String line, ColorHelper color, int lineIndex, String[] lines) {
    // ابتدا بررسی می‌کنیم آیا این خط بخشی از یک code block است
    if (isInCodeBlock(span, line, lineIndex, lines)) {
      span.text(line, color.getStrings());
      return;
    }

    // پردازش عناصر بلوکی
    boolean processed = processBlockElements(span, line, color, lineIndex, lines);

    if (!processed) {
      // اگر عنصر بلوکی نبود، عناصر درون‌خطی را پردازش کن
      processInlineElements(span, line, color);
    }
  }

  private boolean isInCodeBlock(SpanStyler span, String line, int lineIndex, String[] lines) {
    // منطق ساده برای تشخیص code blocks
    String trimmed = line.trim();

    if (trimmed.startsWith("```")) {
      // شروع یا پایان code block
      span.text(line, colors.getKeyword());
      return true;
    }

    // اگر خط قبلی با ``` شروع شده و این خط هنوز داخل code block است
    if (lineIndex > 0) {
      String prevLine = lines[lineIndex - 1].trim();
      if (prevLine.startsWith("```") && !prevLine.matches("^```\\s*$")) {
        return true;
      }
    }

    return false;
  }

  private boolean processBlockElements(
      SpanStyler span, String line, ColorHelper color, int lineIndex, String[] lines) {
    // Headers with #
    if (line.matches("^\\s*#+\\s+.*")) {
      processHeader(span, line, color);
      return true;
    }

    // Headers with === or ---
    if (lineIndex > 0 && line.matches("^=+$|^-+$")) {
      String prevLine = lines[lineIndex - 1];
      if (!prevLine.trim().isEmpty()) {
        span.text(line, color.getKeyword());
        return true;
      }
    }

    // Blockquotes
    if (line.matches("^>\\s+.*")) {
      processBlockquote(span, line, color);
      return true;
    }

    // Lists
    if (line.matches("^\\s*[*+-]\\s+.*") || line.matches("^\\s*\\d+\\.\\s+.*")) {
      processList(span, line, color);
      return true;
    }

    // Horizontal rules
    if (line.matches("^\\s*([*-])(\\s*\\1){2,}\\s*$")) {
      span.text(line, color.getComment());
      return true;
    }

    // Code blocks (indented)
    if (line.matches("^(?: {4}|\\t).+")) {
      span.text(line, color.getStrings());
      return true;
    }

    // Tables
    if (line.matches("^\\|.*\\|$")) {
      processTable(span, line, color);
      return true;
    }

    return false;
  }

  private void processHeader(SpanStyler span, String line, ColorHelper color) {
    Matcher matcher = Pattern.compile("^(\\s*)(#+)(\\s+)(.*)$").matcher(line);
    if (matcher.find()) {
      span.addNullText(matcher.group(1)); // فاصله‌های اول
      span.text(matcher.group(2), color.getKeyword()); // ###
      span.text(matcher.group(3), color.getTextnormal()); // فاصله
      processInlineContent(span, matcher.group(4), color); // متن هدر
    } else {
      span.addNullText(line);
    }
  }

  private void processBlockquote(SpanStyler span, String line, ColorHelper color) {
    Matcher matcher = Pattern.compile("^(>+)(\\s*)(.*)$").matcher(line);
    if (matcher.find()) {
      span.text(matcher.group(1), color.getComment()); // >
      span.text(matcher.group(2), color.getTextnormal()); // فاصله
      processInlineContent(span, matcher.group(3), color); // متن
    } else {
      span.addNullText(line);
    }
  }

  private void processList(SpanStyler span, String line, ColorHelper color) {
    Matcher matcher = Pattern.compile("^(\\s*)([*+-]|\\d+\\.)(\\s+)(.*)$").matcher(line);
    if (matcher.find()) {
      span.addNullText(matcher.group(1)); // فاصله
      span.text(matcher.group(2), color.getKeyword()); // * یا 1.
      span.text(matcher.group(3), color.getTextnormal()); // فاصله
      processInlineContent(span, matcher.group(4), color); // متن لیست
    } else {
      span.addNullText(line);
    }
  }

  private void processTable(SpanStyler span, String line, ColorHelper color) {
    String[] cells = line.split("\\|", -1);

    for (int i = 0; i < cells.length; i++) {
      if (i > 0) {
        span.text("|", color.getKeyword());
      }

      String cell = cells[i].trim();
      if (cell.matches(":?-+:?")) {
        // Separator line
        span.text(cell, color.getComment());
      } else if (!cell.isEmpty()) {
        // Regular cell content
        processInlineContent(span, cell, color);
      }
    }
  }

  private void processInlineElements(SpanStyler span, String line, ColorHelper color) {
    processInlineContent(span, line, color);
  }

  private void processInlineContent(SpanStyler span, String text, ColorHelper color) {
    if (text.isEmpty()) {
      return;
    }

    Matcher matcher = INLINE_PATTERN.matcher(text);
    int lastIndex = 0;

    while (matcher.find()) {
      // متن بین matchها
      if (matcher.start() > lastIndex) {
        String betweenText = text.substring(lastIndex, matcher.start());
        span.addNullText(betweenText);
      }

      String matched = matcher.group();

      // تشخیص نوع عنصر
      if (matched.matches("(^|[^\\\\])(\\*\\*|__).+?\\2")) {
        // Bold
        processBold(span, matched, color);
      } else if (matched.matches("(^|[^\\\\])([*_]).+?\\3")) {
        // Italic
        processItalic(span, matched, color);
      } else if (matched.matches("!?\\[[^\\]]+\\].*")) {
        // Link or Image
        processLinkOrImage(span, matched, color);
      } else if (matched.matches("``.+?``|`[^`\\n]+`")) {
        // Inline code
        processInlineCode(span, matched, color);
      } else if (matched.matches("~~[^~]+~~")) {
        // Strikethrough
        processStrikethrough(span, matched, color);
      } else {
        span.addNullText(matched);
      }

      lastIndex = matcher.end();
    }

    // متن باقی‌مانده
    if (lastIndex < text.length()) {
      span.addNullText(text.substring(lastIndex));
    }
  }

  private void processBold(SpanStyler span, String text, ColorHelper color) {
    // منطق از Prism4j: (^|[^\\\\])(\\*\\*|__)(?:(?:\\r?\\n|\\r)(?!\\r?\\n|\\r)|.)+?\\2
    Matcher matcher = Pattern.compile("(^|[^\\\\])(\\*\\*|__)(.+?)\\2").matcher(text);
    if (matcher.find()) {
      String prefix = matcher.group(1);
      String delimiter = matcher.group(2);
      String content = matcher.group(3);

      span.addNullText(prefix);
      span.text(delimiter, color.getKeyword());
      processInlineContent(span, content, color);
      span.text(delimiter, color.getKeyword());
    } else {
      span.addNullText(text);
    }
  }

  private void processItalic(SpanStyler span, String text, ColorHelper color) {
    // منطق از Prism4j: (^|[^\\\\])([*_])(?:(?:\\r?\\n|\\r)(?!\\r?\\n|\\r)|.)+?\\3
    Matcher matcher = Pattern.compile("(^|[^\\\\])([*_])(.+?)\\2").matcher(text);
    if (matcher.find()) {
      String prefix = matcher.group(1);
      String delimiter = matcher.group(2);
      String content = matcher.group(3);

      span.addNullText(prefix);
      span.text(delimiter, color.getKeyword());
      processInlineContent(span, content, color);
      span.text(delimiter, color.getKeyword());
    } else {
      span.addNullText(text);
    }
  }

  private void processLinkOrImage(SpanStyler span, String text, ColorHelper color) {
    // منطق از Prism4j: !?\\[[^\\]]+\\](?:\\([^\\s)]+(?:[\\t ]+"(?:\\\\.|[^\"\\\\])*")?\\)|
    // ?\\[[^\\]\\n]*\\])
    if (text.startsWith("!")) {
      // Image
      processImage(span, text, color);
    } else {
      // Link
      processLink(span, text, color);
    }
  }

  private void processLink(SpanStyler span, String text, ColorHelper color) {
    // الگوی ساده‌تر برای لینک‌ها
    Pattern linkPattern = Pattern.compile("\\[(.*?)\\]\\((.*?)\\)");
    Matcher linkMatcher = linkPattern.matcher(text);

    if (linkMatcher.find()) {
      String linkText = linkMatcher.group(1);
      String url = linkMatcher.group(2);

      span.text("[", color.getKeyword());
      processInlineContent(span, linkText, color);
      span.text("](", color.getKeyword());
      span.text(url, color.getMethod());
      span.text(")", color.getKeyword());
    } else {
      span.addNullText(text);
    }
  }

  private void processImage(SpanStyler span, String text, ColorHelper color) {
    Pattern imgPattern = Pattern.compile("!\\[(.*?)\\]\\((.*?)\\)");
    Matcher imgMatcher = imgPattern.matcher(text);

    if (imgMatcher.find()) {
      String altText = imgMatcher.group(1);
      String url = imgMatcher.group(2);

      span.text("!", color.getKeyword());
      span.text("[", color.getKeyword());
      span.text(altText, color.getComment());
      span.text("]", color.getKeyword());
      span.text("(", color.getKeyword());
      span.text(url, color.getMethod());
      span.text(")", color.getKeyword());
    } else {
      span.addNullText(text);
    }
  }

  private void processInlineCode(SpanStyler span, String text, ColorHelper color) {
    if (text.startsWith("``") && text.endsWith("``")) {
      // Double backtick code
      span.text("``", color.getKeyword());
      span.text(text.substring(2, text.length() - 2), color.getStrings());
      span.text("``", color.getKeyword());
    } else if (text.startsWith("`") && text.endsWith("`")) {
      // Single backtick code
      span.text("`", color.getKeyword());
      span.text(text.substring(1, text.length() - 1), color.getStrings());
      span.text("`", color.getKeyword());
    } else {
      span.addNullText(text);
    }
  }

  private void processStrikethrough(SpanStyler span, String text, ColorHelper color) {
    if (text.startsWith("~~") && text.endsWith("~~")) {
      span.text("~~", color.getKeyword());
      span.text(text.substring(2, text.length() - 2), color.getComment());
      span.text("~~", color.getKeyword());
    } else {
      span.addNullText(text);
    }
  }
}
