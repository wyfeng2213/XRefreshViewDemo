package com.example.administrator.xrefreshviewdemo.chenjin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.example.administrator.xrefreshviewdemo.R;

public class ChenjinActivity extends AppCompatActivity {

    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chenjin);
        initView();
//        OsUtil.setTranslucentStatus(this);
        OsUtil.setTraslucentColor(this,R.color.deepblue);
    }

    public static void startActivity(Context context) {
        Intent starter = new Intent(context, ChenjinActivity.class);
        context.startActivity(starter);
    }

    private void initView() {
    }
}
