package com.tt.fffffirework.factory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.tt.fffffirework.util.ResouseUtil;

import java.io.File;
import java.util.*;

public abstract class AbstractBeanDefineObjFacory extends AbstractConfigurationFactory implements BeanDefineFactory {

    protected  List<BeanDefine> beanDefineList = Collections.synchronizedList(new ArrayList<>());

    protected  Map<String, List<BeanDefine>> configurationMap;

    public AbstractBeanDefineObjFacory(String configurationPath) {
        super(configurationPath);
        configurationMap = JSON.parseObject(ResouseUtil.loadJsonToString(new File(configurationPath)), new TypeReference<Map<String, List<BeanDefine>>>() {});
        initbeanDefineList();
    }

    private  void initbeanDefineList(){
        beanDefineList=configurationMap.get("beans");
    }

    @Override
    public  List<BeanDefine> getBeanDefineList() {
        return beanDefineList;
    }
}
