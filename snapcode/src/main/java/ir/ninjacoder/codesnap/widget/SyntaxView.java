package ir.ninjacoder.codesnap.widget;

import android.animation.*;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.ClipData;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.InputType;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.BackgroundColorSpan;
import android.text.style.StyleSpan;
import android.text.Spannable;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.inputmethod.EditorInfo;

import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.tooltip.TooltipDrawable;
import ir.ninjacoder.codesnap.R;
import ir.ninjacoder.codesnap.Utils.ObjectUtils;
import ir.ninjacoder.codesnap.colorhelper.ColorHelper;
import ir.ninjacoder.codesnap.folding.CodeFoldingManager;
import ir.ninjacoder.codesnap.markdownpreview.MarkDownTextHelper;

public class SyntaxView extends ScrollView {
  private CodeEditText code;
  private boolean autoIndent = false;
  private LineNumberCalculator lineCode;
  private ColorHelper color = new ColorHelper();
  private CodeFoldingManager foldingManager;
  private boolean codeFoldingEnabled = true;
  private TextView tv;
  private String oldText = "";
  private TextWatcher textWatcher;
  private IncrementalHighlighter incrementalHighlighter;
  private boolean isMarkdownMode = false;
  private TooltipDrawable tooltip;
  private boolean isTooltipShowing = false;
  private int originalStart = -1;
  private int originalEnd = -1;
  private String originalText = "";

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
    tv = findViewById(R.id.mark);
    lineCode = new LineNumberCalculator(code.getText().toString());
    foldingManager = new CodeFoldingManager(color);
    code.setTextSize(14);
    code.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
    code.setSingleLine(false);
    code.setImeOptions(EditorInfo.IME_FLAG_NO_ENTER_ACTION);
    code.setBackgroundColor(Color.TRANSPARENT);
    setHorizontalScrollBarEnabled(true);
    code.setSelection(code.getText().length());
    code.setLineNumberColor(color.getLinenumbercolor());
    applyTheme();
    updateLineNumbers();

    code.setOnLongClickListener(
        v -> {
          int start = code.getSelectionStart();
          int end = code.getSelectionEnd();

          if (start != end) {
            String selectedText = code.getText().toString().substring(start, end);

            originalStart = start;
            originalEnd = end;
            originalText = selectedText;

            ClipData data = ClipData.newPlainText("text", selectedText);
            View.DragShadowBuilder shadow = new CustomDragShadowBuilder(code, start, end);
            v.startDragAndDrop(data, shadow, null, View.DRAG_FLAG_OPAQUE);

            return true;
          }
          return false;
        });
    code.setOnDragListener(
        new View.OnDragListener() {
          private ValueAnimator cursorAnimator;

          @Override
          public boolean onDrag(View v, DragEvent event) {
            switch (event.getAction()) {
              case DragEvent.ACTION_DRAG_STARTED:
                animateCursorAlpha(0.3f, 1.0f, 200);
                return true;

              case DragEvent.ACTION_DRAG_ENTERED:
                animateBackgroundColor(0x1067C8F5, 300);
                return true;

              case DragEvent.ACTION_DRAG_LOCATION:
                int pos = code.getOffsetForPosition(event.getX(), event.getY());
                animateCursorPosition(pos);
                return true;

              case DragEvent.ACTION_DRAG_EXITED:
                animateBackgroundColor(Color.TRANSPARENT, 200);
                return true;

              case DragEvent.ACTION_DROP:
                ClipData.Item item = event.getClipData().getItemAt(0);
                String draggedText = item.getText().toString();

                animateBackgroundColor(0x3067C8F5, 150);

                int dropPos = code.getSelectionStart();
                code.getText().insert(dropPos, draggedText);

                animateCursorAlpha(1.0f, 0.3f, 100);
                animateCursorAlpha(0.3f, 1.0f, 100);

                originalStart = -1;
                originalEnd = -1;
                originalText = "";

                return true;

              case DragEvent.ACTION_DRAG_ENDED:
                if (originalStart != -1 && originalEnd != -1) {
                  code.getText().insert(originalStart, originalText);
                  code.setSelection(originalStart + originalText.length());
                }

                animateBackgroundColor(Color.TRANSPARENT, 300);
                animateCursorAlpha(code.getAlpha(), 1.0f, 200);

                originalStart = -1;
                originalEnd = -1;
                originalText = "";

                return true;
            }
            return true;
          }

          private void animateBackgroundColor(int targetColor, int duration) {
            ValueAnimator colorAnimator =
                ValueAnimator.ofObject(
                    new ArgbEvaluator(), ((TextView) code).getHighlightColor(), targetColor);
            colorAnimator.setDuration(duration);
            colorAnimator.addUpdateListener(
                animator -> {
                  ((TextView) code).setHighlightColor((int) animator.getAnimatedValue());
                });
            colorAnimator.start();
          }

          private void animateCursorAlpha(float from, float to, int duration) {
            if (cursorAnimator != null && cursorAnimator.isRunning()) {
              cursorAnimator.cancel();
            }

            cursorAnimator = ValueAnimator.ofFloat(from, to);
            cursorAnimator.setDuration(duration);
            cursorAnimator.addUpdateListener(
                animator -> {
                  float alpha = (float) animator.getAnimatedValue();
                  code.setAlpha(alpha);
                });
            cursorAnimator.start();
          }

          private void animateCursorPosition(int newPos) {
            AnimatorSet set = new AnimatorSet();
            ObjectAnimator cursorAnim = ObjectAnimator.ofInt(code, "selectionStart", newPos);
            ObjectAnimator cursorAnim2 = ObjectAnimator.ofInt(code, "selectionEnd", newPos);
            set.playTogether(cursorAnim, cursorAnim2);
            set.setDuration(50);
            set.start();
          }
        });
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

