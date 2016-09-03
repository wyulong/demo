package com.cc.framework.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;

import com.cc.framework.dao.SysResourceMapper;
import com.cc.framework.model.Page;
import com.cc.framework.model.SysResource;
import com.cc.framework.service.SysResourceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("sysResourceService")
public class SysResourceServiceImpl extends BaseService<SysResource> implements SysResourceService{

	@Autowired
	private SysResourceMapper sysResourceMapper;
	
	@Override
	public long addResource(SysResource sysResource) {
		return sysResourceMapper.insert(sysResource);
	}

	@Override
	public PageInfo<SysResource> findResourceByPage(SysResource sysResource,
			int startRow,int pageSize) {
		PageHelper.startPage(startRow,pageSize);
		Example example = new Example(SysResource.class);
		example.createCriteria().andLike("name", sysResource.getName());
		List<SysResource> list = sysResourceMapper.selectByExample(example);
		return new PageInfo<SysResource>(list);
	}


	@Override
	public boolean removeResource(long resourceId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean disableResource(long resourceId) {
		// TODO Auto-generated method stub
		return false;
	}

}
