package com.wenld.baselib.http;

import com.wenld.baselib.http.builder.GetHttpBuilder;
import com.wenld.baselib.http.builder.PostHttpBuilder;
import com.wenld.baselib.http.callback.EngineCallBack;
import com.wenld.baselib.http.httpEngine.IHttpEngine;
import com.wenld.baselib.http.request.RequestCall;

import java.io.File;
import java.util.Map;

/**
 * <p/>
 * Author: 温利东 on  2017/3/6 23:30
 * blog: http://blog.csdn.net/sinat_15877283
 * github: https://github.com/LidongWen
 *
 * @Description
 */

public class HttpUtils {

    public HttpUtils() {

    }

    private volatile static HttpUtils mInstance;

    public static HttpUtils getInstance() {
        return initHttpEngine(null);
    }

    public static HttpUtils initHttpEngine(IHttpEngine mHttpEngine) {
        if (mInstance == null) {
            synchronized (HttpUtils.class) {
                if (mInstance == null) {
                    mInstance = new HttpUtils();
                    RequestCall.setmHttpEngine(mHttpEngine);
                }
            }
        }
        return mInstance;

    }

    public GetHttpBuilder get() {
        return new GetHttpBuilder();
    }

    public PostHttpBuilder post() {
        return new PostHttpBuilder();
    }

    public void uploadAPI(String url, String uploadName, Map<String, String> headers, File file, EngineCallBack callback) {

    }

//
//    public static String UrlBuide(String mUrl, Map<String, String> mParamsMap) {
//        Uri.Builder builder = Uri.parse(mUrl).buildUpon();
//        Iterator<String> it = mParamsMap.keySet().iterator();
//        while (it.hasNext()) {
//            String key = it.next();
//            String value = mParamsMap.get(key);
//            builder.appendQueryParameter(key, value);
//        }
//        return builder.toString();
//    }
//
//    public static String Judgeurl(String weburl) {
//
//        if (weburl == null) {
//            return "";
//        }
//        if (weburl.length() > 0) {
//            if (weburl.toLowerCase(Locale.ENGLISH).trim().indexOf("http://") < 0 && weburl.toLowerCase(Locale.ENGLISH).trim().indexOf("https://") < 0) {
//                weburl = "" + weburl;
//            }
//        }
//        return Uri.decode(weburl);
//    }
}
