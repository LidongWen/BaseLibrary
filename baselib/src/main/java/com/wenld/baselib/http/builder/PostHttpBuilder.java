//package com.wenld.baselib.http.builder;
//
//import java.io.File;
//import java.util.LinkedHashMap;
//import java.util.Map;
//
///**
// * <p/>
// * Author: 温利东 on 2017/3/10 13:28.
// * blog: http://blog.csdn.net/sinat_15877283
// * github: https://github.com/LidongWen
// */
//
//public class PostHttpBuilder extends HttpBuilder<PostHttpBuilder> {
//
//    public PostHttpBuilder() {
//        request_Type = REQUEST_POST;
//    }
//
//    public PostHttpBuilder files(String key, Map<String, File> files) {
//        for (String filename : files.keySet()) {
//            this.files.add(new FileInput(key, filename, files.get(filename)));
//        }
//        return this;
//    }
//
//    public PostHttpBuilder addFile(String name, String filename, File file) {
//        files.add(new FileInput(name, filename, file));
//        return this;
//    }
//
//    public PostHttpBuilder params(Map<String, String> params) {
//        this.params = params;
//        return this;
//    }
//
//    public PostHttpBuilder addParam(String key, String val) {
//        if (this.params == null) {
//            params = new LinkedHashMap<>();
//        }
//        params.put(key, val);
//        return this;
//    }
//}
