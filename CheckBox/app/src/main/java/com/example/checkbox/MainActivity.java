package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static void replaceAll(StringBuilder builder, String from, String to) {
        int index = builder.indexOf(from);
        while (index != -1) {
            builder.replace(index, index + from.length(), to);
            index += to.length(); // Move to the end of the replacement
            index = builder.indexOf(from, index);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        CheckBox checkBox4 = (CheckBox) findViewById(R.id.checkBox4);

        StringBuilder str = new StringBuilder();


        checkBox1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //is chkIos checked?
                if (((CheckBox) v).isChecked()) {
                    //Case 1
                    str.append(checkBox1.getText()).append(" ");
                    Toast.makeText(getApplicationContext(),str.toString(),Toast.LENGTH_SHORT).show();
                }
                else{
                    replaceAll(str,checkBox1.getText().toString(),"");
                    Toast.makeText(getApplicationContext(),str.toString(),Toast.LENGTH_SHORT).show();
                }
                //case 2
            }
        });

        checkBox2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //is chkIos checked?
                if (((CheckBox) v).isChecked()) {
                    //Case 1
                    str.append(checkBox2.getText()).append(" ");
                    Toast.makeText(getApplicationContext(),str.toString(),Toast.LENGTH_SHORT).show();
                }
                else{
                    replaceAll(str,checkBox2.getText().toString(),"");
                    Toast.makeText(getApplicationContext(),str.toString(),Toast.LENGTH_SHORT).show();
                }
                //case 2
            }
        });

        checkBox3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //is chkIos checked?
                if (((CheckBox) v).isChecked()) {
                    //Case 1
                    str.append(checkBox3.getText()).append(" ");
                    Toast.makeText(getApplicationContext(),str.toString(),Toast.LENGTH_SHORT).show();
                }
                else{
                    replaceAll(str,checkBox3.getText().toString(),"");
                    Toast.makeText(getApplicationContext(),str.toString(),Toast.LENGTH_SHORT).show();
                }
                //case 2
            }
        });

        checkBox4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //is chkIos checked?
                if (((CheckBox) v).isChecked()) {
                    //Case 1
                    str.append(checkBox4.getText()).append(" ");
                    Toast.makeText(getApplicationContext(),str.toString(),Toast.LENGTH_SHORT).show();
                }
                else{
                    replaceAll(str,checkBox4.getText().toString(),"");
                    Toast.makeText(getApplicationContext(),str.toString(),Toast.LENGTH_SHORT).show();
                }
                //case 2
            }
        });
    }
}