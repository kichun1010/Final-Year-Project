package com.example.estatemanagementsystem.Notice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.estatemanagementsystem.R;

public class Notice extends AppCompatActivity {
    private Button button, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        button = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEN();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEN2();
            }
        });
    }

    public void openEN() {
        Intent intent = new Intent(this, Notice1.class);
        startActivity(intent);
    }
    public void openEN2() {
        Intent intent = new Intent(this, Notice2.class);
        startActivity(intent);
    }
}
