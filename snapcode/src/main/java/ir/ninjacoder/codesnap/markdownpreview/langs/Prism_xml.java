package ir.ninjacoder.codesnap.markdownpreview.langs;

import org.jetbrains.annotations.NotNull;

import io.noties.prism4j.Prism4j;

import static java.util.regex.Pattern.CASE_INSENSITIVE;
import static java.util.regex.Pattern.compile;
import static io.noties.prism4j.Prism4j.grammar;
import static io.noties.prism4j.Prism4j.pattern;
import static io.noties.prism4j.Prism4j.token;

@SuppressWarnings("unused")
public class Prism_xml {

  @NotNull
  public static Prism4j.Grammar create(@NotNull Prism4j prism4j) {
    return grammar(
        "xml",
        token("prolog", pattern(compile("<\\?xml[\\s\\S]*?\\?>"))),
        token("comment", pattern(compile("<!--[\\s\\S]*?-->"))),
        token("doctype", pattern(compile("<!DOCTYPE[\\s\\S]*?>", CASE_INSENSITIVE))),
        token("cdata", pattern(compile("<!\\[CDATA\\[[\\s\\S]*?\\]\\]>"))),
        token(
            "tag",
            pattern(
                compile(
                    "</?(?!\\d)[^\\s>/=$<%]+(?:\\s+[^\\s>/=]+(?:=(?:\"(?:\\\\[\\s\\S]|[^\\\\\"])*\"|'(?:\\\\[\\s\\S]|[^\\\\'])*'|[^\\s'\">=]+))?)*\\s*/?>"),
                false,
                true,
                null,
                grammar(
                    "inside",
                    token("tag-name", pattern(compile("^</?[^\\s>/]+"), false, false)),
                    token(
                        "attr-value",
                        pattern(
                            compile(
                                "=(?:\"(?:\\\\[\\s\\S]|[^\\\\\"])*\"|'(?:\\\\[\\s\\S]|[^\\\\'])*'|[^\\s'\">=]+)"),
                            false,
                            false,
                            null,
                            grammar(
                                "inside",
                                token("punctuation", pattern(compile("^="))),
                                token("string", pattern(compile("^(?:\"[^\"]*\"|'[^']*')")))
                            )
                        )
                    ),
                    token("punctuation", pattern(compile("^/?>"))),
                    token("attr-name", pattern(compile("^[^\\s>/]+")))
                )
            )
        ),
        token("entity", pattern(compile("&#?[a-z0-9]+;", CASE_INSENSITIVE)))
    );
  }
}