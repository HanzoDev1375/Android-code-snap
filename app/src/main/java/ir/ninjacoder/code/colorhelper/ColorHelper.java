package ir.ninjacoder.code.colorhelper;

import android.graphics.Color;
import java.util.ArrayList;
import java.util.List;

public class ColorHelper {

  protected int keyword;
  protected int operator;
  protected int method;
  protected int variable;
  protected int symbol;
  protected int comment;
  protected int lastdot;
  protected int lastsymi;
  protected int uppercase;
  protected int textnormal;
  protected int predot;
  protected int prebrak;
  protected int strings;
  protected int linenumbercolor;
  protected int bracketcolor;
  protected int htmlkeyword;
  protected int htmlattr;
  protected int csskeyword;
  protected int cssoprator;
  protected int cardbackground;
  protected int cardstorkecolor;
  protected ThemeManager thememanager = ThemeManager.DARKTHEME;

  public ColorHelper() {
    updateTheme();
  }

  void updateTheme() {
    switch (thememanager) {
      case DEFAULTTHEME:
        applyDefaultTheme();
        break;
      case DARKTHEME:
        applyDarkTheme();
        break;
      case LIGHTTHEME:
        applyLightTheme();
        break;
      case PROGRAMTHRME:
        applyProgrammingTheme();
        break;
      case GHOSTTHRME:
        applyghostTheme();
        break;
      case OCEANTHEME:
        applyOceanTheme();
        break;
      case SUNSETTHEME:
        applySunsetTheme();
        break;
      case FORESTTHEME:
        applyForestTheme();
        break;
      case ROYALTHEME:
        applyRoyalTheme();
        break;
      case CYBERPUNKTHEME:
        applyCyberpunkTheme();
        break;
      case WARMTHEME:
        applyWarmTheme();
        break;
      case ICETHEME:
        applyIceTheme();
        break;
      case RETROTHEME:
        applyRetroTheme();
        break;
      case MIDNIGHTTHEME:
        applyMidnightTheme();
        break;
      case CANDYTHEME:
        applyCandyTheme();
        break;
      default:
        applyDefaultTheme();
        break;
    }
  }

  void applyDefaultTheme() {

    keyword = Color.parseColor("#FF569CD6");
    operator = Color.parseColor("#FFDCDCAA");
    method = Color.parseColor("#FFD7BA7D");
    variable = Color.parseColor("#FF9CDCFE");
    symbol = Color.parseColor("#FFD4D4D4");
    comment = Color.parseColor("#FF6A9955");
    lastdot = Color.parseColor("#FFCE9178");
    lastsymi = Color.parseColor("#FFCE9178");
    uppercase = Color.parseColor("#FF4EC9B0");
    textnormal = Color.parseColor("#FFD4D4D4");
    prebrak = Color.parseColor("#FFFF79C6");
    predot = Color.parseColor("#FFC586C0");
    strings = Color.parseColor("#FFCE9178");
    linenumbercolor = Color.parseColor("#FF858585");
    bracketcolor = Color.parseColor("#33FFFFFF");
    htmlkeyword = Color.parseColor("#FF569CD6");
    htmlattr = Color.parseColor("#FF9CDCFE");
    csskeyword = Color.parseColor("#FFD7BA7D");
    cssoprator = Color.parseColor("#FFDCDCAA");
    cardbackground = Color.parseColor("#FF141118");
    cardstorkecolor = Color.parseColor("#FF928F98");
  }

