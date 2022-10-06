package com.example.alarammanager;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int miliseconds;
    EditText secondText,minuteText;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        minuteText = (EditText) findViewById(R.id.editText1);
        secondText = (EditText) findViewById(R.id.editText2);
        btn = (Button)findViewById(R.id.button);
        MediaPlayer mp = MediaPlayer.create(this,R.raw.this_is_my_alarm);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                miliseconds = (Integer.parseInt(minuteText.getText().toString())*60*1000 )+ (Integer.parseInt(secondText.getText().toString())*1000);
                Toast.makeText(MainActivity.this, "Timer Started : "+(miliseconds/1000), Toast.LENGTH_SHORT).show();
                new java.util.Timer().schedule(
                        new java.util.TimerTask() {
                            @Override
                            public void run() {
                                mp.start();
                            }
                        }, miliseconds);
                new java.util.Timer().schedule(
                        new java.util.TimerTask() {
                            @Override
                            public void run() {
                                mp.pause();
                            }
                        }, miliseconds + 30000);
            }
        });
    }
}