    // code.addTextChangedListener(textWatcher);
  }

  public void setLangType(LangType langType) {
      Highlighter highlighter = new CodeImpl();
      incrementalHighlighter = new IncrementalHighlighter(highlighter, langType, color);
      incrementalHighlighter.attach(code.getText());
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
      code.setShowLineNumbers(show);
      code.setAlpha(0f);
      code.setScaleX(0.8f);
      code.setScaleY(0.8f);
      code.animate()
          .alpha(1f)
          .scaleX(1f)
          .scaleY(1f)
          .setDuration(350)
          .setInterpolator(new OvershootInterpolator(1.0f))
          .setListener(null);
    } else {
      code.animate()
          .alpha(0f)
          .scaleX(0.8f)
          .scaleY(0.8f)
          .setDuration(250)
          .setInterpolator(new AccelerateInterpolator())
          .setListener(
              new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                  code.setShowLineNumbers(show);
                  code.setAlpha(1f);
                  code.setScaleX(1f);
                  code.setScaleY(1f);
                }
              });
    }
    updateLineNumbers();
  }

  public void setFont(Typeface tf) {
    code.setTypeface(tf);
  }

  public void setTypeFaceEditor(Typeface f) {
    code.setTypeface(f);
  }

  public void setTypeFaceLineNumber(Typeface d) {
    code.setLineNumberTypeFace(d);
  }

  public void setText(String text) {
    code.removeTextChangedListener(textWatcher);
    code.setText(text);
    updateLineNumbers();
    code.addTextChangedListener(textWatcher);
  }

  public String getText() {
    return code.getText().toString();
  }

  public void setTextSize(float size) {
    code.setTextSize(size);
  }

  public void setTextColor(int color) {
    code.setTextColor(color);
  }

  void setLineNumberBackgroundColor(int color) {}

  void setCodeBackgroundColor(int color) {
    code.setBackgroundColor(color);
  }

  public void setPadding(int left, int top, int right, int bottom) {
    code.setPadding(left, top, right, bottom);
  }

  public void setLineNumberPadding(int left, int top, int right, int bottom) {}

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

    setCodeBackgroundColor(Color.TRANSPARENT);
    setTextColor(color.getTextnormal());
    invalidate();
  }

  public void setColorHelper(ColorHelper colorHelper) {
    this.color = colorHelper;
    applyTheme();
  }

  private void updateLineNumbers() {
    String text = code.getText().toString();
    int numLines = text.isEmpty() ? 1 : countLines(text);

    StringBuilder linesText = new StringBuilder();
    for (int i = 1; i <= numLines; i++) {
      linesText.append(i).append("\n");
    }
  }

  private int countLines(String text) {
    int count = 1;
    for (int i = 0; i < text.length(); i++) {
      if (text.charAt(i) == '\n') {
        count++;
      }
    }
    return count;
  }

  public void showMarkDownView(boolean showMarkdown) {
    if (showMarkdown) {
      // Switch to Markdown view
      if (code.getVisibility() == VISIBLE) {
        // Animate code view out
        code.animate()
            .scaleX(0.7f)
            .scaleY(0.7f)
            .alpha(0f)
            .setDuration(300)
            .setInterpolator(new AccelerateInterpolator())
            .withEndAction(
                () -> {
                  code.setVisibility(GONE);
                  code.setScaleX(1f);
                  code.setScaleY(1f);
                  code.setAlpha(1f);

                  // Show markdown view after code view hides
                  tv.setVisibility(VISIBLE);
                  tv.setScaleX(0.5f);
                  tv.setScaleY(0.5f);
                  tv.setAlpha(0f);
                  MarkDownTextHelper.handleMarkDown(tv, code.getText().toString());

                  tv.animate()
                      .scaleX(1f)
                      .scaleY(1f)
                      .alpha(1f)
                      .setDuration(400)
                      .setInterpolator(new OvershootInterpolator(0.8f))
                      .start();
                })
            .start();
      }
      isMarkdownMode = true;
    } else {
      // Switch to code view
      if (tv.getVisibility() == VISIBLE) {
        // Animate markdown view out
        tv.animate()
            .scaleX(0.7f)
            .scaleY(0.7f)
            .alpha(0f)
            .setDuration(300)
            .setInterpolator(new AccelerateInterpolator())
            .withEndAction(
                () -> {
                  tv.setVisibility(GONE);
                  tv.setScaleX(1f);
                  tv.setScaleY(1f);
                  tv.setAlpha(1f);

                  // Show code view after markdown view hides
                  code.setVisibility(VISIBLE);
                  code.setScaleX(0.5f);
                  code.setScaleY(0.5f);
                  code.setAlpha(0f);

                  code.animate()
                      .scaleX(1f)
                      .scaleY(1f)
                      .alpha(1f)
                      .setDuration(400)
                      .setInterpolator(new OvershootInterpolator(0.8f))
                      .start();
                })
            .start();
      }
      isMarkdownMode = false;
    }

    invalidate();
    requestLayout();
  }

  public void toggleMarkdownView() {
    showMarkDownView(!isMarkdownMode);
  }

  public boolean getisMarkdownMode() {
    return this.isMarkdownMode;
  }

  private static class CustomDragShadowBuilder extends View.DragShadowBuilder {
    private final Paint paint;
    private final Paint bgPaint;
    private final Rect bounds;
    private final String selectedText;

    public CustomDragShadowBuilder(View view, int start, int end) {
      super(view);
      TextView textView = (TextView) view;
      this.selectedText = textView.getText().subSequence(start, end).toString();
      float textSize = textView.getTextSize();

      paint = new Paint();
      paint.setTextSize(textSize);
      paint.setColor(Color.WHITE);
      paint.setAntiAlias(true);
      paint.setStyle(Paint.Style.FILL);

      bgPaint = new Paint();
      bgPaint.setColor(0xCC2196F3);
      bgPaint.setAntiAlias(true);
      bgPaint.setStyle(Paint.Style.FILL);

      bounds = new Rect();
      paint.getTextBounds(selectedText, 0, selectedText.length(), bounds);
    }

    @Override
    public void onDrawShadow(Canvas canvas) {
      RectF rect = new RectF(0, 0, bounds.width() + 32, bounds.height() + 24);
      canvas.drawRoundRect(rect, 16, 16, bgPaint);
      canvas.drawText(selectedText, 16, bounds.height() + 8, paint);
    }

    @Override
    public void onProvideShadowMetrics(Point shadowSize, Point shadowTouchPoint) {
      shadowSize.set(bounds.width() + 48, bounds.height() + 32);
      shadowTouchPoint.set(shadowSize.x / 2, shadowSize.y / 2);
    }
  }
}
