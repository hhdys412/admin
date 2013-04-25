package com.hhdys.dao;

import com.hhdys.model.MenuTree;
import com.hhdys.model.MenuTreeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MenuTreeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu_tree
     *
     * @mbggenerated Thu Apr 25 14:14:55 CST 2013
     */
    int countByExample(MenuTreeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu_tree
     *
     * @mbggenerated Thu Apr 25 14:14:55 CST 2013
     */
    int deleteByExample(MenuTreeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu_tree
     *
     * @mbggenerated Thu Apr 25 14:14:55 CST 2013
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu_tree
     *
     * @mbggenerated Thu Apr 25 14:14:55 CST 2013
     */
    int insert(MenuTree record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu_tree
     *
     * @mbggenerated Thu Apr 25 14:14:55 CST 2013
     */
    int insertSelective(MenuTree record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu_tree
     *
     * @mbggenerated Thu Apr 25 14:14:55 CST 2013
     */
    List<MenuTree> selectByExample(MenuTreeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu_tree
     *
     * @mbggenerated Thu Apr 25 14:14:55 CST 2013
     */
    MenuTree selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu_tree
     *
     * @mbggenerated Thu Apr 25 14:14:55 CST 2013
     */
    int updateByExampleSelective(@Param("record") MenuTree record, @Param("example") MenuTreeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu_tree
     *
     * @mbggenerated Thu Apr 25 14:14:55 CST 2013
     */
    int updateByExample(@Param("record") MenuTree record, @Param("example") MenuTreeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu_tree
     *
     * @mbggenerated Thu Apr 25 14:14:55 CST 2013
     */
    int updateByPrimaryKeySelective(MenuTree record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu_tree
     *
     * @mbggenerated Thu Apr 25 14:14:55 CST 2013
     */
    int updateByPrimaryKey(MenuTree record);
}