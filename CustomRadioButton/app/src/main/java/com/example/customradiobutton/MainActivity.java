package com.example.customradiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup radioButtonGroup = (RadioGroup) findViewById(R.id.genderRadioGroup);
        Button maleButton = (Button) findViewById(R.id.male);
        Button femaleButton = (Button) findViewById(R.id.female);

        maleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Male Selected",Toast.LENGTH_SHORT).show();
            }
        });
        femaleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Female Selected",Toast.LENGTH_SHORT).show();
            }
        });
    }
}