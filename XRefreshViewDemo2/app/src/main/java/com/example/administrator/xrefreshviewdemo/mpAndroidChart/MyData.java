package com.example.administrator.xrefreshviewdemo.mpAndroidChart;

/**
 * Description:
 * Date：2017/05/24 16:48
 * Author: wangyong
 */

public class MyData {
    String time;

    public MyData(String time, int data) {
        this.time = time;
        this.data = data;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    int data;

}
