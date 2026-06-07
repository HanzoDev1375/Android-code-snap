package ir.ninjacoder.code.markwon;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.LeadingMarginSpan;
import android.text.style.MetricAffectingSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import android.util.Base64;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleMarkdownRenderer {
  private static final int SPAN_MODE = Spanned.SPAN_EXCLUSIVE_EXCLUSIVE;
  private static final Pattern UNORDERED_PATTERN = Pattern.compile("^[\\*\\-+]\\s+.+");
  private static final Pattern ORDERED_PATTERN = Pattern.compile("^(\\d+)\\.\\s+.+");
  private static final Pattern MARKER_PATTERN = Pattern.compile("^(?:\\d+\\.|[\\*\\-+])\\s+");
  private static final Pattern BR_REGEX = Pattern.compile("(?i)<br\\s*/?>");
  private static final Pattern HEADING_REGEX = Pattern.compile("(?is)<h([1-6])[^>]*>(.*?)</h\\1>");
  private static final Pattern BLOCKQUOTE_REGEX =
      Pattern.compile("(?is)<blockquote[^>]*>(.*?)</blockquote>");
  private static final Pattern STRONG_REGEX = Pattern.compile("(?is)<strong[^>]*>(.*?)</strong>");
  private static final Pattern EM_REGEX = Pattern.compile("(?is)<em[^>]*>(.*?)</em>");
  private static final Pattern CODE_REGEX = Pattern.compile("(?is)<code[^>]*>(.*?)</code>");
  private static final Pattern PRE_REGEX = Pattern.compile("(?is)<pre[^>]*>(.*?)</pre>");
  private static final Pattern LI_REGEX = Pattern.compile("(?is)<li[^>]*>(.*?)</li>");
  private static final Pattern LINK_REGEX =
      Pattern.compile("(?is)<a[^>]+href\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>(.*?)</a>");
  private static final Pattern MARKDOWN_LINK_REGEX =
      Pattern.compile("(?i)\\[([^\\]]*)\\]\\(([^\\)]*)\\)");
  private static final Pattern AUTO_LINK_REGEX = Pattern.compile("(?i)<([^>]+)>");
  private static final Pattern URL_REGEX =
      Pattern.compile(
          "(?i)https?:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&/=]*)");
  private static final Pattern UL_REGEX = Pattern.compile("(?is)</?ul[^>]*>");
  private static final Pattern OL_REGEX = Pattern.compile("(?is)</?ol[^>]*>");
  private static final Pattern P_OPEN_REGEX = Pattern.compile("(?is)<p[^>]*>");
  private static final Pattern P_CLOSE_REGEX = Pattern.compile("(?is)</p>");
  private static final Pattern MULTI_NEWLINE_REGEX = Pattern.compile("\n{3,}");
  public static final int MAX_IMAGE_WIDTH = 800;
  private static final int LEADING_MARGIN = 24;
  private static final int INDENT_MARGIN = 24;
  private static final String LINE_SEPARATOR = "──────────";
  private static final Set<Character> ESCAPE_CHARACTERS = new HashSet<>();

  static {
    for (char c : "\\`*_{}[]()#+-.!<>|:".toCharArray()) {
      ESCAPE_CHARACTERS.add(c);
    }
  }

  private static final float[] DEFAULT_HEADING_SCALE =
      new float[] {1.6f, 1.4f, 1.25f, 1.1f, 1.05f, 1.0f};
  public static ImageProvider globalImageProvider = new DefaultImageProvider(MAX_IMAGE_WIDTH);

  public static Spanned render(
      String markdown,
      int boldColor,
      int inlineCodeColor,
      Typeface codeTypeface,
      Integer linkColor,
      float[] headingScale,
      MarkdownCodeHighlighterRegistry highlighterRegistry) {
    String normalized = normalize(markdown);
    List<Block> blocks = parseBlocks(normalized);
    return build(
        blocks,
        boldColor,
        inlineCodeColor,
        codeTypeface,
        linkColor,
        headingScale,
        highlighterRegistry);
  }

  public static Spanned render(
      String markdown, int boldColor, int inlineCodeColor, Typeface codeTypeface) {
    return render(
        markdown,
        boldColor,
        inlineCodeColor,
        codeTypeface,
        null,
        DEFAULT_HEADING_SCALE,
        MarkdownCodeHighlighterRegistry.global);
  }

  public static SpannableStringBuilder renderAsync(
      String markdown,
      int boldColor,
      int inlineCodeColor,
      Typeface codeTypeface,
      Integer linkColor,
      float[] headingScale,
      MarkdownCodeHighlighterRegistry highlighterRegistry) {
    String normalized = normalize(markdown);
    List<Block> blocks = parseBlocks(normalized);
    return buildAsync(
        blocks,
        boldColor,
        inlineCodeColor,
        codeTypeface,
        linkColor,
        headingScale,
        highlighterRegistry);
  }

  public static SpannableStringBuilder renderAsync(
      String markdown, int boldColor, int inlineCodeColor, Typeface codeTypeface) {
    return renderAsync(
        markdown,
        boldColor,
        inlineCodeColor,
        codeTypeface,
        null,
        DEFAULT_HEADING_SCALE,
        MarkdownCodeHighlighterRegistry.global);
  }

  private static SpannableStringBuilder build(
      List<Block> blocks,
      int boldColor,
      int inlineCodeColor,
      Typeface codeTypeface,
      Integer linkColor,
      float[] headingScale,
      MarkdownCodeHighlighterRegistry highlighterRegistry) {
    SpannableStringBuilder builder = new SpannableStringBuilder();
    boolean firstBlock = true;
    for (Block block : blocks) {
      if (builder.length() > 0) {
        if (!firstBlock) {
          builder.append("\n\n");
        }
      }
      if (block instanceof Block.Heading) {
        Block.Heading heading = (Block.Heading) block;
        int start = builder.length();
        appendInlines(
            builder, heading.inlines, boldColor, inlineCodeColor, codeTypeface, linkColor);
        int end = builder.length();
        builder.setSpan(new StyleSpan(Typeface.BOLD), start, end, SPAN_MODE);
        int scaleIndex = Math.min(Math.max(heading.level - 1, 0), headingScale.length - 1);
        builder.setSpan(new RelativeSizeSpan(headingScale[scaleIndex]), start, end, SPAN_MODE);
      } else if (block instanceof Block.Paragraph) {
        Block.Paragraph paragraph = (Block.Paragraph) block;
        appendInlines(
            builder, paragraph.inlines, boldColor, inlineCodeColor, codeTypeface, linkColor);
      } else if (block instanceof Block.CodeBlock) {
        Block.CodeBlock codeBlock = (Block.CodeBlock) block;
        int start = builder.length();
        MarkdownCodeHighlighterRegistry.HighlightResult result =
            highlighterRegistry.highlight(codeBlock.content, codeBlock.language, codeTypeface);
        builder.append(result.getContent());
        int end = builder.length();
        if (end > start) {
          builder.setSpan(new TypefaceSpanCompat(codeTypeface), start, end, SPAN_MODE);
        }
      } else if (block instanceof Block.ListBlock) {
        Block.ListBlock listBlock = (Block.ListBlock) block;
        int number = listBlock.startIndex;
        for (List<Inline> item : listBlock.items) {
          if (builder.length() > 0 && builder.charAt(builder.length() - 1) != '\n') {
            builder.append('\n');
          }
          int prefixStart = builder.length();
          String label;
          if (listBlock.ordered) {
            label = String.format(Locale.getDefault(), "%d. ", number);
            number++;
          } else {
            label = "• ";
          }
          builder.append(label);
          int prefixEnd = builder.length();
          appendInlines(builder, item, boldColor, inlineCodeColor, codeTypeface, linkColor);
          int itemEnd = builder.length();
          builder.setSpan(
              new LeadingMarginSpan.Standard(LEADING_MARGIN, LEADING_MARGIN + INDENT_MARGIN),
              prefixStart,
              itemEnd,
              SPAN_MODE);
          if (!listBlock.ordered) {
            builder.setSpan(new StyleSpan(Typeface.BOLD), prefixStart, prefixEnd, SPAN_MODE);
          }
        }
      } else if (block instanceof Block.Quote) {
        Block.Quote quote = (Block.Quote) block;
        int start = builder.length();
        builder.append('│');
        builder.append(' ');
        int contentStart = builder.length();
        appendInlines(builder, quote.inlines, boldColor, inlineCodeColor, codeTypeface, linkColor);
        int end = builder.length();
        builder.setSpan(new StyleSpan(Typeface.ITALIC), contentStart, end, SPAN_MODE);
        builder.setSpan(
            new LeadingMarginSpan.Standard(LEADING_MARGIN, LEADING_MARGIN + INDENT_MARGIN),
            start,
            end,
            SPAN_MODE);
      } else if (block instanceof Block.HorizontalRule) {
        builder.append(LINE_SEPARATOR);
      }
      firstBlock = false;
    }
    return builder;
  }

  private static SpannableStringBuilder buildAsync(
      List<Block> blocks,
      int boldColor,
      int inlineCodeColor,
      Typeface codeTypeface,
      Integer linkColor,
      float[] headingScale,
      MarkdownCodeHighlighterRegistry highlighterRegistry) {
    SpannableStringBuilder builder = new SpannableStringBuilder();
    boolean firstBlock = true;
    for (Block block : blocks) {
      if (builder.length() > 0) {
        if (!firstBlock) {
          builder.append("\n\n");
        }
      }
      if (block instanceof Block.Heading) {
        Block.Heading heading = (Block.Heading) block;
        int start = builder.length();
        appendInlines(
            builder, heading.inlines, boldColor, inlineCodeColor, codeTypeface, linkColor);
        int end = builder.length();
        builder.setSpan(new StyleSpan(Typeface.BOLD), start, end, SPAN_MODE);
        int scaleIndex = Math.min(Math.max(heading.level - 1, 0), headingScale.length - 1);
        builder.setSpan(new RelativeSizeSpan(headingScale[scaleIndex]), start, end, SPAN_MODE);
      } else if (block instanceof Block.Paragraph) {
        Block.Paragraph paragraph = (Block.Paragraph) block;
        appendInlines(
            builder, paragraph.inlines, boldColor, inlineCodeColor, codeTypeface, linkColor);
      } else if (block instanceof Block.CodeBlock) {
        Block.CodeBlock codeBlock = (Block.CodeBlock) block;
        int start = builder.length();
        CharSequence highlighted =
            highlighterRegistry.highlightAsync(codeBlock.content, codeBlock.language, codeTypeface);
        builder.append(highlighted);
        int end = builder.length();
        if (end > start) {
          builder.setSpan(new TypefaceSpanCompat(codeTypeface), start, end, SPAN_MODE);
        }
      } else if (block instanceof Block.ListBlock) {
        Block.ListBlock listBlock = (Block.ListBlock) block;
        int number = listBlock.startIndex;
        for (List<Inline> item : listBlock.items) {
          if (builder.length() > 0 && builder.charAt(builder.length() - 1) != '\n') {
            builder.append('\n');
          }
          int prefixStart = builder.length();
          String label;
          if (listBlock.ordered) {
            label = String.format(Locale.getDefault(), "%d. ", number);
            number++;
          } else {
            label = "• ";
          }
          builder.append(label);
          int prefixEnd = builder.length();
          appendInlines(builder, item, boldColor, inlineCodeColor, codeTypeface, linkColor);
          int itemEnd = builder.length();
          builder.setSpan(
              new LeadingMarginSpan.Standard(LEADING_MARGIN, LEADING_MARGIN + INDENT_MARGIN),
              prefixStart,
              itemEnd,
              SPAN_MODE);
          if (!listBlock.ordered) {
            builder.setSpan(new StyleSpan(Typeface.BOLD), prefixStart, prefixEnd, SPAN_MODE);
          }
        }
      } else if (block instanceof Block.Quote) {
        Block.Quote quote = (Block.Quote) block;
        int start = builder.length();
        builder.append('│');
        builder.append(' ');
        int contentStart = builder.length();
        appendInlines(builder, quote.inlines, boldColor, inlineCodeColor, codeTypeface, linkColor);
        int end = builder.length();
        builder.setSpan(new StyleSpan(Typeface.ITALIC), contentStart, end, SPAN_MODE);
        builder.setSpan(
            new LeadingMarginSpan.Standard(LEADING_MARGIN, LEADING_MARGIN + INDENT_MARGIN),
            start,
            end,
            SPAN_MODE);
      } else if (block instanceof Block.HorizontalRule) {
        builder.append(LINE_SEPARATOR);
      }
      firstBlock = false;
    }
    return builder;
  }

  private static void appendInlines(
      SpannableStringBuilder builder,
      List<Inline> inlines,
      int boldColor,
      int inlineCodeColor,
      Typeface codeTypeface,
      Integer linkColor) {
    for (Inline inline : inlines) {
      if (inline instanceof Inline.Text) {
        builder.append(((Inline.Text) inline).value);
      } else if (inline instanceof Inline.Bold) {
        Inline.Bold bold = (Inline.Bold) inline;
        int start = builder.length();
        appendInlines(builder, bold.children, boldColor, inlineCodeColor, codeTypeface, linkColor);
        int end = builder.length();
        builder.setSpan(new StyleSpan(Typeface.BOLD), start, end, SPAN_MODE);
        builder.setSpan(new ForegroundColorSpan(boldColor), start, end, SPAN_MODE);
      } else if (inline instanceof Inline.Italic) {
        Inline.Italic italic = (Inline.Italic) inline;
        int start = builder.length();
        appendInlines(
            builder, italic.children, boldColor, inlineCodeColor, codeTypeface, linkColor);
        int end = builder.length();
        builder.setSpan(new StyleSpan(Typeface.ITALIC), start, end, SPAN_MODE);
      } else if (inline instanceof Inline.Code) {
        Inline.Code code = (Inline.Code) inline;
        int start = builder.length();
        builder.append(code.value);
        int end = builder.length();
        builder.setSpan(new TypefaceSpanCompat(codeTypeface), start, end, SPAN_MODE);
        builder.setSpan(new ForegroundColorSpan(inlineCodeColor), start, end, SPAN_MODE);
      } else if (inline instanceof Inline.Link) {
        Inline.Link link = (Inline.Link) inline;
        int start = builder.length();
        appendInlines(builder, link.label, boldColor, inlineCodeColor, codeTypeface, linkColor);
        int end = builder.length();
        builder.setSpan(new URLSpan(link.url), start, end, SPAN_MODE);
        if (linkColor != null) {
          builder.setSpan(new ForegroundColorSpan(linkColor), start, end, SPAN_MODE);
        }
      } else if (inline instanceof Inline.Image) {
        Inline.Image image = (Inline.Image) inline;
        int start = builder.length();
        Drawable drawable = globalImageProvider.load(image.url);
        if (drawable != null) {
          drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
          builder.append('\uFFFC');
          int end = builder.length();
          builder.setSpan(new ImageSpan(drawable, ImageSpan.ALIGN_CENTER), start, end, SPAN_MODE);
          builder.setSpan(new URLSpan(image.url), start, end, SPAN_MODE);
          continue;
        }
        String altText = image.alt.isEmpty() ? image.url : image.alt;
        builder.append(altText);
        int end = builder.length();
        builder.setSpan(new URLSpan(image.url), start, end, SPAN_MODE);
        if (linkColor != null) {
          builder.setSpan(new ForegroundColorSpan(linkColor), start, end, SPAN_MODE);
        }
      }
    }
  }

  static List<Block> parseBlocks(String text) {
    List<Block> blocks = new ArrayList<>();
    String[] lines = text.split("\n");
    int index = 0;
    while (index < lines.length) {
      String raw = lines[index];
      String line = trimEnd(raw);
      if (line.isEmpty()) {
        index++;
        continue;
      }
      if (line.startsWith("```")) {
        Object[] result = parseCodeBlock(lines, index);
        blocks.add((Block) result[0]);
        index = (Integer) result[1];
        continue;
      }
      if (isHeading(line)) {
        blocks.add(parseHeading(line));
        index++;
        continue;
      }
      if (isHorizontalRule(line)) {
        blocks.add(Block.HorizontalRule.INSTANCE);
        index++;
        continue;
      }
      if (isQuote(line)) {
        Object[] result = parseQuote(lines, index);
        blocks.add((Block) result[0]);
        index = (Integer) result[1];
        continue;
      }
      if (isList(line)) {
        Object[] result = parseList(lines, index);
        blocks.add((Block) result[0]);
        index = (Integer) result[1];
        continue;
      }
      Object[] result = parseParagraph(lines, index);
      blocks.add((Block) result[0]);
      index = (Integer) result[1];
    }
    return blocks;
  }

  private static String trimEnd(String s) {
    int i = s.length() - 1;
    while (i >= 0 && Character.isWhitespace(s.charAt(i))) {
      i--;
    }
    return s.substring(0, i + 1);
  }

  private static Object[] parseCodeBlock(String[] lines, int startIndex) {
    String firstLine = lines[startIndex].trim();
    StringBuilder backquotes = new StringBuilder();
    for (int i = 0; i < firstLine.length(); i++) {
      if (firstLine.charAt(i) == '`') {
        backquotes.append('`');
      } else {
        break;
      }
    }
    String backquotesStr = backquotes.toString();
    String language =
        firstLine.length() > backquotesStr.length()
            ? firstLine.substring(backquotesStr.length()).trim()
            : null;
    StringBuilder builder = new StringBuilder();
    int index = startIndex + 1;
    while (index < lines.length) {
      String line = lines[index];
      if (line.trim().equals(backquotesStr)) {
        index++;
        break;
      }
      if (builder.length() > 0) {
        builder.append('\n');
      }
      builder.append(line);
      index++;
    }
    return new Object[] {new Block.CodeBlock(builder.toString(), language), index};
  }

  private static Block.Heading parseHeading(String line) {
    int level = 0;
    while (level < line.length() && line.charAt(level) == '#') {
      level++;
    }
    String content = line.substring(level).trim();
    List<Inline> inlines = parseInlines(content);
    return new Block.Heading(Math.min(Math.max(level, 1), 6), inlines);
  }

  private static Object[] parseQuote(String[] lines, int startIndex) {
    StringBuilder builder = new StringBuilder();
    int index = startIndex;
    while (index < lines.length) {
      String line = lines[index];
      if (!isQuote(line.trim())) {
        break;
      }
      String content = line.trim().substring(1);
      if (builder.length() > 0) {
        builder.append('\n');
      }
      builder.append(content.trim());
      index++;
    }
    return new Object[] {new Block.Quote(parseInlines(builder.toString())), index};
  }

  private static Object[] parseList(String[] lines, int startIndex) {
    List<List<Inline>> items = new ArrayList<>();
    int index = startIndex;
    String firstLine = lines[index];
    boolean ordered = isOrderedList(firstLine.trim());
    int counter = extractListNumber(firstLine.trim());
    while (index < lines.length) {
      String raw = lines[index];
      String trimmed = raw.trim();
      if (!isList(trimmed)) {
        break;
      }
      int markerEnd = listMarkerEnd(trimmed);
      StringBuilder contentBuilder = new StringBuilder(trimmed.substring(markerEnd).trim());
      index++;
      while (index < lines.length) {
        String cont = lines[index];
        if (cont.isEmpty()) {
          break;
        }
        if (cont.startsWith("    ") || cont.startsWith("\t")) {
          contentBuilder.append('\n');
          contentBuilder.append(cont.trim());
          index++;
          continue;
        }
        break;
      }
      items.add(parseInlines(contentBuilder.toString()));
    }
    if (!ordered) {
      counter = 1;
    }
    if (ordered && counter <= 0) {
      counter = 1;
    }
    return new Object[] {new Block.ListBlock(ordered, items, counter), index};
  }

  private static Object[] parseParagraph(String[] lines, int startIndex) {
    StringBuilder builder = new StringBuilder();
    int index = startIndex;
    while (index < lines.length) {
      String line = lines[index];
      if (line.trim().isEmpty()) {
        break;
      }
      if (isBoundary(line.trim())) {
        break;
      }
      if (builder.length() > 0) {
        builder.append(' ');
      }
      builder.append(line.trim());
      index++;
    }
    return new Object[] {new Block.Paragraph(parseInlines(builder.toString())), index};
  }

  private static boolean isBoundary(String line) {
    if (line.isEmpty()) return true;
    if (line.startsWith("```")) return true;
    if (isHeading(line)) return true;
    if (isQuote(line)) return true;
    if (isHorizontalRule(line)) return true;
    if (isList(line)) return true;
    return false;
  }

  private static List<Inline> parseInlines(String text) {
    List<Inline> nodes = new ArrayList<>();
    int index = 0;
    int length = text.length();
    while (index < length) {
      char current = text.charAt(index);
      if (current == '\\') {
        if (index + 1 < length && ESCAPE_CHARACTERS.contains(text.charAt(index + 1))) {
          nodes.add(new Inline.Text(String.valueOf(text.charAt(index + 1))));
          index += 2;
          continue;
        }
      }
      if (current == '`') {
        int closing = text.indexOf('`', index + 1);
        if (closing > index) {
          String content = text.substring(index + 1, closing);
          nodes.add(new Inline.Code(content));
          index = closing + 1;
          continue;
        }
      }
      if (current == '*' || current == '_') {
        String delimiter;
        if (index + 1 < length && text.charAt(index + 1) == current) {
          delimiter = String.valueOf(current) + current;
        } else {
          delimiter = String.valueOf(current);
        }
        int closing = findClosing(text, delimiter, index);
        if (closing > index) {
          String inside = text.substring(index + delimiter.length(), closing);
          List<Inline> children = parseInlines(inside);
          if (delimiter.length() == 2) {
            nodes.add(new Inline.Bold(children));
          } else {
            nodes.add(new Inline.Italic(children));
          }
          index = closing + delimiter.length();
          continue;
        }
      }
      if (current == '!' && index + 1 < length && text.charAt(index + 1) == '[') {
        int closingBracket = findClosingBracket(text, index + 1);
        if (closingBracket > index) {
          String alt = text.substring(index + 2, closingBracket);
          int urlStart = closingBracket + 1;
          if (urlStart < length && text.charAt(urlStart) == '(') {
            int closingParen = findClosingParen(text, urlStart);
            if (closingParen > urlStart) {
              String url = text.substring(urlStart + 1, closingParen);
              nodes.add(new Inline.Image(url, alt));
              index = closingParen + 1;
              continue;
            }
          }
        }
      }
      if (current == '[') {
        int closingBracket = findClosingBracket(text, index);
        if (closingBracket > index) {
          String label = text.substring(index + 1, closingBracket);
          int urlStart = closingBracket + 1;
          if (urlStart < length && text.charAt(urlStart) == '(') {
            int closingParen = findClosingParen(text, urlStart);
            if (closingParen > urlStart) {
              String url = text.substring(urlStart + 1, closingParen);
              List<Inline> children = parseInlines(label);
              nodes.add(new Inline.Link(children, url));
              index = closingParen + 1;
              continue;
            }
          }
        }
      }
      int nextIndex = nextSpecial(text, index);
      String content = text.substring(index, nextIndex);
      nodes.add(new Inline.Text(content));
      index = nextIndex;
    }
    return mergeText(nodes);
  }

  private static int nextSpecial(String text, int start) {
    int index = start;
    while (index < text.length()) {
      char c = text.charAt(index);
      if (c == '`' || c == '*' || c == '_' || c == '[' || c == '\\') {
        break;
      }
      index++;
    }
    return Math.max(index, start + 1);
  }

  private static List<Inline> mergeText(List<Inline> nodes) {
    List<Inline> merged = new ArrayList<>();
    StringBuilder buffer = new StringBuilder();
    for (Inline node : nodes) {
      if (node instanceof Inline.Text) {
        buffer.append(((Inline.Text) node).value);
      } else {
        if (buffer.length() > 0) {
          merged.add(new Inline.Text(buffer.toString()));
          buffer.setLength(0);
        }
        merged.add(node);
      }
    }
    if (buffer.length() > 0) {
      merged.add(new Inline.Text(buffer.toString()));
    }
    List<Inline> filtered = new ArrayList<>();
    for (Inline node : merged) {
      if (node instanceof Inline.Text && ((Inline.Text) node).value.isEmpty()) {
        continue;
      }
      filtered.add(node);
    }
    return filtered;
  }

  private static int findClosing(String text, String delimiter, int startIndex) {
    int index = startIndex + delimiter.length();
    while (index <= text.length() - delimiter.length()) {
      if (text.regionMatches(index, delimiter, 0, delimiter.length())) {
        return index;
      }
      index++;
    }
    return -1;
  }

  private static int findClosingBracket(String text, int startIndex) {
    int depth = 0;
    int index = startIndex;
    while (index < text.length()) {
      char c = text.charAt(index);
      if (c == '[') {
        depth++;
      } else if (c == ']') {
        depth--;
        if (depth == 0) {
          return index;
        }
      }
      index++;
    }
    return -1;
  }

  private static int findClosingParen(String text, int startIndex) {
    int depth = 0;
    int index = startIndex;
    while (index < text.length()) {
      char c = text.charAt(index);
      if (c == '(') {
        depth++;
      } else if (c == ')') {
        depth--;
        if (depth == 0) {
          return index;
        }
      }
      index++;
    }
    return -1;
  }

  private static boolean isHeading(String line) {
    if (!line.startsWith("#")) return false;
    int count = 0;
    while (count < line.length() && line.charAt(count) == '#') {
      count++;
    }
    if (count == line.length()) return false;
    return Character.isWhitespace(line.charAt(count));
  }

  private static boolean isQuote(String line) {
    return line.startsWith(">");
  }

  private static boolean isHorizontalRule(String line) {
    String trimmed = line.replace(" ", "");
    return trimmed.equals("***") || trimmed.equals("---") || trimmed.equals("___");
  }

  private static boolean isList(String line) {
    return UNORDERED_PATTERN.matcher(line).matches() || ORDERED_PATTERN.matcher(line).matches();
  }

  private static boolean isOrderedList(String line) {
    return ORDERED_PATTERN.matcher(line).matches();
  }

  private static int extractListNumber(String line) {
    Matcher match = ORDERED_PATTERN.matcher(line);
    if (match.matches()) {
      try {
        return Integer.parseInt(match.group(1));
      } catch (NumberFormatException e) {
        return 1;
      }
    }
    return 1;
  }

  private static int listMarkerEnd(String line) {
    Matcher match = MARKER_PATTERN.matcher(line);
    if (match.find()) {
      return match.end();
    }
    return 0;
  }

  private static String normalize(String input) {
    String text = input.replace("\r\n", "\n");
    text = text.replace("\r", "\n");
    text = BR_REGEX.matcher(text).replaceAll("\n");
    text =
        HEADING_REGEX
            .matcher(text)
            .replaceAll(
                matchResult -> {
                  int level = Integer.parseInt(matchResult.group(1));
                  String body = matchResult.group(2).trim();
                  StringBuilder sb = new StringBuilder();
                  for (int i = 0; i < level; i++) sb.append('#');
                  return sb.toString() + " " + body;
                });
    text =
        BLOCKQUOTE_REGEX
            .matcher(text)
            .replaceAll(
                matchResult -> {
                  String body = matchResult.group(1).trim();
                  return "> " + body;
                });
    text = STRONG_REGEX.matcher(text).replaceAll("**$1**");
    text = EM_REGEX.matcher(text).replaceAll("*$1*");
    text = CODE_REGEX.matcher(text).replaceAll("`$1`");
    text =
        PRE_REGEX
            .matcher(text)
            .replaceAll(
                matchResult -> {
                  String body = matchResult.group(1);
                  return "```\n" + body + "\n```";
                });
    text =
        LI_REGEX
            .matcher(text)
            .replaceAll(
                matchResult -> {
                  String body = matchResult.group(1).trim();
                  return "- " + body;
                });
    text =
        LINK_REGEX
            .matcher(text)
            .replaceAll(
                matchResult -> {
                  String href = matchResult.group(1);
                  String label = matchResult.group(2);
                  return "[" + label + "](" + href + ")";
                });
    text =
        AUTO_LINK_REGEX
            .matcher(text)
            .replaceAll(
                matchResult -> {
                  String url = matchResult.group(1);
                  if (URL_REGEX.matcher(url).matches()) {
                    return "[" + url + "](" + url + ")";
                  }
                  return matchResult.group();
                });
    text = normalizePlainUrl(text);
    text = UL_REGEX.matcher(text).replaceAll("");
    text = OL_REGEX.matcher(text).replaceAll("");
    text = P_CLOSE_REGEX.matcher(text).replaceAll("\n\n");
    text = P_OPEN_REGEX.matcher(text).replaceAll("");
    text = text.replace("&nbsp;", " ");
    text = text.replace("&lt;", "<");
    text = text.replace("&gt;", ">");
    text = text.replace("&amp;", "&");
    text = MULTI_NEWLINE_REGEX.matcher(text).replaceAll("\n\n");
    return text.trim();
  }

  private static String normalizePlainUrl(String text) {
    List<int[]> markdownLinks = new ArrayList<>();
    Matcher m = MARKDOWN_LINK_REGEX.matcher(text);
    while (m.find()) {
      markdownLinks.add(new int[] {m.start(), m.end()});
    }
    StringBuilder sb = new StringBuilder();
    int lastIndex = 0;
    Matcher urlMatcher = URL_REGEX.matcher(text);
    while (urlMatcher.find()) {
      int start = urlMatcher.start();
      int end = urlMatcher.end();
      sb.append(text.substring(lastIndex, start));
      boolean inside = false;
      for (int[] range : markdownLinks) {
        if (start >= range[0] && end <= range[1]) {
          inside = true;
          break;
        }
      }
      if (!inside) {
        sb.append("[")
            .append(urlMatcher.group())
            .append("](")
            .append(urlMatcher.group())
            .append(")");
      } else {
        sb.append(text.substring(start, end));
      }
      lastIndex = end;
    }
    sb.append(text.substring(lastIndex));
    return sb.toString();
  }

  public static class DefaultImageProvider implements ImageProvider {
    private final int maxWidth;

    public DefaultImageProvider(int maxWidth) {
      this.maxWidth = maxWidth;
    }

    public DefaultImageProvider() {
      this(800);
    }

    @Override
    public Drawable load(String src) {
      if (!src.startsWith("data:")) return null;
      int commaIndex = src.indexOf("base64,");
      if (commaIndex == -1) return null;
      String payload = src.substring(commaIndex + 7);
      if (payload.isEmpty()) return null;
      byte[] imageByteArray;
      try {
        imageByteArray = Base64.decode(payload, Base64.DEFAULT);
      } catch (Exception e) {
        return null;
      }
      Bitmap bitmap = BitmapFactory.decodeByteArray(imageByteArray, 0, imageByteArray.length);
      if (bitmap == null) return null;
      Bitmap scaledBitmap = scaleIfNeeded(bitmap, maxWidth);
      return new BitmapDrawable(scaledBitmap);
    }

    private Bitmap scaleIfNeeded(Bitmap bmp, int maxWidth) {
      int currentWidth = bmp.getWidth();
      if (currentWidth <= maxWidth) return bmp;
      float ratio = (float) maxWidth / (float) currentWidth;
      int newHeight = (int) (bmp.getHeight() * ratio);
      return Bitmap.createScaledBitmap(bmp, maxWidth, newHeight, true);
    }
  }

  public interface ImageProvider {
    Drawable load(String src);
  }

  interface Block {
    class Heading implements Block {
      public final int level;
      public final List<Inline> inlines;

      public Heading(int level, List<Inline> inlines) {
        this.level = level;
        this.inlines = inlines;
      }
    }

    class Paragraph implements Block {
      public final List<Inline> inlines;

      public Paragraph(List<Inline> inlines) {
        this.inlines = inlines;
      }
    }

    class CodeBlock implements Block {
      public final String content;
      public final String language;

      public CodeBlock(String content, String language) {
        this.content = content;
        this.language = language;
      }
    }

    class ListBlock implements Block {
      public final boolean ordered;
      public final List<List<Inline>> items;
      public final int startIndex;

      public ListBlock(boolean ordered, List<List<Inline>> items, int startIndex) {
        this.ordered = ordered;
        this.items = items;
        this.startIndex = startIndex;
      }
    }

    class Quote implements Block {
      public final List<Inline> inlines;

      public Quote(List<Inline> inlines) {
        this.inlines = inlines;
      }
    }

    enum HorizontalRule implements Block {
      INSTANCE
    }
  }

  interface Inline {
    class Text implements Inline {
      public final String value;

      public Text(String value) {
        this.value = value;
      }
    }

    class Bold implements Inline {
      public final List<Inline> children;

      public Bold(List<Inline> children) {
        this.children = children;
      }
    }

    class Italic implements Inline {
      public final List<Inline> children;

      public Italic(List<Inline> children) {
        this.children = children;
      }
    }

    class Code implements Inline {
      public final String value;

      public Code(String value) {
        this.value = value;
      }
    }

    class Link implements Inline {
      public final List<Inline> label;
      public final String url;

      public Link(List<Inline> label, String url) {
        this.label = label;
        this.url = url;
      }
    }

    class Image implements Inline {
      public final String url;
      public final String alt;

      public Image(String url, String alt) {
        this.url = url;
        this.alt = alt;
      }
    }
  }
}
