package com.example.filesearching;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FilenameFilter;
import java.util.List;

public class FileListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_list);

        ListView fileListView = (ListView)findViewById(R.id.fileListView);
        TextView title = (TextView)findViewById(R.id.title);

        String path = getIntent().getStringExtra("path");
        path+="/Download";
        String filename = getIntent().getStringExtra("filename");

        File dir = new File(path);
        System.out.println("path is "+ path);
        File[] files = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File file, String s) {
                return new File(file,s).isFile();
            }
        });

//        for (int i = 0; i <files.length; i++) {
//            Log.d("Files","FileName: "+files[i].getName());
//        }
        Toast.makeText(getApplicationContext(),path,Toast.LENGTH_SHORT).show();
        if(files==null || files.length==0){
            final AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("No Files Found, Want to still use App?");
            builder.setCancelable(true);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }

            });
            builder.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    moveTaskToBack(true);
                    return;
                }

            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
        title.setVisibility(View.VISIBLE);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,files);
        fileListView.setAdapter(arrayAdapter);
        fileListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "Clicked Item: " + files[i], Toast.LENGTH_SHORT).show();
            }
        });

        //Popup menu



        fileListView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                return false;
            }
        });





    }
}