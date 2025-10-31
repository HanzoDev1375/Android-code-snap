package ir.ninjacoder.codesnap.Utils;

import ir.ninjacoder.codesnap.LangType;
import ir.ninjacoder.codesnap.antlr4.lua.LuaLexer;
import ir.ninjacoder.codesnap.colorhelper.ColorHelper;
import android.text.SpannableStringBuilder;
import ir.ninjacoder.codesnap.Utils.Highlighter;
import ir.ninjacoder.codesnap.widget.data.SpanStyler;
import java.io.StringReader;
import java.util.regex.Pattern;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;

public class CodeHighlighterLua implements Highlighter {

  @Override
  public SpannableStringBuilder highlight(LangType types, String code, ColorHelper color)
      throws Exception {
    SpanStyler span = SpanStyler.create();
    Token token;
    int type;
    int pretoken = -1;
    var lexer = new LuaLexer(CharStreams.fromReader(new StringReader(code)));

    while ((token = lexer.nextToken()) != null) {
      type = token.getType();
      if (type == LuaLexer.EOF) {
        break;
      }

      String tokenText = token.getText();

      switch (type) {
          // Whitespace and newlines
        case LuaLexer.WS:
        case LuaLexer.NL:
          span.addNullText(tokenText);
          break;

          // Keywords
        case LuaLexer.BREAK:
        case LuaLexer.GOTO:
        case LuaLexer.DO:
        case LuaLexer.END:
        case LuaLexer.WHILE:
        case LuaLexer.REPEAT:
        case LuaLexer.UNTIL:
        case LuaLexer.IF:
        case LuaLexer.THEN:
        case LuaLexer.ELSEIF:
        case LuaLexer.ELSE:
        case LuaLexer.FOR:
        case LuaLexer.IN:
        case LuaLexer.FUNCTION:
        case LuaLexer.LOCAL:
        case LuaLexer.RETURN:
        case LuaLexer.CONTINUE:
        case LuaLexer.NIL:
        case LuaLexer.FALSE:
        case LuaLexer.TRUE:
        case LuaLexer.NOT:
        case LuaLexer.AND:
        case LuaLexer.OR:
          span.text(tokenText, color.getKeyword(),true,false);
          break;

          // Operators
        case LuaLexer.LT:
        case LuaLexer.GT:
        case LuaLexer.LE:
        case LuaLexer.GE:
        case LuaLexer.EE:
        case LuaLexer.SQEQ:
        case LuaLexer.PLUS:
        case LuaLexer.MINUS:
        case LuaLexer.STAR:
        case LuaLexer.SLASH:
        case LuaLexer.SS:
        case LuaLexer.PER:
        case LuaLexer.AMP:
        case LuaLexer.PIPE:
        case LuaLexer.CARET:
        case LuaLexer.SQUIG:
        case LuaLexer.LL:
        case LuaLexer.GG:
        case LuaLexer.DD:
        case LuaLexer.DDD:
        case LuaLexer.POUND:
          span.text(tokenText, color.getCssoprator());
          break;

          // Punctuation and delimiters
        case LuaLexer.SEMI:
        case LuaLexer.COMMA:
        case LuaLexer.DOT:
        case LuaLexer.COL:
        case LuaLexer.CC:
        case LuaLexer.OP:
        case LuaLexer.CP:
        case LuaLexer.OCU:
        case LuaLexer.CCU:
        case LuaLexer.OB:
        case LuaLexer.CB:
        case LuaLexer.EQ:
          span.text(tokenText, color.getSymbol());
          break;

          // Strings
        case LuaLexer.NORMALSTRING:
        case LuaLexer.CHARSTRING:
        case LuaLexer.LONGSTRING:
          span.text(tokenText, color.getStrings());
          break;

          // Numbers
        case LuaLexer.INT:
        case LuaLexer.HEX:
        case LuaLexer.FLOAT:
        case LuaLexer.HEX_FLOAT:
          span.text(tokenText, color.getOperator());
          break;

        case LuaLexer.NAME:
          {
            int colorNormal = color.getTextnormal();
            boolean isClassName = false, isbold = false, isShadow = false;

            // تشخیص نام کلاس‌ها و تایپ‌ها
            if (pretoken == LuaLexer.FUNCTION
                || pretoken == LuaLexer.LOCAL
                || pretoken == LuaLexer.END) {
              colorNormal = color.getMethod();
              isShadow = true;
              isbold = true;
              isClassName = true;
            }
            // تشخیص توابع و متدها
            else if (pretoken == LuaLexer.COMMA
                || pretoken == LuaLexer.OP
                || pretoken == LuaLexer.EQ) {
              colorNormal = color.getVariable();
              isbold = true;
              // اگر بعد از شناسه پرانتز باز باشد، احتمالاً تابع است
              if (lexer._input.LA(1) == '(') {
                colorNormal = color.getPrebrak();
              }
            }
            // تشخیص پس از dot (متدها یا فیلدها)
            else if (lexer._input.LA(1) == '.') {
              colorNormal = color.getPredot();
            }
            // تشخیص پس از براکت
            else if (lexer._input.LA(1) == '[' || lexer._input.LA(1) == ']') {
              colorNormal = color.getBracketlevel1();
            }
            // تشخیص پس از dot
            else if (pretoken == LuaLexer.DOT) {
              colorNormal = color.getLastdot();
            }
            // تشخیص شناسه‌هایی که با حرف بزرگ شروع می‌شوند (معمولاً کلاس یا ثابت)
            else if (!isClassName && Character.isUpperCase(token.getText().charAt(0))) {
              Pattern pattern = Pattern.compile("^[A-Z][A-Z0-9_]*$");
              var matcher = pattern.matcher(token.getText());
              if (matcher.matches()) {
                // اگر تمام حروف بزرگ باشد (ثابت)
                colorNormal = color.getUppercase();
              }
            }

            // بررسی توابع built-in
            if (isBuiltInFunction(token.getText())) {
              colorNormal = color.getBracketlevel3();
              isbold = true;
            } else if (isBuiltInLibrary(token.getText())) {
              colorNormal = color.getBracketlevel4();
              isbold = true;
            }
            span.text(token.getText(), colorNormal, isbold, isShadow);
            break;
          }
          // Comments (hidden channel but we can still style them if needed)
        case LuaLexer.COMMENT:
          span.text(tokenText, color.getComment());
          break;

          // Shebang (hidden channel)
        case LuaLexer.SHEBANG:
          span.text(tokenText, color.getComment());
          break;

        default:
          span.text(tokenText, color.getTextnormal());
          break;
      }
      if (type != LuaLexer.WS && type != LuaLexer.NL) {
        pretoken = type;
      }
    }
    return span;
  }

  private boolean isBuiltInFunction(String name) {
    String[] builtInFunctions = {
      "print",
      "type",
      "tostring",
      "tonumber",
      "getmetatable",
      "setmetatable",
      "rawget",
      "rawset",
      "rawequal",
      "pairs",
      "ipairs",
      "next",
      "assert",
      "error",
      "pcall",
      "xpcall",
      "select",
      "load",
      "loadstring",
      "loadfile",
      "dofile",
      "require",
      "module",
      "collectgarbage",
      "getfenv",
      "setfenv"
    };

    for (String func : builtInFunctions) {
      if (func.equals(name)) {
        return true;
      }
    }
    return false;
  }

  private boolean isBuiltInLibrary(String name) {
    String[] builtInLibraries = {
      "string", "table", "math", "io", "os", "debug", "coroutine", "package"
    };

    for (String lib : builtInLibraries) {
      if (lib.equals(name)) {
        return true;
      }
    }
    return false;
  }
}
