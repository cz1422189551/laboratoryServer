package com.lq.laboratory.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {

    //一页的大小
    private int pageSize;

    //当前页
    private int pageNumber;

    //总数
    private long total;

    //当前页的实际记录数
    private int pageCount;

    //总页数
    private long totalPage;

    private List<T> result;

    public Result(List<T> result) {
        this.result = result;
        if (result != null) total = result.size();

    }
}
