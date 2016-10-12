package com.cc.framework.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;

import com.cc.framework.model.SysRoleAuthority;
import com.cc.framework.service.SysRoleAuthorityService;

@Service("sysRoleAuthority")
public class SysRoleAuthorityImpl extends BaseService<SysRoleAuthority> implements SysRoleAuthorityService{

	@Override
	public boolean save(List<SysRoleAuthority> authroies) {
		for(SysRoleAuthority auth:authroies){
			this.save(auth);
		}
		return true;
	}

	@Override
	public boolean delete(Long roleId) {
		List<SysRoleAuthority> authories = findAuthByRole(roleId);
		for(SysRoleAuthority auth:authories){
			this.delete(auth);
		}
		return true;
	}

	@Override
	public List<SysRoleAuthority> findAuthByRole(Long roleId) {
		Example e = new Example(SysRoleAuthority.class);
		e.createCriteria().andEqualTo("role", roleId);
		List<SysRoleAuthority> list = this.selectByExample(e);
		return list;
	}

}
