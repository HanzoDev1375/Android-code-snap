package ir.ninjacoder.codesnap.Utils;

import android.text.style.ForegroundColorSpan;
import ir.ninjacoder.codesnap.LangType;
import ir.ninjacoder.codesnap.antlr4.csharp.CSharpLexer;
import ir.ninjacoder.codesnap.bracket.BracketManager;
import ir.ninjacoder.codesnap.colorhelper.ColorHelper;
import android.text.SpannableStringBuilder;
import ir.ninjacoder.codesnap.Utils.Highlighter;
import java.io.StringReader;
import java.util.List;
import ir.ninjacoder.codesnap.bracket.BracketPosition;
import java.util.ArrayList;
import java.util.regex.Pattern;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;

public class CodeHighlighterCsharp implements Highlighter {

  @Override
  public SpannableStringBuilder highlight(LangType types, String code, ColorHelper color)
      throws Exception {
    var builder = new SpannableStringBuilder();
    Token token;
    int type;
    int pretoken = -1;
    var manager = new BracketManager();
    List<BracketPosition> bracketPositions = new ArrayList<>();
    int currentPosition = 0;
    manager.setRainbowBracketsEnabled(true);
    var lexer = new CSharpLexer(CharStreams.fromReader(new StringReader(code)));
    while ((token = lexer.nextToken()) != null) {
      type = token.getType();
      if (type == CSharpLexer.EOF) break;

      if (isBracketToken(type)) {
        bracketPositions.add(
            new BracketPosition(
                currentPosition,
                currentPosition + token.getText().length(),
                token.getText().charAt(0),
                type));
      }
      switch (type) {
        case CSharpLexer.WHITESPACES:
          builder.append(token.getText());
          break;

        case CSharpLexer.ABSTRACT:
        case CSharpLexer.ADD:
        case CSharpLexer.ALIAS:
        case CSharpLexer.ARGLIST:
        case CSharpLexer.AS:
        case CSharpLexer.ASCENDING:
        case CSharpLexer.ASYNC:
        case CSharpLexer.AWAIT:
        case CSharpLexer.BASE:
        case CSharpLexer.BOOL:
        case CSharpLexer.BREAK:
        case CSharpLexer.BY:
        case CSharpLexer.BYTE:
        case CSharpLexer.CASE:
        case CSharpLexer.CATCH:
        case CSharpLexer.CHAR:
        case CSharpLexer.CHECKED:
        case CSharpLexer.CLASS:
        case CSharpLexer.CONST:
        case CSharpLexer.CONTINUE:
        case CSharpLexer.DECIMAL:
        case CSharpLexer.DEFAULT:
        case CSharpLexer.DELEGATE:
        case CSharpLexer.DESCENDING:
        case CSharpLexer.DO:
        case CSharpLexer.DOUBLE:
        case CSharpLexer.DYNAMIC:
        case CSharpLexer.ELSE:
        case CSharpLexer.ENUM:
        case CSharpLexer.EQUALS:
        case CSharpLexer.EVENT:
        case CSharpLexer.EXPLICIT:
        case CSharpLexer.EXTERN:
        case CSharpLexer.FALSE:
        case CSharpLexer.FINALLY:
        case CSharpLexer.FIXED:
        case CSharpLexer.FLOAT:
        case CSharpLexer.FOR:
        case CSharpLexer.FOREACH:
        case CSharpLexer.FROM:
        case CSharpLexer.GET:
        case CSharpLexer.GOTO:
        case CSharpLexer.GROUP:
        case CSharpLexer.IF:
        case CSharpLexer.IMPLICIT:
        case CSharpLexer.IN:
        case CSharpLexer.INT:
        case CSharpLexer.INTERFACE:
        case CSharpLexer.INTERNAL:
        case CSharpLexer.INTO:
        case CSharpLexer.IS:
        case CSharpLexer.JOIN:
        case CSharpLexer.LET:
        case CSharpLexer.LOCK:
        case CSharpLexer.LONG:
        case CSharpLexer.NAMEOF:
        case CSharpLexer.NAMESPACE:
        case CSharpLexer.NEW:
        case CSharpLexer.NULL_:
        case CSharpLexer.OBJECT:
        case CSharpLexer.ON:
        case CSharpLexer.OPERATOR:
        case CSharpLexer.ORDERBY:
        case CSharpLexer.OUT:
        case CSharpLexer.OVERRIDE:
        case CSharpLexer.PARAMS:
        case CSharpLexer.PARTIAL:
        case CSharpLexer.PRIVATE:
        case CSharpLexer.PROTECTED:
        case CSharpLexer.PUBLIC:
        case CSharpLexer.READONLY:
        case CSharpLexer.REF:
        case CSharpLexer.REMOVE:
        case CSharpLexer.RETURN:
        case CSharpLexer.SBYTE:
        case CSharpLexer.SEALED:
        case CSharpLexer.SELECT:
        case CSharpLexer.SET:
        case CSharpLexer.SHORT:
        case CSharpLexer.SIZEOF:
        case CSharpLexer.STACKALLOC:
        case CSharpLexer.STATIC:
        case CSharpLexer.STRING:
        case CSharpLexer.STRUCT:
        case CSharpLexer.SWITCH:
        case CSharpLexer.THIS:
        case CSharpLexer.THROW:
        case CSharpLexer.TRUE:
        case CSharpLexer.TRY:
        case CSharpLexer.TYPEOF:
        case CSharpLexer.UINT:
        case CSharpLexer.ULONG:
        case CSharpLexer.UNCHECKED:
        case CSharpLexer.UNMANAGED:
        case CSharpLexer.UNSAFE:
        case CSharpLexer.USHORT:
        case CSharpLexer.USING:
        case CSharpLexer.VAR:
        case CSharpLexer.VIRTUAL:
        case CSharpLexer.VOID:
        case CSharpLexer.VOLATILE:
        case CSharpLexer.WHEN:
        case CSharpLexer.WHERE:
        case CSharpLexer.WHILE:
        case CSharpLexer.YIELD:
          builder.append(
              token.getText(),
              new ForegroundColorSpan(color.getKeyword()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
          break;
        case CSharpLexer.OPEN_BRACE:
        case CSharpLexer.CLOSE_BRACE:
        case CSharpLexer.OPEN_BRACKET:
        case CSharpLexer.OPEN_PARENS:
        case CSharpLexer.CLOSE_BRACKET:
        case CSharpLexer.CLOSE_PARENS:
        case CSharpLexer.DOT:
        case CSharpLexer.COMMA:
        case CSharpLexer.COLON:
        case CSharpLexer.SEMICOLON:
        case CSharpLexer.PLUS:
        case CSharpLexer.MINUS:
        case CSharpLexer.STAR:
        case CSharpLexer.DIV:
        case CSharpLexer.PERCENT:
        case CSharpLexer.AMP:
        case CSharpLexer.BITWISE_OR:
        case CSharpLexer.CARET:
        case CSharpLexer.BANG:
        case CSharpLexer.TILDE:
        case CSharpLexer.ASSIGNMENT:
        case CSharpLexer.LT:
        case CSharpLexer.GT:
        case CSharpLexer.INTERR:
        case CSharpLexer.DOUBLE_COLON:
        case CSharpLexer.OP_COALESCING:
        case CSharpLexer.OP_INC:
        case CSharpLexer.OP_DEC:
        case CSharpLexer.OP_AND:
        case CSharpLexer.OP_OR:
        case CSharpLexer.OP_PTR:
        case CSharpLexer.OP_EQ:
        case CSharpLexer.OP_NE:
        case CSharpLexer.OP_LE:
        case CSharpLexer.OP_GE:
        case CSharpLexer.OP_ADD_ASSIGNMENT:
        case CSharpLexer.OP_SUB_ASSIGNMENT:
        case CSharpLexer.OP_MULT_ASSIGNMENT:
        case CSharpLexer.OP_DIV_ASSIGNMENT:
        case CSharpLexer.OP_MOD_ASSIGNMENT:
        case CSharpLexer.OP_AND_ASSIGNMENT:
        case CSharpLexer.OP_OR_ASSIGNMENT:
        case CSharpLexer.OP_XOR_ASSIGNMENT:
        case CSharpLexer.OP_LEFT_SHIFT:
        case CSharpLexer.OP_LEFT_SHIFT_ASSIGNMENT:
        case CSharpLexer.OP_COALESCING_ASSIGNMENT:
        case CSharpLexer.OP_RANGE:
        case CSharpLexer.SHARP:
          builder.append(
              token.getText(),
              new ForegroundColorSpan(color.getSymbol()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
          break;

        case CSharpLexer.DIGITS:
        case CSharpLexer.LITERAL_ACCESS:
        case CSharpLexer.INTEGER_LITERAL:
        case CSharpLexer.HEX_INTEGER_LITERAL:
        case CSharpLexer.BIN_INTEGER_LITERAL:
        case CSharpLexer.REAL_LITERAL:
        case CSharpLexer.DEFINE:
        case CSharpLexer.UNDEF:
        case CSharpLexer.ELIF:
        case CSharpLexer.ENDIF:
        case CSharpLexer.LINE:
        case CSharpLexer.ERROR:
        case CSharpLexer.WARNING:
        case CSharpLexer.REGION:
        case CSharpLexer.ENDREGION:
        case CSharpLexer.PRAGMA:
        case CSharpLexer.NULLABLE:
        case CSharpLexer.DIRECTIVE_HIDDEN:
        case CSharpLexer.CONDITIONAL_SYMBOL:
        case CSharpLexer.DOUBLE_CURLY_CLOSE_INSIDE:
        case CSharpLexer.SINGLE_LINE_DOC_COMMENT:
        case CSharpLexer.EMPTY_DELIMITED_DOC_COMMENT:
        case CSharpLexer.DELIMITED_COMMENT:
        case CSharpLexer.DELIMITED_DOC_COMMENT:
          builder.append(
              token.getText(),
              new ForegroundColorSpan(color.getOperator()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
          break;
        case CSharpLexer.CHARACTER_LITERAL:
        case CSharpLexer.REGULAR_STRING:
          builder.append(
              token.getText(),
              new ForegroundColorSpan(color.getStrings()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
          break;

        case CSharpLexer.IDENTIFIER:
          {
            boolean isClassName = false;
            int mcolor = color.getTextnormal();

            if (pretoken == CSharpLexer.ABSTRACT
                || pretoken == CSharpLexer.USING
                || pretoken == CSharpLexer.DELEGATE
                || pretoken == CSharpLexer.VOID
                || pretoken == CSharpLexer.CLASS
                || pretoken == CSharpLexer.VAR
                || pretoken == CSharpLexer.IDENTIFIER) {
              mcolor = color.getMethod();
              isClassName = true;
              if (lexer._input.LA(1) == '(') {
                mcolor = color.getLastsymi();
              }
            } else if (pretoken == CSharpLexer.BOOL
                || pretoken == CSharpLexer.AS
                || pretoken == CSharpLexer.IS
                || pretoken == CSharpLexer.STRING) {
              mcolor = color.getLastsymi();
            } else if (pretoken == CSharpLexer.DOT) {
              mcolor = color.getLastdot();
            } else if (pretoken == CSharpLexer.NAMESPACE) {
              mcolor = color.getOperator();
            } else if (ObjectUtils.getNextLexer(lexer, '.')) {
              mcolor = color.getPredot();
            } else if (ObjectUtils.getNextLexer(lexer, ':')) {
              mcolor = color.getPrebrak();
            } else if (lexer._input.LA(1) == '[' || lexer._input.LA(1) == ']') {
              mcolor = color.getPrebrak();
            } else if (!isClassName && Character.isUpperCase(token.getText().charAt(0))) {
              Pattern pattern = Pattern.compile("^[A-Z][a-zA-Z0-9_]*$");
              var matcher = pattern.matcher(token.getText());
              if (matcher.matches()) {
                mcolor = color.getUppercase();
              }
            }

            builder.append(
                token.getText(),
                new ForegroundColorSpan(mcolor),
                SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);

            break;
          }
        default:
          builder.append(
              token.getText(),
              new ForegroundColorSpan(color.getTextnormal()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
          break;
      }
      if (type != CSharpLexer.WHITESPACES) {
        pretoken = type;
      }
      currentPosition += token.getText().length();
    }

    if (manager.getRainbowBracketsEnabled() && !bracketPositions.isEmpty()) {
      manager.applyRainbowBrackets(builder, bracketPositions);
    }
    return builder;
  }

  boolean isBracketToken(int type) {
    return type == CSharpLexer.OPEN_BRACE
        || type == CSharpLexer.CLOSE_BRACE
        || type == CSharpLexer.OPEN_BRACKET
        || type == CSharpLexer.CLOSE_BRACKET
        || type == CSharpLexer.OPEN_PARENS
        || type == CSharpLexer.CLOSE_PARENS;
  }
}
