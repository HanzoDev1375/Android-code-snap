package ir.ninjacoder.codesnap.Utils;

import android.text.style.ForegroundColorSpan;
import ir.ninjacoder.codesnap.LangType;
import ir.ninjacoder.codesnap.antlr4.kotlin.KotlinLexer;
import ir.ninjacoder.codesnap.bracket.BracketManager;
import ir.ninjacoder.codesnap.colorhelper.ColorHelper;
import android.text.SpannableStringBuilder;
import ir.ninjacoder.codesnap.widget.data.CommentMatcher;
import java.io.StringReader;
import java.util.Arrays;
import java.util.List;
import ir.ninjacoder.codesnap.bracket.BracketPosition;
import java.util.ArrayList;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;

public class CodeHighlighterKt implements Highlighter {

  @Override
  public SpannableStringBuilder highlight(LangType type2, String code, ColorHelper color)
      throws Exception {
    var builder = new SpannableStringBuilder();
    Token token;
    int type;
    var manager = new BracketManager();
    int pretoken = -1;
    List<BracketPosition> bracketPositions = new ArrayList<>();
    int currentPosition = 0;
    manager.setRainbowBracketsEnabled(true);
    var lexer = new KotlinLexer(CharStreams.fromReader(new StringReader(code)));
    while ((token = lexer.nextToken()) != null) {
      type = token.getType();
      if (type == KotlinLexer.EOF) break;
      if (isBracketToken(type)) {
        bracketPositions.add(
            new BracketPosition(
                currentPosition,
                currentPosition + token.getText().length(),
                token.getText().charAt(0),
                type));
      }
      switch (type) {
        case KotlinLexer.WS:
          builder.append(token.getText());
          break;

        case KotlinLexer.ANNOTATION:
        case KotlinLexer.ABSTRACT:
        case KotlinLexer.BY:
        case KotlinLexer.CATCH:
        case KotlinLexer.COMPANION:
        case KotlinLexer.CONSTRUCTOR:
        case KotlinLexer.CROSSINLINE:
        case KotlinLexer.DATA:
        case KotlinLexer.DYNAMIC:
        case KotlinLexer.ENUM:
        case KotlinLexer.EXTERNAL:
        case KotlinLexer.FINAL:
        case KotlinLexer.FINALLY:
        case KotlinLexer.IMPORT:
        case KotlinLexer.INFIX:
        case KotlinLexer.INIT:
        case KotlinLexer.INLINE:
        case KotlinLexer.INNER:
        case KotlinLexer.INTERNAL:
        case KotlinLexer.LATEINIT:
        case KotlinLexer.NOINLINE:
        case KotlinLexer.OPEN:
        case KotlinLexer.OPERATOR:
        case KotlinLexer.OUT:
        case KotlinLexer.OVERRIDE:
        case KotlinLexer.PRIVATE:
        case KotlinLexer.PROTECTED:
        case KotlinLexer.PUBLIC:
        case KotlinLexer.REIFIED:
        case KotlinLexer.SEALED:
        case KotlinLexer.TAILREC:
        case KotlinLexer.VARARG:
        case KotlinLexer.WHERE:
        case KotlinLexer.CONST:
        case KotlinLexer.SUSPEND:
        case KotlinLexer.PACKAGE:
        case KotlinLexer.CLASS:
        case KotlinLexer.INTERFACE:
        case KotlinLexer.FUN:
        case KotlinLexer.OBJECT:
        case KotlinLexer.VAL:

        case KotlinLexer.VAR:
        case KotlinLexer.TYPE_ALIAS:
        case KotlinLexer.THIS:
        case KotlinLexer.SUPER:
        case KotlinLexer.TYPEOF:
        case KotlinLexer.IF:
        case KotlinLexer.ELSE:
        case KotlinLexer.WHEN:
        case KotlinLexer.TRY:
        case KotlinLexer.FOR:
        case KotlinLexer.DO:
        case KotlinLexer.WHILE:
        case KotlinLexer.THROW:
        case KotlinLexer.RETURN:
        case KotlinLexer.CONTINUE:
        case KotlinLexer.BREAK:
        case KotlinLexer.AS:
        case KotlinLexer.IS:
        case KotlinLexer.IN:
          builder.append(
              token.getText(),
              new ForegroundColorSpan(color.getKeyword()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
          break;
        case KotlinLexer.RealLiteral:
        case KotlinLexer.FloatLiteral:
        case KotlinLexer.DoubleLiteral:
        case KotlinLexer.IntegerLiteral:

        case KotlinLexer.BinLiteral:
        case KotlinLexer.LongLiteral:
        case KotlinLexer.BooleanLiteral:
        case KotlinLexer.NullLiteral:
        case KotlinLexer.HexLiteral:
          builder.append(
              token.getText(),
              new ForegroundColorSpan(color.getOperator()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
          break;
        case KotlinLexer.RESERVED:
        case KotlinLexer.DOT:
        case KotlinLexer.COMMA:
        case KotlinLexer.LPAREN:
        case KotlinLexer.RPAREN:
        case KotlinLexer.LSQUARE:
        case KotlinLexer.RSQUARE:

        case KotlinLexer.MULT:
        case KotlinLexer.MOD:
        case KotlinLexer.DIV:
        case KotlinLexer.ADD:
        case KotlinLexer.SUB:
        case KotlinLexer.INCR:
        case KotlinLexer.DECR:
        case KotlinLexer.CONJ:
        case KotlinLexer.DISJ:
        case KotlinLexer.COLON:
        case KotlinLexer.SEMICOLON:
        case KotlinLexer.ASSIGNMENT:
        case KotlinLexer.ADD_ASSIGNMENT:
        case KotlinLexer.SUB_ASSIGNMENT:
        case KotlinLexer.MULT_ASSIGNMENT:
        case KotlinLexer.DIV_ASSIGNMENT:
        case KotlinLexer.MOD_ASSIGNMENT:
        case KotlinLexer.ARROW:
        case KotlinLexer.DOUBLE_ARROW:
        case KotlinLexer.RANGE:
        case KotlinLexer.COLONCOLON:
        case KotlinLexer.DOUBLE_SEMICOLON:
        case KotlinLexer.LANGLE:
        case KotlinLexer.RANGLE:
        case KotlinLexer.LE:
        case KotlinLexer.GE:
        case KotlinLexer.EXCL_EQ:
        case KotlinLexer.EXCL_EQEQ:
        case KotlinLexer.AS_SAFE:
        case KotlinLexer.EQEQ:
        case KotlinLexer.EQEQEQ:
        case KotlinLexer.HASH:
        case KotlinLexer.LCURL:
        case KotlinLexer.RCURL:
          builder.append(
              token.getText(),
              new ForegroundColorSpan(color.getSymbol()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
          break;
        case KotlinLexer.STRING:
          builder.append(CommentMatcher.getKtFString(token.getText(), color));
          break;
        case KotlinLexer.Identifier:
          {
            int mcolor = color.getTextnormal();
            boolean isbold = false, isItalic = false;

            var mytext = token.getText();
            boolean hasktpr = false;

            if (pretoken == KotlinLexer.AT) {
              mcolor = color.getOperator();
            }
            if (pretoken == KotlinLexer.HASH) {
              mcolor = color.getBracketcolor();
            }
            if (pretoken == KotlinLexer.DOT) {
              mcolor = color.getPredot();
            }
            if (pretoken == KotlinLexer.COLON) {
              mcolor = color.getPrebrak();
              hasktpr = true;
            }
            if (pretoken == KotlinLexer.CLASS
                || pretoken == KotlinLexer.FUN
                || pretoken == KotlinLexer.INNER
                || pretoken == KotlinLexer.INTERFACE
                || pretoken == KotlinLexer.INTERNAL
                || pretoken == KotlinLexer.PACKAGE
                || pretoken == KotlinLexer.IMPORT) {
              mcolor = color.getCsskeyword();
            }
            if (pretoken == KotlinLexer.AS
                || pretoken == KotlinLexer.BY
                || pretoken == KotlinLexer.WHEN
                || pretoken == KotlinLexer.WHERE
                || pretoken == KotlinLexer.IS
                || pretoken == KotlinLexer.IN) {
              mcolor = color.getSymbol();
            }
            if (pretoken == KotlinLexer.VAL || pretoken == KotlinLexer.VAR) {
              mcolor = color.getHtmlattr();
              isItalic = true;
            }
            if (token.getText().equals("apply") || token.getText().equals("let")) {
              mcolor = color.getMethod();
            }
            if (token.getText().equals("field")) {
              isbold = true;
              mcolor = color.getMethod();
            }
            if (token.getText().equals("run")
                || token.getText().equals("aslo")
                || token.getText().equals("launch")) {
              isbold = true;
              mcolor = color.getMethod();
            }

            // next
            if (ObjectUtils.getNextLexer(lexer, '(')) {
              mcolor = color.getLastsymi();
            }
            if (ObjectUtils.getNextLexer(lexer, '.')) {
              mcolor = color.getLastdot();
            }
            if (ObjectUtils.getNextLexer(lexer, ',')) {
              mcolor = color.getLastsymi();
            }
            if (ObjectUtils.getNextLexer(lexer, ')')) {
              mcolor = color.getLastsymi();
            }
            // -> str
            if (ObjectUtils.getNextLexer(lexer, '>')) {
              mcolor = color.getLastdot();
            }
            if (!hasktpr)
              if (ObjectUtils.getNextLexer(lexer, ':')) {
                mcolor = color.getPrebrak();
              }

            String[] ktScopeFunctions = {"with"};
            String[] ktCollectionFunctions = {
              "filter",
              "map",
              "flatMap",
              "fold",
              "reduce",
              "forEach",
              "any",
              "all",
              "none",
              "first",
              "last",
              "contains",
              "reversed",
              "sorted",
              "sum",
              "average",
              "count",
              "max",
              "min",
              "take",
              "drop",
              "zip",
              "plus",
              "minus",
              "distinct",
              "groupBy",
              "associateBy",
              "partition",
              "onEach",
              "shuffled",
              "joinToString"
            };
            if (Arrays.asList(ktScopeFunctions).contains(token.getText())) {
              mcolor = color.getVariable();
            } else if (Arrays.asList(ktCollectionFunctions).contains(token.getText())) {
              mcolor = color.getMethod();
            }

            builder.append(
                token.getText(),
                new ForegroundColorSpan(mcolor),
                SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
            break;
          }

        default:
          builder.append(
              token.getText(),
              new ForegroundColorSpan(color.getTextnormal()),
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
          break;
      }
      if (type != KotlinLexer.WS) {
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
    return type == KotlinLexer.LCURL
        || type == KotlinLexer.RCURL
        || type == KotlinLexer.LPAREN
        || type == KotlinLexer.RPAREN
        || type == KotlinLexer.RSQUARE;
  }
}
