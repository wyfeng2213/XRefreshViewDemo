package com.example.administrator.xrefreshviewdemo.loading;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.xrefreshviewdemo.R;

public class LoadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
    }

    public static void startActivity(Context context) {
        Intent starter = new Intent(context, LoadingActivity.class);
//        starter.putExtra();
        context.startActivity(starter);
    }
}
