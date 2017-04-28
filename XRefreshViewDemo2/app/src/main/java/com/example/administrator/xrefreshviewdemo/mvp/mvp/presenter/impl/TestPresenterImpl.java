package com.example.administrator.xrefreshviewdemo.mvp.mvp.presenter.impl;

import com.example.administrator.xrefreshviewdemo.mvp.mvp.model.BaseModel;
import com.example.administrator.xrefreshviewdemo.mvp.mvp.model.impl.TestModelImpl;
import com.example.administrator.xrefreshviewdemo.mvp.mvp.presenter.Plistener;
import com.example.administrator.xrefreshviewdemo.mvp.mvp.ui.Vlistener;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.Api.BaseApi;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.exception.ApiException;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.listener.HttpOnNextListener;

/**
 * Description:
 * Date：2017/04/27 20:24
 * Author: wangyong
 */
public class TestPresenterImpl implements Plistener {

    private Vlistener vlistener;

    private BaseModel mlistener;


    public TestPresenterImpl(Vlistener viewListener) {
        this.vlistener = viewListener;
        mlistener = new TestModelImpl();
    }

    @Override
    public void startPost(RxAppCompatActivity rxAppCompatActivity, BaseApi baseApi) {
        HttpOnNextListener httpOnNextListener = new HttpOnNextListener() {
            @Override
            public void onNext(String resulte, String mothead) {
                vlistener.onNext(resulte, mothead);

            }

            @Override
            public void onError(ApiException e) {
                vlistener.onError(e);
            }
        };
        mlistener.startPost(httpOnNextListener, rxAppCompatActivity, baseApi);
    }

}
