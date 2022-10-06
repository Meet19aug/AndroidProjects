package com.example.sharedpreferencestwonumberwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText number1,number2,operator,showWindow;
    Button show,calc;
    public static final String MyPREFERENCES = "MyPrefs", Number1 = "Number1",Number2 = "Number2",Number3="Number3",OperatorSign = "Operatorsine";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = (EditText) findViewById(R.id.editText1);
        number2 = (EditText) findViewById(R.id.editText2);
        operator = (EditText)findViewById(R.id.editText3);
        show = (Button)findViewById(R.id.button);
        calc = (Button)findViewById(R.id.button2);
        showWindow = (EditText) findViewById(R.id.editText4);

        SharedPreferences sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);


        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedpreferences.edit();

                int num1 = Integer.parseInt(number1.getText().toString());
                int num2 = Integer.parseInt(number2.getText().toString());
                int total;
                String op = operator.getText().toString();
                switch(op){
                    case "+":
                       total = num1+num2;
                       break;
                    case "-":
                        total = num1-num2;
                        break;
                    case "*":
                        total = num1*num2;
                        break;
                    case "/":
                        total = num1/num2;
                        break;
                    default:
                        total = 0;
                }
                editor.putString(Number1, number1.getText().toString());
                editor.putString(Number2, number2.getText().toString());
                editor.putString(Number3,String.valueOf(total));
                editor.putString(OperatorSign, operator.getText().toString());
                editor.commit();
                number1.setText(String.valueOf(total));
                Toast.makeText(MainActivity.this,"Thanks",Toast.LENGTH_LONG).show();
            }
        });


        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder str= new StringBuilder();
                str.append(sharedpreferences.getString(Number1,"") + sharedpreferences.getString(OperatorSign,"")  +sharedpreferences.getString(Number2,"")+ " = " + sharedpreferences.getString(Number3,"") + "\n");
                 showWindow.setText( str.toString());
            }
        });
    }
}