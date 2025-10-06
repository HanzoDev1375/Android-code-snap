package ir.ninjacoder.code;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.util.AttributeSet;
import ir.ninjacoder.code.databinding.LayoutGroupBinding;
import ir.ninjacoder.code.Utils.ColorUtil;

public class LayoutGroup extends LinearLayout {
  private LayoutGroupBinding binding;

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
    binding = LayoutGroupBinding.inflate(LayoutInflater.from(getContext()),this,true);
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
  }
}
