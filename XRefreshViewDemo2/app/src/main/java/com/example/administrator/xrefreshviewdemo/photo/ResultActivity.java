package com.example.administrator.xrefreshviewdemo.photo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.bm.library.PhotoView;
import com.bumptech.glide.Glide;
import com.example.administrator.xrefreshviewdemo.R;

import static com.example.administrator.xrefreshviewdemo.R.id.img;


public class ResultActivity extends Activity {

    private PhotoView mPhotoView;
    private static final String KEY_IMG = "IMG";
    public String img_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_layout);
        img_value = "file://" + getIntent().getStringExtra(KEY_IMG);
        initView();
    }

    public static void startActivity(Context context, String url) {
        Intent starter = new Intent(context, ResultActivity.class);
        starter.putExtra(KEY_IMG, url);
        context.startActivity(starter);
    }

    private void initView() {
        mPhotoView = (PhotoView) findViewById(img);
        mPhotoView.enable();
        Glide.with(this).load(img_value).into(mPhotoView);
    }
}
