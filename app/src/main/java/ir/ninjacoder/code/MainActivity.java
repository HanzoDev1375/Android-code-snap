package ir.ninjacoder.code;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import ir.ninjacoder.code.colorhelper.ColorHelper;
import ir.ninjacoder.code.colorhelper.ThemeManager;
import ir.ninjacoder.code.databinding.ActivityMainBinding;
import java.util.ArrayList;
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
    List<LangType> list = Arrays.asList(LangType.values());
    binding.sp.setAdapter(
        new ArrayAdapter<LangType>(
            getBaseContext(), android.R.layout.simple_spinner_item, list));
    int position = list.indexOf(binding.et.getType());
    if (position >= 0) {
      binding.sp.setSelection(position);
    }
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
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    this.binding = null;
  }

  private void setupThemeSpinner() {
        
        List<ThemeManager> themeList = Arrays.asList(ThemeManager.values());
        
        ArrayAdapter<ThemeManager> adapter = new ArrayAdapter<>(
            this, 
            android.R.layout.simple_spinner_item, 
            themeList
        );
        binding.sptheme.setAdapter(adapter);
        
        binding.sptheme.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ThemeManager selectedTheme = themeList.get(position);
                binding.et.setTheme(selectedTheme);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}
