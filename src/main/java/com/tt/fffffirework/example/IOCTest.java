package com.tt.fffffirework.example;

import com.tt.fffffirework.exception.BeanClassNotFoundException;
import com.tt.fffffirework.exception.BeanInnerClassNotFoundException;
import com.tt.fffffirework.factory.TTBeanFactory;

import java.lang.reflect.InvocationTargetException;


/*
* IOC 测试，
* 暂时
* 只支持单例对象的创建
* 嵌套对象的创建
* */
public class IOCTest {


    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, BeanClassNotFoundException, BeanInnerClassNotFoundException, NoSuchMethodException, NoSuchFieldException, InvocationTargetException {
        TTBeanFactory ttBeanFactory = new TTBeanFactory("target/classes/application.json");
        Bean2 bean2 = (Bean2)ttBeanFactory.getBeanFromName("bean2");
        bean2.sou();
        bean2.getBean1().sou();
    }

}
