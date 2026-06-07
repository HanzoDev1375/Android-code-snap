package ir.ninjacoder.code;

import android.Manifest;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class DownloadActivity extends AppCompatActivity {

    private TextView tvPercent, tvStatus, tvSize;
    private ProgressBar progressBar;
    private Button btnStart, btnPause, btnResume, btnCancel;

    private DownloadService downloadService;
    private boolean bound = false;

    private final ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            DownloadService.LocalBinder binder = (DownloadService.LocalBinder) service;
            downloadService = binder.getService();
            bound = true;

            if (downloadService != null) {
                int lastPercent = downloadService.getCurrentProgress();
                long lastCur = downloadService.getCurrentBytes();
                long lastTotal = downloadService.getTotalBytes();
                updateUI(lastPercent, lastCur, lastTotal);
            }

            downloadService.setListener(
                    new DownloadService.DownloadListener() {
                        @Override
                        public void onProgress(int percent, long currentBytes, long totalBytes) {
                            updateUI(percent, currentBytes, totalBytes);
                        }

                        @Override
                        public void onStatusChanged(String status) {
                            runOnUiThread(() -> tvStatus.setText("وضعیت: " + status));
                        }

                        @Override
                        public void onError(String error) {
                            runOnUiThread(
                            () ->
                                    Toast.makeText(DownloadActivity.this, error, Toast.LENGTH_SHORT).show());
                        }
                    });
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            bound = false;
        }
    };

    private void updateUI(int percent, long currentBytes, long totalBytes) {
        runOnUiThread(
        () -> {
            progressBar.setProgress(percent);
            tvPercent.setText(percent + "%");

            if (totalBytes > 0) {
                String curMB = String.format("%.1f", currentBytes / (1024.0 * 1024.0));
                String totalMB = String.format("%.1f", totalBytes / (1024.0 * 1024.0));
                tvSize.setText("دریافت شده: " + curMB + "MB / " + totalMB + "MB");
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);

        tvPercent = findViewById(R.id.tv_percent);
        tvStatus = findViewById(R.id.tv_status);
        tvSize = findViewById(R.id.tv_size);
        progressBar = findViewById(R.id.progress_bar);
        btnStart = findViewById(R.id.btn_start);
        btnPause = findViewById(R.id.btn_pause);
        btnResume = findViewById(R.id.btn_resume);
        btnCancel = findViewById(R.id.btn_cancel);

        if (Build.VERSION.SDK_INT >= 33) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(
                        this, new String[]{Manifest.permission.POST_NOTIFICATIONS}, 101);
            }
        }

        Intent intent = new Intent(this, DownloadService.class);
        bindService(intent, connection, Context.BIND_AUTO_CREATE);

        btnStart.setOnClickListener(
                v -> {
                    String url = "https://github.com/HanzoDev1375/Ghostide/raw/refs/heads/main/app/src/arm64/assets/python.7z";
                    String name = "testfile_100mb.bin";
                    startDownload(url, name);
                });

        btnPause.setOnClickListener(
                v -> {
                    if (bound && downloadService != null) downloadService.pauseDownload();
                });

        btnResume.setOnClickListener(
                v -> {
                    if (bound && downloadService != null) downloadService.resumeDownload();
                });

        btnCancel.setOnClickListener(
                v -> {
                    if (bound && downloadService != null) downloadService.cancelDownload();
                });
    }

    private void startDownload(String url, String fileName) {
        Intent serviceIntent = new Intent(this, DownloadService.class);
        serviceIntent.setAction("START");
        serviceIntent.putExtra("url", url);
        serviceIntent.putExtra("filename", fileName);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(serviceIntent);
        } else {
            startService(serviceIntent);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bound) {
            unbindService(connection);
            bound = false;
        }
    }

    @Override
    public void onRequestPermissionsResult(
            int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 101
                && grantResults.length > 0
                && grantResults[0] != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "اجازه نوتیفیکیشن برای نمایش دانلود لازم است", Toast.LENGTH_LONG).show();
        }
    }
}