  void applyDarkTheme() {

    keyword = Color.parseColor("#FFC678DD");
    operator = Color.parseColor("#FF56B6C2");
    method = Color.parseColor("#FF61AFEF");
    variable = Color.parseColor("#FFE06C75");
    symbol = Color.parseColor("#FFABB2BF");
    comment = Color.parseColor("#FF5C6370");
    lastdot = Color.parseColor("#FF98C379");
    lastsymi = Color.parseColor("#FFD19A66");
    uppercase = Color.parseColor("#FFE5C07B");
    textnormal = Color.parseColor("#FFABB2BF");
    prebrak = Color.parseColor("#FFFF6C6B");
    predot = Color.parseColor("#FFC678DD");
    strings = Color.parseColor("#FF98C379");
    linenumbercolor = Color.parseColor("#FF4B5263");
    bracketcolor = Color.parseColor("#3356B6C2");
    htmlkeyword = Color.parseColor("#FFE06C75");
    htmlattr = Color.parseColor("#FFD19A66");
    csskeyword = Color.parseColor("#FF61AFEF");
    cssoprator = Color.parseColor("#FF56B6C2");
    cardbackground = Color.parseColor("#FF141118");
    cardstorkecolor = Color.parseColor("#FF928F98");
  }

  void applyLightTheme() {

    keyword = Color.parseColor("#FF268BD2");
    operator = Color.parseColor("#FF2AA198");
    method = Color.parseColor("#FFD33682");
    variable = Color.parseColor("#FF859900");
    symbol = Color.parseColor("#FF657B83");
    comment = Color.parseColor("#FF93A1A1");
    lastdot = Color.parseColor("#FFB58900");
    lastsymi = Color.parseColor("#FFCB4B16");
    uppercase = Color.parseColor("#FF6C71C4");
    textnormal = Color.parseColor("#FF586E75");
    prebrak = Color.parseColor("#FFDC322F");
    predot = Color.parseColor("#FF268BD2");
    strings = Color.parseColor("#FF859900");
    linenumbercolor = Color.parseColor("#FF839496");
    bracketcolor = Color.parseColor("#332AA198");
    htmlkeyword = Color.parseColor("#FF268BD2");
    htmlattr = Color.parseColor("#FF859900");
    csskeyword = Color.parseColor("#FFD33682");
    cssoprator = Color.parseColor("#FF2AA198");
    cardbackground = Color.parseColor("#FFFEF7FF");
    cardstorkecolor = Color.parseColor("#FF928F98");
  }

  void applyProgrammingTheme() {

    keyword = Color.parseColor("#FFFF79C6");
    operator = Color.parseColor("#FFFF5555");
    method = Color.parseColor("#FF50FA7B");
    variable = Color.parseColor("#FF8BE9FD");
    symbol = Color.parseColor("#FFFFB86C");
    comment = Color.parseColor("#FF6272A4");
    lastdot = Color.parseColor("#FFFFF68F");
    lastsymi = Color.parseColor("#FFFF79C6");
    uppercase = Color.parseColor("#FFBD93F9");
    textnormal = Color.parseColor("#FFF8F8F2");
    prebrak = Color.parseColor("#FFFF5555");
    predot = Color.parseColor("#FF50FA7B");
    strings = Color.parseColor("#FFFFF68F");
    linenumbercolor = Color.parseColor("#FFBD93F9");
    bracketcolor = Color.parseColor("#33FF79C6");
    htmlkeyword = Color.parseColor("#FFFF79C6");
    htmlattr = Color.parseColor("#FF50FA7B");
    csskeyword = Color.parseColor("#FF8BE9FD");
    cssoprator = Color.parseColor("#FFFF5555");
  }

  void applyghostTheme() {

    keyword = Color.parseColor("#FF00FF9F");
    operator = Color.parseColor("#FF00DDFF");
    method = Color.parseColor("#FF7BFF7B");
    variable = Color.parseColor("#FF87CEFA");
    symbol = Color.parseColor("#FF98FB98");
    comment = Color.parseColor("#FF32CD32");
    lastdot = Color.parseColor("#FFADFF2F");
    lastsymi = Color.parseColor("#FF00FA9A");
    uppercase = Color.parseColor("#FF7FFF00");
    textnormal = Color.parseColor("#FF90EE90");
    prebrak = Color.parseColor("#FF00FF7F");
    predot = Color.parseColor("#FF3CB371");
    strings = Color.parseColor("#FF9ACD32");
    linenumbercolor = Color.parseColor("#FF228B22");
    bracketcolor = Color.parseColor("#3300FF9F");
    htmlkeyword = Color.parseColor("#FF00FF9F");
    htmlattr = Color.parseColor("#FF7BFF7B");
    csskeyword = Color.parseColor("#FF00DDFF");
    cssoprator = Color.parseColor("#FF98FB98");
  }

