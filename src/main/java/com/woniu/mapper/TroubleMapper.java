package com.woniu.mapper;

import com.woniu.entity.Hospital;
import com.woniu.entity.Trouble;
import com.woniu.entity.TroubleExample;
import com.woniu.entity.TroubleSearchExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TroubleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trouble
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
	
	
    int countByExample(TroubleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trouble
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    int deleteByExample(TroubleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trouble
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    int deleteByPrimaryKey(Integer tid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trouble
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    int insert(Trouble record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trouble
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    int insertSelective(Trouble record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trouble
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    List<Trouble> selectByExample(TroubleExample example);
    List<Trouble> selectByExample(TroubleExample example,RowBounds rb);
    List<Trouble> search(TroubleSearchExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trouble
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    Trouble selectByPrimaryKey(Integer tid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trouble
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    int updateByExampleSelective(@Param("record") Trouble record, @Param("example") TroubleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trouble
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    int updateByExample(@Param("record") Trouble record, @Param("example") TroubleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trouble
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    int updateByPrimaryKeySelective(Trouble record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trouble
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    int updateByPrimaryKey(Trouble record);
}