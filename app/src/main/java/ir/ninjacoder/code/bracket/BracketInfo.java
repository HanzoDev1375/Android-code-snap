package ir.ninjacoder.code.bracket;

public class BracketInfo {
  public char character;
  public int position;
  public int tokenType;

  public BracketInfo(char character, int position, int tokenType) {
    this.character = character;
    this.position = position;
    this.tokenType = tokenType;
  }
}
