package ir.ninjacoder.code;

import android.animation.LayoutTransition;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.util.AttributeSet;
import ir.ninjacoder.code.Utils.CodeImpl;
import ir.ninjacoder.code.colorhelper.ColorHelper;
import ir.ninjacoder.code.colorhelper.ThemeManager;
import ir.ninjacoder.code.databinding.LayoutGroupBinding;
import ir.ninjacoder.code.Utils.ColorUtil;
import ir.ninjacoder.code.widget.LineNumberTextView;
import ir.ninjacoder.code.widget.SyntaxView;

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
    // حذف شنونده هنگام جدا شدن از ویو
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
}
