package com.example.estatemanagementsystem.Booking;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.view.View;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.estatemanagementsystem.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
import java.util.ArrayList;

public class BookingRecord extends AppCompatActivity {
    ListView mListView;
    RecordListAdapter adapter;
    Context context;
    TableLayout list;
    TableLayout.LayoutParams row_layout;
    TableRow.LayoutParams view_layout;
    private String username;
    private TextView txtTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            username = extras.getString("username");
        }
        setContentView(R.layout.activity_record);
        CallBookingRecord bg = new CallBookingRecord(this);
        bg.execute(username);
        context = this;
        txtTitle = findViewById(R.id.title);
        String htmlString="<u>Booking Record</u>";
        txtTitle.setText(Html.fromHtml(htmlString));

    }

    public void back(View view){
        this.finish();
    }
    public class CallBookingRecord extends AsyncTask<String, Void,String> {

        JSONObject jsonObject;
        JSONArray jsonArray;
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
            String id,type,date,time,status;
//            ArrayList <Record> r = new ArrayList<>();
            try{
                TableLayout list = (TableLayout)findViewById(R.id.table);
                list.setStretchAllColumns(true);
                TableLayout.LayoutParams row_layout = new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT);
                TableRow.LayoutParams view_layout = new TableRow.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT);
//                jsonObject = new JSONObject(s);
                jsonArray = new JSONArray(s);
//                jsonArray = jsonObject.getJSONArray("server_response");
//                int count = 0;
//                while (count<jsonArray.length()){
                for(int i=0;i<jsonArray.length();i++){
//                    JSONObject JO = jsonArray.getJSONObject(count);
                    JSONObject JO = jsonArray.getJSONObject(i);
                    id = JO.getString("BookingID");
                    type = JO.getString("Type");
                    date = JO.getString("Date");
                    time = JO.getString("Period");
                    status = JO.getString("Status");
                    TableRow tr = new TableRow(BookingRecord.this);
                    tr.setLayoutParams(row_layout);
                    tr.setGravity(Gravity.CENTER_HORIZONTAL);
                    TextView bookid = new TextView(BookingRecord.this);
                    bookid.setText(id);
                    bookid.setLayoutParams(view_layout);
                    bookid.setGravity(Gravity.CENTER_HORIZONTAL);
                    TextView t = new TextView(BookingRecord.this);
                    t.setText(type);
                    t.setLayoutParams(view_layout);
                    t.setGravity(Gravity.CENTER_HORIZONTAL);
                    TextView d = new TextView(BookingRecord.this);
                    d.setText(date);
                    d.setLayoutParams(view_layout);
                    d.setGravity(Gravity.CENTER_HORIZONTAL);
                    TextView tm = new TextView(BookingRecord.this);
                    tm.setText(time);
                    tm.setLayoutParams(view_layout);
                    tm.setGravity(Gravity.CENTER_HORIZONTAL);
                    TextView st = new TextView(BookingRecord.this);
                    st.setText(status);
                    st.setLayoutParams(view_layout);
                    st.setGravity(Gravity.CENTER_HORIZONTAL);
//                    r.add(new Record(id,type,date,time,status));
//                    count++;
                    tr.addView(bookid);
                    tr.addView(t);
                    tr.addView(d);
                    tr.addView(tm);
                    tr.addView(st);
                    list.addView(tr);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
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
}
