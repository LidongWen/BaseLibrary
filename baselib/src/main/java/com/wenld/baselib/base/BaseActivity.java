package com.wenld.baselib.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * <p/>
 * Author: wenld on 2017/5/25 14:52.
 * blog: http://www.jianshu.com/u/99f514ea81b3
 * github: https://github.com/LidongWen
 */

public abstract class BaseActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initView();
        initListener();
        ActivityManager.getAppManager().addActivity(this);

    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        ActivityManager.getAppManager().finishActivity(this);
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
    protected abstract void initListener();

    /**
     * startActivity
     *
     * @param clazz
     */
    protected void readyGo(Class<?> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    /**
     * startActivity with bundle
     *
     * @param clazz
     * @param bundle
     */
    protected void readyGo(Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * startActivity then onFinish
     *
     * @param clazz
     */
    protected void readyGoThenKill(Class<?> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
        finish();
    }

    /**
     * startActivity with bundle then onFinish
     *
     * @param clazz
     * @param bundle
     */
    protected void readyGoThenKill(Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
        finish();
    }

    /**
     * startActivityForResult
     *
     * @param clazz
     * @param requestCode
     */
    protected void readyGoForResult(Class<?> clazz, int requestCode) {
        Intent intent = new Intent(this, clazz);
        startActivityForResult(intent, requestCode);
    }

    /**
     * startActivityForResult with bundle
     *
     * @param clazz
     * @param requestCode
     * @param bundle
     */
    protected void readyGoForResult(Class<?> clazz, int requestCode, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }
}
