package com.example.impliciteintentprogressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int progressStatus = 0;
    private Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button submitBtn = (Button)findViewById(R.id.buttonSubmit);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        EditText editTextUrl = (EditText) findViewById(R.id.editTextUrl);
        TextView textView = (TextView)findViewById(R.id.textView);
        progressBar.setMax(200);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start long running operation in a background thread
                if(editTextUrl!=null && editTextUrl.length()>0){
                    new Thread(new Runnable() {
                        public void run() {
                            while (progressStatus < 200) {
                                progressStatus += 5;
                                // Update the progress bar and display the
                                //current value in the text view
                                handler.post(new Runnable() {
                                    public void run() {
                                        progressBar.setProgress(progressStatus);
                                        textView.setText(progressStatus+"/"+progressBar.getMax());
                                    }
                                });
                                try {
                                    // Sleep for 200 milliseconds.
                                    Thread.sleep(200);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            String url=editTextUrl.getText().toString();
                            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                            startActivity(intent);
                        }
                    }
                    ).start();
                }else{
                    Toast.makeText(getApplicationContext(),"Enter URL First.",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}