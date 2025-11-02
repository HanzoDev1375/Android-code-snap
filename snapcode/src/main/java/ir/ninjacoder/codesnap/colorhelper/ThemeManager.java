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
  CUSTOM(20, "تم سفارشی"),
  BLACKNINJA(21, "نینجا"),
  MATRIXTHEME(22, "تم ماتریکس"),
  GOLDTHEME(23, "تم طلایی"),
  CYBERBLUETHEME(24, "تم آبی آینده‌نگر"),
  DUSKDREAM(22, "تم غروب رویایی"),
  MYSTICJUNGLE(23, "تم جنگل اسرارآمیز"),
  COSMICPURPLE(24, "تم بنفش کیهانی"),
  SUNSETBLAZE(25, "تم غروب آتشین"),
  OCEANDEPTH(26, "تم عمق اقیانوس"),
  NEONDREAM(27, "تم رویای نئون"),
  ROYALAMBER(28, "تم کهربای سلطنتی"),
  MINTCHOCOLATE(29, "تم نعنا شکلاتی"),
  CYBERPINK(30, "تم صورتی سایبری"),
  GOLDENHOUR(31, "تم ساعت طلایی"),
  ARCTICICE(32, "تم یخ قطبی"),
  RUBYRED(33, "تم یاقوت سرخ"),
  EMERALDGREEN(34, "تم زمرد سبز"),
  SAPPHIREBLUE(35, "تم یاقوت آبی"),
  AMETHYSTPURPLE(36, "تم آمیتیست بنفش"),
  CITRUSORANGE(37, "تم مرکبات نارنجی"),
  MIDNIGHTBLUE(38, "تم نیمه‌شب آبی"),
  ROSEGOLD(39, "تم رزگلد"),
  ELECTRICVIOLET(40, "تم بنفش الکتریک"),
  TROPICALSUNSET(41, "تم غروب استوایی");

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
