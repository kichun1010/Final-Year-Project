package com.example.estatemanagementsystem.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.estatemanagementsystem.R;

public class ChangePassword extends AppCompatActivity {
    static EditText etNPassword,etNPassword2;
    private Button btn;
    private String username;
    private TextView txtTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        btn = (Button)findViewById(R.id.btnChange);
        etNPassword = (EditText) findViewById(R.id.etNPassword);
        etNPassword2 = (EditText) findViewById(R.id.etNPassword2);
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            username = extras.getString("username");
        }
        txtTitle = findViewById(R.id.title);
        String htmlString="<u>Password Changing</u>";
        txtTitle.setText(Html.fromHtml(htmlString));
    }


    public void change(View v){
        String nPassword = etNPassword.getText().toString();
        String nPassword2 = etNPassword2.getText().toString();
        if(nPassword.equals(nPassword2)) {
            String type = "change";
            BackgroundWorker2 backgroundWorker2 = new BackgroundWorker2(this);
            backgroundWorker2.execute(type, username,nPassword);
        }else{
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(ChangePassword.this);
            alertDialog.setTitle("Password Changing Status");
            alertDialog.setMessage("\nThe repeat password is not the same");
            alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ChangePassword.etNPassword.setText("");
                    ChangePassword.etNPassword2.setText("");
                }
            });
            AlertDialog alert = alertDialog.create();
            alert.show();
        }
    }
}
