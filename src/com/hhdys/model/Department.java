package com.hhdys.model;

public class Department {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column department.id
     *
     * @mbggenerated Thu Apr 25 14:07:26 CST 2013
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column department.name
     *
     * @mbggenerated Thu Apr 25 14:07:26 CST 2013
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column department.parent_id
     *
     * @mbggenerated Thu Apr 25 14:07:26 CST 2013
     */
    private int parentId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column department.id
     *
     * @return the value of department.id
     *
     * @mbggenerated Thu Apr 25 14:07:26 CST 2013
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column department.id
     *
     * @param id the value for department.id
     *
     * @mbggenerated Thu Apr 25 14:07:26 CST 2013
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column department.name
     *
     * @return the value of department.name
     *
     * @mbggenerated Thu Apr 25 14:07:26 CST 2013
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column department.name
     *
     * @param name the value for department.name
     *
     * @mbggenerated Thu Apr 25 14:07:26 CST 2013
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column department.parent_id
     *
     * @return the value of department.parent_id
     *
     * @mbggenerated Thu Apr 25 14:07:26 CST 2013
     */
    public int getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column department.parent_id
     *
     * @param parentId the value for department.parent_id
     *
     * @mbggenerated Thu Apr 25 14:07:26 CST 2013
     */
    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
}