  void applyOceanTheme() {

    keyword = Color.parseColor("#FF1E90FF");
    operator = Color.parseColor("#FF20B2AA");
    method = Color.parseColor("#FF00CED1");
    variable = Color.parseColor("#FF87CEEB");
    symbol = Color.parseColor("#FF48D1CC");
    comment = Color.parseColor("#FF5F9EA0");
    lastdot = Color.parseColor("#FF00BFFF");
    lastsymi = Color.parseColor("#FF1E90FF");
    uppercase = Color.parseColor("#FF7FFFD4");
    textnormal = Color.parseColor("#FFF0F8FF");
    prebrak = Color.parseColor("#FF4682B4");
    predot = Color.parseColor("#FF6495ED");
    strings = Color.parseColor("#FFAFEEEE");
    linenumbercolor = Color.parseColor("#FFB0C4DE");
    bracketcolor = Color.parseColor("#331E90FF");
    htmlkeyword = Color.parseColor("#FF1E90FF");
    htmlattr = Color.parseColor("#FF00CED1");
    csskeyword = Color.parseColor("#FF20B2AA");
    cssoprator = Color.parseColor("#FF48D1CC");
  }

  void applySunsetTheme() {

    keyword = Color.parseColor("#FFFF4500");
    operator = Color.parseColor("#FFFF6347");
    method = Color.parseColor("#FFFF69B4");
    variable = Color.parseColor("#FFFFA500");
    symbol = Color.parseColor("#FFFFD700");
    comment = Color.parseColor("#FFDA70D6");
    lastdot = Color.parseColor("#FFFF1493");
    lastsymi = Color.parseColor("#FFFF4500");
    uppercase = Color.parseColor("#FFFF8C00");
    textnormal = Color.parseColor("#FFFFF0F5");
    prebrak = Color.parseColor("#FFFF0000");
    predot = Color.parseColor("#FFFF69B4");
    strings = Color.parseColor("#FFFFDAB9");
    linenumbercolor = Color.parseColor("#FFFFA07A");
    bracketcolor = Color.parseColor("#33FF4500");
    htmlkeyword = Color.parseColor("#FFFF4500");
    htmlattr = Color.parseColor("#FFFF69B4");
    csskeyword = Color.parseColor("#FFFF6347");
    cssoprator = Color.parseColor("#FFFFD700");
  }

  void applyForestTheme() {

    keyword = Color.parseColor("#FF228B22");
    operator = Color.parseColor("#FF32CD32");
    method = Color.parseColor("#FF6B8E23");
    variable = Color.parseColor("#FF9ACD32");
    symbol = Color.parseColor("#FF8FBC8F");
    comment = Color.parseColor("#FF556B2F");
    lastdot = Color.parseColor("#FFADFF2F");
    lastsymi = Color.parseColor("#FF7CFC00");
    uppercase = Color.parseColor("#FF00FF7F");
    textnormal = Color.parseColor("#FFF5FFFA");
    prebrak = Color.parseColor("#FF8B4513");
    predot = Color.parseColor("#FFDAA520");
    strings = Color.parseColor("#FF90EE90");
    linenumbercolor = Color.parseColor("#FFBC8F8F");
    bracketcolor = Color.parseColor("#33228B22");
    htmlkeyword = Color.parseColor("#FF228B22");
    htmlattr = Color.parseColor("#FF9ACD32");
    csskeyword = Color.parseColor("#FF32CD32");
    cssoprator = Color.parseColor("#FF8FBC8F");
  }

