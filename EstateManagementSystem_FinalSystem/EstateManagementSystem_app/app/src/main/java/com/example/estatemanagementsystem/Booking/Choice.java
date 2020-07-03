package com.example.estatemanagementsystem.Booking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.estatemanagementsystem.R;

public class Choice extends AppCompatActivity {
    private static final int REQUEST_CODE = 3434;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_booking);
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            username = extras.getString("username");
        }
    }

    public void book(View view){
        Intent i = new Intent(this, Gym.class);
        i.putExtra("username",username);
        startActivityForResult(i, REQUEST_CODE);
    }

    public void book2(View view){
        Intent i = new Intent(this, YoGa.class);
        i.putExtra("username",username);
        startActivityForResult(i, REQUEST_CODE);
    }

    public void book3(View view){
        Intent i = new Intent(this, Badminton.class);
        i.putExtra("username",username);
        startActivityForResult(i, REQUEST_CODE);
    }

    public void book4(View view){
        Intent i = new Intent(this, Tennis.class);
        i.putExtra("username",username);
        startActivityForResult(i, REQUEST_CODE);
    }

    public void book5(View view){
        Intent i = new Intent(this, BBQ.class);
        i.putExtra("username",username);
        startActivityForResult(i, REQUEST_CODE);
    }

    public void book6(View view){
        Intent i = new Intent(this, Jacuzzi.class);
        i.putExtra("username",username);
        startActivityForResult(i, REQUEST_CODE);
    }
}
