package com.example.administrator.xrefreshviewdemo.mvp.mvp.presenter;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.Api.BaseApi;

/**
 * Description:
 * Date：2017/04/28 16:37
 * Author: wangyong
 */

public interface PaintPresenter extends BasePresenter {
    public void findPaint(RxAppCompatActivity rxAppCompatActivity, BaseApi baseApi);
}
