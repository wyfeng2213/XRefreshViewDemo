package com.example.administrator.xrefreshviewdemo.mvp.mvp.ui;

import com.wzgiceman.rxretrofitlibrary.retrofit_rx.exception.ApiException;

/**
 * Created by WZG on 2016/12/26.
 */

public interface Vlistener {



    void onNext(String s, String m);

    void  onError(ApiException e);

}
