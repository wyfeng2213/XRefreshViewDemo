package com.example.administrator.xrefreshviewdemo.mvp.mvp.ui;

import com.example.administrator.xrefreshviewdemo.mvp.entity.result.FindPatientResult;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.exception.ApiException;

/**
 * Description:
 * Date：2017/04/28 16:38
 * Author: wangyong
 */

public interface PaintViewListener {
    void onSuccess(FindPatientResult findPatientResult);

    void onError(ApiException e);
}
