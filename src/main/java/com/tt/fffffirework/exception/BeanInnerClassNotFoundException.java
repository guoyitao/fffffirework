package com.tt.fffffirework.exception;

import lombok.Data;

@Data
public class BeanInnerClassNotFoundException extends Exception {

    private String msg;



    public BeanInnerClassNotFoundException(String message) {
        super(message);
        this.msg =message;
    }


    public BeanInnerClassNotFoundException(String message, Throwable ex) {
        super(message, ex);
        this.msg = message;
    }
}
