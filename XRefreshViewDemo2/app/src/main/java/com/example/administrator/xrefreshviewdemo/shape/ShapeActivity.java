package com.example.administrator.xrefreshviewdemo.shape;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.administrator.xrefreshviewdemo.R;

public class ShapeActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_test;
    private LinearLayout activity_shape;
    private Button bt_test2;
    private Button bt_test3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shape);
        initView();
    }

    public static void startActivity(Context context) {
        Intent starter = new Intent(context, ShapeActivity.class);
        context.startActivity(starter);
    }

    private void initView() {
        bt_test = (Button) findViewById(R.id.bt_test);
        activity_shape = (LinearLayout) findViewById(R.id.activity_shape);

        bt_test.setOnClickListener(this);


        bt_test2 = (Button) findViewById(R.id.bt_test2);
        bt_test2.setOnClickListener(this);
        bt_test3 = (Button) findViewById(R.id.bt_test3);
        bt_test3.setOnClickListener(this);


        GradientDrawable myGrad2 = (GradientDrawable) bt_test2.getBackground();
        myGrad2.setColor(getResources().getColor(R.color.green));
        myGrad2.setStroke(2, getResources().getColor(R.color.black));

        GradientDrawable myGrad3 = new GradientDrawable();
        myGrad2.setColor(getResources().getColor(R.color.green));
        myGrad3.setStroke(2, getResources().getColor(R.color.white));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_test:

                break;
            case R.id.bt_test2:
                break;
            case R.id.bt_test3:
                break;
        }
    }
}
