package ir.ninjacoder.code.markwon;

import android.graphics.Typeface;
import android.text.Spanned;

public abstract class AsyncMarkdownCodeHighlighter implements MarkdownCodeHighlighter {
  @Override
  public boolean isAsync() {
    return true;
  }

  @Override
  public Spanned highlight(String code, String language, Typeface codeTypeface) {
    throw new UnsupportedOperationException("Use highlightAsync for async highlighter");
  }

  @Override
  public abstract Spanned highlightAsync(String code, String language, Typeface codeTypeface);
}
