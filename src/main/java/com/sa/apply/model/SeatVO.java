package com.sa.apply.model;

public class SeatVO {
	private String roomnumber; //예약된 좌석
	private String seat; // 방번호
	
	public SeatVO() {
		// TODO Auto-generated constructor stub
	}

	public SeatVO(String roomnumber, String seat) {
		super();
		this.roomnumber = roomnumber;
		this.seat = seat;
	}

	public String getRoomnumber() {
		return roomnumber;
	}

	public void setRoomnumber(String roomnumber) {
		this.roomnumber = roomnumber;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}
	
	
	
}
