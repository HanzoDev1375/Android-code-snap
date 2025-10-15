package ir.ninjacoder.codesnap;

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
  KOTLIN(".kt");

  private final String langname;

  LangType(String langname) {
    this.langname = langname;
  }

  public String getLangname() {
    return this.langname;
  }
}
