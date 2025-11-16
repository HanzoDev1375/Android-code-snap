package ir.ninjacoder.codesnap.Utils;

import android.text.Editable;
import android.text.TextWatcher;
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
    private Editable editable;

    public IncrementalHighlighter(Highlighter highlighter, LangType langType, ColorHelper colorHelper) {
        this.highlighter = highlighter;
        this.langType = langType;
        this.colorHelper = colorHelper;
    }

    public void attach(Editable editable) {
        this.editable = editable;
        editable.setSpan(this, 0, editable.length(), 0);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        // No-op
    }

    private int changeStart;
    private int changeEnd;

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        changeStart = start;
        changeEnd = start + count;
    }

    @Override
    public void afterTextChanged(Editable s) {
        executor.submit(() -> {
            try {
                // Define a region to re-highlight, with some context
                int start = Math.max(0, changeStart - 200);
                int end = Math.min(s.length(), changeEnd + 200);

                String regionToHighlight = s.subSequence(start, end).toString();

                CharSequence highlightedRegion = highlighter.highlight(langType, regionToHighlight, colorHelper);

                handler.post(() -> {
                    // Remove old spans only in the affected region
                    Object[] spans = s.getSpans(start, end, Object.class);
                    for (Object span : spans) {
                        s.removeSpan(span);
                    }
                    // Apply new spans
                    s.replace(start, end, highlightedRegion);
                });
            } catch (Exception e) {
                // Handle exception
            }
        });
    }
}
