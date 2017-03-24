package com.example.administrator.xrefreshviewdemo;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.administrator.xrefreshviewdemo.calendar.CanendarActivity;
import com.example.administrator.xrefreshviewdemo.photo.PhotoActivity;
import com.example.administrator.xrefreshviewdemo.refresh.RefreshActivity;
import com.example.administrator.xrefreshviewdemo.zbar.QrCodeScanActivity;

public class MainActivity extends Activity implements View.OnClickListener {


    private Button bt_refresh;
    private Button bt_photo;
    private LinearLayout activity_take_photo;
    private Button bt_calendar;
    private Button bt_qrcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        bt_refresh = (Button) findViewById(R.id.bt_refresh);
        bt_photo = (Button) findViewById(R.id.bt_photo);
        activity_take_photo = (LinearLayout) findViewById(R.id.activity_take_photo);

        bt_refresh.setOnClickListener(this);
        bt_photo.setOnClickListener(this);
        bt_calendar = (Button) findViewById(R.id.bt_calendar);
        bt_calendar.setOnClickListener(this);
        bt_qrcode = (Button) findViewById(R.id.bt_qrcode);
        bt_qrcode.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_refresh:
                RefreshActivity.startActivity(this);
                break;
            case R.id.bt_photo:
                PhotoActivity.startActivity(this);
                break;
            case R.id.bt_calendar:
                CanendarActivity.startActivity(this);
                break;
            case R.id.bt_qrcode:
                QrCodeScanActivity.startActivity(this);
                break;
        }
    }
}
