package com.wenld.baselibrary.test;

import com.wenld.baselib.base.BaseIView;
import com.wenld.baselib.base.BaseModel;
import com.wenld.baselib.base.BasePresenter;

/**
 * <p/>
 * Author: wenld on 2017/6/2 14:15.
 * blog: http://www.jianshu.com/u/99f514ea81b3
 * github: https://github.com/LidongWen
 */

public class TestContract {
    public interface View extends BaseIView<Persenter> {
        void setTitle(String s);
    }

    public interface Persenter extends BasePresenter<View, Model> {
        void changeTitle(String testParams);
    }

    public interface Model extends BaseModel {
        /**
         * 请求数据
         * @param params
         * @param dataCallBack
         */
        void requestData(String params, DataCallBack dataCallBack);
    }
}
