package com.wenld.baselib.http.request;


import com.wenld.baselib.http.builder.FileInput;
import com.wenld.baselib.http.builder.HttpBuilder;
import com.wenld.baselib.http.callback.EngineCallBack;
import com.wenld.baselib.http.httpEngine.IHttpEngine;

import java.util.List;
import java.util.Map;

/**
 * <p/>
 * Author: 温利东 on 2017/3/10 10:41.
 * blog: http://blog.csdn.net/sinat_15877283
 * github: https://github.com/LidongWen
 */

public class RequestCall implements IHttpEngine {
    private static IHttpEngine mHttpEngine/* = new OkHttpEngine()*/;
    HttpBuilder httpBuilder;

    public RequestCall(HttpBuilder httpBuilder) {
        this.httpBuilder = httpBuilder;
    }

    public void execute(EngineCallBack httpEngine) {
        if (httpBuilder != null) {
            if (httpBuilder.getRequest_Type() == HttpBuilder.REQUEST_GET)
                getAPI(httpBuilder.getUrl(), httpBuilder.getParams(), httpBuilder.getHeaders(), httpEngine);
            if (httpBuilder.getRequest_Type() == HttpBuilder.REQUEST_POST) {
                if (httpBuilder.getFiles() != null && httpBuilder.getFiles().size() > 0) {
                    uploadAPI(httpBuilder.getUrl(), httpBuilder.getParams(), httpBuilder.getHeaders(), httpBuilder.getFiles(), httpEngine);
                } else {
                    postAPI(httpBuilder.getUrl(), httpBuilder.getParams(), httpBuilder.getHeaders(), httpEngine);
                }
            }
        }
    }

    @Override
    public void postAPI(String url, Map<String, String> params, EngineCallBack callback) {
        mHttpEngine.postAPI(url, params, callback);
    }

    @Override
    public void getAPI(String url, Map<String, String> params, EngineCallBack callback) {
        mHttpEngine.getAPI(url, params, callback);
    }

    public void postAPI(String url, Map<String, String> params, Map<String, String> headers, EngineCallBack callback) {
        mHttpEngine.postAPI(url, params, headers, callback);
    }

    public void getAPI(String url, Map<String, String> params, Map<String, String> headers, EngineCallBack callback) {
        mHttpEngine.getAPI(url, params, headers, callback);
    }

    public void uploadAPI(String url, Map<String, String> params, Map<String, String> headers, List<FileInput> files, EngineCallBack callback) {
        mHttpEngine.uploadAPI(url, params, headers, files, callback);
    }

    public static void setmHttpEngine(IHttpEngine mHttpEngine) {
        if (mHttpEngine != null)
            RequestCall.mHttpEngine = mHttpEngine;
    }
}
