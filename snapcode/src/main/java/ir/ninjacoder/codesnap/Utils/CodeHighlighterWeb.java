package ir.ninjacoder.codesnap.Utils;

import android.graphics.Color;
import android.graphics.Typeface;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import androidx.core.graphics.ColorUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ir.ninjacoder.codesnap.LangType;
import android.text.SpannableStringBuilder;
import ir.ninjacoder.codesnap.Utils.ObjectUtils;
import ir.ninjacoder.codesnap.antlr4.web.HTMLLexer;
import ir.ninjacoder.codesnap.bracket.BracketManager;
import ir.ninjacoder.codesnap.bracket.BracketPosition;
import ir.ninjacoder.codesnap.colorhelper.ColorHelper;
import ir.ninjacoder.codesnap.colorhelper.css.CSSJsonColor;
import ir.ninjacoder.codesnap.colorhelper.css.CssColorModel;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;

public class CodeHighlighterWeb implements Highlighter {

  @Override
  public SpannableStringBuilder highlight(LangType types, String code, ColorHelper color)
      throws Exception {
    var builder = new SpannableStringBuilder();
    var lexer = new HTMLLexer(CharStreams.fromReader(new StringReader(code)));
    Token token;

    var manager = new BracketManager();
    List<BracketPosition> bracketPositions = new ArrayList<>();
    int pretoken = -1;
    int type;
    int currentPosition = 0;
    manager.setRainbowBracketsEnabled(true);
    while ((token = lexer.nextToken()) != null) {
      type = token.getType();
      if (type == HTMLLexer.EOF) {
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
        case HTMLLexer.WS:
          builder.append(token.getText());
          break;
        case HTMLLexer.ABSTRACT:
        case HTMLLexer.ASSERT:
        case HTMLLexer.BREAK:
        case HTMLLexer.CASE:
        case HTMLLexer.CATCH:
        case HTMLLexer.CLASS:
        case HTMLLexer.CONST:
        case HTMLLexer.CONTINUE:
        case HTMLLexer.DEFAULT:
        case HTMLLexer.DO:
        case HTMLLexer.ELSE:
        case HTMLLexer.EXTENDS:
        case HTMLLexer.FINAL:
        case HTMLLexer.FINALLY:
        case HTMLLexer.FOR:
        case HTMLLexer.IF:
        case HTMLLexer.GOTO:
        case HTMLLexer.IMPLEMENTS:
        case HTMLLexer.IMPORT:
        case HTMLLexer.INSTANCEOF:
        case HTMLLexer.INTERFACE:
        case HTMLLexer.NATIVE:
        case HTMLLexer.NEW:
        case HTMLLexer.PACKAGE:
        case HTMLLexer.PRIVATE:
        case HTMLLexer.PROTECTED:
        case HTMLLexer.PUBLIC:
        case HTMLLexer.RETURN:
        case HTMLLexer.STATIC:
        case HTMLLexer.STRICTFP:
        case HTMLLexer.SUPER:
        case HTMLLexer.SWITCH:
        case HTMLLexer.SYNCHRONIZED:
        case HTMLLexer.THIS:
        case HTMLLexer.THROW:
        case HTMLLexer.THROWS:
        case HTMLLexer.TRANSIENT:
        case HTMLLexer.TRY:
        case HTMLLexer.VOID:
        case HTMLLexer.VOLATILE:
        case HTMLLexer.WHILE:
        case HTMLLexer.VAR:
        case HTMLLexer.FUNCTION:
        case HTMLLexer.LET:
        case HTMLLexer.DEBUGGER:
        case HTMLLexer.YELD:
        case HTMLLexer.BYTE:
        case HTMLLexer.CHAR:
        case HTMLLexer.DOUBLE:
        case HTMLLexer.ENUM:
        case HTMLLexer.FLOAT:
        case HTMLLexer.INT:
        case HTMLLexer.LONG:
        case HTMLLexer.SHORT:
        case HTMLLexer.BOOLEAN:
          builder.append(
              token.getText(),
              new ForegroundColorSpan(color.getKeyword()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
          break;
        case HTMLLexer.DECIMAL_LITERAL:
        case HTMLLexer.OCT_LITERAL:
        case HTMLLexer.BINARY_LITERAL:
        case HTMLLexer.FLOAT_LITERAL:
        case HTMLLexer.HEX_FLOAT_LITERAL:
        case HTMLLexer.BOOL_LITERAL:
        case HTMLLexer.NULL_LITERAL:
          builder.append(
              token.getText(),
              new ForegroundColorSpan(color.getOperator()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
          break;
        case HTMLLexer.PhpFuns:
        case HTMLLexer.CSSKEYWORD:
          builder.append(
              token.getText(),
              new ForegroundColorSpan(color.getCsskeyword()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
          break;
        case HTMLLexer.CSSDOMATTR:
          builder.append(
              token.getText(),
              new ForegroundColorSpan(color.getCssoprator()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
          break;
        case HTMLLexer.CHATREF:
        case HTMLLexer.STRING:
          builder.append(
              token.getText(),
              new ForegroundColorSpan(color.getStrings()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
          break;
        case HTMLLexer.HtmlAttr:
          builder.append(
              token.getText(),
              new ForegroundColorSpan(color.getHtmlattr()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
          break;
        case HTMLLexer.LPAREN:
        case HTMLLexer.LBRACK:
        case HTMLLexer.RPAREN:
        case HTMLLexer.RBRACK:
        case HTMLLexer.SEMI:
        case HTMLLexer.COMMA:
        case HTMLLexer.ASSIGN:
        case HTMLLexer.BANG:
        case HTMLLexer.TILDE:
        case HTMLLexer.QUESTION:
        case HTMLLexer.COLON:
        case HTMLLexer.EQUAL:
        case HTMLLexer.GE:
        case HTMLLexer.LE:
        case HTMLLexer.NOTEQUAL:
        case HTMLLexer.AND:
        case HTMLLexer.OR:
        case HTMLLexer.INC:
        case HTMLLexer.DEC:
        case HTMLLexer.ADD:
        case HTMLLexer.SUB:
        case HTMLLexer.MUL:
        case HTMLLexer.BITAND:
        case HTMLLexer.BITOR:
        case HTMLLexer.CARET:
        case HTMLLexer.MOD:
        case HTMLLexer.HASH:
        case HTMLLexer.ADD_ASSIGN:
        case HTMLLexer.SUB_ASSIGN:
        case HTMLLexer.MUL_ASSIGN:
        case HTMLLexer.DIV_ASSIGN:
        case HTMLLexer.AND_ASSIGN:
        case HTMLLexer.OR_ASSIGN:
        case HTMLLexer.XOR_ASSIGN:
        case HTMLLexer.MOD_ASSIGN:
        case HTMLLexer.LSHIFT_ASSIGN:
        case HTMLLexer.RSHIFT_ASSIGN:
        case HTMLLexer.URSHIFT_ASSIGN:
        case HTMLLexer.ARROW:
        case HTMLLexer.COLONCOLON:
        case HTMLLexer.ELLIPSIS:
        case HTMLLexer.DOT:
        case HTMLLexer.DOLLAR:
        case HTMLLexer.DIV:
        case HTMLLexer.AT:
        case HTMLLexer.GT:
        case HTMLLexer.LT:
        case HTMLLexer.OPEN_SLASH:
        case HTMLLexer.SLASH_CLOSE:
          builder.append(
              token.getText(),
              new ForegroundColorSpan(color.getSymbol()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
          break;

        case HTMLLexer.BLOCK_COMMENT:
        case HTMLLexer.LINE_COMMENT:
          builder.append(
              token.getText(),
              new ForegroundColorSpan(color.getComment()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
          break;
        case HTMLLexer.HtmlTags:
        case HTMLLexer.HtmlTagOne:
          builder.append(
              token.getText(),
              new ForegroundColorSpan(color.getHtmlkeyword()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
          break;
        case HTMLLexer.IDENTIFIER:
          {
            var text = token.getText();
            int start = builder.length();
            int colorid = color.getTextnormal();
            if (ObjectUtils.getNextLexer(lexer, '.')) {
              colorid = color.getLastdot();
            }
            try {
              List<CssColorModel> listcolor =
                  new Gson()
                      .fromJson(
                          new StringReader(CSSJsonColor.getCssColor()),
                          new TypeToken<List<CssColorModel>>() {}.getType());

              boolean colorApplied = false;
              for (var it : listcolor) {

                Pattern pattern = Pattern.compile("\\b" + Pattern.quote(it.getName()) + "\\b");
                Matcher matcher = pattern.matcher(text);
                if (it.getName().startsWith("#") || it.getName().startsWith(".")) {
                  break;
                }
                if (matcher.find()) {
                  int backgroundColor = Color.parseColor(it.getDesc());

                  int textColor;
                  if (ColorUtils.calculateLuminance(backgroundColor) > 0.5) {
                    textColor = Color.BLACK;
                  } else {
                    textColor = Color.WHITE;
                  }

                  builder.append(text);
                  var b = new BackgroundColorSpan(backgroundColor);

                  builder.setSpan(
                      b,
                      start,
                      start + text.length(),
                      SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
                  builder.setSpan(
                      new StyleSpan(Typeface.BOLD),
                      start,
                      start + text.length(),
                      SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
                  builder.setSpan(
                      new ForegroundColorSpan(textColor),
                      start,
                      start + text.length(),
                      SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
                  colorApplied = true;
                  break;
                }
              }
              if (!colorApplied) {
                builder.append(text);
                builder.setSpan(
                    new ForegroundColorSpan(colorid),
                    start,
                    start + text.length(),
                    SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
              }

            } catch (Exception err) {
              builder.append(text);
              builder.setSpan(
                  new ForegroundColorSpan(color.getTextnormal()),
                  start,
                  start + text.length(),
                  SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
              Log.e("Error", err.getLocalizedMessage());
            }
            break;
          }
        default:
          builder.append(
              token.getText(),
              new ForegroundColorSpan(color.getTextnormal()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
          break;
      }
      if (type != HTMLLexer.WS) {
        pretoken = type;
      }
      currentPosition += token.getText().length();
    }
    if (manager.getRainbowBracketsEnabled() && !bracketPositions.isEmpty()) {
      manager.applyRainbowBrackets(builder, bracketPositions);
    }

    return builder;
  }

  private boolean isBracketToken(int tokenType) {
    return tokenType == HTMLLexer.LPAREN
        || tokenType == HTMLLexer.RPAREN
        || tokenType == HTMLLexer.LBRACE
        || tokenType == HTMLLexer.RBRACE
        || tokenType == HTMLLexer.LBRACK
        || tokenType == HTMLLexer.RBRACK;
  }
}
