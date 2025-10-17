package ir.ninjacoder.codesnap.Utils;

import android.graphics.Typeface;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import ir.ninjacoder.codesnap.LangType;
import android.text.SpannableStringBuilder;
import ir.ninjacoder.codesnap.Utils.Highlighter;
import ir.ninjacoder.codesnap.Utils.ObjectUtils;
import ir.ninjacoder.codesnap.antlr4.JavaScriptLexer;
import ir.ninjacoder.codesnap.bracket.BracketManager;
import ir.ninjacoder.codesnap.colorhelper.ColorHelper;
import ir.ninjacoder.codesnap.widget.data.CommentMatcher;
import ir.ninjacoder.codesnap.widget.data.SpanStyler;
import java.io.StringReader;
import java.util.List;
import ir.ninjacoder.codesnap.bracket.BracketPosition;
import java.util.ArrayList;
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
    BracketManager manager = new BracketManager();
    List<BracketPosition> bracketPositions = new ArrayList<>();
    int currentPosition = 0;
    manager.setRainbowBracketsEnabled(true);
    while ((token = lexer.nextToken()) != null) {
      type = token.getType();
      if (type == JavaScriptLexer.EOF) break;
      if (isBracketToken(type)) {
        bracketPositions.add(
            new BracketPosition(
                currentPosition,
                currentPosition + token.getText().length(),
                token.getText().charAt(0),
                type));
      }
      SpanStyler styler = SpanStyler.create();

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
          sb.append(styler.commentjs(token.getText(),color.getComment(),color.getBracketlevel1(),color.getBracketlevel2()));
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
          
          sb.append(styler.text(token.getText(), color.getKeyword(), true));
          break;

        case JavaScriptLexer.Identifier:
          {
            int colorNormal = color.getTextnormal();
            boolean isClassName = false;
            boolean isbold = false;
            boolean shouldUnderline = true;

            if (pretoken == JavaScriptLexer.Function_
                || pretoken == JavaScriptLexer.Class
                || pretoken == JavaScriptLexer.Package
                || pretoken == JavaScriptLexer.Export
                || pretoken == JavaScriptLexer.Extends
                || pretoken == JavaScriptLexer.Identifier) {
              colorNormal = color.getMethod();
              isClassName = true;
              shouldUnderline = false;
            } else if (pretoken == JavaScriptLexer.Var
                || pretoken == JavaScriptLexer.NonStrictLet
                || pretoken == JavaScriptLexer.StrictLet
                || pretoken == JavaScriptLexer.Const
                || pretoken == JavaScriptLexer.Interface
                || pretoken == JavaScriptLexer.Return
                || pretoken == JavaScriptLexer.As
                || pretoken == JavaScriptLexer.Yield) {
              colorNormal = color.getVariable();
              isbold = true;
              shouldUnderline = false;
              if (lexer._input.LA(1) == '(') {
                colorNormal = color.getLastsymi();
              }
            } else if (lexer._input.LA(1) == '.') {
              colorNormal = color.getLastdot();
              shouldUnderline = false;
            } else if (lexer._input.LA(1) == '[' || lexer._input.LA(1) == ']') {
              colorNormal = color.getPrebrak();
              shouldUnderline = false;
            } else if (pretoken == JavaScriptLexer.Dot || pretoken == JavaScriptLexer.Colon) {
              colorNormal = color.getPredot();
              shouldUnderline = false;
            } else if (lexer._input.LA(1) == '>' || pretoken == JavaScriptLexer.LessThan) {
              colorNormal = color.getHtmlkeyword();
              shouldUnderline = false;
            } else if (!isClassName && Character.isUpperCase(token.getText().charAt(0))) {
              Pattern pattern = Pattern.compile("^[A-Z][a-zA-Z0-9_]*$");
              var matcher = pattern.matcher(token.getText());
              if (matcher.matches()) {
                colorNormal = color.getUppercase();
                shouldUnderline = false;
              }
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

            if (builtinNames.contains(token.getText())) {
              colorNormal = color.getVariable();
              shouldUnderline = false;
            }
            styler.text(token.getText(), colorNormal, isbold, shouldUnderline);
            sb.append(styler);
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
      currentPosition += token.getText().length();
    }
    if (manager.getRainbowBracketsEnabled() && !bracketPositions.isEmpty()) {
      manager.applyRainbowBrackets(sb, bracketPositions);
    }
    return sb;
  }

  boolean isBracketToken(int type) {
    return type == JavaScriptLexer.OpenBracket
        || type == JavaScriptLexer.CloseBracket
        || type == JavaScriptLexer.OpenParen
        || type == JavaScriptLexer.CloseParen
        || type == JavaScriptLexer.OpenBrace
        || type == JavaScriptLexer.CloseBrace;
  }
}
