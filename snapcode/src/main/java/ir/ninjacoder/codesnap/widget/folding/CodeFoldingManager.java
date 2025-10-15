package ir.ninjacoder.codesnap.folding;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import ir.ninjacoder.codesnap.colorhelper.ColorHelper;

public class CodeFoldingManager {

  public static class FoldingRegion {
    public int startLine;
    public int endLine;
    public boolean isCollapsed;
    public String startLineText;

    public FoldingRegion(int startLine, int endLine, String startLineText) {
      this.startLine = startLine;
      this.endLine = endLine;
      this.startLineText = startLineText;
      this.isCollapsed = false;
    }
  }

  private List<FoldingRegion> foldingRegions;
  private ColorHelper colorHelper;

  public CodeFoldingManager(ColorHelper colorHelper) {
    this.foldingRegions = new ArrayList<>();
    this.colorHelper = colorHelper;
  }

  public void detectFoldingRegions(String code) {
    foldingRegions.clear();
    if (code == null || code.isEmpty()) return;

    Stack<FoldingRegion> stack = new Stack<>();
    String[] lines = code.split("\n", -1);

    for (int i = 0; i < lines.length; i++) {
      String line = lines[i].trim();

      // باز کردن بلاک وقتی '{' آخر خط یا تنها کاراکتر باز باشه
      if (line.contains("{") && getLastNonSpaceChar(line) == '{') {
        FoldingRegion region = new FoldingRegion(i, -1, lines[i]);
        stack.push(region);
      } else if (line.contains("}") && getFirstNonSpaceChar(line) == '}' && !stack.isEmpty()) {
        FoldingRegion region = stack.pop();
        region.endLine = i;
        foldingRegions.add(region);
      }
    }

    while (!stack.isEmpty()) {
      FoldingRegion region = stack.pop();
      region.endLine = lines.length - 1;
      foldingRegions.add(region);
    }
  }

  private char getLastNonSpaceChar(String str) {
    for (int i = str.length() - 1; i >= 0; i--) {
      char c = str.charAt(i);
      if (!Character.isWhitespace(c)) {
        return c;
      }
    }
    return ' ';
  }

  private char getFirstNonSpaceChar(String str) {
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if (!Character.isWhitespace(c)) {
        return c;
      }
    }
    return ' ';
  }

  /**
   * applyFolding => بجای حذف خطوط در ناحیه‌ی تا شده، یک placeholder خطی می‌سازیم که خط شروع +
   * نشانگر + کامنت (n lines hidden) را نمایش دهد. این روش مکان‌نما را پایدارتر نگه می‌دارد.
   */
  public SpannableStringBuilder applyFolding(String code) {
    if (code == null) code = "";
    String[] lines = code.split("\n", -1);
    SpannableStringBuilder builder = new SpannableStringBuilder();

    for (int i = 0; i < lines.length; i++) {
      // آیا شروع یکی از folding regions هست؟
      FoldingRegion regionHere = null;
      for (FoldingRegion r : foldingRegions) {
        if (r.startLine == i) {
          regionHere = r;
          break;
        }
      }

      if (regionHere != null
          && regionHere.isCollapsed
          && regionHere.endLine > regionHere.startLine) {
        // append the start line with indicator and a compact placeholder about hidden lines
        String startLineText = lines[i];
        int hiddenCount = Math.max(0, regionHere.endLine - regionHere.startLine);
        String indicator = " ▼"; // collapsed = show ▼ on start line
        String placeholder = startLineText + indicator + " /* " + hiddenCount + " lines hidden */";
        int start = builder.length();
        builder.append(placeholder);
        int end = builder.length();

        // color the indicator and the comment part
        int indicatorStart = start + startLineText.length();
        int indicatorEnd = indicatorStart + indicator.length();
        builder.setSpan(
            new ForegroundColorSpan(colorHelper.getSymbol()),
            indicatorStart,
            indicatorEnd,
            SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
        // comment color
        int commentStart = indicatorEnd;
        int commentEnd = end;
        builder.setSpan(
            new ForegroundColorSpan(colorHelper.getComment()),
            commentStart,
            commentEnd,
            SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);

        // skip to endLine
        i = regionHere.endLine;
      } else {
        // normal line
        int start = builder.length();
        builder.append(lines[i]);
        // if this line is a start of an expanded region, add a visible indicator (▼) after it
        if (regionHere != null
            && !regionHere.isCollapsed
            && regionHere.endLine > regionHere.startLine) {
          String indicator = " ▼";
          int indStart = builder.length();
          builder.append(indicator);
          int indEnd = builder.length();
          builder.setSpan(
              new ForegroundColorSpan(colorHelper.getSymbol()),
              indStart,
              indEnd,
              SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
      }

      if (i < lines.length - 1) builder.append("\n");
    }

    return builder;
  }

  public FoldingRegion findFoldingRegionAtLine(int line) {
    for (FoldingRegion region : foldingRegions) {
      if (region.startLine == line) {
        return region;
      }
    }
    return null;
  }

  public void toggleFolding(FoldingRegion region) {
    if (region != null && region.endLine > region.startLine) {
      region.isCollapsed = !region.isCollapsed;
    }
  }

  public List<FoldingRegion> getFoldingRegions() {
    return foldingRegions;
  }

  public void clearFoldingRegions() {
    foldingRegions.clear();
  }
}
