package ir.ninjacoder.code.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.widget.ScrollView;
import android.widget.TextView;

import ir.ninjacoder.code.R;
import ir.ninjacoder.code.colorhelper.ColorHelper;

public class SyntaxView extends ScrollView {
  private CodeEditText code;
  private TextView rows;
  private boolean autoIndent = false;
  private ColorHelper color=new ColorHelper();
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
    rows.setTextColor(color.getLinenumbercolor());
    code.addTextChangedListener(
        new TextWatcher() {
          String oldText;

          @Override
          public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            oldText = s.toString();
          }

          @Override
          public void onTextChanged(CharSequence s, int start, int before, int count) {
            int numLines = code.getLineCount();
            StringBuilder linesText = new StringBuilder();
            for (int i = 1; i <= numLines; i++) {
              linesText.append(i).append("\n");
            }
            rows.setText(linesText.toString());
          }

          @Override
          public void afterTextChanged(Editable s) {
            if (autoIndent) {
              char lastDiff = getLastDifference(s.toString(), oldText);
              if (lastDiff == '{' || lastDiff == ':') {
                int pos = code.getSelectionStart();
                code.getText().insert(pos, "\n ");
                code.setSelection(pos + 2);
              }
            }
            // چون CodeEditText خودش invalidate می‌کنه، اینجا نیازی به رسم مجدد نیست اما امنه:
            code.invalidate();
          }
        });
  }

  private char getLastDifference(String a, String b) {
    if (a.equals(b)) return '.';
    int len = Math.min(a.length(), b.length());
    for (int i = 0; i < len; i++) {
      if (a.charAt(i) != b.charAt(i)) return a.charAt(i);
    }
    return a.length() > b.length() ? a.charAt(a.length() - 1) : '.';
  }

  public void setAutoIndent(boolean val) {
    this.autoIndent = val;
  }

  public void setRowNumbersColor(String color) {
    rows.setTextColor(Color.parseColor(color));
  }

  public void showLineNumber(boolean show) {
    rows.setVisibility(show ? VISIBLE : GONE);
  }

  public void setFont(Typeface tf) {
    code.setTypeface(tf);
    rows.setTypeface(tf);
  }

  public void setText(String text) {
    code.setText(text);
  }

  public String getText() {
    return code.getText().toString();
  }

  public void setTextSize(float size) {
    code.setTextSize(size);
    rows.setTextSize(size);
  }

  public void setTextColor(int color) {
    code.setTextColor(color);
  }

  public void setLineNumberBackgroundColor(int color) {
    rows.setBackgroundColor(color);
  }

  public void setCodeBackgroundColor(int color) {
    code.setBackgroundColor(color);
  }

  public void setPadding(int left, int top, int right, int bottom) {
    code.setPadding(left, top, right, bottom);
  }

  public void setLineNumberPadding(int left, int top, int right, int bottom) {
    rows.setPadding(left, top, right, bottom);
  }

  public void setHint(String hint) {
    code.setHint(hint);
  }

  public void setHintTextColor(int color) {
    code.setHintTextColor(color);
  }

  public void setSelection(int index) {
    code.setSelection(index);
  }

  public CodeEditText getCode() {
    return code;
  }
}
