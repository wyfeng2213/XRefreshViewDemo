package com.example.administrator.xrefreshviewdemo.photo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.administrator.xrefreshviewdemo.R;
import com.jph.takephoto.app.TakePhotoActivity;
import com.jph.takephoto.model.TImage;
import com.jph.takephoto.model.TResult;
import com.simple.commonadapter.RecyclerAdapter;
import com.simple.commonadapter.viewholders.RecyclerViewHolder;

import java.util.ArrayList;
import java.util.List;

import static com.example.administrator.xrefreshviewdemo.photo.CustomHelper.SELECT_PHOTO;

public class PhotoActivity2 extends TakePhotoActivity implements View.OnClickListener {

    private CustomHelper customHelper;
    private Button btnPickBySelect;
    private Button btnPickByTake;

    private RecyclerView recyclerView;
    private PhotoAdapter photoAdapter;
    public final int TYPE_CAMERA = 1;
    public final int TYPE_PICTURE = 2;
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
        setAdapter();
    }

    private boolean isShowAddItem(int position) {
        int size = selectMedia.size() == 0 ? 0 : selectMedia.size();
        return position == size;
    }

    RecyclerAdapter<TImage> adapter;
    int selectMax = 8;

    public void setAdapter() {
        int count;
        if (selectMedia.size() < selectMax) {
            count = selectMedia.size() + 1;
        } else {
            count = selectMedia.size();
        }
        final int count2 = count;
        // 线性
        recyclerView.setLayoutManager(new GridLayoutManager(this, 5));
        // 初始化adapter
        adapter = new RecyclerAdapter<TImage>(R.layout.activity_photo_item, selectMedia) {
            @Override
            public int getItemCount() {
                return count2;
            }

            @Override
            protected void onBindData(RecyclerViewHolder viewHolder, final int position, TImage item) {
                ImageView photo_img = viewHolder.findViewById(R.id.photo_image);
                ImageView photo_del = viewHolder.findViewById(R.id.photo_del);
                //少于3张，显示继续添加的图标
                Log.d("...", "onBindViewHolder: " + position);
                if (getItemViewType(position) == TYPE_CAMERA) {

                    viewHolder.setImageResource(R.id.photo_image, R.mipmap.icon_addpic);
                    photo_img.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            customHelper.onClick(SELECT_PHOTO, getTakePhoto());
                        }
                    });
                    photo_del.setVisibility(View.INVISIBLE);
                } else {
                    photo_del.setVisibility(View.VISIBLE);
                    photo_img.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String url = selectMedia.get(position).getOriginalPath();
                            ResultActivity.startActivity(mcontext, url);
                        }
                    });
                    photo_del.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.remove(position);
                        }
                    });

                    Glide.with(mcontext)
                            .load(item.getCompressPath())
                            .crossFade()
                            .into(photo_img);
                }
            }


            // 如果有多个布局,那么覆写getItemViewType与getItemLayout即可
            @Override
            public int getItemViewType(int position) {
                if (isShowAddItem(position)) {
                    return TYPE_CAMERA;
                } else {
                    return TYPE_PICTURE;
                }
            }


        };

        // 设置RecyclerView的点击事件
        adapter.setOnItemClickListener(new RecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
            }
        });
        recyclerView.setAdapter(adapter);
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
//        Intent intent = new Intent(this, ResultActivity.class);
//        intent.putExtra("images", images);
//        startActivity(intent);

        if (images.size() > 0) {
            img_add.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }
        for (int i = 0; i < images.size(); i++) {
            if (images.get(i).getCompressPath() != null) {
                selectMedia.add(images.get(i));
            }
        }
        if (selectMedia != null) {
//            adapter.addItems(images);

            setAdapter();
//            photoAdapter.setList(selectMedia);
//            photoAdapter.notifyDataSetChanged();
        }
    }

    public static void startActivity(Context context) {
        Intent starter = new Intent(context, PhotoActivity2.class);
        context.startActivity(starter);
    }

    ImageView img_add;

    private void initView() {
//        img_add = (ImageView) findViewById(R.id.img_add);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        btnPickBySelect = (Button) findViewById(R.id.btnPickBySelect);
        btnPickByTake = (Button) findViewById(R.id.btnPickByTake);

        btnPickBySelect.setOnClickListener(this);
        btnPickByTake.setOnClickListener(this);
        btnPickBySelect = (Button) findViewById(R.id.btnPickBySelect);
        btnPickBySelect.setOnClickListener(this);
        btnPickByTake = (Button) findViewById(R.id.btnPickByTake);
        btnPickByTake.setOnClickListener(this);
        img_add.setOnClickListener(this);
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
//            case R.id.img_add:
//                customHelper.onClick(SELECT_PHOTO, getTakePhoto());
//                break;
        }
    }
}
