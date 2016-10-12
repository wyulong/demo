package com.cc.framework.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tk.mybatis.mapper.common.Mapper;

import com.cc.framework.service.IService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public abstract class BaseService<T> implements IService<T> {

    @Override
	public boolean batchDel(Object... ids) {
    	for(Object key:ids){
    		mapper.deleteByPrimaryKey(key);
    	}
    	return true;
	}

	@Override
	public PageInfo<T> selectByPage(T t,int startRow,int pageSize) {
    	PageHelper.startPage(startRow,pageSize);
    	return new PageInfo<T>(mapper.select(t));
	}

	@Autowired
    protected Mapper<T> mapper;

    public Mapper<T> getMapper() {
        return mapper;
    }

    @Override
    public T selectByKey(Object key) {
        return mapper.selectByPrimaryKey(key);
    }

    public int save(T entity) {
        return mapper.insert(entity);
    }

    public int delete(Object key) {
        return mapper.deleteByPrimaryKey(key);
    }
    
    public int updateAll(T entity) {
        return mapper.updateByPrimaryKey(entity);
    }

    public int updateNotNull(T entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }

    public List<T> selectByExample(Object example) {
        return mapper.selectByExample(example);
    }
    
    public List<T> findAll(){
    	return mapper.selectAll();
    }

    //TODO 其他...
}
