package com.lq.laboratory.controller;

import com.lq.laboratory.entity.ResponseEntity;
import com.lq.laboratory.util.EntityFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionController {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity runtimeException(Exception e) {
        return EntityFactory.createErrorResponse(EntityFactory.RUNTIME_ERROR, e);
    }
}
