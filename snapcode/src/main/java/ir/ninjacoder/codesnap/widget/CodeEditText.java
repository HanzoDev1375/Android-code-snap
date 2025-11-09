package ir.ninjacoder.codesnap.widget;

import android.content.Context;
import android.text.Editable;
import android.text.Layout;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.BackgroundColorSpan;
import android.text.style.StyleSpan;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.GestureDetector;
import android.view.ScaleGestureDetector;
import android.widget.EditText;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Color;
import android.content.res.Resources;
import android.widget.MultiAutoCompleteTextView;
import ir.ninjacoder.codesnap.widget.data.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;

import ir.ninjacoder.codesnap.colorhelper.ColorHelper;
import ir.ninjacoder.codesnap.widget.ad.SuggestionAdapter;
import ir.ninjacoder.codesnap.widget.ad.KeywordTokenizer;
import ir.ninjacoder.codesnap.widget.editorbase.EffectType;
import ir.ninjacoder.codesnap.widget.editorbase.PowerModeEditText;

public class CodeEditText extends PowerModeEditText {

  private ColorHelper color = new ColorHelper();
  private BackgroundColorSpan currentSpan1, currentSpan2;
  private int lastCursorPos = -1;
  private StyleSpan boldSpan1, boldSpan2;
  private MultiAutoCompleteTextView.Tokenizer mAutoCompleteTokenizer;
  private ArrayList<String> suggestionsList;
  private ArrayList<String> suggestionsList1;
  private boolean codeStickyEnabled = true;
  private Paint stickyLineNumberPaint;
  private Paint stickyLineNumberBackgroundPaint;

  public interface OnTextSizeChangedListener {
    void onTextSizeChanged(float newSize);
  }

  public interface OnFoldingToggleListener {
    void onFoldingToggled(int lineNumber);
  }

  private OnTextSizeChangedListener textSizeChangedListener;
  private boolean isLineNumberPinned = false;
  private int pinnedLineNumber = -1;
  private GestureDetector gestureDetector;
  private ScaleGestureDetector scaleGestureDetector;
  private float scaleFactor = 1.0f;
  private final float minScale = 0.7f;
  private final float maxScale = 2.5f;
  private boolean isZooming = false;

  private OnFoldingToggleListener foldingToggleListener;
  private boolean codeFoldingEnabled = true;
  private boolean showLineNumbers = true;
  private int lineNumberWidth = 0;
  private Paint lineNumberPaint;
  private Paint lineNumberBackgroundPaint;
  private int lineNumberPadding = 16;
  private float baseTextSize;
  private float lineNumberTextSize;

  public CodeEditText(Context context) {
    super(context);
    init();
  }

  public CodeEditText(Context context, AttributeSet attrs) {
    super(context, attrs);
    init();
  }

  public CodeEditText(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();
  }

  public void setOnTextSizeChangedListener(OnTextSizeChangedListener listener) {
    this.textSizeChangedListener = listener;
  }

  public void setOnFoldingToggleListener(OnFoldingToggleListener listener) {
    this.foldingToggleListener = listener;
  }

  public void setCodeFoldingEnabled(boolean enabled) {
    this.codeFoldingEnabled = enabled;
    invalidate();
  }

  public boolean isCodeFoldingEnabled() {
    return codeFoldingEnabled;
  }

  public void addInlayAuto(String target, String hint, InlayTextSpan.Mode mode) {
    Editable text = getText();
    if (text == null || target == null || target.isEmpty()) return;

    String content = text.toString();
    int index = content.indexOf(target);
    if (index == -1) return;

    Layout layout = getLayout();
    if (layout == null) return;

    int line = layout.getLineForOffset(index);
    int lineStart = layout.getLineStart(line);
    int column = index - lineStart;

    addInlayAt(line, column, hint, mode);
  }

