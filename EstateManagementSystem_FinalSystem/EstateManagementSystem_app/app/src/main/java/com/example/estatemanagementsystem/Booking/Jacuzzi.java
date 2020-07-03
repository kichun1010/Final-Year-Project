package com.example.estatemanagementsystem.Booking;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.estatemanagementsystem.Booking.Config.Config;
import com.example.estatemanagementsystem.R;
import com.github.jhonnyx2012.horizontalpicker.DatePickerListener;
import com.github.jhonnyx2012.horizontalpicker.HorizontalPicker;
import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;

import org.joda.time.DateTime;
import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Jacuzzi extends AppCompatActivity implements DatePickerListener {

    private TextView show;
    private SQLiteHandler db;
    private String name,phone,address,email,time,fullDate;
    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn120,btn11,btn12;
    public static final int PAYPAL_REQUEST_CODE = 7171;
    private static PayPalConfiguration config = new PayPalConfiguration()
            .environment(PayPalConfiguration.ENVIRONMENT_SANDBOX)
            .clientId(Config.PAYPAL_CLIENT_ID);//USE SANDBOX

    String date="";
    Button btnPayNow;
    EditText editAmount;
    String amount="";
    private String username;
    private TextView txtTitle;

    @Override
    protected void onDestroy() {
        stopService(new Intent(this, PayPalService.class));
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jacuzzi);
        name = "Chan Tai Man";
        phone = "12345678";
        address = "Flat B, 9/F, Block A";
        email = "abc@gmail.com";
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn120 = findViewById(R.id.btn10);
        btn11 = findViewById(R.id.btn11);
        btn12 = findViewById(R.id.btn12);
        db = new SQLiteHandler(getApplicationContext());
        show = findViewById(R.id.show);
        HorizontalPicker picker= (HorizontalPicker) findViewById(R.id.datePicker);
        picker.setListener(this)
                .setDays(14)
                .setOffset(0)
                .setDateSelectedColor(Color.DKGRAY)
                .setDateSelectedTextColor(Color.WHITE)
                .setMonthAndYearTextColor(Color.DKGRAY)
                .setTodayButtonTextColor(getResources().getColor(R.color.colorPrimary))
                .setTodayDateTextColor(getResources().getColor(R.color.colorPrimary))
                .setTodayDateBackgroundColor(Color.GRAY)
                .setUnselectedDayTextColor(Color.DKGRAY)
                .setDayOfWeekTextColor(Color.DKGRAY )
                .setUnselectedDayTextColor(getResources().getColor(R.color.primaryTextColor))
                .showTodayButton(false)
                .init();
        picker.setBackgroundColor(Color.LTGRAY);
        picker.setDate(new DateTime());
        //Start Paypal Service
        Intent intent = new Intent(this,PayPalService.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION,config);
        startService(intent);
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            username = extras.getString("username");
        }
        txtTitle = findViewById(R.id.title);
        String htmlString="<u>Jacuzzi</u>";
        txtTitle.setText(Html.fromHtml(htmlString));
    }


    public void book1(View view){
        time = btn1.getText().toString();
        //fullDate = "1,"+tv2.getText().toString();
        //booking(name,phone,email,address,fullDate,time);
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        //Yes button clicked
                        payment();
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        //No button clicked
                        break;
                }
            }
        };
        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Booking Confirm");
        builder.setMessage("Your booking is \n Facility: Jacuzzi \n Date: "+date+"\n Time : "+time+" \n Total Booking Fee : $120 \n Is the information above correct?");

        // add the buttons
        builder.setPositiveButton("Yes", dialogClickListener);
        builder.setNegativeButton("No", null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void book2(View view){
        time = btn2.getText().toString();
        //fullDate = "1,"+tv2.getText().toString();
        //booking(name,phone,email,address,fullDate,time);
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        //Yes button clicked
                        payment();
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        //No button clicked
                        break;
                }
            }
        };
        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Booking Confirm");
        builder.setMessage("Your booking is \n Facility: Jacuzzi \n Date: "+date+"\n Time : "+time+" \n Total Booking Fee : $120 \n Is the information above correct?");

        // add the buttons
        builder.setPositiveButton("Yes", dialogClickListener);
        builder.setNegativeButton("No", null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void book3(View view){
        time = btn3.getText().toString();
        //fullDate = "1,"+tv2.getText().toString();
        //booking(name,phone,email,address,fullDate,time);
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        //Yes button clicked
                        payment();
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        //No button clicked
                        break;
                }
            }
        };
        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Booking Confirm");
        builder.setMessage("Your booking is \n Facility: Jacuzzi \n Date: "+date+"\n Time : "+time+" \n Total Booking Fee : $120 \n Is the information above correct?");

        // add the buttons
        builder.setPositiveButton("Yes", dialogClickListener);
        builder.setNegativeButton("No", null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void book4(View view){
        time = btn4.getText().toString();
        //fullDate = "1,"+tv2.getText().toString();
        //booking(name,phone,email,address,fullDate,time);
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        //Yes button clicked
                        payment();
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        //No button clicked
                        break;
                }
            }
        };
        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Booking Confirm");
        builder.setMessage("Your booking is \n Facility: Jacuzzi \n Date: "+date+"\n Time : "+time+" \n Total Booking Fee : $120 \n Is the information above correct?");

        // add the buttons
        builder.setPositiveButton("Yes", dialogClickListener);
        builder.setNegativeButton("No", null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void book5(View view){
        time = btn5.getText().toString();
        //fullDate = "1,"+tv2.getText().toString();
        //booking(name,phone,email,address,fullDate,time);
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        //Yes button clicked
                        payment();
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        //No button clicked
                        break;
                }
            }
        };
        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Booking Confirm");
        builder.setMessage("Your booking is \n Facility: Jacuzzi \n Date: "+date+"\n Time : "+time+" \n Total Booking Fee : $120 \n Is the information above correct?");

        // add the buttons
        builder.setPositiveButton("Yes", dialogClickListener);
        builder.setNegativeButton("No", null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void book6(View view){
        time = btn6.getText().toString();
        //fullDate = "1,"+tv2.getText().toString();
        //booking(name,phone,email,address,fullDate,time);
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        //Yes button clicked
                        payment();
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        //No button clicked
                        break;
                }
            }
        };
        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Booking Confirm");
        builder.setMessage("Your booking is \n Facility: Jacuzzi \n Date: "+date+"\n Time : "+time+" \n Total Booking Fee : $120 \n Is the information above correct?");

        // add the buttons
        builder.setPositiveButton("Yes", dialogClickListener);
        builder.setNegativeButton("No", null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void book7(View view){
        time = btn7.getText().toString();
        //fullDate = "1,"+tv2.getText().toString();
        //booking(name,phone,email,address,fullDate,time);
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        //Yes button clicked
                        payment();
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        //No button clicked
                        break;
                }
            }
        };
        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Booking Confirm");
        builder.setMessage("Your booking is \n Facility: Jacuzzi \n Date: "+date+"\n Time : "+time+" \n Total Booking Fee : $120 \n Is the information above correct?");

        // add the buttons
        builder.setPositiveButton("Yes", dialogClickListener);
        builder.setNegativeButton("No", null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void book8(View view){
        time = btn8.getText().toString();
        //fullDate = "1,"+tv2.getText().toString();
        //booking(name,phone,email,address,fullDate,time);
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        //Yes button clicked
                        payment();
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        //No button clicked
                        break;
                }
            }
        };
        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Booking Confirm");
        builder.setMessage("Your booking is \n Facility: Jacuzzi \n Date: "+date+"\n Time : "+time+" \n Total Booking Fee : $120 \n Is the information above correct?");

        // add the buttons
        builder.setPositiveButton("Yes", dialogClickListener);
        builder.setNegativeButton("No", null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void book9(View view){
        time = btn9.getText().toString();
        //fullDate = "1,"+tv2.getText().toString();
        //booking(name,phone,email,address,fullDate,time);
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        //Yes button clicked
                        payment();
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        //No button clicked
                        break;
                }
            }
        };
        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Booking Confirm");
        builder.setMessage("Your booking is \n Facility: Jacuzzi \n Date: "+date+"\n Time : "+time+" \n Total Booking Fee : $120 \n Is the information above correct?");

        // add the buttons
        builder.setPositiveButton("Yes", dialogClickListener);
        builder.setNegativeButton("No", null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void book120(View view){
        time = btn120.getText().toString();
        //fullDate = "1,"+tv2.getText().toString();
        //booking(name,phone,email,address,fullDate,time);
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        //Yes button clicked
                        payment();
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        //No button clicked
                        break;
                }
            }
        };
        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Booking Confirm");
        builder.setMessage("Your booking is \n Facility: Jacuzzi \n Date: "+date+"\n Time : "+time+" \n Total Booking Fee : $120 \n Is the information above correct?");

        // add the buttons
        builder.setPositiveButton("Yes", dialogClickListener);
        builder.setNegativeButton("No", null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void book11(View view){
        time = btn11.getText().toString();
        //fullDate = "1,"+tv2.getText().toString();
        //booking(name,phone,email,address,fullDate,time);
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        //Yes button clicked
                        payment();
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        //No button clicked
                        break;
                }
            }
        };
        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Booking Confirm");
        builder.setMessage("Your booking is \n Facility: Jacuzzi \n Date: "+date+"\n Time : "+time+" \n Total Booking Fee : $120 \n Is the information above correct?");

        // add the buttons
        builder.setPositiveButton("Yes", dialogClickListener);
        builder.setNegativeButton("No", null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void book12(View view){
        time = btn12.getText().toString();
        //fullDate = "1,"+tv2.getText().toString();
        //booking(name,phone,email,address,fullDate,time);
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        //Yes button clicked
                        payment();
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        //No button clicked
                        break;
                }
            }
        };
        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Booking Confirm");
        builder.setMessage("Your booking is \n Facility: Jacuzzi \n Date: "+date+"\n Time : "+time+" \n Total Booking Fee : $120 \n Is the information above correct?");

        // add the buttons
        builder.setPositiveButton("Yes", dialogClickListener);
        builder.setNegativeButton("No", null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }



    public void payment(){
        amount = "120";
        PayPalPayment payPalPayment = new PayPalPayment(new BigDecimal(String.valueOf(amount)),"HKD","Booking Fee",PayPalPayment.PAYMENT_INTENT_SALE);
        Intent intent = new Intent(this, PaymentActivity.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION,config);
        intent.putExtra(PaymentActivity.EXTRA_PAYMENT,payPalPayment);
        startActivityForResult(intent,PAYPAL_REQUEST_CODE);

    }

    private void booking(final String name,final String phone,final String email,final String address,final String fullDate,final String time) {
        StringRequest strReq = new StringRequest(Request.Method.POST, "", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try{
                    JSONObject jobj = new JSONObject((response));
                    boolean error = jobj.getBoolean(("error"));
                    if(!error){
                        String id = jobj.getString("id");
                        JSONObject user = jobj.getJSONObject("user");
                        String name = user.getString("name");
                        String phone = user.getString("phone");
                        String email = user.getString("email");
                        String address = user.getString("address");
                        String fullDate = user.getString("fullDate");
                        String time = user.getString("time");

                        db.booking(name,phone,email,address,fullDate,time);
                        finish();
                    }else{
                        Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
                    }
                }catch(JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String,String>getParams(){
                Map<String,String> params = new HashMap<String,String>();
                params.put("tag","booking");
                params.put("name",name);
                params.put("phone",phone);
                params.put("email",email);
                params.put("address",address);
                params.put("fullDate",fullDate);
                params.put("time",time);
                return params;
            }
        };

        Volley.newRequestQueue(getApplicationContext()).add(strReq);
    }

    @Override
    public void onDateSelected(DateTime dateSelected) {
        date = dateSelected.toString();
        date = date.substring(0,10);
        Toast.makeText(this,date,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == PAYPAL_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                PaymentConfirmation confirmation = data.getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);
                if (confirmation != null) {
                    try {
                        String paymentDetails = confirmation.toJSONObject().toString(4);
                        startActivity(new Intent(this, PaymentDetails.class)
                                .putExtra("PaymentDetails", paymentDetails)
                                .putExtra("PaymentAmount", amount)
                                .putExtra("username",username)
                                .putExtra("type","Jacuzzi")
                                .putExtra("date",date)
                                .putExtra("time",time)

                        );


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            } else if (resultCode == Activity.RESULT_CANCELED)
                Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show();
        } else if (resultCode == PaymentActivity.RESULT_EXTRAS_INVALID) {
            Toast.makeText(this, "Invalid", Toast.LENGTH_SHORT).show();
        }
    }
}
