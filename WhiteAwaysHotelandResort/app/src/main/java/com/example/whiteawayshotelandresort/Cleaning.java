package com.example.whiteawayshotelandresort;

public class Cleaning {

    private String cleanType;
    private String cleanDate;
    private int roomnum;
    private String status;

    public Cleaning() {
        this.cleanType = null;
        this.cleanDate = null;
        this.roomnum = 0;
        this.status = null;
    }

    public Cleaning(String cleanType, String cDate, int roomnum, String status) {

        this.cleanType = cleanType;
        this.cleanDate = cDate;
        this.roomnum = roomnum;
        this.status = "Not yet begun";
    }

    public int getRoomnum() {
        return roomnum;
    }

    public void setRoomnum(int roomnum) {
        this.roomnum = roomnum;
    }



    public void setCleanType(String cleanType) {
        this.cleanType = cleanType;
    }





    public String getCleanType() {
        return cleanType;
    }

    public String getCleanDate() {
        return cleanDate;
    }

    public void setCleanDate(String cleanDate) {
        this.cleanDate = cleanDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
