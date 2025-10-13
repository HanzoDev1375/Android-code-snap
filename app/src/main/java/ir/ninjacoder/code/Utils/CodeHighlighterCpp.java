package ir.ninjacoder.code.Utils;

import android.text.style.ForegroundColorSpan;
import ir.ninjacoder.code.LangType;
import android.text.SpannableStringBuilder;
import ir.ninjacoder.code.Utils.Highlighter;
import ir.ninjacoder.code.antlr4.cpp.CPP14Lexer;
import ir.ninjacoder.code.bracket.BracketManager;
import ir.ninjacoder.code.colorhelper.ColorHelper;
import java.io.StringReader;
import java.util.List;
import ir.ninjacoder.code.bracket.BracketPosition;
import java.util.ArrayList;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;

public class CodeHighlighterCpp implements Highlighter {

  @Override
  public SpannableStringBuilder highlight(LangType types, String code) throws Exception {
    SpannableStringBuilder sb = new SpannableStringBuilder();
    CPP14Lexer lexer = new CPP14Lexer(CharStreams.fromReader(new StringReader(code)));
    ColorHelper colorHelper = new ColorHelper();
    BracketManager manager = new BracketManager();
    List<BracketPosition> bracketPositions = new ArrayList<>();
    int pretoken = -1;
    manager.setRainbowBracketsEnabled(true);

    Token token;
    int type = 0;
    int currentPosition = 0;
    while ((token = lexer.nextToken()) != null) {
      type = token.getType();
      if (type == CPP14Lexer.EOF) break;

      if (isBracketToken(type)) {
        bracketPositions.add(
            new BracketPosition(
                currentPosition,
                currentPosition + token.getText().length(),
                token.getText().charAt(0),
                type));
      }

      switch (type) {
        case CPP14Lexer.WS:
          sb.append(token.getText());
          break;

        case CPP14Lexer.Alignas:
        case CPP14Lexer.Alignof:
        case CPP14Lexer.Asm:
        case CPP14Lexer.Auto:
        case CPP14Lexer.Bool:
        case CPP14Lexer.Break:
        case CPP14Lexer.Case:
        case CPP14Lexer.Catch:
        case CPP14Lexer.Char:
        case CPP14Lexer.Char16:
        case CPP14Lexer.Char32:
        case CPP14Lexer.Class:
        case CPP14Lexer.Const:
        case CPP14Lexer.Constexpr:
        case CPP14Lexer.Const_cast:
        case CPP14Lexer.Continue:
        case CPP14Lexer.Decltype:
        case CPP14Lexer.Default:
        case CPP14Lexer.Delete:
        case CPP14Lexer.Do:
        case CPP14Lexer.Double:
        case CPP14Lexer.Dynamic_cast:
        case CPP14Lexer.Else:
        case CPP14Lexer.Enum:
        case CPP14Lexer.Explicit:
        case CPP14Lexer.Export:
        case CPP14Lexer.Extern:
        case CPP14Lexer.False_:
        case CPP14Lexer.Final:
        case CPP14Lexer.Float:
        case CPP14Lexer.For:
        case CPP14Lexer.Friend:
        case CPP14Lexer.Goto:
        case CPP14Lexer.If:
        case CPP14Lexer.Inline:
        case CPP14Lexer.Int:
        case CPP14Lexer.Long:
        case CPP14Lexer.Mutable:
        case CPP14Lexer.Namespace:
        case CPP14Lexer.New:
        case CPP14Lexer.Noexcept:
        case CPP14Lexer.Nullptr:
        case CPP14Lexer.Operator:
        case CPP14Lexer.Override:
        case CPP14Lexer.Private:
        case CPP14Lexer.Protected:
        case CPP14Lexer.Public:
        case CPP14Lexer.Register:
        case CPP14Lexer.Reinterpret_cast:
        case CPP14Lexer.Return:
        case CPP14Lexer.Short:
        case CPP14Lexer.Signed:
        case CPP14Lexer.Sizeof:
        case CPP14Lexer.Static:
        case CPP14Lexer.Static_assert:
        case CPP14Lexer.Static_cast:
        case CPP14Lexer.Struct:
        case CPP14Lexer.Switch:
        case CPP14Lexer.Template:
        case CPP14Lexer.This:
        case CPP14Lexer.Thread_local:
        case CPP14Lexer.Throw:
        case CPP14Lexer.True_:
        case CPP14Lexer.Try:
        case CPP14Lexer.Typedef:
        case CPP14Lexer.Typeid_:
        case CPP14Lexer.Typename_:
        case CPP14Lexer.Union:
        case CPP14Lexer.Unsigned:
        case CPP14Lexer.Using:
        case CPP14Lexer.Virtual:
        case CPP14Lexer.Void:
        case CPP14Lexer.Volatile:
        case CPP14Lexer.Wchar:
        case CPP14Lexer.While:
          sb.append(
              token.getText(),
              new ForegroundColorSpan(colorHelper.getKeyword()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
          break;

        case CPP14Lexer.StringLiteral:
        case CPP14Lexer.CharacterLiteral:
          sb.append(
              token.getText(),
              new ForegroundColorSpan(colorHelper.getStrings()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
          break;

        case CPP14Lexer.IntegerLiteral:
        case CPP14Lexer.FloatingLiteral:
        case CPP14Lexer.DecimalLiteral:
        case CPP14Lexer.OctalLiteral:
        case CPP14Lexer.HexadecimalLiteral:
        case CPP14Lexer.BinaryLiteral:
        case CPP14Lexer.Integersuffix:
          sb.append(
              token.getText(),
              new ForegroundColorSpan(colorHelper.getOperator()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
          break;

        case CPP14Lexer.LeftParen:
        case CPP14Lexer.RightParen:
        case CPP14Lexer.LeftBracket:
        case CPP14Lexer.RightBracket:
        case CPP14Lexer.LeftBrace:
        case CPP14Lexer.RightBrace:
        case CPP14Lexer.Plus:
        case CPP14Lexer.Minus:
        case CPP14Lexer.Star:
        case CPP14Lexer.Div:
        case CPP14Lexer.Mod:
        case CPP14Lexer.Caret:
        case CPP14Lexer.And:
        case CPP14Lexer.Or:
        case CPP14Lexer.Tilde:
        case CPP14Lexer.Not:
        case CPP14Lexer.Assign:
        case CPP14Lexer.Less:
        case CPP14Lexer.Greater:
        case CPP14Lexer.PlusAssign:
        case CPP14Lexer.MinusAssign:
        case CPP14Lexer.StarAssign:
        case CPP14Lexer.DivAssign:
        case CPP14Lexer.ModAssign:
        case CPP14Lexer.XorAssign:
        case CPP14Lexer.AndAssign:
        case CPP14Lexer.OrAssign:
        case CPP14Lexer.LeftShiftAssign:
        case CPP14Lexer.RightShiftAssign:
        case CPP14Lexer.Equal:
        case CPP14Lexer.NotEqual:
        case CPP14Lexer.LessEqual:
        case CPP14Lexer.GreaterEqual:
        case CPP14Lexer.AndAnd:
        case CPP14Lexer.OrOr:
        case CPP14Lexer.PlusPlus:
        case CPP14Lexer.MinusMinus:
        case CPP14Lexer.Comma:
        case CPP14Lexer.ArrowStar:
        case CPP14Lexer.Arrow:
        case CPP14Lexer.Question:
        case CPP14Lexer.Colon:
        case CPP14Lexer.Doublecolon:
        case CPP14Lexer.Semi:
        case CPP14Lexer.Dot:
        case CPP14Lexer.DotStar:
        case CPP14Lexer.Ellipsis:
          sb.append(
              token.getText(),
              new ForegroundColorSpan(colorHelper.getSymbol()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
          break;

        case CPP14Lexer.BlockComment:
        case CPP14Lexer.LineComment:
          sb.append(
              token.getText(),
              new ForegroundColorSpan(colorHelper.getComment()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
          break;

        case CPP14Lexer.Identifier:
          int colorNormal = colorHelper.getTextnormal();
          boolean isClassName = false;

          if (pretoken == CPP14Lexer.Class
              || pretoken == CPP14Lexer.Struct
              || pretoken == CPP14Lexer.Enum) {
            colorNormal = colorHelper.getMethod();
            isClassName = true;
          } else if (pretoken == CPP14Lexer.Void
              || pretoken == CPP14Lexer.Int
              || pretoken == CPP14Lexer.Float
              || pretoken == CPP14Lexer.Double
              || pretoken == CPP14Lexer.Char
              || pretoken == CPP14Lexer.Bool
              || pretoken == CPP14Lexer.Long
              || pretoken == CPP14Lexer.Short
              || pretoken == CPP14Lexer.Auto
              || pretoken == CPP14Lexer.Unsigned
              || pretoken == CPP14Lexer.Signed
              || pretoken == CPP14Lexer.Identifier) {
            if (lexer._input.LA(1) == '(') {
              colorNormal = colorHelper.getLastsymi();
            }
          } else if (lexer._input.LA(1) == '.') {
            colorNormal = colorHelper.getLastdot();
          } else if (lexer._input.LA(1) == '[' || lexer._input.LA(1) == ']') {
            colorNormal = colorHelper.getPrebrak();
          } else if (pretoken == CPP14Lexer.Dot || pretoken == CPP14Lexer.Arrow) {
            colorNormal = colorHelper.getPredot();
          } else if (!isClassName && Character.isUpperCase(token.getText().charAt(0))) {
            if (isPascalCase(token.getText())) {
              colorNormal = colorHelper.getUppercase();
            }
          }

          if (lexer._input.LA(2) == '#') {
            colorNormal = colorHelper.getVariable();
          }

          if (lexer._input.LA(1) == '<') {
            colorNormal = colorHelper.getMethod();
          }

          sb.append(
              token.getText(),
              new ForegroundColorSpan(colorNormal),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
          break;

        default:
          sb.append(
              token.getText(),
              new ForegroundColorSpan(colorHelper.getTextnormal()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
          break;
      }

      if (type != CPP14Lexer.WS) {
        pretoken = type;
      }
      currentPosition += token.getText().length();
    }

    if (manager.getRainbowBracketsEnabled() && !bracketPositions.isEmpty()) {
      manager.applyRainbowBrackets(sb, bracketPositions);
    }

    return sb;
  }

  private boolean isBracketToken(int type) {
    return type == CPP14Lexer.LeftParen
        || type == CPP14Lexer.RightParen
        || type == CPP14Lexer.LeftBracket
        || type == CPP14Lexer.RightBracket
        || type == CPP14Lexer.LeftBrace
        || type == CPP14Lexer.RightBrace;
  }

  private boolean isPascalCase(String text) {
    if (text == null || text.isEmpty()) return false;
    for (int i = 0; i < text.length(); i++) {
      if (!Character.isLetterOrDigit(text.charAt(i)) && text.charAt(i) != '_') {
        return false;
      }
    }
    return Character.isUpperCase(text.charAt(0));
  }
}