  public void addInlayAt(int line, int column, String hint, InlayTextSpan.Mode mode) {
    Editable text = getText();
    if (text == null) return;

    Layout layout = getLayout();
    if (layout == null) return;

    int lineStart = layout.getLineStart(line);
    int offset = lineStart + column;

    if (offset < 0 || offset > text.length()) return;

    int bgColor = Color.argb(60, 128, 128, 128);
    int textColor = Color.GRAY;

    InlayTextSpan span = new InlayTextSpan(hint, bgColor, textColor, mode);
    text.setSpan(
        span, offset, offset + targetLengthSafe(text, offset), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

    invalidate();
  }

  private int targetLengthSafe(CharSequence text, int start) {
    int end = start;
    while (end < text.length() && Character.isJavaIdentifierPart(text.charAt(end))) end++;
    return end - start;
  }

  private void applyZoom() {
    float newSize = baseTextSize * scaleFactor;

    super.setTextSize(TypedValue.COMPLEX_UNIT_PX, newSize);

    if (lineNumberPaint != null) {
      lineNumberPaint.setTextSize(newSize);
    }

    if (stickyLineNumberPaint != null) {
      stickyLineNumberPaint.setTextSize(newSize);
    }

    if (textSizeChangedListener != null) {
      textSizeChangedListener.onTextSizeChanged(newSize);
    }

    updateLineNumberWidth();
    requestLayout();
    invalidate();
  }

  private void init() {
    setHorizontallyScrolling(true);
    post(() -> resetZoom());
    setPinLineNumber(false);
    if (mAutoCompleteTokenizer == null) mAutoCompleteTokenizer = new KeywordTokenizer();
    setTokenizer(mAutoCompleteTokenizer);
    setDropDownWidth(Resources.getSystem().getDisplayMetrics().widthPixels / 2);
    setCursorVisible(false);

    gestureDetector = new GestureDetector(getContext(), new GestureListener());
    scaleGestureDetector = new ScaleGestureDetector(getContext(), new ScaleListener());
    baseTextSize = getTextSize();
    lineNumberTextSize = baseTextSize;
    setHint("Type code ");

    setHintTextColor(color.getLastsymi());
    initLineNumberPaints();
    initStickyLineNumberPaints();
    setCodeStickyEnabled(false);
    addTextChangedListener(
        new TextWatcher() {
          @Override
          public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

          @Override
          public void onTextChanged(CharSequence s, int start, int before, int count) {}

          @Override
          public void afterTextChanged(Editable s) {
            int cursorPos = getSelectionStart();
            if (cursorPos != lastCursorPos) {
              highlightByCursor(cursorPos);
              lastCursorPos = cursorPos;
            }
            if (isCursorVisible()) {
              setCursorVisible(false);
            }
            updateLineNumberWidth();
            invalidate();
          }
        });
  }

  private void initLineNumberPaints() {
    lineNumberPaint = new Paint();
    lineNumberPaint.setAntiAlias(true);
    lineNumberPaint.setTextSize(baseTextSize * scaleFactor);
    lineNumberPaint.setColor(color.getLinenumbercolor());
    lineNumberPaint.setTextAlign(Paint.Align.RIGHT);

    lineNumberBackgroundPaint = new Paint();
    lineNumberBackgroundPaint.setColor(Color.TRANSPARENT);
  }

  private void initStickyLineNumberPaints() {
    stickyLineNumberPaint = new Paint();
    stickyLineNumberPaint.setAntiAlias(true);
    stickyLineNumberPaint.setTextSize(baseTextSize * scaleFactor);
    stickyLineNumberPaint.setColor(color.getBracketlevel1());
    stickyLineNumberPaint.setTextAlign(Paint.Align.RIGHT);
    stickyLineNumberPaint.setTypeface(Typeface.DEFAULT_BOLD);

    stickyLineNumberBackgroundPaint = new Paint();
    stickyLineNumberBackgroundPaint.setColor(Color.argb(200, 40, 40, 40));
  }

  public void setCodeStickyEnabled(boolean enabled) {
    this.codeStickyEnabled = enabled;
    invalidate();
  }

  public boolean isCodeStickyEnabled() {
    return codeStickyEnabled;
  }

  private void updateLineNumberWidth() {
    if (!showLineNumbers) {
      lineNumberWidth = 0;
      setPadding(0, getPaddingTop(), getPaddingRight(), getPaddingBottom());
      return;
    }

    int lineCount = getLineCount();
    int maxDigits = Math.max(1, String.valueOf(Math.max(lineCount, 1)).length());

    float charWidth = lineNumberPaint.measureText("0");
    float textWidth = charWidth * (maxDigits + 1);
    lineNumberWidth = (int) textWidth + lineNumberPadding * 2;

    setPadding(lineNumberWidth, getPaddingTop(), getPaddingRight(), getPaddingBottom());
  }

  public void setLineNumberColor(int color) {
    lineNumberPaint.setColor(color);
  }

  @Override
  protected void onDraw(Canvas canvas) {
    canvas.save();

    if (showLineNumbers) {
      drawLineNumbers(canvas);

      if (codeStickyEnabled) {
        drawStickyLineNumber(canvas);
      }
    }

    canvas.clipRect(lineNumberWidth, 0, getWidth(), getHeight());
    super.onDraw(canvas);
    canvas.restore();
  }

  private void drawLineNumbers(Canvas canvas) {
    if (getLayout() == null) return;

    int baseline;
    int lineCount = getLineCount();
    int currentLine = getCurrentLine();

    canvas.drawRect(0, 0, lineNumberWidth, getHeight(), lineNumberBackgroundPaint);

    Paint separatorPaint = new Paint();
    separatorPaint.setColor(color.getLinenumbercolor());
    separatorPaint.setAlpha(50);
    canvas.drawLine(lineNumberWidth - 1, 0, lineNumberWidth - 1, getHeight(), separatorPaint);

    for (int i = 0; i < lineCount; i++) {
      baseline = getLineBounds(i, null);

      if (i == currentLine) {
        lineNumberPaint.setColor(color.getLinenumbercolor());
        lineNumberPaint.setTypeface(Typeface.DEFAULT_BOLD);
      } else {
        lineNumberPaint.setColor(color.getLinenumbercolor());
        lineNumberPaint.setTypeface(Typeface.DEFAULT);
      }

      String lineNumber = String.valueOf(i + 1);
      canvas.drawText(lineNumber, lineNumberWidth - lineNumberPadding, baseline, lineNumberPaint);
    }
  }

  private int getCurrentLine() {
    if (getLayout() == null) return 0;
    int selectionStart = getSelectionStart();
    return getLayout().getLineForOffset(selectionStart);
  }

  @Override
  protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    super.onSizeChanged(w, h, oldw, oldh);
    updateLineNumberWidth();
  }

