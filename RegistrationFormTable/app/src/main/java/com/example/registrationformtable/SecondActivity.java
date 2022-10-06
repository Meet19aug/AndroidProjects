package com.example.registrationformtable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String firstName = getIntent().getStringExtra("fn");
        String lastName = getIntent().getStringExtra("ln");
        String contactNumber = getIntent().getStringExtra("cn");
        String email =getIntent().getStringExtra("em");
        String userName = getIntent().getStringExtra("un");
        String countryName = getIntent().getStringExtra("co");
        String districtName = getIntent().getStringExtra("di");
        String gender = getIntent().getStringExtra("gn");

        TextView nameTextBox = (TextView) findViewById(R.id.textView1b);
        nameTextBox.setText(firstName+ " " +lastName);
        TextView contactNumberTextBox = (TextView) findViewById(R.id.textView2b);
        contactNumberTextBox.setText(contactNumber);
        TextView emailTextBox = (TextView) findViewById(R.id.textView3b);
        emailTextBox.setText(email);
        TextView genderTextBox = (TextView) findViewById(R.id.textView4b);
        genderTextBox.setText(gender);
        TextView districtTextBox = (TextView) findViewById(R.id.textView5b);
        districtTextBox.setText(districtName);
        TextView countryTextBox = (TextView) findViewById(R.id.textView6b);
        countryTextBox.setText(countryName);
        TextView usernameTextBox = (TextView) findViewById(R.id.textView7b);
        usernameTextBox.setText(userName);






    }
}