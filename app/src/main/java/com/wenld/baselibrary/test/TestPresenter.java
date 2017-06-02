package com.wenld.baselibrary.test;


import com.wenld.baselib.base.BaseModel;

public class TestPresenter implements TestContract.Persenter {
    protected TestContract.View v;
    protected TestContract.Model m;

    public TestPresenter(TestContract.View v) {
        this.v = v;
        m = new TestModel();
    }


    @Override
    public void changeTitle(final String testParams) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                m.requestData(testParams, new BaseModel.DataCallBack<String>() {
                    @Override
                    public void onSuccess(String s) {
                        v.setTitle(s);
                    }

                    @Override
                    public void onFailed(String msg) {

                    }

                });
            }
        }).start();

    }
}
