package com.tt.fffffirework.factory;

/**
 * @Description: bean工厂接口类
 * @Author: guo
 * @CreateDate: 2019/11/8
 * @UpdateUser:
 */
public interface BeanFactory {


    /**
     * @author guoyitao
     * @date 2019/11/8 15:39
     * @return  obj
     */
    Object getBeanFromBeanDefine(BeanDefine beanDefine);

    /**
     * @author guoyitao
     * @date 2019/11/8 15:39
     * @params name bean名称
     * @return  obj
     */
    Object getBeanFromName(String name);

    /**
     * @author guoyitao
     * @date 2019/11/8 15:39
     * @params className Class名称
     * @return
     */

    Object getBeanFromClassName(String className);
    /**
     * @author guoyitao
     * @date 2019/11/8 15:39
     * @params clazz Class
     * @return
     */
    Object getBeanFromClass(Class clazz);
}
