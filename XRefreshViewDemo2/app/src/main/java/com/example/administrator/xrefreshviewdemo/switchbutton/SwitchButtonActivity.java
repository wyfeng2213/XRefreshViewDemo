package com.example.administrator.xrefreshviewdemo.switchbutton;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;

import com.example.administrator.xrefreshviewdemo.R;
import com.kyleduo.switchbutton.SwitchButton;

/**
 * https://github.com/xiaopansky/SwitchButton
 * https://github.com/kyleduo/SwitchButton
 */
public class SwitchButtonActivity extends AppCompatActivity implements View.OnClickListener {

    private SwitchButton sb_ios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_button);
        initView();

        sb_ios.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                ToastUtil.show(SwitchButtonActivity.this, isChecked + "");
            }
        });
    }

    public static void startActivity(Context context) {
        Intent starter = new Intent(context, SwitchButtonActivity.class);
        context.startActivity(starter);
    }

    private void initView() {
        sb_ios = (SwitchButton) findViewById(R.id.sb_ios);

        sb_ios.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sb_ios:

                break;
        }
    }
}
