package ir.ninjacoder.codesnap.Utils;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.Selection;
import ir.ninjacoder.codesnap.LangType;
import ir.ninjacoder.codesnap.colorhelper.ColorHelper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import android.os.Handler;
import android.os.Looper;

public class IncrementalHighlighter implements TextWatcher {

    private final Highlighter highlighter;
    private final LangType langType;
    private final ColorHelper colorHelper;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    private final Handler handler = new Handler(Looper.getMainLooper());

    public IncrementalHighlighter(Highlighter highlighter, LangType langType, ColorHelper colorHelper) {
        this.highlighter = highlighter;
        this.langType = langType;
        this.colorHelper = colorHelper;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        // No-op
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        // No-op
    }

    @Override
    public void afterTextChanged(Editable s) {
        executor.submit(() -> {
            try {
                // Highlight the full text in the background
                SpannableStringBuilder highlighted = (SpannableStringBuilder) highlighter.highlight(langType, s.toString(), colorHelper);

                // Post the UI update back to the main thread
                handler.post(() -> {
                    // Preserve cursor position
                    int selectionStart = Selection.getSelectionStart(s);
                    int selectionEnd = Selection.getSelectionEnd(s);

                    // Remove only character style spans (colors, bold, etc.)
                    android.text.style.CharacterStyle[] spans = s.getSpans(0, s.length(), android.text.style.CharacterStyle.class);
                    for (android.text.style.CharacterStyle span : spans) {
                        s.removeSpan(span);
                    }

                    // Apply the new style spans from the highlighted text
                    Object[] newSpans = highlighted.getSpans(0, highlighted.length(), Object.class);
                    for (Object span : newSpans) {
                        s.setSpan(span, highlighted.getSpanStart(span), highlighted.getSpanEnd(span), highlighted.getSpanFlags(span));
                    }

                    // Restore cursor position
                    if (selectionStart >= 0 && selectionEnd >= 0) {
                        Selection.setSelection(s, selectionStart, selectionEnd);
                    }
                });
            } catch (Exception e) {
                // Handle exception
            }
        });
    }
}
