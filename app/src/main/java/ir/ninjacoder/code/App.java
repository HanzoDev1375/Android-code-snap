package ir.ninjacoder.code;

import android.app.Application;

import ch.usi.si.seart.treesitter.*;
import ir.ninjacoder.codesnap.colorhelper.ThemeLoader;

public class App extends Application {
  @Override
  public void onCreate() {
    super.onCreate();
    ThemeLoader.init(this);
    // TODO: Implement this method
  }
}