  void applyRoyalTheme() {

    keyword = Color.parseColor("#FF8A2BE2");
    operator = Color.parseColor("#FF9370DB");
    method = Color.parseColor("#FF9932CC");
    variable = Color.parseColor("#FFBA55D3");
    symbol = Color.parseColor("#FFDDA0DD");
    comment = Color.parseColor("#FF6A5ACD");
    lastdot = Color.parseColor("#FFFF00FF");
    lastsymi = Color.parseColor("#FFDA70D6");
    uppercase = Color.parseColor("#FFD8BFD8");
    textnormal = Color.parseColor("#FFE6E6FA");
    prebrak = Color.parseColor("#FFFFD700");
    predot = Color.parseColor("#FFFF69B4");
    strings = Color.parseColor("#FFEEE8AA");
    linenumbercolor = Color.parseColor("#FFBDB76B");
    bracketcolor = Color.parseColor("#338A2BE2");
    htmlkeyword = Color.parseColor("#FF8A2BE2");
    htmlattr = Color.parseColor("#FFBA55D3");
    csskeyword = Color.parseColor("#FF9370DB");
    cssoprator = Color.parseColor("#FFFFD700");
  }

  void applyCyberpunkTheme() {

    keyword = Color.parseColor("#FFFF00FF");
    operator = Color.parseColor("#FF00FFFF");
    method = Color.parseColor("#FFFFFF00");
    variable = Color.parseColor("#FF00FF00");
    symbol = Color.parseColor("#FFFF4500");
    comment = Color.parseColor("#FF808080");
    lastdot = Color.parseColor("#FFFF1493");
    lastsymi = Color.parseColor("#FF1E90FF");
    uppercase = Color.parseColor("#FF7CFC00");
    textnormal = Color.parseColor("#FFFFFFFF");
    prebrak = Color.parseColor("#FFFF0000");
    predot = Color.parseColor("#FF00CED1");
    strings = Color.parseColor("#FFADFF2F");
    linenumbercolor = Color.parseColor("#FF4B0082");
    bracketcolor = Color.parseColor("#33FF00FF");
    htmlkeyword = Color.parseColor("#FFFF00FF");
    htmlattr = Color.parseColor("#FF00FF00");
    csskeyword = Color.parseColor("#FF00FFFF");
    cssoprator = Color.parseColor("#FFFFFF00");
  }

  void applyWarmTheme() {

    keyword = Color.parseColor("#FFA0522D");
    operator = Color.parseColor("#FFCD853F");
    method = Color.parseColor("#FFDEB887");
    variable = Color.parseColor("#FFF4A460");
    symbol = Color.parseColor("#FFD2B48C");
    comment = Color.parseColor("#FFBC8F8F");
    lastdot = Color.parseColor("#FF8B4513");
    lastsymi = Color.parseColor("#FFD2691E");
    uppercase = Color.parseColor("#FFFFDEAD");
    textnormal = Color.parseColor("#FFFFFAF0");
    prebrak = Color.parseColor("#FFDA70D6");
    predot = Color.parseColor("#FFFF69B4");
    strings = Color.parseColor("#FFFFE4B5");
    linenumbercolor = Color.parseColor("#FFF5DEB3");
    bracketcolor = Color.parseColor("#33A0522D");
    htmlkeyword = Color.parseColor("#FFA0522D");
    htmlattr = Color.parseColor("#FFDEB887");
    csskeyword = Color.parseColor("#FFCD853F");
    cssoprator = Color.parseColor("#FFD2B48C");
  }

  void applyIceTheme() {

    keyword = Color.parseColor("#FFADD8E6");
    operator = Color.parseColor("#FFB0E0E6");
    method = Color.parseColor("#FF87CEFA");
    variable = Color.parseColor("#FFE0FFFF");
    symbol = Color.parseColor("#FFF0F8FF");
    comment = Color.parseColor("#FFD3D3D3");
    lastdot = Color.parseColor("#FFAFEEEE");
    lastsymi = Color.parseColor("#FF48D1CC");
    uppercase = Color.parseColor("#FF7FFFD4");
    textnormal = Color.parseColor("#FFFFFFFF");
    prebrak = Color.parseColor("#FF00BFFF");
    predot = Color.parseColor("#FF1E90FF");
    strings = Color.parseColor("#FFF5FFFA");
    linenumbercolor = Color.parseColor("#FFE6E6FA");
    bracketcolor = Color.parseColor("#33ADD8E6");
    htmlkeyword = Color.parseColor("#FFADD8E6");
    htmlattr = Color.parseColor("#FFE0FFFF");
    csskeyword = Color.parseColor("#FFB0E0E6");
    cssoprator = Color.parseColor("#FFF0F8FF");
  }

