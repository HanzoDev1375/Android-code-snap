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

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        // No-op
    }

    @Override
    public void afterTextChanged(Editable s) {
        executor.submit(() -> {
            try {
                // For simplicity, we are re-highlighting the entire text.
                // A more optimized version would only highlight the changed region.
                CharSequence highlighted = highlighter.highlight(langType, s.toString(), colorHelper);
                handler.post(() -> {
                    s.clearSpans();
                    s.replace(0, s.length(), highlighted);
                });
            } catch (Exception e) {
                // Handle exception
            }
        });
    }
}
