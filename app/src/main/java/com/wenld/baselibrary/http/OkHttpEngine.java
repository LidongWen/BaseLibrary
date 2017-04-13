package com.wenld.baselibrary.http;


import com.wenld.baselib.http.builder.FileInput;
import com.wenld.baselib.http.callback.EngineCallBack;
import com.wenld.baselib.http.httpEngine.IHttpEngine;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * <p/>
 * Author: 温利东 on  2017/3/6 23:20
 * blog: http://blog.csdn.net/sinat_15877283
 * github: https://github.com/LidongWen
 *
 * @Description
 */

public class OkHttpEngine implements IHttpEngine {
    //    private OkHttpUtils instance = OkHttpUtils.getInstance();
    static OkHttpEngine instance;
    private OkHttpClient mOkHttpClient;

    private OkHttpEngine(OkHttpClient okHttpClient) {
        if (okHttpClient == null) {
            mOkHttpClient = new OkHttpClient();
        } else {
            mOkHttpClient = okHttpClient;
        }
    }

    private OkHttpEngine() {
        this(null);
    }

    public static OkHttpEngine getInstance() {
        if (instance == null) {
            instance = new OkHttpEngine();
        }
        return instance;
    }


    @Override
    public void postAPI(String url, Map<String, String> params,final EngineCallBack callback) {
        FormBody.Builder builder = new FormBody.Builder();
        addParams(params, builder);
        RequestBody formBody = builder.build();

        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onError(e,1);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result=response.body().toString();
                callback.onResponse(response,1);
            }
        });
//        mOkHttpClient.post()
//                .url(url)
//                .params(params)
//                .build()
//                .execute(new OkHttpCallBack<ty>(callback) {
//                    @Override
//                    public ty parseNetworkResponse(Response response, int id) throws Exception {
//                        return null;
//                    }
//                });
    }

    @Override
    public void getAPI(String url, Map<String, String> params, EngineCallBack callback) {

        Request request = new Request.Builder()
                .url(url)
                .build();
        Call mcall = mOkHttpClient.newCall(request);
        mcall.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
//        mOkHttpClient.get()
//                .url(url)
//                .build()
//                .execute(new OkHttpCallBack(callback));
    }

    @Override
    public void postAPI(String url, Map<String, String> params, Map<String, String> headers, EngineCallBack callback) {
//        mOkHttpClient.post()
//                .url(url)
//                .params(params)
//                .headers(headers)
//                .build()
//                .execute(new OkHttpCallBack(callback));
    }

    @Override
    public void getAPI(String url, Map<String, String> params, Map<String, String> headers, EngineCallBack callback) {
//        mOkHttpClient.get()
//                .url(url)
//                .params(params)
//                .headers(headers)
//                .build()
//                .execute(new OkHttpCallBack(callback));
    }

    @Override
    public void uploadAPI(String url, Map<String, String> params, Map<String, String> headers, List<FileInput> files, EngineCallBack callback) {
        MultipartBody.Builder builder = new MultipartBody.Builder()
                .setType(MultipartBody.FORM);
        addParams(params, builder);
        RequestBody formBody = builder.build();

        for (int i = 0; i < files.size(); i++) {
            FileInput fileInput = files.get(i);
            RequestBody fileBody = RequestBody.create(MediaType.parse(guessMimeType(fileInput.filename)), fileInput.file);
            builder.addFormDataPart(fileInput.key, fileInput.filename, fileBody);
        }
    }


    private String guessMimeType(String path) {
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

    private void addParams(Map<String, String> params, FormBody.Builder builder) {
        if (params != null) {
            for (String key : params.keySet()) {
                builder.add(key, params.get(key));
            }
        }
    }

    private void addParams(Map<String, String> params, MultipartBody.Builder builder) {
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                builder.addPart(Headers.of("Content-Disposition", "form-data; name=\"" + key + "\""),
                        RequestBody.create(null, params.get(key)));
            }
        }
    }
}
