package com.cc.framework.service;

import com.cc.framework.model.SysResource;
import com.github.pagehelper.PageInfo;

public interface SysResourceService extends IService<SysResource>{
	
	public long addResource(SysResource sysResource);
	
	public PageInfo<SysResource> findResourceByPage(SysResource sysResource,int startRow,int pageSize);
	
	public boolean removeResource(long resourceId);
	
	public boolean disableResource(long resourceId);
}
