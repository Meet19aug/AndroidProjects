package com.example.textaddedtospinner;

import android.content.ContentValues;
import android.content.Context;
import android.database.ContentObservable;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DbManager extends SQLiteOpenHelper {

    private static final String dbName = "OptionsDB";
    private static final String tableName = "Options";
    public DbManager(Context context) {
        super(context, dbName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qry = "Create table " + tableName + " (id integer primary key autoincrement, option text)";
        db.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop Table if Exists " + tableName);
        onCreate(db);
    }

    public String addRecord(String t1){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("option",t1);

        long res = db.insert(tableName,null,cv);

        if(res==-1){
            return "Failed";
        }else{
            return "Successfully Inserted";
        }
    }
    public ArrayList<String> getOptions(){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM "+tableName ,null);
        ArrayList<String> arrOptions = new ArrayList<>();
        while(cursor.moveToNext()){
            arrOptions.add(cursor.getString(1));
        }
        return arrOptions;
    }
}
