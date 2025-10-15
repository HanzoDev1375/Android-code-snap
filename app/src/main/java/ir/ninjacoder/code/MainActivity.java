package ir.ninjacoder.code;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import ir.ninjacoder.code.databinding.ActivityMainBinding;
import ir.ninjacoder.codesnap.LangType;
import ir.ninjacoder.codesnap.colorhelper.ThemeManager;
import ir.ninjacoder.codesnap.widget.editorbase.EffectType;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.contracts.Effect;

public class MainActivity extends AppCompatActivity {
  private ActivityMainBinding binding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // Inflate and get instance of binding
    binding = ActivityMainBinding.inflate(getLayoutInflater());

    // set content view to binding's root
    setContentView(binding.getRoot());
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
    List<LangType> list = Arrays.asList(LangType.values());
    var ad =
        new ArrayAdapter<LangType>(getBaseContext(), android.R.layout.simple_spinner_item, list);
    binding.sp.setAdapter(ad);
    
    binding.btn.setOnClickListener(
        v -> {
          binding.et.takeScreenshot();
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
    binding.et.setTheme(ThemeManager.DARKTHEME);
    setupThemeSpinner();
    binding.showline.setChecked(true);
    binding.showline.setOnCheckedChangeListener(
        (is, c) -> {
          binding.et.getEditor().showLineNumber(c);
        });
    binding
        .et
        .getEditor()
        .setFont(Typeface.createFromFile(new File("/storage/emulated/0/apk/ghostfont.ttf")));

    setupef();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    this.binding = null;
  }

  private void setupThemeSpinner() {

    List<ThemeManager> themeList = Arrays.asList(ThemeManager.values());

    ArrayAdapter<ThemeManager> adapter =
        new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, themeList);
    binding.sptheme.setAdapter(adapter);

    binding.sptheme.setOnItemSelectedListener(
        new AdapterView.OnItemSelectedListener() {
          @Override
          public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            ThemeManager selectedTheme = themeList.get(position);
            binding.et.setTheme(selectedTheme);
          }

          @Override
          public void onNothingSelected(AdapterView<?> parent) {}
        });
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
          public void onNothingSelected(AdapterView<?> parent) {
            
          }
        });
  }
}
