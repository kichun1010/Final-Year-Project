package com.example.estatemanagementsystem.Booking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.estatemanagementsystem.R;

import java.util.ArrayList;

public class RecordListAdapter extends ArrayAdapter<Record> {
    private static final String TAG = "RecordListAdapter";
    private Context mContext;
    int mResource;

    public RecordListAdapter(Context context, int resource, ArrayList<Record>objects){
        super(context,resource,objects);
        mContext=context;
        mResource=resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String id = getItem(position).getId();
        String type =getItem(position).getType();
        String date = getItem(position).getDate();
        String time = getItem(position).getTime();
        String status = getItem(position).getStatus();

        Record record = new Record(id,type,date,time,status);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource,parent,false);

        TextView tv1 = convertView.findViewById(R.id.tv1);
        TextView tv2 = convertView.findViewById(R.id.tv2);
        TextView tv3 = convertView.findViewById(R.id.tv3);
        TextView tv4 = convertView.findViewById(R.id.tv4);
        TextView tv5 = convertView.findViewById(R.id.tv5);

        tv1.setText(id);
        tv2.setText(type);
        tv3.setText(date);
        tv4.setText(time);
        tv5.setText(status);

        return convertView;
    }
}
