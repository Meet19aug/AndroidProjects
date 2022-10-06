package com.example.sendingemail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText to,cc,bcc,subject,body;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText to = (EditText) findViewById(R.id.editText1);
        EditText cc = (EditText) findViewById(R.id.editText2);
        EditText bcc = (EditText) findViewById(R.id.editText3);
        EditText subject = (EditText) findViewById(R.id.editText4);
        EditText body = (EditText) findViewById(R.id.editText5);
        Button btn = (Button) findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] TO = {to.getText().toString()};
                String[] CC = {cc.getText().toString()};
                String[] BCC ={bcc.getText().toString()};
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto:"));
                intent.setType("text/html");
                intent.putExtra(Intent.EXTRA_EMAIL, TO);
                intent.putExtra(Intent.EXTRA_SUBJECT, subject.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT, body.getText().toString());
                intent.putExtra(Intent.EXTRA_CC, CC);
                intent.putExtra(Intent.EXTRA_BCC, BCC);
                startActivity(Intent.createChooser(intent, "Send Email"));
            }
        });


    }
}