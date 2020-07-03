package com.example.estatemanagementsystem.Booking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.estatemanagementsystem.R;

public class Booking extends AppCompatActivity {
    private static final int REQUEST_CODE = 3434;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookingmain);
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            username = extras.getString("username");
        }
    }

    public void book(View view){
        Intent i = new Intent(this, Choice.class);
        i.putExtra("username",username);
        startActivityForResult(i, REQUEST_CODE);
    }

    public void record(View view){
        Intent i = new Intent(this, BookingRecord.class);
        i.putExtra("username",username);
        startActivityForResult(i, REQUEST_CODE);
    }

//    public void test(View view){
//        Intent i = new Intent(this, Testing.class);
//        startActivityForResult(i, REQUEST_CODE);
//        this.finish();
//    }
}
