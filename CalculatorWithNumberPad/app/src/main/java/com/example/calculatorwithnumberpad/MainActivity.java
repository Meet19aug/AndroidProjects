package com.example.calculatorwithnumberpad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    float temp1,temp2;
    float temp3;
    char opr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn0 = (Button) findViewById(R.id.button0);
        Button btn1 = (Button) findViewById(R.id.button1);
        Button btn2 = (Button) findViewById(R.id.button2);
        Button btn3 = (Button) findViewById(R.id.button3);
        Button btn4 = (Button) findViewById(R.id.button4);
        Button btn5 = (Button) findViewById(R.id.button5);
        Button btn6 = (Button) findViewById(R.id.button6);
        Button btn7 = (Button) findViewById(R.id.button7);
        Button btn8 = (Button) findViewById(R.id.button8);
        Button btn9 = (Button) findViewById(R.id.button9);
        Button btnPlus = (Button) findViewById(R.id.buttonPlus);
        Button btnMinus = (Button) findViewById(R.id.buttonMinus);
        Button btnMulti = (Button) findViewById(R.id.buttonMulti);
        Button btnDivide = (Button) findViewById(R.id.buttonDivide);
        Button btnEqual = (Button) findViewById(R.id.buttonEqual);
        Button btnDot = (Button) findViewById(R.id.buttonDot);
        Button btnClear = (Button) findViewById(R.id.buttonClear);
        EditText editText = (EditText) findViewById(R.id.editText);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = editText.getText().toString();
                str+="0";
                editText.setText(str);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = editText.getText().toString();
                str+="1";
                editText.setText(str);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = editText.getText().toString();
                str+="2";
                editText.setText(str);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = editText.getText().toString();
                str+="3";
                editText.setText(str);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = editText.getText().toString();
                str+="4";
                editText.setText(str);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = editText.getText().toString();
                str+="5";
                editText.setText(str);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = editText.getText().toString();
                str+="6";
                editText.setText(str);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = editText.getText().toString();
                str+="7";
                editText.setText(str);
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = editText.getText().toString();
                str+="8";
                editText.setText(str);
            }
        });
        btn9.setOnClickListener(view -> {
            String str = editText.getText().toString();
            str+="9";
            editText.setText(str);
        });
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = editText.getText().toString();
                str+=".";
                editText.setText(str);
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText("");
            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opr='+';
                temp1=Float.parseFloat(editText.getText().toString());
                editText.setText("");
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opr='-';
                temp1=Float.parseFloat(editText.getText().toString());
                editText.setText("");
            }
        });
        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opr='*';
                temp1=Float.parseFloat(editText.getText().toString());
                editText.setText("");
            }
        });
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opr='/';
                temp1=Float.parseFloat(editText.getText().toString());
                editText.setText("");
            }
        });
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp2=Float.parseFloat(editText.getText().toString());
                switch(opr){
                    case '+':
                        temp3=temp1+temp2;
                        break;
                    case '-':
                        temp3=temp1-temp2;
                        break;
                    case '*':
                        temp3=temp1*temp2;
                        break;
                    case '/':
                        temp3=temp1/temp2;
                        break;

                }
                editText.setText(Float.toString(temp3));
            }
        });



    }

}