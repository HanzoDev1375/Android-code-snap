package ir.ninjacoder.code.markwon;

import android.graphics.Typeface;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MarkdownCodeHighlighterRegistry {
  private final Map<String, MarkdownCodeHighlighter> highlighters = new HashMap<>();
  private final Map<String, String> aliases = new HashMap<>();
  private final List<CodeHighlighterProvider> providers = new ArrayList<>();

  public Disposable withProvider(CodeHighlighterProvider provider) {
    providers.add(provider);
    return () -> providers.remove(provider);
  }

  public Disposable register(String language, MarkdownCodeHighlighter highlighter) {
    String key = language.toLowerCase();
    highlighters.put(key, highlighter);
    return () -> highlighters.remove(key);
  }

  public Disposable registerWithAlias(LanguageAlias alias, MarkdownCodeHighlighter highlighter) {
    String target = alias.getTarget().toLowerCase();
    highlighters.put(target, highlighter);
    for (String a : alias.getAliases()) {
      aliases.put(a.toLowerCase(), target);
    }
    return () -> {
      highlighters.remove(target);
      for (String a : alias.getAliases()) {
        aliases.remove(a.toLowerCase());
      }
    };
  }

  public void unregister(String language) {
    String key = language.toLowerCase();
    highlighters.remove(key);
    Iterator<Map.Entry<String, String>> it = aliases.entrySet().iterator();
    while (it.hasNext()) {
      if (it.next().getValue().equals(key)) {
        it.remove();
      }
    }
  }

  public void addAlias(String from, String to) {
    aliases.put(from.toLowerCase(), to.toLowerCase());
  }

  public HighlightResult highlight(String code, String language, Typeface codeTypeface) {
    if (language == null) return new HighlightResult(code, false);
    String resolved = aliases.getOrDefault(language.toLowerCase(), language.toLowerCase());
    MarkdownCodeHighlighter highlighter = highlighters.get(resolved);
    if (highlighter == null) {
      for (CodeHighlighterProvider provider : providers) {
        highlighter = provider.provide(resolved);
        if (highlighter != null) {
          highlighters.put(resolved, highlighter);
          break;
        }
      }
    }
    if (highlighter == null) return new HighlightResult(code, false);
    if (highlighter.isAsync()) {
      Log.w(
          "CodeHighlighterRegistry",
          "Async highlighter for '" + resolved + "' called in sync context");
      return new HighlightResult(code, true);
    }
    return new HighlightResult(highlighter.highlight(code, language, codeTypeface), false);
  }

  public CharSequence highlightAsync(String code, String language, Typeface codeTypeface) {
    if (language == null) return code;
    String resolved = aliases.getOrDefault(language.toLowerCase(), language.toLowerCase());
    MarkdownCodeHighlighter highlighter = highlighters.get(resolved);
    if (highlighter == null) {
      for (CodeHighlighterProvider provider : providers) {
        highlighter = provider.provide(resolved);
        if (highlighter != null) {
          highlighters.put(resolved, highlighter);
          break;
        }
      }
    }
    if (highlighter != null) {
      return highlighter.highlightAsync(code, language, codeTypeface);
    }
    return code;
  }

  public static class HighlightResult {
    private final CharSequence content;
    private final boolean needsAsync;

    public HighlightResult(CharSequence content, boolean needsAsync) {
      this.content = content;
      this.needsAsync = needsAsync;
    }

    public CharSequence getContent() {
      return content;
    }

    public boolean isNeedsAsync() {
      return needsAsync;
    }
  }

  public static class LanguageAlias {
    private final String target;
    private final List<String> aliases;

    public LanguageAlias(String target, List<String> aliases) {
      this.target = target;
      this.aliases = aliases != null ? aliases : new ArrayList<>();
    }

    public String getTarget() {
      return target;
    }

    public List<String> getAliases() {
      return aliases;
    }

    public static LanguageAlias Kotlin = new LanguageAlias("kotlin", createList("kt"));
    public static LanguageAlias Java = new LanguageAlias("java", null);
    public static LanguageAlias JavaScript =
        new LanguageAlias("javascript", createList("js", "jsx"));
    public static LanguageAlias TypeScript =
        new LanguageAlias("typescript", createList("ts", "tsx"));
    public static LanguageAlias Python = new LanguageAlias("python", createList("py"));
    public static LanguageAlias Cpp = new LanguageAlias("cpp", createList("c++"));
    public static LanguageAlias CSharp = new LanguageAlias("csharp", createList("c#", "cs"));
    public static LanguageAlias Ruby = new LanguageAlias("ruby", createList("rb"));
    public static LanguageAlias Shell = new LanguageAlias("shell", createList("sh", "bash", "zsh"));
    public static LanguageAlias Yaml = new LanguageAlias("yaml", createList("yml"));
    public static LanguageAlias Markdown = new LanguageAlias("markdown", createList("md"));

    private static List<String> createList(String... items) {
      List<String> list = new ArrayList<>();
      for (String item : items) {
        list.add(item);
      }
      return list;
    }
  }

  public static final MarkdownCodeHighlighterRegistry global =
      new MarkdownCodeHighlighterRegistry();

  public interface Disposable {
    void dispose();
  }

  public interface CodeHighlighterProvider {
    MarkdownCodeHighlighter provide(String language);
  }
}
