package com.wenld.baselibrary.http;

import com.wenld.baselib.http.callback.EngineCallBack;
import com.zhy.http.okhttp.callback.Callback;

import okhttp3.Call;

/**
 * <p/>
 * Author: 温利东 on  2017/3/6 23:23
 * blog: http://blog.csdn.net/sinat_15877283
 * github: https://github.com/LidongWen
 *
 * @Description
 */

public abstract class OkHttpCallBack<T> extends Callback<T> {
    EngineCallBack callBack;

    public OkHttpCallBack(EngineCallBack callBack) {
        this.callBack = callBack;
    }

//    @Override
//    public T parseNetworkResponse(Response response, int id) throws Exception {
//        try {
//            Class<? super T> rawType;
//            rawType = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
//
//            return (T) FastJsonUtil.getListObjects(response.body().string(), rawType);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

    @Override
    public void onError(Call call, Exception e, int id) {
        if (callBack == null)
            return;
        callBack.onError(e, id);
    }

    @Override
    public void onResponse(T response, int id) {
        if (callBack == null)
            return;
        callBack.onResponse(response, id);
    }

}
