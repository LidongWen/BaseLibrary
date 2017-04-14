package com.wenld.baselibrary.http;

import java.io.UnsupportedEncodingException;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * <p/>
 * Author: wenld on 2017/4/14 10:40.
 * blog: http://www.jianshu.com/u/99f514ea81b3
 * github: https://github.com/LidongWen
 */

public class OkhttpHelper {
//
    public static String guessMimeType(String path) {
        FileNameMap fileNameMap = URLConnection.getFileNameMap();
        String contentTypeFor = null;
        try {
            contentTypeFor = fileNameMap.getContentTypeFor(URLEncoder.encode(path, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (contentTypeFor == null) {
            contentTypeFor = "application/octet-stream";
        }
        return contentTypeFor;
    }

    /**
     * 添加参数
     * @param params
     * @param builder
     */
    public static void addParams(Map<String, String> params, FormBody.Builder builder) {
        if (params != null) {
            for (String key : params.keySet()) {
                builder.add(key, params.get(key));
            }
        }
    }

    /**
     * 
     * @param params
     * @param builder
     */
    public static void addParams(Map<String, String> params, MultipartBody.Builder builder) {
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                builder.addPart(Headers.of("Content-Disposition", "form-data; name=\"" + key + "\""),
                        RequestBody.create(null, params.get(key)));
            }
        }
    }

    /**
     * 
     * @param requestBuilder
     * @param headers
     */
    public static void addHeaders(Request.Builder requestBuilder, Map<String, String> headers) {
        Headers.Builder headerBuilder = new Headers.Builder();
        if (headers == null || headers.isEmpty()) return;

        for (String key : headers.keySet()) {
            headerBuilder.add(key, headers.get(key));
        }
        requestBuilder.headers(headerBuilder.build());
    }


}
