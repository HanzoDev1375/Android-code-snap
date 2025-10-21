package ir.ninjacoder.codesnap.Utils;

import ir.ninjacoder.codesnap.LangType;
import ir.ninjacoder.codesnap.antlr4.golang.GoLexer;
import ir.ninjacoder.codesnap.bracket.BracketManager;
import java.util.List;
import ir.ninjacoder.codesnap.bracket.BracketPosition;
import java.util.ArrayList;
import ir.ninjacoder.codesnap.antlr4.dart.Dart2LexerCompat;
import ir.ninjacoder.codesnap.colorhelper.ColorHelper;
import android.text.SpannableStringBuilder;
import ir.ninjacoder.codesnap.Utils.Highlighter;
import ir.ninjacoder.codesnap.widget.data.SpanStyler;
import java.io.StringReader;
import java.util.regex.Pattern;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;

public class CodeHighlighterGo implements Highlighter {

  @Override
  public SpannableStringBuilder highlight(LangType types, String code, ColorHelper color)
      throws Exception {
    SpanStyler span = SpanStyler.create();
    var lexer = new GoLexer(CharStreams.fromReader(new StringReader(code)));
    Token token;
    int type;
    int pretoken = -1;
    var manager = new BracketManager();
    List<BracketPosition> bracketPositions = new ArrayList<>();
    int currentPosition = 0;
    manager.setRainbowBracketsEnabled(true);
    while ((token = lexer.nextToken()) != null) {
      type = token.getType();
      String data = token.getText();
      if (type == GoLexer.EOF) break;
      if (type == Dart2LexerCompat.EOF) break;
      if (isBracketToken(type)) {
        bracketPositions.add(
            new BracketPosition(
                currentPosition,
                currentPosition + token.getText().length(),
                token.getText().charAt(0),
                type));
      }
      switch (type) {
        case GoLexer.WS:
        case GoLexer.TERMINATOR:
          span.addNullText(data);
          break;
        case GoLexer.BREAK:
        case GoLexer.CASE:
        case GoLexer.CHAN:
        case GoLexer.CONST:
        case GoLexer.CONTINUE:
        case GoLexer.DEFAULT:
        case GoLexer.DEFER:
        case GoLexer.ELSE:
        case GoLexer.FALLTHROUGH:
        case GoLexer.FOR:
        case GoLexer.FUNC:
        case GoLexer.GO:
        case GoLexer.GOTO:
        case GoLexer.IF:
        case GoLexer.IMPORT:
        case GoLexer.INTERFACE:
        case GoLexer.MAP:
        case GoLexer.NIL_LIT:
        case GoLexer.PACKAGE:
        case GoLexer.RANGE:
        case GoLexer.RETURN:
        case GoLexer.SELECT:
        case GoLexer.STRUCT:
        case GoLexer.SWITCH:
        case GoLexer.TYPE:
        case GoLexer.VAR:
          span.text(data, color.getKeyword());
          break;
        case GoLexer.L_PAREN:
        case GoLexer.R_PAREN:
        case GoLexer.L_CURLY:
        case GoLexer.R_CURLY:
        case GoLexer.L_BRACKET:
        case GoLexer.R_BRACKET:
        case GoLexer.ASSIGN:
        case GoLexer.COMMA:
        case GoLexer.SEMI:
        case GoLexer.COLON:
        case GoLexer.DOT:
        case GoLexer.PLUS_PLUS:
        case GoLexer.MINUS_MINUS:
        case GoLexer.DECLARE_ASSIGN:
        case GoLexer.ELLIPSIS:
        case GoLexer.LOGICAL_OR:
        case GoLexer.LOGICAL_AND:
        case GoLexer.EQUALS:
        case GoLexer.NOT_EQUALS:
        case GoLexer.LESS:
        case GoLexer.LESS_OR_EQUALS:
        case GoLexer.GREATER:
        case GoLexer.GREATER_OR_EQUALS:
        case GoLexer.OR:
        case GoLexer.DIV:
        case GoLexer.MOD:
        case GoLexer.LSHIFT:
        case GoLexer.RSHIFT:
        case GoLexer.BIT_CLEAR:
        case GoLexer.UNDERLYING:
        case GoLexer.EXCLAMATION:
        case GoLexer.PLUS:
        case GoLexer.MINUS:
        case GoLexer.CARET:
        case GoLexer.STAR:
        case GoLexer.AMPERSAND:
        case GoLexer.RECEIVE:
          span.text(data, color.getSymbol());
          break;

        case GoLexer.DECIMAL_LIT:
        case GoLexer.BINARY_LIT:
        case GoLexer.OCTAL_LIT:
        case GoLexer.HEX_LIT:
        case GoLexer.FLOAT_LIT:
          span.text(data, color.getOperator());
          break;
        case GoLexer.RAW_STRING_LIT:
        case GoLexer.INTERPRETED_STRING_LIT:
          span.text(data, color.getStrings());
          break;
        case GoLexer.COMMENT:
        case GoLexer.LINE_COMMENT:
          span.commentjs(
              data,
              color.getBracketlevel1(),
              color.getBracketlevel2(),
              color.getBracketlevel4(),
              color.getComment());
          break;
        case GoLexer.IDENTIFIER:
          {
            int colorNormal = color.getTextnormal();
            boolean isClassName = false, isbold = false;

            if (pretoken == GoLexer.STRUCT
                || pretoken == GoLexer.INTERFACE
                || pretoken == GoLexer.TYPE
                || pretoken == GoLexer.FUNC) {
              colorNormal = color.getMethod();
              isbold = true;
              isClassName = true;
            } else if (pretoken == GoLexer.VAR
                || pretoken == GoLexer.CONST
                || pretoken == GoLexer.PACKAGE
                || pretoken == GoLexer.IMPORT
                || pretoken == GoLexer.IDENTIFIER) {
              colorNormal = color.getMethod();
              isbold = true;
              if (lexer._input.LA("(".length()) == '(') {
                colorNormal = color.getLastsymi();
              }
            } else if (lexer._input.LA(1) == '.') {
              colorNormal = color.getLastdot();
            } else if (lexer._input.LA(1) == '[' || lexer._input.LA(1) == ']') {
              colorNormal = color.getPrebrak();
            } else if (lexer._input.LA(2) == '{') {
              colorNormal = color.getBracketlevel1();
            } else if (pretoken == GoLexer.DOT) {
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
      if (type != GoLexer.WS && type != GoLexer.TERMINATOR) {
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
    return type == GoLexer.L_PAREN
        || type == GoLexer.R_PAREN
        || type == GoLexer.L_CURLY
        || type == GoLexer.R_CURLY
        || type == GoLexer.L_BRACKET;
  }
}
