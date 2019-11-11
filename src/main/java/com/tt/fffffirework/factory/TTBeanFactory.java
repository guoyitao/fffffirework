package com.tt.fffffirework.factory;

import com.tt.fffffirework.exception.BeanClassNotFoundException;
import com.tt.fffffirework.exception.BeanInnerClassNotFoundException;
import com.tt.fffffirework.interceptor.TTAop;
import com.tt.fffffirework.strategy.BeanStrategy;
import com.tt.fffffirework.strategy.NoArgumentsConstructorStrategy;

import java.lang.reflect.InvocationTargetException;

public class TTBeanFactory extends AbstractBeanFactory {


    private static final BeanStrategy beanStrategy = new NoArgumentsConstructorStrategy();
    private final TTAop ttAop = new TTAop(this);

    public TTBeanFactory(String configurationPath) throws ClassNotFoundException, BeanInnerClassNotFoundException, InstantiationException, BeanClassNotFoundException, IllegalAccessException, NoSuchMethodException, NoSuchFieldException, InvocationTargetException {
        super(configurationPath,beanStrategy);

        //开始aop
//        ttAop.Fuck();
    }




}
