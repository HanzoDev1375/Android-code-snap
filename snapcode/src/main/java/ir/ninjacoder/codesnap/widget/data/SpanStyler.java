package ir.ninjacoder.codesnap.widget.data;

import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.UnderlineSpan;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class SpanStyler extends SpannableStringBuilder {

  public SpanStyler() {
    super();
  }

  public SpanStyler(CharSequence text) {
    super(text);
  }

  public SpanStyler(CharSequence text, int start, int end) {
    super(text, start, end);
  }

  public SpanStyler text(String text, int color) {
    int start = length();
    append(text);
    setSpan(new ForegroundColorSpan(color), start, length(), SPAN_EXCLUSIVE_EXCLUSIVE);
    return this;
  }
  public SpanStyler addNullText(String text){
    append(text);
    return this;
  }

  public SpanStyler text(String text, int color, boolean bold) {
    int start = length();
    append(text);
    setSpan(new ForegroundColorSpan(color), start, length(), SPAN_EXCLUSIVE_EXCLUSIVE);
    if (bold) {
      setSpan(new StyleSpan(Typeface.BOLD), start, length(), SPAN_EXCLUSIVE_EXCLUSIVE);
    }
    return this;
  }

  public SpanStyler text(String text, int color, boolean bold, boolean underline) {
    int start = length();
    append(text);
    setSpan(new ForegroundColorSpan(color), start, length(), SPAN_EXCLUSIVE_EXCLUSIVE);
    if (bold) {
      setSpan(new StyleSpan(Typeface.BOLD), start, length(), SPAN_EXCLUSIVE_EXCLUSIVE);
    }
    if (underline) {
      setSpan(new UnderlineSpan(), start, length(), SPAN_EXCLUSIVE_EXCLUSIVE);
    }
    return this;
  }

  public SpanStyler space() {
    append(" ");
    return this;
  }

  public SpanStyler newLine() {
    append("\n");
    return this;
  }

  public SpanStyler tab() {
    append("\t");
    return this;
  }

  public static SpanStyler create() {
    return new SpanStyler();
  }

  public SpanStyler backgroundColor(String text, int bgColor) {
    int start = length();
    append(text);
    setSpan(new BackgroundColorSpan(bgColor), start, length(), SPAN_EXCLUSIVE_EXCLUSIVE);
    return this;
  }

  public SpanStyler textWithSize(String text, int color, float textSize) {
    int start = length();
    append(text);
    setSpan(new ForegroundColorSpan(color), start, length(), SPAN_EXCLUSIVE_EXCLUSIVE);
    setSpan(new AbsoluteSizeSpan((int) textSize, true), start, length(), SPAN_EXCLUSIVE_EXCLUSIVE);
    return this;
  }

  public SpanStyler textWithFont(String text, int color, Typeface typeface) {
    int start = length();
    append(text);
    setSpan(new ForegroundColorSpan(color), start, length(), SPAN_EXCLUSIVE_EXCLUSIVE);
    setSpan(new CustomTypefaceSpan(typeface), start, length(), SPAN_EXCLUSIVE_EXCLUSIVE);
    return this;
  }

  public SpanStyler superscript(String text) {
    int start = length();
    append(text);
    setSpan(new SuperscriptSpan(), start, length(), SPAN_EXCLUSIVE_EXCLUSIVE);
    return this;
  }

  public SpanStyler subscript(String text) {
    int start = length();
    append(text);
    setSpan(new SubscriptSpan(), start, length(), SPAN_EXCLUSIVE_EXCLUSIVE);
    return this;
  }

  public SpanStyler comment(String text, int color) {
    if (text.contains("@")) {
      Pattern pattern = Pattern.compile("(@\\w+)");
      Matcher matcher = pattern.matcher(text);
      int lastIndex = 0;
      while (matcher.find()) {
        String before = text.substring(lastIndex, matcher.start());
        if (!before.isEmpty()) {
          append(before);
        }

        int start = length();
        append(matcher.group());
        setSpan(new ForegroundColorSpan(color), start, length(), SPAN_EXCLUSIVE_EXCLUSIVE);
        setSpan(new StyleSpan(Typeface.BOLD), start, length(), SPAN_EXCLUSIVE_EXCLUSIVE);

        lastIndex = matcher.end();
      }
      if (lastIndex < text.length()) {
        append(text.substring(lastIndex));
      }
    } else {
      append(text);
    }
    return this;
  }

  public SpanStyler commentjs(String text, int mentionColor, int bracketColor, int contentColor) {
    // پترن برای شناسایی @mention و {model}
    Pattern pattern = Pattern.compile("(@\\w+)|(\\{[^}]+\\})");
    Matcher matcher = pattern.matcher(text);
    int lastIndex = 0;

    while (matcher.find()) {

      String before = text.substring(lastIndex, matcher.start());
      if (!before.isEmpty()) {
        append(before);
      }

      String matchedText = matcher.group();

      if (matchedText.startsWith("@")) {
        // @mention
        int start = length();
        append(matchedText);
        setSpan(new ForegroundColorSpan(mentionColor), start, length(), SPAN_EXCLUSIVE_EXCLUSIVE);
        setSpan(new StyleSpan(Typeface.BOLD), start, length(), SPAN_EXCLUSIVE_EXCLUSIVE);
      } else if (matchedText.startsWith("{")) {
        // {model} - براکت‌ها و متن داخلش جدا رنگی می‌شوند
        int bracketStart = length();
        append("{");
        setSpan(
            new ForegroundColorSpan(bracketColor),
            bracketStart,
            length(),
            SPAN_EXCLUSIVE_EXCLUSIVE);
        setSpan(new StyleSpan(Typeface.BOLD), bracketStart, length(), SPAN_EXCLUSIVE_EXCLUSIVE);

        // متن داخل براکت
        String content = matchedText.substring(1, matchedText.length() - 1);
        int contentStart = length();
        append(content);
        setSpan(
            new ForegroundColorSpan(contentColor),
            contentStart,
            length(),
            SPAN_EXCLUSIVE_EXCLUSIVE);

        // براکت بسته
        int bracketEnd = length();
        append("}");
        setSpan(
            new ForegroundColorSpan(bracketColor), bracketEnd, length(), SPAN_EXCLUSIVE_EXCLUSIVE);
        setSpan(new StyleSpan(Typeface.BOLD), bracketEnd, length(), SPAN_EXCLUSIVE_EXCLUSIVE);
      }

      lastIndex = matcher.end();
    }

    // متن باقیمانده
    if (lastIndex < text.length()) {
      append(text.substring(lastIndex));
    }

    return this;
  }

  public SpanStyler fstring(String text, int bracketColor, int contentColor, int normalColor) {
    Pattern pattern = Pattern.compile("\\{(.*?)\\}");
    Matcher matcher = pattern.matcher(text);
    int lastEnd = 0;

    while (matcher.find()) {
      int exprStart = matcher.start();
      int exprEnd = matcher.end();

      // متن عادی قبل از {}
      if (exprStart > lastEnd) {
        String normalText = text.substring(lastEnd, exprStart);
        append(normalText);
        setSpan(
            new ForegroundColorSpan(normalColor),
            length() - normalText.length(),
            length(),
            SPAN_EXCLUSIVE_EXCLUSIVE);
      }

      // { با رنگ و استایل جدا
      int braceStart = length();
      append("{");
      setSpan(
          new ForegroundColorSpan(bracketColor), braceStart, length(), SPAN_EXCLUSIVE_EXCLUSIVE);
      setSpan(new StyleSpan(Typeface.BOLD), braceStart, length(), SPAN_EXCLUSIVE_EXCLUSIVE);

      // محتوای داخل {} با رنگ و استایل جدا
      String innerContent = matcher.group(1);
      if (!innerContent.isEmpty()) {
        int contentStart = length();
        append(innerContent);
        setSpan(
            new ForegroundColorSpan(contentColor),
            contentStart,
            length(),
            SPAN_EXCLUSIVE_EXCLUSIVE);
        setSpan(
            new StyleSpan(Typeface.BOLD_ITALIC), contentStart, length(), SPAN_EXCLUSIVE_EXCLUSIVE);
        setSpan(new UnderlineSpan(), contentStart, length(), SPAN_EXCLUSIVE_EXCLUSIVE);
      }

      // } با رنگ و استایل جدا
      braceStart = length();
      append("}");
      setSpan(
          new ForegroundColorSpan(bracketColor), braceStart, length(), SPAN_EXCLUSIVE_EXCLUSIVE);
      setSpan(new StyleSpan(Typeface.BOLD), braceStart, length(), SPAN_EXCLUSIVE_EXCLUSIVE);

      lastEnd = exprEnd;
    }

    // متن باقیمانده
    if (lastEnd < text.length()) {
      String remainingText = text.substring(lastEnd);
      append(remainingText);
      setSpan(
          new ForegroundColorSpan(normalColor),
          length() - remainingText.length(),
          length(),
          SPAN_EXCLUSIVE_EXCLUSIVE);
    }

    return this;
  }

  public SpanStyler ktstring(
      String text, int dollarColor, int bracketColor, int contentColor, int normalColor) {
    Pattern pattern = Pattern.compile("\\$(?:\\{(.*?)\\}|([a-zA-Z_][a-zA-Z0-9_]*))");
    Matcher matcher = pattern.matcher(text);
    int lastEnd = 0;

    while (matcher.find()) {
      int exprStart = matcher.start();
      int exprEnd = matcher.end();

      // متن عادی قبل از $
      if (exprStart > lastEnd) {
        String normalText = text.substring(lastEnd, exprStart);
        append(normalText);
        setSpan(
            new ForegroundColorSpan(normalColor),
            length() - normalText.length(),
            length(),
            SPAN_EXCLUSIVE_EXCLUSIVE);
      }

      String innerContent = matcher.group(1);
      if (innerContent != null) {
        // حالت ${}

        // $ با رنگ و استایل جدا
        int dollarStart = length();
        append("$");
        setSpan(
            new ForegroundColorSpan(dollarColor), dollarStart, length(), SPAN_EXCLUSIVE_EXCLUSIVE);
        setSpan(new StyleSpan(Typeface.BOLD), dollarStart, length(), SPAN_EXCLUSIVE_EXCLUSIVE);

        // { با رنگ و استایل جدا
        int braceStart = length();
        append("{");
        setSpan(
            new ForegroundColorSpan(bracketColor), braceStart, length(), SPAN_EXCLUSIVE_EXCLUSIVE);
        setSpan(new StyleSpan(Typeface.BOLD), braceStart, length(), SPAN_EXCLUSIVE_EXCLUSIVE);

        // محتوای داخل {}
        if (!innerContent.isEmpty()) {
          int contentStart = length();
          append(innerContent);
          setSpan(
              new ForegroundColorSpan(contentColor),
              contentStart,
              length(),
              SPAN_EXCLUSIVE_EXCLUSIVE);
          setSpan(
              new StyleSpan(Typeface.BOLD_ITALIC),
              contentStart,
              length(),
              SPAN_EXCLUSIVE_EXCLUSIVE);
          setSpan(new UnderlineSpan(), contentStart, length(), SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        // } با رنگ و استایل جدا
        braceStart = length();
        append("}");
        setSpan(
            new ForegroundColorSpan(bracketColor), braceStart, length(), SPAN_EXCLUSIVE_EXCLUSIVE);
        setSpan(new StyleSpan(Typeface.BOLD), braceStart, length(), SPAN_EXCLUSIVE_EXCLUSIVE);
      } else {
        // حالت $variable

        // $ با رنگ و استایل جدا
        int dollarStart = length();
        append("$");
        setSpan(
            new ForegroundColorSpan(dollarColor), dollarStart, length(), SPAN_EXCLUSIVE_EXCLUSIVE);
        setSpan(new StyleSpan(Typeface.BOLD), dollarStart, length(), SPAN_EXCLUSIVE_EXCLUSIVE);

        String variable = matcher.group(2);
        if (variable != null && !variable.isEmpty()) {
          int contentStart = length();
          append(variable);
          setSpan(
              new ForegroundColorSpan(contentColor),
              contentStart,
              length(),
              SPAN_EXCLUSIVE_EXCLUSIVE);
          setSpan(
              new StyleSpan(Typeface.BOLD_ITALIC),
              contentStart,
              length(),
              SPAN_EXCLUSIVE_EXCLUSIVE);
          setSpan(new UnderlineSpan(), contentStart, length(), SPAN_EXCLUSIVE_EXCLUSIVE);
        }
      }

      lastEnd = matcher.end();
    }

    // متن باقیمانده
    if (lastEnd < text.length()) {
      String remainingText = text.substring(lastEnd);
      append(remainingText);
      setSpan(
          new ForegroundColorSpan(normalColor),
          length() - remainingText.length(),
          length(),
          SPAN_EXCLUSIVE_EXCLUSIVE);
    }

    return this;
  }

  public static SpanStyler from(CharSequence text) {
    return new SpanStyler(text);
  }
}
