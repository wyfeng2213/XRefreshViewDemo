package com.example.administrator.xrefreshviewdemo.supertext;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.xrefreshviewdemo.R;

public class StateButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_super_button);
    }
    public static void startActivity(Context context) {
        Intent starter = new Intent(context, StateButtonActivity.class);
        context.startActivity(starter);
    }
}
