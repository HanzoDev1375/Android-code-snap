package ir.ninjacoder.code.Utils;

import ir.ninjacoder.code.LangType;
import android.text.SpannableStringBuilder;
import ir.ninjacoder.code.Utils.CodeHighlighterPython;

public class CodeImpl implements Highlighter {

  @Override
  public SpannableStringBuilder highlight(LangType type, String code) throws Exception {
    SpannableStringBuilder string = new SpannableStringBuilder();
    if (type == LangType.JAVA) {
      return new CodeHighlighterJava().highlight(type, code);
    } else if (type == LangType.JAVASCRIPT) {
      return new CodeHighlighterJavaScript().highlight(type, code);
    } else if (type == LangType.PYTHON) {
      return new CodeHighlighterPython().highlight(type, code);
    }
    return null;
  }
}
