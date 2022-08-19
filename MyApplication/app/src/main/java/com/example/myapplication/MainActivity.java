package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button addBtn = (Button) findViewById(R.id.buttonAdd);
        Button addSub = (Button) findViewById(R.id.buttonSub);
        Button addMul = (Button) findViewById(R.id.buttonMul);
        Button addDiv = (Button) findViewById(R.id.buttonDiv);
        Button addRes = (Button) findViewById(R.id.buttonRes);
        final EditText num1 = (EditText) findViewById(R.id.text1);
        final EditText num2 = (EditText) findViewById(R.id.text2);

        addBtn.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){

                        int a = Integer.parseInt(num1.getText().toString());
                        int b = Integer.parseInt(num2.getText().toString());
                        Toast.makeText(getApplicationContext(), String.valueOf(a+b) , Toast.LENGTH_SHORT).show();
                    }
                }
        );
        addSub.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){

                        int a = Integer.parseInt(num1.getText().toString());
                        int b = Integer.parseInt(num2.getText().toString());
                        Toast.makeText(getApplicationContext(), String.valueOf(a-b) , Toast.LENGTH_SHORT).show();
                    }
                }
        );
        addMul.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){

                        int a = Integer.parseInt(num1.getText().toString());
                        int b = Integer.parseInt(num2.getText().toString());
                        Toast.makeText(getApplicationContext(), String.valueOf(a*b) , Toast.LENGTH_SHORT).show();
                    }
                }
        );
        addDiv.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){

                        int a = Integer.parseInt(num1.getText().toString());
                        int b = Integer.parseInt(num2.getText().toString());
                        Toast.makeText(getApplicationContext(), String.valueOf(a/b) , Toast.LENGTH_SHORT).show();
                    }
                }
        );
        addRes.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        num1.setText("");
                        num2.setText("");
                        Toast.makeText(getApplicationContext(), String.valueOf("Reset Done") , Toast.LENGTH_SHORT).show();
                    }
                }
        );

    }
}