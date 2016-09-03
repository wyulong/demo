package com.cc.framework.model;

import javax.persistence.*;

@Table(name = "sys_role")
public class SysRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Byte seq;

    private String description;

    private Byte status;

    private String resources;

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
     * @return seq
     */
    public Byte getSeq() {
        return seq;
    }

    /**
     * @param seq
     */
    public void setSeq(Byte seq) {
        this.seq = seq;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return status
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * @return resources
     */
    public String getResources() {
        return resources;
    }

    /**
     * @param resources
     */
    public void setResources(String resources) {
        this.resources = resources;
    }
}