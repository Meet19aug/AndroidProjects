package com.example.layoutinflate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View v = getLayoutInflater().inflate(R.layout.sublayout,null);
        FrameLayout f =(FrameLayout) findViewById(R.id.my_frame_layout);
        f.addView(v);
    }
}