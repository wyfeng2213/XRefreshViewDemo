package com.example.administrator.xrefreshviewdemo.zxing;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.cmcc.healthlibrary.utils.BitmapUtils;
import com.example.administrator.xrefreshviewdemo.R;
import com.example.administrator.xrefreshviewdemo.util.QrcodeUtils;

public class ZXingCreatePicActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_create;
    private ImageView img;
    private LinearLayout activity_zxing_create_pic;
    private EditText edt_content;
    private ImageView img_create;

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
        img_create = (ImageView) findViewById(R.id.img_create);

        Bitmap bitmap = BitmapUtils.drawable2Bitmap(getResources().getDrawable(R.mipmap.custom_grid_scan_line));
        Bitmap resultBitmap = BitmapUtils.addTextWatermark(bitmap, "测试", 15, R.color.bg, 50, 200, 200);
        img_create.setImageBitmap(resultBitmap);

    }

//    /**
//     * 添加文字水印
//     *
//     * @param src      源图片
//     * @param content  水印文本
//     * @param textSize 水印字体大小
//     * @param color    水印字体颜色
//     * @param alpha    水印字体透明度
//     * @param x        起始坐标x
//     * @param y        起始坐标y
//     * @return 带有文字水印的图片
//     */
//    public static Bitmap addTextWatermark(Bitmap src, String content, int textSize, int color, int alpha, float x, float y) {
//        return addTextWatermark(src, content, textSize, color, alpha, x, y, false);
//    }

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
