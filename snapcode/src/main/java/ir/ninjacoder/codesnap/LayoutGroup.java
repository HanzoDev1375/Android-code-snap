package ir.ninjacoder.codesnap;

import android.animation.ArgbEvaluator;
import android.animation.LayoutTransition;
import android.animation.ValueAnimator;
import android.content.ClipboardManager;
import android.content.ClipData;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.graphics.PorterDuff;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.annotation.RequiresApi;
import ir.ninjacoder.codesnap.Utils.ObjectUtils;
import ir.ninjacoder.codesnap.Utils.opt.LightSourceDrawable;
import ir.ninjacoder.codesnap.bracket.BracketManager;
import ir.ninjacoder.codesnap.colorhelper.ThemeLoader;
import ir.ninjacoder.codesnap.widget.CodeEditText;
import java.io.ByteArrayOutputStream;
import android.util.Base64;
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
import java.util.Arrays;
import java.util.Date;
import android.os.Environment;
import android.graphics.Bitmap;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import android.graphics.Point;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class LayoutGroup extends LinearLayout {
  private LayoutGroupBinding binding;
  protected LangType type = LangType.JAVA;
  protected ColorHelper color;
  protected String fileName;
  private BracketManager manager;
  private boolean isShowCopyIcon = false;
  private boolean iconRgbMod = false, isRgbCard;
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

    var drawable = new LightSourceDrawable();
    setIsShowCopyIcon(false);
    binding.copyicon.setOnClickListener(
        __ -> {
          copyText();
        });
    drawable.setRippleMinSize(10f);
    drawable.setRippleMaxSize(50f);
    drawable.setHighlightColor(color.getCardstorkecolor());

    binding.editor.getCode().setForeground(drawable);
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
    binding.eyeicon.setOnClickListener(
        v -> {
          boolean newState = !getEditor().getisMarkdownMode();
          getEditor().toggleMarkdownView();
          ObjectUtils.animIcon(
              binding.eyeicon, newState ? R.drawable.eyeoff_24px : R.drawable.eyeon_24px);
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
        setStorkeAnimator();
  }

  public void setText(String text) {
    highlightText(text, binding.editor.getCode());
  }

  public void setPaddingStroke(int f) {
    binding.card.setStrokeWidth(f);
  }

  void setStorkeAnimator() {

    Handler handler = new Handler();
    ArgbEvaluator evaluator = new ArgbEvaluator();
    int[] colorPalette = {
      color.getBracketcolor(),
      color.getBracketlevel1(),
      color.getBracketlevel2(),
      color.getBracketlevel3(),
      color.getBracketlevel4(),
      color.getBracketlevel5(),
      color.getBracketlevel6()
    };
    final int[] currentIndex = {0};

    Runnable runnable =
        new Runnable() {
          @Override
          public void run() {
            int endColor = colorPalette[currentIndex[0]];
            int startColor =
                colorPalette[(currentIndex[0] - 1 + colorPalette.length) % colorPalette.length];

            ValueAnimator animator = ValueAnimator.ofObject(evaluator, startColor, endColor);
            animator.setDuration(1000);
            animator.addUpdateListener(
                new ValueAnimator.AnimatorUpdateListener() {
                  @Override
                  public void onAnimationUpdate(ValueAnimator animator) {
                    int color = (int) animator.getAnimatedValue();
                    if (isRgbCard) binding.card.setStrokeColor(color);
                    if (iconRgbMod) {
                      binding.copyicon.setColorFilter(color, PorterDuff.Mode.SRC_IN);
                      binding.eyeicon.setColorFilter(color, PorterDuff.Mode.SRC_IN);
                    }
                  }
                });
            animator.start();

            currentIndex[0] = (currentIndex[0] + 1) % colorPalette.length;
            handler.postDelayed(this, 1000);
          }
        };
    handler.post(runnable);
  }

  private void highlightText(String text, EditText editText) {
    try {
      CodeImpl code = new CodeImpl();
      final SpannableStringBuilder highlightedText = code.highlight(type, text, color);
      editText.setText(text);
      animateOptimizedColorWave(editText, highlightedText);
      binding
          .getRoot()
          .post(
              () -> {
                binding.eyeicon.setVisibility(type == LangType.MARKDOWN ? VISIBLE : GONE);
                // binding.editor.showMarkDownView(type == LangType.MARKDOWN);
                binding.eyeicon.invalidate();
              });

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  void showIconCopy(boolean show) {
    ObjectUtils.animIconShow(show, binding.copyicon);
    ObjectUtils.animIconShow(show, binding.eyeicon);
  }

  public void setShowHighlighterBracket(boolean show) {
    manager.setRainbowBracketsEnabled(show);
    updateTheme();
  }

  void copyText() {
    ((ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE))
        .setPrimaryClip(ClipData.newPlainText("clipboard", getCode().getText().toString()));

    binding
        .copyicon
        .animate()
        .scaleX(0.8f)
        .scaleY(0.8f)
        .setDuration(150)
        .withEndAction(
            () -> {
              binding.copyicon.setImageResource(R.drawable.check_24px);
              binding.copyicon.setColorFilter(Color.GREEN);
              binding.copyicon.animate().scaleX(1f).scaleY(1f).setDuration(150).start();
            })
        .start();
    postDelayed(
        () -> {
          binding
              .copyicon
              .animate()
              .scaleX(0.8f)
              .scaleY(0.8f)
              .setDuration(150)
              .withEndAction(
                  () -> {
                    binding.copyicon.clearColorFilter();
                    binding.copyicon.setImageResource(R.drawable.ic_copy_24px);

                    binding.copyicon.animate().scaleX(1f).scaleY(1f).setDuration(150).start();
                  })
              .start();
        },
        1000);
  }

  private void animateOptimizedColorWave(
      final EditText editText, final SpannableStringBuilder highlightedText) {
    final Editable editableText = editText.getText();
    final int totalLength = highlightedText.length();
    final int chunkSize = Math.max(100, totalLength / 30); // اندازه chunk داینامیک
    final long frameDelay = 90;

    new Handler(Looper.getMainLooper())
        .post(
            new Runnable() {
              int currentPos = 0;

              @Override
              public void run() {
                if (currentPos < totalLength) {
                  int endPos = Math.min(currentPos + chunkSize, totalLength);
                  Object[] spans = highlightedText.getSpans(currentPos, endPos, Object.class);
                  for (Object span : spans) {
                    int start = highlightedText.getSpanStart(span);
                    int end = highlightedText.getSpanEnd(span);
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

  private void animateFastColorWave(
      final EditText editText, final SpannableStringBuilder highlightedText) {
    final Editable editableText = editText.getText();
    final int totalLength = highlightedText.length();
    final int steps = 10;
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
        fileName =
            "code snap"
                + (String) DateFormat.format("yyyy-MM-dd_HH-mm-ss", now)
                + type.getLangname()
                + " .png";
        break;
      case JPEG:
        fileName =
            "code snap"
                + (String) DateFormat.format("yyyy-MM-dd_HH-mm-ss", now)
                + type.getLangname()
                + " .jpg";
        break;
      case WEBP:
        fileName =
            "code snap"
                + (String) DateFormat.format("yyyy-MM-dd_HH-mm-ss", now)
                + type.getLangname()
                + " .webp";
        break;
      case WEB_LOSSY:
        fileName =
            "code snap "
                + (String) DateFormat.format("yyyy-MM-dd_HH-mm-ss", now)
                + " weblossy.webp";
        break;
      case PDF:
        fileName =
            "code snap"
                + (String) DateFormat.format("yyyy-MM-dd_HH-mm-ss", now)
                + " "
                + type.getLangname()
                + ".pdf";
        break;

      case SVG:
        fileName =
            "code snap"
                + (String) DateFormat.format("yyyy-MM-dd_HH-mm-ss", now)
                + " "
                + type.getLangname()
                + ".svg";
        break;
      case VECTORDRAWABLE:
        fileName =
            "code snap"
                + (String) DateFormat.format("yyyy-MM-dd_HH-mm-ss", now)
                + " "
                + type.getLangname()
                + ".xml";
        break;
      default:
        fileName = "code snap" + (String) DateFormat.format("yyyy-MM-dd_HH-mm-ss", now) + ".png";
        break;
    }

    try {
      View cardView = binding.card;
      if (isShowCopyIcon) showIconCopy(false);
      cardView.post(
          () -> {
            try {
              Bitmap bitmap =
                  Bitmap.createBitmap(
                      cardView.getWidth(), cardView.getHeight(), Bitmap.Config.ARGB_8888);

              Canvas canvas = new Canvas(bitmap);
              cardView.draw(canvas);
              saveBitmapToMediaStore(bitmap, fileName, frm);
              if (isShowCopyIcon) postDelayed(() -> showIconCopy(true), 1000);
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
    if (im == FormatImage.SVG) {
      saveAsSvg(bitmap, fileName);
      return;
    }
    if (im == FormatImage.VECTORDRAWABLE) {
      saveAsVector(fileName);
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
        case WEB_LOSSY:
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
                bitmap.compress(Bitmap.CompressFormat.WEBP_LOSSLESS, 100, outputStream);
                break;
              case WEB_LOSSY:
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
              bitmap.compress(Bitmap.CompressFormat.WEBP_LOSSLESS, 100, outputStream);
              break;
            case WEB_LOSSY:
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
            case WEB_LOSSY:
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

  private void saveAsSvg(Bitmap bitmap, String fileName) {
    try {

      String svgContent = createSvgFromView(bitmap);

      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(MediaStore.Files.FileColumns.DISPLAY_NAME, fileName);
        contentValues.put(MediaStore.Files.FileColumns.MIME_TYPE, "image/svg+xml");
        contentValues.put(
            MediaStore.Files.FileColumns.RELATIVE_PATH,
            Environment.DIRECTORY_PICTURES + "/AndroidCodeSnap");

        Uri uri =
            getContext()
                .getContentResolver()
                .insert(MediaStore.Files.getContentUri("external"), contentValues);

        if (uri != null) {
          try (OutputStream outputStream =
              getContext().getContentResolver().openOutputStream(uri)) {
            if (outputStream != null) {
              outputStream.write(svgContent.getBytes("UTF-8"));
              Toast.makeText(getContext(), "SVG saved successfully", Toast.LENGTH_SHORT).show();
            }
          }
        }
      } else {
        File directory =
            new File(
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                "AndroidCodeSnap");
        if (!directory.exists()) {
          directory.mkdirs();
        }

        File svgFile = new File(directory, fileName);
        try (FileOutputStream outputStream = new FileOutputStream(svgFile)) {
          outputStream.write(svgContent.getBytes("UTF-8"));

          MediaScannerConnection.scanFile(
              getContext(),
              new String[] {svgFile.getAbsolutePath()},
              new String[] {"image/svg+xml"},
              null);

          Toast.makeText(getContext(), "SVG saved successfully", Toast.LENGTH_SHORT).show();
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
      Toast.makeText(getContext(), "Error saving SVG: " + e.getMessage(), Toast.LENGTH_LONG).show();
    }
  }

  private String createSvgFromView(Bitmap bitmap) {
    try {
      int width = bitmap.getWidth();
      int height = bitmap.getHeight();

      String base64 = bitmapToBase64(bitmap);

      String svgContent =
          "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
              + "<svg xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"\n"
              + "     width=\""
              + width
              + "\" height=\""
              + height
              + "\"\n"
              + "     viewBox=\"0 0 "
              + width
              + " "
              + height
              + "\">\n"
              + "<image width=\""
              + width
              + "\" height=\""
              + height
              + "\"\n"
              + "       xlink:href=\"data:image/png;base64,"
              + base64
              + "\"/>\n"
              + "</svg>";

      return svgContent;

    } catch (Exception e) {
      e.printStackTrace();
      return "";
    }
  }

  private String bitmapToBase64(Bitmap bitmap) {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
    byte[] byteArray = byteArrayOutputStream.toByteArray();
    return Base64.encodeToString(byteArray, Base64.DEFAULT);
  }

  public FormatImage getFormatImage() {
    return this.img;
  }

  private void saveAsVector(String fileName) {
    try {
      // گرفتن بیت‌مپ از ویو
      View cardView = binding.card;
      Bitmap bitmap =
          Bitmap.createBitmap(cardView.getWidth(), cardView.getHeight(), Bitmap.Config.ARGB_8888);
      Canvas canvas = new Canvas(bitmap);
      cardView.draw(canvas);

      // ساخت وکتور از بیت‌مپ
      String vectorContent = convertBitmapToVectorPaths(bitmap);

      // ذخیره‌سازی
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(MediaStore.Files.FileColumns.DISPLAY_NAME, fileName);
        contentValues.put(MediaStore.Files.FileColumns.MIME_TYPE, "text/xml");
        contentValues.put(
            MediaStore.Files.FileColumns.RELATIVE_PATH,
            Environment.DIRECTORY_DOCUMENTS + "/AndroidCodeSnap");

        Uri uri =
            getContext()
                .getContentResolver()
                .insert(MediaStore.Files.getContentUri("external"), contentValues);

        if (uri != null) {
          try (OutputStream outputStream =
              getContext().getContentResolver().openOutputStream(uri)) {
            outputStream.write(vectorContent.getBytes("UTF-8"));
            Toast.makeText(getContext(), "Vector saved", Toast.LENGTH_SHORT).show();
          }
        }
      } else {
        File directory =
            new File(
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS),
                "AndroidCodeSnap");
        if (!directory.exists()) directory.mkdirs();

        File vectorFile = new File(directory, fileName);
        try (FileOutputStream outputStream = new FileOutputStream(vectorFile)) {
          outputStream.write(vectorContent.getBytes("UTF-8"));
          MediaScannerConnection.scanFile(
              getContext(),
              new String[] {vectorFile.getAbsolutePath()},
              new String[] {"text/xml"},
              null);
          Toast.makeText(getContext(), "Vector saved", Toast.LENGTH_SHORT).show();
        }
      }

      bitmap.recycle();
    } catch (Exception e) {
      e.printStackTrace();
      Toast.makeText(getContext(), "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
    }
  }

  private String convertBitmapToVectorPaths(Bitmap bitmap) {
    StringBuilder vectorXml = new StringBuilder();
    int width = bitmap.getWidth();
    int height = bitmap.getHeight();

    // ساختار اصلی وکتور
    vectorXml
        .append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n")
        .append("<vector xmlns:android=\"http://schemas.android.com/apk/res/android\"\n")
        .append("    android:width=\"")
        .append(width)
        .append("dp\"\n")
        .append("    android:height=\"")
        .append(height)
        .append("dp\"\n")
        .append("    android:viewportWidth=\"")
        .append(width)
        .append("\"\n")
        .append("    android:viewportHeight=\"")
        .append(height)
        .append("\">\n");

    // پس‌زمینه
    vectorXml
        .append("    <path\n")
        .append("        android:fillColor=\"#")
        .append(String.format("%08X", color.getCardbackground()))
        .append("\"\n")
        .append("        android:pathData=\"M0,0 L")
        .append(width)
        .append(",0 L")
        .append(width)
        .append(",")
        .append(height)
        .append(" L0,")
        .append(height)
        .append(" Z\" />\n");

    // مناطق رنگی
    StringBuilder paths = new StringBuilder();
    int minRegionSize = 50;
    boolean[][] visited = new boolean[width][height];

    for (int y = 0; y < height; y += 2) {
      for (int x = 0; x < width; x += 2) {
        if (!visited[x][y]) {
          int pixel = bitmap.getPixel(x, y);
          int alpha = Color.alpha(pixel);

          if (alpha > 100) {
            List<Point> region = findColorRegion(bitmap, visited, x, y, pixel, 30);
            if (region.size() > minRegionSize) {
              String pathData = regionToPathData(region);
              paths
                  .append("    <path\n")
                  .append("        android:fillColor=\"#")
                  .append(String.format("%08X", pixel))
                  .append("\"\n")
                  .append("        android:pathData=\"")
                  .append(pathData)
                  .append("\" />\n");
            }
          }
        }
      }
    }

    vectorXml.append(paths.toString());
    vectorXml.append("</vector>");

    return vectorXml.toString();
  }

  private List<Point> findColorRegion(
      Bitmap bitmap, boolean[][] visited, int startX, int startY, int targetColor, int tolerance) {
    List<Point> region = new ArrayList<>();
    Queue<Point> queue = new LinkedList<>();
    queue.add(new Point(startX, startY));
    visited[startX][startY] = true;

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    while (!queue.isEmpty()) {
      Point p = queue.poll();
      region.add(p);

      for (int i = 0; i < 4; i++) {
        int nx = p.x + dx[i];
        int ny = p.y + dy[i];

        if (nx >= 0
            && nx < bitmap.getWidth()
            && ny >= 0
            && ny < bitmap.getHeight()
            && !visited[nx][ny]) {
          int neighborColor = bitmap.getPixel(nx, ny);
          if (colorSimilar(targetColor, neighborColor, tolerance)) {
            visited[nx][ny] = true;
            queue.add(new Point(nx, ny));
          }
        }
      }
    }

    return region;
  }

  private boolean colorSimilar(int color1, int color2, int tolerance) {
    return Math.abs(Color.red(color1) - Color.red(color2)) <= tolerance
        && Math.abs(Color.green(color1) - Color.green(color2)) <= tolerance
        && Math.abs(Color.blue(color1) - Color.blue(color2)) <= tolerance
        && Math.abs(Color.alpha(color1) - Color.alpha(color2)) <= tolerance;
  }

  private String regionToPathData(List<Point> region) {
    if (region.size() < 3) return "";

    // پیدا کردن bounding box
    int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
    int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;

    for (Point p : region) {
      minX = Math.min(minX, p.x);
      minY = Math.min(minY, p.y);
      maxX = Math.max(maxX, p.x);
      maxY = Math.max(maxY, p.y);
    }

    // ساخت مستطیل ساده
    return "M" + minX + "," + minY + " L" + maxX + "," + minY + " L" + maxX + "," + maxY + " L"
        + minX + "," + maxY + " Z";
  }

  private String get(int stringres) {
    return getContext().getString(stringres);
  }

  public boolean getIsShowCopyIcon() {
    return this.isShowCopyIcon;
  }

  public void setIsShowCopyIcon(boolean isShowCopyIcon) {
    this.isShowCopyIcon = isShowCopyIcon;
    showIconCopy(isShowCopyIcon);
    binding.copyicon.invalidate();
  }

  public void setSaveThemeBySpinner(Spinner sp) {
    List<ThemeManager> themeList = Arrays.asList(ThemeManager.values());

    ArrayAdapter<ThemeManager> adapter =
        new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, themeList);
    sp.setAdapter(adapter);
    SharedPreferences prefs =
        getContext().getSharedPreferences("AppSettings", Context.MODE_PRIVATE);
    int savedThemePosition = prefs.getInt("selected_theme_position", 0);
    sp.setSelection(savedThemePosition);

    sp.setOnItemSelectedListener(
        new AdapterView.OnItemSelectedListener() {
          @Override
          public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            ThemeManager selectedTheme = themeList.get(position);
            setTheme(selectedTheme);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putInt("selected_theme_position", position);
            editor.apply();
          }

          @Override
          public void onNothingSelected(AdapterView<?> parent) {}
        });
  }
  public void setIconRgbMod(boolean iconRgbMod) {
    this.iconRgbMod = iconRgbMod;
  }
  public void setCardRgb(boolean isRgbCard) {
    this.isRgbCard = isRgbCard;
  }
}
