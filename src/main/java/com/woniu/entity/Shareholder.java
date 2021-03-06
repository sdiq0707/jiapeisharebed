package com.woniu.entity;

import java.util.Date;
import java.util.List;

public class Shareholder {
	private Userinfo userinfo;
    public Userinfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shareholder.uid
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    private Integer uid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shareholder.investment
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    private Double investment;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shareholder.jointime
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    private Date jointime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shareholder.divideratio
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    private Double divideratio;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shareholder.account
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    private String account;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shareholder.isdelete
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    private Integer isdelete;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shareholder.uid
     *
     * @return the value of shareholder.uid
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shareholder.uid
     *
     * @param uid the value for shareholder.uid
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shareholder.investment
     *
     * @return the value of shareholder.investment
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    public Double getInvestment() {
        return investment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shareholder.investment
     *
     * @param investment the value for shareholder.investment
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    public void setInvestment(Double investment) {
        this.investment = investment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shareholder.jointime
     *
     * @return the value of shareholder.jointime
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    public Date getJointime() {
        return jointime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shareholder.jointime
     *
     * @param jointime the value for shareholder.jointime
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    public void setJointime(Date jointime) {
        this.jointime = jointime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shareholder.divideratio
     *
     * @return the value of shareholder.divideratio
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    public Double getDivideratio() {
        return divideratio;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shareholder.divideratio
     *
     * @param divideratio the value for shareholder.divideratio
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    public void setDivideratio(Double divideratio) {
        this.divideratio = divideratio;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shareholder.account
     *
     * @return the value of shareholder.account
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    public String getAccount() {
        return account;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shareholder.account
     *
     * @param account the value for shareholder.account
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shareholder.isdelete
     *
     * @return the value of shareholder.isdelete
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    public Integer getIsdelete() {
        return isdelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shareholder.isdelete
     *
     * @param isdelete the value for shareholder.isdelete
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }
}