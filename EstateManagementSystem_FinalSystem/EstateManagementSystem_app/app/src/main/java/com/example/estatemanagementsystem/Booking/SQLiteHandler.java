package com.example.estatemanagementsystem.Booking;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME = "FYP";
    private static final String TABLE_NAME="booking";
    private static final String KEY_ID="id",KEY_NAME="userName",KEY_ADDRESS="address",KEY_EMAIL="userEmail",KEY_PHONE="userPhone",KEY_TIME="time",KEY_DATE="date";

    public SQLiteHandler(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_LOGIN_TABLE="CREATE TABLE "+TABLE_NAME+"("
                +KEY_ID+"INTEGER PRIMARY KEY,"+KEY_NAME+"TEXT,"
                +KEY_PHONE+" TEXT,"+KEY_EMAIL+" TEXT,"+KEY_ADDRESS+" TEXT,"+KEY_DATE
                +" TEXT,"+KEY_TIME+" TEXT"+")";
        db.execSQL(CREATE_LOGIN_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public void booking(String name,String phone,String email,String address,String date,String time){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME,name);
        values.put(KEY_PHONE,phone);
        values.put(KEY_EMAIL,email);
        values.put(KEY_ADDRESS,address);
        values.put(KEY_DATE,date);
        values.put(KEY_TIME,time);

        db.insert(TABLE_NAME,null,values);
        db.close();

    }
}