  void applyRetroTheme() {

    keyword = Color.parseColor("#FFFF69B4");
    operator = Color.parseColor("#FF00FF7F");
    method = Color.parseColor("#FFFFFF00");
    variable = Color.parseColor("#FF1E90FF");
    symbol = Color.parseColor("#FFFFA500");
    comment = Color.parseColor("#FF808080");
    lastdot = Color.parseColor("#FFFF00FF");
    lastsymi = Color.parseColor("#FF00FFFF");
    uppercase = Color.parseColor("#FF7CFC00");
    textnormal = Color.parseColor("#FFFFFFFF");
    prebrak = Color.parseColor("#FFFF0000");
    predot = Color.parseColor("#FFDA70D6");
    strings = Color.parseColor("#FFADFF2F");
    linenumbercolor = Color.parseColor("#FF4B0082");
    bracketcolor = Color.parseColor("#33FF69B4");
    htmlkeyword = Color.parseColor("#FFFF69B4");
    htmlattr = Color.parseColor("#FF00FF7F");
    csskeyword = Color.parseColor("#FFFFFF00");
    cssoprator = Color.parseColor("#FF1E90FF");
  }

  void applyMidnightTheme() {

    keyword = Color.parseColor("#FF191970");
    operator = Color.parseColor("#FF000080");
    method = Color.parseColor("#FF4169E1");
    variable = Color.parseColor("#FF6A5ACD");
    symbol = Color.parseColor("#FF483D8B");
    comment = Color.parseColor("#FF2F4F4F");
    lastdot = Color.parseColor("#FF00BFFF");
    lastsymi = Color.parseColor("#FF1E90FF");
    uppercase = Color.parseColor("#FF87CEEB");
    textnormal = Color.parseColor("#FFF0F8FF");
    prebrak = Color.parseColor("#FFFFD700");
    predot = Color.parseColor("#FFDA70D6");
    strings = Color.parseColor("#FFAFEEEE");
    linenumbercolor = Color.parseColor("#FF708090");
    bracketcolor = Color.parseColor("#33191970");
    htmlkeyword = Color.parseColor("#FF191970");
    htmlattr = Color.parseColor("#FF4169E1");
    csskeyword = Color.parseColor("#FF000080");
    cssoprator = Color.parseColor("#FF6A5ACD");
  }

  void applyCandyTheme() {

    keyword = Color.parseColor("#FFFFB6C1");
    operator = Color.parseColor("#FF98FB98");
    method = Color.parseColor("#FF87CEFA");
    variable = Color.parseColor("#FFFFD700");
    symbol = Color.parseColor("#FFDDA0DD");
    comment = Color.parseColor("#FFFFA07A");
    lastdot = Color.parseColor("#FFE0FFFF");
    lastsymi = Color.parseColor("#FFFFE4E1");
    uppercase = Color.parseColor("#FFF0FFF0");
    textnormal = Color.parseColor("#FFFFFAFA");
    prebrak = Color.parseColor("#FFFF69B4");
    predot = Color.parseColor("#FFADFF2F");
    strings = Color.parseColor("#FFFFE4B5");
    linenumbercolor = Color.parseColor("#FFD8BFD8");
    bracketcolor = Color.parseColor("#33FFB6C1");
    htmlkeyword = Color.parseColor("#FFFFB6C1");
    htmlattr = Color.parseColor("#FF98FB98");
    csskeyword = Color.parseColor("#FF87CEFA");
    cssoprator = Color.parseColor("#FFFFD700");
  }

