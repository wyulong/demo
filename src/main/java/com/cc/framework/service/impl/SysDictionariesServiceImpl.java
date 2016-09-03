package com.cc.framework.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;

import com.cc.framework.dao.SysDictionariesMapper;
import com.cc.framework.model.SysDictionaries;
import com.cc.framework.service.SysDictionariesService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("sysDictionariesService")
public class SysDictionariesServiceImpl extends BaseService<SysDictionaries>
		implements SysDictionariesService {

	@Autowired
	private SysDictionariesMapper sysDictionariesMapper;

	@Override
	public List<SysDictionaries> getChildrenByCode(Long value) {
		Example condition = new Example(SysDictionaries.class);
		condition.createCriteria().andEqualTo("parentId", value);
		return this.getMapper().selectByExample(condition);
	}

	@Override
	public List<SysDictionaries> getBycode(String code) {
		Example e = new Example(SysDictionaries.class);
		e.createCriteria().andEqualTo("bianma", code);
		List<SysDictionaries> list = this.getMapper().selectByExample(e);
		return list;
	}

	@Override
	public PageInfo<SysDictionaries> getChildrenByCodeAndPage(Long value,
			int pageNum, int limit) {
		Example condition = new Example(SysDictionaries.class);
		PageHelper.startPage(pageNum, limit);
		condition.createCriteria().andEqualTo("parentId", value);
		List<SysDictionaries> list = this.getMapper()
				.selectByExample(condition);
		return new PageInfo<SysDictionaries>(list);
	}

	@Override
	public boolean delSysDict(SysDictionaries dict) {
		if (dict != null) {
			List<SysDictionaries> list = getChildrenByCode(dict.getId());
			for (SysDictionaries temp : list) {
				delete(temp);
			}
			int i = delete(dict);
			if (i > 0)
				return true;
		}
		return false;
	}

}
