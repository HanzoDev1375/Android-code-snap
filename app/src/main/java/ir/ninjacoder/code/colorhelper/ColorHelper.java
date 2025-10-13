package ir.ninjacoder.code.colorhelper;

import android.graphics.Color;

public class ColorHelper {
  protected int keyword;
  protected int operator;
  protected int method;
  protected int variable;
  protected int symbol;
  protected int comment;
  protected int lastdot;
  protected int strings;
  protected int lastsymi;
  protected int uppercase;
  protected int textnormal;
  protected int predot;
  protected int prebrak;
  protected int linenumbercolor;
  protected int bracketcolor;
  protected int htmlkeyword;
  protected int htmlattr;
  protected int csskeyword;
  protected int cssoprator;

  public ColorHelper() {
    applyColor();
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

  public void applyColor() {

    keyword = Color.parseColor("#FF569CD6");
    operator = Color.parseColor("#FFD69D56");
    method = Color.parseColor("#FFC586C0");
    variable = Color.parseColor("#FF4EC9B0");
    symbol = Color.parseColor("#FFDCDCAA");
    comment = Color.parseColor("#FF6A9955");
    lastdot = Color.parseColor("#FF8BBAFF");
    lastsymi = Color.parseColor("#FFCE9178");
    uppercase = Color.parseColor("#FFFF79C6");
    textnormal = Color.parseColor("#FFFFFFFF");
    prebrak = Color.parseColor("#FFFFB28B");
    predot = Color.parseColor("#FF90D15A");
    strings = Color.parseColor("#FF4FFF34");
    linenumbercolor = Color.parseColor("#ffffdd");
    bracketcolor = Color.parseColor("#BAFF9A67");
    htmlkeyword = Color.parseColor("#ff7027");
    htmlattr = Color.parseColor("#ff4ff819");
    csskeyword = Color.parseColor("#f63a52");
    cssoprator = Color.parseColor("#ff8061a2");
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
}
