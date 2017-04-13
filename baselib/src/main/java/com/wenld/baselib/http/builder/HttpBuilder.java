package com.wenld.baselib.http.builder;


import com.wenld.baselib.http.request.RequestCall;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * <p/>
 * Author: 温利东 on 2017/3/10 8:55.
 * blog: http://blog.csdn.net/sinat_15877283
 * github: https://github.com/LidongWen
 * http构建工具类
 */

public abstract class HttpBuilder<T extends HttpBuilder> {
    public static int REQUEST_GET = 0x111;
    public static int REQUEST_POST = 0x222;

    protected String url;
    protected Object tag;
    protected Map<String, String> headers;

    protected Map<String, String> params;
    protected List<FileInput> files = new ArrayList<>();

    protected int id;
    protected int request_Type;

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
        return new RequestCall((T)this);
    }

    public String getUrl() {
        return url;
    }

    public Object getTag() {
        return tag;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public List<FileInput> getFiles() {
        return files;
    }

    public int getId() {
        return id;
    }

    public int getRequest_Type() {
        return request_Type;
    }
}
