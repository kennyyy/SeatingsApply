package com.sa.apply.model;

import java.sql.Timestamp;

public class ApplyVO {
	//APPLY
	private String userid; //유저아이디
	private String roomnumber; //방번호
	private String iswin; //당첨여부
	private String selectseat;//선택한좌석
	
	//MEMBERS
	private String master; //마스터권한
	private String limitroom; //접속가능한 방 개수
	
	public ApplyVO() {
		// TODO Auto-generated constructor stub
	}

	public ApplyVO(String userid, String roomnumber, String iswin, String selectseat, String master, String limitroom) {
		super();
		this.userid = userid;
		this.roomnumber = roomnumber;
		this.iswin = iswin;
		this.selectseat = selectseat;
		this.master = master;
		this.limitroom = limitroom;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getRoomnumber() {
		return roomnumber;
	}

	public void setRoomnumber(String roomnumber) {
		this.roomnumber = roomnumber;
	}

	public String getIswin() {
		return iswin;
	}

	public void setIswin(String iswin) {
		this.iswin = iswin;
	}

	public String getSelectseat() {
		return selectseat;
	}

	public void setSelectseat(String selectseat) {
		this.selectseat = selectseat;
	}

	public String getMaster() {
		return master;
	}

	public void setMaster(String master) {
		this.master = master;
	}

	public String getLimitroom() {
		return limitroom;
	}

	public void setLimitroom(String limitroom) {
		this.limitroom = limitroom;
	}

	
	
	
}
