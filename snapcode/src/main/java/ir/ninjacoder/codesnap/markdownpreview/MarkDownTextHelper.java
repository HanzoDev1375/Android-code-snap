package ir.ninjacoder.codesnap.markdownpreview;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.text.style.ClickableSpan;
import android.text.style.LeadingMarginSpan;
import android.util.Log;
import android.view.View;
import android.text.TextPaint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.widget.Toast;
import io.noties.markwon.AbstractMarkwonPlugin;
import io.noties.markwon.MarkwonSpansFactory;
import io.noties.markwon.utils.LeadingMarginUtils;
import android.content.ClipboardManager;
import android.content.ClipData;
import android.widget.TextView;
import android.text.SpannableStringBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.Glide;
import android.graphics.Color;
import android.text.style.ForegroundColorSpan;
import android.text.Spanned;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.google.android.material.color.MaterialColors;
import io.noties.markwon.image.AsyncDrawable;
import com.bumptech.glide.RequestBuilder;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.RequestListener;
import io.noties.markwon.Markwon;
import io.noties.markwon.ext.tasklist.TaskListPlugin;
import io.noties.markwon.html.HtmlPlugin;
import io.noties.markwon.image.ImagesPlugin;
import io.noties.markwon.image.glide.GlideImagesPlugin;
import io.noties.markwon.image.AsyncDrawableScheduler;
import io.noties.markwon.image.svg.SvgPictureMediaDecoder;
import io.noties.markwon.syntax.Prism4jTheme;
import io.noties.markwon.syntax.SyntaxHighlightPlugin;
import io.noties.prism4j.GrammarLocator;
import io.noties.prism4j.Prism4j;
import io.noties.prism4j.Prism4j.Grammar;
import ir.ninjacoder.codesnap.markdownpreview.langs.Prism_clike;
import ir.ninjacoder.codesnap.markdownpreview.langs.Prism_groovy;
import ir.ninjacoder.codesnap.markdownpreview.langs.Prism_java;
import ir.ninjacoder.codesnap.markdownpreview.langs.Prism_json;
import ir.ninjacoder.codesnap.markdownpreview.langs.Prism_xml;
import ir.ninjacoder.codesnap.markdownpreview.langs.WebGrammer;
import java.util.HashSet;
import java.util.Set;
import androidx.annotation.*;
import ir.ninjacoder.codesnap.R;
import static com.google.android.material.R.attr.*;
import org.commonmark.node.FencedCodeBlock;

// @PrismBundle(includeAll = true)
public class MarkDownTextHelper {

  public static void handleMarkDown(TextView t, String md) {
    final Prism4j prism4j = new Prism4j(new MyGrammarLocator());
    var theme = new Theme(t.getContext());

    Markwon markwon =
        Markwon.builder(t.getContext())
            .usePlugin(
                ImagesPlugin.create(
                    it -> {
                      it.addMediaDecoder(SvgPictureMediaDecoder.create());
                    }))
            .usePlugin(HtmlPlugin.create(plugin -> plugin.addHandler(new SpanTagHandler())))
            .usePlugin(GlideImagesPlugin.create(new GifGlideStore(Glide.with(t.getContext()))))
            .usePlugin(TaskListPlugin.create(t.getContext()))
            .usePlugin(
                new AbstractMarkwonPlugin() {
                  @Override
                  public void configureSpansFactory(MarkwonSpansFactory.Builder builder) {
                    builder.setFactory(
                        FencedCodeBlock.class,
                        (configuration, props) -> {
                          return new Object[] {
                            new CopyIconSpan(t.getContext().getDrawable(R.drawable.code_copy_24px))
                          };
                        });
                  }
                })
            .usePlugin(SyntaxHighlightPlugin.create(prism4j, theme))
            .build();

    AsyncDrawableScheduler.schedule(t);
    markwon.setMarkdown(t, md);
  }

  static class Theme implements Prism4jTheme {
    Context c;

    public Theme(Context c) {
      this.c = c;
    }

    @Override
    public int background() {
      return MaterialColors.getColor(c, colorSurface, 0);
    }

    @Override
    public int textColor() {
      return MaterialColors.getColor(c, colorPrimaryContainer, 0);
    }

