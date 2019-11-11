package com.tt.fffffirework.exception;

import lombok.Data;

@Data
public class BeanClassNotFoundException extends Exception {


    private String msg;

    public BeanClassNotFoundException() {
    }

    public BeanClassNotFoundException(String s) {
        super(s);
        this.msg = s;

    }

    public BeanClassNotFoundException(String s, Throwable ex) {
        super(s, ex);
        this.msg = s;
    }
}
