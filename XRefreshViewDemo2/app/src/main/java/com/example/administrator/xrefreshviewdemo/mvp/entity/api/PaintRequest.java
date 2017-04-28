package com.example.administrator.xrefreshviewdemo.mvp.entity.api;


import com.example.administrator.xrefreshviewdemo.mvp.HttpPostService;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.Api.BaseApi;

import retrofit2.Retrofit;
import rx.Observable;

/**
 * 测试数据
 * Created by WZG on 2016/7/16.
 */
public class PaintRequest extends BaseApi {
    //    接口需要传入的参数 可自定义不同类型
    /*任何你先要传递的参数*/
    String patientPhone;

    public PaintRequest(String patientPhone, String equipmentData) {
        this.patientPhone = patientPhone;
        this.equipmentData = equipmentData;
    }

    String equipmentData;


    /**
     * 默认初始化需要给定回调和rx周期类
     * 可以额外设置请求设置加载框显示，回调等（可扩展）
     * 设置可查看BaseApi
     */
    public PaintRequest() {
        setShowProgress(true);
        setCancel(true);
    }

    @Override
    public Observable getObservable(Retrofit retrofit) {
        HttpPostService httpService = retrofit.create(HttpPostService.class);
        return httpService.findPatient(patientPhone, equipmentData);
    }

}
