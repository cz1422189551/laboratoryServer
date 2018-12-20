package com.lq.laboratory.controller;

import com.lq.laboratory.entity.ResponseEntity;
import com.lq.laboratory.exception.AppointmentException;
import com.lq.laboratory.util.EntityFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionController {

    @ExceptionHandler(AppointmentException.class)
    public ResponseEntity appointException(Exception e) {
        return EntityFactory.createErrorResponse(EntityFactory.APPOINT_ERROR, e);
    }


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity runtimeException(Exception e) {
        return EntityFactory.createErrorResponse(EntityFactory.RUNTIME_ERROR, e);
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity sqlException(Exception e) {
        return EntityFactory.createErrorResponse(EntityFactory.SQL_ERROR, e);
    }

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity dataAccessException(Exception e) {
        return EntityFactory.createErrorResponse(EntityFactory.DB_ERROR, e);
    }


}
