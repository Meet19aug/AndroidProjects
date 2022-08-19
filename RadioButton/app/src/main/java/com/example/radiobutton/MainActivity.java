package com.example.radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup radioButtonGroup = (RadioGroup) findViewById(R.id.radioGroup);
        Button submitButton = (Button) findViewById(R.id.submitButton);
        Button clearButton = (Button) findViewById(R.id.clearButton);
        RadioButton radioButtonIndian = (RadioButton) findViewById(R.id.radioButton);
        RadioButton radioButtonCanada = (RadioButton) findViewById(R.id.radioButton2);
        RadioButton radioButtonAustralia = (RadioButton) findViewById(R.id.radioButton3);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder str=new StringBuilder();
                str.append("Nationality is: ");
                int flag=0;
                if(radioButtonIndian.isChecked()){
                    flag=1;
                    str.append("Indian ");
                }
                if(radioButtonCanada.isChecked()){
                    flag=1;
                    str.append("Canadian ");
                }
                if(radioButtonAustralia.isChecked()){
                    flag=1;
                    str.append("Australian ");
                }
                if(flag==0){
                    str.delete(0,str.length());
                }else{
                    str.append("\n");
                }
                int selectedId = radioButtonGroup.getCheckedRadioButtonId();
                if(selectedId==-1){
                    Toast.makeText(getApplicationContext(), "Please Select something from Gender", Toast.LENGTH_SHORT).show();
                }else {
                    RadioButton selectedGender = (RadioButton) findViewById(selectedId);

                    str.append("Gender Selected: ").append(selectedGender.getText());
                    Toast.makeText(getApplicationContext(), str.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = radioButtonGroup.getCheckedRadioButtonId();
                if(selectedId!=-1){
                    RadioButton selectedGender = (RadioButton) findViewById(selectedId);
                    selectedGender.setChecked(false);
                }
                if(radioButtonIndian.isChecked()){
                    radioButtonIndian.setChecked(false);
                }
                if(radioButtonCanada.isChecked()){
                    radioButtonCanada.setChecked(false);
                }
                if(radioButtonAustralia.isChecked()){
                    radioButtonAustralia.setChecked(false);
                }
                Toast.makeText(getApplicationContext(), "Done : Reset Competed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}