package com.cc.framework.model;

import javax.persistence.*;

@Table(name = "sys_role_authority")
public class SysRoleAuthority {
    private Long role;

    private String authorities;

    /**
     * @return role
     */
    public Long getRole() {
        return role;
    }

    /**
     * @param role
     */
    public void setRole(Long role) {
        this.role = role;
    }

    /**
     * @return authorities
     */
    public String getAuthorities() {
        return authorities;
    }

    /**
     * @param authorities
     */
    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }
}