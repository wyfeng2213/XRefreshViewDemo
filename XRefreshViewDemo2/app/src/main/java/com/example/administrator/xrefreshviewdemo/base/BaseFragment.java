package com.example.administrator.xrefreshviewdemo.base;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.xrefreshviewdemo.application.MyApplication;


/**
 * Description:
 * Date：2017/03/20 15:23
 * Author: wangyong
 */

public abstract class BaseFragment extends Fragment {
    protected String TAG;
    protected MyApplication mApp;
    protected View mContentView;
    protected Activity mActivity;

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        TAG = this.getClass().getSimpleName();
        mApp = MyApplication.getInstance();
        mActivity = activity;
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            onUserVisible();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // 避免多次从xml中加载布局文件
        if (mContentView == null) {
            mContentView = getContentView(inflater,container);
            initView(mContentView);
            initData();
        } else {
            ViewGroup parent = (ViewGroup) mContentView.getParent();
            if (parent != null) {
                parent.removeView(mContentView);
            }
        }
        return mContentView;
    }

    public abstract View getContentView(LayoutInflater inflater,ViewGroup container);

    /**
     * 初始化View控件
     */
    protected abstract void initView(View mContentView);

    /**
     * 给View控件添加初始化数据
     */
    protected abstract void initData();

    /**
     * 当fragment对用户可见时，会调用该方法，可在该方法中懒加载网络数据
     */
    protected abstract void onUserVisible();


}
