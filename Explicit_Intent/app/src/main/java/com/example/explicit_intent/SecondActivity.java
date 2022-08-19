package com.example.explicit_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    ImageView img=(ImageView) findViewById(R.id.imageView);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        try {
            Bundle bundle = getIntent().getExtras();
        if(bundle!=null)
        {
            String imgIndex=bundle.getString("imageIndex");
            setImage(imgIndex);
        }
        }
        catch(Exception e){
            Toast.makeText(getApplicationContext(),"Exception occured",Toast.LENGTH_SHORT).show();
        }

    }

    private void setImage(String index)
    {
        switch (index){
            case "1":
                img.setImageResource(R.drawable.messenger);
                break;
            case "2":
                img.setImageResource(R.drawable.music);
                break;
            case "3":
                img.setImageResource(R.drawable.snapchat);
                break;
            case "4":
                img.setImageResource(R.drawable.twitter);
                break;
            default:
                img.setImageResource(R.drawable.messenger);
                break;
        }
    }
}