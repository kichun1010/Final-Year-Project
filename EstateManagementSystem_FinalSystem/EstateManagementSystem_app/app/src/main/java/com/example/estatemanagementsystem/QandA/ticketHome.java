package com.example.estatemanagementsystem.QandA;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.estatemanagementsystem.R;

public class ticketHome extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tickethome);
        Button ran = findViewById(R.id.randam);
        Button choose = findViewById(R.id.choose);
        SQLiteDatabase mDatabase = openOrCreateDatabase("tlog", Context.MODE_PRIVATE,null);
        String createTable = "CREATE TABLE IF NOT EXISTS tlog (id INTEGER PRIMARY KEY  AUTOINCREMENT,name VARCHAR(32), " + "email VARCHAR(500), " + "message VARCHAR(1000000), subject VARCHAR(900),tid VARCHAR(500))";
        mDatabase.execSQL(createTable);
        ran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ticketHome.this, createTicketActivity.class);
                startActivity(intent);
            }
        });
        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ticketHome.this, historyTicket.class);
                startActivity(intent);
            }
        });

    }
}

