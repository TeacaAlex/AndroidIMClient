package com.example.chatclient;

public class Message {
	private String msg;
	private String exp;
	private String dest;
	
	
	public Message(String msg, String exp) {
		this.msg = msg;
		this.exp = exp;
	}
	
	public String getMessage() {
		return msg;
	}
	
	public void setMessage(String msg) {
		this.msg = msg;
	}
	
	public String getExpeditor() {
		return exp;
	}
	
	public void setExpeditor(String exp) {
		this.exp = exp;
	}
	
	public String getDestinatar() {
		return dest;
	}
	
	public void setDestinatar(String dest) {
		this.dest = dest;
	}
	
	
	public String toString() {
		return exp + ": " + msg;
	}
}
