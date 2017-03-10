package com.wenld.baselibrary.http;

import android.net.Uri;

import com.wenld.baselib.http.EngineCallBack;

import java.io.File;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/**
 * <p/>
 * Author: 温利东 on  2017/3/6 23:30
 * blog: http://blog.csdn.net/sinat_15877283
 * github: https://github.com/LidongWen
 *
 * @Description
 */

public class HttpUtils{

    public  HttpUtils(){

    }

    public HttpBuilder get(){
        return new GetHttpBudilder();
    }
    public HttpBuilder post(){
        return new PostHttpBudilder();
    }


//    private static OkHttpEngine instance=new OkHttpEngine();
//
//
//
//    public static void postAPI(String url, Map<String, String> params, EngineCallBack callback) {
//        String content = Judgeurl(url);
//        instance.postAPI(content,params,callback);
//    }
//
//    public static void getAPI(String url, Map<String, String> params, EngineCallBack callback) {
//        String content = UrlBuide(url, params);
//        instance.getAPI(content,params,callback);
//    }
//
//    public static void postAPI(String url, Map<String, String> params, Map<String, String> headers, EngineCallBack callback) {
//        String content = Judgeurl(url);
//        instance.postAPI(content,params,headers,callback);
//    }
//
//    public static void getAPI(String url, Map<String, String> params, Map<String, String> headers, EngineCallBack callback) {
//        String content = UrlBuide(url, params);
//        instance.getAPI(content,params,headers,callback);
//    }

    public static void uploadAPI(String url, String uploadName, Map<String, String> headers, File file, EngineCallBack callback) {

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

    public static String Judgeurl(String weburl) {

        if (weburl == null) {
            return "";
        }
        if (weburl.length() > 0) {
            if (weburl.toLowerCase(Locale.ENGLISH).trim().indexOf("http://") < 0 && weburl.toLowerCase(Locale.ENGLISH).trim().indexOf("https://") < 0) {
                weburl = "" + weburl;
            }
        }
        return Uri.decode(weburl);
    }
}
