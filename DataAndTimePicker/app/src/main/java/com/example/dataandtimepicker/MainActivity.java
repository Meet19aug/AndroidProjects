package com.example.dataandtimepicker;

import androidx.appcompat.app.AppCompatActivity;;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity<TextView> extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {
    int day, month, year, hour, minute;
    int myday, myMonth, myYear, myHour, myMinute;
    EditText editText1,editText2;
    Button button1,button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1= (EditText) findViewById(R.id.in_date);
        editText2= (EditText) findViewById(R.id.in_time);
        button1 = (Button) findViewById(R.id.btn_date);
        button2 = (Button) findViewById(R.id.btn_time);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, MainActivity.this,year, month,day);
                datePickerDialog.show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                hour = c.get(Calendar.HOUR);
                minute = c.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, MainActivity.this, hour, minute, DateFormat.is24HourFormat(MainActivity.this));
                timePickerDialog.show();
            }
        });

    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        myYear = year;
        myday = day;
        myMonth = month;

        editText1.setText("Year: " + myYear + "\n" +
                "Month: " + myMonth + "\n" +
                "Day: " + myday );
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        myHour = hour;
        myMinute = minute;
        editText2.setText("Hour: " + myHour + "\n" +
                "Minute: " + myMinute);
    }
}