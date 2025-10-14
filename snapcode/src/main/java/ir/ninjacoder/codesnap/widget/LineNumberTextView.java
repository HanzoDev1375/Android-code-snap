package ir.ninjacoder.codesnap.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;
import android.text.Layout;
import ir.ninjacoder.codesnap.colorhelper.ColorHelper;
import java.util.WeakHashMap;

public class LineNumberTextView extends EditText {
  private final Context context;
  private final Paint paint;
  private final Rect tempRect;
  private boolean showlinenumber;
  private boolean isInitialized = false;
  protected ColorHelper color;
  public LineNumberTextView(Context context) {
    super(context);
    this.context = context;
    paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    tempRect = new Rect();
    init();
  }

  public LineNumberTextView(Context context, AttributeSet attrs) {
    super(context, attrs);
    this.context = context;
    paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    tempRect = new Rect();
    init();
  }

  public LineNumberTextView(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
    this.context = context;
    paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    tempRect = new Rect();
    init();
  }

  private void init() {
    if (isInitialized) return;
    color = new ColorHelper();
    paint.setStyle(Paint.Style.FILL);
    paint.setColor(color.getLinenumbercolor());
    paint.setTextSize(35);
   // paint.setTypeface(Typeface.MONOSPACE);

    setBackgroundColor(Color.TRANSPARENT);
    isInitialized = true;
    setShowlinenumber(true);
  }

  @Override
  protected void onDraw(Canvas canvas) {
    // ابتدا شماره خطوط را رسم کنید
    drawLineNumbers(canvas);

    // سپس متن اصلی را رسم کنید
    super.onDraw(canvas);

    // در نهایت هایلایت خط فعلی (اختیاری - اگر باعث کندی است غیرفعال کنید)
    // drawCurrentLineHighlight(canvas);
  }

  private void drawLineNumbers(Canvas canvas) {

    Layout layout = getLayout();
    if (layout == null) return;
    if (showlinenumber) {
      int lineCount = layout.getLineCount();
      int visibleLineCount = getHeight() / getLineHeight();
      int firstVisibleLine = getScrollY() / getLineHeight();
      int lastVisibleLine = Math.min(firstVisibleLine + visibleLineCount + 1, lineCount);

      // فقط خطوط قابل مشاهده را رسم کنید
      for (int i = firstVisibleLine; i < lastVisibleLine; i++) {
        int baseline = getLineBounds(i, null);
        String lineNumber = String.valueOf(i + 1);

        // محاسبه عرض متن برای ترازبندی
        float textWidth = paint.measureText(lineNumber);
        float x = 15; // فاصله از چپ

        canvas.drawText(lineNumber, x, baseline, paint);
      }

      // تنظیم padding بر اساس حداکثر عرض شماره خط
      setPaddingBasedOnLineCount(lineCount);
    }
  }

  private void setPaddingBasedOnLineCount(int lineCount) {
    int paddingLeft = 20;
    if (lineCount < 100) {
      paddingLeft = 50;
    } else if (lineCount < 1000) {
      paddingLeft = 60;
    } else if (lineCount < 10000) {
      paddingLeft = 70;
    } else {
      paddingLeft = 90;
    }

    setPadding(paddingLeft, getPaddingTop(), getPaddingRight(), getPaddingBottom());
  }

  private void drawCurrentLineHighlight(Canvas canvas) {
    try {
      Layout layout = getLayout();
      if (layout == null) return;

      int position = getSelectionStart();
      int line = layout.getLineForOffset(position);

      int lineTop = layout.getLineTop(line);
      int lineBottom = layout.getLineBottom(line);

      Paint highlightPaint = new Paint();
      highlightPaint.setColor(0x1A000000); // هایلایت بسیار ملایم
      highlightPaint.setStyle(Paint.Style.FILL);

      canvas.drawRect(0, lineTop, getWidth(), lineBottom, highlightPaint);

    } catch (Exception e) {
      // ignore
    }
  }

  @Override
  protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
    super.onTextChanged(text, start, lengthBefore, lengthAfter);

    // فقط در صورت نیاز مجدداً رسم کنید
    postInvalidate();
  }

  public boolean getShowlinenumber() {
    return this.showlinenumber;
  }

  public void setShowlinenumber(boolean showlinenumber) {
    this.showlinenumber = showlinenumber;
  }
}
