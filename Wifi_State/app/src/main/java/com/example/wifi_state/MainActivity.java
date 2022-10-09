package com.example.wifi_state;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button wifiEnable,wifiDisable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wifiEnable = (Button)findViewById(R.id.button);
        wifiDisable = (Button)findViewById(R.id.button2);

        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_WIFI_STATE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.ACCESS_WIFI_STATE},100);
        }

        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CHANGE_WIFI_STATE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CHANGE_WIFI_STATE},100);
        }


        wifiEnable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                wifi.setWifiEnabled(true);
                Toast.makeText(MainActivity.this, "Wifi Enable", Toast.LENGTH_SHORT).show();
            }
        });

        wifiDisable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                wifi.setWifiEnabled(false);
                Toast.makeText(MainActivity.this, "Wifi Disable", Toast.LENGTH_SHORT).show();

            }
        });
    }

}