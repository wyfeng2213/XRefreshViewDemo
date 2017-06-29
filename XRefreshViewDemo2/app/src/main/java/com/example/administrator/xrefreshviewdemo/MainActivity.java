package com.example.administrator.xrefreshviewdemo;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.administrator.xrefreshviewdemo.calendar.CanendarActivity;
import com.example.administrator.xrefreshviewdemo.chart.ChartActivity;
import com.example.administrator.xrefreshviewdemo.expandablelist.animalistview.AnimatedListViewTestActivity;
import com.example.administrator.xrefreshviewdemo.headlistview.HeadListViewActivity;
import com.example.administrator.xrefreshviewdemo.iosdialog.IosDialogActivity;
import com.example.administrator.xrefreshviewdemo.listviewdelete.ListViewDelDemoActivity;
import com.example.administrator.xrefreshviewdemo.listviewletter.ListviewLetterActivity;
import com.example.administrator.xrefreshviewdemo.loading.LoadingActivity;
import com.example.administrator.xrefreshviewdemo.mpAndroidChart.LineChatActivity;
import com.example.administrator.xrefreshviewdemo.mvp.mvp.ui.MvpActivity;
import com.example.administrator.xrefreshviewdemo.ormlite.OrmLiteActivity;
import com.example.administrator.xrefreshviewdemo.permission.PermissionTestActivity;
import com.example.administrator.xrefreshviewdemo.photo.PhotoActivity;
import com.example.administrator.xrefreshviewdemo.refresh.RefreshActivity;
import com.example.administrator.xrefreshviewdemo.shape.ShapeActivity;
import com.example.administrator.xrefreshviewdemo.supertext.SuperTextViewActivity;
import com.example.administrator.xrefreshviewdemo.switchbutton.SwitchButtonActivity;
import com.example.administrator.xrefreshviewdemo.tab.GuideActivity;
import com.example.administrator.xrefreshviewdemo.tab.MoreTab2Activity;
import com.example.administrator.xrefreshviewdemo.tab.ScrollTabActivity;
import com.example.administrator.xrefreshviewdemo.toolbar.ToolBarTestActivty2;
import com.example.administrator.xrefreshviewdemo.wheelview.WheelActivity;
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
    private Button bt_tab2;
    private Button bt_tab3;
    private Button bt_wheel;
    private Button bt_chat;
    private Button bt_zbar_qrcode;
    private Button bt_toolbar;
    private Button bt_head_suspension;
    private Button bt_expandable_listview;
    private Button bt_letter;
    private Button bt_listviewdel;
    private Button bt_mvp;
    private Button bt_ormlite;
    private Button bt_mpAndroidChart;
    private Button bt_loading;
    private Button bt_super_textview;
    private Button bt_iosDialog;
    private Button bt_shape;
    private Button bt_permission;

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
        bt_tab2 = (Button) findViewById(R.id.bt_tab2);
        bt_tab2.setOnClickListener(this);
        bt_tab3 = (Button) findViewById(R.id.bt_tab3);
        bt_tab3.setOnClickListener(this);
        bt_wheel = (Button) findViewById(R.id.bt_wheel);
        bt_wheel.setOnClickListener(this);
        bt_chat = (Button) findViewById(R.id.bt_chat);
        bt_chat.setOnClickListener(this);
        bt_zbar_qrcode = (Button) findViewById(R.id.bt_zbar_qrcode);
        bt_zbar_qrcode.setOnClickListener(this);
        bt_toolbar = (Button) findViewById(R.id.bt_toolbar);
        bt_toolbar.setOnClickListener(this);
        bt_head_suspension = (Button) findViewById(R.id.bt_head_suspension);
        bt_head_suspension.setOnClickListener(this);
        bt_expandable_listview = (Button) findViewById(R.id.bt_expandable_listview);
        bt_expandable_listview.setOnClickListener(this);
        bt_letter = (Button) findViewById(R.id.bt_letter);
        bt_letter.setOnClickListener(this);
        bt_listviewdel = (Button) findViewById(R.id.bt_listviewdel);
        bt_listviewdel.setOnClickListener(this);
        bt_mvp = (Button) findViewById(R.id.bt_mvp);
        bt_mvp.setOnClickListener(this);
        bt_ormlite = (Button) findViewById(R.id.bt_ormlite);
        bt_ormlite.setOnClickListener(this);
        bt_mpAndroidChart = (Button) findViewById(R.id.bt_mpAndroidChart);
        bt_mpAndroidChart.setOnClickListener(this);
        bt_loading = (Button) findViewById(R.id.bt_loading);
        bt_loading.setOnClickListener(this);
        bt_super_textview = (Button) findViewById(R.id.bt_super_textview);
        bt_super_textview.setOnClickListener(this);
        bt_iosDialog = (Button) findViewById(R.id.bt_iosDialog);
        bt_iosDialog.setOnClickListener(this);
        bt_shape = (Button) findViewById(R.id.bt_shape);
        bt_shape.setOnClickListener(this);
        bt_permission = (Button) findViewById(R.id.bt_permission);
        bt_permission.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //下拉刷新
            case R.id.bt_refresh:
                RefreshActivity.startActivity(this);
                break;
            //拍照和选择相册
            case R.id.bt_photo:
                PhotoActivity.startActivity(this);
                break;
            //日历控件
            case R.id.bt_calendar:
                CanendarActivity.startActivity(this);
                break;
            //zbar使用
            case R.id.bt_zbar_qrcode:
                ZbarActivity.startActivity(this);
                break;
            //zxing使用
            case R.id.bt_zxing_qrcode:
                ZxingActivity.startActivity(this);
                break;
            //滑动开关
            case R.id.bt_switch:
                SwitchButtonActivity.startActivity(this);
                break;
            //tab滑动
            case R.id.bt_tab:
                ScrollTabActivity.startActivity(this);
                break;
            //二维码生成
            case R.id.bt_zxing_create:
                ZXingCreatePicActivity.startActivity(this);
                break;
            //滑动tab带下划线
            case R.id.bt_tab2:
                MoreTab2Activity.startActivity(this);
                break;
            //带白色小点的滑动
            case R.id.bt_tab3:
                GuideActivity.startActivity(this);
                break;
            //滚轮的滑动
            case R.id.bt_wheel:
                WheelActivity.startActivity(this);
                break;
            //图表
            case R.id.bt_chat:
                ChartActivity.startActivity(this);
                break;
            //bt_toolbar的使用
            case R.id.bt_toolbar:
                ToolBarTestActivty2.startActivity(this);
                break;
            // listview 头部的悬浮
            case R.id.bt_head_suspension:
                HeadListViewActivity.startActivity(this);
                break;
            // 可折叠的listview
            case R.id.bt_expandable_listview:
                AnimatedListViewTestActivity.startActivity(this);
