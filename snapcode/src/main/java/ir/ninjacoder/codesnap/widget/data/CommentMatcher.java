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
