package com.example.estatemanagementsystem.Bus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.estatemanagementsystem.R;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class Bus extends AppCompatActivity {

    SimpleDateFormat format1 = new SimpleDateFormat("HH:mm");


    String [] busStop1 = new String[]{
            "07:00","07:30","08:00","08:30","09:00","10:00","11:00","12:00","13:00"
    };

    String [] busStop2 = new String[]{
            "07:30","08:00","08:30","09:00","09:30","10:30","11:30","12:30","13:30"
    };

    String [] busStop3 = new String[]{
            "07:42","08:12","08:42","09:12","09:42","10:42","11:42","12:42","13:42"
    };

    String [] busStop4 = new String[]{
            "07:50","08:20","08:50","09:20","09:50","10:50","11:50","12:50","13:50"
    };

    String [] busStop5 = new String[]{
            "08:00","08:30","09:00","09:30","10:00","11:00","12:00","13:00","14:00"
    };

    Spinner spinner;
    TextView tempbusstop;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);

        spinner = findViewById(R.id.spinner);
        tempbusstop = findViewById(R.id.tempbusstop);
        button = findViewById(R.id.button);
        //temp = findViewById(R.id.temp);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.BusStop, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView adapterView, View selectedItemView, int position, long id) {
                // your code here
                Date currentTime = Calendar.getInstance().getTime();
                String current = format1.format(currentTime);
                String currentT [] = current.split(":");
                int current1 = Integer.parseInt(currentT[0]);
                int tempcurrent = 0;
                tempcurrent = tempcurrent + current1 * 60;
                int current2 = Integer.parseInt(currentT[1]);
                tempcurrent = tempcurrent + current2;

                //temp.setText(String.valueOf(tempcurrent));

                switch (position) {
                    case 0:
                            for(int i=0;i<busStop1.length;i++) {
                                String time123 [] = busStop1[i].split(":");
                                int time1 = Integer.parseInt(time123[0]);
                                int temptime = 0;
                                temptime = temptime + time1 * 60;
                                int time2 = Integer.parseInt(time123[1]);
                                temptime = temptime + time2;
                                if (tempcurrent < temptime) {
                                    tempbusstop.setText(busStop1[i]);
                                    break;
                                }
                                tempbusstop.setText(busStop1[0]);
                            }
                        break;
                    case 1:
                            for(int i=0;i<busStop2.length;i++) {
                                String time123[] = busStop2[i].split(":");
                                int time1 = Integer.parseInt(time123[0]);
                                int temptime = 0;
                                temptime = temptime + time1 * 60;
                                int time2 = Integer.parseInt(time123[1]);
                                temptime = temptime + time2;
                                if (tempcurrent < temptime) {
                                    tempbusstop.setText(busStop2[i]);
                                    break;
                                }
                                tempbusstop.setText(busStop2[0]);
                            }
                        break;
                    case 2:
                            for(int i=0;i<busStop3.length;i++) {
                                String time123[] = busStop3[i].split(":");
                                int time1 = Integer.parseInt(time123[0]);
                                int temptime = 0;
                                temptime = temptime + time1 * 60;
                                int time2 = Integer.parseInt(time123[1]);
                                temptime = temptime + time2;
                                if (tempcurrent < temptime) {
                                    tempbusstop.setText(busStop3[i]);
                                    break;
                                }
                                tempbusstop.setText(busStop3[0]);
                            }
                        break;
                    case 3:
                            for(int i=0;i<busStop4.length;i++) {
                                String time123[] = busStop4[i].split(":");
                                int time1 = Integer.parseInt(time123[0]);
                                int temptime = 0;
                                temptime = temptime + time1 * 60;
                                int time2 = Integer.parseInt(time123[1]);
                                temptime = temptime + time2;
                                if (tempcurrent < temptime) {
                                    tempbusstop.setText(busStop4[i]);
                                    break;
                                }
                                tempbusstop.setText(busStop4[0]);
                            }
                        break;
                    case 4:
                            for(int i=0;i<busStop5.length;i++) {
                                String time123[] = busStop5[i].split(":");
                                int time1 = Integer.parseInt(time123[0]);
                                int temptime = 0;
                                temptime = temptime + time1 * 60;
                                int time2 = Integer.parseInt(time123[1]);
                                temptime = temptime + time2;
                                if (tempcurrent < temptime) {
                                    tempbusstop.setText(busStop5[i]);
                                    break;
                                }
                                tempbusstop.setText(busStop5[0]);
                            }
                        break;
                }


            }
                public void onNothingSelected (AdapterView adapterView){
                    // your code here
                }


        });

//        SimpleDateFormat format1 = new SimpleDateFormat("HH:mm");
//        String currentDateandTime = format1.format(new Date());
//        currenttime.setText(currentDateandTime);
//
//        tempbusstop.setText(tempBusStop);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Bus.this,BusTimeTable.class);
                startActivity(intent);
            }
        });




    }


}
