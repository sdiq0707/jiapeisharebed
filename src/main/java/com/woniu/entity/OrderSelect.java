package com.woniu.entity;

import java.io.Serializable;
import java.util.Date;

/*这个类是用来做订单的条件查询类的，各个属性为订单表条件查询的条件*/
public class OrderSelect implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//订单编号
	private String onum;
	//医院id
	private Integer hid;
	//科室id
	private Integer aid; 
	//订单状态
	private Integer status; 
	//开始时间
	private String btime;
	//结束时间
	private String etime;
	public String getOnum() {
		return onum;
	}
	public void setOnum(String onum) {
		this.onum = onum;
	}
	public Integer getHid() {
		return hid;
	}
	public void setHid(Integer hid) {
		this.hid = hid;
	}
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getBtime() {
		return btime;
	}
	public void setBtime(String btime) {
		this.btime = btime;
	}
	public String getEtime() {
		return etime;
	}
	public void setEtime(String etime) {
		this.etime = etime;
	}
	@Override
	public String toString() {
		return "OrderSelect [onum=" + onum + ", hid=" + hid + ", aid=" + aid + ", status=" + status + ", btime=" + btime
				+ ", etime=" + etime + "]";
	}
	
	
	
}
