package com.tt.fffffirework.factory;

import com.tt.fffffirework.util.ResouseUtil;

import java.io.File;

public abstract class AbstractConfigurationFactory implements ConfigurationFactory{


    private File applicationConf;
    protected  String path;

    public AbstractConfigurationFactory(String path) {
        this.path = path;
    }

    public File getApplicationConf() {
        return this.applicationConf;
    }

    /**
     * @author guoyitao
     * @date 2019/11/8 16:53
     * @params 加载bean配置文件
     * @return
     */
    @Override
    public String loadJsonConfigurationToString(){
        if (path=="" && path ==null){
            path="application.json";
        }
        applicationConf = ResouseUtil.getFileFromClassPath(path);
        String string = ResouseUtil.loadJsonToString(applicationConf);
        return string;
    }
}
