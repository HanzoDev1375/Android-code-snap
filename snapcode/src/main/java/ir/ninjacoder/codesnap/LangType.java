package ir.ninjacoder.codesnap;

import java.util.Arrays;

public enum LangType {
  JAVA(".java"),
  PYTHON(".py"),
  TYPESCRIPT(".ts"),
  JAVASCRIPT(".js"),
  RUST(".rs"),
  C(".c"),
  CPP(".cpp"),
  HTML(".html"),
  PHP(".php"),
  CSS(".css"),
  KOTLIN(".kt"),
  CSHARP(".cs"),
  GRADLE(".gradle"),
  DART(".dart"),
  GO(".go"),
  XML(".xml"),
  JSON(".json"),
  YAML(".yml"),
  RUBY(".rb"),
  MARKDOWN(".md"),
  ZIG(".zig"),
  LUA(".lua"),
  NONE("");

  private final String langname;

  LangType(String langname) {
    this.langname = langname;
  }

  public String getLangname() {
    return this.langname;
  }

  public LangType getLangTypeFromPath(String filePath) {
    for (LangType lang : LangType.values()) {
      if (filePath.endsWith(lang.getLangname())) {
        return lang;
      }
    }
    return null;
  }

  public boolean hasFile(String file) {
    return Arrays.stream(LangType.values()).allMatch(it -> file.endsWith(it.getLangname()));
  }
}
