package com.wenld.baselibrary.http;

import com.wenld.baselib.http.EngineCallBack;
import com.wenld.baselib.http.IHttpEngine;
import com.zhy.http.okhttp.OkHttpUtils;

import java.io.File;
import java.util.Map;

/**
 * <p/>
 * Author: 温利东 on  2017/3/6 23:20
 * blog: http://blog.csdn.net/sinat_15877283
 * github: https://github.com/LidongWen
 *
 * @Description
 */

public class OkHttpEngine implements IHttpEngine {
    private OkHttpUtils instance = OkHttpUtils.getInstance();

    @Override
    public void postAPI(String url, Map<String, String> params, EngineCallBack callback) {
        instance.post()
                .url(url)
                .params(params)
                .build()
                .execute(new OkHttpCallBack(callback));
    }

    @Override
    public void getAPI(String url, Map<String, String> params, EngineCallBack callback) {
        instance.get()
                .url(url)
                .build()
                .execute(new OkHttpCallBack(callback));
    }

    @Override
    public void postAPI(String url, Map<String, String> params, Map<String, String> headers, EngineCallBack callback) {
        instance.post()
                .url(url)
                .params(params)
                .headers(headers)
                .build()
                .execute(new OkHttpCallBack(callback));
    }

    @Override
    public void getAPI(String url, Map<String, String> params, Map<String, String> headers, EngineCallBack callback) {
        instance.get()
                .url(url)
                .params(params)
                .headers(headers)
                .build()
                .execute(new OkHttpCallBack(callback));
    }

    @Override
    public void uploadAPI(String url, String uploadName,  Map<String, String> params,Map<String, String> headers,  Map<String, File> files, EngineCallBack callback) {
        instance.post()
                .files(uploadName, files)
                .url(url)
                .params(headers)
                .build()
                .execute(new OkHttpCallBack(callback));
    }
}
