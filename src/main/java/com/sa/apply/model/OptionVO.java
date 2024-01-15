package com.sa.apply.model;

import java.sql.Timestamp;

public class OptionVO {
	private String roomnumber;
	private String numcount;
	private String deadline;
	private String width;
	private String height;
	private String mid;
	private String nowdate;
	
	public OptionVO() {
		// TODO Auto-generated constructor stub
	}

	public OptionVO(String roomnumber, String numcount, String deadline, String width, String height, String mid, String nowdate) {
		super();
		this.roomnumber = roomnumber;
		this.numcount = numcount;
		this.deadline = deadline;
		this.width = width;
		this.height = height;
		this.mid = mid;
	}

	public String getRoomnumber() {
		return roomnumber;
	}

	public void setRoomnumber(String roomnumber) {
		this.roomnumber = roomnumber;
	}

	public String getNumcount() {
		return numcount;
	}

	public void setNumcount(String numcount) {
		this.numcount = numcount;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeigth() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getNowdate() {
		return nowdate;
	}

	public void setNowdate(String nowdate) {
		this.nowdate = nowdate;
	}

	
	
	
	
}
