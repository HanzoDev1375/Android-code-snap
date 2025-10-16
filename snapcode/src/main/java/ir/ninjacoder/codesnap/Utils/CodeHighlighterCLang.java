package ir.ninjacoder.codesnap.Utils;

import android.text.style.ForegroundColorSpan;
import ir.ninjacoder.codesnap.LangType;
import android.text.SpannableStringBuilder;
import ir.ninjacoder.codesnap.antlr4.clang.CLexer;
import ir.ninjacoder.codesnap.bracket.BracketManager;
import ir.ninjacoder.codesnap.colorhelper.ColorHelper;
import java.io.StringReader;
import java.util.List;
import ir.ninjacoder.codesnap.bracket.BracketPosition;
import java.util.ArrayList;
import java.util.regex.Pattern;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;

public class CodeHighlighterCLang implements Highlighter {

  @Override
  public SpannableStringBuilder highlight(LangType types, String code, ColorHelper color)
      throws Exception {
    var builder = new SpannableStringBuilder();

    Token token;
    int type;
    int pretoken = -1;
    BracketManager manager = new BracketManager();
    CLexer lexer = new CLexer(CharStreams.fromReader(new StringReader(code)));
    List<BracketPosition> bracketPositions = new ArrayList<>();
    int currentPosition = 0;
    manager.setRainbowBracketsEnabled(true);
    while ((token = lexer.nextToken()) != null) {
      type = token.getType();
      if (type == CLexer.EOF) break;
      if (isBracketToken(type)) {
        bracketPositions.add(
            new BracketPosition(
                currentPosition,
                currentPosition + token.getText().length(),
                token.getText().charAt(0),
                type));
      }
      switch (type) {
        case CLexer.Whitespace:
        case CLexer.Newline:
          builder.append(token.getText());
          break;
        case CLexer.Auto:
        case CLexer.Break:
        case CLexer.Case:
        case CLexer.Char:
        case CLexer.Const:
        case CLexer.Continue:
        case CLexer.Default:
        case CLexer.Do:
        case CLexer.Double:
        case CLexer.Else:
        case CLexer.Enum:
        case CLexer.Extern:
        case CLexer.Float:
        case CLexer.For:
        case CLexer.Goto:
        case CLexer.If:
        case CLexer.Inline:
        case CLexer.Int:
        case CLexer.Long:
        case CLexer.Register:
        case CLexer.Restrict:
        case CLexer.Return:
        case CLexer.Short:
        case CLexer.Signed:
        case CLexer.Sizeof:
        case CLexer.Static:
        case CLexer.Struct:
        case CLexer.Switch:
        case CLexer.Typedef:
        case CLexer.Union:
        case CLexer.Unsigned:
        case CLexer.Void:
        case CLexer.Volatile:
        case CLexer.While:
        case CLexer.Alignas:
        case CLexer.Alignof:
        case CLexer.Atomic:
        case CLexer.Bool:
        case CLexer.Complex:
        case CLexer.Generic:
        case CLexer.Imaginary:
        case CLexer.Noreturn:
        case CLexer.StaticAssert:
        case CLexer.ThreadLocal:
          builder.append(
              token.getText(),
              new ForegroundColorSpan(color.getKeyword()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
          break;

        case CLexer.LeftParen:
        case CLexer.RightParen:
        case CLexer.LeftBracket:
        case CLexer.RightBracket:
        case CLexer.LeftBrace:
        case CLexer.RightBrace:
        case CLexer.Less:
        case CLexer.LessEqual:
        case CLexer.Greater:
        case CLexer.GreaterEqual:
        case CLexer.LeftShift:
        case CLexer.RightShift:
        case CLexer.Plus:
        case CLexer.PlusPlus:
        case CLexer.Minus:
        case CLexer.MinusMinus:
        case CLexer.Star:
        case CLexer.Div:
        case CLexer.Mod:
        case CLexer.And:
        case CLexer.Or:
        case CLexer.AndAnd:
        case CLexer.OrOr:
        case CLexer.Caret:
        case CLexer.Not:
        case CLexer.Tilde:
        case CLexer.Question:
        case CLexer.Colon:
        case CLexer.Semi:
        case CLexer.Comma:
        case CLexer.Assign:
        case CLexer.StarAssign:
        case CLexer.DivAssign:
        case CLexer.ModAssign:
        case CLexer.PlusAssign:
        case CLexer.MinusAssign:
        case CLexer.LeftShiftAssign:
        case CLexer.RightShiftAssign:
        case CLexer.AndAssign:
        case CLexer.XorAssign:
        case CLexer.OrAssign:
        case CLexer.Equal:
        case CLexer.NotEqual:
        case CLexer.Arrow:
        case CLexer.Dot:
        case CLexer.Ellipsis:
          builder.append(
              token.getText(),
              new ForegroundColorSpan(color.getSymbol()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
          break;
        case CLexer.Identifier:
          {
            int col = color.getTextnormal();
            String text = token.getText();
            if (pretoken == CLexer.Struct || pretoken == CLexer.Typedef) {
              col = color.getMethod(); // تعریف type یا struct
            } else if (pretoken == CLexer.Dot || pretoken == CLexer.Arrow) {
              col = color.getPredot(); // دسترسی به member
            } else if (pretoken == CLexer.Int
                || pretoken == CLexer.Void
                || pretoken == CLexer.Float
                || pretoken == CLexer.Double
                || pretoken == CLexer.Char
                || pretoken == CLexer.Bool
                || pretoken == CLexer.Short
                || pretoken == CLexer.Long
                || pretoken == CLexer.Unsigned
                || pretoken == CLexer.Signed
                || pretoken == CLexer.Identifier) {
              if (ObjectUtils.getNextLexer(lexer, '(')) {
                col = color.getLastsymi(); 
              } else {
                col = color.getMethod();
              }
            } else if (pretoken == CLexer.Return) {
              col = color.getVariable();
            }
            if (ObjectUtils.getNextLexer(lexer, '(')) {
              col = color.getLastsymi(); 
            } else if (ObjectUtils.getNextLexer(lexer, '.')) {
              col = color.getLastdot();
            } else if (ObjectUtils.getNextLexer(lexer, '[')) {
              col = color.getPrebrak();
            }

          
            if (Character.isUpperCase(text.charAt(0))) {
              Pattern p = Pattern.compile("^[A-Z][a-zA-Z0-9_]*$");
              if (p.matcher(text).matches()) {
                col = color.getUppercase();
              }
            }

            builder.append(
                text,
                new ForegroundColorSpan(col),
                SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
            break;
          }
        case CLexer.Constant:
        case CLexer.DigitSequence:
          builder.append(
              token.getText(),
              new ForegroundColorSpan(color.getOperator()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
          break;
        case CLexer.StringLiteral:
          builder.append(
              token.getText(),
              new ForegroundColorSpan(color.getStrings()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
          break;
        case CLexer.MultiLineMacro:
        case CLexer.Directive:
        case CLexer.AsmBlock:
          builder.append(
              token.getText(),
              new ForegroundColorSpan(color.getVariable()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
          break;
        case CLexer.BlockComment:
        case CLexer.LineComment:
          builder.append(
              token.getText(),
              new ForegroundColorSpan(color.getComment()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
          break;
        default:
          builder.append(
              token.getText(),
              new ForegroundColorSpan(color.getTextnormal()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
          break;
      }
      if (type != CLexer.Whitespace && type != CLexer.Newline) {
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
    return type == CLexer.LeftParen
        || type == CLexer.RightParen
        || type == CLexer.LeftBracket
        || type == CLexer.RightBracket
        || type == CLexer.LeftBrace
        || type == CLexer.RightBrace;
  }
}
