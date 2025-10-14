package ir.ninjacoder.codesnap.bracket;

public class BracketPair {
  public int openPos;
  public int closePos;
  public int openLength;
  public int closeLength;

  public BracketPair(int openPos, int closePos, int length) {
    this.openPos = openPos;
    this.closePos = closePos;
    this.openLength = length;
    this.closeLength = length;
  }
}
