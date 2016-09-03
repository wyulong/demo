package com.cc.framework.service;

import java.util.List;

import com.cc.framework.model.SysDictionaries;

public interface SysDictionariesService extends IService<SysDictionaries>{

	List<SysDictionaries> getChildrenByCode(Long value);

}
