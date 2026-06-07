package ir.ninjacoder.codesnap.diagnostics;

import android.graphics.Color;

public enum DiagnosticsState {
  ERROR(0, Color.RED),
  WARNING(1, Color.YELLOW),
  TYPO(2, Color.GREEN),
  NONE(3);

  int value;
  int color;

  DiagnosticsState(int color) {
    this.color = color;
  }

  DiagnosticsState(int value, int color) {
    this.value = value;
    this.color = color;
  }

  public int getValue() {
    return this.value;
  }

  public int getColor() {
    return this.color;
  }
}
