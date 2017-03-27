package com.example.administrator.xrefreshviewdemo.switchbutton;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.xrefreshviewdemo.R;

public class SwitchButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_button);
    }

    public static void startActivity(Context context) {
        Intent starter = new Intent(context, SwitchButtonActivity.class);
        context.startActivity(starter);
    }
}
