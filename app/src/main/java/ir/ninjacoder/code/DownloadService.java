package ir.ninjacoder.code;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import com.downloader.Error;
import com.downloader.OnDownloadListener;
import com.downloader.OnProgressListener;
import com.downloader.PRDownloader;
import com.downloader.Progress;
import com.downloader.Status;

public class DownloadService extends Service {

  private final IBinder binder = new LocalBinder();
  private final Handler mainHandler = new Handler(Looper.getMainLooper());
  private int downloadId = -1;

  
  private int lastProgressPercent = 0;
  private long lastCurrentBytes = 0;
  private long lastTotalBytes = 0;

  
  public interface DownloadListener {
    void onProgress(int percent, long currentBytes, long totalBytes);

    void onStatusChanged(String status);

    void onError(String error);
  }

  private DownloadListener listener;

  public class LocalBinder extends Binder {
    public DownloadService getService() {
      return DownloadService.this;
    }
  }

  public void setListener(DownloadListener listener) {
    this.listener = listener;
  }

  @Nullable
  @Override
  public IBinder onBind(Intent intent) {
    return binder;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    createNotificationChannel();
    startForeground(1, buildNotification("آماده دانلود", 0));
  }

  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {
    if (intent != null && intent.getAction() != null) {
      String action = intent.getAction();
      switch (action) {
        case "START":
          String url = intent.getStringExtra("url");
          String name = intent.getStringExtra("filename");
          if (url != null && name != null) startDownload(url, name);
          break;
        case "PAUSE":
          pauseDownload();
          break;
        case "RESUME":
          resumeDownload();
          break;
      }
    }
    return START_STICKY;
  }

  
  public void startDownload(String url, String fileName) {
    String dirPath =
        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
            .getAbsolutePath();

    downloadId =
        PRDownloader.download(url, dirPath, fileName)
            .build()
            .setOnStartOrResumeListener(() -> notifyListener("شروع شد"))
            .setOnPauseListener(
                () -> {
                  notifyListener("توقف");
                  updateNotification("متوقف شد", lastProgressPercent);
                })
            .setOnProgressListener(
                new OnProgressListener() {
                  @Override
                  public void onProgress(Progress progress) {
                    
                    lastCurrentBytes = progress.currentBytes;
                    lastTotalBytes = progress.totalBytes;
                    lastProgressPercent = (int) ((lastCurrentBytes * 100) / lastTotalBytes);

                    
                    mainHandler.post(
                        () -> {
                          if (listener != null) {
                            listener.onProgress(
                                lastProgressPercent, lastCurrentBytes, lastTotalBytes);
                          }
                        });

                    
                    updateNotification("در حال دانلود...", lastProgressPercent);
                  }
                })
            .start(
                new OnDownloadListener() {
                  @Override
                  public void onDownloadComplete() {
                    lastProgressPercent = 100;
                    notifyListener("تکمیل");
                    updateNotification("دانلود کامل شد", 100);
                    downloadId = -1;
                  }

                  @Override
                  public void onError(Error error) {
                    String msg = error != null ? error.getServerErrorMessage() : "خطای ناشناخته";
                    notifyListener(msg);
                    updateNotification("خطا در دانلود", lastProgressPercent);
                    downloadId = -1;
                  }
                });
  }

  
  public void pauseDownload() {
    if (downloadId != -1 && PRDownloader.getStatus(downloadId) == Status.RUNNING) {
      PRDownloader.pause(downloadId);
    }
  }

  
  public void resumeDownload() {
    if (downloadId != -1 && PRDownloader.getStatus(downloadId) == Status.PAUSED) {
      PRDownloader.resume(downloadId);
    }
  }

  
  public void cancelDownload() {
    if (downloadId != -1) {
      PRDownloader.cancel(downloadId);
      downloadId = -1;
      notifyListener("لغو شد");
      updateNotification("لغو شد", 0);
    }
  }

  
  public int getCurrentProgress() {
    return lastProgressPercent;
  }

  public long getCurrentBytes() {
    return lastCurrentBytes;
  }

  public long getTotalBytes() {
    return lastTotalBytes;
  }

  
  private void notifyListener(String status) {
    mainHandler.post(
        () -> {
          if (listener != null) listener.onStatusChanged(status);
        });
  }

  
  private void createNotificationChannel() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
      NotificationChannel channel =
          new NotificationChannel(
              "download_channel", "دانلود فایل", NotificationManager.IMPORTANCE_LOW);
      NotificationManager manager = getSystemService(NotificationManager.class);
      if (manager != null) manager.createNotificationChannel(channel);
    }
  }

  private Notification buildNotification(String text, int progress) {
    Intent intent = new Intent(this, MainActivity.class);
    PendingIntent pi =
        PendingIntent.getActivity(
            this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

    return new NotificationCompat.Builder(this, "download_channel")
        .setContentTitle("دانلود فایل")
        .setContentText(text)
        .setSmallIcon(android.R.drawable.stat_sys_download)
        .setOngoing(true)
        .setContentIntent(pi)
        .setProgress(100, progress, progress < 0)
        .build();
  }

  private void updateNotification(String text, int progress) {
    NotificationManager manager = getSystemService(NotificationManager.class);
    if (manager != null) {
      manager.notify(1, buildNotification(text, progress));
    }
  }

  @Override
  public void onDestroy() {
    if (downloadId != -1) PRDownloader.pause(downloadId);
    super.onDestroy();
  }
}
