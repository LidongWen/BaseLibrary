package com.wenld.baselibrary.http;

import com.wenld.baselib.http.EngineCallBack;
import com.zhy.http.okhttp.callback.Callback;

import okhttp3.Call;
import okhttp3.Response;

/**
 * <p/>
 * Author: 温利东 on  2017/3/6 23:23
 * blog: http://blog.csdn.net/sinat_15877283
 * github: https://github.com/LidongWen
 *
 * @Description
 */

public class OkHttpCallBack extends Callback<String> {
    EngineCallBack<String> callBack;

    public OkHttpCallBack(EngineCallBack callBack) {
        this.callBack = callBack;
    }

    @Override
    public String parseNetworkResponse(Response response, int id) throws Exception {
        return response.body().string();
    }

    @Override
    public void onError(Call call, Exception e, int id) {
        callBack.onError(e,id);
    }

    @Override
    public void onResponse(String response, int id) {
        callBack.onResponse(response,id);
    }
}
