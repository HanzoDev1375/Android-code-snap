package ir.ninjacoder.codesnap.Utils;

import ir.ninjacoder.codesnap.LangType;
import android.text.SpannableStringBuilder;
import ir.ninjacoder.codesnap.colorhelper.ColorHelper;

public class CodeImpl implements Highlighter {

  @Override
  public SpannableStringBuilder highlight(LangType type, String code, ColorHelper color)
      throws Exception {
    SpannableStringBuilder string = new SpannableStringBuilder();
    if (type == LangType.JAVA) {
      return new CodeHighlighterJava().highlight(type, code, color);
    } else if (type == LangType.JAVASCRIPT) {
      return new CodeHighlighterJavaScript().highlight(type, code, color);
    } else if (type == LangType.PYTHON) {
      return new CodeHighlighterPython().highlight(type, code, color);
    } else if (type == LangType.RUST) {
      return new CodeHighlighterRust().highlight(type, code, color);
    } else if (type == LangType.CPP) {
      return new CodeHighlighterCpp().highlight(type, code, color);
    } else if (type == LangType.C) {
      return new CodeHighlighterCLang().highlight(type, code, color);
    } else if (type == LangType.HTML || type == LangType.PHP || type == LangType.CSS) {
      return new CodeHighlighterWeb().highlight(type, code, color);
    } else if (type == LangType.KOTLIN) {
      return new CodeHighlighterKt().highlight(type, code, color);
    } else if (type == LangType.CSHARP) {
      return new CodeHighlighterCsharp().highlight(type, code, color);
    } else if (type == LangType.TYPESCRIPT) {
      return new CodeHighlighterTs().highlight(type, code, color);
    } else if (type == LangType.GRADLE) {
      return new CodeHighlighterGradle().highlight(type, code, color);
    } else if (type == LangType.DART) {
      return new CodeHighlighterDart().highlight(type, code, color);
    } else if (type == LangType.GO) {
      return new CodeHighlighterGo().highlight(type, code, color);
    }
    return null;
  }
}
