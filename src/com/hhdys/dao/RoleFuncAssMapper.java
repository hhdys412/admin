package com.hhdys.dao;

import com.hhdys.model.RoleFuncAss;
import com.hhdys.model.RoleFuncAssExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleFuncAssMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_func_ass
     *
     * @mbggenerated Mon Aug 19 14:24:20 CST 2013
     */
    int countByExample(RoleFuncAssExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_func_ass
     *
     * @mbggenerated Mon Aug 19 14:24:20 CST 2013
     */
    int deleteByExample(RoleFuncAssExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_func_ass
     *
     * @mbggenerated Mon Aug 19 14:24:20 CST 2013
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_func_ass
     *
     * @mbggenerated Mon Aug 19 14:24:20 CST 2013
     */
    int insert(RoleFuncAss record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_func_ass
     *
     * @mbggenerated Mon Aug 19 14:24:20 CST 2013
     */
    int insertSelective(RoleFuncAss record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_func_ass
     *
     * @mbggenerated Mon Aug 19 14:24:20 CST 2013
     */
    List<RoleFuncAss> selectByExample(RoleFuncAssExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_func_ass
     *
     * @mbggenerated Mon Aug 19 14:24:20 CST 2013
     */
    RoleFuncAss selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_func_ass
     *
     * @mbggenerated Mon Aug 19 14:24:20 CST 2013
     */
    int updateByExampleSelective(@Param("record") RoleFuncAss record, @Param("example") RoleFuncAssExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_func_ass
     *
     * @mbggenerated Mon Aug 19 14:24:20 CST 2013
     */
    int updateByExample(@Param("record") RoleFuncAss record, @Param("example") RoleFuncAssExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_func_ass
     *
     * @mbggenerated Mon Aug 19 14:24:20 CST 2013
     */
    int updateByPrimaryKeySelective(RoleFuncAss record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_func_ass
     *
     * @mbggenerated Mon Aug 19 14:24:20 CST 2013
     */
    int updateByPrimaryKey(RoleFuncAss record);
}