package ir.ninjacoder.codesnap.colorhelper;

import android.content.Context;
import android.graphics.Color;
import android.widget.Toast;
import org.json.JSONObject;
import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;

public class ThemeLoader {

  private static ThemeLoader instance;
  private Context context;
  protected String path;

  public ThemeLoader() {}

  private ThemeLoader(Context context) {
    this.context = context.getApplicationContext();
  }

  public static void init(Context context) {
    if (instance == null) {
      instance = new ThemeLoader(context);
    }
  }

  public static ThemeLoader get() {
    if (instance == null)
      throw new IllegalStateException(
          "ThemeLoader not initialized. Call ThemeLoader.init(context) in Application.");
    return instance;
  }

  JSONObject loadThemeFromPath(String path) {
    try {
      File file = new File(path);
      if (!file.exists()) return null;
      FileInputStream fis = new FileInputStream(file);
      byte[] buffer = new byte[(int) file.length()];
      int read = fis.read(buffer);
      fis.close();
      if (read <= 0) return null;
      String jsonString = new String(buffer, StandardCharsets.UTF_8);
      return new JSONObject(jsonString);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public void applyThemeFromJson(ColorHelper color) {
    if (path != null) {

      if (!path.isEmpty()) {

        JSONObject json = loadThemeFromPath(path);
        if (json == null) return;
        try {
          color.keyword = Color.parseColor(json.getString("keyword"));
          color.operator = Color.parseColor(json.getString("operator"));
          color.method = Color.parseColor(json.getString("method"));
          color.variable = Color.parseColor(json.getString("variable"));
          color.symbol = Color.parseColor(json.getString("symbol"));
          color.comment = Color.parseColor(json.getString("comment"));
          color.lastdot = Color.parseColor(json.getString("lastdot"));
          color.lastsymi = Color.parseColor(json.getString("lastsymi"));
          color.uppercase = Color.parseColor(json.getString("uppercase"));
          color.textnormal = Color.parseColor(json.getString("textnormal"));
          color.prebrak = Color.parseColor(json.getString("prebrak"));
          color.predot = Color.parseColor(json.getString("predot"));
          color.strings = Color.parseColor(json.getString("strings"));
          color.linenumbercolor = Color.parseColor(json.getString("linenumbercolor"));
          color.bracketcolor = Color.parseColor(json.getString("bracketcolor"));
          color.htmlkeyword = Color.parseColor(json.getString("htmlkeyword"));
          color.htmlattr = Color.parseColor(json.getString("htmlattr"));
          color.csskeyword = Color.parseColor(json.getString("csskeyword"));
          color.cssoprator = Color.parseColor(json.getString("cssoprator"));
          color.cardbackground = Color.parseColor(json.getString("cardbackground"));
          color.cardstorkecolor = Color.parseColor(json.getString("cardstorkecolor"));
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    } else Toast.makeText(context, "Path the empty", 2).show();
  }

  public String getPath() {
    return this.path;
  }

  public void setPath(String path) {
    this.path = path;
  }
}
