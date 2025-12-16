package ir.ninjacoder.codesnap.Utils;

import ir.ninjacoder.codesnap.LangType;
import ir.ninjacoder.codesnap.antlr4.mt.Matlab;
import ir.ninjacoder.codesnap.bracket.BracketManager;
import ir.ninjacoder.codesnap.colorhelper.ColorHelper;
import android.text.SpannableStringBuilder;
import ir.ninjacoder.codesnap.Utils.Highlighter;
import ir.ninjacoder.codesnap.widget.data.SpanStyler;
import java.io.StringReader;
import java.util.List;
import ir.ninjacoder.codesnap.bracket.BracketPosition;
import java.util.ArrayList;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;

public class CodeHighlighterMatlab implements Highlighter {

  @Override
  public SpannableStringBuilder highlight(LangType types, String code, ColorHelper color)
      throws Exception {
    SpanStyler span = SpanStyler.create();
    var lexer = new Matlab(CharStreams.fromReader(new StringReader(code)));
    Token token;
    BracketManager manager = new BracketManager();
    List<BracketPosition> bracketPositions = new ArrayList<>();
    int pretoken = -1, currentPosition = 0;

    manager.setRainbowBracketsEnabled(true);
    int type;
    while ((token = lexer.nextToken()) != null) {
      type = token.getType();
      String text = token.getText();
      if (type == Matlab.EOF) {
        break;
      }
      if (isBracketToken(type)) {
        bracketPositions.add(
            new BracketPosition(
                currentPosition,
                currentPosition + token.getText().length(),
                token.getText().charAt(0),
                type));
      }
      switch (type) {
        case Matlab.WS:
        case Matlab.CR:
          span.addNullText(text);
          break;
        case Matlab.PLUS:
        case Matlab.MINUS:
        case Matlab.MUL:
        case Matlab.DIV:
        case Matlab.POW:
        case Matlab.ASSIGN:
        case Matlab.NOT:
        case Matlab.LT:
        case Matlab.GT:
        case Matlab.DOT:
        case Matlab.COLON:
        case Matlab.SEMI:
        case Matlab.COMMA:
        case Matlab.AT:
        case Matlab.LE_OP:
        case Matlab.GE_OP:
        case Matlab.EQ_OP:
        case Matlab.NE_OP:

          // Parentheses and brackets
        case Matlab.LPAREN:
        case Matlab.RPAREN:
        case Matlab.LBRACK:
        case Matlab.RBRACK:
        case Matlab.LBRACE:
        case Matlab.RBRACE:
          span.text(text, color.getOperator());
          break;
        case Matlab.ARRAYMUL:
        case Matlab.ARRAYDIV:
        case Matlab.ARRAYRDIV:
        case Matlab.ARRAYPOW:
        case Matlab.NCTRANSPOSE:
          span.text(text, color.getSymbol());
          break;
       case Matlab.IDENTIFIER: span.text(text,color.getTextnormal()); break;
        default:
          span.text(text, color.getTextnormal());
          break;
      }
      if (type != Matlab.WS  && type != Matlab.CR) {
        pretoken = type;
      }
      currentPosition += token.getText().length();
    }

    if (manager.getRainbowBracketsEnabled() && !bracketPositions.isEmpty()) {
      manager.applyRainbowBrackets(span, bracketPositions);
    }

    return span;
  }

  private boolean isBracketToken(int type) {
    return type == Matlab.LPAREN
        || type == Matlab.RPAREN
        || type == Matlab.LBRACK
        || type == Matlab.RBRACK
        || type == Matlab.LBRACE
        || type == Matlab.RBRACE;
  }
}
