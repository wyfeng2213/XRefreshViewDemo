package com.example.administrator.xrefreshviewdemo.supertext;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.xrefreshviewdemo.R;

public class BadgebuttonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_red_circle);
    }

    public static void startActivity(Context context) {
        Intent starter = new Intent(context, BadgebuttonActivity.class);
        context.startActivity(starter);
    }
}
