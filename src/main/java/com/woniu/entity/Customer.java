package com.woniu.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Customer {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.cid
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    private Integer cid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.cname
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    private String cname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.phone
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    private String phone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.sex
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    private String sex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.cpass
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    private String cpass;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.cnickname
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    private String cnickname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.regtime
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    private Date regtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.isdeposit
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    private Integer isdeposit;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.balance
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    private BigDecimal balance;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.ordertimes
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    private Integer ordertimes;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.sumconsume
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    private Integer sumconsume;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.isdelete
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    private Integer isdelete;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.cid
     *
     * @return the value of customer.cid
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    public Integer getCid() {
        return cid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.cid
     *
     * @param cid the value for customer.cid
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    public void setCid(Integer cid) {
        this.cid = cid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.cname
     *
     * @return the value of customer.cname
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    public String getCname() {
        return cname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.cname
     *
     * @param cname the value for customer.cname
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    public void setCname(String cname) {
        this.cname = cname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.phone
     *
     * @return the value of customer.phone
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.phone
     *
     * @param phone the value for customer.phone
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.sex
     *
     * @return the value of customer.sex
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    public String getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.sex
     *
     * @param sex the value for customer.sex
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.cpass
     *
     * @return the value of customer.cpass
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    public String getCpass() {
        return cpass;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.cpass
     *
     * @param cpass the value for customer.cpass
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    public void setCpass(String cpass) {
        this.cpass = cpass;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.cnickname
     *
     * @return the value of customer.cnickname
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    public String getCnickname() {
        return cnickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.cnickname
     *
     * @param cnickname the value for customer.cnickname
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    public void setCnickname(String cnickname) {
        this.cnickname = cnickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.regtime
     *
     * @return the value of customer.regtime
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    public Date getRegtime() {
        return regtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.regtime
     *
     * @param regtime the value for customer.regtime
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    public void setRegtime(Date regtime) {
        this.regtime = regtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.isdeposit
     *
     * @return the value of customer.isdeposit
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    public Integer getIsdeposit() {
        return isdeposit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.isdeposit
     *
     * @param isdeposit the value for customer.isdeposit
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    public void setIsdeposit(Integer isdeposit) {
        this.isdeposit = isdeposit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.balance
     *
     * @return the value of customer.balance
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.balance
     *
     * @param balance the value for customer.balance
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.ordertimes
     *
     * @return the value of customer.ordertimes
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    public Integer getOrdertimes() {
        return ordertimes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.ordertimes
     *
     * @param ordertimes the value for customer.ordertimes
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    public void setOrdertimes(Integer ordertimes) {
        this.ordertimes = ordertimes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.sumconsume
     *
     * @return the value of customer.sumconsume
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    public Integer getSumconsume() {
        return sumconsume;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.sumconsume
     *
     * @param sumconsume the value for customer.sumconsume
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    public void setSumconsume(Integer sumconsume) {
        this.sumconsume = sumconsume;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.isdelete
     *
     * @return the value of customer.isdelete
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    public Integer getIsdelete() {
        return isdelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.isdelete
     *
     * @param isdelete the value for customer.isdelete
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }
}