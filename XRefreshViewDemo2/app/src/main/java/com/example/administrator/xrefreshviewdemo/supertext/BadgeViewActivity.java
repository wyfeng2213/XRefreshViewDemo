package com.example.administrator.xrefreshviewdemo.supertext;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.xrefreshviewdemo.R;
import com.itingchunyu.badgeview.BadgeTextView;

public class BadgeViewActivity extends AppCompatActivity {

    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_badge_view);
        initView();

        //无数值
        TextView tv = (TextView) findViewById(R.id.tv);
        BadgeTextView mBadgeTextView = new BadgeTextView(this);
        mBadgeTextView.setTargetView(tv);
        mBadgeTextView.setBadgeCount(0).setmDefaultTopPadding(15).setmDefaultRightPadding(20);
        mBadgeTextView.setBadgeShown(true);
        //两位数
        TextView tv2 = (TextView) findViewById(R.id.tv2);
        BadgeTextView mBadgeTextView2 = new BadgeTextView(this);
        mBadgeTextView2.setBadgeShown(true);
        mBadgeTextView2.setTargetView(tv2);
        mBadgeTextView2.setBadgeColor(Color.RED);
        mBadgeTextView2.setBadgeCount(929).setmDefaultRightPadding(20)
                .setmDefaultTopPadding(15);


        BadgeTextView mBadgeTextView3 = new BadgeTextView(this);
        mBadgeTextView3.setBadgeShown(true);
        mBadgeTextView3.setTargetView(img);
        mBadgeTextView3.setBadgeColor(ContextCompat.getColor(this,R.color.red));
        mBadgeTextView3.setBadgeCount(1);
    }

    public static void startActivity(Context context) {
        Intent starter = new Intent(context, BadgeViewActivity.class);
//        starter.putExtra();
        context.startActivity(starter);
    }

    private void initView() {
        img = (ImageView) findViewById(R.id.img);
    }
}
