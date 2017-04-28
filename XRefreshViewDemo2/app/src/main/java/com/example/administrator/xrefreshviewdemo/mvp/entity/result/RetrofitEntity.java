package com.example.administrator.xrefreshviewdemo.mvp.entity.result;

import java.util.List;

/**
 * 直接请求返回数据格式
 * Created by WZG on 2016/7/16.
 */
public class RetrofitEntity {
    private int ret;
    private String msg;
    private List<SubjectResult> data;

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<SubjectResult> getData() {
        return data;
    }

    public void setData(List<SubjectResult> data) {
        this.data = data;
    }
}
