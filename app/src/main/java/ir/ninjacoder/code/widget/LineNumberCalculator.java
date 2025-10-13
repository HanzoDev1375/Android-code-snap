package ir.ninjacoder.code.widget;

 class LineNumberCalculator {

  private final CharSequence mTarget;
  private final int mLength;
  private int mOffset;
  private int mLine;
  private int mColumn;

  public LineNumberCalculator(CharSequence target) {
    mTarget = target;
    mOffset = mLine = mColumn = 0;
    mLength = mTarget.length();
  }

  public void update(int length) {
    for (int i = 0; i < length; i++) {
      if (mOffset + i == mLength) {
        break;
      }
      if (mTarget.charAt(mOffset + i) == '\n') {
        mLine++;
        mColumn = 0;
      } else {
        mColumn++;
      }
    }
    mOffset = mOffset + length;
  }

  public int findLineStart() {
    return mOffset - mColumn;
  }

  public int findLineEnd() {
    int i = 0;
    for (; i + mOffset < mLength; i++) {
      if (mTarget.charAt(mOffset + i) == '\n') {
        break;
      }
    }
    return mOffset + i;
  }

  public int getLine() {
    return mLine;
  }

  public int getColumn() {
    return mColumn;
  }
}
