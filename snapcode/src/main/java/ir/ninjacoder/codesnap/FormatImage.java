package ir.ninjacoder.codesnap;

public enum FormatImage {
  PNG(0),
  JPEG(1),
  WEBP(2),
  PDF(3),
  WEB_LOSSY(4),
  SVG(5),
  VECTORDRAWABLE(6);
  int id;

  FormatImage(int id) {
    this.id = id;
  }

  public int getId() {
    return this.id;
  }
}
