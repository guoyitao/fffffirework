package com.tt.fffffirework.interceptor;

import com.tt.fffffirework.annotations.Aop;
import com.tt.fffffirework.factory.BeanDefine;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public abstract class AbstractTTAop {



    public Method whetherMethodNeedAop(Object o) {
        for (Method method : o.getClass().getDeclaredMethods()) {
            //如果有注解
            int length = method.getAnnotations().length;
            if (length >0){
                for (Annotation annotation : method.getAnnotations()) {
                    if (annotation.annotationType().getName().equals(Aop.class.getName())) {
                        //需要aop
                        return method;
                    }
                }
            }
        }
        return null;
    }

}
