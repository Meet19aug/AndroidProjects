package com.example.explicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class SecondActivity extends AppCompatActivity {

    int images[]={R.drawable.messenger, R.drawable.snapchat, R.drawable.twitter, R.drawable.music};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        int indexOfImage = Integer.parseInt(getIntent().getStringExtra("imageIndex"));

        imageView.setImageResource(images[indexOfImage]);


    }
}