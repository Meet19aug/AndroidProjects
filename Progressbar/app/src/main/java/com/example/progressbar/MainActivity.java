package com.example.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static int findSum(int[] progress) {
        int sum=0;
        for (int i = 0; i < progress.length; i++) {
            sum+=progress[i];
        }
        return sum;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText1 = (EditText) findViewById(R.id.editText1);
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        EditText editText3 = (EditText) findViewById(R.id.editText3);
        EditText editText4 = (EditText) findViewById(R.id.editText4);
        EditText editText5 = (EditText) findViewById(R.id.editText5);
        EditText editText6 = (EditText) findViewById(R.id.editText6);
        EditText editText7 = (EditText) findViewById(R.id.editText7);
        EditText editText8 = (EditText) findViewById(R.id.editText8);
        ProgressBar progressBar = (ProgressBar)findViewById(R.id.progressBar);
        progressBar.setMax(80);
        final int[] progress = {0,0,0,0,0,0,0,0};
        final int[] sum = {0};

        editText1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b) {
                    if (editText1.getText().toString().matches("")) {
                        if(progress[0]==10) {
                            progress[0] = 0;
                        }
                    } else {
                        if(progress[0]==0) {
                            progress[0] = 10;
                        }
                    }
                }
                int sum = findSum(progress);
                progressBar.setProgress(sum);
                Toast.makeText(getApplicationContext(), "Progress = "+((sum*10)/8.0) + "%", Toast.LENGTH_SHORT).show();            }
        });
        editText2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b) {
                    if (editText2.getText().toString().matches("")) {
                        if(progress[1]==10) {
                            progress[1] = 0;
                        }
                    } else {
                        if(progress[1]==0) {
                            progress[1] = 10;
                        }
                    }
                }
                int sum = findSum(progress);
                progressBar.setProgress(sum);
                Toast.makeText(getApplicationContext(), "Progress = "+((sum*10)/8.0) + "%", Toast.LENGTH_SHORT).show();            }
        });
        editText3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b) {
                    if (editText3.getText().toString().matches("")) {
                        if(progress[2]==10) {
                            progress[2] = 0;
                        }
                    } else {
                        if(progress[2]==0) {
                            progress[2] = 10;
                        }
                    }
                }
                int sum = findSum(progress);
                progressBar.setProgress(sum);
                Toast.makeText(getApplicationContext(), "Progress = "+((sum*10)/8.0) + "%", Toast.LENGTH_SHORT).show();            }
        });

        editText4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b) {
                    if (editText4.getText().toString().matches("")) {
                        if(progress[3]==10) {
                            progress[3] = 0;
                        }
                    } else {
                        if(progress[3]==0) {
                            progress[3] = 10;
                        }
                    }
                }
                int sum = findSum(progress);
                progressBar.setProgress(sum);
                Toast.makeText(getApplicationContext(), "sum = "+sum, Toast.LENGTH_SHORT).show();

            }
        });
        editText5.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b) {
                    if (editText5.getText().toString().matches("")) {
                        if(progress[4]==10) {
                            progress[4] = 0;
                        }
                    } else {
                        if(progress[4]==0) {
                            progress[4] = 10;
                        }
                    }
                }
                int sum = findSum(progress);
                progressBar.setProgress(sum);
                Toast.makeText(getApplicationContext(), "Progress = "+((sum*10)/8.0) + "%", Toast.LENGTH_SHORT).show();            }
        });
        editText6.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b) {
                    if (editText6.getText().toString().matches("")) {
                        if(progress[5]==10) {
                            progress[5] = 0;
                        }
                    } else {
                        if(progress[5]==0) {
                            progress[5] = 10;
                        }
                    }
                }
                int sum = findSum(progress);
                progressBar.setProgress(sum);
                Toast.makeText(getApplicationContext(), "Progress = "+((sum*10)/8.0) + "%", Toast.LENGTH_SHORT).show();            }
        });
        editText7.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b) {
                    if (editText7.getText().toString().matches("")) {
                        if(progress[6]==10) {
                            progress[6] = 0;
                        }
                    } else {
                        if(progress[6]==0) {
                            progress[6] = 10;
                        }
                    }
                }
                int sum = findSum(progress);
                progressBar.setProgress(sum);
                Toast.makeText(getApplicationContext(), "Progress = "+((sum*10)/8.0) + "%", Toast.LENGTH_SHORT).show();            }
        });
        editText8.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b) {
                    if (editText8.getText().toString().matches("")) {
                        if(progress[7]==10) {
                            progress[7] = 0;
                        }
                    } else {
                        if(progress[7]==0) {
                            progress[7] = 10;
                        }
                    }
                }
                int sum = findSum(progress);
                progressBar.setProgress(sum);
                Toast.makeText(getApplicationContext(), "Progress = "+((sum*10)/8.0) + "%", Toast.LENGTH_SHORT).show();            }
        });

    }

}