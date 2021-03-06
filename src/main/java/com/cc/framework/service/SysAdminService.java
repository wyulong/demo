/*
 * Copyright 2005-2013 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 */
package com.cc.framework.service;

import java.util.List;
import java.util.Set;

import com.cc.framework.model.SysAdmin;
import com.cc.framework.model.SysRole;

/**
 * Service - 管理员
 * 
 * @author SHOP++ Team
 * @version 3.0
 */
public interface SysAdminService extends IService<SysAdmin> {

	/**
	 * 判断用户名是否存在
	 * 
	 * @param username
	 *            用户名(忽略大小写)
	 * @return 用户名是否存在
	 */
	boolean usernameExists(String username);
	
	boolean saveUserAndRole(SysAdmin admin,Set<SysRole> adminRoles);

	/**
	 * 根据用户名查找管理员
	 * 
	 * @param username
	 *            用户名(忽略大小写)
	 * @return 管理员，若不存在则返回null
	 */
	SysAdmin findByUsername(String username);

	/**
	 * 根据ID查找权限
	 * 
	 * @param id
	 *            ID
	 * @return 权限,若不存在则返回null
	 *//*
	List<String> findAuthorities(Long id);

	*//**
	 * 判断管理员是否登录
	 * 
	 * @return 管理员是否登录
	 *//*
	boolean isAuthenticated();

	*//**
	 * 获取当前登录管理员
	 * 
	 * @return 当前登录管理员,若不存在则返回null
	 *//*
	SysAdmin getCurrent();

	*//**
	 * 获取当前登录用户名
	 * 
	 * @return 当前登录用户名,若不存在则返回null
	 *//*
	String getCurrentUsername();
*/
	
	SysAdmin find(Long id);

	void update(SysAdmin admin, Set<SysRole> roles);

	void batchDelAdmins(Long[] ids);

	/**
	 * 查询用户所有权限
	 * @param id
	 * @return
	 */
	List<String> findAuthorities(Long id);

}