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
import org.w3c.dom.Text;

import java.math.BigDecimal;


public class YoGa extends AppCompatActivity implements DatePickerListener {

    public static final int PAYPAL_REQUEST_CODE = 7171;
    private static PayPalConfiguration config = new PayPalConfiguration()
            .environment(PayPalConfiguration.ENVIRONMENT_SANDBOX)
            .clientId(Config.PAYPAL_CLIENT_ID);//USE SANDBOX
    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,btn15,btn16,btn17,btn18,btn19,btn20,btn21,btn22,btn23,btn24;

    Button btnPayNow;
    EditText editAmount;
    String amount="";
    String date = "";
    String time = "";
    String room = "";
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
        setContentView(R.layout.activity_yoga);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn10 = findViewById(R.id.btn10);
        btn11 = findViewById(R.id.btn11);
        btn12 = findViewById(R.id.btn12);
        btn13 = findViewById(R.id.btn13);
        btn14 = findViewById(R.id.btn14);
        btn15 = findViewById(R.id.btn15);
        btn16 = findViewById(R.id.btn16);
        btn17 = findViewById(R.id.btn17);
        btn18 = findViewById(R.id.btn18);
        btn19 = findViewById(R.id.btn19);
        btn20 = findViewById(R.id.btn20);
        btn21 = findViewById(R.id.btn21);
        btn22 = findViewById(R.id.btn22);
        btn23 = findViewById(R.id.btn23);
        btn24 = findViewById(R.id.btn24);
        HorizontalPicker picker = (HorizontalPicker) findViewById(R.id.datePicker);
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
        Intent intent = new Intent(this,PayPalService.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION,config);
        startService(intent);
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            username = extras.getString("username");
        }
        txtTitle = findViewById(R.id.title);
        String htmlString="<u>YoGa Room</u>";
        txtTitle.setText(Html.fromHtml(htmlString));
    }

    @Override
    public void onDateSelected(DateTime dateSelected) {
        // log it for demo
//        Log.i("HorizontalPicker", "Selected date is " + dateSelected.toString());
        date = dateSelected.toString();
        date = date.substring(0, 10);
        Toast.makeText(this,date,Toast.LENGTH_SHORT).show();

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
        builder.setMessage("Your booking is \n Facility: YoGa Room 1 \n Date: "+date+"\n Time : "+time+" \n Total Booking Fee : $30 \n Is the information above correct?");

        // add the buttons
        builder.setPositiveButton("Yes", dialogClickListener);
        builder.setNegativeButton("No", null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
        room ="1";
    }

    public void book2(View view){
        time = btn2.getText().toString();
        room ="1";
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
        builder.setMessage("Your booking is \n Facility: YoGa Room 1 \n Date: "+date+"\n Time : "+time+" \n Total Booking Fee : $30 \n Is the information above correct?");

        // add the buttons
        builder.setPositiveButton("Yes", dialogClickListener);
        builder.setNegativeButton("No", null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void book3(View view){
        time = btn3.getText().toString();
        room ="1";
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
        builder.setMessage("Your booking is \n Facility: YoGa Room 1\n Date: "+date+"\n Time : "+time+" \n Total Booking Fee : $30 \n Is the information above correct?");

        // add the buttons
        builder.setPositiveButton("Yes", dialogClickListener);
        builder.setNegativeButton("No", null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void book4(View view){
        time = btn4.getText().toString();
        room ="1";
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
        builder.setMessage("Your booking is \n Facility: YoGa Room 1\n Date: "+date+"\n Time : "+time+" \n Total Booking Fee : $30 \n Is the information above correct?");

        // add the buttons
        builder.setPositiveButton("Yes", dialogClickListener);
        builder.setNegativeButton("No", null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void book5(View view){
        time = btn5.getText().toString();
        room ="1";
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
        builder.setMessage("Your booking is \n Facility: YoGa Room 1\n Date: "+date+"\n Time : "+time+" \n Total Booking Fee : $30 \n Is the information above correct?");

        // add the buttons
        builder.setPositiveButton("Yes", dialogClickListener);
        builder.setNegativeButton("No", null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void book6(View view){
        time = btn6.getText().toString();
        room ="1";
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
        builder.setMessage("Your booking is \n Facility: YoGa Room 1\n Date: "+date+"\n Time : "+time+" \n Total Booking Fee : $30 \n Is the information above correct?");

        // add the buttons
        builder.setPositiveButton("Yes", dialogClickListener);
        builder.setNegativeButton("No", null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void book7(View view){
        time = btn7.getText().toString();
        room ="1";
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
        builder.setMessage("Your booking is \n Facility: YoGa Room 1\n Date: "+date+"\n Time : "+time+" \n Total Booking Fee : $30 \n Is the information above correct?");

        // add the buttons
        builder.setPositiveButton("Yes", dialogClickListener);
        builder.setNegativeButton("No", null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void book8(View view){
        time = btn8.getText().toString();
        room ="1";
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
        builder.setMessage("Your booking is \n Facility: YoGa Room 1\n Date: "+date+"\n Time : "+time+" \n Total Booking Fee : $30 \n Is the information above correct?");

        // add the buttons
        builder.setPositiveButton("Yes", dialogClickListener);
        builder.setNegativeButton("No", null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void book9(View view){
        time = btn9.getText().toString();
        room ="1";
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
        builder.setMessage("Your booking is \n Facility: YoGa Room 1\n Date: "+date+"\n Time : "+time+" \n Total Booking Fee : $30 \n Is the information above correct?");

        // add the buttons
        builder.setPositiveButton("Yes", dialogClickListener);
        builder.setNegativeButton("No", null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void book10(View view){
        time = btn10.getText().toString();
        room ="1";
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
        builder.setMessage("Your booking is \n Facility: YoGa Room 1\n Date: "+date+"\n Time : "+time+" \n Total Booking Fee : $30 \n Is the information above correct?");

        // add the buttons
        builder.setPositiveButton("Yes", dialogClickListener);
        builder.setNegativeButton("No", null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void book11(View view){
        time = btn11.getText().toString();
        room ="1";
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
        builder.setMessage("Your booking is \n Facility: YoGa Room 1\n Date: "+date+"\n Time : "+time+" \n Total Booking Fee : $30 \n Is the information above correct?");

        // add the buttons
        builder.setPositiveButton("Yes", dialogClickListener);
        builder.setNegativeButton("No", null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void book12(View view){
        time = btn12.getText().toString();
        room ="1";
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
        builder.setMessage("Your booking is \n Facility: YoGa Room 1\n Date: "+date+"\n Time : "+time+" \n Total Booking Fee : $30 \n Is the information above correct?");

        // add the buttons
        builder.setPositiveButton("Yes", dialogClickListener);
        builder.setNegativeButton("No", null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void book20(View view){
        time = btn20.getText().toString();
        room ="2";
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
        builder.setMessage("Your booking is \n Facility: YoGa Room 2\n Date: "+date+"\n Time : "+time+" \n Total Booking Fee : $30 \n Is the information above correct?");

        // add the buttons
        builder.setPositiveButton("Yes", dialogClickListener);
        builder.setNegativeButton("No", null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void book13(View view){
        time = btn13.getText().toString();
        room ="2";
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
        builder.setMessage("Your booking is \n Facility: YoGa Room 2\n Date: "+date+"\n Time : "+time+" \n Total Booking Fee : $30 \n Is the information above correct?");

        // add the buttons
        builder.setPositiveButton("Yes", dialogClickListener);
        builder.setNegativeButton("No", null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void book14(View view){
        time = btn14.getText().toString();
        room ="2";
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
        builder.setMessage("Your booking is \n Facility: YoGa Room 2\n Date: "+date+"\n Time : "+time+" \n Total Booking Fee : $30 \n Is the information above correct?");

        // add the buttons
        builder.setPositiveButton("Yes", dialogClickListener);
        builder.setNegativeButton("No", null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void book15(View view){
        time = btn15.getText().toString();
        room ="2";
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
        builder.setMessage("Your booking is \n Facility: YoGa Room 2\n Date: "+date+"\n Time : "+time+" \n Total Booking Fee : $30 \n Is the information above correct?");

        // add the buttons
        builder.setPositiveButton("Yes", dialogClickListener);
        builder.setNegativeButton("No", null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void book16(View view){
        time = btn16.getText().toString();
        room ="2";
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
        builder.setMessage("Your booking is \n Facility: YoGa Room 2\n Date: "+date+"\n Time : "+time+" \n Total Booking Fee : $30 \n Is the information above correct?");

        // add the buttons
        builder.setPositiveButton("Yes", dialogClickListener);
        builder.setNegativeButton("No", null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void book17(View view){
        time = btn17.getText().toString();
        room ="2";
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
        builder.setMessage("Your booking is \n Facility: YoGa Room 2\n Date: "+date+"\n Time : "+time+" \n Total Booking Fee : $30 \n Is the information above correct?");

        // add the buttons
        builder.setPositiveButton("Yes", dialogClickListener);
        builder.setNegativeButton("No", null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void book18(View view){
        time = btn18.getText().toString();
        room ="2";
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
        builder.setMessage("Your booking is \n Facility: YoGa Room 2\n Date: "+date+"\n Time : "+time+" \n Total Booking Fee : $30 \n Is the information above correct?");

        // add the buttons
        builder.setPositiveButton("Yes", dialogClickListener);
        builder.setNegativeButton("No", null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void book19(View view){
        time = btn19.getText().toString();
        room ="2";
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
        builder.setMessage("Your booking is \n Facility: YoGa Room 2\n Date: "+date+"\n Time : "+time+" \n Total Booking Fee : $30 \n Is the information above correct?");

        // add the buttons
        builder.setPositiveButton("Yes", dialogClickListener);
        builder.setNegativeButton("No", null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void book21(View view){
        time = btn21.getText().toString();
        room ="2";
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
        builder.setMessage("Your booking is \n Facility: YoGa Room 2\n Date: "+date+"\n Time : "+time+" \n Total Booking Fee : $30 \n Is the information above correct?");

        // add the buttons
        builder.setPositiveButton("Yes", dialogClickListener);
        builder.setNegativeButton("No", null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void book22(View view){
        time = btn22.getText().toString();
        room ="2";
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
        builder.setMessage("Your booking is \n Facility: YoGa Room 2\n Date: "+date+"\n Time : "+time+" \n Total Booking Fee : $30 \n Is the information above correct?");

        // add the buttons
        builder.setPositiveButton("Yes", dialogClickListener);
        builder.setNegativeButton("No", null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void book23(View view){
        time = btn23.getText().toString();
        room ="2";
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
        builder.setMessage("Your booking is \n Facility: YoGa Room 2\n Date: "+date+"\n Time : "+time+" \n Total Booking Fee : $30 \n Is the information above correct?");

        // add the buttons
        builder.setPositiveButton("Yes", dialogClickListener);
        builder.setNegativeButton("No", null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void book24(View view){
        time = btn24.getText().toString();
        room ="2";
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
        builder.setMessage("Your booking is \n Facility: YoGa Room 2\n Date: "+date+"\n Time : "+time+" \n Total Booking Fee : $30 \n Is the information above correct?");

        // add the buttons
        builder.setPositiveButton("Yes", dialogClickListener);
        builder.setNegativeButton("No", null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }


    public void payment(){
        amount = "30";
        PayPalPayment payPalPayment = new PayPalPayment(new BigDecimal(String.valueOf(amount)),"HKD","Booking Fee",PayPalPayment.PAYMENT_INTENT_SALE);
        Intent intent = new Intent(this, PaymentActivity.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION,config);
        intent.putExtra(PaymentActivity.EXTRA_PAYMENT,payPalPayment);
        startActivityForResult(intent,PAYPAL_REQUEST_CODE);

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
                                .putExtra("type","YoGa Room "+room)
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
