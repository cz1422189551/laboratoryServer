package com.lq.laboratory.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseEntity<T> {

    //响应码 默认200为正常
    private int code;

    //响应信息
    private String msg;

    //数据
    private T data;

    
}
