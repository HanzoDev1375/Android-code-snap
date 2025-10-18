package ir.ninjacoder.codesnap.Utils;

import ir.ninjacoder.codesnap.LangType;
import ir.ninjacoder.codesnap.antlr4.gradle.GradleLexer;
import ir.ninjacoder.codesnap.colorhelper.ColorHelper;
import android.text.SpannableStringBuilder;
import ir.ninjacoder.codesnap.widget.data.SpanStyler;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;

import java.io.StringReader;
import java.util.regex.Pattern;

public class CodeHighlighterGradle implements Highlighter {

  @Override
  public SpannableStringBuilder highlight(LangType typ, String code, ColorHelper color)
      throws Exception {

    SpanStyler span = SpanStyler.create();
    GradleLexer lexer = new GradleLexer(CharStreams.fromReader(new StringReader(code)));
    Token token;
    int pretoken = -1;

    while ((token = lexer.nextToken()).getType() != Token.EOF) {
      int type = token.getType();
      String text = token.getText();

      switch (type) {
        case GradleLexer.WS:
          span.addNullText(text);
          break;

        case GradleLexer.APPLY:
        case GradleLexer.TASK:
        case GradleLexer.BUILDSCRIPT:
        case GradleLexer.REPOSITORIES:
        case GradleLexer.MAVEN:
        case GradleLexer.GOOGLE:
        case GradleLexer.GRADLE:
        case GradleLexer.PROJECT:
        case GradleLexer.SETTINGS:
        case GradleLexer.FILE_TREE:
        case GradleLexer.FILES:
        case GradleLexer.DO_LAST:
        case GradleLexer.FROM:
        case GradleLexer.INTO:
          span.text(text, color.getKeyword(), true);
          break;

        case GradleLexer.IMPLEMENTATION:
        case GradleLexer.COMPILE_ONLY:
        case GradleLexer.RUNTIME_ONLY:
        case GradleLexer.TEST_IMPLEMENTATION:
        case GradleLexer.ANDROID_TEST_IMPLEMENTATION:
        case GradleLexer.API:
        case GradleLexer.KAPT:
        case GradleLexer.ANNOTATION_PROCESSOR:
        case GradleLexer.COMPILE:
        case GradleLexer.RUNTIME:
        case GradleLexer.TEST_COMPILE:
        case GradleLexer.TEST_RUNTIME:
        case GradleLexer.VARIANT_CONFIGURATION:
          span.text(text, color.getOperator(), true);
          break;

        case GradleLexer.SINGLE_QUOTE_STRING:
        case GradleLexer.DOUBLE_QUOTE_STRING:
        case GradleLexer.TRIPLE_QUOTE_STRING:
          span.text(text, color.getStrings());
          break;
        
        
        case GradleLexer.DEPENDENCIES:
        case GradleLexer.PLUGINS:
        span.text(text,color.getMethod(),true); break;

        case GradleLexer.INTEGER:
        case GradleLexer.FLOAT:
          span.text(text, color.getHtmlattr());
          break;
        case GradleLexer.ASSIGN:
        case GradleLexer.PLUS:
        case GradleLexer.MINUS:
        case GradleLexer.MULT:
        case GradleLexer.DIV:
        case GradleLexer.DOT:
        case GradleLexer.COLON:
        case GradleLexer.COMMA:
        case GradleLexer.SEMICOLON:
        case GradleLexer.LPAREN:
        case GradleLexer.RPAREN:
        case GradleLexer.LBRACE:
        case GradleLexer.RBRACE:
        case GradleLexer.LBRACKET:
        case GradleLexer.RBRACKET:
          span.text(text, color.getSymbol());
          break;
        case GradleLexer.TRUE:
        case GradleLexer.FALSE:
        case GradleLexer.NULL:
          span.text(text, color.getLastsymi(), true);
          break;

        case GradleLexer.AS:
        case GradleLexer.ASSERT:
        case GradleLexer.BREAK:
        case GradleLexer.CASE:
        case GradleLexer.CATCH:
        case GradleLexer.CLASS:
        case GradleLexer.CONST:
        case GradleLexer.CONTINUE:
        case GradleLexer.DEF:
        case GradleLexer.DEFAULT:
        case GradleLexer.DO:
        case GradleLexer.ELSE:
        case GradleLexer.ENUM:
        case GradleLexer.EXTENDS:
        case GradleLexer.FINALLY:
        case GradleLexer.FOR:
        case GradleLexer.GOTO:
        case GradleLexer.IF:
        case GradleLexer.IMPLEMENTS:
        case GradleLexer.IMPORT:
        case GradleLexer.IN:
        case GradleLexer.INSTANCEOF:
        case GradleLexer.INTERFACE:
        case GradleLexer.NEW:
        case GradleLexer.PACKAGE:
        case GradleLexer.RETURN:
        case GradleLexer.SUPER:
        case GradleLexer.SWITCH:
        case GradleLexer.THIS:
        case GradleLexer.THROW:
        case GradleLexer.THROWS:
        case GradleLexer.TRAIT:
        case GradleLexer.TRY:
        case GradleLexer.WHILE:
          span.text(text, color.getKeyword(), true);
          break;
        case GradleLexer.LINE_COMMENT:
        case GradleLexer.BLOCK_COMMENT:
        case GradleLexer.DOC_COMMENT:
          span.text(text, color.getComment());
          break;

        case GradleLexer.IDENTIFIER:
          {
            int colorNormal = color.getTextnormal();
            boolean isBold = false;

            if (pretoken == GradleLexer.TASK) {
              colorNormal = color.getMethod();
              isBold = true;

            } else if (pretoken == GradleLexer.PROJECT
                || pretoken == GradleLexer.APPLY
                || pretoken == GradleLexer.REPOSITORIES
                || pretoken == GradleLexer.BUILDSCRIPT) {
              colorNormal = color.getPredot();

            } else if (pretoken == GradleLexer.IMPLEMENTATION
                || pretoken == GradleLexer.COMPILE_ONLY
                || pretoken == GradleLexer.RUNTIME_ONLY
                || pretoken == GradleLexer.TEST_IMPLEMENTATION) {
              colorNormal = color.getLastsymi();
              isBold = true;

            } else if (pretoken == GradleLexer.DEF
                || pretoken == GradleLexer.CLASS
                || pretoken == GradleLexer.IMPORT
                || pretoken == GradleLexer.IMPLEMENTS) {

              colorNormal = color.getMethod();
            } else if (lexer._input.LA(2) == '{' || lexer._input.LA("{".length()) == '{') {
              colorNormal = color.getMethod();
              isBold = true;

            } else if (lexer._input.LA(1) == '.') {
              colorNormal = color.getLastsymi();
            } else if (pretoken == GradleLexer.DOT) {
              colorNormal = color.getPredot();
            } else if (Character.isUpperCase(text.charAt(0))) {
              Pattern pattern = Pattern.compile("^[A-Z][a-zA-Z0-9_]*$");
              if (pattern.matcher(text).matches()) {
                colorNormal = color.getUppercase();
              }
            }

            span.text(text, colorNormal, isBold);
            break;
          }
        default:
          span.text(text, color.getTextnormal());
          break;
      }

      pretoken = type;
    }

    return span;
  }
}
