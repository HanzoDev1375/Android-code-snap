package ir.ninjacoder.codesnap.Utils;

import android.text.SpannableStringBuilder;
import ir.ninjacoder.codesnap.LangType;
import ir.ninjacoder.codesnap.colorhelper.ColorHelper;

public interface Highlighter {
  SpannableStringBuilder highlight(LangType type, String code,ColorHelper color) throws Exception;
}
