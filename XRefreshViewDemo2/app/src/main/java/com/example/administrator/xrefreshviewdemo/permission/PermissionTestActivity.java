package com.example.administrator.xrefreshviewdemo.permission;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.administrator.xrefreshviewdemo.R;

public class PermissionTestActivity extends PermissionActivity implements View.OnClickListener {

    private Button bt;
    private RelativeLayout activity_permission;

    //=================targetSdkVersion 需要23以上
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);
        initView();
    }

    public static void startActivity(Context context) {
        Intent starter = new Intent(context, PermissionTestActivity.class);
//        starter.putExtra();
        context.startActivity(starter);
    }

    private void initView() {
        bt = (Button) findViewById(R.id.bt);
        activity_permission = (RelativeLayout) findViewById(R.id.activity_permission);

        bt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt:
                checkPermission(new CheckPermListener() {
                    @Override
                    public void superPermission() {
                        Toast.makeText(PermissionTestActivity.this, "相机可用", Toast.LENGTH_SHORT).show();
                    }
                }, R.string.camera, Manifest.permission.CAMERA);
                break;
        }
    }
}
