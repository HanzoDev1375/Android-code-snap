package ir.ninjacoder.codesnap.colorhelper;

public enum ThemeManager {
  DEFAULTTHEME(0, "تم پیش‌فرض"),
  DARKTHEME(1, "تم تاریک"),
  LIGHTTHEME(2, "تم روشن"),
  PROGRAMTHRME(3, "تم برنامه‌نویسی"),
  GHOSTTHRME(4, "تم شبح"),
  OCEANTHEME(5, "تم اقیانوسی"),
  SUNSETTHEME(6, "تم غروب"),
  FORESTTHEME(7, "تم جنگلی"),
  ROYALTHEME(8, "تم سلطنتی"),
  CYBERPUNKTHEME(9, "تم سایبرپانک"),
  WARMTHEME(10, "تم گرم"),
  ICETHEME(11, "تم یخی"),
  RETROTHEME(12, "تم رترو"),
  MIDNIGHTTHEME(13, "تم نیمه‌شب"),
  CANDYTHEME(14, "تم آب‌نباتی"),
  AURORATHEME(15, "تم شفق"),
  LAVATHEME(16, "تم لاوا"),
  SANDTHEME(17, "تم ماسه‌ای"),
  NEONTHEME(18, "تم نئون"),
  MOONGLOWTHEME(19, "تم ماه‌تاب"),
  CUSTOM(20,"تم سفارشی")
  ;

  private int id;
  private String name;

  ThemeManager(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return name;
  }

  public static ThemeManager fromId(int id) {
    for (ThemeManager theme : values()) {
      if (theme.id == id) {
        return theme;
      }
    }
    return DEFAULTTHEME;
  }
}
