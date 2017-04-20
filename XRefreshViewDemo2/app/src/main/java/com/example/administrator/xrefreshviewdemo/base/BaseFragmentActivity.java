package com.example.administrator.xrefreshviewdemo.base;

import android.app.Dialog;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;

import com.example.administrator.xrefreshviewdemo.application.SystemApplication;


/**
 * @author shuyang on 15/7/11.
 */
public abstract class BaseFragmentActivity extends FragmentActivity {

    public Dialog diaolog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        SystemApplication.getInstance().addActivity(this);
    }


    @Override
    protected void onResume() {
        /**
         * 设置为竖屏
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
