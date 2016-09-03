package com.cc.framework.model;

import javax.persistence.*;

@Table(name = "sys_dictionaries")
public class SysDictionaries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "name_en")
    private String nameEn;

    private String bianma;

    @Column(name = "order_by")
    private Integer orderBy;

    @Column(name = "parent_id")
    private Long parentId;

    private String bz;

    private String tbsname;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return name_en
     */
    public String getNameEn() {
        return nameEn;
    }

    /**
     * @param nameEn
     */
    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    /**
     * @return bianma
     */
    public String getBianma() {
        return bianma;
    }

    /**
     * @param bianma
     */
    public void setBianma(String bianma) {
        this.bianma = bianma;
    }

    /**
     * @return order_by
     */
    public Integer getOrderBy() {
        return orderBy;
    }

    /**
     * @param orderBy
     */
    public void setOrderBy(Integer orderBy) {
        this.orderBy = orderBy;
    }

    /**
     * @return parent_id
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * @return bz
     */
    public String getBz() {
        return bz;
    }

    /**
     * @param bz
     */
    public void setBz(String bz) {
        this.bz = bz;
    }

    /**
     * @return tbsname
     */
    public String getTbsname() {
        return tbsname;
    }

    /**
     * @param tbsname
     */
    public void setTbsname(String tbsname) {
        this.tbsname = tbsname;
    }
}