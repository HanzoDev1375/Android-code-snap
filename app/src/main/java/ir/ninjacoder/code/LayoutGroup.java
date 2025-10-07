package ir.ninjacoder.code;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.util.AttributeSet;
import ir.ninjacoder.code.Utils.CodeImpl;
import ir.ninjacoder.code.colorhelper.ColorHelper;
import ir.ninjacoder.code.databinding.LayoutGroupBinding;
import ir.ninjacoder.code.Utils.ColorUtil;

public class LayoutGroup extends LinearLayout {
  private LayoutGroupBinding binding;
  protected LangType type = LangType.PYTHON;
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
        """
     class Main():
        def __init__(): pass
        def run(self,item,object):
           print(item * 2)
           
      d = Main() 
      d.run(2,220,100)
    """;
    highlightText(code, binding.editor);
  }

  private void highlightText(String text, EditText editText) {

    try {

      CodeImpl code = new CodeImpl();
      editText.setText(code.highlight(type, text));

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public LangType getType() {
    return this.type;
  }

  public void setType(LangType type) {
    this.type = type;
  }

  public ColorHelper getColor() {
    return this.color;
  }
}
