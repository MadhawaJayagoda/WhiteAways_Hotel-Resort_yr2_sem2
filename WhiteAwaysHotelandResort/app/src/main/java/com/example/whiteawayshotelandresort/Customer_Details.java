package com.example.whiteawayshotelandresort;

import java.util.Date;

public class Customer_Details {

    private String customerID;
    private int roomID;
    private String date_in;
    private String date_out;
    private long day_count;
    private String reservation_made_by;

    public Customer_Details() {
    }

    public Customer_Details(String cusID, int roomID, String date_in, String date_out, long day_count, String reservation_made_by) {
        this.customerID = cusID;
        this.roomID = roomID;
        this.date_in = date_in;
        this.date_out = date_out;
        this.day_count = day_count;
        this.reservation_made_by = reservation_made_by;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public String getDate_in() {
        return date_in;
    }

    public void setDate_in(String date_in) {
        this.date_in = date_in;
    }

    public String getDate_out() {
        return date_out;
    }

    public void setDate_out(String date_out) {
        this.date_out = date_out;
    }

    public long getDay_count() {
        return day_count;
    }

    public void setDay_count(long day_count) {
        this.day_count = day_count;
    }

    public String getReservation_made_by() {
        return reservation_made_by;
    }

    public void setReservation_made_by(String reservation_made_by) {
        this.reservation_made_by = reservation_made_by;
    }
}
