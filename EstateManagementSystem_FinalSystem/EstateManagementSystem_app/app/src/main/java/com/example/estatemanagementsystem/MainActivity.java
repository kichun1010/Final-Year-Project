package com.example.estatemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.estatemanagementsystem.Booking.Booking;
import com.example.estatemanagementsystem.CCTV.CCTVActivity;
import com.example.estatemanagementsystem.Notice.Notice;
import com.example.estatemanagementsystem.Bus.TimeTable;
import com.example.estatemanagementsystem.QandA.ticketHome;
import com.example.estatemanagementsystem.ui.FaceActivity;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 3434;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            username = extras.getString("username");
        }
    }

    public void book(View view){
        Intent i = new Intent(this, Booking.class);
        i.putExtra("username",username);
        startActivityForResult(i, REQUEST_CODE);
    }

    public void live(View view){
        Intent i = new Intent(this, FaceActivity.class);
        i.putExtra("username",username);
        startActivityForResult(i, REQUEST_CODE);
    }

    public void question(View view){
        Intent i = new Intent(this, ticketHome.class);
        i.putExtra("username",username);
        startActivityForResult(i, REQUEST_CODE);
    }

    public void notice(View view){
        Intent i = new Intent(this, Notice.class);
        i.putExtra("username",username);
        startActivityForResult(i, REQUEST_CODE);
    }

    public void bus(View view){
        Intent i = new Intent(this, TimeTable.class);
        i.putExtra("username",username);
        startActivityForResult(i, REQUEST_CODE);
    }

    public void cctv(View view){
        Intent i = new Intent(this, CCTVActivity.class);
        startActivity(i);

    }
}
