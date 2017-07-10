package com.example.administrator.xrefreshviewdemo.MyEdtitext;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.cmcc.healthlibrary.utils.ToastUtil;
import com.example.administrator.xrefreshviewdemo.R;

public class MyEditextActivity extends AppCompatActivity implements View.OnClickListener {

    private EditTextCount edit;
    private Button btnGetText;
    private LinearLayout activity_my_editext;
    private EditTextCount edit2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_editext);
        initView();
    }

    public static void startActivity(Context context) {
        Intent starter = new Intent(context, MyEditextActivity.class);
        context.startActivity(starter);
    }

    private void initView() {
        edit = (EditTextCount) findViewById(R.id.edit);
        btnGetText = (Button) findViewById(R.id.btnGetText);
        activity_my_editext = (LinearLayout) findViewById(R.id.activity_my_editext);

        edit.setEtHint("内容")//设置提示文字
                .setEtMinLines(2) //最小行数
                .setLength(20)//设置总字数
                //TextView显示类型(SINGULAR单数类型)(PERCENTAGE百分比类型)
                .setType(EditTextCount.PERCENTAGE)
//                .setLineColor(R.color.line_color1)//设置横线颜色
                .show();


        btnGetText.setOnClickListener(this);
        edit2 = (EditTextCount) findViewById(R.id.edit2);

        GradientDrawable drawable = new GradientDrawable();
        drawable.setCornerRadius(25);
        drawable.setColor(getResources().getColor(R.color.white));
        edit2.setBackgroundDrawable(drawable);

        edit2.setOnClickListener(this);
        edit2.setEtHint("内容")//设置提示文字
                .setEtMinLines(2) //最小行数
                .setLength(20)//设置总字数
                //TextView显示类型(SINGULAR单数类型)(PERCENTAGE百分比类型)
                .setType(EditTextCount.SINGULAR)
//                .setLineColor(R.color.line_color1)//设置横线颜色
                .show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnGetText:
                ToastUtil.show(this, edit.getText());
                break;
        }
    }

}
