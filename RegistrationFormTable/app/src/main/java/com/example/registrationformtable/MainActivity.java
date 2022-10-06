package com.example.registrationformtable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    EditText firstName, lastName,contactNumber,email,userName,password,confirmPassword;
    Button submit,clear;
    RadioGroup gender;
    RadioButton male,female;
    Spinner district,country;

    String[] districtName = {"Ahmedabad", "Bharuch", "Mahesana", "Gandhinagar", "Surat"};
    String[] countryName = {"Newzeland", "USA", "Canada","Austrailia","Japan"};
    int[] countryFlags = {R.drawable.newzelanf, R.drawable.usa, R.drawable.canada, R.drawable.austrailia, R.drawable.japan};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstName = (EditText) findViewById(R.id.firstName);
        lastName = (EditText) findViewById(R.id.lastName);
        contactNumber = (EditText) findViewById(R.id.contactNumber);
        email = (EditText) findViewById(R.id.email);
        userName = (EditText) findViewById(R.id.userName);
        password = (EditText) findViewById(R.id.password);
        confirmPassword = (EditText) findViewById(R.id.confirmPassword);

        clear = (Button)findViewById(R.id.clear);
        submit = (Button)findViewById(R.id.submit);

        gender = (RadioGroup) findViewById(R.id.radioGroup);
        male = (RadioButton) findViewById(R.id.male);
        female = (RadioButton) findViewById(R.id.female);

        district = (Spinner) findViewById(R.id.spinnerDistrict);
        country = (Spinner) findViewById(R.id.spinnerCountry);

        ArrayAdapter countriesArrayAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,countryName);
        countriesArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        country.setAdapter(countriesArrayAdapter);

        ArrayAdapter districtsArrayAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,districtName);
        districtsArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        district.setAdapter(districtsArrayAdapter);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstName.setText("");
                lastName.setText("");
                contactNumber.setText("");
                email.setText("");
                userName.setText("");
                password.setText("");
                confirmPassword.setText("");
                gender.clearCheck();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),SecondActivity.class);
                String fn = firstName.getText().toString();
                String ln = lastName.getText().toString();
                String cn = contactNumber.getText().toString();
                String em = email.getText().toString();
                String un = userName.getText().toString();
                boolean ma = male.isChecked();
                intent.putExtra("gn",ma==true?"Male":"Female");
                String di = district.getSelectedItem().toString();
                String co = country.getSelectedItem().toString();
                intent.putExtra("fn",fn);
                intent.putExtra("ln",ln);
                intent.putExtra("cn",cn);
                intent.putExtra("em",em);
                intent.putExtra("un",un);
                intent.putExtra("ma",ma);
                intent.putExtra("di",di);
                intent.putExtra("co",co);
                startActivity(intent);
            }
        });
    }
}