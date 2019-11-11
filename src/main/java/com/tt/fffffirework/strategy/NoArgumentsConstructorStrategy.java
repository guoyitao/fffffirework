package com.tt.fffffirework.strategy;

import com.tt.fffffirework.annotations.Aop;
import com.tt.fffffirework.exception.BeanClassNotFoundException;
import com.tt.fffffirework.exception.BeanInnerClassNotFoundException;
import com.tt.fffffirework.factory.BeanDefine;
import com.tt.fffffirework.factory.BeanFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class NoArgumentsConstructorStrategy implements BeanStrategy {


    @Override
    public Object create(BeanDefine beanDefine) throws BeanClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> aClass = null;
        try {
            aClass = Class.forName(beanDefine.getClassName());
        } catch (Exception e) {
            throw new BeanClassNotFoundException(e.getMessage(),e.getCause());
        }
    // TODO 在这里对类增强
        Object o = aClass.newInstance();
        return o;
    }




}
