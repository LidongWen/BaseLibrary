package com.wenld.baselib.LayoutController;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wenld.baselib.navigatbar.ViewHolder;

import static com.wenld.baselib.LayoutController.LayoutController.Builder.ViewLayoutParams.VIEW_TOGGER;

/**
 * <p/>
 * Author: 温利东 on 2017/3/14 15:18.
 * blog: http://blog.csdn.net/sinat_15877283
 * github: https://github.com/LidongWen
 */

public class LayoutController extends BaseLayoutController<LayoutController> {
    private Builder.ViewLayoutParams mParams;

    public LayoutController(Builder.ViewLayoutParams parent) {
        this.mParams = parent;
        createdAndBindView();
    }

    private void createdAndBindView() {
        View layoutView = LayoutInflater.from(mParams.mContext).
                inflate(mParams.layoutRes, mParams.mParent, false);
        if (mParams.layoutParams != null) {
            layoutView.setLayoutParams(mParams.layoutParams);
        }
        viewHolder = new ViewHolder(mParams.mContext, layoutView);
    }

    public LayoutController show() {
        toggerOrAddview();
        return this;
    }

    private void toggerOrAddview() {
        if (mParams.mParent.indexOfChild(viewHolder.getConvertView()) < 0) {
            if (mParams.mViewFlag == VIEW_TOGGER) {
                int index = mParams.mParent.indexOfChild(mParams.oldView);
                mParams.mParent.removeView(mParams.oldView);
                mParams.mParent.addView(viewHolder.getConvertView(), index);
            } else {
                mParams.mParent.addView(viewHolder.getConvertView());
            }
        }
    }

    public void removeView() {
        removeViewAndAddOldView();
    }

    private void removeViewAndAddOldView() {
        int index = mParams.mParent.indexOfChild(viewHolder.getConvertView());
        mParams.mParent.removeView(viewHolder.getConvertView());
        if (mParams.mViewFlag == VIEW_TOGGER) {
            if (index > 0) {
                mParams.mParent.addView(mParams.oldView, index);
            }
        }
    }

    public static class Builder {
        ViewLayoutParams viewLayoutParams;

        /**
         * 替换
         *
         * @param context
         * @param view
         * @param layoutRes
         */
        public Builder(Context context, View view, @LayoutRes Integer layoutRes) {
            this(context, view, null, layoutRes);
        }

        public Builder(Context context, View view, ViewGroup.LayoutParams layoutParams, @LayoutRes Integer layoutRes) {
            viewLayoutParams = new ViewLayoutParams(context, view, layoutParams);
            bindLayoutId(layoutRes);
        }

        /**
         * 添加
         *
         * @param context
         * @param parent
         * @param layoutRes
         */
        public Builder(Context context, ViewGroup parent, @LayoutRes Integer layoutRes) {
            this(context, parent, null, layoutRes);
        }

        public Builder(Context context, ViewGroup parent, ViewGroup.LayoutParams layoutParams, @LayoutRes Integer layoutRes) {
            viewLayoutParams = new ViewLayoutParams(context, parent, layoutParams);
            bindLayoutId(layoutRes);
        }

        private Builder bindLayoutId(@LayoutRes Integer layoutRes) {
            viewLayoutParams.layoutRes = layoutRes;
            return this;
        }

        public LayoutController build() {
            return new LayoutController(viewLayoutParams);
        }

        public static class ViewLayoutParams {
            Context mContext;
            ViewGroup mParent;
            View oldView;

            ViewGroup.LayoutParams layoutParams;
            @LayoutRes
            Integer layoutRes;

            int mViewFlag;
            final static int VIEW_ADD = 0;
            final static int VIEW_TOGGER = 1;


            public ViewLayoutParams(Context context, ViewGroup parent) {
                this(context, parent, null);
            }

            public ViewLayoutParams(Context context, View oldView, ViewGroup.LayoutParams layoutParams) {
                this.mContext = context;
                this.oldView = oldView;
                this.mParent = (ViewGroup) oldView.getParent();
                this.layoutParams = oldView.getLayoutParams();
                mViewFlag = VIEW_TOGGER;
            }

            public ViewLayoutParams(Context context, ViewGroup parent, ViewGroup.LayoutParams layoutParams) {
                this.mContext = context;
                this.mParent = parent;
                this.layoutParams = layoutParams;
                mViewFlag = VIEW_ADD;
            }
        }
    }
}