  public int getKeyword() {
    return this.keyword;
  }

  public void setKeyword(int keyword) {
    this.keyword = keyword;
  }

  public int getOperator() {
    return this.operator;
  }

  public void setOperator(int operator) {
    this.operator = operator;
  }

  public int getMethod() {
    return this.method;
  }

  public void setMethod(int method) {
    this.method = method;
  }

  public int getVariable() {
    return this.variable;
  }

  public void setVariable(int variable) {
    this.variable = variable;
  }

  public int getSymbol() {
    return this.symbol;
  }

  public void setSymbol(int symbol) {
    this.symbol = symbol;
  }

  public int getComment() {
    return this.comment;
  }

  public void setComment(int comment) {
    this.comment = comment;
  }

  public int getLastdot() {
    return this.lastdot;
  }

  public void setLastdot(int lastdot) {
    this.lastdot = lastdot;
  }

  public int getLastsymi() {
    return this.lastsymi;
  }

  public void setLastsymi(int lastsymi) {
    this.lastsymi = lastsymi;
  }

  public int getUppercase() {
    return this.uppercase;
  }

  public void setUppercase(int uppercase) {
    this.uppercase = uppercase;
  }

  public int getTextnormal() {
    return this.textnormal;
  }

  public void setTextnormal(int textnormal) {
    this.textnormal = textnormal;
  }

  public int getPredot() {
    return this.predot;
  }

  public void setPredot(int predot) {
    this.predot = predot;
  }

  public int getPrebrak() {
    return this.prebrak;
  }

  public void setPrebrak(int prebrak) {
    this.prebrak = prebrak;
  }

  public int getStrings() {
    return this.strings;
  }

  public void setStrings(int strings) {
    this.strings = strings;
  }

  public int getLinenumbercolor() {
    return this.linenumbercolor;
  }

  public void setLinenumbercolor(int linenumbercolor) {
    this.linenumbercolor = linenumbercolor;
  }

  public int getBracketcolor() {
    return this.bracketcolor;
  }

  public void setBracketcolor(int bracketcolor) {
    this.bracketcolor = bracketcolor;
  }

  public int getHtmlkeyword() {
    return this.htmlkeyword;
  }

  public void setHtmlkeyword(int htmlkeyword) {
    this.htmlkeyword = htmlkeyword;
  }

  public int getHtmlattr() {
    return this.htmlattr;
  }

  public void setHtmlattr(int htmlattr) {
    this.htmlattr = htmlattr;
  }

  public int getCsskeyword() {
    return this.csskeyword;
  }

  public void setCsskeyword(int csskeyword) {
    this.csskeyword = csskeyword;
  }

  public int getCssoprator() {
    return this.cssoprator;
  }

  public void setCssoprator(int cssoprator) {
    this.cssoprator = cssoprator;
  }

  public ThemeManager getThememanager() {
    return this.thememanager;
  }

  public interface OnThemeChangeListener {
    void onThemeChanged();
  }

  private List<OnThemeChangeListener> listeners = new ArrayList<>();

  public void addOnThemeChangeListener(OnThemeChangeListener listener) {
    listeners.add(listener);
  }

  public void removeOnThemeChangeListener(OnThemeChangeListener listener) {
    listeners.remove(listener);
  }

  private void notifyThemeChanged() {
    for (OnThemeChangeListener listener : listeners) {
      listener.onThemeChanged();
    }
  }

  public void setThememanager(ThemeManager thememanager) {
    this.thememanager = thememanager;
    updateTheme();
    notifyThemeChanged();
  }

  public int getCardbackground() {
    return this.cardbackground;
  }

  public void setCardbackground(int cardbackground) {
    this.cardbackground = cardbackground;
  }

  public int getCardstorkecolor() {
    return this.cardstorkecolor;
  }

  public void setCardstorkecolor(int cardstorkecolor) {
    this.cardstorkecolor = cardstorkecolor;
  }
}
