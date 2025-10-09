package ir.ninjacoder.code.widget;

/**
 * orginal code in
 * https://github.com/Badranh/Syntax-View-Android/blob/master/syntax-view/src/main/java/net/cryptobrewery/syntaxview/SyntaxView.java
 */
import android.view.View;
import ir.ninjacoder.code.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.InputType;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.BackgroundColorSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

public class SyntaxView extends ScrollView {
  private EditText code;
  private int oldLength;
  private int newLength;
  private TextView rows;
  private boolean autoIndent = false;
  private boolean rainbowBrackets = false;
  private int[] rainbowColors = {
    Color.parseColor("#FF6666"), // قرمز
    Color.parseColor("#FF9966"), // نارنجی
    Color.parseColor("#FFCC66"), // زرد
    Color.parseColor("#99CC66"), // سبز
    Color.parseColor("#66CCCC"), // فیروزه‌ای
    Color.parseColor("#6699CC"), // آبی
    Color.parseColor("#9966CC") // بنفش
  };

  public SyntaxView(Context context) {
    super(context);
    initialize(context);
  }

  public SyntaxView(Context context, AttributeSet attrs) {
    super(context, attrs);
    initialize(context);
  }

  private void initialize(Context context) {

    inflate(context, R.layout.syntaxview, this);
    code = findViewById(R.id.code);
    rows = findViewById(R.id.rows);
    code.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
    code.setSingleLine(false);
    code.setImeOptions(EditorInfo.IME_FLAG_NO_ENTER_ACTION);
    code.setBackgroundColor(Color.TRANSPARENT);

    code.setSelection(code.getText().length());
    
    code.addTextChangedListener(
        new TextWatcher() {
          String temp1, temp2;

          @Override
          public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            oldLength = s.length();
            temp1 = s.toString();
          }

          // increment the rows view by 1 when the user moves to next line
          @Override
          public void onTextChanged(CharSequence s, int start, int before, int count) {
            Log.d(
                "SyntaxView",
                "[onTextChanged] id = "
                    + java.lang.System.identityHashCode(code)
                    + " content = "
                    + s.toString());

            int numb_of_line = code.getLineCount();
            StringBuilder linesText = new StringBuilder();
            for (int i = 1; i <= numb_of_line; i++) {
              linesText.append(i).append("\n");
            }
            rows.setText(linesText.toString());
          }

          // remove old highlighting and set new highlighting
          @Override
          public void afterTextChanged(final Editable s) {
            temp2 = s.toString();
            newLength = s.length();
            if (autoIndent) {
              char lastDiff = getLastDifference(temp2, temp1);
              if (oldLength < newLength && (lastDiff == ':' || lastDiff == '{')) {

                int position = code.getSelectionStart();
                code.getText().insert(position, "\n ");
                position = code.getSelectionStart();
                code.setSelection(position);
              }
            }

            // Apply rainbow brackets if enabled
            if (rainbowBrackets) {
              applyRainbowBrackets(s);
            }
          }
        });
  }

  public void setRowNumbersColor(String color) {

    rows.setTextColor(Color.parseColor(color));
  }

  public void showLineNumber(boolean show) {
    rows.setVisibility(show ? View.VISIBLE : View.GONE);
  }

  public void setFont(Typeface tf) {
    code.setTypeface(tf);
    rows.setTypeface(tf);
  }

  /**
   * Enable or disable rainbow brackets feature
   *
   * @param enable true to enable rainbow brackets, false to disable
   */
  public void setRainbowBrackets(boolean enable) {
    this.rainbowBrackets = enable;
    if (enable) {
      applyRainbowBrackets(code.getText());
    } else {
      removeRainbowBrackets(code.getText());
    }
  }

  /**
   * Set custom colors for rainbow brackets
   *
   * @param colors array of color integers
   */
  public void setRainbowBracketsColors(int[] colors) {
    this.rainbowColors = colors;
    if (rainbowBrackets) {
      applyRainbowBrackets(code.getText());
    }
  }

  /** Apply rainbow coloring to brackets */
  private void applyRainbowBrackets(Editable text) {
    removeRainbowBrackets(text);

    String textStr = text.toString();
    Stack<BracketInfo> stack = new Stack<>();
    List<BracketPair> bracketPairs = new ArrayList<>();

    // Find all brackets and their positions
    for (int i = 0; i < textStr.length(); i++) {
      char c = textStr.charAt(i);
      if (isOpenBracket(c)) {
        stack.push(new BracketInfo(c, i));
      } else if (isCloseBracket(c)) {
        if (!stack.isEmpty()) {
          BracketInfo openBracket = stack.pop();
          if (isMatchingBracket(openBracket.character, c)) {
            bracketPairs.add(new BracketPair(openBracket.position, i));
          }
        }
      }
    }

    // Color the brackets based on their depth
    for (BracketPair pair : bracketPairs) {
      int depth = calculateBracketDepth(textStr, pair.openPos);
      int colorIndex = depth % rainbowColors.length;

      // Color open bracket
      text.setSpan(
          new ForegroundColorSpan(rainbowColors[colorIndex]),
          pair.openPos,
          pair.openPos + 1,
          Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

      // Color close bracket
      text.setSpan(
          new ForegroundColorSpan(rainbowColors[colorIndex]),
          pair.closePos,
          pair.closePos + 1,
          Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
    }
  }

  /** Remove all rainbow bracket spans */
  private void removeRainbowBrackets(Editable text) {
    ForegroundColorSpan[] spans = text.getSpans(0, text.length(), ForegroundColorSpan.class);
    for (ForegroundColorSpan span : spans) {
      // Only remove rainbow bracket spans (you might want to be more specific here)
      text.removeSpan(span);
    }
  }

  /** Calculate bracket depth at given position */
  private int calculateBracketDepth(String text, int position) {
    int depth = 0;
    for (int i = 0; i <= position; i++) {
      char c = text.charAt(i);
      if (isOpenBracket(c)) {
        depth++;
      } else if (isCloseBracket(c)) {
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

  // Helper classes for bracket tracking
  private static class BracketInfo {
    char character;
    int position;

    BracketInfo(char character, int position) {
      this.character = character;
      this.position = position;
    }
  }

  private static class BracketPair {
    int openPos;
    int closePos;

    BracketPair(int openPos, int closePos) {
      this.openPos = openPos;
      this.closePos = closePos;
    }
  }

  private void checkValidity(Editable s) {
    String s1 = s.toString();
    Stack stackCheck = new Stack();
    char[] valid = s1.toCharArray();
    for (char c : valid) {
      if (c == '{' || c == '(') {
        stackCheck.push((c));
      }
      if (c == '}' || c == ')') {
        if (stackCheck.empty()) {
          Toast.makeText(getContext(), "Your Code Has Invalid Parenthesis", Toast.LENGTH_LONG)
              .show();
          return;
        } else {
          if (!matchPair((char) stackCheck.peek(), c)) {
            Toast.makeText(getContext(), "Your Code Has Invalid Parenthesis", Toast.LENGTH_LONG)
                .show();
            return;
          }
          stackCheck.pop();
        }
      }
    }
    if (stackCheck.size() == 1) {
      Toast.makeText(getContext(), "Unmatched Parenthesis", Toast.LENGTH_LONG).show();
    }
  }

  private boolean matchPair(char c1, char c2) {
    if (c1 == '(' && c2 == ')') return true;
    else if (c1 == '{' && c2 == '}') return true;
    else return c1 == '[' && c2 == ']';
  }

  public void checkMyCode() {
    checkValidity(code.getText());
  }

  private char getLastDifference(String a, String b) {
    // a is new
    char[] c1 = a.toCharArray();
    // b is old
    char[] c2 = b.toCharArray();

    if (b.length() > a.length()) return '.';
    if (c1.length == 0 || c2.length == 0) return '.';
    if (c1[c1.length - 1] != c2[c2.length - 1]) {
      return c1[c1.length - 1];
    }
    for (int i = 0; i < b.length(); i++) {
      if (c1[i] != c2[i]) {
        return c1[i];
      }
    }
    return '.';
  }

  public void setAutoIndent(boolean val) {
    this.autoIndent = val;
  }

  public EditText getCode() {
    return code;
  }

  /**
   * Check if rainbow brackets is enabled
   *
   * @return true if rainbow brackets is enabled
   */
  public boolean isRainbowBracketsEnabled() {
    return rainbowBrackets;
  }
}
