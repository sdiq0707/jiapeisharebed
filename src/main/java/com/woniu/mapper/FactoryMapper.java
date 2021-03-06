package com.woniu.mapper;

import com.woniu.entity.Factory;
import com.woniu.entity.FactoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FactoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table factory
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    int countByExample(FactoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table factory
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    int deleteByExample(FactoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table factory
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    int deleteByPrimaryKey(Integer fid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table factory
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    int insert(Factory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table factory
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    int insertSelective(Factory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table factory
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    List<Factory> selectByExample(FactoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table factory
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    Factory selectByPrimaryKey(Integer fid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table factory
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    int updateByExampleSelective(@Param("record") Factory record, @Param("example") FactoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table factory
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    int updateByExample(@Param("record") Factory record, @Param("example") FactoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table factory
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    int updateByPrimaryKeySelective(Factory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table factory
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    int updateByPrimaryKey(Factory record);
}