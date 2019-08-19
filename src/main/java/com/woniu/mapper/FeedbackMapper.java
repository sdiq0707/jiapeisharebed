package com.woniu.mapper;

import com.woniu.entity.Feedback;
import com.woniu.entity.FeedbackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FeedbackMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feedback
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    int countByExample(FeedbackExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feedback
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    int deleteByExample(FeedbackExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feedback
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    int deleteByPrimaryKey(Integer fid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feedback
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    int insert(Feedback record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feedback
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    int insertSelective(Feedback record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feedback
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    List<Feedback> selectByExample(FeedbackExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feedback
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    Feedback selectByPrimaryKey(Integer fid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feedback
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    int updateByExampleSelective(@Param("record") Feedback record, @Param("example") FeedbackExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feedback
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    int updateByExample(@Param("record") Feedback record, @Param("example") FeedbackExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feedback
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    int updateByPrimaryKeySelective(Feedback record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feedback
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    int updateByPrimaryKey(Feedback record);
}