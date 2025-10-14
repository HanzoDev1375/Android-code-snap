package ir.ninjacoder.codesnap.Utils;

import android.text.style.ForegroundColorSpan;
import ir.ninjacoder.codesnap.LangType;
import android.text.SpannableStringBuilder;
import ir.ninjacoder.codesnap.Utils.Highlighter;
import ir.ninjacoder.codesnap.antlr4.rust.RustLexer;
import ir.ninjacoder.codesnap.colorhelper.ColorHelper;
import java.io.StringReader;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;

public class CodeHighlighterRust implements Highlighter {

  @Override
  public SpannableStringBuilder highlight(LangType types, String code,ColorHelper color) throws Exception {
    var builder = new SpannableStringBuilder();
    var lexer = new RustLexer(CharStreams.fromReader(new StringReader(code)));
    Token token;
    
    int pretoken = -1;
    int type;
    while ((token = lexer.nextToken()) != null) {
      type = token.getType();
      if (type == RustLexer.EOF) break;
      switch (type) {
        case RustLexer.WHITESPACE:
        case RustLexer.NEWLINE:
          builder.append(token.getText());
          break;
        case RustLexer.KW_AS:
        case RustLexer.KW_BREAK:
        case RustLexer.KW_CONST:
        case RustLexer.KW_CONTINUE:
        case RustLexer.KW_CRATE:
        case RustLexer.KW_ELSE:
        case RustLexer.KW_ENUM:
        case RustLexer.KW_EXTERN:
        case RustLexer.KW_FALSE:
        case RustLexer.KW_FN:
        case RustLexer.KW_FOR:
        case RustLexer.KW_IF:
        case RustLexer.KW_IMPL:
        case RustLexer.KW_IN:
        case RustLexer.KW_LET:
        case RustLexer.KW_LOOP:
        case RustLexer.KW_MATCH:
        case RustLexer.KW_MOD:
        case RustLexer.KW_MOVE:
        case RustLexer.KW_MUT:
        case RustLexer.KW_PUB:
        case RustLexer.KW_REF:
        case RustLexer.KW_RETURN:
        case RustLexer.KW_SELFVALUE:
        case RustLexer.KW_SELFTYPE:
        case RustLexer.KW_STATIC:
        case RustLexer.KW_STRUCT:
        case RustLexer.KW_SUPER:
        case RustLexer.KW_TRAIT:
        case RustLexer.KW_TRUE:
        case RustLexer.KW_TYPE:
        case RustLexer.KW_UNSAFE:
        case RustLexer.KW_USE:
        case RustLexer.KW_WHERE:
        case RustLexer.KW_WHILE:
        case RustLexer.KW_ASYNC:
        case RustLexer.KW_AWAIT:
        case RustLexer.KW_DYN:
        case RustLexer.KW_ABSTRACT:
        case RustLexer.KW_BECOME:
        case RustLexer.KW_BOX:
        case RustLexer.KW_DO:
        case RustLexer.KW_FINAL:
        case RustLexer.KW_MACRO:
        case RustLexer.KW_OVERRIDE:
        case RustLexer.KW_PRIV:
        case RustLexer.KW_TYPEOF:
        case RustLexer.KW_UNSIZED:
        case RustLexer.KW_VIRTUAL:
        case RustLexer.KW_YIELD:
        case RustLexer.KW_TRY:
        case RustLexer.KW_UNION:
        case RustLexer.KW_STATICLIFETIME:
        case RustLexer.KW_MACRORULES:
          builder.append(
              token.getText(),
              new ForegroundColorSpan(color.getKeyword()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
          break;
        case RustLexer.PLUS:
        case RustLexer.MINUS:
        case RustLexer.STAR:
        case RustLexer.SLASH:
        case RustLexer.PERCENT:
        case RustLexer.CARET:
        case RustLexer.NOT:
        case RustLexer.AND:
        case RustLexer.OR:
        case RustLexer.ANDAND:
        case RustLexer.OROR:
        case RustLexer.PLUSEQ:
        case RustLexer.MINUSEQ:
        case RustLexer.STAREQ:
        case RustLexer.SLASHEQ:
        case RustLexer.PERCENTEQ:
        case RustLexer.CARETEQ:
        case RustLexer.ANDEQ:
        case RustLexer.OREQ:
        case RustLexer.SHLEQ:
        case RustLexer.SHREQ:
        case RustLexer.EQ:
        case RustLexer.EQEQ:
        case RustLexer.NE:
        case RustLexer.GT:
        case RustLexer.LT:
        case RustLexer.GE:
        case RustLexer.LE:
        case RustLexer.AT:
        case RustLexer.UNDERSCORE:
        case RustLexer.DOT:
        case RustLexer.DOTDOT:
        case RustLexer.DOTDOTDOT:
        case RustLexer.DOTDOTEQ:
        case RustLexer.COMMA:
        case RustLexer.SEMI:
        case RustLexer.COLON:
        case RustLexer.PATHSEP:
        case RustLexer.RARROW:
        case RustLexer.FATARROW:
        case RustLexer.POUND:
        case RustLexer.DOLLAR:
        case RustLexer.QUESTION:
        case RustLexer.LCURLYBRACE:
        case RustLexer.LSQUAREBRACKET:
        case RustLexer.LPAREN:
        case RustLexer.RCURLYBRACE:
        case RustLexer.RSQUAREBRACKET:
        case RustLexer.RPAREN:
          builder.append(
              token.getText(),
              new ForegroundColorSpan(color.getSymbol()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
          break;
        case RustLexer.STRING_LITERAL:
        case RustLexer.CHAR_LITERAL:
          builder.append(
              token.getText(),
              new ForegroundColorSpan(color.getStrings()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
          break;
        case RustLexer.LINE_COMMENT:
          builder.append(
              token.getText(),
              new ForegroundColorSpan(color.getComment()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
          break;
        case RustLexer.INTEGER_LITERAL:
        case RustLexer.FLOAT_LITERAL:
          builder.append(
              token.getText(),
              new ForegroundColorSpan(color.getOperator()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
          break;
        case RustLexer.NON_KEYWORD_IDENTIFIER:
          {
            int colorid = color.getTextnormal();
            if (pretoken == RustLexer.KW_STATIC) {
              colorid = color.getLastsymi();
            }
            if (pretoken == RustLexer.KW_FN) {
              colorid = color.getMethod();
            }
            if (pretoken == RustLexer.LT) {
              colorid = color.getPrebrak();
            }
            if (pretoken == RustLexer.COLON || pretoken == RustLexer.PATHSEP) {
              colorid = color.getPrebrak();
            }
            if (ObjectUtils.getNextLexer(lexer, '(')) {
              colorid = color.getPrebrak();
            }
            if (ObjectUtils.getNextLexer(lexer, ':')) {
              colorid = color.getLastsymi();
            }
            if (ObjectUtils.getNextLexer(lexer, '.')) {
              colorid = color.getLastdot();
            }
            if (ObjectUtils.getNextLexer(lexer, '<')) {
              colorid = color.getPredot();
            }
            if (ObjectUtils.getNextLexer(lexer, '!')) {
              colorid = color.getUppercase();
            }
            if (pretoken == RustLexer.KW_MUT
                || pretoken == RustLexer.KW_MATCH
                || pretoken == RustLexer.KW_LET) {
              colorid = color.getVariable();
            }
            if (token.getText().equalsIgnoreCase("Ok")
                || token.getText().equalsIgnoreCase("Error")) {
              colorid = color.getVariable();
            }
            builder.append(
                token.getText(),
                new ForegroundColorSpan(colorid),
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
      if (type != RustLexer.WHITESPACE && type != RustLexer.NEWLINE) {
        type = pretoken;
      }
    }
    return builder;
  }
}
