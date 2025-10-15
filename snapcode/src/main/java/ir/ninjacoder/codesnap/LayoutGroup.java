package ir.ninjacoder.codesnap;

import android.animation.LayoutTransition;
import android.content.ContentValues;
import android.os.Build;
import android.provider.MediaStore;
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
    String code =
        "public class Main {\n"
            + "    public static void main(String[] args) {\n"
            + "        System.out.println(\"Hello World\");\n"
            + "        \n"
            + "        if (true) {\n"
            + "            System.out.println(\"Inside if\");\n"
            + "        }\n"
            + "        \n"
            + "        for (int i = 0; i < 10; i++) {\n"
            + "            System.out.println(i);\n"
            + "        }\n"
            + "    }\n"
            + "}";
    highlightText(code, binding.editor.getCode());
    color.addOnThemeChangeListener(
        new ColorHelper.OnThemeChangeListener() {
          @Override
          public void onThemeChanged() {
            updateTheme();
          }
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

  private void highlightText(String text, EditText editText) {
    try {
      CodeImpl code = new CodeImpl();
      editText.setText(code.highlight(type, text, color));

    } catch (Exception e) {
      e.printStackTrace();
    }
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

  public ColorHelper getColor() {
    return this.color;
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
    Date now = new Date();
    String fileName =
        "screenshot_" + (String) DateFormat.format("yyyy-MM-dd_HH-mm-ss", now) + ".png";

    try {
      View cardView = binding.card;

      cardView.post(
          () -> {
            try {
              // ایجاد bitmap از اندازه کارت
              Bitmap bitmap =
                  Bitmap.createBitmap(
                      cardView.getWidth(), cardView.getHeight(), Bitmap.Config.ARGB_8888);

              Canvas canvas = new Canvas(bitmap);

              // کشیدن کارت روی canvas
              cardView.draw(canvas);

              // ذخیره تصویر
              saveBitmapToMediaStore(bitmap, fileName);

            } catch (Exception e) {
              e.printStackTrace();
              Toast.makeText(getContext(), "خطا در گرفتن اسکرین شات", Toast.LENGTH_SHORT).show();
            }
          });

    } catch (Throwable e) {
      e.printStackTrace();
      Toast.makeText(getContext(), "خطا در گرفتن اسکرین شات", Toast.LENGTH_SHORT).show();
    }
  }

  private void saveBitmapToMediaStore(Bitmap bitmap, String fileName) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
      ContentValues contentValues = new ContentValues();
      contentValues.put(MediaStore.Images.Media.DISPLAY_NAME, fileName);
      contentValues.put(MediaStore.Images.Media.MIME_TYPE, "image/png");
      contentValues.put(
          MediaStore.Images.Media.RELATIVE_PATH, Environment.DIRECTORY_PICTURES + "/apk");

      Uri uri =
          getContext()
              .getContentResolver()
              .insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);

      if (uri != null) {
        try {
          OutputStream outputStream = getContext().getContentResolver().openOutputStream(uri);
          if (outputStream != null) {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
            outputStream.close();
            Toast.makeText(getContext(), "اسکرین شات ذخیره شد", Toast.LENGTH_SHORT).show();
          }
        } catch (IOException e) {
          e.printStackTrace();
          Toast.makeText(getContext(), "خطا در ذخیره‌سازی", Toast.LENGTH_SHORT).show();
        }
      }
    } else {
      try {
        File directory =
            new File(
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                "APK_Screenshots");
        if (!directory.exists()) {
          directory.mkdirs();
        }

        File imageFile = new File(directory, fileName);
        FileOutputStream outputStream = new FileOutputStream(imageFile);
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
        outputStream.flush();
        outputStream.close();

        MediaScannerConnection.scanFile(
            getContext(),
            new String[] {imageFile.getAbsolutePath()},
            new String[] {"image/png"},
            null);

        Toast.makeText(getContext(), "اسکرین شات ذخیره شد", Toast.LENGTH_SHORT).show();

      } catch (IOException e) {
        e.printStackTrace();
        Toast.makeText(getContext(), "خطا در ذخیره‌سازی", Toast.LENGTH_SHORT).show();
      }
    }
  }
}
