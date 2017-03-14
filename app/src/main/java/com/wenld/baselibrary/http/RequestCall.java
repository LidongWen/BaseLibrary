package com.wenld.baselibrary.http;

import com.wenld.baselib.http.EngineCallBack;

import java.io.File;
import java.util.Map;

import static com.wenld.baselibrary.http.HttpBuilder.REQUEST_GET;
import static com.wenld.baselibrary.http.HttpBuilder.REQUEST_POST;

/**
 * <p/>
 * Author: 温利东 on 2017/3/10 10:41.
 * blog: http://blog.csdn.net/sinat_15877283
 * github: https://github.com/LidongWen
 */

public class RequestCall<T> {
    private static OkHttpEngine instance = new OkHttpEngine();
    HttpBuilder httpBuilder;

    public RequestCall(HttpBuilder httpBuilder) {
        this.httpBuilder = httpBuilder;
    }

    public void execute(EngineCallBack httpEngine) {
        if (httpBuilder != null) {
            if (httpBuilder.request_Type == REQUEST_GET)
                getAPI(httpBuilder.url, httpBuilder.params, httpBuilder.headers, httpEngine);
            if (httpBuilder.request_Type == REQUEST_POST)
                postAPI(httpBuilder.url, httpBuilder.params, httpBuilder.headers, httpEngine);
        }
    }

    void postAPI(String url, Map<String, String> params, Map<String, String> headers, EngineCallBack callback) {
        instance.postAPI(url, params, headers, callback);
    }

    void getAPI(String url, Map<String, String> params, Map<String, String> headers, EngineCallBack callback) {
        instance.getAPI(url, params, headers, callback);
    }

    void uploadAPI(String url, String uploadName, Map<String, String> params, Map<String, String> headers, Map<String, File> files, EngineCallBack callback) {
        instance.uploadAPI(url, uploadName, params, headers, files, callback);
    }
}
