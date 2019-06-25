package com.example.whiteawayshotelandresort;

import java.util.Date;

public class Room {

// Variable declaration
    private int roomID;
    private int room_floor;
    private String room_size;
    private String room_status;
    private int price_per_night;

    public Room(){}  //default constructor

    public Room(int roomid, int roomFloor, String roomSize, String roomStatus, int price) {
        this.roomID = roomid;
        this.room_floor = roomFloor;
        this.room_size = roomSize;
        this.room_status = roomStatus;
        this.price_per_night = price;
    }

    //Getter and the Setters

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public int getRoom_floor() {
        return room_floor;
    }

    public void setRoom_floor(int room_floor) {
        this.room_floor = room_floor;
    }

    public String getRoom_size() {
        return room_size;
    }

    public void setRoom_size(String room_size) {
        this.room_size = room_size;
    }

    public String getRoom_status() {
        return room_status;
    }

    public void setRoom_status(String room_status) {
        this.room_status = room_status;
    }

    public int getPrice_per_night() {
        return price_per_night;
    }

    public void setPrice_per_night(int price_per_night) {
        this.price_per_night = price_per_night;
    }
}
