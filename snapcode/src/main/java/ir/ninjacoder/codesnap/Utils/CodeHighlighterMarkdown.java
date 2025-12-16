package ir.ninjacoder.codesnap.Utils;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import ir.ninjacoder.codesnap.LangType;
import ir.ninjacoder.codesnap.antlr4.md.MarkDownLexer;
import ir.ninjacoder.codesnap.colorhelper.ColorHelper;
import ir.ninjacoder.codesnap.widget.data.SpanStyler;
import java.io.StringReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;

public class CodeHighlighterMarkdown implements Highlighter {

  @Override
  public SpannableStringBuilder highlight(LangType types, String code, ColorHelper color) {
    SpanStyler builder = SpanStyler.create();
    try {
      var lexer = new MarkDownLexer(CharStreams.fromReader(new StringReader(code)));
      int pretoken = -1;
      int type;
      Token token;

      while ((token = lexer.nextToken()) != null) {
        type = token.getType();
        String text = token.getText();
        if (type == MarkDownLexer.EOF) {
          break;
        }
        switch (type) {
          case MarkDownLexer.WS:
            builder.addNullText(text);
            break;
          case MarkDownLexer.BACKTIKMASER:
            builder.text(text, color.getOperator());
            break;
          case MarkDownLexer.BOLD:
            builder.text(text, color.getKeyword(), true, false, false);
            break;

          case MarkDownLexer.HEADER1:
          case MarkDownLexer.HEADER2:
          case MarkDownLexer.HEADER3:
          case MarkDownLexer.HEADER4:
          case MarkDownLexer.HEADER5:
          case MarkDownLexer.HEADER6:
            builder.text(text, color.getCssoprator());
            break;
          case MarkDownLexer.ITALIC:
            builder.text(text, color.getMethod());
            break;
          case MarkDownLexer.HTMLCLOSE:
          case MarkDownLexer.SLASH:
          case MarkDownLexer.HTMLOPEN:
            builder.text(text, color.getSymbol());
            break;
          case MarkDownLexer.STRING:
            builder.text(text, color.getStrings());
            break;
          case MarkDownLexer.LINK:
          case MarkDownLexer.LINKMASET:
            builder.text(text, color.getCsskeyword());
            break;
          case MarkDownLexer.LANGTYPE:
            builder.text(text, color.getStrings());
            break;
          case MarkDownLexer.BOXOFF:
          case MarkDownLexer.BOXON:
          builder.text(text,color.getBracketlevel3()); break;
          case MarkDownLexer.ID:
            {
              int i = color.getTextnormal();
              if (pretoken == MarkDownLexer.HEADER1
                  || pretoken == MarkDownLexer.HEADER2
                  || pretoken == MarkDownLexer.HEADER3
                  || pretoken == MarkDownLexer.HEADER4
                  || pretoken == MarkDownLexer.HEADER5
                  || pretoken == MarkDownLexer.HEADER6) {
                i = color.getSymbol();
              }
              if(pretoken == MarkDownLexer.BOXOFF|| pretoken == MarkDownLexer.BOXON) {
              	i = color.getBracketlevel5();
              }

              builder.text(text, i);

              break;
            }

          default:
            builder.text(text, color.getTextnormal());
            break;
        }
        if (pretoken != MarkDownLexer.WS) {
          pretoken = type;
        }
      }
    } catch (Exception err) {

    }

    return builder;
  }
}
