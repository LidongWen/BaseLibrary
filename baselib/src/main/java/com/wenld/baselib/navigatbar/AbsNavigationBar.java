package com.wenld.baselib.navigatbar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by wenld on 2017/2/26.
 */

public abstract class AbsNavigationBar<P extends AbsNavigationBar.Builder.AbsNavigationBarParams> implements INavigationBar {


    private P mParams;
    View navigationView;

    public AbsNavigationBar(P parent) {
        this.mParams = parent;
        createdAndBindView();
    }

    private void createdAndBindView() {
        navigationView = LayoutInflater.from(mParams.mContext).
                inflate(bindLayoutId(), mParams.mParent, false);
//        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        navigationView.setLayoutParams(params);
        mParams.mParent.addView(navigationView, 0);
        applyVIew();
    }

    private P getmParams() {
        return mParams;
    }

    /**
     * 设置文本
     *
     * @param viewId
     * @param text
     */
    protected void setText(int viewId, CharSequence text) {
        TextView tv = findViewById(viewId);
        if (tv != null) {
            tv.setText(text);
        }
    }

    /**
     * 设置点击事件
     *
     * @param viewId
     * @param listener
     */
    protected void setOnClickListener(int viewId, View.OnClickListener listener) {
        View view = findViewById(viewId);
        if (view != null) {
            view.setOnClickListener(listener);
        }
    }


    /**
     * 设置背景资源
     *
     * @param viewId
     * @param resourceId
     */
    protected void setImageResource(int viewId, int resourceId) {
        ImageView imageView = findViewById(viewId);
        if (imageView != null) {
            imageView.setImageResource(resourceId);
        }
    }

    protected <T extends View> T findViewById(int id) {
        return (T) navigationView.findViewById(id);
    }


    public abstract static class Builder<P extends AbsNavigationBar> {

        public Builder(Context context, ViewGroup parent) {
        }

        public abstract P create();

        public static class AbsNavigationBarParams {
            Context mContext;
            ViewGroup mParent;

            public AbsNavigationBarParams(Context context, ViewGroup parent) {
                this.mContext = context;
                this.mParent = parent;
            }
        }
    }
}
