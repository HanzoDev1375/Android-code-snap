package ir.ninjacoder.codesnap.bracket;

public class BracketPosition {
  public int start;
  public int end;
  public int length;
  public char bracketChar;
  public int tokenType;

  public BracketPosition(int start, int end, char bracketChar, int tokenType) {
    this.start = start;
    this.end = end;
    this.length = end - start;
    this.bracketChar = bracketChar;
    this.tokenType = tokenType;
  }
}
