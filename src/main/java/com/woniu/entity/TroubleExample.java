package com.woniu.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TroubleExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table trouble
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table trouble
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table trouble
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trouble
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    public TroubleExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trouble
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trouble
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trouble
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trouble
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trouble
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trouble
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trouble
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trouble
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trouble
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trouble
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table trouble
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andTidIsNull() {
            addCriterion("tid is null");
            return (Criteria) this;
        }

        public Criteria andTidIsNotNull() {
            addCriterion("tid is not null");
            return (Criteria) this;
        }

        public Criteria andTidEqualTo(Integer value) {
            addCriterion("tid =", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotEqualTo(Integer value) {
            addCriterion("tid <>", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThan(Integer value) {
            addCriterion("tid >", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThanOrEqualTo(Integer value) {
            addCriterion("tid >=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThan(Integer value) {
            addCriterion("tid <", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThanOrEqualTo(Integer value) {
            addCriterion("tid <=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidIn(List<Integer> values) {
            addCriterion("tid in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotIn(List<Integer> values) {
            addCriterion("tid not in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidBetween(Integer value1, Integer value2) {
            addCriterion("tid between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotBetween(Integer value1, Integer value2) {
            addCriterion("tid not between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andTtitleIsNull() {
            addCriterion("ttitle is null");
            return (Criteria) this;
        }

        public Criteria andTtitleIsNotNull() {
            addCriterion("ttitle is not null");
            return (Criteria) this;
        }

        public Criteria andTtitleEqualTo(String value) {
            addCriterion("ttitle =", value, "ttitle");
            return (Criteria) this;
        }

        public Criteria andTtitleNotEqualTo(String value) {
            addCriterion("ttitle <>", value, "ttitle");
            return (Criteria) this;
        }

        public Criteria andTtitleGreaterThan(String value) {
            addCriterion("ttitle >", value, "ttitle");
            return (Criteria) this;
        }

        public Criteria andTtitleGreaterThanOrEqualTo(String value) {
            addCriterion("ttitle >=", value, "ttitle");
            return (Criteria) this;
        }

        public Criteria andTtitleLessThan(String value) {
            addCriterion("ttitle <", value, "ttitle");
            return (Criteria) this;
        }

        public Criteria andTtitleLessThanOrEqualTo(String value) {
            addCriterion("ttitle <=", value, "ttitle");
            return (Criteria) this;
        }

        public Criteria andTtitleLike(String value) {
            addCriterion("ttitle like", value, "ttitle");
            return (Criteria) this;
        }

        public Criteria andTtitleNotLike(String value) {
            addCriterion("ttitle not like", value, "ttitle");
            return (Criteria) this;
        }

        public Criteria andTtitleIn(List<String> values) {
            addCriterion("ttitle in", values, "ttitle");
            return (Criteria) this;
        }

        public Criteria andTtitleNotIn(List<String> values) {
            addCriterion("ttitle not in", values, "ttitle");
            return (Criteria) this;
        }

        public Criteria andTtitleBetween(String value1, String value2) {
            addCriterion("ttitle between", value1, value2, "ttitle");
            return (Criteria) this;
        }

        public Criteria andTtitleNotBetween(String value1, String value2) {
            addCriterion("ttitle not between", value1, value2, "ttitle");
            return (Criteria) this;
        }

        public Criteria andTdescribeIsNull() {
            addCriterion("tdescribe is null");
            return (Criteria) this;
        }

        public Criteria andTdescribeIsNotNull() {
            addCriterion("tdescribe is not null");
            return (Criteria) this;
        }

        public Criteria andTdescribeEqualTo(String value) {
            addCriterion("tdescribe =", value, "tdescribe");
            return (Criteria) this;
        }

        public Criteria andTdescribeNotEqualTo(String value) {
            addCriterion("tdescribe <>", value, "tdescribe");
            return (Criteria) this;
        }

        public Criteria andTdescribeGreaterThan(String value) {
            addCriterion("tdescribe >", value, "tdescribe");
            return (Criteria) this;
        }

        public Criteria andTdescribeGreaterThanOrEqualTo(String value) {
            addCriterion("tdescribe >=", value, "tdescribe");
            return (Criteria) this;
        }

        public Criteria andTdescribeLessThan(String value) {
            addCriterion("tdescribe <", value, "tdescribe");
            return (Criteria) this;
        }

        public Criteria andTdescribeLessThanOrEqualTo(String value) {
            addCriterion("tdescribe <=", value, "tdescribe");
            return (Criteria) this;
        }

        public Criteria andTdescribeLike(String value) {
            addCriterion("tdescribe like", value, "tdescribe");
            return (Criteria) this;
        }

        public Criteria andTdescribeNotLike(String value) {
            addCriterion("tdescribe not like", value, "tdescribe");
            return (Criteria) this;
        }

        public Criteria andTdescribeIn(List<String> values) {
            addCriterion("tdescribe in", values, "tdescribe");
            return (Criteria) this;
        }

        public Criteria andTdescribeNotIn(List<String> values) {
            addCriterion("tdescribe not in", values, "tdescribe");
            return (Criteria) this;
        }

        public Criteria andTdescribeBetween(String value1, String value2) {
            addCriterion("tdescribe between", value1, value2, "tdescribe");
            return (Criteria) this;
        }

        public Criteria andTdescribeNotBetween(String value1, String value2) {
            addCriterion("tdescribe not between", value1, value2, "tdescribe");
            return (Criteria) this;
        }

        public Criteria andTtypeIsNull() {
            addCriterion("ttype is null");
            return (Criteria) this;
        }

        public Criteria andTtypeIsNotNull() {
            addCriterion("ttype is not null");
            return (Criteria) this;
        }

        public Criteria andTtypeEqualTo(String value) {
            addCriterion("ttype =", value, "ttype");
            return (Criteria) this;
        }

        public Criteria andTtypeNotEqualTo(String value) {
            addCriterion("ttype <>", value, "ttype");
            return (Criteria) this;
        }

        public Criteria andTtypeGreaterThan(String value) {
            addCriterion("ttype >", value, "ttype");
            return (Criteria) this;
        }

        public Criteria andTtypeGreaterThanOrEqualTo(String value) {
            addCriterion("ttype >=", value, "ttype");
            return (Criteria) this;
        }

        public Criteria andTtypeLessThan(String value) {
            addCriterion("ttype <", value, "ttype");
            return (Criteria) this;
        }

        public Criteria andTtypeLessThanOrEqualTo(String value) {
            addCriterion("ttype <=", value, "ttype");
            return (Criteria) this;
        }

        public Criteria andTtypeLike(String value) {
            addCriterion("ttype like", value, "ttype");
            return (Criteria) this;
        }

        public Criteria andTtypeNotLike(String value) {
            addCriterion("ttype not like", value, "ttype");
            return (Criteria) this;
        }

        public Criteria andTtypeIn(List<String> values) {
            addCriterion("ttype in", values, "ttype");
            return (Criteria) this;
        }

        public Criteria andTtypeNotIn(List<String> values) {
            addCriterion("ttype not in", values, "ttype");
            return (Criteria) this;
        }

        public Criteria andTtypeBetween(String value1, String value2) {
            addCriterion("ttype between", value1, value2, "ttype");
            return (Criteria) this;
        }

        public Criteria andTtypeNotBetween(String value1, String value2) {
            addCriterion("ttype not between", value1, value2, "ttype");
            return (Criteria) this;
        }

        public Criteria andTdeclarantIsNull() {
            addCriterion("tdeclarant is null");
            return (Criteria) this;
        }

        public Criteria andTdeclarantIsNotNull() {
            addCriterion("tdeclarant is not null");
            return (Criteria) this;
        }

        public Criteria andTdeclarantEqualTo(String value) {
            addCriterion("tdeclarant =", value, "tdeclarant");
            return (Criteria) this;
        }

        public Criteria andTdeclarantNotEqualTo(String value) {
            addCriterion("tdeclarant <>", value, "tdeclarant");
            return (Criteria) this;
        }

        public Criteria andTdeclarantGreaterThan(String value) {
            addCriterion("tdeclarant >", value, "tdeclarant");
            return (Criteria) this;
        }

        public Criteria andTdeclarantGreaterThanOrEqualTo(String value) {
            addCriterion("tdeclarant >=", value, "tdeclarant");
            return (Criteria) this;
        }

        public Criteria andTdeclarantLessThan(String value) {
            addCriterion("tdeclarant <", value, "tdeclarant");
            return (Criteria) this;
        }

        public Criteria andTdeclarantLessThanOrEqualTo(String value) {
            addCriterion("tdeclarant <=", value, "tdeclarant");
            return (Criteria) this;
        }

        public Criteria andTdeclarantLike(String value) {
            addCriterion("tdeclarant like", value, "tdeclarant");
            return (Criteria) this;
        }

        public Criteria andTdeclarantNotLike(String value) {
            addCriterion("tdeclarant not like", value, "tdeclarant");
            return (Criteria) this;
        }

        public Criteria andTdeclarantIn(List<String> values) {
            addCriterion("tdeclarant in", values, "tdeclarant");
            return (Criteria) this;
        }

        public Criteria andTdeclarantNotIn(List<String> values) {
            addCriterion("tdeclarant not in", values, "tdeclarant");
            return (Criteria) this;
        }

        public Criteria andTdeclarantBetween(String value1, String value2) {
            addCriterion("tdeclarant between", value1, value2, "tdeclarant");
            return (Criteria) this;
        }

        public Criteria andTdeclarantNotBetween(String value1, String value2) {
            addCriterion("tdeclarant not between", value1, value2, "tdeclarant");
            return (Criteria) this;
        }

        public Criteria andDeclarantphoneIsNull() {
            addCriterion("declarantphone is null");
            return (Criteria) this;
        }

        public Criteria andDeclarantphoneIsNotNull() {
            addCriterion("declarantphone is not null");
            return (Criteria) this;
        }

        public Criteria andDeclarantphoneEqualTo(String value) {
            addCriterion("declarantphone =", value, "declarantphone");
            return (Criteria) this;
        }

        public Criteria andDeclarantphoneNotEqualTo(String value) {
            addCriterion("declarantphone <>", value, "declarantphone");
            return (Criteria) this;
        }

        public Criteria andDeclarantphoneGreaterThan(String value) {
            addCriterion("declarantphone >", value, "declarantphone");
            return (Criteria) this;
        }

        public Criteria andDeclarantphoneGreaterThanOrEqualTo(String value) {
            addCriterion("declarantphone >=", value, "declarantphone");
            return (Criteria) this;
        }

        public Criteria andDeclarantphoneLessThan(String value) {
            addCriterion("declarantphone <", value, "declarantphone");
            return (Criteria) this;
        }

        public Criteria andDeclarantphoneLessThanOrEqualTo(String value) {
            addCriterion("declarantphone <=", value, "declarantphone");
            return (Criteria) this;
        }

        public Criteria andDeclarantphoneLike(String value) {
            addCriterion("declarantphone like", value, "declarantphone");
            return (Criteria) this;
        }

        public Criteria andDeclarantphoneNotLike(String value) {
            addCriterion("declarantphone not like", value, "declarantphone");
            return (Criteria) this;
        }

        public Criteria andDeclarantphoneIn(List<String> values) {
            addCriterion("declarantphone in", values, "declarantphone");
            return (Criteria) this;
        }

        public Criteria andDeclarantphoneNotIn(List<String> values) {
            addCriterion("declarantphone not in", values, "declarantphone");
            return (Criteria) this;
        }

        public Criteria andDeclarantphoneBetween(String value1, String value2) {
            addCriterion("declarantphone between", value1, value2, "declarantphone");
            return (Criteria) this;
        }

        public Criteria andDeclarantphoneNotBetween(String value1, String value2) {
            addCriterion("declarantphone not between", value1, value2, "declarantphone");
            return (Criteria) this;
        }

        public Criteria andTstatusIsNull() {
            addCriterion("tstatus is null");
            return (Criteria) this;
        }

        public Criteria andTstatusIsNotNull() {
            addCriterion("tstatus is not null");
            return (Criteria) this;
        }

        public Criteria andTstatusEqualTo(Boolean value) {
            addCriterion("tstatus =", value, "tstatus");
            return (Criteria) this;
        }

        public Criteria andTstatusNotEqualTo(Boolean value) {
            addCriterion("tstatus <>", value, "tstatus");
            return (Criteria) this;
        }

        public Criteria andTstatusGreaterThan(Boolean value) {
            addCriterion("tstatus >", value, "tstatus");
            return (Criteria) this;
        }

        public Criteria andTstatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("tstatus >=", value, "tstatus");
            return (Criteria) this;
        }

        public Criteria andTstatusLessThan(Boolean value) {
            addCriterion("tstatus <", value, "tstatus");
            return (Criteria) this;
        }

        public Criteria andTstatusLessThanOrEqualTo(Boolean value) {
            addCriterion("tstatus <=", value, "tstatus");
            return (Criteria) this;
        }

        public Criteria andTstatusIn(List<Boolean> values) {
            addCriterion("tstatus in", values, "tstatus");
            return (Criteria) this;
        }

        public Criteria andTstatusNotIn(List<Boolean> values) {
            addCriterion("tstatus not in", values, "tstatus");
            return (Criteria) this;
        }

        public Criteria andTstatusBetween(Boolean value1, Boolean value2) {
            addCriterion("tstatus between", value1, value2, "tstatus");
            return (Criteria) this;
        }

        public Criteria andTstatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("tstatus not between", value1, value2, "tstatus");
            return (Criteria) this;
        }

        public Criteria andTdeclaretimeIsNull() {
            addCriterion("tdeclaretime is null");
            return (Criteria) this;
        }

        public Criteria andTdeclaretimeIsNotNull() {
            addCriterion("tdeclaretime is not null");
            return (Criteria) this;
        }

        public Criteria andTdeclaretimeEqualTo(Date value) {
            addCriterion("tdeclaretime =", value, "tdeclaretime");
            return (Criteria) this;
        }

        public Criteria andTdeclaretimeNotEqualTo(Date value) {
            addCriterion("tdeclaretime <>", value, "tdeclaretime");
            return (Criteria) this;
        }

        public Criteria andTdeclaretimeGreaterThan(Date value) {
            addCriterion("tdeclaretime >", value, "tdeclaretime");
            return (Criteria) this;
        }

        public Criteria andTdeclaretimeGreaterThanOrEqualTo(Date value) {
            addCriterion("tdeclaretime >=", value, "tdeclaretime");
            return (Criteria) this;
        }

        public Criteria andTdeclaretimeLessThan(Date value) {
            addCriterion("tdeclaretime <", value, "tdeclaretime");
            return (Criteria) this;
        }

        public Criteria andTdeclaretimeLessThanOrEqualTo(Date value) {
            addCriterion("tdeclaretime <=", value, "tdeclaretime");
            return (Criteria) this;
        }

        public Criteria andTdeclaretimeIn(List<Date> values) {
            addCriterion("tdeclaretime in", values, "tdeclaretime");
            return (Criteria) this;
        }

        public Criteria andTdeclaretimeNotIn(List<Date> values) {
            addCriterion("tdeclaretime not in", values, "tdeclaretime");
            return (Criteria) this;
        }

        public Criteria andTdeclaretimeBetween(Date value1, Date value2) {
            addCriterion("tdeclaretime between", value1, value2, "tdeclaretime");
            return (Criteria) this;
        }

        public Criteria andTdeclaretimeNotBetween(Date value1, Date value2) {
            addCriterion("tdeclaretime not between", value1, value2, "tdeclaretime");
            return (Criteria) this;
        }

        public Criteria andBidIsNull() {
            addCriterion("bid is null");
            return (Criteria) this;
        }

        public Criteria andBidIsNotNull() {
            addCriterion("bid is not null");
            return (Criteria) this;
        }

        public Criteria andBidEqualTo(Integer value) {
            addCriterion("bid =", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotEqualTo(Integer value) {
            addCriterion("bid <>", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidGreaterThan(Integer value) {
            addCriterion("bid >", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidGreaterThanOrEqualTo(Integer value) {
            addCriterion("bid >=", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidLessThan(Integer value) {
            addCriterion("bid <", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidLessThanOrEqualTo(Integer value) {
            addCriterion("bid <=", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidIn(List<Integer> values) {
            addCriterion("bid in", values, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotIn(List<Integer> values) {
            addCriterion("bid not in", values, "bid");
            return (Criteria) this;
        }

        public Criteria andBidBetween(Integer value1, Integer value2) {
            addCriterion("bid between", value1, value2, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotBetween(Integer value1, Integer value2) {
            addCriterion("bid not between", value1, value2, "bid");
            return (Criteria) this;
        }

        public Criteria andIsdeclareIsNull() {
            addCriterion("isdeclare is null");
            return (Criteria) this;
        }

        public Criteria andIsdeclareIsNotNull() {
            addCriterion("isdeclare is not null");
            return (Criteria) this;
        }

        public Criteria andIsdeclareEqualTo(Boolean value) {
            addCriterion("isdeclare =", value, "isdeclare");
            return (Criteria) this;
        }

        public Criteria andIsdeclareNotEqualTo(Boolean value) {
            addCriterion("isdeclare <>", value, "isdeclare");
            return (Criteria) this;
        }

        public Criteria andIsdeclareGreaterThan(Boolean value) {
            addCriterion("isdeclare >", value, "isdeclare");
            return (Criteria) this;
        }

        public Criteria andIsdeclareGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isdeclare >=", value, "isdeclare");
            return (Criteria) this;
        }

        public Criteria andIsdeclareLessThan(Boolean value) {
            addCriterion("isdeclare <", value, "isdeclare");
            return (Criteria) this;
        }

        public Criteria andIsdeclareLessThanOrEqualTo(Boolean value) {
            addCriterion("isdeclare <=", value, "isdeclare");
            return (Criteria) this;
        }

        public Criteria andIsdeclareIn(List<Boolean> values) {
            addCriterion("isdeclare in", values, "isdeclare");
            return (Criteria) this;
        }

        public Criteria andIsdeclareNotIn(List<Boolean> values) {
            addCriterion("isdeclare not in", values, "isdeclare");
            return (Criteria) this;
        }

        public Criteria andIsdeclareBetween(Boolean value1, Boolean value2) {
            addCriterion("isdeclare between", value1, value2, "isdeclare");
            return (Criteria) this;
        }

        public Criteria andIsdeclareNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isdeclare not between", value1, value2, "isdeclare");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIsNull() {
            addCriterion("isdelete is null");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIsNotNull() {
            addCriterion("isdelete is not null");
            return (Criteria) this;
        }

        public Criteria andIsdeleteEqualTo(Integer value) {
            addCriterion("isdelete =", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotEqualTo(Integer value) {
            addCriterion("isdelete <>", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteGreaterThan(Integer value) {
            addCriterion("isdelete >", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("isdelete >=", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLessThan(Integer value) {
            addCriterion("isdelete <", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLessThanOrEqualTo(Integer value) {
            addCriterion("isdelete <=", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIn(List<Integer> values) {
            addCriterion("isdelete in", values, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotIn(List<Integer> values) {
            addCriterion("isdelete not in", values, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteBetween(Integer value1, Integer value2) {
            addCriterion("isdelete between", value1, value2, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("isdelete not between", value1, value2, "isdelete");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table trouble
     *
     * @mbggenerated do_not_delete_during_merge Mon Aug 19 15:25:36 CST 2019
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table trouble
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}