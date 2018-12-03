package com.lq.laboratory.services;

import com.lq.laboratory.entity.Result;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

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


    T insert(T t);

    int update(T t);

    boolean delete(String id);

    default List<T> getList(Specification<T> specification, int pageNumber, int pageSize) {
        return null;
    }

    default List<T> getAll(Specification<T> specification) {
        return null;
    }

    //清空表数据
    boolean clear();
}
