package ir.ninjacoder.codesnap.widget.data;

import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import ir.ninjacoder.codesnap.colorhelper.ColorHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import android.text.style.ForegroundColorSpan;

public class CommentMatcher {
  public static SpannableStringBuilder getFString(String fstringText, ColorHelper colorHelper) {
    SpannableStringBuilder fstringBuilder = new SpannableStringBuilder();
    Pattern exprPattern = Pattern.compile("\\{(.*?)\\}");
    Matcher exprMatcher = exprPattern.matcher(fstringText);

    int lastEnd = 0;

    while (exprMatcher.find()) {
      int exprStart = exprMatcher.start();
      int exprEnd = exprMatcher.end();
      if (exprStart > lastEnd) {
        String normalText = fstringText.substring(lastEnd, exprStart);
        fstringBuilder.append(
            normalText,
            new ForegroundColorSpan(colorHelper.getStrings()),
            SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
      }

      int braceStart = fstringBuilder.length();
      fstringBuilder.append("{");
      int braceEnd = fstringBuilder.length();
      fstringBuilder.setSpan(
          new StyleSpan(Typeface.BOLD),
          braceStart,
          braceEnd,
          SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
      fstringBuilder.setSpan(
          new ForegroundColorSpan(colorHelper.getSymbol()),
          braceStart,
          braceEnd,
          SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
      String innerContent = exprMatcher.group(1);
      if (!innerContent.isEmpty()) {
        int contentStart = fstringBuilder.length();
        fstringBuilder.append(innerContent);
        int contentEnd = fstringBuilder.length();
        fstringBuilder.setSpan(
            new UnderlineSpan(),
            contentStart,
            contentEnd,
            SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
        fstringBuilder.setSpan(
            new StyleSpan(Typeface.BOLD_ITALIC),
            contentStart,
            contentEnd,
            SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
        fstringBuilder.setSpan(
            new ForegroundColorSpan(colorHelper.getVariable()),
            contentStart,
            contentEnd,
            SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
      }
      braceStart = fstringBuilder.length();
      fstringBuilder.append("}");
      braceEnd = fstringBuilder.length();
      fstringBuilder.setSpan(
          new StyleSpan(Typeface.BOLD),
          braceStart,
          braceEnd,
          SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
      fstringBuilder.setSpan(
          new ForegroundColorSpan(colorHelper.getSymbol()),
          braceStart,
          braceEnd,
          SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);

      lastEnd = exprEnd;
    }

    if (lastEnd < fstringText.length()) {
      String remainingText = fstringText.substring(lastEnd);
      fstringBuilder.append(
          remainingText,
          new ForegroundColorSpan(colorHelper.getStrings()),
          SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
    }

    return fstringBuilder;
  }

  public static SpannableStringBuilder getComment(String commentText, ColorHelper colorHelper) {
    SpannableStringBuilder commentBuilder = new SpannableStringBuilder();
    List<LinkDetector.LinkPosition> links = LinkDetector.findLinks(commentText);
    Pattern pattern = Pattern.compile("(@\\w+)");
    Matcher matcher = pattern.matcher(commentText);

    int lastEnd = 0;

    while (matcher.find()) {
      int matchStart = matcher.start();
      int matchEnd = matcher.end();

      boolean hasLinkBeforeMatch = false;
      for (LinkDetector.LinkPosition linkPos : links) {
        if (linkPos.start >= lastEnd && linkPos.end <= matchStart) {
          if (linkPos.start > lastEnd) {
            String normalText = commentText.substring(lastEnd, linkPos.start);
            commentBuilder.append(
                normalText,
                new ForegroundColorSpan(colorHelper.getComment()),
                SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
          }

          String link = linkPos.link;
          int linkStart = commentBuilder.length();
          commentBuilder.append(link);
          int linkEnd = commentBuilder.length();
          commentBuilder.setSpan(
              new ForegroundColorSpan(colorHelper.getOperator()),
              linkStart,
              linkEnd,
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
          commentBuilder.setSpan(
              new UnderlineSpan(),
              linkStart,
              linkEnd,
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);

          lastEnd = linkPos.end;
          hasLinkBeforeMatch = true;
        }
      }

      if (matchStart > lastEnd) {
        String normalText = commentText.substring(lastEnd, matchStart);
        commentBuilder.append(
            normalText,
            new ForegroundColorSpan(colorHelper.getComment()),
            SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
      }

      String specialWord = matcher.group(1);
      int specialStart = commentBuilder.length();
      commentBuilder.append(specialWord);
      int specialEnd = commentBuilder.length();
      commentBuilder.setSpan(
          new ForegroundColorSpan(colorHelper.getStrings()),
          specialStart,
          specialEnd,
          SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
      commentBuilder.setSpan(
          new UnderlineSpan(),
          specialStart,
          specialEnd,
          SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);

      lastEnd = matchEnd;
    }

    for (LinkDetector.LinkPosition linkPos : links) {
      if (linkPos.start >= lastEnd) {
        if (linkPos.start > lastEnd) {
          String normalText = commentText.substring(lastEnd, linkPos.start);
          commentBuilder.append(
              normalText,
              new ForegroundColorSpan(colorHelper.getComment()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        String link = linkPos.link;
        int linkStart = commentBuilder.length();
        commentBuilder.append(link);
        int linkEnd = commentBuilder.length();
        commentBuilder.setSpan(
            new ForegroundColorSpan(colorHelper.getOperator()),
            linkStart,
            linkEnd,
            SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
        commentBuilder.setSpan(
            new UnderlineSpan(),
            linkStart,
            linkEnd,
            SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);

        lastEnd = linkPos.end;
      }
    }

    if (lastEnd < commentText.length()) {
      String remainingText = commentText.substring(lastEnd);
      commentBuilder.append(
          remainingText,
          new ForegroundColorSpan(colorHelper.getComment()),
          SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
    }

    return commentBuilder;
  }

  public static SpannableStringBuilder getKtFString(String ktStringText, ColorHelper colorHelper) {
    SpannableStringBuilder ktStringBuilder = new SpannableStringBuilder();

    // الگوی بهبود یافته برای تمپلیت‌های کاتلین
    Pattern ktExprPattern = Pattern.compile("\\$(?:\\{(.*?)\\}|([a-zA-Z_][a-zA-Z0-9_]*))");
    Matcher ktExprMatcher = ktExprPattern.matcher(ktStringText);

    int lastEnd = 0;

    while (ktExprMatcher.find()) {
      int exprStart = ktExprMatcher.start();
      int exprEnd = ktExprMatcher.end();

      // متن عادی قبل از تمپلیت
      if (exprStart > lastEnd) {
        String normalText = ktStringText.substring(lastEnd, exprStart);
        ktStringBuilder.append(
            normalText,
            new ForegroundColorSpan(colorHelper.getStrings()),
            SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
      }

      // محتوای درونی تمپلیت
      String innerContent = ktExprMatcher.group(1); // برای ${...}
      if (innerContent == null) {
        innerContent = ktExprMatcher.group(2); // برای $متغیر
      }

      // علامت دلار
      int dollarStart = ktStringBuilder.length();
      ktStringBuilder.append("$");
      int dollarEnd = ktStringBuilder.length();
      ktStringBuilder.setSpan(
          new StyleSpan(Typeface.BOLD),
          dollarStart,
          dollarEnd,
          SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
      ktStringBuilder.setSpan(
          new ForegroundColorSpan(colorHelper.getVariable()),
          dollarStart,
          dollarEnd,
          SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);

      // پردازش محتوای درونی
      if (ktExprMatcher.group(1) != null) {
        // حالت ${expression}
        addBracesAndContent(ktStringBuilder, innerContent, colorHelper);
      } else {
        // حالت $variable
        addVariableContent(ktStringBuilder, innerContent, colorHelper);
      }

      lastEnd = exprEnd;
    }

    // متن باقیمانده
    if (lastEnd < ktStringText.length()) {
      String remainingText = ktStringText.substring(lastEnd);
      ktStringBuilder.append(
          remainingText,
          new ForegroundColorSpan(colorHelper.getStrings()),
          SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
    }

    return ktStringBuilder;
  }

  // متد کمکی برای اضافه کردن محتوای ${...}
  private static void addBracesAndContent(
      SpannableStringBuilder builder, String content, ColorHelper colorHelper) {
    if (content == null) return;

    // آکولاد باز
    int braceStart = builder.length();
    builder.append("{");
    int braceEnd = builder.length();
    builder.setSpan(
        new StyleSpan(Typeface.BOLD),
        braceStart,
        braceEnd,
        SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
    builder.setSpan(
        new ForegroundColorSpan(colorHelper.getSymbol()),
        braceStart,
        braceEnd,
        SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);

    // محتوای درونی
    if (!content.isEmpty()) {
      int contentStart = builder.length();
      builder.append(content);
      int contentEnd = builder.length();
      builder.setSpan(
          new UnderlineSpan(),
          contentStart,
          contentEnd,
          SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
      builder.setSpan(
          new StyleSpan(Typeface.BOLD_ITALIC),
          contentStart,
          contentEnd,
          SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
      builder.setSpan(
          new ForegroundColorSpan(colorHelper.getVariable()),
          contentStart,
          contentEnd,
          SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
    }

    // آکولاد بسته
    braceStart = builder.length();
    builder.append("}");
    braceEnd = builder.length();
    builder.setSpan(
        new StyleSpan(Typeface.BOLD),
        braceStart,
        braceEnd,
        SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
    builder.setSpan(
        new ForegroundColorSpan(colorHelper.getSymbol()),
        braceStart,
        braceEnd,
        SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
  }

  // متد کمکی برای اضافه کردن متغیر ساده
  private static void addVariableContent(
      SpannableStringBuilder builder, String content, ColorHelper colorHelper) {
    if (content != null && !content.isEmpty()) {
      int contentStart = builder.length();
      builder.append(content);
      int contentEnd = builder.length();
      builder.setSpan(
          new UnderlineSpan(),
          contentStart,
          contentEnd,
          SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
      builder.setSpan(
          new StyleSpan(Typeface.BOLD_ITALIC),
          contentStart,
          contentEnd,
          SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
      builder.setSpan(
          new ForegroundColorSpan(colorHelper.getVariable()),
          contentStart,
          contentEnd,
          SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
    }
  }

  class LinkDetector {

    public static List<LinkPosition> findLinks(String text) {
      List<LinkPosition> links = new ArrayList<>();

      Pattern pattern =
          Pattern.compile(
              "(https?://[^\\s]+)|"
                  + "(www\\.[^\\s]+)|"
                  + "([a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,})");

      Matcher matcher = pattern.matcher(text);

      while (matcher.find()) {
        String link = matcher.group();
        int start = matcher.start();
        int end = matcher.end();

        links.add(new LinkPosition(link, start, end));
      }

      return links;
    }

    public static class LinkPosition {
      public final String link;
      public final int start;
      public final int end;

      public LinkPosition(String link, int start, int end) {
        this.link = link;
        this.start = start;
        this.end = end;
      }
    }
  }
}
