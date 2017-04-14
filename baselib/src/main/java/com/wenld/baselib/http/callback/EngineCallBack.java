package com.wenld.baselib.http.callback;

/**
 * <p/>
 * Author: 温利东 on  2017/3/6 23:06
 * blog: http://blog.csdn.net/sinat_15877283
 * github: https://github.com/LidongWen
 *
 * @Description http引擎回调
 */

public abstract  class EngineCallBack<T> {
    public abstract void onError(Exception e, int id);

    public abstract void onResponse(T response, int id);
    /**
     * UI Thread
     *
     * @param progress
     */
    public void inProgress(float progress, long total , int id)
    {

    }
}
