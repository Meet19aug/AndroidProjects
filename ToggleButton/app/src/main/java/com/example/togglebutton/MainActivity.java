package com.example.togglebutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ToggleButton tgButton = (ToggleButton) findViewById(R.id.toggleButton);

        tgButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // do something, the isChecked will be
                // true if the switch is in the On position
                StringBuilder str = new StringBuilder();
                str.append("Toggle Button: ").append(isChecked);
                Toast.makeText(getApplicationContext(), str.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}