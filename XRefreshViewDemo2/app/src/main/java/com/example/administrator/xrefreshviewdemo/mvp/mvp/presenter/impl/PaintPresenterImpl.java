package com.example.administrator.xrefreshviewdemo.mvp.mvp.presenter.impl;

import com.example.administrator.xrefreshviewdemo.mvp.entity.result.FindPatientResult;
import com.example.administrator.xrefreshviewdemo.mvp.mvp.model.BaseModel;
import com.example.administrator.xrefreshviewdemo.mvp.mvp.model.impl.BaseModelImpl;
import com.example.administrator.xrefreshviewdemo.mvp.mvp.presenter.PaintPresenter;
import com.example.administrator.xrefreshviewdemo.mvp.mvp.ui.PaintViewListener;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.Api.BaseApi;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.exception.ApiException;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.listener.HttpOnNextListener;

/**
 * Description:
 * Date：2017/04/28 16:37
 * Author: wangyong
 */
public class PaintPresenterImpl implements PaintPresenter {

    public PaintPresenterImpl(PaintViewListener paintViewListener) {
        this.paintViewListener = paintViewListener;
        baseModel = BaseModelImpl.getInstance();
    }

    PaintViewListener paintViewListener;
    BaseModel baseModel;


    @Override
    public void findPaint(RxAppCompatActivity rxAppCompatActivity, BaseApi baseApi) {
        HttpOnNextListener httpOnNextListener = new HttpOnNextListener() {
            @Override
            public void onNext(String result, String method) {
                FindPatientResult findPatientResult = new Gson().fromJson(result, FindPatientResult.class);
                paintViewListener.onSuccess(findPatientResult);
            }

            @Override
            public void onError(ApiException e) {
                Logger.e(e.getCode() + "");
            }
        };
        baseModel.startPost(httpOnNextListener, rxAppCompatActivity, baseApi);
    }
}
