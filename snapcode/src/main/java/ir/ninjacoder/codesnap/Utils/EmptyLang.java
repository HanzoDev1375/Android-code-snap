package ir.ninjacoder.codesnap.Utils;

import ir.ninjacoder.codesnap.LangType;
import ir.ninjacoder.codesnap.bracket.BracketManager;
import java.util.List;
import ir.ninjacoder.codesnap.bracket.BracketPosition;
import java.util.ArrayList;
import ir.ninjacoder.codesnap.colorhelper.ColorHelper;
import android.text.SpannableStringBuilder;
import ir.ninjacoder.codesnap.widget.data.SpanStyler;

public class EmptyLang implements Highlighter {

  @Override
  public SpannableStringBuilder highlight(LangType langType, String code, ColorHelper color)
      throws Exception {
    var manager = new BracketManager();
    List<BracketPosition> bracketPositions = new ArrayList<>();
    int currentPosition = 0;
    manager.setRainbowBracketsEnabled(true);
    SpanStyler span = SpanStyler.create();

    StringBuilder currentToken = new StringBuilder();

    for (int i = 0; i < code.length(); i++) {
      char c = code.charAt(i);

      if (isBracketChar(c)) {

        if (currentToken.length() > 0) {
          String token = currentToken.toString();
          span.text(token, color.getBracketlevel1());
          currentPosition += token.length();
          currentToken.setLength(0);
        }

        bracketPositions.add(new BracketPosition(currentPosition, currentPosition + 1, c, (int) c));
        span.text(String.valueOf(c), color.getBracketlevel1());
        currentPosition += 1;

      } else if (Character.isLetterOrDigit(c) || c == '-') {

        currentToken.append(c);
      } else {

        if (currentToken.length() > 0) {
          String token = currentToken.toString();
          span.text(token, color.getBracketlevel1());
          currentPosition += token.length();
          currentToken.setLength(0);
        }

        span.addNullText(String.valueOf(c));
        currentPosition += 1;
      }
    }

    if (currentToken.length() > 0) {
      String token = currentToken.toString();
      span.text(token, color.getBracketlevel1());
      currentPosition += token.length();
    }

    if (manager.getRainbowBracketsEnabled() && !bracketPositions.isEmpty()) {
      manager.applyRainbowBrackets(span, bracketPositions);
    }

    return span;
  }

  boolean isBracketChar(char c) {
    return c == '{' || c == '}' || c == '(' || c == ')' || c == '[' || c == ']' || c == '<'
        || c == '>';
  }
}
