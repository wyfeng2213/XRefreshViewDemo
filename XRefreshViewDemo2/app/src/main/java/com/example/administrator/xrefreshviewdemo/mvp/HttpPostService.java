package com.example.administrator.xrefreshviewdemo.mvp;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * 测试接口service-post相关
 * Created by WZG on 2016/12/19.
 */

public interface HttpPostService {

    @FormUrlEncoded
    @POST("AppFiftyToneGraph/videoLink")
    Observable<String> getAllVedioBy(@Field("once_no") boolean once_no);

    /**
     * 获取患者资料信息
     *
     * @return
     */
    @FormUrlEncoded
    @POST("app/patientUser/select.action")
    Observable<String> findPatient(@Field("patientPhone") String patientPhone, @Field("equipmentData") String equipmentData);

}
