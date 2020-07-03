package com.example.estatemanagementsystem.Notice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.estatemanagementsystem.R;

public class Notice2 extends AppCompatActivity {

    ListView listView;

    String [] listviewitems = new String[]{
            "ST302/NTT/193/15/GW - Updating Emergency Contact Inforamation","ST302/130/15/NK - Shuttle Bus Services","ST302/NTT/171/15/NK - Cleansing Serive Of Car Parks",
            "ST302/131/15/NK - Temporarily Closed of Recreation Room","ST302/110/14/NK - Shuttle Bus Services","ST302/NTT/108/09/NK - Cleansing Serive Of Car Parks","ST302/106/17/NK - Temporarily Closed of Recreation Room"
    };

    String [] numbers = new String[]{
            "0","1","2","3","4","5","6"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice2);

        listView = (ListView) findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_2, android.R.id.text1,listviewitems);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String TemplistView = numbers[position];
                Intent intent = new Intent(Notice2.this,Notice2_1.class);
                intent.putExtra("List",TemplistView);
                startActivity(intent);
            }
        });
    }
}
