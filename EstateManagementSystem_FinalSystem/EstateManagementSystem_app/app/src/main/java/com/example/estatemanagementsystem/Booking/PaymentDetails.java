package com.example.estatemanagementsystem.Booking;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.estatemanagementsystem.R;

import org.json.JSONException;
import org.json.JSONObject;

public class PaymentDetails extends AppCompatActivity {
    TextView txtId,txtAmount,txtStatus,txtUser,txtDate,txtTime,txtType,txtTitle;
    private static final int REQUEST_CODE = 3434;
    private String username,type,date,time;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_details);

        txtId = (TextView)findViewById(R.id.txtId);
        txtAmount = (TextView)findViewById(R.id.txtAmount);
        txtStatus = (TextView)findViewById(R.id.txtStatus);
        txtUser = (TextView)findViewById(R.id.txtUser);
        txtDate = (TextView)findViewById(R.id.txtDate);
        txtTime = (TextView)findViewById(R.id.txtTime);
        txtType = (TextView)findViewById(R.id.txtType);
        txtTitle = findViewById(R.id.title);
        String htmlString="<u>Payment Details</u>";
        txtTitle.setText(Html.fromHtml(htmlString));

        //Get Intent
        Intent intent = getIntent();
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            username = extras.getString("username");
            type = extras.getString("type");
            date = extras.getString("date");
            time = extras.getString("time");
        }


        try{
            JSONObject jsonObject = new JSONObject(intent.getStringExtra("PaymentDetails"));
            showDetails(jsonObject.getJSONObject("response"),intent.getStringExtra("PaymentAmount"));
            insert(username,type,date,time);

        }catch(JSONException e){
            e.printStackTrace();
        }
    }

    private void showDetails(JSONObject response, String paymentAmount) {
        try {
            txtId.setText("Payment Code : "+response.getString("id"));
            txtAmount.setText("Amount : "+("$"+paymentAmount));
            txtStatus.setText("Status : "+response.getString("state"));
            txtUser.setText("Username : "+username);
            txtDate.setText("Date : "+date);
            txtTime.setText("Period : "+time);
            txtType.setText("Facility Type : "+type);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Payment Successful");
            builder.setMessage("Your booking is finished. Thank you for using our service.");

            // add a button
            builder.setPositiveButton("OK", null);

            // create and show the alert dialog
            AlertDialog dialog = builder.create();
            dialog.show();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void insert(String username,String type,String date,String time){
        background bg = new background(this);
        bg.execute(username,type,date,time);
    }

    public void back(View view){
        this.finish();
        Intent i = new Intent(this, Booking.class);
        i.putExtra("username",username);
        startActivityForResult(i, REQUEST_CODE);

    }
}
