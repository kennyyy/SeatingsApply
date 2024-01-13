package com.sa.roomset.model;

public class RoomSetVO {

    private String roomNumber;
    private String mid;
    private String numCount;
    private String deadLine;
    private String closingTime;
    private String width;
    private String height;

    private String RANDOMCYCLE;
    private String CYCLENUM;

    public String getRANDOMCYCLE() {
        return RANDOMCYCLE;
    }

    public void setRANDOMCYCLE(String RANDOMCYCLE) {
        this.RANDOMCYCLE = RANDOMCYCLE;
    }

    public String getCYCLENUM() {
        return CYCLENUM;
    }

    public void setCYCLENUM(String CYCLENUM) {
        this.CYCLENUM = CYCLENUM;
    }

    public RoomSetVO() {
    }

    public RoomSetVO(String roomNumber, String mid, String numCount, String deadLine, String closingTime, String width, String height) {
        this.roomNumber = roomNumber;
        this.mid = mid;
        this.numCount = numCount;
        this.deadLine = deadLine;
        this.closingTime = closingTime;
        this.width = width;
        this.height = height;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getNumCount() {
        return numCount;
    }

    public void setNumCount(String numCount) {
        this.numCount = numCount;
    }

    public String getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(String deadLine) {
        this.deadLine = deadLine;
    }

    public String getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(String closingTime) {
        this.closingTime = closingTime;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }



    @Override
    public String toString() {
        return "RoomSetVO{" +
                "roomNumber='" + roomNumber + '\'' +
                ", mid='" + mid + '\'' +
                ", numCount='" + numCount + '\'' +
                ", deadLine='" + deadLine + '\'' +
                ", closingTime='" + closingTime + '\'' +
                ", width='" + width + '\'' +
                ", height='" + height + '\'' +
                '}';
    }
}
