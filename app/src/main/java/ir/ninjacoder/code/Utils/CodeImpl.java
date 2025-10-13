package ir.ninjacoder.code.Utils;

import ir.ninjacoder.code.LangType;
import android.text.SpannableStringBuilder;

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
    } else if (type == LangType.RUST) {
      return new CodeHighlighterRust().highlight(type, code);
    } else if (type == LangType.CPP) {
      return new CodeHighlighterCpp().highlight(type, code);
    } else if (type == LangType.C) {
      return new CodeHighlighterCLang().highlight(type, code);
    }
    return null;
  }
}
