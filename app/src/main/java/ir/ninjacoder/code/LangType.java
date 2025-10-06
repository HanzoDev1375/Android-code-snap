package ir.ninjacoder.code;

public enum LangType {
  JAVA(".java"),
  PYTHON(".py"),
  TYPESCRIPT(".ts"),
  JAVASCRIPT(".js"),
  RUST(".rs"),
  C(".c"),
  CPP(".cpp");

  private final String langname;

  LangType(String langname) {
    this.langname = langname;
  }

  public String getLangname() {
    return this.langname;
  }
}
