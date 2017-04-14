package com.wenld.baselibrary.http;


import android.net.Uri;

import com.wenld.baselib.http.HttpUtils;
import com.wenld.baselib.http.builder.FileInput;
import com.wenld.baselib.http.callback.EngineCallBack;
import com.wenld.baselib.http.callback.FileCallBack;
import com.wenld.baselib.http.httpEngine.IHttpEngine;
import com.wenld.baselibrary.FastJsonUtil;
import com.zhy.http.okhttp.OkHttpUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
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
            private OkHttpUtils instance = OkHttpUtils.getInstance();
    private OkHttpClient mOkHttpClient;

    public OkHttpEngine(OkHttpClient okHttpClient) {
        if (okHttpClient == null) {
            mOkHttpClient = new OkHttpClient();
        } else {
            mOkHttpClient = okHttpClient;
        }
    }

    public OkHttpEngine() {
        this(null);
    }

    @Override
    public void postAPI(String url, Map<String, String> params, final EngineCallBack callback) {
        FormBody.Builder builder = new FormBody.Builder();
        OkhttpHelper.addParams(params, builder);
        RequestBody formBody = builder.build();

        Request.Builder requestBuilder = new Request.Builder()
                .url(url)
                .post(formBody);

        Request request = requestBuilder.build();

        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onError(e, 1);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) {
                    callback.onError(new IOException("request failed , reponse's code is : " + response.code()), 1);
                } else {
                    if (FileCallBack.class.isInstance(callback)) {
                        File file = saveFile(response, 1, (FileCallBack) callback);
                        callback.onResponse(file, 1);
                    } else {
                        Class<?> entityClass = (Class<?>) ((ParameterizedType) (callback.getClass().getGenericSuperclass())).getActualTypeArguments()[0];
                        String result = response.body().string();
                        callback.onResponse(FastJsonUtil.getObject(result, entityClass), 1);
                    }
                }
            }
        });
    }

    @Override
    public void getAPI(String url, Map<String, String> params, final EngineCallBack callback) {
        String urls = UrlBuide(url, params);
        Request request = new Request.Builder()
                .url(urls)
                .build();
        Call mcall = mOkHttpClient.newCall(request);
        mcall.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onError(e, 1);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) {
                    callback.onError(new IOException("request failed , reponse's code is : " + response.code()), 1);
                } else {
                    Class<?> entityClass = (Class<?>) ((ParameterizedType) (callback.getClass().getGenericSuperclass())).getActualTypeArguments()[0];
                    String result = response.body().string();
                    callback.onResponse(FastJsonUtil.getObject(result, entityClass), 1);
                }
            }
        });
    }

    @Override
    public void postAPI(String url, Map<String, String> params, Map<String, String> headers, final EngineCallBack callback) {
        FormBody.Builder builder = new FormBody.Builder();
        OkhttpHelper.addParams(params, builder);
        RequestBody formBody = builder.build();

        Request.Builder requestBuilder = new Request.Builder()
                .url(url)
                .post(formBody);

        OkhttpHelper.addHeaders(requestBuilder, headers);

        Request request = requestBuilder.build();

        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onError(e, 1);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) {
                    callback.onError(new IOException("request failed , reponse's code is : " + response.code()), 1);
                } else {
                    if (FileCallBack.class.isInstance(callback)) {
                        File file = saveFile(response, 1, (FileCallBack) callback);
                        callback.onResponse(file, 1);
                    } else {
                        Class<?> entityClass = (Class<?>) ((ParameterizedType) (callback.getClass().getGenericSuperclass())).getActualTypeArguments()[0];
                        String result = response.body().string();
                        callback.onResponse(FastJsonUtil.getObject(result, entityClass), 1);
                    }
                }
            }
        });
    }


    @Override
    public void getAPI(String url, Map<String, String> params, Map<String, String> headers, EngineCallBack callback) {
//        instance.get()
//                .url(url)
//                .params(params)
//                .headers(headers)
//                .build()
//                .execute(new com.zhy.http.okhttp.callback.Callback<String>() {
//                    @Override
//                    public String parseNetworkResponse(Response response, int id) throws Exception {
//                        return null;
//                    }
//
//                    @Override
//                    public void onError(Call call, Exception e, int id) {
//
//                    }
//
//                    @Override
//                    public void onResponse(String response, int id) {
//
//                    }
//                });
    }

    @Override
    public void uploadAPI(String url, Map<String, String> params, Map<String, String> headers, List<FileInput> files, EngineCallBack callback) {
//        MultipartBody.Builder builder = new MultipartBody.Builder()
//                .setType(MultipartBody.FORM);
//        addParams(params, builder);
//        RequestBody formBody = builder.build();
//
//        for (int i = 0; i < files.size(); i++) {
//            FileInput fileInput = files.get(i);
//            RequestBody fileBody = RequestBody.create(MediaType.parse(guessMimeType(fileInput.filename)), fileInput.file);
//            builder.addFormDataPart(fileInput.key, fileInput.filename, fileBody);
//        }
    }

    /**
     * @param response
     * @param id
     * @param callback
     * @return
     * @throws IOException
     */
    public File saveFile(Response response, final int id, final FileCallBack callback) throws IOException {
        InputStream is = null;
        byte[] buf = new byte[2048];
        int len = 0;
        FileOutputStream fos = null;
        try {
            is = response.body().byteStream();
            final long total = response.body().contentLength();

            long sum = 0;

            File dir = new File(callback.destFileDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File file = new File(dir, callback.destFileName);
            fos = new FileOutputStream(file);
            while ((len = is.read(buf)) != -1) {
                sum += len;
                fos.write(buf, 0, len);
                final long finalSum = sum;
                HttpUtils.getInstance().getDelivery().execute(new Runnable() {
                    @Override
                    public void run() {
                        callback.inProgress(finalSum * 1.0f / total, total, id);
                    }
                });
            }
            fos.flush();

            return file;

        } finally {
            try {
                response.body().close();
                if (is != null) is.close();
            } catch (IOException e) {
            }
            try {
                if (fos != null) fos.close();
            } catch (IOException e) {
            }
        }
    }

    public static String UrlBuide(String mUrl, Map<String, String> mParamsMap) {
        Uri.Builder builder = Uri.parse(mUrl).buildUpon();
        Iterator<String> it = mParamsMap.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            String value = mParamsMap.get(key);
            builder.appendQueryParameter(key, value);
        }
        return builder.toString();
    }
}
