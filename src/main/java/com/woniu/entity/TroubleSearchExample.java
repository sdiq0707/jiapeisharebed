package com.woniu.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TroubleSearchExample {
	private Integer tstatus;
	private Integer tid;
	private String ttype;
	private String hospital;
	private String startTime;
	private String endTime;
	
	
	
	
	public final Integer getTid() {
		return tid;
	}
	public final void setTid(Integer tid) {
		this.tid = tid;
	}
	public final Integer getTstatus() {
		return tstatus;
	}
	public final void setTstatus(Integer tstatus) {
		this.tstatus = tstatus;
	}
	public final String getTtype() {
		return ttype;
	}
	public final void setTtype(String ttype) {
		this.ttype = ttype;
	}
	public final String getHospital() {
		return hospital;
	}
	public final void setHospital(String hospital) {
		this.hospital = hospital;
	}
	public final void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public final void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public final String getStartTime() {
		return startTime;
	}
	public final String getEndTime() {
		return endTime;
	}
	

}
