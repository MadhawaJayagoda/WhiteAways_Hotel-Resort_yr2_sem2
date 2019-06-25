package com.example.whiteawayshotelandresort;

import java.util.Date;

public class Customer {

    private String fullname;
    private String roomno;
    private String datein;
    private String dateout;
    private String id;

    public Customer() {
    }

    public Customer(String id,String fullname,String roomno, String datein, String dateout) {
        this.id = id;
        this.fullname = fullname;
        this.roomno = roomno;
        this.datein = datein;
        this.dateout = dateout;

    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getRoomno() {
        return roomno;
    }

    public void setRoomno(String roomno) {
        this.roomno = roomno;
    }


    public String getDatein() {
        return datein;
    }

    public void setDatein(String datein) {
        this.datein = datein;
    }

    public String getDateout() {
        return dateout;
    }

    public void setDateout(String dateout) {
        this.dateout = dateout;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}