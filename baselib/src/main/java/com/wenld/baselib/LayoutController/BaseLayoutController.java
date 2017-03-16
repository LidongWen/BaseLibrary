package com.wenld.baselib.LayoutController;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.wenld.baselib.navigatbar.ViewHolder;

/**
 * <p/>
 * Author: 温利东 on 2017/3/14 15:18.
 * blog: http://blog.csdn.net/sinat_15877283
 * github: https://github.com/LidongWen
 */

public class BaseLayoutController<T extends BaseLayoutController> {

    protected ViewHolder viewHolder;

    public T setText(int viewId, String text) {
        viewHolder.setText(viewId, text);
        return (T) this;
    }

    public T setText(int viewId, CharSequence text) {
        viewHolder.setText(viewId, text);
        return (T) this;
    }

    public T setImageResource(int viewId, int resId) {
        viewHolder.setImageResource(viewId, resId);
        return (T) this;
    }

    public T setImageBitmap(int viewId, Bitmap bitmap) {
        viewHolder.setImageBitmap(viewId, bitmap);
        return (T) this;
    }

    public T setImageDrawable(int viewId, Drawable drawable) {
        viewHolder.setImageDrawable(viewId, drawable);
        return (T) this;
    }

    public T setBackgroundColor(int viewId, int color) {
        viewHolder.setBackgroundColor(viewId, color);

        return (T) this;
    }

    public T setBackgroundRes(int viewId, int backgroundRes) {
        viewHolder.setBackgroundRes(viewId, backgroundRes);
        return (T) this;
    }

    public T setTextColor(int viewId, int textColor) {
        viewHolder.setTextColor(viewId, textColor);
        return (T) this;
    }

    public T setTextColorRes(int viewId, int textColorRes) {
        viewHolder.setAlpha(viewId, textColorRes);
        return (T) this;
    }

    @SuppressLint("NewApi")
    public T setAlpha(int viewId, float value) {
        viewHolder.setAlpha(viewId, value);
        return (T) this;
    }

    public T setVisible(int viewId, boolean visible) {
        viewHolder.setVisible(viewId, visible);
        return (T) this;
    }

    public <T extends View> T getView(int viewId) {
        return viewHolder.getView(viewId);
    }


    public T linkify(int viewId) {
        viewHolder.linkify(viewId);
        return (T) this;
    }

    public T setTypeface(Typeface typeface, int... viewIds) {
        viewHolder.setTypeface(typeface, viewIds);
        return (T) this;
    }

    public T setProgress(int viewId, int progress) {
        viewHolder.setProgress(viewId, progress);
        return (T) this;
    }

    public T setProgress(int viewId, int progress, int max) {
        viewHolder.setProgress(viewId, progress, max);
        return (T) this;
    }

    public T setMax(int viewId, int max) {
        viewHolder.setMax(viewId, max);
        return (T) this;
    }

    public T setRating(int viewId, float rating) {
        viewHolder.setRating(viewId, rating);
        return (T) this;
    }

    public T setRating(int viewId, float rating, int max) {
        viewHolder.setRating(viewId, rating, max);
        return (T) this;
    }

    public T setTag(int viewId, Object tag) {
        viewHolder.setTag(viewId, tag);
        return (T) this;
    }

    public T setTag(int viewId, int key, Object tag) {
        viewHolder.setTag(viewId, key, tag);
        return (T) this;
    }

    public T setChecked(int viewId, boolean checked) {
        viewHolder.setChecked(viewId, checked);
        return (T) this;
    }


    public T setOnClickListener(int viewId,
                                View.OnClickListener listener) {
        viewHolder.setOnClickListener(viewId, listener);
        return (T) this;
    }

    public T setOnLongClickListener(int viewId,
                                    View.OnLongClickListener listener) {
        viewHolder.setOnLongClickListener(viewId, listener);
        return (T) this;
    }

    public T setOnTouchListener(int viewId,
                                View.OnTouchListener listener) {
        viewHolder.setOnTouchListener(viewId, listener);
        return (T) this;
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

}

