package com.example.imageswitcher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {

    private Button prevButton,nextButton;
    private ImageSwitcher imgSwtich;
    private int index=0;

    private final int[] imageNames=
            {       R.drawable.music,R.drawable.snapchat,R.drawable.whatsapp,R.drawable.twitter,R.drawable.messenger};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nextButton=(Button) findViewById(R.id.next);
        prevButton=(Button) findViewById(R.id.previous);
        imgSwtich=(ImageSwitcher) findViewById(R.id.imageSwitcher);

        imgSwtich.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imgVw= new ImageView(MainActivity.this);
                imgVw.setImageResource(imageNames[index]);
                return imgVw;
            }
        });
        imgSwtich.setInAnimation(this, android.R.anim.slide_in_left);
        imgSwtich.setOutAnimation(this, android.R.anim.slide_out_right);

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index>0)
                    index--;
                else if(index<=0)
                    index = imageNames.length-1;
                imgSwtich.setImageResource(imageNames[index]);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index<imageNames.length)
                    index = (index +1)%imageNames.length;
                if(index>=imageNames.length)
                    index =0;
                imgSwtich.setImageResource(imageNames[index]);
            }
        });

    }
}