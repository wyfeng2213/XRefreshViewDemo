package com.example.administrator.xrefreshviewdemo.androidview;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.cmcc.healthlibrary.utils.ToastUtil;
import com.example.administrator.xrefreshviewdemo.R;

import java.util.Calendar;

public class AndroidViewActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_dialog;
    private Button bt_date;
    private LinearLayout activity_android_view;
    Context mContext;
    private Button bt_dialog_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_view);
        initView();
        mContext = this;
    }

    public static void startActivity(Context context) {
        Intent starter = new Intent(context, AndroidViewActivity.class);
        context.startActivity(starter);
    }

    private void initView() {
        bt_dialog = (Button) findViewById(R.id.bt_dialog);
        bt_date = (Button) findViewById(R.id.bt_date);
        activity_android_view = (LinearLayout) findViewById(R.id.activity_android_view);

        bt_dialog.setOnClickListener(this);
        bt_date.setOnClickListener(this);
        bt_dialog_list = (Button) findViewById(R.id.bt_dialog_list);
        bt_dialog_list.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_dialog:
                showSelectDialog(v);
                break;
            case R.id.bt_date:
                showDate(v);
                break;
            case R.id.bt_dialog_list:
                showListDialog(v);
                break;
        }
    }

    final Calendar ca = Calendar.getInstance();
    int mYear = ca.get(Calendar.YEAR);
    int mMonth = ca.get(Calendar.MONTH);
    int mDay = ca.get(Calendar.DAY_OF_MONTH);

    public void showDate(View v) {
        new DatePickerDialog(this, mdateListener, mYear, mMonth, mDay).show();
    }

    private DatePickerDialog.OnDateSetListener mdateListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            mYear = year;
            mMonth = monthOfYear;
            mDay = dayOfMonth;
            String date = mYear + "-" + mMonth + "-" + mDay;
            ToastUtil.show(mContext, "选择日期: " + date);
        }
    };

    // 警告对话框，需要用Builder方法创建
    public void showSelectDialog(View v) {
        // 这里的属性可以一直设置，因为每次设置后返回的是一个builder对象
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        // 设置提示框的标题
        builder.setTitle("提示标题").
                // 设置提示框的图标
//                        setIcon(R.drawable.ic_launcher).
                // 设置要显示的信息
                        setMessage("文本的提示信息：你妈喊你回家吃饭了！").
                // 设置确定按钮
                        setPositiveButton("确定", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(mContext, "选择就确定哦", Toast.LENGTH_LONG).show();

                    }
                }).

                // 设置取消按钮,null是什么都不做
                        setNegativeButton("取消", null);
        // 生产对话框
        android.app.AlertDialog alertDialog = builder.create();
        // 显示对话框
        alertDialog.show();

    }


    //数据源
    String[] array = new String[]{"音乐", "体育", "舞蹈", "看书"};

    // 显示一个菜单的对话框选项，点击选择菜单后，菜单会消失

    // 匿名类去创建
    public void showListDialog(View v) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // 设置标题
        builder.setTitle("选择你最喜欢的课程").
                // 设置可选择的内容，并添加点击事件
                        setItems(array, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // which代表的是选择的标签的序列号

                        Toast.makeText(mContext, "选择" + array[which],
                                Toast.LENGTH_LONG).show();

                    }
                });
        // 产生对话框，并显示出来
        builder.create().show();
    }
}
