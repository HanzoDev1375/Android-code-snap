package ir.ninjacoder.code;

import android.app.Application;

import android.graphics.Paint;
import ir.ninjacoder.codesnap.colorhelper.ThemeLoader;

public class App extends Application {
  @Override
  public void onCreate() {
    super.onCreate();
    Paint paint = new Paint();
    
    ThemeLoader.init(this);
    // TODO: Implement this method
  }
}
