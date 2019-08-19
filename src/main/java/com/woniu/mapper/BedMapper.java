package com.woniu.mapper;

import com.woniu.entity.Bed;
import com.woniu.entity.BedExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BedMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bed
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    int countByExample(BedExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bed
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    int deleteByExample(BedExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bed
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    int deleteByPrimaryKey(Integer bid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bed
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    int insert(Bed record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bed
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    int insertSelective(Bed record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bed
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    List<Bed> selectByExample(BedExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bed
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    Bed selectByPrimaryKey(Integer bid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bed
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    int updateByExampleSelective(@Param("record") Bed record, @Param("example") BedExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bed
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    int updateByExample(@Param("record") Bed record, @Param("example") BedExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bed
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    int updateByPrimaryKeySelective(Bed record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bed
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    int updateByPrimaryKey(Bed record);
}