package com.wenld.baselibrary;

import android.app.Application;

import com.wenld.baselib.http.HttpUtils;
import com.wenld.baselibrary.http.ZhyHttpEngine;

/**
 * <p/>
 * Author: wenld on 2017/4/13 15:23.
 * blog: http://www.jianshu.com/u/99f514ea81b3
 * github: https://github.com/LidongWen
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        HttpUtils.initHttpEngine(new ZhyHttpEngine());
    }
}
