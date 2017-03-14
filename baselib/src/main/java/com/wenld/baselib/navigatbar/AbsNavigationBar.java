package com.wenld.baselib.navigatbar;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by wenld on 2017/2/26.
 */

public abstract class AbsNavigationBar<P extends AbsNavigationBar.Builder.AbsNavigationBarParams> implements INavigationBar {


    private P mParams;
    View navigationView;
    ViewHolder viewHolder;

    public AbsNavigationBar(P parent) {
        this.mParams = parent;
        createdAndBindView();
    }

    private void createdAndBindView() {
        if (mParams.mParent == null)
            mParams.mParent = (ViewGroup) ((ViewGroup) ((Activity) mParams.mContext).getWindow().getDecorView()).getChildAt(0);

        navigationView = LayoutInflater.from(mParams.mContext).
                inflate(bindLayoutId(), mParams.mParent, false);
//        ViewGroup.ViewLayoutParams params = new ViewGroup.ViewLayoutParams(ViewGroup.ViewLayoutParams.MATCH_PARENT, ViewGroup.ViewLayoutParams.WRAP_CONTENT);
//        navigationView.setLayoutParams(params);
        mParams.mParent.addView(navigationView, 0);

        viewHolder = new ViewHolder(mParams.mContext, navigationView);
        applyVIew();
    }

    protected P getmParams() {
        return mParams;
    }

    /**
     * 设置文本
     *
     * @param viewId
     * @param text
     */
    protected void setText(int viewId, CharSequence text) {
        viewHolder.setText(viewId, text);
    }

    /**
     * 设置点击事件
     *
     * @param viewId
     * @param listener
     */
    protected void setOnClickListener(int viewId, View.OnClickListener listener) {
        viewHolder.setOnClickListener(viewId,listener);
    }


    /**
     * 设置背景资源
     *
     * @param viewId
     * @param resourceId
     */
    protected void setImageResource(int viewId, int resourceId) {
        viewHolder.setImageResource(viewId,resourceId);
    }

    protected <T extends View> T findViewById(int id) {
        return viewHolder.getView(id);
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
