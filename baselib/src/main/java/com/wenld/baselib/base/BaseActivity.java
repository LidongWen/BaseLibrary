package com.wenld.baselib.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * <p/>
 * Author: wenld on 2017/5/25 14:52.
 * blog: http://www.jianshu.com/u/99f514ea81b3
 * github: https://github.com/LidongWen
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements BaseIView {
    protected P basePresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initView();
        basePresenter = initPresent();
        if (null != basePresenter) {
            basePresenter.attachedView(this);
        }
        onPrepared();

        ActivityManager.getAppManager().addActivity(this);

    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        ActivityManager.getAppManager().finishActivity(this);
        if (null != basePresenter) {
            basePresenter.deathView();
        }
        super.onDestroy();
    }
//
//
//    protected void setImmerseLayout(View view) {//设置沉浸式（4.4以上）
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            setImmerseLayout();
//            int statusBarHeight = DensityUtil.getStatusBarHeight(this.getBaseContext());
//            view.setPadding(0, statusBarHeight, 0, 0);
//        }
//    }
//
//    protected void setImmerseLayout() {//设置沉浸式（4.4以上）
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            Window window = getWindow();
//            window.setFlags(
//                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
//                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
//                window.setStatusBarColor(ContextCompat.getColor(this, R.color.color_transparenthalf));
//        }
//    }
//
//    /**
//     * 设置状态栏的颜色，目前只是在4.4以上有效
//     */
//    public void setStatusBarView(int color) {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            SystemBarTintManager tintManager = new SystemBarTintManager(this);
//            tintManager.setStatusBarTintEnabled(true);
//            tintManager.setNavigationBarTintEnabled(false);
//            tintManager.setTintColor(color);
//        }
//    }


    /**
     * 布局
     *
     * @author wangxj
     * @version 2016/6/12
     */
    protected abstract int getLayoutId();

    /**
     * 初始化布局
     *
     * @author wangxj
     * @version 2016/6/12
     */
    protected abstract void initView();

    /**
     * 初始化Present
     *
     * @author wangxj
     * @version 2016/6/12
     */
    protected abstract P initPresent();

    /**
     * 页面准备工作、流程
     *
     * @author wangxj
     * @version 2016/6/12
     */
    protected abstract void onPrepared();
}
