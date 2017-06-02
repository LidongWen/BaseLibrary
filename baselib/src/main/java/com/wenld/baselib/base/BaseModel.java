package com.wenld.baselib.base;

/**
 * <p/>
 * Author: wenld on 2017/6/2 15:09.
 * blog: http://www.jianshu.com/u/99f514ea81b3
 * github: https://github.com/LidongWen
 */
public interface BaseModel {
    interface DataCallBack<T> {
        void onSuccess(T o);

        void onFailed(String msg);
    }
}