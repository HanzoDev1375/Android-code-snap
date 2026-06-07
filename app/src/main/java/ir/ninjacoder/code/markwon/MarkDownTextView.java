package ir.ninjacoder.code.markwon;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MarkDownTextView extends AppCompatTextView {


  private int boldColor = Color.parseColor("#FF5722");
  private int inlineCodeColor = Color.parseColor("#E91E63");
  private int linkColor = Color.parseColor("#2196F3");
  private Typeface codeTypeface = Typeface.MONOSPACE;
  private float[] headingScale = new float[] {1.6f, 1.4f, 1.25f, 1.1f, 1.05f, 1.0f};
  private MarkdownCodeHighlighterRegistry highlighterRegistry =
      MarkdownCodeHighlighterRegistry.global;

  public MarkDownTextView(Context context) {
    super(context);
    init();
  }

  public MarkDownTextView(Context context, AttributeSet attrs) {
    super(context, attrs);
    init();
  }

  public MarkDownTextView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();
  }

  private void init() {
    setTextIsSelectable(true);
  }

  public void setBoldColor(int boldColor) {
    this.boldColor = boldColor;
  }

  public void setInlineCodeColor(int inlineCodeColor) {
    this.inlineCodeColor = inlineCodeColor;
  }

  public void setLinkColor(int linkColor) {
    this.linkColor = linkColor;
  }

  public void setCodeTypeface(Typeface codeTypeface) {
    this.codeTypeface = codeTypeface;
  }

  public void setHeadingScale(float[] headingScale) {
    this.headingScale = headingScale;
  }

  public void setHighlighterRegistry(MarkdownCodeHighlighterRegistry highlighterRegistry) {
    this.highlighterRegistry = highlighterRegistry;
  }

  public void setMarkdown(String markdown) {
    Spanned rendered =
        SimpleMarkdownRenderer.render(
            markdown,
            boldColor,
            inlineCodeColor,
            codeTypeface,
            linkColor,
            headingScale,
            highlighterRegistry);
    setText(rendered);
  }
}
