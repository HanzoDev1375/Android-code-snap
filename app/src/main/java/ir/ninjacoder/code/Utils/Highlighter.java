package ir.ninjacoder.code.Utils;

import android.text.SpannableStringBuilder;
import ir.ninjacoder.code.LangType;
import ir.ninjacoder.code.colorhelper.ColorHelper;

public interface Highlighter {
  SpannableStringBuilder highlight(LangType type, String code,ColorHelper color) throws Exception;
}
