package com.wenld.baselib.base;


import android.app.Activity;

import java.util.Iterator;
import java.util.Stack;


/**
 * Activity基类
 *
 * @author chenjianbin
 * @version 2016/6/19
 */
public class ActivityManager {

    private static Stack<Activity> activityStack = new Stack<Activity>();
    private static ActivityManager instance;

    private ActivityManager() {
    }

    /**
     * 单一实例
     */
    public static ActivityManager getAppManager() {
        if (instance == null) {
            synchronized (ActivityManager.class) {
                instance = new ActivityManager();
            }
        }
        return instance;
    }

    /**
     * 添加Activity到堆栈
     */
    public void addActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<Activity>();
        }
        for (Iterator iterator = activityStack.iterator(); iterator.hasNext(); ) {
            Activity type = (Activity) iterator.next();
            if (type.equals(activity)) {
                iterator.remove();
            }
        }
        activityStack.add(activity);
    }

    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    public Activity currentActivity() {
        if (activityStack != null) {
            Activity activity = activityStack.lastElement();
            return activity;
        }
        return null;
    }

    /**
     * 结束当前Activity（堆栈中最后一个压入的）
     */
    public void finishActivity() {
        if (activityStack != null) {
            Activity activity = activityStack.lastElement();
            finishActivity(activity);
        }
    }

    /**
     * 结束指定的Activity
     */
    public void finishActivity(Activity activity) {
        if (activity != null && activityStack != null) {
            activityStack.remove(activity);
            activity.finish();
            activity = null;
        }
    }

    /**
     * 结束指定类名的Activity
     */
    public void finishActivity(Class<?> cls) {
        if (activityStack != null) {
            for (Iterator iterator = activityStack.iterator(); iterator.hasNext(); ) {
                Activity tempActivity = (Activity) iterator.next();
                if (tempActivity.getClass().equals(cls)) {
                    iterator.remove();
                    tempActivity.finish();
                    break;
                }
            }
        }
    }

    /**
     * 结束所有Activity
     */
    public void finishAllActivity() {
        if (activityStack != null) {
            for (int i = 0, size = activityStack.size(); i < size; i++) {
                if (null != activityStack.get(i)) {
                    activityStack.get(i).finish();
                }
            }
            activityStack.clear();
        }
    }


    /**
     * 退出应用程序
     */
    public void AppExit(Boolean isDowning) {
        try {
            finishAllActivity();
            if (!isDowning) {
                System.exit(0);
            }
        } catch (Exception e) {
        }
    }
}