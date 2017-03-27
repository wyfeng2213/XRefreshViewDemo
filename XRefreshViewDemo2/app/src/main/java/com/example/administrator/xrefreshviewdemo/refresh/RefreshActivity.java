package com.example.administrator.xrefreshviewdemo.refresh;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.andview.refreshview.XRefreshView;
import com.example.administrator.xrefreshviewdemo.R;
import com.example.administrator.xrefreshviewdemo.baseadapter.ListViewAdapter;
import com.example.administrator.xrefreshviewdemo.baseadapter.viewholder.GodViewHolder;

import java.util.ArrayList;
import java.util.List;

import static com.example.administrator.xrefreshviewdemo.R.id.custom_view;
import static com.example.administrator.xrefreshviewdemo.R.id.lv;


public class RefreshActivity extends AppCompatActivity {

    private ListView listview;
    private XRefreshView refreshView;
    ListViewAdapter mAdapter;
    List<String> mDatas = new ArrayList<>();
    public static long lastRefreshTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh);
        initView();
        initData();
    }

    public static void startActivity(Context context) {
        Intent starter = new Intent(context, RefreshActivity.class);
        context.startActivity(starter);
    }

    private void initView() {
        listview = (ListView) findViewById(lv);
        refreshView = (XRefreshView) findViewById(custom_view);

        // 设置是否可以下拉刷新
        refreshView.setPullRefreshEnable(true);
        // 设置是否可以上拉加载
        refreshView.setPullLoadEnable(true);
        // 设置上次刷新的时间
        refreshView.restoreLastRefreshTime(lastRefreshTime);
        // 设置时候可以自动刷新
        refreshView.setAutoRefresh(true);

        refreshView.setXRefreshViewListener(new XRefreshView.SimpleXRefreshListener() {
            @Override
            public void onRefresh(boolean isPullDown) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshView.stopRefresh();
                        lastRefreshTime = refreshView.getLastRefreshTime();
                    }
                }, 2000);
            }

            @Override
            public void onLoadMore(boolean isSilence) {
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {

                        RefreshActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                List<String> mylist = new ArrayList<String>();
                                for (int i = 0; i < 10; i++) {
                                    mylist.add("i" + i);
                                }
                                mAdapter.addItems(mylist);
                            }
                        });
                        refreshView.stopLoadMore();
                    }
                }, 2000);
            }

            @Override
            public void onRelease(float direction) {
                super.onRelease(direction);
                if (direction > 0) {
                    toast("下拉");
                } else {
                    toast("上拉");
                }
            }
        });
    }

    private void initData() {
        for (int i = 0; i < 10; i++) {
            mDatas.add(" ");
        }
        mAdapter = new ListViewAdapter<String>(R.layout.item_service) {
            @Override
            protected void onBindData(GodViewHolder viewHolder, int position, String item) {
//                viewHolder
//                        .setText(R.id.textview, item);          // 设置文本内容
            }
        };
        mAdapter.addItems(mDatas);
        listview.setAdapter(mAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    public void toast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
