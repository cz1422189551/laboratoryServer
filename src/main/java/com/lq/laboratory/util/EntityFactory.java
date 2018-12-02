package com.lq.laboratory.util;

import com.lq.laboratory.entity.ResponseEntity;
import com.lq.laboratory.entity.Result;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * 响应实体生成
 */
public class EntityFactory {


    public static final int SUCCESS = 200;

    public static final int INSERT_ERROR = 300;

    public static final int RUNTIME_ERROR = 500;


    public static ResponseEntity createRunTimeError() {
        return createErrorResponse(RUNTIME_ERROR, "服务器运行异常");
    }

    public static ResponseEntity createErrorResponse(int code, Exception e) {
        return createErrorResponse(code, e.getMessage());
    }

    //创建错误的响应实体
    public static ResponseEntity createErrorResponse(int code, String msg) {
        return new ResponseEntity(code, msg, null);
    }

    //创建正常的响应实体
    public static <T> ResponseEntity<T> createResponse(T t) {
        return new ResponseEntity<>(SUCCESS, "success", t);
    }


    public static <T> Result<T> createResult(Page<T> page) {
        //总记录数量
        long totalElements = page.getTotalElements();
        //当前页
        int pageNumber = page.getNumber();
        //总页数
        int totalPages = page.getTotalPages();
        //当前页的记录数
        int numberOfElements = page.getNumberOfElements();
        //一页大小
        int pageSize = page.getSize();
        //数据
        List<T> data = page.getContent();
        return new Result<>(pageSize, pageNumber, totalElements, numberOfElements, totalPages, data);
    }

    public static <T> Result<T> createResult(List<T> t) {

        return new Result<>(t);
    }

    public static Pageable createPagable(int pageNumber, int pageSize) {
        return PageRequest.of(pageNumber, pageSize, Sort.Direction.DESC, "id");

    }

}