    @Override
    public void apply(
        @NonNull String language,
        @NonNull Prism4j.Syntax syntax,
        @NonNull SpannableStringBuilder builder,
        int start,
        int end) {

      if (start < 0 || end <= start || end > builder.length()) {
        return;
      }

      int color;
      String type = syntax.type();

      switch (type) {
        case "property":
          color = Color.parseColor("#9CDCFE");
          break;
        case "string":
          color = Color.parseColor("#CE9178");
          break;
        case "number":
          color = Color.parseColor("#B5CEA8");
          break;
        case "boolean":
          color = Color.parseColor("#569CD6");
          break;
        case "null":
          color = Color.parseColor("#C586C0");
          break;
        case "punctuation":
          color = Color.parseColor("#D4D4D4");
          break;
        case "operator":
          color = Color.parseColor("#DCDCAA");
          break;
        case "keyword":
          color = Color.parseColor("#569CD6");
          break;
        case "comment":
          color = Color.parseColor("#6A9955");
          break;
        case "class-name":
          color = Color.parseColor("#4EC9B0");
          break;
        case "function":
          color = Color.parseColor("#DCDCAA");
          break;
        case "annotation":
          color = Color.parseColor("#C586C0");
          break;
        case "tag":
          color = Color.parseColor("#569CD6");
          break;
        case "attr-name":
          color = Color.parseColor("#FF89FF34");
          break;
        case "attr-value":
          color = Color.parseColor("#CE9178");
          break;
        case "selector":
          color = Color.parseColor("#D7BA7D");
          break;
        case "important":
          color = Color.parseColor("#569CD6");
          break;
        case "color":
          color = Color.parseColor("#B5CEA8");
          break;
        case "atrule":
          color = Color.parseColor("#C586C0");
          break;
        case "url":
          color = Color.parseColor("#CE9178");
          break;
        case "entity":
          color = Color.parseColor("#569CD6");
          break;
        case "doctype":
          color = Color.parseColor("#6A9955");
          break;
        case "script":
          color = Color.parseColor("#D4D4D4");
          break;
        case "style":
          color = Color.parseColor("#D4D4D4");
          break;
        case "event-handler":
          color = Color.parseColor("#DCDCAA");
          break;
        case "inline-style":
          color = Color.parseColor("#9CDCFE");
          break;

        case "tag-name":
          color = Color.parseColor("#569CD6");
          break;

        case "js-keyword":
          color = Color.parseColor("#569CD6");
          break;
        case "css-keyword":
          color = Color.parseColor("#C586C0");
          break;
        case "at-rule":
          color = Color.parseColor("#C586C0");
          break;
        case "unit":
          color = Color.parseColor("#B5CEA8");
          break;
        case "cdata":
          color = Color.parseColor("#6A9955");
          break;
        default:
          color = textColor();
          break;
      }

      builder.setSpan(new ForegroundColorSpan(color), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
    }
  }

  static class MyGrammarLocator implements GrammarLocator {

    @Nullable
    @Override
    public Grammar grammar(@NonNull Prism4j prism4j, @NonNull String language) {
      switch (language) {
        case "html":
        case "htm":
          return WebGrammer.create(prism4j);
        case "json":
        case "json5":
          return Prism_json.create(prism4j);
        case "java":
          return Prism_java.create(prism4j);
        case "clike":
          return Prism_clike.create(prism4j);
        case "groovy":
          return Prism_groovy.create(prism4j);
        case "xml":
          return Prism_xml.create(prism4j);
        default:
          return null;
      }
    }

    @Override
    public Set<String> languages() {
      Set<String> set = new HashSet<>();
      set.add("json");
      return set;
    }
  }

  private static class GifGlideStore implements GlideImagesPlugin.GlideStore {
    private final RequestManager requestManager;

    GifGlideStore(RequestManager requestManager) {
      this.requestManager = requestManager;
    }

    @NonNull
    @Override
    public RequestBuilder<Drawable> load(@NonNull AsyncDrawable drawable) {
      final String destination = drawable.getDestination();
      return requestManager
          .asDrawable()
          .addListener(
              new RequestListener<Drawable>() {
                @Override
                public boolean onLoadFailed(
                    @Nullable GlideException e,
                    Object model,
                    Target<Drawable> target,
                    boolean isFirstResource) {
                  return false;
                }

                @Override
                public boolean onResourceReady(
                    Drawable resource,
                    Object model,
                    Target<Drawable> target,
                    DataSource dataSource,
                    boolean isFirstResource) {
                  if (resource instanceof Animatable) {
                    ((Animatable) resource).start();
                  }
                  return false;
                }
              })
          .load(destination);
    }

    @Override
    public void cancel(@NonNull Target<?> target) {
      requestManager.clear(target);
    }
  }

  static class CopyIconSpan extends ClickableSpan implements LeadingMarginSpan {
    private final Drawable icon;

    CopyIconSpan(Drawable icon) {
      this.icon = icon;
      if (icon.getBounds().isEmpty()) {
        icon.setBounds(0, 0, icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
      }
    }

    @Override
    public void onClick(View widget) {

      if (widget instanceof TextView) {
        TextView textView = (TextView) widget;
        Spanned spanned = (Spanned) textView.getText();

        int start = spanned.getSpanStart(this);
        int end = spanned.getSpanEnd(this);
        String contents = spanned.subSequence(start, end).toString().trim();
        Log.i("CopyContents", contents);
        copyToClipboard(widget.getContext(), contents);
        Toast.makeText(widget.getContext(), "done!", Toast.LENGTH_SHORT).show();
      }
    }

    @Override
    public void updateDrawState(TextPaint ds) {
      // do not apply link styling
    }

    @Override
    public int getLeadingMargin(boolean first) {
      return 0;
    }

    @Override
    public void drawLeadingMargin(
        Canvas c,
        Paint p,
        int x,
        int dir,
        int top,
        int baseline,
        int bottom,
        CharSequence text,
        int start,
        int end,
        boolean first,
        Layout layout) {
      if (!LeadingMarginUtils.selfStart(start, text, this)) return;

      int save = c.save();
      try {
        float w = icon.getBounds().width();
        float left = layout.getWidth() - w - (w / 4F);
        c.translate(left, top);
        icon.draw(c);
      } finally {
        c.restoreToCount(save);
      }
    }

    private void copyToClipboard(Context context, String text) {
      ClipboardManager clipboard =
          (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
      if (clipboard != null) {
        ClipData clip = ClipData.newPlainText("Code snippet", text);
        clipboard.setPrimaryClip(clip);
      }
    }
  }
}
