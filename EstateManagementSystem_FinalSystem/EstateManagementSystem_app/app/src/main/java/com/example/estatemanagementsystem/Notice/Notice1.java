package com.example.estatemanagementsystem.Notice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.estatemanagementsystem.R;

public class Notice1 extends AppCompatActivity {

    ListView listView;

    String [] listviewitems = new String[]{
            "ST302/NTT/255/15/NK - Suspension of Lift Service","ST302/NTT/203/15/NK - Suspension of Water Supply","ST302/NTT/196/15/NK - Suspension of Water Supply","ST302/NTT/193/15/NK - Suspension of Water Supply",
            "ST302/NTT/187/15/NK - Suspension of Lift Service","ST302/NTT/184/15/NK - Suspension of Water Supply","ST302/NTT/165/15/NK - Suspension of Lift Service"
    };

    String [] numbers = new String[]{
            "0","1","2","3","4","5","6"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice1);

        listView = (ListView) findViewById(R.id.listView);

        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_2, android.R.id.text1,listviewitems);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String TemplistView = numbers[position];
                Intent intent = new Intent(Notice1.this,Notice1_1.class);
                intent.putExtra("List",TemplistView);
                 startActivity(intent);
            }
        });
    }
}
