package com.wenld.baselib.http;

import java.io.File;
import java.util.Map;

/**
 * <p/>
 * Author: 温利东 on  2017/3/6 23:15
 * blog: http://blog.csdn.net/sinat_15877283
 * github: https://github.com/LidongWen
 *
 * @Description 上传
 */

public interface IHttpEngine {
    void postAPI(String url, Map<String, String> params, EngineCallBack callback);
    void getAPI(String url, Map<String, String> params, EngineCallBack callback);
    void postAPI(String url, Map<String, String> params, Map<String, String> headers,  EngineCallBack callback);
    void getAPI(String url, Map<String, String> params,Map<String, String> headers, EngineCallBack callback);
    void uploadAPI(String url, String uploadName,  Map<String, String> params,Map<String, String> headers, File file, EngineCallBack callback);
}
