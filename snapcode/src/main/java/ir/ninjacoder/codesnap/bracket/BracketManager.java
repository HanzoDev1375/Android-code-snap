package ir.ninjacoder.codesnap.bracket;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import java.util.List;
import java.util.Stack;
import java.util.ArrayList;
import android.text.style.ForegroundColorSpan;

public class BracketManager {

  private boolean rainbowBracketsEnabled = true;

  private int[] rainbowColors = {
    Color.parseColor("#FF6666"), // قرمز
    Color.parseColor("#FF9966"), // نارنجی
    Color.parseColor("#FFCC66"), // زرد
    Color.parseColor("#99CC66"), // سبز
    Color.parseColor("#66CCCC"), // فیروزه‌ای
    Color.parseColor("#6699CC"), // آبی
    Color.parseColor("#9966CC") // بنفش
  };

  /** تنظیم رنگ‌های دلخواه برای براکت رنگین کمانی */
  public void setRainbowColors(int[] colors) {
    this.rainbowColors = colors;
  }

  public void applyRainbowBrackets(
      SpannableStringBuilder sb, List<BracketPosition> bracketPositions) {
    Stack<BracketInfo> stack = new Stack<>();
    List<BracketPair> bracketPairs = new ArrayList<>();
    for (BracketPosition bp : bracketPositions) {
      char bracketChar = bp.bracketChar;
      if (isOpenBracket(bracketChar)) {
        stack.push(new BracketInfo(bracketChar, bp.start, bp.tokenType));
      } else if (isCloseBracket(bracketChar)) {
        if (!stack.isEmpty()) {
          BracketInfo openBracket = stack.pop();
          if (isMatchingBracket(openBracket.character, bracketChar)) {
            bracketPairs.add(new BracketPair(openBracket.position, bp.start, bp.length));
          }
        }
      }
    }

    // رنگ‌آمیزی براکت‌ها بر اساس عمق تودرتویی
    for (BracketPair pair : bracketPairs) {
      int depth = calculateBracketDepth(bracketPositions, pair.openPos);
      int colorIndex = depth % rainbowColors.length;

      // اعمال رنگ روی براکت باز
      sb.setSpan(
          new ForegroundColorSpan(rainbowColors[colorIndex]),
          pair.openPos,
          pair.openPos + pair.openLength,
          SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);

      // اعمال رنگ روی براکت بسته
      sb.setSpan(
          new ForegroundColorSpan(rainbowColors[colorIndex]),
          pair.closePos,
          pair.closePos + pair.closeLength,
          SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
    }
  }

  /** محاسبه عمق تودرتویی برای یک براکت */
  private int calculateBracketDepth(List<BracketPosition> bracketPositions, int position) {
    int depth = 0;
    for (BracketPosition bp : bracketPositions) {
      if (bp.start >= position) break;
      if (isOpenBracket(bp.bracketChar)) {
        depth++;
      } else if (isCloseBracket(bp.bracketChar)) {
        depth--;
      }
    }
    return Math.max(0, depth - 1);
  }

  private boolean isOpenBracket(char c) {
    return c == '(' || c == '{' || c == '[';
  }

  private boolean isCloseBracket(char c) {
    return c == ')' || c == '}' || c == ']';
  }

  private boolean isMatchingBracket(char open, char close) {
    return (open == '(' && close == ')')
        || (open == '{' && close == '}')
        || (open == '[' && close == ']');
  }

  public boolean getRainbowBracketsEnabled() {
    return this.rainbowBracketsEnabled;
  }

  public void setRainbowBracketsEnabled(boolean rainbowBracketsEnabled) {
    this.rainbowBracketsEnabled = rainbowBracketsEnabled;
  }
}
