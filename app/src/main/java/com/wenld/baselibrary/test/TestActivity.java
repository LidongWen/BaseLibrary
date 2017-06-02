package com.wenld.baselibrary.test;

import android.support.v7.widget.Toolbar;
import android.view.View;

import com.wenld.baselib.base.BaseActivity;
import com.wenld.baselibrary.R;

public class TestActivity extends BaseActivity implements TestContract.View {

    private Toolbar toolbar;
    private TestContract.Persenter persenter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    public void initView() {
        setPresenter(new TestPresenter(this));

        toolbar = (Toolbar) findViewById(R.id.toolbar_activity_test);
        setSupportActionBar(toolbar);
        toolbar.setTitle("IView");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                persenter.changeTitle(toolbar.getTitle().toString());
            }
        });
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void setTitle(String s) {
        toolbar.setTitle(s);
    }

    @Override
    public void setPresenter(TestContract.Persenter presenter) {
        this.persenter = presenter;
    }
}
