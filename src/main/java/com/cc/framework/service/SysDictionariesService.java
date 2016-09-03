package com.cc.framework.service;

import java.util.List;

import com.cc.framework.model.SysDictionaries;
import com.github.pagehelper.PageInfo;

public interface SysDictionariesService extends IService<SysDictionaries>{

	List<SysDictionaries> getChildrenByCode(Long value);
	
	PageInfo<SysDictionaries> getChildrenByCodeAndPage(Long value,int pageNum,int limit);
	
	List<SysDictionaries> getBycode(String code);

	boolean delSysDict(SysDictionaries dict);
}
