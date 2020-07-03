package com.example.estatemanagementsystem.QandA;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.estatemanagementsystem.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class createTicketActivity extends AppCompatActivity {
    EditText name, email, subject, message;
    String connect = "https://estatemanagement.design/api/index.php/v1/tickets";
    Button send;
    JSONObject data = new JSONObject();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createticket);
        final Spinner dropdown = findViewById(R.id.spinner1);
        send=findViewById(R.id.aaa);
        String[] items = new String[]{"Ask", "Complain", "Other"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = findViewById(R.id.editText4);
                email = findViewById(R.id.editText2);
                subject = findViewById(R.id.editText3);
                message = findViewById(R.id.edit_text);
                if (TextUtils.isEmpty(name.getText())) {
                    name.setError("Please enter the flied");
                }
                if (TextUtils.isEmpty(message.getText())) {
                    message.setError("Please enter the flied");
                }
                if (TextUtils.isEmpty(subject.getText())) {
                    subject.setError("Please enter the flied");
                }
                if (TextUtils.isEmpty(email.getText())) {
                    email.setError("Please enter the flied");

                }

                try {
                    data.put("name", name.getText().toString());
                    data.put("email", email.getText().toString());
                    data.put("subject", subject.getText().toString());
                    data.put("message", message.getText().toString());
                    data.put("html", false);
                    data.put("category",dropdown.getSelectedItemPosition()+1);
                    data.put("language", "English");


                } catch (JSONException e) {

                }
                String tid = "";
                final String[] response = {""};
                Thread a = new Thread(new Runnable(){
                    @Override
                    public void run() {
                        Post example = new Post();
                        try {
                    response[0] = example.post(connect, data.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                    }
                });
                a.start();
                try {
                    a.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(!response[0].isEmpty()){
                try {
                        JSONObject jsonObject = new JSONObject(response[0]);
                        tid = jsonObject.getString("trackingId");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    log(name.getText().toString(),email.getText().toString(),message.getText().toString(),subject.getText().toString(),tid);
                    showDialog("done");
            }
            else {
    showerrorDialog("please check your input!");

}
            }
        });



    }
private void log(String name,String email, String message,String subject,String tid){
    SQLiteDatabase mDatabase = openOrCreateDatabase("tlog", Context.MODE_PRIVATE,null);
    String createTable = "CREATE TABLE IF NOT EXISTS tlog (id INTEGER PRIMARY KEY  AUTOINCREMENT,name VARCHAR(32), " + "email VARCHAR(500), " + "message VARCHAR(1000000), subject VARCHAR(900),tid VARCHAR(500))";
    mDatabase.execSQL(createTable);
    String ins = "INSERT INTO tlog (name,email,message,subject,tid) VALUES ('"+name+"','"+email+"','"+message+"','"+subject+"','"+tid+"')";
    mDatabase.execSQL(ins);
}
    public class Post {
        public final MediaType JSON = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();

        String post(String url, String json) throws IOException {
            RequestBody body = RequestBody.create(json, JSON);
            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                if (response.code() == 400) {
                    return null;
                }
                return response.body().string();

            }
        }
    }

    private void showDialog(String message){
        final AlertDialog.Builder normalDialog =
                new AlertDialog.Builder(createTicketActivity.this);
        normalDialog.setTitle("message");
        normalDialog.setMessage(message);
        normalDialog.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
        normalDialog.show();
    }
    private void showerrorDialog(String message){
        final AlertDialog.Builder normalDialog =
                new AlertDialog.Builder(createTicketActivity.this);
        normalDialog.setTitle("message");
        normalDialog.setMessage(message);
        normalDialog.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                      //  finish();
                    }
                });
        normalDialog.show();
    }
}
