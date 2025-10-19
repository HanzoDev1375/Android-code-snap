package ir.ninjacoder.codesnap;

import android.animation.LayoutTransition;
import android.content.ContentValues;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.StyleSpan;
import androidx.annotation.RequiresApi;
import ir.ninjacoder.codesnap.bracket.BracketManager;
import ir.ninjacoder.codesnap.colorhelper.ThemeLoader;
import ir.ninjacoder.codesnap.widget.CodeEditText;
import java.io.OutputStream;
import java.io.IOException;
import android.content.Context;
import android.graphics.Canvas;
import android.media.MediaScannerConnection;
import android.widget.Toast;
import android.graphics.Color;
import android.net.Uri;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.util.AttributeSet;
import ir.ninjacoder.codesnap.Utils.CodeImpl;
import ir.ninjacoder.codesnap.colorhelper.ColorHelper;
import ir.ninjacoder.codesnap.colorhelper.ThemeManager;
import ir.ninjacoder.codesnap.databinding.LayoutGroupBinding;
import ir.ninjacoder.codesnap.Utils.ColorUtil;
import ir.ninjacoder.codesnap.widget.SyntaxView;
import java.util.Date;
import android.os.Environment;
import android.graphics.Bitmap;
import java.io.File;
import java.io.FileOutputStream;

public class LayoutGroup extends LinearLayout {
  private LayoutGroupBinding binding;
  protected LangType type = LangType.JAVA;
  protected ColorHelper color;
  protected String fileName;
  private BracketManager manager;
  protected FormatImage img = FormatImage.PNG;

  public LayoutGroup(Context c) {
    super(c);
    init();
  }

  public LayoutGroup(Context c, AttributeSet s) {
    super(c, s);
    init();
  }

