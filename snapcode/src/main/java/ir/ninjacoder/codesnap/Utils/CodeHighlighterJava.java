package ir.ninjacoder.codesnap.Utils;

import android.text.SpannableStringBuilder;
import ir.ninjacoder.codesnap.antlr4.JavaLexer;
import ir.ninjacoder.codesnap.bracket.BracketManager;
import ir.ninjacoder.codesnap.bracket.BracketPosition;
import ir.ninjacoder.codesnap.colorhelper.ColorHelper;
import ir.ninjacoder.codesnap.widget.data.CommentMatcher;
import ir.ninjacoder.codesnap.widget.data.SpanStyler;
import java.io.StringReader;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;
import android.text.style.ForegroundColorSpan;
import java.util.regex.Pattern;
import ir.ninjacoder.codesnap.LangType;
import java.util.ArrayList;
import java.util.List;

public class CodeHighlighterJava implements Highlighter {

  @Override
  public SpannableStringBuilder highlight(LangType lang, String code, ColorHelper colorHelper)
      throws Exception {
    BracketManager manager = new BracketManager();
    JavaLexer lexer = new JavaLexer(CharStreams.fromReader(new StringReader(code)));
    SpanStyler sb = SpanStyler.create();
    Token token;
    int type = 0;
    int pretoken = -1;
    List<BracketPosition> bracketPositions = new ArrayList<>();
    int currentPosition = 0;
    manager.setRainbowBracketsEnabled(true);
    while ((token = lexer.nextToken()) != null) {
      type = token.getType();
      if (type == JavaLexer.EOF) break;
      if (isBracketToken(type)) {
        bracketPositions.add(
            new BracketPosition(
                currentPosition,
                currentPosition + token.getText().length(),
                token.getText().charAt(0),
                type));
      }

      switch (type) {
        case JavaLexer.WS:
          sb.addNullText(token.getText());
          break;
        case JavaLexer.ABSTRACT:
        case JavaLexer.ASSERT:
        case JavaLexer.BREAK:
        case JavaLexer.CASE:
        case JavaLexer.CATCH:
        case JavaLexer.CLASS:
        case JavaLexer.CONST:
        case JavaLexer.CONTINUE:
        case JavaLexer.DEFAULT:
        case JavaLexer.DO:
        case JavaLexer.ELSE:
        case JavaLexer.EXTENDS:
        case JavaLexer.FINAL:
        case JavaLexer.FINALLY:
        case JavaLexer.FOR:
        case JavaLexer.IF:
        case JavaLexer.GOTO:
        case JavaLexer.IMPLEMENTS:
        case JavaLexer.IMPORT:
        case JavaLexer.INSTANCEOF:
        case JavaLexer.INTERFACE:
        case JavaLexer.NATIVE:
        case JavaLexer.NEW:
        case JavaLexer.PACKAGE:
        case JavaLexer.PRIVATE:
        case JavaLexer.PROTECTED:
        case JavaLexer.PUBLIC:
        case JavaLexer.RETURN:
        case JavaLexer.STATIC:
        case JavaLexer.STRICTFP:
        case JavaLexer.SUPER:
        case JavaLexer.SWITCH:
        case JavaLexer.SYNCHRONIZED:
        case JavaLexer.THIS:
        case JavaLexer.THROW:
        case JavaLexer.THROWS:
        case JavaLexer.TRANSIENT:
        case JavaLexer.TRY:
        case JavaLexer.VOID:
        case JavaLexer.VOLATILE:
        case JavaLexer.WHILE:
          sb.text(token.getText(), colorHelper.getKeyword());
          break;
        case JavaLexer.DECIMAL_LITERAL:
        case JavaLexer.HEX_LITERAL:
        case JavaLexer.OCT_LITERAL:
        case JavaLexer.BINARY_LITERAL:
        case JavaLexer.FLOAT_LITERAL:
        case JavaLexer.HEX_FLOAT_LITERAL:
        case JavaLexer.BOOL_LITERAL:
        case JavaLexer.CHAR_LITERAL:
        case JavaLexer.NULL_LITERAL:
          sb.text(token.getText(), colorHelper.getOperator());

          break;
        case JavaLexer.STRING_LITERAL:
          sb.text(token.getText(), colorHelper.getStrings());
          break;
        case JavaLexer.LPAREN:
        case JavaLexer.RPAREN:
        case JavaLexer.LBRACK:
        case JavaLexer.RBRACK:
        case JavaLexer.SEMI:
        case JavaLexer.COMMA:
        case JavaLexer.ASSIGN:
        case JavaLexer.GT:
        case JavaLexer.LT:
        case JavaLexer.BANG:
        case JavaLexer.TILDE:
        case JavaLexer.QUESTION:
        case JavaLexer.COLON:
        case JavaLexer.EQUAL:
        case JavaLexer.GE:
        case JavaLexer.LE:
        case JavaLexer.NOTEQUAL:
        case JavaLexer.AND:
        case JavaLexer.OR:
        case JavaLexer.INC:
        case JavaLexer.DEC:
        case JavaLexer.ADD:
        case JavaLexer.SUB:
        case JavaLexer.MUL:
        case JavaLexer.DIV:
        case JavaLexer.BITAND:
        case JavaLexer.BITOR:
        case JavaLexer.CARET:
        case JavaLexer.MOD:
        case JavaLexer.ADD_ASSIGN:
        case JavaLexer.SUB_ASSIGN:
        case JavaLexer.MUL_ASSIGN:
        case JavaLexer.DIV_ASSIGN:
        case JavaLexer.AND_ASSIGN:
        case JavaLexer.OR_ASSIGN:
        case JavaLexer.XOR_ASSIGN:
        case JavaLexer.MOD_ASSIGN:
        case JavaLexer.LSHIFT_ASSIGN:
        case JavaLexer.RSHIFT_ASSIGN:
        case JavaLexer.URSHIFT_ASSIGN:
        case JavaLexer.ARROW:
        case JavaLexer.COLONCOLON:
        case JavaLexer.ELLIPSIS:
        case JavaLexer.DOT:
        case JavaLexer.LBRACE:
        case JavaLexer.RBRACE:
        case JavaLexer.AT:
          sb.text(token.getText(), colorHelper.getSymbol());
          break;
        case JavaLexer.BOOLEAN:
        case JavaLexer.BYTE:
        case JavaLexer.CHAR:
        case JavaLexer.DOUBLE:
        case JavaLexer.ENUM:
        case JavaLexer.FLOAT:
        case JavaLexer.INT:
        case JavaLexer.LONG:
        case JavaLexer.SHORT:
          sb.text(token.getText(), colorHelper.getOperator());
          break;
        case JavaLexer.BLOCK_COMMENT:
        case JavaLexer.LINE_COMMENT:
          {
            sb.commentjs(
                token.getText(),
                colorHelper.getBracketlevel3(),
                colorHelper.getBracketlevel1(),
                colorHelper.getBracketlevel2(),
                colorHelper.getComment());
            break; 
          }
        case JavaLexer.IDENTIFIER:
          {
            int colorNormal = colorHelper.getTextnormal();
            boolean isClassName = false , isbold = false;
            if (pretoken == JavaLexer.CLASS
                || pretoken == JavaLexer.INTERFACE
                || pretoken == JavaLexer.ENUM
                || pretoken == JavaLexer.EXTENDS
                || pretoken == JavaLexer.IMPLEMENTS) {
              colorNormal = colorHelper.getMethod();
              isbold = true;
              isClassName = true;
            } else if (pretoken == JavaLexer.VOID
                || pretoken == JavaLexer.BOOLEAN
                || pretoken == JavaLexer.BYTE
                || pretoken == JavaLexer.CHAR
                || pretoken == JavaLexer.DOUBLE
                || pretoken == JavaLexer.FLOAT
                || pretoken == JavaLexer.INT
                || pretoken == JavaLexer.LONG
                || pretoken == JavaLexer.SHORT
                || pretoken == JavaLexer.IDENTIFIER) {
                  colorNormal = colorHelper.getMethod();
                  isbold=true;
              if (lexer._input.LA(1) == '(') {
                colorNormal = colorHelper.getLastsymi();
              }
            } else if (lexer._input.LA(1) == '.') {
              colorNormal = colorHelper.getLastdot();
            } else if (lexer._input.LA(1) == '[' || lexer._input.LA(1) == ']') {
              colorNormal = colorHelper.getPrebrak();
            } else if(lexer._input.LA(2) == '{'){
              colorNormal = colorHelper.getBracketlevel1();
            }else if (pretoken == JavaLexer.DOT) {
              colorNormal = colorHelper.getPredot();
            } else if (!isClassName && Character.isUpperCase(token.getText().charAt(0))) {
              Pattern pattern = Pattern.compile("^[A-Z][a-zA-Z0-9_]*$");
              var matcher = pattern.matcher(token.getText());
              if (matcher.matches()) {
                colorNormal = colorHelper.getUppercase();
              }
            }

            sb.text(token.getText(), colorNormal,isbold);
            break;
          }
        default:
          sb.text(token.getText(), colorHelper.getTextnormal());
          break;
      }
      if (type != JavaLexer.WS) {
        pretoken = type;
      }
      currentPosition += token.getText().length();
    }

    if (manager.getRainbowBracketsEnabled() && !bracketPositions.isEmpty()) {
      manager.applyRainbowBrackets(sb, bracketPositions);
    }

    return sb;
  }

  private boolean isBracketToken(int tokenType) {
    return tokenType == JavaLexer.LPAREN
        || tokenType == JavaLexer.RPAREN
        || tokenType == JavaLexer.LBRACE
        || tokenType == JavaLexer.RBRACE
        || tokenType == JavaLexer.LBRACK
        || tokenType == JavaLexer.RBRACK;
  }
}
