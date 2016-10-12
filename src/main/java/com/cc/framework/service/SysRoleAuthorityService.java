package com.cc.framework.service;

import java.util.List;

import com.cc.framework.model.SysRoleAuthority;

public interface SysRoleAuthorityService extends IService<SysRoleAuthority>{
	
	public boolean save(List<SysRoleAuthority> authroies);
	
	public boolean delete(Long roleId);
	
	public List<SysRoleAuthority> findAuthByRole(Long roleId);
}
