package ir.ninjacoder.codesnap.Utils;

import android.text.style.ForegroundColorSpan;
import ir.ninjacoder.codesnap.LangType;
import android.text.SpannableStringBuilder;
import ir.ninjacoder.codesnap.Utils.Highlighter;
import ir.ninjacoder.codesnap.antlr4.PythonLexerCompat;
import ir.ninjacoder.codesnap.colorhelper.ColorHelper;
import ir.ninjacoder.codesnap.widget.data.CommentMatcher;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.regex.Pattern;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;

public class CodeHighlighterPython implements Highlighter {

  @Override
  public SpannableStringBuilder highlight(LangType types, String code, ColorHelper color)
      throws Exception {

    SpannableStringBuilder builder = new SpannableStringBuilder();
    PythonLexerCompat lexer = new PythonLexerCompat(CharStreams.fromReader(new StringReader(code)));
    int type;
    int pretoken = -1;
    Token token;

    while ((token = lexer.nextToken()) != null) {
      type = token.getType();
      if (type == PythonLexerCompat.EOF) break;
      switch (type) {
        case PythonLexerCompat.WS:
          builder.append(token.getText());
          break;
        case PythonLexerCompat.LBRACE:
        case PythonLexerCompat.LPAR:
        case PythonLexerCompat.LSQB:

        case PythonLexerCompat.RBRACE:
        case PythonLexerCompat.RPAR:
        case PythonLexerCompat.RSQB:
          builder.append(
              token.getText(),
              new ForegroundColorSpan(color.getSymbol()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
          break;
        case PythonLexerCompat.AND:
        case PythonLexerCompat.AS:
        case PythonLexerCompat.ASYNC:
        case PythonLexerCompat.AWAIT:
        case PythonLexerCompat.BREAK:
        case PythonLexerCompat.CLASS:
        case PythonLexerCompat.CONTINUE:
        case PythonLexerCompat.DEF:
        case PythonLexerCompat.DEL:
        case PythonLexerCompat.ELIF:
        case PythonLexerCompat.ELSE:
        case PythonLexerCompat.EXCEPT:
        case PythonLexerCompat.FALSE:
        case PythonLexerCompat.FINALLY:
        case PythonLexerCompat.FOR:
        case PythonLexerCompat.GLOBAL:
        case PythonLexerCompat.IF:
        case PythonLexerCompat.IMPORT:
        case PythonLexerCompat.IN:
        case PythonLexerCompat.IS:
        case PythonLexerCompat.RAISE:
        case PythonLexerCompat.RETURN:
        case PythonLexerCompat.TRUE:
        case PythonLexerCompat.TRY:
        case PythonLexerCompat.WITH:
        case PythonLexerCompat.YIELD:
        case PythonLexerCompat.FROM:
        case PythonLexerCompat.WHILE:
        case PythonLexerCompat.ASSERT:
        case PythonLexerCompat.LAMBDA:
        case PythonLexerCompat.NONE:
        case PythonLexerCompat.NONLOCAL:
        case PythonLexerCompat.NOT:
        case PythonLexerCompat.OR:
        case PythonLexerCompat.PASS:
        case PythonLexerCompat.NAME_OR_TYPE:
        case PythonLexerCompat.NAME_OR_MATCH:
        case PythonLexerCompat.NAME_OR_CASE:
          builder.append(
              token.getText(),
              new ForegroundColorSpan(color.getKeyword()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
          break;
        case PythonLexerCompat.DOT:
        case PythonLexerCompat.STAR:
        case PythonLexerCompat.COMMA:
        case PythonLexerCompat.VBAR:
        case PythonLexerCompat.EQUAL:
        case PythonLexerCompat.PERCENT:
        case PythonLexerCompat.EQEQUAL:
        case PythonLexerCompat.NOTEQUAL:
        case PythonLexerCompat.LESSEQUAL:
        case PythonLexerCompat.GREATEREQUAL:
        case PythonLexerCompat.TILDE:
        case PythonLexerCompat.CIRCUMFLEX:
        case PythonLexerCompat.LEFTSHIFT:
        case PythonLexerCompat.RIGHTSHIFT:
        case PythonLexerCompat.DOUBLESTAR:
        case PythonLexerCompat.PLUSEQUAL:
        case PythonLexerCompat.MINEQUAL:
        case PythonLexerCompat.STAREQUAL:
        case PythonLexerCompat.SLASHEQUAL:
        case PythonLexerCompat.PERCENTEQUAL:
        case PythonLexerCompat.AMPEREQUAL:
        case PythonLexerCompat.VBAREQUAL:
        case PythonLexerCompat.CIRCUMFLEXEQUAL:
        case PythonLexerCompat.LEFTSHIFTEQUAL:
        case PythonLexerCompat.RIGHTSHIFTEQUAL:
        case PythonLexerCompat.DOUBLESTAREQUAL:
        case PythonLexerCompat.DOUBLESLASH:
        case PythonLexerCompat.DOUBLESLASHEQUAL:
        case PythonLexerCompat.AT:
        case PythonLexerCompat.ATEQUAL:
        case PythonLexerCompat.RARROW:
        case PythonLexerCompat.ELLIPSIS:
        case PythonLexerCompat.COLONEQUAL:
        case PythonLexerCompat.EXCLAMATION:
          builder.append(
              token.getText(),
              new ForegroundColorSpan(color.getSymbol()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
          break;
        case PythonLexerCompat.FSTRING:
        case PythonLexerCompat.STRING:
        case PythonLexerCompat.NUMBER:
          builder.append(CommentMatcher.getFString(token.getText(), color));
          break;
        case PythonLexerCompat.COMMENT:
          builder.append(
              token.getText(),
              new ForegroundColorSpan(color.getComment()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
          break;

        case PythonLexerCompat.IDENTIFIER:
          {
            int colorId = color.getTextnormal();
            String text = token.getText();

            if (pretoken == PythonLexerCompat.CLASS || pretoken == PythonLexerCompat.DEF) {
              colorId = color.getMethod();
            } else if (pretoken == PythonLexerCompat.FROM
                || pretoken == PythonLexerCompat.IMPORT
                || pretoken == PythonLexerCompat.AS) {
              colorId = color.getOperator();
            } else if (pretoken == PythonLexerCompat.AT) {
              colorId = color.getSymbol();
            } else if (pretoken == PythonLexerCompat.RETURN
                || pretoken == PythonLexerCompat.YIELD) {
              colorId = color.getVariable();
            } else if (pretoken == PythonLexerCompat.IF
                || pretoken == PythonLexerCompat.ELIF
                || pretoken == PythonLexerCompat.WHILE
                || pretoken == PythonLexerCompat.FOR) {
              colorId = color.getOperator();
            } else if (pretoken == PythonLexerCompat.IDENTIFIER) {

              if (ObjectUtils.getNextLexer(lexer, '(')) {
                colorId = color.getLastsymi();
              }
            }

            if (ObjectUtils.getNextLexer(lexer, '(')) {
              colorId = color.getVariable();
            } else if (ObjectUtils.getNextLexer(lexer, '.')) {
              colorId = color.getLastdot();
            } else if (ObjectUtils.getNextLexer(lexer, '[')) {
              colorId = color.getPrebrak();
            } else if (ObjectUtils.getNextLexer(lexer, ':')) {
              colorId = color.getMethod();
            }

            Set<String> builtinFuncs =
                new HashSet<>(
                    Arrays.asList(
                        "print", "range", "len", "input", "int", "str", "list", "dict", "set",
                        "tuple", "open"));
            if (builtinFuncs.contains(text)) {
              colorId = color.getVariable();
            }

            if (Character.isUpperCase(text.charAt(0))) {
              Pattern pattern = Pattern.compile("^[A-Z][a-zA-Z0-9_]*$");
              if (pattern.matcher(text).matches()) {
                colorId = color.getUppercase();
              }
            }

            builder.append(
                text,
                new ForegroundColorSpan(colorId),
                SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
            break;
          }
        default:
          builder.append(
              token.getText(),
              new ForegroundColorSpan(color.getTextnormal()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
      }
      if (type != PythonLexerCompat.WS) pretoken = type;
    }
    return builder;
  }
}
