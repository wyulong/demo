package com.cc.framework.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

public interface IService<T> {

    T selectByKey(Object key);

    int save(T entity);

    int delete(Object key);

    int updateAll(T entity);

    int updateNotNull(T entity);

    List<T> selectByExample(Object example);
    
    PageInfo<T> selectByPage(T t,int startRow,int pageSize);
    
    List<T> findAll();

    boolean batchDel(Object[] ids);
}