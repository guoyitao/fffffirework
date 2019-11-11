package com.tt.fffffirework.factory;

import com.tt.fffffirework.exception.BeanClassNotFoundException;
import com.tt.fffffirework.exception.BeanInnerClassNotFoundException;
import com.tt.fffffirework.strategy.BeanStrategy;
import com.tt.fffffirework.util.ResouseUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractBeanFactory extends AbstractBeanDefineObjFacory implements BeanFactory {

    protected Map<BeanDefine,Object> classMap = new ConcurrentHashMap<>();
    private BeanStrategy beanStrategy;

    public AbstractBeanFactory(String configurationPath,BeanStrategy beanStrategy) throws ClassNotFoundException, BeanInnerClassNotFoundException, InstantiationException, BeanClassNotFoundException, IllegalAccessException, NoSuchMethodException, NoSuchFieldException, InvocationTargetException {
        super(configurationPath);
        this.beanStrategy = beanStrategy;
        createObj();

    }

   private boolean isSingletonAndNotExits(BeanDefine beanDefine){
       if (!classMap.containsKey(beanDefine) && beanDefine.isSingleton()) {
           return true;
       }
        return false;
   }

   /**
    * 使用 abstract Object newInstance(Class<?> clazz); 创建类
    * @author guoyitao
    * @date 2019/11/10 13:40
    * @params
    * @return
    */
   private Object createObj(BeanDefine beanDefine) throws ClassNotFoundException, IllegalAccessException, InstantiationException, BeanClassNotFoundException {

        if (isSingletonAndNotExits(beanDefine)){
            return newInstance(beanDefine);
        }
        return null;
   }

   /**
    *
    * 创建的类的方式将来会有多种
    * @author guoyitao
    * @date 2019/11/9 23:31
    * @params BeanDefine bean定义
    * @return  BeanStrategy 创建策略
    */
   private Object newInstance(BeanDefine beanDefine) throws ClassNotFoundException, InstantiationException, BeanClassNotFoundException, IllegalAccessException {
       return beanStrategy.create(beanDefine);
   }

   /**
    *
    * !!!!!! 这才是类的创建主方法
    *
    * 先创建没有set嵌套类的
    * 判断是不是单例
    * 然后连接嵌套的类
    * @author guoyitao
    * @date 2019/11/10 13:34
    * @params
    * @return
    */
   private void createObj() throws IllegalAccessException, InstantiationException, ClassNotFoundException, BeanInnerClassNotFoundException, BeanClassNotFoundException, NoSuchMethodException, NoSuchFieldException, InvocationTargetException {
       for (BeanDefine beanDefine : beanDefineList) {
           //是单例并且没有被第一次创建
           if (beanDefine.isSingleton() || beanDefine.getObject() != null) {
//             创建没有set嵌套类的类
               Object obj = createObj(beanDefine);
               beanDefine.setObject(obj);
               classMap.put(beanDefine,obj);
           }
       }
//       连接嵌套的类
       createNestedObj();
   }

    /**
     * 连接嵌套的类
     * @author guoyitao
     * @date 2019/11/10 13:34
     * @params
     * @return
     */
   private void createNestedObj() throws BeanInnerClassNotFoundException, NoSuchMethodException, NoSuchFieldException, IllegalAccessException, InvocationTargetException {
       for (Map.Entry<BeanDefine, Object> beanDefineObjectEntry : classMap.entrySet()) {
           BeanDefine beanDefine = beanDefineObjectEntry.getKey();
           setObjToOtherBean(beanDefine);
       }
   }

    /**
     * 递归set嵌套的类
     * @author guoyitao
     * @date 2019/11/9 23:10
     * @params beanDefine需要被set的类定义
     * @return
     */
   private void setObjToOtherBean(BeanDefine beanDefine) throws BeanInnerClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException, NoSuchFieldException {
       List<BeanDefine> filds = beanDefine.getFilds();
       if (filds != null && filds.size()!=0) {
           Iterator<BeanDefine> iterator = filds.iterator();
           while (iterator.hasNext()){
               BeanDefine fild = iterator.next();
               Object o = null;
               try {
                   //之前第一次创建好的obj
                   o = getBeanFromName(fild.getName());
                   fild.setObject(o);
               } catch (Exception e) {
                   throw new BeanInnerClassNotFoundException(e.getMessage());
               }
               setRefFild(beanDefine,fild);
               iterator.remove();

               setObjToOtherBean(beanDefine);
           }
       }
   };

   /**
    * @author guoyitao
    * @date 2019/11/10 15:02
    * @params beanDefine需要被设置的，fildBeanDefine 参数
    * @return
    */
   private void setRefFild(BeanDefine beanDefine, BeanDefine fildBeanDefine) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
       Object object = beanDefine.getObject();


       Method method = object.getClass().getMethod("set" + ResouseUtil.shouzimudaxie(fildBeanDefine.getName()), fildBeanDefine.getObject().getClass());

       method.invoke(object,fildBeanDefine.getObject());

   }

    @Override
    public Object getBeanFromName(String name) {
        BeanDefine beanDefine = new BeanDefine();
        beanDefine.setName(name);
        return classMap.get(beanDefine);
    }

    public Collection<Object> getAllObjs(){
       return classMap.values();
    }

    @Override
    public Object getBeanFromBeanDefine(BeanDefine beanDefine) {
        return null;
    }

    @Override
    public Object getBeanFromClassName(String className) {
        return null;
    }

    @Override
    public Object getBeanFromClass(Class clazz) {
        return null;
    }
}
