package com.wenld.baselibrary.http;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p/>
 * Author: 温利东 on 2017/3/10 8:55.
 * blog: http://blog.csdn.net/sinat_15877283
 * github: https://github.com/LidongWen
 * http构建工具类
 */

public class HttpBuilder<T extends HttpBuilder> {
    public static int REQUEST_GET = 0x111;
    public static int REQUEST_POST = 0x222;

    protected String url;
    protected Object tag;
    protected Map<String, String> headers;
    protected Map<String, String> params;
    protected int id;
    protected int request_Type;


//    public  HttpBuilder() {
//        this.request_Type = request_Type;
//    }

//    public T get() {
//        request_Type = REQUEST_GET;
//        return (T) this;
//    }
//
//    public T post() {
//        request_Type = REQUEST_POST;
//        return (T) this;
//    }

    public T id(int id) {
        this.id = id;
        return (T) this;
    }

    public T url(String url) {
        this.url = url;
        return (T) this;
    }


    public T tag(Object tag) {
        this.tag = tag;
        return (T) this;
    }

    public T headers(Map<String, String> headers) {
        this.headers = headers;
        return (T) this;
    }

    public T addHeader(String key, String val) {
        if (this.headers == null) {
            headers = new LinkedHashMap<>();
        }
        headers.put(key, val);
        return (T) this;
    }

    public RequestCall build() {
        return new RequestCall(this);
    }
}
