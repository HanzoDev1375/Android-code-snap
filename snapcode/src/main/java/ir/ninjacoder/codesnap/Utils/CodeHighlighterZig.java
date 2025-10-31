package ir.ninjacoder.codesnap.Utils;

import ir.ninjacoder.codesnap.LangType;
import ir.ninjacoder.codesnap.antlr4.zig.ZigLexer;
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

public class CodeHighlighterZig implements Highlighter {

  @Override
  public SpannableStringBuilder highlight(LangType types, String code, ColorHelper color)
      throws Exception {
    var span = SpanStyler.create();
    int type;
    var pretoken = -1;
    Token token;
    BracketManager manager = new BracketManager();
    List<BracketPosition> bracketPositions = new ArrayList<>();
    int currentPosition = 0;
    manager.setRainbowBracketsEnabled(true);
    var lexer = new ZigLexer(CharStreams.fromReader(new StringReader(code)));
    while ((token = lexer.nextToken()) != null) {
      type = token.getType();
      if (type == ZigLexer.EOF) {
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
        case ZigLexer.WHITESPACE:
          span.addNullText(token.getText());
          break;
        case ZigLexer.ADDRSPACE:
        case ZigLexer.ALIGN:
        case ZigLexer.ALLOWZERO:
        case ZigLexer.AND:
        case ZigLexer.ANYFRAME:
        case ZigLexer.ANYTYPE:
        case ZigLexer.ASM:
        case ZigLexer.BREAK:
        case ZigLexer.CALLCONV:
        case ZigLexer.CATCH:
        case ZigLexer.COMPTIME:
        case ZigLexer.CONST:
        case ZigLexer.CONTINUE:
        case ZigLexer.DEFER:
        case ZigLexer.ELSE:
        case ZigLexer.ENUM:
        case ZigLexer.ERRDEFER:
        case ZigLexer.ERROR:
        case ZigLexer.EXPORT:
        case ZigLexer.EXTERN:
        case ZigLexer.FN:
        case ZigLexer.FOR:
        case ZigLexer.IF:
        case ZigLexer.INLINE:
        case ZigLexer.LINKSECTION:
        case ZigLexer.NOALIAS:
        case ZigLexer.NOINLINE:
        case ZigLexer.NOSUSPEND:
        case ZigLexer.OPAQUE:
        case ZigLexer.OR:
        case ZigLexer.ORELSE:
        case ZigLexer.PACKED:
        case ZigLexer.PUB:
        case ZigLexer.RESUME:
        case ZigLexer.RETURN:
        case ZigLexer.STRUCT:
        case ZigLexer.SUSPEND:
        case ZigLexer.SWITCH:
        case ZigLexer.TEST:
        case ZigLexer.THREADLOCAL:
        case ZigLexer.TRY:
        case ZigLexer.UNION:
        case ZigLexer.UNREACHABLE:
        case ZigLexer.VAR:
        case ZigLexer.VOLATILE:
        case ZigLexer.WHILE:
          span.text(token.getText(), color.getKeyword(), true, false);
          break;
        case ZigLexer.AMPERSAND:
        case ZigLexer.AMPERSANDEQUAL:
        case ZigLexer.ASTERISK:
        case ZigLexer.ASTERISK2:
        case ZigLexer.ASTERISKEQUAL:
        case ZigLexer.ASTERISKPERCENT:
        case ZigLexer.ASTERISKPERCENTEQUAL:
        case ZigLexer.ASTERISKPIPE:
        case ZigLexer.ASTERISKPIPEEQUAL:
        case ZigLexer.CARET:
        case ZigLexer.CARETEQUAL:
        case ZigLexer.COLON:
        case ZigLexer.COMMA:
        case ZigLexer.DOT:
        case ZigLexer.DOT2:
        case ZigLexer.DOT3:
        case ZigLexer.DOTASTERISK:
        case ZigLexer.DOTQUESTIONMARK:
        case ZigLexer.EQUAL:
        case ZigLexer.EQUALEQUAL:
        case ZigLexer.BUILTINIDENTIFIER:
        case ZigLexer.EQUALRARROW:
        case ZigLexer.EXCLAMATIONMARK:
        case ZigLexer.EXCLAMATIONMARKEQUAL:
        case ZigLexer.LARROW:
        case ZigLexer.LARROW2:
        case ZigLexer.LARROW2EQUAL:
        case ZigLexer.LARROW2PIPE:
        case ZigLexer.LARROW2PIPEEQUAL:
        case ZigLexer.LARROWEQUAL:
        case ZigLexer.LBRACE:
        case ZigLexer.LBRACKET:
        case ZigLexer.LPAREN:
        case ZigLexer.MINUS:
        case ZigLexer.MINUSEQUAL:
        case ZigLexer.MINUSPERCENT:
        case ZigLexer.MINUSPERCENTEQUAL:
        case ZigLexer.MINUSPIPE:
        case ZigLexer.MINUSPIPEEQUAL:
        case ZigLexer.MINUSRARROW:
        case ZigLexer.PERCENT:
        case ZigLexer.PERCENTEQUAL:
        case ZigLexer.PIPE:
        case ZigLexer.PIPE2:
        case ZigLexer.PIPEEQUAL:
        case ZigLexer.PLUS:
        case ZigLexer.PLUS2:
        case ZigLexer.PLUSEQUAL:
        case ZigLexer.PLUSPERCENT:
        case ZigLexer.PLUSPERCENTEQUAL:
        case ZigLexer.PLUSPIPE:
        case ZigLexer.PLUSPIPEEQUAL:
        case ZigLexer.LETTERC:
        case ZigLexer.QUESTIONMARK:
        case ZigLexer.RARROW:
        case ZigLexer.RARROW2:
        case ZigLexer.RARROW2EQUAL:
        case ZigLexer.RARROWEQUAL:
        case ZigLexer.RBRACE:
        case ZigLexer.RBRACKET:
        case ZigLexer.RPAREN:
        case ZigLexer.SEMICOLON:
        case ZigLexer.SLASH:
        case ZigLexer.SLASHEQUAL:
        case ZigLexer.TILDE:
          span.text(token.getText(), color.getSymbol());
          break;
        case ZigLexer.Container_doc_comment:
        case ZigLexer.Doc_comment:
        case ZigLexer.Line_comment:
          span.commentjs(
              token.getText(),
              color.getBracketlevel3(),
              color.getBracketlevel1(),
              color.getBracketlevel2(),
              color.getComment());
          break;
        case ZigLexer.INTEGER:
        case ZigLexer.FLOAT:
          span.text(token.getText(), color.getOperator());
          break;
        case ZigLexer.STRINGLITERAL:
        case ZigLexer.CHAR_LITERAL:
          span.text(token.getText(), color.getStrings());
          break;
        case ZigLexer.IDENTIFIER:
          {
            int mcolor = color.getTextnormal();
            boolean isBold = false;
            boolean isClassName = false;
            boolean isShadow = false;

            if (pretoken == ZigLexer.CONST || pretoken == ZigLexer.VAR) {
              mcolor = color.getLastsymi();
              isBold = true;
            } else if (pretoken == ZigLexer.FN
                || pretoken == ZigLexer.STRUCT
                || pretoken == ZigLexer.ENUM
                || pretoken == ZigLexer.UNION) {
              mcolor = color.getMethod();
              isShadow = true;
              isBold = true;
              isClassName = true;
            } else if (pretoken == ZigLexer.COMPTIME) {
              mcolor = color.getMethod();
              isBold = true;
              if (lexer._input.LA(1) == '(') {
                mcolor = color.getLastsymi();
              }
            } else if (lexer._input.LA(1) == '.') {
              mcolor = color.getLastdot();
            } else if (lexer._input.LA(1) == '[' || lexer._input.LA(1) == ']') {
              mcolor = color.getPrebrak();
            } else if (lexer._input.LA(2) == '{') {
              mcolor = color.getBracketlevel1();
            } else if (pretoken == ZigLexer.DOT) {
              mcolor = color.getPredot();
            } else if (!isClassName && Character.isUpperCase(token.getText().charAt(0))) {
              Pattern pattern = Pattern.compile("^[A-Z][a-zA-Z0-9_]*$");
              var matcher = pattern.matcher(token.getText());
              if (matcher.matches()) {
                mcolor = color.getUppercase();
              }
            }

            span.text(token.getText(), mcolor, isBold, isShadow);
            break;
          }
        default:
          span.text(token.getText(), color.getTextnormal());
          break;
      }

      if (type != ZigLexer.WHITESPACE) {
        pretoken = type;
      }
      currentPosition += token.getText().length();
    }
    if (manager.getRainbowBracketsEnabled() && !bracketPositions.isEmpty()) {
      manager.applyRainbowBrackets(span, bracketPositions);
    }
    return span;
  }

  private boolean isBracketToken(int tokenType) {
    return tokenType == ZigLexer.LPAREN
        || tokenType == ZigLexer.RPAREN
        || tokenType == ZigLexer.LBRACE
        || tokenType == ZigLexer.RBRACE
        || tokenType == ZigLexer.LBRACKET
        || tokenType == ZigLexer.RBRACKET;
  }
}
