package com.example.administrator.xrefreshviewdemo.base;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;

import com.example.administrator.xrefreshviewdemo.application.SystemApplication;
import com.jph.takephoto.app.TakePhotoActivity;

/**
 * Description:
 * Date：2017/03/24 10:05
 * Author: wangyong
 */

public abstract class BasePhotoActivity extends TakePhotoActivity {
    public static String TAG;
    public Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        mContext = this;
        TAG = this.getClass().getSimpleName();
        SystemApplication.getInstance().addActivity(this);
    }

    @Override
    protected void onResume() {
        /**
         * 设置为横屏
         */
        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        super.onResume();
    }

    /**
     * 初始化事件
     */
    public abstract void initView();

    /**
     * 初始化数据
     */
    public abstract void initData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SystemApplication.getInstance().removeActivity(this);
    }
}
