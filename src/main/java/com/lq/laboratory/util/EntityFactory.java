package com.lq.laboratory.util;

import com.lq.laboratory.entity.*;

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

    public static final int SQL_ERROR = 300;

    public static final int DB_ERROR = 400;

    public static final int RUNTIME_ERROR = 500;

    public static final int APPOINT_ERROR = 500;

    public static ResponseEntity createRunTimeError() {
        return createErrorResponse(RUNTIME_ERROR, "服务器运行异常");
    }

    public static ResponseEntity createErrorResponse(int code, Exception e) {
        return createErrorResponse(code, e.getClass().getSimpleName() + ":" + e.getMessage());
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
        int pageNumber = page.getNumber() + 1;
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

    public static Pageable createPageable(int pageNumber, int pageSize) {
        return PageRequest.of(pageNumber - 1, pageSize, Sort.Direction.DESC, "id");

    }

//    public static LaboratoryTypeEntity createLaboratoryTypeEntity(LaboratoryType type, LaboratorySeatServiceImpl seatService) {
//        List<Laboratory> laboratoryList = type.getLaboratoryList();
//
//        List<LaboratoryEntity> collect = laboratoryList.stream().map(l -> {
//            List<LaboratorySeat> seatInfoList = seatService.getAll(LaboratorySeatSpecification.findBySeatIdAndLaboratoryId(l.getId()));
//            return new LaboratoryEntity(l, seatInfoList);
//        }).collect(Collectors.toList());
//
//        return new LaboratoryTypeEntity(type.getId(), type.getName(), collect);
//    }
//
//    public static List<LaboratoryTypeEntity> createLaboratoryTypeEntity(List<LaboratoryType> typeList, LaboratorySeatServiceImpl seatService) {
//        return typeList.stream().map(t -> createLaboratoryTypeEntity(t, seatService)).collect(Collectors.toList());
//    }


}