  @Override
  protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
    super.onTextChanged(text, start, lengthBefore, lengthAfter);
    updateLineNumberWidth();
  }

  @Override
  public void setTextSize(float size) {
    super.setTextSize(size);
    this.baseTextSize = getTextSize();
    this.lineNumberTextSize = baseTextSize;
    updateLineNumberWidth();
  }

  @Override
  public void setTextSize(int unit, float size) {
    super.setTextSize(unit, size);
    this.baseTextSize = getTextSize();
    this.lineNumberTextSize = baseTextSize;
    updateLineNumberWidth();
  }

  public void setBaseTextSizePx(float px) {
    this.baseTextSize = px;
    this.lineNumberTextSize = px;
    applyZoom();
  }

  public void setShowLineNumbers(boolean show) {
    this.showLineNumbers = show;
    updateLineNumberWidth();
    invalidate();
  }

  public boolean isShowingLineNumbers() {
    return showLineNumbers;
  }

  public void setLineNumberBackgroundColor(int color) {
    lineNumberBackgroundPaint.setColor(color);
    invalidate();
  }

  public void setLineNumberPadding(int padding) {
    this.lineNumberPadding = padding;
    updateLineNumberWidth();
    invalidate();
  }

  public void setLineNumberTextSize(float size) {
    this.lineNumberTextSize = size;
    if (lineNumberPaint != null) {
      lineNumberPaint.setTextSize(size * scaleFactor);
      updateLineNumberWidth();
    }
    invalidate();
  }

  public float getLineNumberTextSize() {
    return lineNumberTextSize;
  }

  @Override
  public boolean onTouchEvent(MotionEvent event) {
    scaleGestureDetector.onTouchEvent(event);

    if (!scaleGestureDetector.isInProgress()) {
      gestureDetector.onTouchEvent(event);
    }

    if (event.getAction() == MotionEvent.ACTION_UP && !isZooming) {
      int offset = getOffsetForPosition(event.getX(), event.getY());
      highlightByCursor(offset);
    }

    return super.onTouchEvent(event);
  }

  private class GestureListener extends GestureDetector.SimpleOnGestureListener {
    @Override
    public boolean onDoubleTap(MotionEvent e) {
      resetZoom();
      return true;
    }
  }

  private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
    @Override
    public boolean onScale(ScaleGestureDetector detector) {
      isZooming = true;
      float newScale = scaleFactor * detector.getScaleFactor();
      newScale = Math.max(minScale, Math.min(newScale, maxScale));
      if (Math.abs(newScale - scaleFactor) > 0.01f) {
        scaleFactor = newScale;
        applyZoom();
      }
      return true;
    }

    @Override
    public void onScaleEnd(ScaleGestureDetector detector) {
      isZooming = false;
      invalidate();
      super.onScaleEnd(detector);
    }
  }

  public void resetZoom() {
    scaleFactor = 1.0f;
    applyZoom();

    postDelayed(
        () -> {
          updateLineNumberWidth();
          invalidate();
        },
        50);
  }

  public void zoomIn() {
    scaleFactor = Math.min(scaleFactor + 0.1f, maxScale);
    applyZoom();
  }

  public void zoomOut() {
    scaleFactor = Math.max(scaleFactor - 0.1f, minScale);
    applyZoom();
  }

  public void setZoom(float zoom) {
    scaleFactor = Math.max(minScale, Math.min(zoom, maxScale));
    applyZoom();
  }

  public float getZoom() {
    return scaleFactor;
  }

  private void highlightByCursor(int cursorPos) {
    Editable text = getText();
    if (text == null || text.length() == 0) return;
    removeOldHighlights(text);

    int length = text.length();
    char before = (cursorPos > 0) ? text.charAt(cursorPos - 1) : 0;
    char at = (cursorPos < length) ? text.charAt(cursorPos) : 0;
    if (isBracket(before)) {
      highlightBracketPair(cursorPos - 1);
    } else if (isBracket(at)) {
      highlightBracketPair(cursorPos);
    }

    invalidate();
  }

  private void highlightBracketPair(int pos) {
    Editable text = getText();
    if (text == null || pos < 0 || pos >= text.length()) return;
    removeOldHighlights(text);
    char c = text.charAt(pos);

    if (isOpenBracket(c)) {
      int match = findMatchingForward(text.toString(), pos, c);
      if (match != -1) applyHighlight(text, pos, match);
    } else if (isCloseBracket(c)) {
      int match = findMatchingBackward(text.toString(), pos, c);
      if (match != -1) applyHighlight(text, pos, match);
    }
  }

  private void applyHighlight(Editable text, int pos1, int pos2) {
    currentSpan1 = new BackgroundColorSpan(color.getBracketcolor());
    currentSpan2 = new BackgroundColorSpan(color.getBracketcolor());
    boldSpan1 = new StyleSpan(Typeface.BOLD);
    boldSpan2 = new StyleSpan(Typeface.BOLD);
    text.setSpan(currentSpan1, pos1, pos1 + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    text.setSpan(currentSpan2, pos2, pos2 + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    text.setSpan(boldSpan1, pos1, pos1 + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    text.setSpan(boldSpan2, pos2, pos2 + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
  }

  private void removeOldHighlights(Editable text) {
    if (currentSpan1 != null) text.removeSpan(currentSpan1);
    if (currentSpan2 != null) text.removeSpan(currentSpan2);
    if (boldSpan1 != null) text.removeSpan(boldSpan1);
    if (boldSpan2 != null) text.removeSpan(boldSpan2);
    currentSpan1 = null;
    currentSpan2 = null;
    boldSpan1 = null;
    boldSpan2 = null;
  }

  private boolean isBracket(char c) {
    return isOpenBracket(c) || isCloseBracket(c);
  }

  private boolean isOpenBracket(char c) {
    return c == '(' || c == '{' || c == '[' || c == '<';
  }

  private boolean isCloseBracket(char c) {
    return c == ')' || c == '}' || c == ']' || c == '>';
  }

  private int findMatchingForward(String text, int start, char open) {
    char close = getMatchingClose(open);
    int depth = 0;
    for (int i = start + 1; i < text.length(); i++) {
      char c = text.charAt(i);
      if (c == open) depth++;
      else if (c == close) {
        if (depth == 0) return i;
        depth--;
      }
    }
    return -1;
  }

  private int findMatchingBackward(String text, int start, char close) {
    char open = getMatchingOpen(close);
    int depth = 0;
    for (int i = start - 1; i >= 0; i--) {
      char c = text.charAt(i);
      if (c == close) depth++;
      else if (c == open) {
        if (depth == 0) return i;
        depth--;
      }
    }
    return -1;
  }

  private char getMatchingClose(char open) {
    switch (open) {
      case '(':
        return ')';
      case '{':
        return '}';
      case '[':
        return ']';
      case '<':
        return '>';
    }
    return 0;
  }

  private char getMatchingOpen(char close) {
    switch (close) {
      case ')':
        return '(';
      case '}':
        return '{';
      case ']':
        return '[';
      case '>':
        return '<';
    }
    return 0;
  }

  public void setUpListSuggestions(ArrayList<String> listStr) {
    suggestionsList = new ArrayList<>();
    String myWord = currentWord(this);
    for (String word : listStr) {
      if (word.contains(myWord)) {
        suggestionsList.add(word);
      }
    }
    SuggestionAdapter adapter = new SuggestionAdapter(getContext(), suggestionsList);
    setAdapter(adapter);
  }

  public String currentWord(EditText editText) {
    Spannable textSpan = editText.getText();
    final int selection = editText.getSelectionStart();
    final Pattern pattern = Pattern.compile("\\w+");
    final Matcher matcher = pattern.matcher(textSpan);
    int start = 0;
    int end = 0;
    String currentWord = "";
    while (matcher.find()) {
      start = matcher.start();
      end = matcher.end();
      if (start <= selection && selection <= end) {
        currentWord = textSpan.subSequence(start, end).toString();
        break;
      }
    }
    return currentWord;
  }

  public EffectType getEffectType() {
    return getEffectTypes();
  }

  public void setEffects(EffectType type) {
    setEffect(type);
  }

  public void setLineNumberTypeFace(Typeface f) {
    lineNumberBackgroundPaint.setTypeface(f);
  }

  public void setPinLineNumber(boolean pin) {
    this.isLineNumberPinned = pin;
    if (pin) {

      pinnedLineNumber = getCurrentLine();
    } else {

      pinnedLineNumber = -1;
    }
    invalidate();
  }

  public boolean isLineNumberPinned() {
    return isLineNumberPinned;
  }

  public int getPinnedLineNumber() {
    return pinnedLineNumber;
  }

  private void drawStickyLineNumber(Canvas canvas) {
    if (getLayout() == null) return;

    int lineToShow;
    if (isLineNumberPinned && pinnedLineNumber >= 0) {
      lineToShow = pinnedLineNumber;
    } else {
      lineToShow = getCurrentLine();
    }

    if (lineToShow < 0) return;

    int baseline = getLineBounds(lineToShow, null);
    int stickyTop = getScrollY();
    int stickyBottom = stickyTop + (int) getTextSize() + getPaddingTop();

    canvas.drawRect(0, stickyTop, lineNumberWidth, stickyBottom, stickyLineNumberBackgroundPaint);

    Paint separatorPaint = new Paint();
    separatorPaint.setColor(color.getLinenumbercolor());
    separatorPaint.setAlpha(100);
    canvas.drawLine(
        lineNumberWidth - 1, stickyTop, lineNumberWidth - 1, stickyBottom, separatorPaint);

    String lineNumber = String.valueOf(lineToShow + 1);
    float textY =
        stickyTop
            + (stickyBottom - stickyTop - stickyLineNumberPaint.getTextSize()) / 2
            + stickyLineNumberPaint.getTextSize();
    canvas.drawText(lineNumber, lineNumberWidth - lineNumberPadding, textY, stickyLineNumberPaint);
  }


  public interface OnSelectionChangedListener {
    void onSelectionChanged(int selStart, int selEnd);
  }
}
