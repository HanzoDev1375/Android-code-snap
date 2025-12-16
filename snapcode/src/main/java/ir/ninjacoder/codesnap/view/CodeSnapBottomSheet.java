package ir.ninjacoder.codesnap.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.CompoundButton;
import com.google.android.material.color.MaterialColors;
import ir.ninjacoder.codesnap.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.materialswitch.MaterialSwitch;
import ir.ninjacoder.codesnap.databinding.CodesnapviewBinding;

public class CodeSnapBottomSheet implements MaterialSwitch.OnCheckedChangeListener {
  private String code;
  private Context context;
  private CodesnapviewBinding bind;
  private BottomSheetDialog dialog;

  public CodeSnapBottomSheet(String code, Context context) {
    this.code = code;
    this.context = context;
    bind = CodesnapviewBinding.inflate(LayoutInflater.from(context));
    dialog = new BottomSheetDialog(context);
    dialog.setContentView(bind.getRoot());
    dialog.show();
    init();
  }

  void init() {
    bind.strokeSlider.setValue(1);
    bind.strokeSlider.setValueTo(10);
    bind.strokeSlider.addOnChangeListener(
        (slider, is, f) -> {
          if (f) {
            bind.group.setPaddingStroke((int) is);
          }
        });
    bind.swIcons.setOnCheckedChangeListener(this);
    bind.swRgb.setOnCheckedChangeListener(this);
    bind.swLine.setOnCheckedChangeListener(this);
    bind.swIconcopy.setOnCheckedChangeListener(this);
    bind.group.setSaveThemeBySpinner(bind.sptheme);
    bind.group.setLangGroup(bind.splang);
    bind.shot.setOnClickListener(v ->{
      bind.group.takeScreenshot();
    });
  }

  @Override
  public void onCheckedChanged(CompoundButton button, boolean is) {
    var id = button.getId();
    if (id == R.id.sw_icons) {
      bind.group.setIconRgbMod(is);
    } else if (id == R.id.sw_rgb) {
      bind.group.setCardRgb(is);
    } else if (id == R.id.sw_line) {
      bind.group.getEditor().showLineNumber(is);
    } else if (id == R.id.sw_iconcopy) {
      bind.group.setIsShowCopyIcon(is);
    }
  }
}
