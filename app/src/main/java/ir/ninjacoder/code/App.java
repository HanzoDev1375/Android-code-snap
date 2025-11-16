package ir.ninjacoder.code;

import android.app.Application;

import ir.ninjacoder.codesnap.colorhelper.ThemeLoader;

public class App extends Application {
  @Override
  public void onCreate() {
    super.onCreate();
    ThemeLoader.init(this);
    // TODO: Implement this method
  }
}
