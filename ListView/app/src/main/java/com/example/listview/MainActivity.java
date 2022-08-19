package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String []arr={"Captain America: The First Avenger","Captain Marvel (2019)", "Iron Man (2008)","Iron Man 2 (2010)","The Incredible Hulk (2008)","Thor (2011)","The Avengers (2012)","Thor: The Dark World (2013)","Guardians of the Galaxy (2014)","Guardians of the Galaxy Vol. 2 (2017)","Iron Man 3 (2013)","Captain America: The Winter Soldier (2014)","Avengers: Age of Ultron (2015)"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arr);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Clicked Movie: " + arr[i], Toast.LENGTH_SHORT).show();
            }
        });


    }
}