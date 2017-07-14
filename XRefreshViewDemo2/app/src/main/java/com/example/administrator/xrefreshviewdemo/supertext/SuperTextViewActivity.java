package com.example.administrator.xrefreshviewdemo.supertext;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.allen.library.SuperTextView;
import com.example.administrator.xrefreshviewdemo.R;

/**
 * https://github.com/lygttpod/SuperTextView
 */
public class SuperTextViewActivity extends AppCompatActivity {

    private SuperTextView tv_yinhangka;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_super_text_view);
        initView();
        tv_yinhangka.setRightString("tv_123123123123sdfafdadf123");
        tv_yinhangka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_yinhangka.setRightString("tv_123123123123sdfafdadf123");
            }
        });
    }

    public static void startActivity(Context context) {
        Intent starter = new Intent(context, SuperTextViewActivity.class);
//        starter.putExtra();
        context.startActivity(starter);
    }

    private void initView() {
        tv_yinhangka = (SuperTextView) findViewById(R.id.tv_yinhangka);
    }
}
