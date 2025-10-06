package ir.ninjacoder.code.Utils;

import android.text.SpannableStringBuilder;
import ir.ninjacoder.code.LangType;

public interface Highlighter {
  SpannableStringBuilder highlight(LangType type, String code) throws Exception;
}
