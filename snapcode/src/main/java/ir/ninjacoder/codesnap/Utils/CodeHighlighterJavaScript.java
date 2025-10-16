package ir.ninjacoder.codesnap.Utils;

import android.text.style.ForegroundColorSpan;
import ir.ninjacoder.codesnap.LangType;
import android.text.SpannableStringBuilder;
import ir.ninjacoder.codesnap.Utils.Highlighter;
import ir.ninjacoder.codesnap.Utils.ObjectUtils;
import ir.ninjacoder.codesnap.antlr4.JavaScriptLexer;
import ir.ninjacoder.codesnap.colorhelper.ColorHelper;
import ir.ninjacoder.codesnap.widget.data.CommentMatcher;
import java.io.StringReader;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.regex.Pattern;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;

public class CodeHighlighterJavaScript implements Highlighter {

  @Override
  public SpannableStringBuilder highlight(LangType types, String code, ColorHelper color)
      throws Exception {

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
            boolean hasFunc = false;
            int colorId = color.getTextnormal();
            String text = token.getText();

            if (pretoken == JavaScriptLexer.Import || pretoken == JavaScriptLexer.From) {
              colorId = color.getLastsymi();
            } else if (pretoken == JavaScriptLexer.Dot || pretoken == JavaScriptLexer.Colon) {
              colorId = color.getPredot();
            } else if (pretoken == JavaScriptLexer.Function_
                || pretoken == JavaScriptLexer.Class
                || pretoken == JavaScriptLexer.Package
                || pretoken == JavaScriptLexer.Export
                || pretoken == JavaScriptLexer.Extends) {
              hasFunc = true;
              colorId = color.getMethod();
            } else if (pretoken == JavaScriptLexer.Var
                || pretoken == JavaScriptLexer.NonStrictLet
                || pretoken == JavaScriptLexer.StrictLet
                || pretoken == JavaScriptLexer.Const) {
              hasFunc = true;
              colorId = color.getVariable();
            } else if (pretoken == JavaScriptLexer.Return
                || pretoken == JavaScriptLexer.As
                || pretoken == JavaScriptLexer.Interface
                || pretoken == JavaScriptLexer.Yield) {
              hasFunc = true;
              colorId = color.getPrebrak();
            }

            if (ObjectUtils.getNextLexer(lexer, '(')) {
              colorId = color.getLastsymi();
            } else if (ObjectUtils.getNextLexer(lexer, '.')) {
              colorId = color.getLastdot();
            } else if (ObjectUtils.getNextLexer(lexer, '$')) {
              colorId = color.getLastsymi();
            } else if (ObjectUtils.getNextLexer(lexer, '>')) {
              colorId = color.getSymbol();
            } else if (ObjectUtils.getNextLexer(lexer, ':')) {
              colorId = color.getSymbol();
            }
            Set<String> builtinNames =
                new HashSet<>(
                    Arrays.asList(
                        "console",
                        "window",
                        "document",
                        "Math",
                        "JSON",
                        "Promise",
                        "Array",
                        "Object",
                        "String",
                        "Number",
                        "Boolean",
                        "Symbol",
                        "Set",
                        "Map",
                        "Date"));
            if (builtinNames.contains(text)) {
              colorId = color.getVariable();
            }

            if (!hasFunc && Character.isUpperCase(text.charAt(0))) {
              Pattern pattern = Pattern.compile("^[A-Z][a-zA-Z0-9_]*$");
              if (pattern.matcher(text).matches()) {
                colorId = color.getUppercase();
              }
            }

            sb.append(
                text,
                new ForegroundColorSpan(colorId),
                SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
            break;
          }
        case JavaScriptLexer.StringLiteral:
          sb.append(
              token.getText(),
              new ForegroundColorSpan(color.getStrings()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
          break;
        case JavaScriptLexer.BikTikString:
          sb.append(CommentMatcher.getKtFString(token.getText(), color));
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
