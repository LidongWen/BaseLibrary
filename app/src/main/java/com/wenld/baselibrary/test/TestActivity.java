package com.wenld.baselibrary.test;

import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.wenld.baselib.base.BaseActivity;
import com.wenld.baselibrary.R;
import com.wenld.superitem.SuperItemView;

public class TestActivity extends BaseActivity implements TestContract.View {
    String TAG = "TestActivity";
    private Toolbar toolbar;
    private SuperItemView superItemView;
    private TestContract.Persenter persenter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    public void initView() {
        setPresenter(new TestPresenter(this));

        toolbar = (Toolbar) findViewById(R.id.toolbar_activity_test);
        superItemView = (SuperItemView) findViewById(R.id.superItemVIew_test);

        setSupportActionBar(toolbar);
        toolbar.setTitle("IView");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(v -> persenter.changeTitle(toolbar.getTitle().toString()));

        superItemView.setOnCheckChangeListener(SuperItemView.SuperItemViewID.leftCheckBoxId, (buttonView, isChecked) -> {
            Log.e(TAG, isChecked + "");
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
