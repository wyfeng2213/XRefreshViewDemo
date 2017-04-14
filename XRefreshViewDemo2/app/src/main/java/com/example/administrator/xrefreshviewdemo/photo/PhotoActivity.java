package com.example.administrator.xrefreshviewdemo.photo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.example.administrator.xrefreshviewdemo.R;
import com.jph.takephoto.app.TakePhotoActivity;
import com.jph.takephoto.model.TImage;
import com.jph.takephoto.model.TResult;

import java.util.ArrayList;
import java.util.List;

public class PhotoActivity extends TakePhotoActivity implements View.OnClickListener {

    private CustomHelper customHelper;
    private Button btnPickBySelect;
    private Button btnPickByTake;

    private RecyclerView recyclerView;
    private PhotoAdapter photoAdapter;
    Context mcontext;
    private List<TImage> selectMedia = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_photo);
        View contentView = LayoutInflater.from(this).inflate(R.layout.common_layout, null);
        customHelper = CustomHelper.of(contentView);
        mcontext = this;
        initView();

        initRecylerView();


    }

    private void initRecylerView() {
        //设置RecyclerView
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        photoAdapter = new PhotoAdapter(this, onAddPicListener, onPicClickListener);
        photoAdapter.setSelectMax(8);
        recyclerView.setAdapter(photoAdapter);
    }

    //加号的点击事件
    private PhotoAdapter.onAddPicListener onAddPicListener = new PhotoAdapter.onAddPicListener() {
        @Override
        public void onAddPicClick(int type, int position) {
            switch (type) {
                case 0:
//                    new AlertView("上传图片", null, "取消", null,
//                            new String[]{"拍照", "从相册中选择"},
//                            PhotoActivity.this, AlertView.Style.ActionSheet, new OnItemClickListener() {
//                        @Override
//                        public void onItemClick(Object o, int position) {
//                            TakePhoto takePhoto = getTakePhoto();
//                            //获取TakePhoto图片路径
//                            File file = new File(Environment.getExternalStorageDirectory(), "/photo/" + System.currentTimeMillis() + ".jpg");
//                            if (!file.getParentFile().exists()) file.getParentFile().mkdirs();
//                            Uri imageUri = Uri.fromFile(file);
//
//                            configCompress(takePhoto);
//                            configTakePhotoOption(takePhoto);
//                            switch (position) {
//                                case 0:
//                                    takePhoto.onPickFromCapture(imageUri);
//                                    break;
//                                case 1:
//                                    //设置最多几张
//                                    takePhoto.onPickMultiple(3);
//                                    break;
//                            }
//                        }
//                    }).show();
                    break;
                case 1:
                    // 删除图片
                    selectMedia.remove(position);
                    photoAdapter.notifyItemRemoved(position);
                    break;
            }
        }
    };

    //图片点击事件
    private PhotoAdapter.onPicClickListener onPicClickListener = new PhotoAdapter.onPicClickListener() {
        @Override
        public void onPicClick(View view, int position) {
            String url = selectMedia.get(position).getOriginalPath();
            ResultActivity.startActivity(mcontext, url);
        }
    };


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
//        Intent intent = new Intent(this, ResultActivity.class);
//        intent.putExtra("images", images);
//        startActivity(intent);

        for (int i = 0; i < images.size(); i++) {
            if (images.get(i).getCompressPath() != null) {
                selectMedia.add(images.get(i));
            }
        }
        if (selectMedia != null) {
            photoAdapter.setList(selectMedia);
            photoAdapter.notifyDataSetChanged();
        }
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
