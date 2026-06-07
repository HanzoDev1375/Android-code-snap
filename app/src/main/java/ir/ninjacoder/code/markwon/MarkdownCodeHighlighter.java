package ir.ninjacoder.code.markwon;

import android.graphics.Typeface;
import android.text.Spanned;

public interface MarkdownCodeHighlighter {
  default boolean isAsync() {
    return false;
  }

  Spanned highlight(String code, String language, Typeface codeTypeface);

  default Spanned highlightAsync(String code, String language, Typeface codeTypeface) {
    return highlight(code, language, codeTypeface);
  }
}
