package com.cc.framework.service;

import java.util.Collection;

import com.cc.framework.model.SysRole;

/**
 * Service - 角色
 * 
 */
public interface SysRoleService extends IService<SysRole> {

	Collection<? extends SysRole> findList(Long[] roleIds);

	void batchDelRoles(Long[] ids);

}