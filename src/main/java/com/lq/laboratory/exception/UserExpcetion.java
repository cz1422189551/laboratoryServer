package com.lq.laboratory.exception;

public class UserExpcetion extends RuntimeException {

    public UserExpcetion() {
    }

    public UserExpcetion(String message) {
        super(message);
    }

    public UserExpcetion(String message, Throwable cause) {
        super(message, cause);
    }

    public UserExpcetion(Throwable cause) {
        super(cause);
    }

    public UserExpcetion(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
