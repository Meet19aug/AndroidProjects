package com.example.ratingbar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = (EditText)findViewById(R.id.editTextNumberDecimal);
        RatingBar rateBar = (RatingBar)  findViewById(R.id.ratingBar);
        Button btn = (Button)findViewById(R.id.button);
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);


        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
                String num = editText.getText().toString();
                rateBar.setRating(Float.parseFloat(num));
            }
        });

        rateBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                editText.setText(String.valueOf(v));
            }
        });
    }
}