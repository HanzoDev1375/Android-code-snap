package ir.ninjacoder.code.Utils;

import android.text.style.ForegroundColorSpan;
import ir.ninjacoder.code.LangType;
import android.text.SpannableStringBuilder;
import ir.ninjacoder.code.antlr4.clang.CLexer;
import ir.ninjacoder.code.bracket.BracketManager;
import ir.ninjacoder.code.colorhelper.ColorHelper;
import java.io.StringReader;
import java.util.List;
import ir.ninjacoder.code.bracket.BracketPosition;
import java.util.ArrayList;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;

public class CodeHighlighterCLang implements Highlighter {

  @Override
  public SpannableStringBuilder highlight(LangType types, String code,ColorHelper color) throws Exception {
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
            if (pretoken == CLexer.Dot) col = color.getPredot();
            if (ObjectUtils.getNextLexer(lexer, '.')) col = color.getLastdot();
            if (pretoken == CLexer.Void) {
              col = color.getMethod();
            }
            if (pretoken == CLexer.Int) {
              col = color.getMethod();
            }
            if (pretoken == CLexer.Bool) {
              col = color.getMethod();
            }
            if (ObjectUtils.getNextLexer(lexer, '(') || ObjectUtils.getNextLexer(lexer, ')'))
              col = color.getPrebrak();
            
            builder.append(
                token.getText(),
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
