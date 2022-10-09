package com.example.files;
import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileActivity extends AppCompatActivity {
    String finalpath;
    TextView text;
    Button download;
    ProgressBar progress;
    Handler handle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        text = findViewById(R.id.textView);
        download = findViewById(R.id.download);
        progress = findViewById(R.id.downloadprogress);
        progress.setProgress(0);
        progress.setMax(100);
        handle = new Handler(Looper.getMainLooper());
        AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(this);
        Intent intent = getIntent();
        finalpath = intent.getStringExtra("file_path").toString();

        if (finalpath.equals("File not Found!"))
        {
            builder.setMessage("File doesn't exist! Do you want to search again ?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Intent intent=new Intent(FileActivity.this,MainActivity.class);
                            startActivity(intent);
                            FileActivity.this.finish();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            finishAffinity();
                            System.exit(0);
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }
        else
        {
            download.setVisibility(View.VISIBLE);
            text.setVisibility(View.VISIBLE);
            text.setText("Download File");
            download.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder build = new AlertDialog.Builder(FileActivity.this);
                    build.setTitle("File Downloaded Successfully");
                    build.setMessage("Do you want to search again?");
                    build.setCancelable(false);
                    build.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(FileActivity.this, MainActivity.class);
                            startActivity(intent);
                            FileActivity.this.finish();
                        }
                    }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finishAffinity();
                            System.exit(0);
                        }
                    });
                    AlertDialog alert = build.create();

                    File src = new File(getIntent().getStringExtra("file_path"));
                    File dest = new File(Environment.getExternalStorageDirectory().getPath()+"/Documents");
                    FileInputStream fileinpstream;
                    FileOutputStream fileoutstream;
                    long length = src.length();
                    int bytesRead;
                    int totalBytesRead = 0;
                    byte[] buffer = new byte[10 * 1024];
                    try {
                        fileinpstream = new FileInputStream(src);
                        fileoutstream = new FileOutputStream(dest + "/download.mp4");
                        while ((bytesRead = fileinpstream.read(buffer)) != -1)
                        {
                            fileoutstream.write(buffer, 0, bytesRead);
                            totalBytesRead += bytesRead;
                            int percent = (int) (totalBytesRead * 100 / length);
                            progress.setVisibility(View.VISIBLE);
                            progress.incrementProgressBy(percent);
                        }
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    alert.show();
                }
            });
        }
    }
}