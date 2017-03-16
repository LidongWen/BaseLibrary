package com.wenld.baselib.LayoutController;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
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

public class LayoutController {
    private Builder.ViewLayoutParams mParams;
    View layoutView;
    ViewHolder viewHolder;

    public LayoutController(Builder.ViewLayoutParams parent) {
        this.mParams = parent;
        createdAndBindView();
    }

    private void createdAndBindView() {
        layoutView = LayoutInflater.from(mParams.mContext).
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
        if (mParams.mParent.indexOfChild(layoutView) < 0) {
            if (mParams.mViewFlag == VIEW_TOGGER) {
                int index = mParams.mParent.indexOfChild(mParams.oldView);
                mParams.mParent.removeView(mParams.oldView);
                mParams.mParent.addView(layoutView, index);
            } else {
                mParams.mParent.addView(layoutView);
            }
        }
    }

    public void removeView() {
        removeViewAndAddOldView();
    }

    private void removeViewAndAddOldView() {
        int index = mParams.mParent.indexOfChild(layoutView);
        mParams.mParent.removeView(layoutView);
        if (mParams.mViewFlag == VIEW_TOGGER) {
            if (index > 0) {
                mParams.mParent.addView(mParams.oldView, index);
            }
        }
    }

    public LayoutController setText(int viewId, String text) {
        viewHolder.setText(viewId, text);
        return this;
    }

    public LayoutController setText(int viewId, CharSequence text) {
        viewHolder.setText(viewId, text);
        return this;
    }

    public LayoutController setImageResource(int viewId, int resId) {
        viewHolder.setImageResource(viewId, resId);
        return this;
    }

    public LayoutController setImageBitmap(int viewId, Bitmap bitmap) {
        viewHolder.setImageBitmap(viewId, bitmap);
        return this;
    }

    public LayoutController setImageDrawable(int viewId, Drawable drawable) {
        viewHolder.setImageDrawable(viewId, drawable);
        return this;
    }

    public LayoutController setBackgroundColor(int viewId, int color) {
        viewHolder.setBackgroundColor(viewId, color);

        return this;
    }

    public LayoutController setBackgroundRes(int viewId, int backgroundRes) {
        viewHolder.setBackgroundRes(viewId, backgroundRes);
        return this;
    }

    public LayoutController setTextColor(int viewId, int textColor) {
        viewHolder.setTextColor(viewId, textColor);
        return this;
    }

    public LayoutController setTextColorRes(int viewId, int textColorRes) {
        viewHolder.setAlpha(viewId, textColorRes);
        return this;
    }

    @SuppressLint("NewApi")
    public LayoutController setAlpha(int viewId, float value) {
        viewHolder.setAlpha(viewId, value);
        return this;
    }

    public LayoutController setVisible(int viewId, boolean visible) {
        viewHolder.setVisible(viewId, visible);
        return this;
    }

    public <T extends View> T getView(int viewId) {
        return viewHolder.getView(viewId);
    }

    public LayoutController setOnClickListener(int viewId,
                                               View.OnClickListener listener) {
        viewHolder.setOnClickListener(viewId, listener);
        return this;
    }

    public LayoutController setOnLongClickListener(int viewId,
                                                   View.OnLongClickListener listener) {
        viewHolder.setOnLongClickListener(viewId, listener);
        return this;
    }

    public LayoutController setOnTouchListener(int viewId,
                                               View.OnTouchListener listener) {
        viewHolder.setOnTouchListener(viewId, listener);
        return this;
    }


    public static class Builder {
        ViewLayoutParams viewLayoutParams;

        /**
         *   替换
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
//
//        public Builder setOnClickListener(int viewId,
//                                          View.OnClickListener listener) {
//            viewLayoutParams.onClickListeners.put(viewId, listener);
//            return this;
//        }
//
//        public Builder setOnLongClickListener(int viewId,
//                                              View.OnLongClickListener listener) {
//            viewLayoutParams.onLongClickListeners.put(viewId, listener);
//            return this;
//        }

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
//                onClickListeners = new SparseArray<>();
//                onLongClickListeners = new SparseArray<>();
            }

            public ViewLayoutParams(Context context, ViewGroup parent, ViewGroup.LayoutParams layoutParams) {
                this.mContext = context;
                this.mParent = parent;
                this.layoutParams = layoutParams;
                mViewFlag = VIEW_ADD;
//                onClickListeners = new SparseArray<>();
//                onLongClickListeners = new SparseArray<>();
            }
        }
    }
}

