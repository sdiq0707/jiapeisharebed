package com.woniu.entity;

import java.util.Date;

public class Scrap {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column scrap.sid
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    private Integer sid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column scrap.stime
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    private Date stime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column scrap.bid
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    private Integer bid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column scrap.sid
     *
     * @return the value of scrap.sid
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    public Integer getSid() {
        return sid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column scrap.sid
     *
     * @param sid the value for scrap.sid
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    public void setSid(Integer sid) {
        this.sid = sid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column scrap.stime
     *
     * @return the value of scrap.stime
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    public Date getStime() {
        return stime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column scrap.stime
     *
     * @param stime the value for scrap.stime
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    public void setStime(Date stime) {
        this.stime = stime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column scrap.bid
     *
     * @return the value of scrap.bid
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    public Integer getBid() {
        return bid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column scrap.bid
     *
     * @param bid the value for scrap.bid
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    public void setBid(Integer bid) {
        this.bid = bid;
    }
}