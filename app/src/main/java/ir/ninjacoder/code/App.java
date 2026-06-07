package ir.ninjacoder.code;

import android.app.Application;

import android.graphics.Paint;
import com.downloader.PRDownloader;
import ir.ninjacoder.codesnap.colorhelper.ThemeLoader;

public class App extends Application {
  @Override
  public void onCreate() {
    super.onCreate();
    Paint paint = new Paint();
    PRDownloader.initialize(this);
    
    ThemeLoader.init(this);
    // TODO: Implement this method
  }
}
