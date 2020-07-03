package com.example.estatemanagementsystem.QandA;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.estatemanagementsystem.R;

import java.util.ArrayList;

public class historyTicket extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticketlog);
        ListView ll = findViewById(R.id.list);
        SQLiteDatabase mDatabase = openOrCreateDatabase("tlog", Context.MODE_PRIVATE,null);
        ArrayList<String> results = new ArrayList<String>();
        String sql = "select * from tlog";
        Cursor cursor = mDatabase.rawQuery(sql,null);
        if (cursor != null ) {
            if  (cursor.moveToFirst()) {
                do
                    {String tid = cursor.getString(cursor.getColumnIndex("tid"));
                    String name = cursor.getString(cursor.getColumnIndex("name"));
                    String email = cursor.getString(cursor.getColumnIndex("email"));
                    String subject = cursor.getString(cursor.getColumnIndex("subject"));
                    String message = cursor.getString(cursor.getColumnIndex("message"));
                    results.add("TicketID: "+tid+" \r\n name:" + name + ",\r\n email: " + email+" \r\n subject:"+subject+"\r\n message: " + message);
                    ll.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,results));
                }while (cursor.moveToNext());
            }
        }
    }}

