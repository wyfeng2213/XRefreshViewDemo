package com.example.administrator.xrefreshviewdemo.mvp.mvp.model.impl;

import com.example.administrator.xrefreshviewdemo.mvp.mvp.model.BaseModel;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.Api.BaseApi;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.http.HttpManager;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.listener.HttpOnNextListener;

/**
 * Description:
 * Date：2017/04/28 16:35
 * Author: wangyong
 */
public class BaseModelImpl implements BaseModel {
    public static BaseModelImpl singleton = null;

    public static BaseModelImpl getInstance() {
        if (singleton == null) {
            singleton = new BaseModelImpl();
        }
        return singleton;
    }
    @Override
    public void startPost(HttpOnNextListener httpOnNextListener, RxAppCompatActivity rxAppCompatActivity, BaseApi baseApi) {
        HttpManager manager = new HttpManager(httpOnNextListener, rxAppCompatActivity);
        manager.doHttpDeal(baseApi);
    }
}
