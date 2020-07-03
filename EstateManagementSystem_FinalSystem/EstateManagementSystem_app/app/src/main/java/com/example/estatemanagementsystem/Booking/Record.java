package com.example.estatemanagementsystem.Booking;

public class Record {
    private String id,type,date,time,status;

    public Record(String id,String type,String date,String time,String status){
        this.id=id;
        this.type=type;
        this.date=date;
        this.time=time;
        this.status=status;
    }

    public String getId(){return id;}
    public String getType(){return type;}
    public String getDate(){return date;}
    public String getTime(){return time;}
    public String getStatus(){return status;}

}
