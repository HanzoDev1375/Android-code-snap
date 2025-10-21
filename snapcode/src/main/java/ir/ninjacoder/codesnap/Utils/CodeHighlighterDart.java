package ir.ninjacoder.codesnap.Utils;

import ir.ninjacoder.codesnap.LangType;
import ir.ninjacoder.codesnap.antlr4.dart.Dart2LexerCompat;
import ir.ninjacoder.codesnap.bracket.BracketManager;
import java.util.List;
import ir.ninjacoder.codesnap.bracket.BracketPosition;
import java.util.ArrayList;
import ir.ninjacoder.codesnap.colorhelper.ColorHelper;
import android.text.SpannableStringBuilder;
import ir.ninjacoder.codesnap.Utils.Highlighter;
import ir.ninjacoder.codesnap.widget.data.SpanStyler;
import java.io.StringReader;
import java.util.regex.Pattern;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;

public class CodeHighlighterDart implements Highlighter {

  @Override
  public SpannableStringBuilder highlight(LangType types, String code, ColorHelper color)
      throws Exception {
    SpanStyler span = SpanStyler.create();
    var lexer = new Dart2LexerCompat(CharStreams.fromReader(new StringReader(code)));
    int type;
    int pretoken = -1;
    Token token;
    var manager = new BracketManager();
    List<BracketPosition> bracketPositions = new ArrayList<>();
    int currentPosition = 0;
    manager.setRainbowBracketsEnabled(true);
    while ((token = lexer.nextToken()) != null) {
      type = token.getType();
      if (type == Dart2LexerCompat.EOF) break;
      if (isBracketToken(type)) {
        bracketPositions.add(
            new BracketPosition(
                currentPosition,
                currentPosition + token.getText().length(),
                token.getText().charAt(0),
                type));
      }
      String data = token.getText();
      switch (type) {
        case Dart2LexerCompat.WHITESPACE:
          span.addNullText(data);
          break;
        case Dart2LexerCompat.ABSTRACT_:
        case Dart2LexerCompat.AS_:
        case Dart2LexerCompat.ASSERT_:
        case Dart2LexerCompat.ASYNC_:
        case Dart2LexerCompat.AWAIT_:
        case Dart2LexerCompat.BREAK_:
        case Dart2LexerCompat.CASE_:
        case Dart2LexerCompat.CATCH_:
        case Dart2LexerCompat.CLASS_:
        case Dart2LexerCompat.CONST_:
        case Dart2LexerCompat.CONTINUE_:
        case Dart2LexerCompat.COVARIANT_:
        case Dart2LexerCompat.DEFAULT_:
        case Dart2LexerCompat.DEFERRED_:
        case Dart2LexerCompat.DO_:
        case Dart2LexerCompat.DYNAMIC_:
        case Dart2LexerCompat.ELSE_:
        case Dart2LexerCompat.ENUM_:
        case Dart2LexerCompat.EXPORT_:
        case Dart2LexerCompat.EXTENDS_:
        case Dart2LexerCompat.EXTENSION_:
        case Dart2LexerCompat.EXTERNAL_:
        case Dart2LexerCompat.FACTORY_:
        case Dart2LexerCompat.FALSE_:
        case Dart2LexerCompat.FINAL_:
        case Dart2LexerCompat.FINALLY_:
        case Dart2LexerCompat.FOR_:
        case Dart2LexerCompat.FUNCTION_:
        case Dart2LexerCompat.GET_:
        case Dart2LexerCompat.HIDE_:
        case Dart2LexerCompat.IF_:
        case Dart2LexerCompat.IMPLEMENTS_:
        case Dart2LexerCompat.IMPORT_:
        case Dart2LexerCompat.IN_:
        case Dart2LexerCompat.INTERFACE_:
        case Dart2LexerCompat.IS_:
        case Dart2LexerCompat.LATE_:
        case Dart2LexerCompat.LIBRARY_:
        case Dart2LexerCompat.MIXIN_:
        case Dart2LexerCompat.NATIVE_:
        case Dart2LexerCompat.NEW_:
        case Dart2LexerCompat.NULL_:
        case Dart2LexerCompat.ON_:
        case Dart2LexerCompat.OPERATOR_:
        case Dart2LexerCompat.PART_:
        case Dart2LexerCompat.REQUIRED_:
        case Dart2LexerCompat.RETHROW_:
        case Dart2LexerCompat.RETURN_:
        case Dart2LexerCompat.SET_:
          span.text(data, color.getKeyword(), true);
          break;
        case Dart2LexerCompat.SHOW_:
        case Dart2LexerCompat.STATIC_:
        case Dart2LexerCompat.SUPER_:
        case Dart2LexerCompat.SWITCH_:
        case Dart2LexerCompat.SYNC_:
        case Dart2LexerCompat.THIS_:
        case Dart2LexerCompat.THROW_:
        case Dart2LexerCompat.TRUE_:
        case Dart2LexerCompat.TRY_:
        case Dart2LexerCompat.TYPEDEF_:
        case Dart2LexerCompat.VAR_:
        case Dart2LexerCompat.WHILE_:
        case Dart2LexerCompat.WITH_:
        case Dart2LexerCompat.YIELD_:
        case Dart2LexerCompat.VOID_:
          span.text(data, color.getOperator());
          break;
        case Dart2LexerCompat.STRING:
          span.fstring(
              data, color.getBracketlevel2(), color.getBracketlevel3(), color.getStrings());
          break;
          case Dart2LexerCompat.NUMBER: span.text(data,color.getLastsymi()); break;

        case Dart2LexerCompat.CB:
        case Dart2LexerCompat.CP:
        case Dart2LexerCompat.CBC:
        case Dart2LexerCompat.OB:
        case Dart2LexerCompat.OP:
        case Dart2LexerCompat.OBC:
        case Dart2LexerCompat.A:
        case Dart2LexerCompat.AA:
        case Dart2LexerCompat.AE:
        case Dart2LexerCompat.AT:
        case Dart2LexerCompat.C:
        case Dart2LexerCompat.CIR:
        case Dart2LexerCompat.CIRE:
        case Dart2LexerCompat.CO:
        case Dart2LexerCompat.D:
        case Dart2LexerCompat.DD:
        case Dart2LexerCompat.DDD:
        case Dart2LexerCompat.EE:
        case Dart2LexerCompat.EG:
        case Dart2LexerCompat.EQ:
        case Dart2LexerCompat.GT:
        case Dart2LexerCompat.LT:
        case Dart2LexerCompat.LTE:
        case Dart2LexerCompat.LTLT:
        case Dart2LexerCompat.LTLTE:
        case Dart2LexerCompat.ME:
        case Dart2LexerCompat.MINUS:
        case Dart2LexerCompat.MM:
        case Dart2LexerCompat.NE:
        case Dart2LexerCompat.P:
        case Dart2LexerCompat.PC:
        case Dart2LexerCompat.PL:
        case Dart2LexerCompat.PLE:
        case Dart2LexerCompat.PLPL:
        case Dart2LexerCompat.POE:
        case Dart2LexerCompat.PP:
        case Dart2LexerCompat.QU:
        case Dart2LexerCompat.QUD:
        case Dart2LexerCompat.QUDD:
        case Dart2LexerCompat.QUQU:
        case Dart2LexerCompat.QUQUEQ:
        case Dart2LexerCompat.SC:
        case Dart2LexerCompat.SE:
        case Dart2LexerCompat.SL:
        case Dart2LexerCompat.SQS:
        case Dart2LexerCompat.SQSE:
        case Dart2LexerCompat.SQUIG:
        case Dart2LexerCompat.ST:
        case Dart2LexerCompat.STE:
          span.text(data, color.getSymbol());
          break;

        case Dart2LexerCompat.IDENTIFIER:
          {
            int colorNormal = color.getTextnormal();
            boolean isClassName = false, isbold = false;
            if (pretoken == Dart2LexerCompat.CLASS_
                || pretoken == Dart2LexerCompat.INTERFACE_
                || pretoken == Dart2LexerCompat.ENUM_
                || pretoken == Dart2LexerCompat.EXTENDS_
                || pretoken == Dart2LexerCompat.IMPLEMENTS_) {
              colorNormal = color.getMethod();
              isbold = true;
              isClassName = true;
            } else if (pretoken == Dart2LexerCompat.VOID_
                || pretoken == Dart2LexerCompat.YIELD_
                || pretoken == Dart2LexerCompat.VAR_
                || pretoken == Dart2LexerCompat.IDENTIFIER) {
              colorNormal = color.getMethod();
              isbold = true;
              if (lexer._input.LA(1) == '(') {
                colorNormal = color.getLastsymi();
              }
            } else if (lexer._input.LA(1) == '.') {
              colorNormal = color.getLastdot();
            } else if (lexer._input.LA(1) == '[' || lexer._input.LA(1) == ']') {
              colorNormal = color.getPrebrak();
            } else if (lexer._input.LA(2) == '{') {
              colorNormal = color.getBracketlevel1();
              // '.'
            } else if (pretoken == Dart2LexerCompat.AT) {
              colorNormal = color.getSymbol();
            } else if (lexer._input.LA(":".length()) == ':') {
              colorNormal = color.getLastdot();
            } else if (pretoken == Dart2LexerCompat.D) {
              colorNormal = color.getPredot();
            } else if (!isClassName && Character.isUpperCase(token.getText().charAt(0))) {
              Pattern pattern = Pattern.compile("^[A-Z][a-zA-Z0-9_]*$");
              var matcher = pattern.matcher(token.getText());
              if (matcher.matches()) {
                colorNormal = color.getUppercase();
              }
            }

            span.text(token.getText(), colorNormal, isbold);
            break;
          }
        default:
          span.text(data, color.getTextnormal());
          break;
      }

      if (type != Dart2LexerCompat.WHITESPACE) {
        pretoken = type;
      }
      currentPosition += token.getText().length();
    }
    if (manager.getRainbowBracketsEnabled() && !bracketPositions.isEmpty()) {
      manager.applyRainbowBrackets(span, bracketPositions);
    }
    return span;
  }

  boolean isBracketToken(int type) {
    return type == Dart2LexerCompat.CB
        || type == Dart2LexerCompat.CP
        || type == Dart2LexerCompat.CBC
        || type == Dart2LexerCompat.OB
        || type == Dart2LexerCompat.OP
        || type == Dart2LexerCompat.OBC;
  }
}
