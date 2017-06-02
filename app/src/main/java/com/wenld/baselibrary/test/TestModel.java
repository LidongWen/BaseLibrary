package com.wenld.baselibrary.test;

import android.os.Handler;
import android.os.Looper;

import com.google.common.base.Strings;

/**
 * <p/>
 * Author: wenld on 2017/6/2 14:32.
 * blog: http://www.jianshu.com/u/99f514ea81b3
 * github: https://github.com/LidongWen
 */

public class TestModel implements TestContract.Model {
    private String str;

    @Override
    public void requestData(String params, final DataCallBack dataCallBack) {
        // 从内存中拿数据
        if (!Strings.isNullOrEmpty(str)) {

        }
        // 从本地拿数据
        else if (!Strings.isNullOrEmpty(str)) {

        }
        // 从网络拿数据
        else {
            str = "这是新的标题";
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    dataCallBack.onSuccess(str);
                }
            });
        }
    }
}
