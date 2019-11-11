package com.tt.fffffirework.strategy;

import com.tt.fffffirework.exception.BeanClassNotFoundException;
import com.tt.fffffirework.factory.BeanDefine;

public interface BeanStrategy {

    Object create(BeanDefine beanDefine) throws ClassNotFoundException, BeanClassNotFoundException, IllegalAccessException, InstantiationException;


}
