package com.example.administrator.xrefreshviewdemo.application;

import android.app.Activity;
import android.app.Application;

import java.util.Stack;

/**
 * Description:
 * Date：2017/03/15 10:30
 * Author: wangyong
 */

public class SystemApplication extends Application {
    private static Stack<Activity> mActivityStack;
    private static SystemApplication sysApplication;

    public static SystemApplication getInstance() {
        if (sysApplication == null) {
            sysApplication = new SystemApplication();
        }
        return sysApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
//        EaseUI.getInstance().init(this, null);
        // 异常信息收集
//        CrashHandlerUtil crashHandlerUtil = CrashHandlerUtil.getInstance();
//        crashHandlerUtil.init(this);
//        crashHandlerUtil.setCrashTip(getString(R.string.str_crash_tip));
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
