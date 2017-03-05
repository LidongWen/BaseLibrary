package com.wenld.baselib.weight;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.wenld.baselib.R;
import com.wenld.baselib.navigatbar.AbsNavigationBar;


/**
 * Created by wenld on 2017/2/27.
 */

public class DefaultNavigationBar extends AbsNavigationBar {

    public DefaultNavigationBar(Builder.AbsNavigationBarParams parent) {
        super(parent);
    }

    @Override
    public int bindLayoutId() {
        return R.layout.topbar_common_single_text;
    }

    @Override
    public void applyVIew() {
//        setImageResource(R.id.iv_left, getmParams().leftIconRes);
//        setImageResource(R.id.iv_right, getmParams().rightIconRes);
//        setImageResource(R.id.iv_right_icon, getmParams().textRightIconRes);
//        setText(R.id.title_tv, getmParams().title);
//        setText(R.id.left_tv, getmParams().leftTv);
//        setText(R.id.right_tv, getmParams().rightTv);
//        setBackgroundColor(R.id.title_bar, getmParams().bgColor);
//        setOnClickListener(R.id.left_ll, getmParams().leftOnClickListener);
//        setOnClickListener(R.id.right_ll, getmParams().rightOnClickListener);
    }

    public static class Builder extends AbsNavigationBar.Builder {
        DefalutNavationParams params;

        public Builder(Context context, ViewGroup parent) {
            super(context, parent);
            params = new DefalutNavationParams(context, parent);
        }
        public Builder setTitle(String title) {
            params.title = title;
            return this;
        }

        public Builder setRight(String right) {
            params.rightTv = right;
            return this;
        }

        public Builder setLeft(String left) {
            params.leftTv = left;
            return this;
        }

        public Builder setLeftIcon(int iconRes) {
            params.leftIconRes = iconRes;
            return this;
        }

        public Builder setRightIcon(int iconRes) {
            params.rightIconRes = iconRes;
            return this;
        }

        public Builder setTitleBackgroundColor(int bgColor) {
            params.bgColor = bgColor;
            return this;
        }

        public Builder setLeftOnClickListener(View.OnClickListener onClickListener) {
            params.leftOnClickListener = onClickListener;
            return this;
        }

        public Builder setRightOnClickListener(View.OnClickListener onClickListener) {
            params.rightOnClickListener = onClickListener;
            return this;
        }
        @Override
        public DefaultNavigationBar create() {
            DefaultNavigationBar navigationBar = new DefaultNavigationBar(params);
            return navigationBar;
        }

        public static class DefalutNavationParams extends AbsNavigationBar.Builder.AbsNavigationBarParams {
            //标题
            public String title;
            //左边图片资源
            public int leftIconRes;
            //右边图片资源
            public int rightIconRes;
            //左边的点击事件
            public View.OnClickListener leftOnClickListener;
            //右边的点击事件
            public View.OnClickListener rightOnClickListener;
            public String leftTv;
            public String rightTv;
            public int bgColor;

            public DefalutNavationParams(Context context, ViewGroup parent) {
                super(context, parent);
            }
        }
    }
}
