package com.example.files;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.io.File;

public class MainActivity extends AppCompatActivity {
    Button closeButton,searchButton;
    EditText inp_file;
    String searchdir = Environment.getExternalStorageDirectory().getPath()+"/Download";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        closeButton=findViewById(R.id.cancel);
        searchButton=findViewById(R.id.search);
        inp_file=findViewById(R.id.filename);
        AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(this);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setMessage("Are you sure you want to Close App ?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finishAffinity();
                                System.exit(0);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED)
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 111);
                File root=new File(searchdir);
                String filename=inp_file.getText().toString();
                Boolean found= false;
                for(File dir:root.listFiles())
                {
                    System.out.println(dir.getName());
                    if(filename.equalsIgnoreCase(dir.getName()))
                        found = true;
                }
                if(found)
                {
                    Intent download=new Intent(getApplicationContext(),FileActivity.class);
                    String file_name=inp_file.getText().toString();
                    download.putExtra("file_path",searchdir+"/"+file_name);
                    startActivity(download);
                    MainActivity.this.finish();
                }
                else
                {
                    Intent download=new Intent(getApplicationContext(),FileActivity.class);
                    String path = "File not Found!";
                    download.putExtra("file_path",path);
                    startActivity(download);
                    MainActivity.this.finish();
                }
            }
        });
    }
}