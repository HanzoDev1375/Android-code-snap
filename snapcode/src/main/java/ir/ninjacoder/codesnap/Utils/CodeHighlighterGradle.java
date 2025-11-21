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
          span.text(text, color.getMethod(), true);
          break;

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
                || pretoken == GradleLexer.TEST_IMPLEMENTATION
                || pretoken == GradleLexer.API
                || pretoken == GradleLexer.KAPT
                || pretoken == GradleLexer.ANNOTATION_PROCESSOR) {
              colorNormal = color.getLastsymi();
              isBold = true;
            } else if (pretoken == GradleLexer.DEF
                || pretoken == GradleLexer.CLASS
                || pretoken == GradleLexer.IMPORT
                || pretoken == GradleLexer.IMPLEMENTS
                || pretoken == GradleLexer.EXTENDS) {
              colorNormal = color.getMethod();
            } else if (pretoken == GradleLexer.DOT) {
              colorNormal = color.getMethod();
              isBold = true;
            } else if (isNextChar(lexer, '.')) {
              colorNormal = color.getLastsymi();
            } else if (isNextChar(lexer, ':')) {
              colorNormal = color.getVariable();
            } else if (isNextChar(lexer, '(')) {
              colorNormal = color.getMethod();
              isBold = true;
            } else if (isGradleMethod(text)) {
              colorNormal = color.getMethod();
              isBold = true;
            } else if (isGradleConfiguration(text)) {
              colorNormal = color.getOperator();
              isBold = true;
            } else if (isUpperCaseIdentifier(text)) {
              colorNormal = color.getUppercase();
            }else if(isGradleOther(text)) {
            	colorNormal = color.getCssoprator();
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

  private boolean isNextChar(GradleLexer lexer, char expectedChar) {
    try {
      int nextChar = lexer._input.LA(1);
      return nextChar == expectedChar;
    } catch (Exception e) {
      return false;
    }
  }

  private boolean isGradleMethod(String text) {
    return text.equals("allDependencies")
        || text.equals("each")
        || text.equals("appendNode")
        || text.equals("all")
        || text.equals("configure")
        || text.equals("withType")
        || text.equals("getDependencies")
        || text.equals("getByName")
        || text.equals("matching")
        || text.equals("setGroup")
        || text.equals("setVersion")
        || text.endsWith("Node")
        || text.startsWith("get")
        || text.startsWith("set");
  }

  private boolean isGradleConfiguration(String text) {
    return text.equals("configurations")
        || text.equals("dependencies")
        || text.equals("plugins")
        || text.equals("repositories")
        || text.equals("buildscript")
        || text.equals("artifacts")
        || text.equals("publishing")
        || text.equals("android")
        || text.equals("java")
        || text.equals("kotlin");
  }

  private boolean isGradleOther(String text) {
    return text.equals("dependencyResolutionManagement")
        || text.equals("pluginManagement")
        || text.equals("debug")
        || text.equals("release")
        || text.equals("namespace")
        || text.equals("sourceCompatibility")
        || text.equals("targetCompatibility")
        || text.equals("viewBinding");
  }

  private boolean isUpperCaseIdentifier(String text) {
    if (text == null || text.isEmpty() || !Character.isUpperCase(text.charAt(0))) {
      return false;
    }

    for (int i = 1; i < text.length(); i++) {
      char c = text.charAt(i);
      if (!Character.isLetterOrDigit(c) && c != '_') {
        return false;
      }
    }
    return true;
  }
}
