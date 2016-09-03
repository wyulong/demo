package com.cc.framework.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;

import com.cc.framework.dao.SysDictionariesMapper;
import com.cc.framework.model.SysDictionaries;
import com.cc.framework.service.SysDictionariesService;


@Service("sysDictionariesService")
public class SysDictionariesServiceImpl extends BaseService<SysDictionaries> implements SysDictionariesService{

	@Autowired
	private SysDictionariesMapper sysDictionariesMapper;
	
	@Override
	public List<SysDictionaries> getChildrenByCode(Long value) {
		Example condition = new Example(SysDictionaries.class);
		condition.createCriteria().andEqualTo("parentId", value);
		return this.getMapper().selectByExample(condition);
	}

}
