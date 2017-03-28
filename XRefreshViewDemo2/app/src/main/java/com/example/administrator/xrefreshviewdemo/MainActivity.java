package com.example.administrator.xrefreshviewdemo;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.administrator.xrefreshviewdemo.calendar.CanendarActivity;
import com.example.administrator.xrefreshviewdemo.photo.PhotoActivity;
import com.example.administrator.xrefreshviewdemo.refresh.RefreshActivity;
import com.example.administrator.xrefreshviewdemo.switchbutton.SwitchButtonActivity;
import com.example.administrator.xrefreshviewdemo.tab.ScrollTabActivity;
import com.example.administrator.xrefreshviewdemo.zbar.ZbarActivity;
import com.example.administrator.xrefreshviewdemo.zxing.ZXingCreatePicActivity;
import com.example.administrator.xrefreshviewdemo.zxing.ZxingActivity;

public class MainActivity extends Activity implements View.OnClickListener {


    private Button bt_refresh;
    private Button bt_photo;
    private LinearLayout activity_take_photo;
    private Button bt_calendar;
    private Button bt_qrcode;
    private Button bt_switch;
    private Button bt_tab;
    private Button bt_zxing_qrcode;
    private Button bt_zxing_create;

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
        bt_qrcode = (Button) findViewById(R.id.bt_zbar_qrcode);
        bt_qrcode.setOnClickListener(this);
        bt_switch = (Button) findViewById(R.id.bt_switch);
        bt_switch.setOnClickListener(this);
        bt_tab = (Button) findViewById(R.id.bt_tab);
        bt_tab.setOnClickListener(this);
        bt_zxing_qrcode = (Button) findViewById(R.id.bt_zxing_qrcode);
        bt_zxing_qrcode.setOnClickListener(this);
        bt_zxing_create = (Button) findViewById(R.id.bt_zxing_create);
        bt_zxing_create.setOnClickListener(this);
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
            case R.id.bt_zbar_qrcode:
                ZbarActivity.startActivity(this);
                break;
            case R.id.bt_zxing_qrcode:
                ZxingActivity.startActivity(this);
                break;
            case R.id.bt_switch:
                SwitchButtonActivity.startActivity(this);
                break;
            case R.id.bt_tab:
                ScrollTabActivity.startActivity(this);
                break;
            case R.id.bt_zxing_create:
                ZXingCreatePicActivity.startActivity(this);
                break;
        }
    }
}
