package com.example.bitmap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        // To integrate the menu layout's data using inflater.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.line)
            drawLine();
        else if(item.getItemId()==R.id.rectangle)
            drawRectangle();
        else if(item.getItemId()==R.id.circle)
            drawCircle();
        else if(item.getItemId()==R.id.triangle)
            drawTriangle();
        else if(item.getItemId()==R.id.square)
            drawSquare();
        return super.onOptionsItemSelected(item);

    }

    private void drawSquare() {
        DrawSquare obj = new DrawSquare(this);
        setContentView(obj);
    }

    private void drawLine()
    {
        DrawLine obj=new DrawLine(this);
        setContentView(obj);
    }

    private void drawRectangle()
    {
        DrawRectangle obj=new DrawRectangle(this);
        setContentView(obj);
    }

    private void drawCircle()
    {
        DrawCircle obj=new DrawCircle(this);
        setContentView(obj);
    }
    private void drawTriangle()
    {
        DrawTriangle obj=new DrawTriangle(this);
        setContentView(obj);
    }



}