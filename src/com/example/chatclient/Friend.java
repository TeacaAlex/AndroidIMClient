package com.example.chatclient;

public class Friend {
	private String userName;
	private String ip;
	private String port;
	private String status;
	
	public Friend(String userName, String ip, String port, String status) {
		this.userName = userName;
		this.ip = ip;
		this.port = port;
		this.status = status;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus() {
		this.status = status;
	}
	
	public String toString() {
		return userName;
	}
}
