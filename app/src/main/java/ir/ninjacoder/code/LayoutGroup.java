package ir.ninjacoder.code;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.BackgroundColorSpan;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.util.AttributeSet;
import ir.ninjacoder.code.Utils.CodeHighlighterJava;
import ir.ninjacoder.code.databinding.LayoutGroupBinding;
import ir.ninjacoder.code.Utils.ColorUtil;

public class LayoutGroup extends LinearLayout {
  private LayoutGroupBinding binding;
  protected LangType type = LangType.JAVA;

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
    
    String code = """
      import java.io.File;
      public class Main(){
      void main(String[] args){
      
      File file = new File("");
      if(file.isFile){
         System.out.println("Hello word");
        }
     }
   }
    """;
    highlightText(code, binding.editor);
  }

  private void highlightText(String text, EditText editText) {

    try {
      var highlighter = new CodeHighlighterJava();
      SpannableStringBuilder highlightedText = highlighter.highlight(type, text);

      Editable editable = editText.getText();
      ForegroundColorSpan[] oldSpans =
          editable.getSpans(0, editable.length(), ForegroundColorSpan.class);
      BackgroundColorSpan[] oldBgSpans =
          editable.getSpans(0, editable.length(), BackgroundColorSpan.class);

      for (ForegroundColorSpan span : oldSpans) {
        editable.removeSpan(span);
      }
      for (BackgroundColorSpan span : oldBgSpans) {
        editable.removeSpan(span);
      }
      int selectionStart = editText.getSelectionStart();
      int selectionEnd = editText.getSelectionEnd();

      editText.setText(highlightedText);
      editText.setSelection(selectionStart, selectionEnd);

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
}
