package com.woniu.entity;

public class Message {
	private boolean success;
	private String msg;
	
	public Message(boolean success,String msg) {
		// TODO Auto-generated constructor stub
		super();
		this.success=success;
		this.msg=msg;
	}
	public boolean isSuccess() {
		return success;
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	@Override
	public String toString() {
		return "Message [success=" + success + ", msg=" + msg + "]";
	}
	

}
