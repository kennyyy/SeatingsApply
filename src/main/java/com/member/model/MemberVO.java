package com.member.model;

import java.sql.Timestamp;

public class MemberVO {

	private String id;
	private String pw;
	private String name;
	private String email;
	private String address;
	private int age;
	private String gender;
	private Timestamp regdate;
	private String master;
	private int limitroom;
	
	public MemberVO() {
	}

	public MemberVO(String id, String pw, String name, String email, String address, int age, String gender,
		Timestamp regdate, String master, int limitroom) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.address = address;
		this.age = age;
		this.gender = gender;
		this.regdate = regdate;
		this.master = master;
		this.limitroom = limitroom;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	public String getMaster() {
		return master;
	}

	public void setMaster(String master) {
		this.master = master;
	}

	public int getLimitroom() {
		return limitroom;
	}

	public void setLimitroom(int limitroom) {
		this.limitroom = limitroom;
	}
	
	
	
	
	
	
	
	
	
	
}