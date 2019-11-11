package com.tt.fffffirework.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.tt.fffffirework.factory.BeanDefine;
import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class ResouseUtil {

    public static File getFileFromClassPath(String string){
        URL url= Thread.currentThread().getContextClassLoader().getResource(string);
        return new File(url.getFile());
    }

    public static String loadJsonToString(File file){
        String str = "";
        try (FileInputStream in=new FileInputStream(file)){
            // size  为字串的长度 ，这里一次性读完

            int size=in.available();

            byte[] buffer=new byte[size];

            in.read(buffer);

            str=new String(buffer,"utf8");

        } catch (IOException e) {


            e.printStackTrace();

        }

        return str;
    }

    /**
     * 把Java对象转换成json字符串
     *
     * @param object 待转化为JSON字符串的Java对象
     * @return json 串 or null
     */
    public static String parseObjToJson(Object object) {
        String string = null;
        try {
            //string = JSON.toJSONString(object);
            string = JSONObject.toJSONString(object);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return string;
    }

    /**
     * 将Json字符串信息转换成对应的Java对象
     *
     * @param json json字符串对象
     * @param c    对应的类型
     */
    public static <T> T parseJsonToObj(String json, Class<T> c) {
        try {
            //两个都是可行的，起码我测试的时候是没问题的。
            //JSONObject jsonObject = JSONObject.parseObject(json);
            JSONObject jsonObject = JSON.parseObject(json);
            return JSON.toJavaObject(jsonObject, c);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static String shouzimudaxie(String str){

        return  str.substring(0, 1).toUpperCase() + str.substring(1);

    }


}
