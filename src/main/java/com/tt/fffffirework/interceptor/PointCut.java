package com.tt.fffffirework.interceptor;

import com.tt.fffffirework.annotations.Aop;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PointCut {
    private Object object;

    private Method[] method;
    private Field[] fields;


    public PointCut(Object object) {
        this.object = object;
        parsing();
    }

    private void parsing(){
        Class<?> aClass = object.getClass();
        method = aClass.getDeclaredMethods();
        fields = aClass.getDeclaredFields();

    }


    public Object getObject() {
        return object;
    }

    public Method[] getMethod() {
        return method;
    }

    public Field[] getFields() {
        return fields;
    }
}
