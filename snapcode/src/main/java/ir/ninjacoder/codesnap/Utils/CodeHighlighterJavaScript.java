package ir.ninjacoder.codesnap.Utils;

import android.text.style.ForegroundColorSpan;
import ir.ninjacoder.codesnap.LangType;
import android.text.SpannableStringBuilder;
import ir.ninjacoder.codesnap.Utils.Highlighter;
import ir.ninjacoder.codesnap.Utils.ObjectUtils;
import ir.ninjacoder.codesnap.antlr4.JavaScriptLexer;
import ir.ninjacoder.codesnap.colorhelper.ColorHelper;
import java.io.StringReader;
import java.util.regex.Pattern;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;

public class CodeHighlighterJavaScript implements Highlighter {

  @Override
  public SpannableStringBuilder highlight(LangType types, String code,ColorHelper color) throws Exception {
    
    JavaScriptLexer lexer = new JavaScriptLexer(CharStreams.fromReader(new StringReader(code)));
    SpannableStringBuilder sb = new SpannableStringBuilder();
    Token token;
    int type;
    int pretoken = -1;
    while ((token = lexer.nextToken()) != null) {
      type = token.getType();
      if (type == JavaScriptLexer.EOF) break;
      switch (type) {
        case JavaScriptLexer.WhiteSpaces:
          sb.append(token.getText());
          break;
        case JavaScriptLexer.CloseBracket:
        case JavaScriptLexer.CloseBrace:
        case JavaScriptLexer.CloseParen:
        case JavaScriptLexer.OpenParen:
        case JavaScriptLexer.OpenBracket:
        case JavaScriptLexer.OpenBrace:
        case JavaScriptLexer.SemiColon:
        case JavaScriptLexer.Comma:
        case JavaScriptLexer.Assign:
        case JavaScriptLexer.QuestionMark:
        case JavaScriptLexer.QuestionMarkDot:
        case JavaScriptLexer.Colon:
        case JavaScriptLexer.Ellipsis:
        case JavaScriptLexer.PlusPlus:
        case JavaScriptLexer.Plus:
        case JavaScriptLexer.MinusMinus:
        case JavaScriptLexer.Minus:
        case JavaScriptLexer.BitNot:
        case JavaScriptLexer.Not:
        case JavaScriptLexer.Multiply:
        case JavaScriptLexer.Divide:
        case JavaScriptLexer.Dot:
          sb.append(
              token.getText(),
              new ForegroundColorSpan(color.getSymbol()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
          break;

        case JavaScriptLexer.Modulus:
        case JavaScriptLexer.NullCoalesce:
        case JavaScriptLexer.Hashtag:
        case JavaScriptLexer.RightShiftArithmetic:
        case JavaScriptLexer.LeftShiftArithmetic:
        case JavaScriptLexer.RightShiftLogical:
        case JavaScriptLexer.LessThan:
        case JavaScriptLexer.MoreThan:
        case JavaScriptLexer.LessThanEquals:
        case JavaScriptLexer.GreaterThanEquals:
        case JavaScriptLexer.Equals_:
        case JavaScriptLexer.NotEquals:
        case JavaScriptLexer.IdentityEquals:
        case JavaScriptLexer.IdentityNotEquals:
        case JavaScriptLexer.BitAnd:
        case JavaScriptLexer.BitXOr:
        case JavaScriptLexer.BitOr:
        case JavaScriptLexer.And:
        case JavaScriptLexer.Or:
        case JavaScriptLexer.MultiplyAssign:
        case JavaScriptLexer.DivideAssign:
        case JavaScriptLexer.ModulusAssign:
        case JavaScriptLexer.PlusAssign:
        case JavaScriptLexer.MinusAssign:
        case JavaScriptLexer.LeftShiftArithmeticAssign:
        case JavaScriptLexer.RightShiftArithmeticAssign:
        case JavaScriptLexer.RightShiftLogicalAssign:
        case JavaScriptLexer.BitAndAssign:
        case JavaScriptLexer.BitXorAssign:
        case JavaScriptLexer.BitOrAssign:
        case JavaScriptLexer.PowerAssign:
        case JavaScriptLexer.ARROW:
        case JavaScriptLexer.BackTick:
          sb.append(
              token.getText(),
              new ForegroundColorSpan(color.getOperator()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
          break;
        case JavaScriptLexer.SingleLineComment:
        case JavaScriptLexer.MultiLineComment:
        case JavaScriptLexer.HtmlComment:
          sb.append(
              token.getText(),
              new ForegroundColorSpan(color.getComment()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
          break;

        case JavaScriptLexer.Var:
        case JavaScriptLexer.NonStrictLet:
        case JavaScriptLexer.StrictLet:
        case JavaScriptLexer.Const:
        case JavaScriptLexer.Break:
        case JavaScriptLexer.Do:
        case JavaScriptLexer.Instanceof:
        case JavaScriptLexer.Typeof:
        case JavaScriptLexer.Case:
        case JavaScriptLexer.Else:
        case JavaScriptLexer.New:
        case JavaScriptLexer.Catch:
        case JavaScriptLexer.Finally:
        case JavaScriptLexer.Return:
        case JavaScriptLexer.Void:
        case JavaScriptLexer.Continue:
        case JavaScriptLexer.For:
        case JavaScriptLexer.Switch:
        case JavaScriptLexer.While:
        case JavaScriptLexer.Debugger:
        case JavaScriptLexer.Function_:
        case JavaScriptLexer.This:
        case JavaScriptLexer.With:
        case JavaScriptLexer.Default:
        case JavaScriptLexer.If:
        case JavaScriptLexer.Throw:
        case JavaScriptLexer.Delete:
        case JavaScriptLexer.In:
        case JavaScriptLexer.Try:
        case JavaScriptLexer.As:
        case JavaScriptLexer.From:
        case JavaScriptLexer.Class:
        case JavaScriptLexer.Enum:
        case JavaScriptLexer.Extends:
        case JavaScriptLexer.Super:
        case JavaScriptLexer.Export:
        case JavaScriptLexer.Import:
        case JavaScriptLexer.Async:
        case JavaScriptLexer.Await:
        case JavaScriptLexer.Yield:
        case JavaScriptLexer.Implements:
        case JavaScriptLexer.Private:
        case JavaScriptLexer.Public:
        case JavaScriptLexer.Interface:
        case JavaScriptLexer.Package:
        case JavaScriptLexer.Protected:
        case JavaScriptLexer.Static:
          sb.append(
              token.getText(),
              new ForegroundColorSpan(color.getKeyword()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
          break;

        case JavaScriptLexer.Identifier:
          {
            boolean hasfunc = false;

            int mycolor = color.getTextnormal();
            if (pretoken == JavaScriptLexer.Import || pretoken == JavaScriptLexer.From) {
              mycolor = color.getLastsymi();
            }

            // symbol like in vscode
            if (pretoken == JavaScriptLexer.Dot || pretoken == JavaScriptLexer.Colon) {
              mycolor = color.getPredot();
            }
            if (pretoken == JavaScriptLexer.Function_
                || pretoken == JavaScriptLexer.Class
                || pretoken == JavaScriptLexer.Package
                || pretoken == JavaScriptLexer.Export
                || pretoken == JavaScriptLexer.Extends) {
              hasfunc = true;
              mycolor = color.getMethod();
            }
            // var
            if (pretoken == JavaScriptLexer.Var
                || pretoken == JavaScriptLexer.NonStrictLet
                || pretoken == JavaScriptLexer.StrictLet
                || pretoken == JavaScriptLexer.Const) {
              hasfunc = true;
              mycolor = color.getVariable();
            }
            // retrun and .....
            if (pretoken == JavaScriptLexer.Return
                || pretoken == JavaScriptLexer.As
                || pretoken == JavaScriptLexer.Interface
                || pretoken == JavaScriptLexer.Yield) {
              hasfunc = true;
              mycolor = color.getPrebrak();
            }

            // next
            if (ObjectUtils.getNextLexer(lexer, '(')) {
              mycolor = color.getLastsymi();
            }
            if (ObjectUtils.getNextLexer(lexer, '.')) {
              mycolor = color.getLastdot();
            }
            if (ObjectUtils.getNextLexer(lexer, '$')) {
              mycolor = color.getLastsymi();
            }

            // -> str
            if (ObjectUtils.getNextLexer(lexer, '>')) {
              mycolor = color.getSymbol();
            }
            if (ObjectUtils.getNextLexer(lexer, ':')) {
              mycolor = color.getSymbol();
            }
            if (!hasfunc) {
              Pattern pattern = Pattern.compile("\\b[A-Z][a-zA-Z]*\\b");
              var matcher = pattern.matcher(token.getText());
              if (matcher.matches()) {

                mycolor = color.getUppercase();
              }
            }
            sb.append(
                token.getText(),
                new ForegroundColorSpan(mycolor),
                SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
            break;
          }

        case JavaScriptLexer.StringLiteral:
          sb.append(
              token.getText(),
              new ForegroundColorSpan(color.getStrings()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
          break;
        default:
          sb.append(
              token.getText(),
              new ForegroundColorSpan(color.getTextnormal()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
          break;
      }
      if (type != JavaScriptLexer.WhiteSpaces) {
        pretoken = type;
      }
    }
    return sb;
  }
}