  public void init() {
    setOrientation(VERTICAL);
    binding = LayoutGroupBinding.inflate(LayoutInflater.from(getContext()), this, true);
    if (binding != null) {
      removeAllViews();
      addView(binding.getRoot());
    }

    setLayoutParams(
        new ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
    binding.red.setBackground(ColorUtil.get(Color.RED));
    binding.blue.setBackground(ColorUtil.get(Color.GREEN));
    binding.green.setBackground(ColorUtil.get(Color.YELLOW));
    color = new ColorHelper();
    manager = new BracketManager(color);
    
    getCode()
        .addTextChangedListener(
            new TextWatcher() {

              @Override
              public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {}

              @Override
              public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {}

              @Override
              public void afterTextChanged(Editable arg0) {
              //  highlightText(arg0.toString(), binding.editor.getCode());
              }
            });
    color.addOnThemeChangeListener(
        () -> {
          updateTheme();
        });

    applyInitialTheme();
    setOnTouchListener(
        (v, event) -> {
          if (event.getAction() == MotionEvent.ACTION_DOWN) {

            ObjectAnimator.ofFloat(v, SCALE_X, 1.26f).setDuration(350).start();
            ObjectAnimator.ofFloat(v, SCALE_Y, 1.26f).setDuration(350).start();
          } else if (event.getAction() == MotionEvent.ACTION_UP
              || event.getAction() == MotionEvent.ACTION_CANCEL) {
            ObjectAnimator.ofFloat(v, SCALE_X, 1f).setDuration(350).start();
            ObjectAnimator.ofFloat(v, SCALE_Y, 1f).setDuration(350).start();
          }
          return true;
        });
  }
  
  public void setText(String text){
    highlightText(text, binding.editor.getCode());
  }
  private void highlightText(String text, EditText editText) {
    try {
      CodeImpl code = new CodeImpl();
      final SpannableStringBuilder highlightedText = code.highlight(type, text, color);

      // اول متن رو ساده ست کن
      editText.setText(text);

      // انیمیشن بهینه‌شده
      animateOptimizedColorWave(editText, highlightedText);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void animateOptimizedColorWave(
      final EditText editText, final SpannableStringBuilder highlightedText) {
    final Editable editableText = editText.getText();
    final int totalLength = highlightedText.length();
    final int chunkSize = Math.max(100, totalLength / 30); // اندازه chunk داینامیک
    final long frameDelay = 90; // تأخیر کمتر

    new Handler(Looper.getMainLooper())
        .post(
            new Runnable() {
              int currentPos = 0;

              @Override
              public void run() {
                if (currentPos < totalLength) {
                  int endPos = Math.min(currentPos + chunkSize, totalLength);

                  // فقط اسپن‌های مربوط به این بخش رو اعمال کن
                  Object[] spans = highlightedText.getSpans(currentPos, endPos, Object.class);
                  for (Object span : spans) {
                    int start = highlightedText.getSpanStart(span);
                    int end = highlightedText.getSpanEnd(span);

                    // فقط اگر اسپن در محدوده فعلی هست
                    if (start < endPos && end > currentPos) {
                      Object newSpan = copySpan(span);
                      editableText.setSpan(newSpan, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    }
                  }

                  currentPos = endPos;
                  editText.postDelayed(this, frameDelay);
                }
              }
            });
  }

  // یا این نسخه ساده‌تر و سریع‌تر:
  private void animateFastColorWave(
      final EditText editText, final SpannableStringBuilder highlightedText) {
    final Editable editableText = editText.getText();
    final int totalLength = highlightedText.length();
    final int steps = 10; // فریم‌های کمتر
    final long delay = 30;

    new Handler(Looper.getMainLooper())
        .post(
            new Runnable() {
              int currentStep = 0;

              @Override
              public void run() {
                if (currentStep <= steps) {
                  float progress = (float) currentStep / steps;
                  int currentPos = (int) (totalLength * progress);

                  // فقط اسپن‌های جدید رو اضافه کن
                  Object[] spans =
                      highlightedText.getSpans(currentPos - 100, currentPos, Object.class);
                  for (Object span : spans) {
                    int start = highlightedText.getSpanStart(span);
                    int end = highlightedText.getSpanEnd(span);
                    if (end <= currentPos
                        && editableText.getSpans(start, end, span.getClass()).length == 0) {
                      editableText.setSpan(
                          copySpan(span), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    }
                  }

                  currentStep++;
                  editText.postDelayed(this, delay);
                }
              }
            });
  }

  private Object copySpan(Object span) {
    if (span instanceof ForegroundColorSpan) {
      return new ForegroundColorSpan(((ForegroundColorSpan) span).getForegroundColor());
    } else if (span instanceof BackgroundColorSpan) {
      return new BackgroundColorSpan(((BackgroundColorSpan) span).getBackgroundColor());
    } else if (span instanceof StyleSpan) {
      return new StyleSpan(((StyleSpan) span).getStyle());
    }
    return span;
  }

  void updateHighlight() {
    String currentText = binding.editor.getCode().getText().toString();
    highlightText(currentText, binding.editor.getCode());
  }

  public LangType getType() {
    return this.type;
  }

  public void setType(LangType type) {
    this.type = type;
    updateHighlight();
  }

  public boolean getFilePath(String path) {
    return this.type.hasFile(path);
  }

  public ColorHelper getColor() {
    return this.color;
  }

  public ThemeLoader getTheme() {
    return this.color.getTheme();
  }

  public void setThemeCustom(String path) {
    getTheme().setPath(path);
  }

  public SyntaxView getEditor() {
    return binding.editor;
  }

  public CodeEditText getCode() {
    return getEditor().getCode();
  }

  public void setTheme(ThemeManager theme) {
    color.setThememanager(theme);
  }

  private void applyInitialTheme() {
    updateEditorTheme();
  }

  private void updateEditorTheme() {
    if (binding.editor != null) {
      binding.editor.setColorHelper(color);
      binding.editor.applyTheme();
    }
  }

  private void updateTheme() {
    updateEditorTheme();
    binding.getRoot().setCardBackgroundColor(color.getCardbackground());
    binding.getRoot().setStrokeColor(color.getCardstorkecolor());
    updateHighlight();
    manager.updateRainbowColors();
    setLayoutChange();
  }

  @Override
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    color.removeOnThemeChangeListener(
        new ColorHelper.OnThemeChangeListener() {
          @Override
          public void onThemeChanged() {
            updateTheme();
          }
        });
  }

  void setLayoutChange() {
    LayoutTransition transition = new LayoutTransition();
    transition.enableTransitionType(LayoutTransition.CHANGING);
    transition.enableTransitionType(LayoutTransition.APPEARING);
    transition.enableTransitionType(LayoutTransition.DISAPPEARING);
    transition.enableTransitionType(LayoutTransition.CHANGE_APPEARING);
    transition.enableTransitionType(LayoutTransition.CHANGE_DISAPPEARING);
    transition.addTransitionListener(
        new LayoutTransition.TransitionListener() {
          @Override
          public void startTransition(
              LayoutTransition transition, ViewGroup container, View view, int transitionType) {}

          @Override
          public void endTransition(
              LayoutTransition transition, ViewGroup container, View view, int transitionType) {
            if (view != binding.getRoot()) {
              return;
            }
            view.requestLayout();
          }
        });
    binding.getRoot().setLayoutTransition(transition);
  }

  public void takeScreenshot() {
    /// png
    takeScreenshot(img);
  }

  public void takeScreenshot(FormatImage frm) {
    Date now = new Date();
    switch (frm) {
      case PNG:
        fileName = "screenshot_" + (String) DateFormat.format("yyyy-MM-dd_HH-mm-ss", now) + ".png";
        break;
      case JPEG:
        fileName = "screenshot_" + (String) DateFormat.format("yyyy-MM-dd_HH-mm-ss", now) + ".jpg";
        break;
      case WEBP:
        fileName = "screenshot_" + (String) DateFormat.format("yyyy-MM-dd_HH-mm-ss", now) + ".webp";
        break;
      case PDF:
        fileName =
            "screenshot_"
                + (String) DateFormat.format("yyyy-MM-dd_HH-mm-ss", now)
                + type.getLangname()
                + ".pdf";
        break;
      default:
        fileName = "screenshot_" + (String) DateFormat.format("yyyy-MM-dd_HH-mm-ss", now) + ".png";
        break;
    }

    try {
      View cardView = binding.card;

      cardView.post(
          () -> {
            try {
              Bitmap bitmap =
                  Bitmap.createBitmap(
                      cardView.getWidth(), cardView.getHeight(), Bitmap.Config.ARGB_8888);

              Canvas canvas = new Canvas(bitmap);
              cardView.draw(canvas);
              saveBitmapToMediaStore(bitmap, fileName, frm);

            } catch (Exception e) {
              e.printStackTrace();
              Toast.makeText(getContext(), get(R.string.errortoshat), Toast.LENGTH_SHORT).show();
            }
          });

    } catch (Throwable e) {
      e.printStackTrace();
      Toast.makeText(getContext(), get(R.string.errortoshat), Toast.LENGTH_SHORT).show();
    }
  }

  private void saveBitmapToMediaStore(Bitmap bitmap, String fileName, FormatImage im) {
    if (im == FormatImage.PDF) {
      saveAsPdfNative(bitmap, fileName);
      return;
    }

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
      ContentValues contentValues = new ContentValues();
      contentValues.put(MediaStore.Images.Media.DISPLAY_NAME, fileName);

      String mimeType = "image/png";
      switch (im) {
        case PNG:
          mimeType = "image/png";
          break;
        case JPEG:
          mimeType = "image/jpeg";
          break;
        case WEBP:
          mimeType = "image/webp";
          break;
      }
      contentValues.put(MediaStore.Images.Media.MIME_TYPE, mimeType);

      contentValues.put(
          MediaStore.Images.Media.RELATIVE_PATH,
          Environment.DIRECTORY_PICTURES + "/AndroidCodeSnap");

      Uri uri =
          getContext()
              .getContentResolver()
              .insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);

      if (uri != null) {
        try (OutputStream outputStream = getContext().getContentResolver().openOutputStream(uri)) {
          if (outputStream != null) {
            switch (im) {
              case PNG:
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
                break;
              case JPEG:
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
                break;
              case WEBP:
                bitmap.compress(Bitmap.CompressFormat.WEBP_LOSSY, 100, outputStream);
                break;
            }
            Toast.makeText(getContext(), get(R.string.savedshat), Toast.LENGTH_SHORT).show();
          }
        } catch (IOException e) {
          e.printStackTrace();
          Toast.makeText(
                  getContext(), get(R.string.errortoshat) + e.getMessage(), Toast.LENGTH_LONG)
              .show();
        }
      }
    } else {
      // کد برای اندروید پایین‌تر از Q (بدون PDF)
      try {
        File directory =
            new File(
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                "AndroidCodeSnap");
        if (!directory.exists()) {
          directory.mkdirs();
        }

        File imageFile = new File(directory, fileName);
        try (FileOutputStream outputStream = new FileOutputStream(imageFile)) {
          switch (im) {
            case PNG:
              bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
              break;
            case JPEG:
              bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
              break;
            case WEBP:
              bitmap.compress(Bitmap.CompressFormat.WEBP_LOSSY, 100, outputStream);
              break;
          }

          String mimeType = "image/png";
          switch (im) {
            case PNG:
              mimeType = "image/png";
              break;
            case JPEG:
              mimeType = "image/jpeg";
              break;
            case WEBP:
              mimeType = "image/webp";
              break;
          }

          MediaScannerConnection.scanFile(
              getContext(),
              new String[] {imageFile.getAbsolutePath()},
              new String[] {mimeType},
              null);

          Toast.makeText(getContext(), get(R.string.savedshat), Toast.LENGTH_SHORT).show();
        }
      } catch (IOException e) {
        e.printStackTrace();
        Toast.makeText(getContext(), get(R.string.errortoshat) + e.getMessage(), Toast.LENGTH_LONG)
            .show();
      }
    }
  }

  @RequiresApi(api = Build.VERSION_CODES.KITKAT)
  private void saveAsPdfNative(Bitmap bitmap, String fileName) {
    PdfDocument document = new PdfDocument();

    try {
      PdfDocument.PageInfo pageInfo =
          new PdfDocument.PageInfo.Builder(bitmap.getWidth(), bitmap.getHeight(), 1).create();

      PdfDocument.Page page = document.startPage(pageInfo);
      Canvas canvas = page.getCanvas();
      canvas.drawBitmap(bitmap, 0, 0, new Paint());
      document.finishPage(page);

      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(MediaStore.Files.FileColumns.DISPLAY_NAME, fileName);
        contentValues.put(MediaStore.Files.FileColumns.MIME_TYPE, "application/pdf");
        contentValues.put(
            MediaStore.Files.FileColumns.RELATIVE_PATH,
            Environment.DIRECTORY_DOCUMENTS + "/AndroidCodeSnap");

        Uri uri =
            getContext()
                .getContentResolver()
                .insert(MediaStore.Files.getContentUri("external"), contentValues);

        if (uri != null) {
          try (OutputStream out = getContext().getContentResolver().openOutputStream(uri)) {
            document.writeTo(out);
            Toast.makeText(getContext(), get(R.string.pdfsave), Toast.LENGTH_SHORT).show();
          } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(getContext(), get(R.string.pdferror) + e.getMessage(), Toast.LENGTH_LONG)
                .show();
          }
        } else {
          Toast.makeText(getContext(), get(R.string.pdferror), Toast.LENGTH_SHORT).show();
        }
      } else {

        File directory =
            new File(
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS),
                "AndroidCodeSnap");

        if (!directory.exists()) {
          boolean created = directory.mkdirs();
          if (!created) {
            Toast.makeText(getContext(), get(R.string.foldererror), Toast.LENGTH_SHORT).show();
            return;
          }
        }

        File pdfFile = new File(directory, fileName);
        try (FileOutputStream out = new FileOutputStream(pdfFile)) {
          document.writeTo(out);
          MediaScannerConnection.scanFile(
              getContext(),
              new String[] {pdfFile.getAbsolutePath()},
              new String[] {"application/pdf"},
              null);

          Toast.makeText(getContext(), get(R.string.pdfsave), Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
          e.printStackTrace();
          Toast.makeText(getContext(), get(R.string.pdferror) + e.getMessage(), Toast.LENGTH_LONG)
              .show();
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
      Toast.makeText(getContext(), get(R.string.pdferror) + e.getMessage(), Toast.LENGTH_LONG)
          .show();
    } finally {
      document.close();
    }
  }

  public FormatImage getFormatImage() {
    return this.img;
  }

  private String get(int stringres) {
    return getContext().getString(stringres);
  }
}