//                ExpandableListViewTestActivity.startActivity(this);
                break;
            // 侧面字母栏
            case R.id.bt_letter:
                ListviewLetterActivity.startActivity(this);
                break;
            //侧滑删除
            case R.id.bt_listviewdel:
                ListViewDelDemoActivity.startActivity(this);
                break;
            // 测试mvp 模式
            case R.id.bt_mvp:
                MvpActivity.startActivity(this);
                break;
            //ormlite 使用
            case R.id.bt_ormlite:
                OrmLiteActivity.startActivity(this);
                break;
            //MPAndroidChart 的使用
            case R.id.bt_mpAndroidChart:
                LineChatActivity.startActivity(this);
                break;
            //加载框
            case R.id.bt_loading:
                LoadingActivity.startActivity(this);
                break;
            //SuperTextView的使用
            case R.id.bt_super_textview:
                SuperTextViewActivity.startActivity(this);
                break;
            //ios dialog的使用
            case R.id.bt_iosDialog:
                IosDialogActivity.startActivity(this);
                break;
            //动态设置shape
            case R.id.bt_shape:
                ShapeActivity.startActivity(this);
                break;
            //动态权限申请
            case R.id.bt_permission:
                PermissionTestActivity.startActivity(this);
                break;
        }
    }
}
