package com.cc.framework.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;

import com.cc.framework.dao.SysAdminRoleMapper;
import com.cc.framework.dao.SysRoleAuthorityMapper;
import com.cc.framework.model.SysAdminRole;
import com.cc.framework.model.SysRole;
import com.cc.framework.model.SysRoleAuthority;
import com.cc.framework.service.SysRoleService;


@Service("sysRoleService")
public class SysRoleServiceImpl extends BaseService<SysRole> implements SysRoleService{

	@Autowired
	private SysRoleAuthorityMapper sysRoleAuthorityMapper;
	
	@Autowired
	private SysAdminRoleMapper sysAdminRoleMapper;
	
	@Override
	public Collection<? extends SysRole> findList(Long[] roleIds) {
		List<Long> ids = new ArrayList<Long>();
		for(Long id:roleIds){
			ids.add(id);
		}
		Example e = new Example(SysRole.class);
		e.createCriteria().andIn("id", ids);
		return this.selectByExample(e);
	}

	@Override
	public void batchDelRoles(Long[] ids) {
		for(Long id:ids){
			Example e = new Example(SysAdminRole.class);
			e.createCriteria().andEqualTo("roles", id);
			List<SysAdminRole> list = sysAdminRoleMapper.selectByExample(e);
			for(SysAdminRole adminrole:list){
				sysAdminRoleMapper.delete(adminrole);
			}
			e = new Example(SysRoleAuthority.class);
			e.createCriteria().andEqualTo("role",id);
			List<SysRoleAuthority> list2 = sysRoleAuthorityMapper.selectByExample(e);
			for(SysRoleAuthority auth:list2){
				sysRoleAuthorityMapper.delete(auth);
			}
		}
		this.batchDel(ids);
	}

}
