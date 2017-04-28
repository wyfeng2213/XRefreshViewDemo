package com.example.administrator.xrefreshviewdemo.mvp.mvp.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.xrefreshviewdemo.R;
import com.example.administrator.xrefreshviewdemo.mvp.activity.BaseActivity;
import com.example.administrator.xrefreshviewdemo.mvp.entity.api.CommonData;
import com.example.administrator.xrefreshviewdemo.mvp.entity.api.PaintRequest;
import com.example.administrator.xrefreshviewdemo.mvp.entity.result.FindPatientResult;
import com.example.administrator.xrefreshviewdemo.mvp.mvp.presenter.PaintPresenter;
import com.example.administrator.xrefreshviewdemo.mvp.mvp.presenter.Plistener;
import com.example.administrator.xrefreshviewdemo.mvp.mvp.presenter.impl.PaintPresenterImpl;
import com.example.administrator.xrefreshviewdemo.mvp.mvp.presenter.impl.TestPresenterImpl;
import com.google.gson.Gson;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.exception.ApiException;


public class MvpActivity extends BaseActivity implements Vlistener, View.OnClickListener, PaintViewListener {

    private Plistener plistener;
    private TextView tv_test;
    private TextView tv_msg;
    PaintPresenter paintPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        initView();
        plistener = new TestPresenterImpl(this);
        tv_msg.setOnClickListener(this);
        paintPresenter = new PaintPresenterImpl(this);
    }

    public static void startActivity(Context context) {
        Intent starter = new Intent(context, MvpActivity.class);
//        starter.putExtra();
        context.startActivity(starter);
    }


    @Override
    public void onNext(String s, String m) {
        tv_msg.setText("返回数据:" + s);
    }

    @Override
    public void onSuccess(FindPatientResult findPatientResult) {
        tv_msg.setText("患者返回数据:" + new Gson().toJson(findPatientResult));
    }

    @Override
    public void onError(ApiException e) {
        tv_msg.setText("错误信息:" + e.getMessage() + "------" + e.getCode());
    }


    private void initView() {
        tv_test = (TextView) findViewById(R.id.tv_test);
        tv_msg = (TextView) findViewById(R.id.tv_msg);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_msg:
//                TestPostApi postEntity = new TestPostApi();
//                postEntity.setAll(true);
//                plistener.startPost(MvpActivity.this, postEntity);
                String patientPhone = "15876587123";
                String equipmentData = getCommonData();
                PaintRequest paintRequest = new PaintRequest(patientPhone, equipmentData);
                paintPresenter.findPaint(this, paintRequest);
                break;
            case R.id.tv_test:
                break;
        }
    }

    public String getCommonData() {
//        CommonData commonData = new CommonData("15876587110","","paint","","android6.0.1","Xiaomi Redmi 4X","1.0","");
        CommonData commonData = new CommonData();
        commonData.setPhone("15876587123");
        commonData.setUserName("");
        commonData.setUserRole("paint");
        commonData.setDeviceToken("");
        commonData.setSystemtype("android6.0.1");
        commonData.setModel("Xiaomi Redmi 4X");
        commonData.setPackageVesion("1.0");
        commonData.setSession("");

        return new Gson().toJson(commonData);
    }
}
