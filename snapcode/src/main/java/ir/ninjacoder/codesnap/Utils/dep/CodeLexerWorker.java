package ir.ninjacoder.codesnap.Utils.dep;

import ir.ninjacoder.codesnap.antlr4.PythonLexerCompat;
import ir.ninjacoder.codesnap.colorhelper.ColorHelper;
import ir.ninjacoder.codesnap.widget.data.SpanStyler;

public class CodeLexerWorker {
  public static void fstringpy(
      int pretoken, ColorHelper helper, SpanStyler span, String text, PythonLexerCompat lexer) {
    int colorNormal = helper.getVariable();
    if (pretoken == PythonLexerCompat.ASSERT) {
      colorNormal = helper.getMethod();
    }
    if (lexer._input.LA(3) == '=') {
      colorNormal = helper.getHtmlattr();
    }

    span.fstring(text, helper.getBracketlevel1(), colorNormal, helper.getStrings());
  }
}
