package com.lq.laboratory.entity;

import lombok.Data;

@Data
public class ResponseEntity<T> {
    private int code;
    private String msg;
    private T data;

    
}
