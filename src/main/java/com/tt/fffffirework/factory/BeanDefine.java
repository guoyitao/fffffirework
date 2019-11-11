package com.tt.fffffirework.factory;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class BeanDefine {
    private String name;
    private String className;
    private boolean isSingleton  = true;

    private List<BeanDefine> filds;

    private Object object;

    public BeanDefine() {

    }



    @Override
    public boolean equals(Object o) {
        BeanDefine beanDefine = (BeanDefine) o;

        return name.equals(beanDefine.getName());
    }



    @Override
    public int hashCode() {

        return name.hashCode();
    }
}
