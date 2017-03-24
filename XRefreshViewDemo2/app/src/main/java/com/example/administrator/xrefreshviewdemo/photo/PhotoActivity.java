package com.example.administrator.xrefreshviewdemo.photo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.example.administrator.xrefreshviewdemo.R;
import com.jph.takephoto.app.TakePhotoActivity;
import com.jph.takephoto.model.TImage;
import com.jph.takephoto.model.TResult;

import java.util.ArrayList;

public class PhotoActivity extends TakePhotoActivity implements View.OnClickListener {

    private CustomHelper customHelper;
    private Button btnPickBySelect;
    private Button btnPickByTake;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_photo);
        View contentView = LayoutInflater.from(this).inflate(R.layout.common_layout, null);
        customHelper = CustomHelper.of(contentView);
        initView();

    }


    @Override
    public void takeCancel() {
        super.takeCancel();
    }

    @Override
    public void takeFail(TResult result, String msg) {
        super.takeFail(result, msg);
    }

    @Override
    public void takeSuccess(TResult result) {
        super.takeSuccess(result);
        showImg(result.getImages());
    }

    private void showImg(ArrayList<TImage> images) {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("images", images);
        startActivity(intent);
    }

    public static void startActivity(Context context) {
        Intent starter = new Intent(context, PhotoActivity.class);
        context.startActivity(starter);
    }

    private void initView() {
        btnPickBySelect = (Button) findViewById(R.id.btnPickBySelect);
        btnPickByTake = (Button) findViewById(R.id.btnPickByTake);

        btnPickBySelect.setOnClickListener(this);
        btnPickByTake.setOnClickListener(this);
        btnPickBySelect = (Button) findViewById(R.id.btnPickBySelect);
        btnPickBySelect.setOnClickListener(this);
        btnPickByTake = (Button) findViewById(R.id.btnPickByTake);
        btnPickByTake.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPickBySelect:
                customHelper.onClick(v, getTakePhoto());
                break;
            case R.id.btnPickByTake:
                customHelper.onClick(v, getTakePhoto());
                break;
        }
    }
}
