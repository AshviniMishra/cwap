package com.cdac.model;

public class User {

	@Override
	public String toString() {
		return String.format("Name: %s Email: %s Password : %s Type_Of_User : %s Mobile_No : %d IsValidUser : %b ",
				name, email_id, password, type_of_user, mobile_no, isvalid);
	}

	String name;
	String email_id;
	String password;
	String type_of_user;
	long mobile_no = 0;
	boolean isvalid;

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getType_of_user() {
		return type_of_user;
	}

	public void setType_of_user(String type_of_user) {
		this.type_of_user = type_of_user;
	}

	public long getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(long mobile_no) {
		this.mobile_no = mobile_no;
	}

	public boolean isIsvalid() {
		return isvalid;
	}

	public void setIsvalid(boolean isvalid) {
		this.isvalid = isvalid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
