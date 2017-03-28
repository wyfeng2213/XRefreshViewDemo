package com.example.administrator.xrefreshviewdemo.zxing;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.administrator.xrefreshviewdemo.R;
import com.example.administrator.xrefreshviewdemo.util.QrcodeUtils;

public class ZXingCreatePicActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_create;
    private ImageView img;
    private LinearLayout activity_zxing_create_pic;
    private EditText edt_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zxing_create_pic);
        initView();
    }

    private void initView() {
        bt_create = (Button) findViewById(R.id.bt_create);
        img = (ImageView) findViewById(R.id.img);
        activity_zxing_create_pic = (LinearLayout) findViewById(R.id.activity_zxing_create_pic);

        bt_create.setOnClickListener(this);
        edt_content = (EditText) findViewById(R.id.edt_content);
        edt_content.setOnClickListener(this);
    }

    public static void startActivity(Context context) {
        Intent starter = new Intent(context, ZXingCreatePicActivity.class);
        context.startActivity(starter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_create:
                String content = edt_content.getText().toString().trim();
                if (TextUtils.isEmpty(content)) {
                    Toast.makeText(this, "请输入内容", Toast.LENGTH_SHORT).show();
                    return;
                }
                img.setImageBitmap(QrcodeUtils.createQRImage(content));
                Toast.makeText(this, "二维码生成成功", Toast.LENGTH_SHORT).show();
                break;
        }
    }

}
