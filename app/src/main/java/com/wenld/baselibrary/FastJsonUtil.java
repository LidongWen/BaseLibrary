package com.wenld.baselibrary;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p/>
 * Author: wenld on 2017/4/13 16:24.
 * blog: http://www.jianshu.com/u/99f514ea81b3
 * github: https://github.com/LidongWen
 */


public class FastJsonUtil {
    public FastJsonUtil() {
    }

    public static <T> T getObject(String jsonString, Class<T> cls) {
        Object t = null;

        try {
            t = JSON.parseObject(jsonString, cls);
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        return (T) t;
    }

    public static <T> List<T> getListObjects(String jsonString, Class<T> cls) {
        new ArrayList();

        try {
            List list = JSON.parseArray(jsonString, cls);
            return list;
        } catch (Exception var4) {
            var4.printStackTrace();
            return new ArrayList();
        }
    }

    public static List<Map<String, Object>> getListMaps(String jsonString) {
        Object list = new ArrayList();

        try {
            list = (List)JSON.parseObject(jsonString, new TypeReference() {
            }, new Feature[0]);
        } catch (Exception var3) {
            var3.printStackTrace();
        }

        return (List)list;
    }

    public static List<Map<String, String>> getListMapss(String jsonString) {
        Object list = new ArrayList();

        try {
            list = (List)JSON.parseObject(jsonString, new TypeReference() {
            }, new Feature[0]);
        } catch (Exception var3) {
            var3.printStackTrace();
        }

        return (List)list;
    }
//
//    public static String toJsonObject(Object obj) {
//        return JSONObject.toJSONString(obj);
//    }
//
//    public static String toJsonObjectByGson(Object obj) {
//        return (new Gson()).toJson(obj);
//    }
}