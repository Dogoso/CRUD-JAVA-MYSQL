package com.doglab.agenda;

import java.util.Date;

public class User {

	private int id;
	private String fullname, nickname, email;
	private Date born;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBorn() {
		return born;
	}
	public void setBorn(Date born) {
		this.born = born;
	}
	
}
