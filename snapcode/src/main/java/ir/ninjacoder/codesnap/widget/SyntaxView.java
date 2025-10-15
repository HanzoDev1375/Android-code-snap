package ir.ninjacoder.codesnap.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.InputType;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.BackgroundColorSpan;
import android.text.style.StyleSpan;
import android.text.Spannable;
import android.util.AttributeSet;
import android.view.animation.OvershootInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.inputmethod.EditorInfo;
import android.widget.ScrollView;
import android.widget.TextView;

import ir.ninjacoder.codesnap.R;
import ir.ninjacoder.codesnap.colorhelper.ColorHelper;
import ir.ninjacoder.codesnap.folding.CodeFoldingManager;

public class SyntaxView extends ScrollView {
  private CodeEditText code;
  private TextView rows;
  private boolean autoIndent = false;
  private LineNumberCalculator lineCode;
  private ColorHelper color = new ColorHelper();
  private CodeFoldingManager foldingManager;
  private boolean codeFoldingEnabled = true;
  private String oldText = "";
  private TextWatcher textWatcher;

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
    lineCode = new LineNumberCalculator(code.getText().toString());
    foldingManager = new CodeFoldingManager(color);

    code.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
    code.setSingleLine(false);
    code.setOnTextSizeChangedListener(
        size -> {
          rows.setTextSize(size);
        });
    code.setImeOptions(EditorInfo.IME_FLAG_NO_ENTER_ACTION);
    code.setBackgroundColor(Color.TRANSPARENT);
    code.setSelection(code.getText().length());
    rows.setTextColor(color.getLinenumbercolor());

    code.setOnFoldingToggleListener(
        line -> {
          toggleFoldingAtLine(line);
        });

    applyTheme();
    
    textWatcher =
        new TextWatcher() {
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

            if (codeFoldingEnabled) {
              foldingManager.detectFoldingRegions(s.toString());
            }
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
            code.invalidate();
          }
        };

    code.addTextChangedListener(textWatcher);
  }

  private char getLastDifference(String a, String b) {
    if (a.equals(b)) return '.';
    int len = Math.min(a.length(), b.length());
    for (int i = 0; i < len; i++) {
      if (a.charAt(i) != b.charAt(i)) return a.charAt(i);
    }
    return a.length() > b.length() ? a.charAt(a.length() - 1) : '.';
  }

  public void toggleFoldingAtLine(int line) {
    if (codeFoldingEnabled && foldingManager != null) {
      CodeFoldingManager.FoldingRegion region = foldingManager.findFoldingRegionAtLine(line);
      if (region != null) {
        foldingManager.toggleFolding(region);
        updateDisplayWithFolding();

        postInvalidate();
        code.invalidate();
      }
    }
  }

  private void updateDisplayWithFolding() {
    String originalText = code.getText().toString();
    int selection = code.getSelectionStart();

    code.removeTextChangedListener(textWatcher);

    foldingManager.detectFoldingRegions(originalText);
    SpannableStringBuilder foldedText = foldingManager.applyFolding(originalText);

    // حفظ هایلایت‌ها و استایل‌ها
    Editable currentText = code.getText();
    Object[] spans = currentText.getSpans(0, currentText.length(), Object.class);

    code.setText(foldedText);

    // بازگردانی هایلایت‌ها
    Editable newText = code.getText();
    for (Object span : spans) {
      if (span instanceof BackgroundColorSpan || span instanceof StyleSpan) {
        int start = currentText.getSpanStart(span);
        int end = currentText.getSpanEnd(span);
        if (start >= 0 && end <= newText.length()) {
          newText.setSpan(span, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
      }
    }

    int newSelection = calculateNewCursorPosition(originalText, foldedText.toString(), selection);
    if (newSelection >= 0 && newSelection <= foldedText.length()) {
      code.setSelection(newSelection);
    }

    code.addTextChangedListener(textWatcher);
  }

  private int calculateNewCursorPosition(String originalText, String foldedText, int originalPos) {

    if (originalText.equals(foldedText)) {
      return originalPos;
    }

    if (originalPos >= foldedText.length()) {
      return foldedText.length();
    }

    String[] originalLines = originalText.split("\n", -1);
    int originalLine = 0;
    int currentPos = 0;
    for (int i = 0; i < originalLines.length; i++) {
      currentPos += originalLines[i].length();
      if (currentPos >= originalPos) {
        originalLine = i;
        break;
      }
      currentPos++;
    }

    String[] foldedLines = foldedText.split("\n", -1);
    if (originalLine < foldedLines.length) {
      int newPos = 0;
      for (int i = 0; i < originalLine; i++) {
        newPos += foldedLines[i].length() + 1;
      }

      String originalLineText = originalLines[originalLine];
      String foldedLineText = foldedLines[originalLine];

      int lineStartPos = 0;
      for (int i = 0; i < originalLine; i++) {
        lineStartPos += originalLines[i].length() + 1;
      }
      int offsetInLine = originalPos - lineStartPos;

      offsetInLine = Math.min(offsetInLine, foldedLineText.length());

      return newPos + offsetInLine;
    }

    return foldedText.length();
  }

  public void setCodeFoldingEnabled(boolean enabled) {
    this.codeFoldingEnabled = enabled;
    code.setCodeFoldingEnabled(enabled);
  }

  public void setAutoIndent(boolean val) {
    this.autoIndent = val;
  }

  public void showLineNumber(boolean show) {
    if (show) {
      rows.setVisibility(VISIBLE);
      rows.setAlpha(0f);
      rows.setScaleX(0.8f);
      rows.setScaleY(0.8f);
      rows.animate()
          .alpha(1f)
          .scaleX(1f)
          .scaleY(1f)
          .setDuration(350)
          .setInterpolator(new OvershootInterpolator(1.0f))
          .setListener(null);
    } else {
      rows.animate()
          .alpha(0f)
          .scaleX(0.8f)
          .scaleY(0.8f)
          .setDuration(250)
          .setInterpolator(new AccelerateInterpolator())
          .setListener(
              new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                  rows.setVisibility(GONE);
                  rows.setAlpha(1f);
                  rows.setScaleX(1f);
                  rows.setScaleY(1f);
                }
              });
    }
  }

  public void setFont(Typeface tf) {
    code.setTypeface(tf);
    rows.setTypeface(tf);
  }

  public void setTypeFaceEditor(Typeface f) {
    code.setTypeface(f);
  }

  public void setTypeFaceLineNumber(Typeface d) {
    rows.setTypeface(d);
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

  void setLineNumberBackgroundColor(int color) {
    rows.setBackgroundColor(color);
  }

  void setCodeBackgroundColor(int color) {
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

  public int getLine() {
    return lineCode.getLine();
  }

  public int getColumn() {
    return lineCode.getColumn();
  }

  public int getStart() {
    return lineCode.findLineStart();
  }

  public int getEnd() {
    return lineCode.findLineEnd();
  }

  public void applyTheme() {
    rows.setTextColor(color.getLinenumbercolor());
    setCodeBackgroundColor(Color.TRANSPARENT);
    setTextColor(color.getTextnormal());
    invalidate();
  }

  public void setColorHelper(ColorHelper colorHelper) {
    this.color = colorHelper;
    applyTheme();
  }
}
