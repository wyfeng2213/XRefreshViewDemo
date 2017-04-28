package com.example.administrator.xrefreshviewdemo.mvp.mvp.model.impl;

import com.example.administrator.xrefreshviewdemo.mvp.mvp.model.Mlistener;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.Api.BaseApi;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.http.HttpManager;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.listener.HttpOnNextListener;

/**
 * Description:
 * Date：2017/04/27 20:23
 * Author: wangyong
 */
public class TestModelImpl implements Mlistener {

    @Override
    public void startPost(HttpOnNextListener httpOnNextListener, RxAppCompatActivity rxAppCompatActivity, BaseApi baseApi) {
        HttpManager manager = new HttpManager(httpOnNextListener, rxAppCompatActivity);
        manager.doHttpDeal(baseApi);
    }
}
