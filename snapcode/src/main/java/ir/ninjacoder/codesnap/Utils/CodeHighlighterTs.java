package ir.ninjacoder.codesnap.Utils;

import ir.ninjacoder.codesnap.LangType;
import ir.ninjacoder.codesnap.antlr4.typesctipt.TypeScriptLexer;
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

public class CodeHighlighterTs implements Highlighter {

  @Override
  public SpannableStringBuilder highlight(LangType typ, String code, ColorHelper color)
      throws Exception {
    var span = SpanStyler.create();
    var lexer = new TypeScriptLexer(CharStreams.fromReader(new StringReader(code)));
    Token token;
    int type;
    int pretoken = -1;
    var manager = new BracketManager();
    List<BracketPosition> bracketPositions = new ArrayList<>();
    int currentPosition = 0;
    manager.setRainbowBracketsEnabled(true);

    while ((token = lexer.nextToken()) != null) {
      type = token.getType();
      String text = token.getText();
      if (type == TypeScriptLexer.EOF) break;
      if (isBracketToken(type)) {
        bracketPositions.add(
            new BracketPosition(
                currentPosition,
                currentPosition + token.getText().length(),
                token.getText().charAt(0),
                type));
      }
      switch (type) {
        case TypeScriptLexer.WhiteSpaces:
          span.addNullText(text);
          break;
        case TypeScriptLexer.StringLiteral:
          span.fstring(
              text, color.getBracketlevel1(), color.getBracketlevel2(), color.getStrings());
          break;
        case TypeScriptLexer.CloseBrace:
        case TypeScriptLexer.OpenBrace:
        case TypeScriptLexer.RegularExpressionLiteral:
        case TypeScriptLexer.OpenBracket:
        case TypeScriptLexer.CloseBracket:
        case TypeScriptLexer.BitNot:
        case TypeScriptLexer.Not:
        case TypeScriptLexer.Multiply:
        case TypeScriptLexer.Divide:
        case TypeScriptLexer.Modulus:
        case TypeScriptLexer.RightShiftArithmetic:
        case TypeScriptLexer.LeftShiftArithmetic:
        case TypeScriptLexer.RightShiftLogical:
        case TypeScriptLexer.LessThan:
        case TypeScriptLexer.MoreThan:
        case TypeScriptLexer.LessThanEquals:
        case TypeScriptLexer.GreaterThanEquals:
        case TypeScriptLexer.Equals_:
        case TypeScriptLexer.NotEquals:
        case TypeScriptLexer.IdentityEquals:
        case TypeScriptLexer.IdentityNotEquals:
        case TypeScriptLexer.BitAnd:
        case TypeScriptLexer.BitXOr:
        case TypeScriptLexer.BitOr:
        case TypeScriptLexer.And:
        case TypeScriptLexer.Or:
        case TypeScriptLexer.MultiplyAssign:
        case TypeScriptLexer.DivideAssign:
        case TypeScriptLexer.ModulusAssign:
        case TypeScriptLexer.PlusAssign:
        case TypeScriptLexer.MinusAssign:
        case TypeScriptLexer.LeftShiftArithmeticAssign:
        case TypeScriptLexer.RightShiftArithmeticAssign:
        case TypeScriptLexer.RightShiftLogicalAssign:
        case TypeScriptLexer.BitAndAssign:
        case TypeScriptLexer.BitXorAssign:
        case TypeScriptLexer.BitOrAssign:
        case TypeScriptLexer.ARROW:
        case TypeScriptLexer.NullLiteral:
        case TypeScriptLexer.BooleanLiteral:
        case TypeScriptLexer.DecimalLiteral:
        case TypeScriptLexer.HexIntegerLiteral:
        case TypeScriptLexer.OctalIntegerLiteral:
        case TypeScriptLexer.BinaryIntegerLiteral:
        case TypeScriptLexer.At:
        case TypeScriptLexer.TemplateCloseBrace:
        case TypeScriptLexer.OpenParen:
        case TypeScriptLexer.SemiColon:
        case TypeScriptLexer.Comma:
        case TypeScriptLexer.Assign:
        case TypeScriptLexer.QuestionMark:
        case TypeScriptLexer.Ellipsis:
        case TypeScriptLexer.Dot:
        case TypeScriptLexer.PlusPlus:
        case TypeScriptLexer.MinusMinus:
        case TypeScriptLexer.Plus:
        case TypeScriptLexer.CloseParen:
        case TypeScriptLexer.Minus:
          span.text(text, color.getSymbol());
          break;

        case TypeScriptLexer.Break:
        case TypeScriptLexer.Do:
        case TypeScriptLexer.Instanceof:
        case TypeScriptLexer.Typeof:
        case TypeScriptLexer.Case:
        case TypeScriptLexer.Else:
        case TypeScriptLexer.New:
        case TypeScriptLexer.Var:
        case TypeScriptLexer.Catch:
        case TypeScriptLexer.Finally:
        case TypeScriptLexer.Return:
        case TypeScriptLexer.Void:
        case TypeScriptLexer.Continue:
        case TypeScriptLexer.For:
        case TypeScriptLexer.Switch:
        case TypeScriptLexer.While:
        case TypeScriptLexer.Debugger:
        case TypeScriptLexer.Function_:
        case TypeScriptLexer.This:
        case TypeScriptLexer.With:
        case TypeScriptLexer.Default:
        case TypeScriptLexer.If:
        case TypeScriptLexer.Throw:
        case TypeScriptLexer.Delete:
        case TypeScriptLexer.In:
        case TypeScriptLexer.Try:
        case TypeScriptLexer.As:
        case TypeScriptLexer.From:
        case TypeScriptLexer.ReadOnly:
        case TypeScriptLexer.Async:
        case TypeScriptLexer.Class:
        case TypeScriptLexer.Enum:
        case TypeScriptLexer.Extends:
        case TypeScriptLexer.Super:
        case TypeScriptLexer.Const:
        case TypeScriptLexer.Export:
        case TypeScriptLexer.Import:
        case TypeScriptLexer.Implements:
        case TypeScriptLexer.Let:
        case TypeScriptLexer.Private:
        case TypeScriptLexer.Public:
        case TypeScriptLexer.Interface:
        case TypeScriptLexer.Package:
        case TypeScriptLexer.Protected:
        case TypeScriptLexer.Static:
        case TypeScriptLexer.Yield:
        case TypeScriptLexer.Any:
        case TypeScriptLexer.Boolean:
        case TypeScriptLexer.String:
        case TypeScriptLexer.Get:
        case TypeScriptLexer.Set:
        case TypeScriptLexer.Constructor:
        case TypeScriptLexer.Namespace:
        case TypeScriptLexer.Require:
        case TypeScriptLexer.Module:
        case TypeScriptLexer.Declare:
        case TypeScriptLexer.Abstract:
        case TypeScriptLexer.TypeAlias:
        case TypeScriptLexer.Is:
          span.text(text, color.getKeyword(), true);
          break;
        case TypeScriptLexer.Identifier:
          {
            int colorNormal = color.getTextnormal();
            boolean isClassName = false, isbold = false, Varunderline = false;
            if (pretoken == TypeScriptLexer.Class
                || pretoken == TypeScriptLexer.Interface
                || pretoken == TypeScriptLexer.Enum
                || pretoken == TypeScriptLexer.Extends
                || pretoken == TypeScriptLexer.Implements) {
              colorNormal = color.getMethod();
              isbold = true;
              isClassName = true;
            } else if (pretoken == TypeScriptLexer.Void
                || pretoken == TypeScriptLexer.Boolean
                || pretoken == TypeScriptLexer.Any
                || pretoken == TypeScriptLexer.Async
                || pretoken == TypeScriptLexer.Instanceof
                || pretoken == TypeScriptLexer.Let
                || pretoken == TypeScriptLexer.Not
                || pretoken == TypeScriptLexer.Var
                || pretoken == TypeScriptLexer.Abstract
                || pretoken == TypeScriptLexer.Identifier) {
              Varunderline = true;

              colorNormal = color.getMethod();
              isbold = true;
              if (lexer._input.LA(1) == '(') {
                colorNormal = color.getLastsymi();
              }
            } else if (lexer._input.LA(1) == '.') {
              colorNormal = color.getLastdot();
            } else if (lexer._input.LA(1) == '[' || lexer._input.LA(1) == ']') {
              colorNormal = color.getPrebrak();
            } else if (pretoken == TypeScriptLexer.Dot) {
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
        case TypeScriptLexer.MultiLineComment:
        case TypeScriptLexer.SingleLineComment:
        case TypeScriptLexer.HtmlComment:
        case TypeScriptLexer.CDataComment:
          span.commentjs(
              token.getText(),
              color.getBracketlevel3(),
              color.getBracketlevel1(),
              color.getBracketlevel2(),
              color.getComment());
          break;
        default:
          span.text(text, color.getTextnormal());
          break;
      }
      if (type != TypeScriptLexer.WhiteSpaces) {

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
    return tokenType == TypeScriptLexer.OpenBrace
        || tokenType == TypeScriptLexer.OpenBracket
        || tokenType == TypeScriptLexer.OpenParen
        || tokenType == TypeScriptLexer.CloseBrace
        || tokenType == TypeScriptLexer.CloseBracket
        || tokenType == TypeScriptLexer.CloseParen;
  }
}
