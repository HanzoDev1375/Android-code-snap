package ir.ninjacoder.codesnap.Utils;

import ir.ninjacoder.codesnap.LangType;
import ir.ninjacoder.codesnap.colorhelper.ColorHelper;
import android.text.SpannableStringBuilder;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CodeHighlighterXml implements Highlighter {

    @Override
    public SpannableStringBuilder highlight(LangType types, String code, ColorHelper color) throws Exception {
        SpannableStringBuilder spannable = new SpannableStringBuilder(code);
        
        colorPattern(spannable, "[<>=/]", color.getSymbol(), code);
        colorPattern(spannable, "<\\s*([\\w:-]+)", color.getBracketlevel1(), code, 1);
        colorPattern(spannable, "</\\s*([\\w:-]+)", color.getBracketlevel1(), code, 1);
        
        // 3. نام attributeها (قبل از =)
        colorPattern(spannable, "(\\s+)([\\w:-]+)(?=\\s*=)", color.getBracketlevel3(), code, 2);
        
        // 4. مقادیر attribute
        colorPattern(spannable, "=(\"[^\"]*\")", color.getStrings(), code, 1);
        colorPattern(spannable, "='[^']*'", color.getStrings(), code, 0);
        
        // 5. محتوای متن
        colorTextContent(spannable, code, color.getTextnormal());
        
        return spannable;
    }

    private void colorPattern(SpannableStringBuilder spannable, String regex, int colorValue, String code) {
        colorPattern(spannable, regex, colorValue, code, 0);
    }

    private void colorPattern(SpannableStringBuilder spannable, String regex, int colorValue, String code, int group) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(code);
        
        while (matcher.find()) {
            int start = group == 0 ? matcher.start() : matcher.start(group);
            int end = group == 0 ? matcher.end() : matcher.end(group);
            
            if (start >= 0 && end > start) {
                spannable.setSpan(
                    new ForegroundColorSpan(colorValue),
                    start,
                    end,
                    SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE
                );
            }
        }
    }

    private void colorTextContent(SpannableStringBuilder spannable, String code, int colorValue) {
        // محتوای بین تگ‌ها
        Pattern pattern = Pattern.compile(">([^<]+)</");
        Matcher matcher = pattern.matcher(code);
        
        while (matcher.find()) {
            int start = matcher.start(1);
            int end = matcher.end(1);
            
            spannable.setSpan(
                new ForegroundColorSpan(colorValue),
                start,
                end,
                SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE
            );
        }
        
        // محتوای بعد از آخرین تگ بسته
        Pattern lastPattern = Pattern.compile("</[^>]+>([^<]+)$");
        Matcher lastMatcher = lastPattern.matcher(code);
        
        if (lastMatcher.find()) {
            int start = lastMatcher.start(1);
            int end = lastMatcher.end(1);
            
            spannable.setSpan(
                new ForegroundColorSpan(colorValue),
                start,
                end,
                SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE
            );
        }
    }
}