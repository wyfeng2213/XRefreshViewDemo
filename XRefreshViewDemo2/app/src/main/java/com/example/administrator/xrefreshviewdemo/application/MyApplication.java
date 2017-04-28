package com.example.administrator.xrefreshviewdemo.application;

import android.app.Activity;
import android.app.Application;

import com.example.administrator.xrefreshviewdemo.util.PreferencesUtils;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.RxRetrofitApp;

import java.util.Stack;

/**
 * Description:
 * Date：2017/03/15 10:30
 * Author: wangyong
 */

public class MyApplication extends Application {
    private static Stack<Activity> mActivityStack;
    private static MyApplication myApp;

    public static PreferencesUtils getPreferences() {
        return preferencesUtils;
    }

    public static PreferencesUtils preferencesUtils;

    public static MyApplication getInstance() {
        if (myApp == null) {
            myApp = new MyApplication();
        }
        return myApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        RxRetrofitApp.init(this);
    }


    /**
     * get current activity
     */
    public Activity getCurActivity() {
        return mActivityStack.lastElement();
    }


    // 移除activity
    public void removeActivity(Activity activity) {
        if (activity != null) {
            mActivityStack.remove(activity);
        }
    }

    // 将当前Activity推入栈中
    public void addActivity(Activity activity) {
        if (mActivityStack == null) {
            mActivityStack = new Stack<Activity>();
        }
        mActivityStack.add(activity);
    }

    // 退出栈中所有Activity
    public void clearAllActivity() {
        while (!mActivityStack.isEmpty()) {
            Activity activity = mActivityStack.pop();
            if (activity != null) {
                activity.finish();
            }
        }
    }

}
