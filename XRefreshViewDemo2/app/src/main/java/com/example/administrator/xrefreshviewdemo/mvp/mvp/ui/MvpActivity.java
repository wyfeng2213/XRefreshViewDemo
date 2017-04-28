package com.example.administrator.xrefreshviewdemo.mvp.mvp.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.xrefreshviewdemo.R;
import com.example.administrator.xrefreshviewdemo.mvp.activity.BaseActivity;
import com.example.administrator.xrefreshviewdemo.mvp.entity.api.TestPostApi;
import com.example.administrator.xrefreshviewdemo.mvp.mvp.presenter.Plistener;
import com.example.administrator.xrefreshviewdemo.mvp.mvp.presenter.impl.TestPresenterImpl;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.exception.ApiException;


public class MvpActivity extends BaseActivity implements Vlistener, View.OnClickListener {

    private Plistener plistener;
    private TextView tv_test;
    private TextView tv_msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        initView();
        plistener = new TestPresenterImpl(this);
        tv_msg.setOnClickListener(this);
    }

    public static void startActivity(Context context) {
        Intent starter = new Intent(context, MvpActivity.class);
//        starter.putExtra();
        context.startActivity(starter);
    }

    @Override
    public void showProg() {
        showP();
    }

    @Override
    public void dismissProg() {
        dismissP();
    }

    @Override
    public void onNext(String s, String m) {
        tv_msg.setText("返回数据:" + s);
    }

    @Override
    public void onError(ApiException e) {
        tv_msg.setText("错误信息:" + e.getMessage() + "------" + e.getCode());
    }


    @Override
    protected void onPause() {
        super.onPause();
        dismissProg();
    }

    private void initView() {
        tv_test = (TextView) findViewById(R.id.tv_test);
        tv_msg = (TextView) findViewById(R.id.tv_msg);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_msg:
                TestPostApi postEntity = new TestPostApi();
                postEntity.setAll(true);
                plistener.startPost(MvpActivity.this, postEntity);
                break;
            case R.id.tv_test:
                break;
        }
    }
}
