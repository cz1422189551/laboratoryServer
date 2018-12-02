package com.lq.laboratory.services;

import com.lq.laboratory.entity.Result;

import java.util.List;

public interface IService<T> {

    //通过id查询一个对象
    T getOne(String id);

    /**
     * 分页查询
     *
     * @param pageNumber 页数
     * @param pageSize   一页多少条记录
     * @return
     */
    Result<T> getList(int pageNumber, int pageSize);

    //查询所有记录
    List<T> getAll();

    //自定义查询条件
    Result<T> getCustom(String sql);

    //自定义查询条件，返回一个结果
    T getCustomOne(String sql);

    T insert(T t);

    T update(T t);

    boolean delete(String id);

    //清空表数据
    boolean clear();
}
