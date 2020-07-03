package com.example.estatemanagementsystem.Booking;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class CallBookingRecord extends AsyncTask <String, Void,String> {

    AlertDialog dialog;
    Context context;
    public Boolean login = false;
    public CallBookingRecord(Context context)
    {

        this.context = context;
    }

    @Override
    protected void onPreExecute() {
    }
    @Override
    protected void onPostExecute(String s) {
//        if(s.contains("login successful"))
//        {
//            Intent intent_name = new Intent();
//            intent_name.setClass(context.getApplicationContext(),Main2Activity.class);
//            context.startActivity(intent_name);
//        }
    }
    @Override
    protected String doInBackground(String... voids) {
        String result = "";
        String username = voids[0];

        String connstr = "http://192.168.1.101/BookingRecord.php";

        try {
            URL url = new URL(connstr);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.setDoInput(true);
            http.setDoOutput(true);

            OutputStream ops = http.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(ops,"UTF-8"));
            String data = URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(username,"UTF-8");
            writer.write(data);
            writer.flush();
            writer.close();
            ops.close();

            InputStream ips = http.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(ips,"ISO-8859-1"));
            String line ="";
            StringBuffer stringBuffer = new StringBuffer("");
            while ((line = reader.readLine()) != null)
            {
                stringBuffer.append(line);
            }
            result = stringBuffer.toString();
            reader.close();
            ips.close();
            http.disconnect();
            return result;

        } catch (MalformedURLException e) {
            result = e.getMessage();
        } catch (IOException e) {
            result = e.getMessage();
        }


        return result;
    }
}
