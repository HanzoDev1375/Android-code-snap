package ir.ninjacoder.code.Utils;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import ir.ninjacoder.code.Utils.CodeHighlighterJavaScript;
import ir.ninjacoder.code.antlr4.JavaLexer;
import ir.ninjacoder.code.bracket.BracketInfo;
import ir.ninjacoder.code.bracket.BracketManager;
import ir.ninjacoder.code.bracket.BracketPair;
import ir.ninjacoder.code.bracket.BracketPosition;
import ir.ninjacoder.code.colorhelper.ColorHelper;
import java.io.StringReader;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;
import android.text.style.ForegroundColorSpan;
import android.text.style.BackgroundColorSpan;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import ir.ninjacoder.code.LangType;
import java.util.Stack;
import java.util.ArrayList;
import java.util.List;

public class CodeHighlighterJava implements Highlighter {


  @Override
  public SpannableStringBuilder highlight(LangType lang, String code) throws Exception {

    ColorHelper colorHelper = new ColorHelper();
     BracketManager manager = new BracketManager();
    JavaLexer lexer = new JavaLexer(CharStreams.fromReader(new StringReader(code)));
    SpannableStringBuilder sb = new SpannableStringBuilder();
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
          sb.append(token.getText());
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
          sb.append(
              token.getText(),
              new ForegroundColorSpan(colorHelper.getKeyword()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
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
          sb.append(
              token.getText(),
              new ForegroundColorSpan(colorHelper.getOperator()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
          break;
        case JavaLexer.STRING_LITERAL:
          sb.append(
              token.getText(),
              new ForegroundColorSpan(colorHelper.getStrings()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
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
          // برای براکت‌ها رنگ معمولی می‌گذاریم و بعداً رنگین کمانی اعمال می‌کنیم
          sb.append(
              token.getText(),
              new ForegroundColorSpan(colorHelper.getSymbol()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
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
          sb.append(
              token.getText(),
              new ForegroundColorSpan(colorHelper.getOperator()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
          break;
        case JavaLexer.BLOCK_COMMENT:
        case JavaLexer.LINE_COMMENT:
          sb.append(
              token.getText(),
              new ForegroundColorSpan(colorHelper.getComment()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
          break;
        case JavaLexer.IDENTIFIER:
          {
            int colorNormal = colorHelper.getTextnormal();
            boolean isClassName = false;
            if (pretoken == JavaLexer.CLASS
                || pretoken == JavaLexer.INTERFACE
                || pretoken == JavaLexer.ENUM
                || pretoken == JavaLexer.EXTENDS
                || pretoken == JavaLexer.IMPLEMENTS) {
              colorNormal = colorHelper.getMethod();
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
              if (lexer._input.LA(1) == '(') {
                colorNormal = colorHelper.getLastsymi();
              }
            } else if (lexer._input.LA(1) == '.') {
              colorNormal = colorHelper.getLastdot();
            } else if (lexer._input.LA(1) == '[' || lexer._input.LA(1) == ']') {
              colorNormal = colorHelper.getPrebrak();
            } else if (pretoken == JavaLexer.DOT) {
              colorNormal = colorHelper.getPredot();
            } else if (!isClassName && Character.isUpperCase(token.getText().charAt(0))) {
              Pattern pattern = Pattern.compile("^[A-Z][a-zA-Z0-9_]*$");
              var matcher = pattern.matcher(token.getText());
              if (matcher.matches()) {
                colorNormal = colorHelper.getUppercase();
              }
            }

            sb.append(
                token.getText(),
                new ForegroundColorSpan(colorNormal),
                SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
            break;
          }
        default:
          sb.append(
              token.getText(),
              new ForegroundColorSpan(colorHelper.getTextnormal()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
          break;
      }
      if (type != JavaLexer.WS) {
        pretoken = type;
      }
      currentPosition += token.getText().length();
    }

    if (manager.getRainbowBracketsEnabled() && !bracketPositions.isEmpty()) {
     manager. applyRainbowBrackets(sb, bracketPositions);
    }

    return sb;
  }

  /** بررسی آیا توکن داده شده یک براکت است */
  private boolean isBracketToken(int tokenType) {
    return tokenType == JavaLexer.LPAREN
        || tokenType == JavaLexer.RPAREN
        || tokenType == JavaLexer.LBRACE
        || tokenType == JavaLexer.RBRACE
        || tokenType == JavaLexer.LBRACK
        || tokenType == JavaLexer.RBRACK;
  }
}