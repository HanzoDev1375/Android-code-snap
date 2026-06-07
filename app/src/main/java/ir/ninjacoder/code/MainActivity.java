package ir.ninjacoder.code;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.net.Uri;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import ir.ninjacoder.code.databinding.ActivityMainBinding;
import ir.ninjacoder.codesnap.FormatImage;
import ir.ninjacoder.codesnap.LangType;
import ir.ninjacoder.codesnap.colorhelper.ThemeManager;
import ir.ninjacoder.codesnap.diagnostics.DiagnosticsState;
import ir.ninjacoder.codesnap.dialog.ProgressDialog;
import ir.ninjacoder.codesnap.view.CodeSnapBottomSheet;
import ir.ninjacoder.codesnap.widget.editorbase.EffectType;
import java.io.File;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
  private ActivityMainBinding binding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // Inflate and get instance of binding
    binding = ActivityMainBinding.inflate(getLayoutInflater());

    // set content view to binding's root
    setContentView(binding.getRoot());
    binding.btn.setOnLongClickListener(
        v -> {
          var f = new ProgressDialog(MainActivity.this);
          f.setTitle("Hello");
          f.setMessage("User");
          f.show();

          return false;
        });
    checkAndRequestPermissions();
    List<LangType> list = Arrays.asList(LangType.values());
    var ad =
        new ArrayAdapter<LangType>(getBaseContext(), android.R.layout.simple_spinner_item, list);
    binding.sp.setAdapter(ad);

    binding.btn.setOnClickListener(
        v -> {
          //    binding.et.takeScreenshot();
          new CodeSnapBottomSheet("", MainActivity.this);
        });

    ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    binding.sp.setOnItemSelectedListener(
        new AdapterView.OnItemSelectedListener() {
          @Override
          public void onItemSelected(AdapterView<?> ad, View v, int position, long l) {
            binding.et.setType(list.get(position));
          }

          @Override
          public void onNothingSelected(AdapterView<?> ad) {}
        });
    binding.et.setTheme(ThemeManager.DEFAULTTHEME);
    setupThemeSpinner();
    binding.showline.setChecked(true);
    binding.showline.setOnCheckedChangeListener(
        (is, c) -> {
          binding.et.getEditor().showLineNumber(c);
        });

    binding.showiconCopy.setOnCheckedChangeListener(
        (is, c) -> {
          startActivity(new Intent(getApplicationContext(), DownloadActivity.class));
          binding.et.setIsShowCopyIcon(c);
          binding.et.getEditor().getCode().addDiagnostic(1, 4, "Error", DiagnosticsState.ERROR);
          binding.et.getEditor().getCode().addDiagnostic(5, 100, "Error", DiagnosticsState.WARNING);
          //   binding.et.getEditor().getCode().addDiagnostic(8,20,"Error",DiagnosticsState.TYPO);
        });
    String md =
        """
    # سلام دنیا

    این یک **متن بولد** و *ایتالیک* است.

    - آیتم اول
    - آیتم دوم
    - [x] hello word
    ```java
    class Hsi{}
    ```

    [کلیک کن](https://google.com)
    """;

    binding.markwon.setMarkdown(md);
    String code =
        """
          public class Main{

            public void runItem() {
              int id = 0;
              if(id == 0) System.out.println("Hello");

            }

          }
        """;
    binding.et.setText(code);
    //    binding
    //        .et
    //        .getEditor()
    //        .setFont(Typeface.createFromFile(new File("/storage/emulated/0/apk/ghostfont.ttf")));
    getWindow()
        .setSoftInputMode(
            WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE
                | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

    setupef();
    binding.et.setPaddingStroke(4);
    binding.et.setIconRgbMod(true);
    binding.et.setCardRgb(true);

    //  binding.glassBackground.bind(binding.glassFabRoot);
    binding.et.setThemeCustom("/storage/emulated/0/Apktool_M/theme.json");
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    this.binding = null;
  }

  private void setupThemeSpinner() {
    binding.et.setSaveThemeBySpinner(binding.sptheme);
  }

  void setupef() {
    EffectType[] ts;
    ts = EffectType.values();
    ArrayAdapter<EffectType> adapter =
        new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, ts);

    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    binding.speff.setAdapter(adapter);
    binding.speff.setOnItemSelectedListener(
        new AdapterView.OnItemSelectedListener() {
          @Override
          public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            EffectType selectedEffect = ts[position];
            if (binding.et.getEditor().getCode() != null) {
              binding.et.getEditor().getCode().setEffects(selectedEffect);
            }
          }

          @Override
          public void onNothingSelected(AdapterView<?> parent) {}
        });
  }

  private void checkAndRequestPermissions() {

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
      if (!Environment.isExternalStorageManager()) {

        try {
          Intent intent = new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
          Uri uri = Uri.parse("package:" + getPackageName());
          intent.setData(uri);
          startActivityForResult(intent, 10);
        } catch (Exception ex) {
          Intent intent = new Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
          startActivityForResult(intent, 10);
        }
      }
    } else {

      if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
              == PackageManager.PERMISSION_DENIED
          || ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
              == PackageManager.PERMISSION_DENIED) {
        ActivityCompat.requestPermissions(
            this,
            new String[] {
              Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE
            },
            1000);
      }
    }
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if (requestCode == 10) {
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        if (Environment.isExternalStorageManager()) {
          return;
        } else {
          Toast.makeText(this, "برای عملکرد کامل اپ، مجوز دسترسی لازم است", Toast.LENGTH_LONG)
              .show();
        }
      }
    }
  }
}
