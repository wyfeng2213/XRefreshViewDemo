package com.example.administrator.xrefreshviewdemo.mvp.mvp.model;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.Api.BaseApi;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.listener.HttpOnNextListener;

/**
 * m层提供给p层的接口
 * Created by WZG on 2016/12/26.
 */

public interface Mlistener {

    /**
     * 开始任务
     *
     * @param rxAppCompatActivity
     * @param baseApi
     */

    void startPost(HttpOnNextListener httpOnNextListener, RxAppCompatActivity rxAppCompatActivity, BaseApi baseApi);


}
