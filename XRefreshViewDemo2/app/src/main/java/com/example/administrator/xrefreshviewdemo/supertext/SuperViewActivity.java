package com.example.administrator.xrefreshviewdemo.supertext;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.administrator.xrefreshviewdemo.R;

public class SuperViewActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt1;
    private Button bt2;
    private Button bt3;
    private Button bt4;
    private LinearLayout activity_super_view;
    private Button bt5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_super_view);
        initView();
    }

    public static void startActivity(Context context) {
        Intent starter = new Intent(context, SuperViewActivity.class);
        context.startActivity(starter);
    }

    private void initView() {
        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);
        bt3 = (Button) findViewById(R.id.bt3);
        bt4 = (Button) findViewById(R.id.bt4);
        activity_super_view = (LinearLayout) findViewById(R.id.activity_super_view);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5 = (Button) findViewById(R.id.bt5);
        bt5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //superText多行布局
            case R.id.bt1:
                SuperTextViewActivity.startActivity(this);
                break;
            //superText, shape的使用
            case R.id.bt2:
                SuperTextShapeActivity.startActivity(this);
                break;
            //superButton的使用
            case R.id.bt3:
                StateButtonActivity.startActivity(this);
                break;
            //红点的使用
            case R.id.bt4:
                BadgebuttonActivity.startActivity(this);
                break;
            case R.id.bt5:
                BadgeViewActivity.startActivity(this);
                break;
        }
    }
}
