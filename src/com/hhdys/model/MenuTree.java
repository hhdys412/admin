package com.hhdys.model;

public class MenuTree {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menu_tree.id
     *
     * @mbggenerated Thu Apr 25 14:14:55 CST 2013
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menu_tree.name
     *
     * @mbggenerated Thu Apr 25 14:14:55 CST 2013
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menu_tree.url
     *
     * @mbggenerated Thu Apr 25 14:14:55 CST 2013
     */
    private String url;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menu_tree.parent_id
     *
     * @mbggenerated Thu Apr 25 14:14:55 CST 2013
     */
    private int parentId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menu_tree.is_show
     *
     * @mbggenerated Thu Apr 25 14:14:55 CST 2013
     */
    private int isShow;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menu_tree.id
     *
     * @return the value of menu_tree.id
     *
     * @mbggenerated Thu Apr 25 14:14:55 CST 2013
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menu_tree.id
     *
     * @param id the value for menu_tree.id
     *
     * @mbggenerated Thu Apr 25 14:14:55 CST 2013
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menu_tree.name
     *
     * @return the value of menu_tree.name
     *
     * @mbggenerated Thu Apr 25 14:14:55 CST 2013
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menu_tree.name
     *
     * @param name the value for menu_tree.name
     *
     * @mbggenerated Thu Apr 25 14:14:55 CST 2013
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menu_tree.url
     *
     * @return the value of menu_tree.url
     *
     * @mbggenerated Thu Apr 25 14:14:55 CST 2013
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menu_tree.url
     *
     * @param url the value for menu_tree.url
     *
     * @mbggenerated Thu Apr 25 14:14:55 CST 2013
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menu_tree.parent_id
     *
     * @return the value of menu_tree.parent_id
     *
     * @mbggenerated Thu Apr 25 14:14:55 CST 2013
     */
    public int getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menu_tree.parent_id
     *
     * @param parentId the value for menu_tree.parent_id
     *
     * @mbggenerated Thu Apr 25 14:14:55 CST 2013
     */
    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menu_tree.is_show
     *
     * @return the value of menu_tree.is_show
     *
     * @mbggenerated Thu Apr 25 14:14:55 CST 2013
     */
    public int getIsShow() {
        return isShow;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menu_tree.is_show
     *
     * @param isShow the value for menu_tree.is_show
     *
     * @mbggenerated Thu Apr 25 14:14:55 CST 2013
     */
    public void setIsShow(int isShow) {
        this.isShow = isShow;
    }
}