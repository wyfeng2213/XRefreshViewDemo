package com.example.administrator.xrefreshviewdemo.searchview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.xrefreshviewdemo.R;
import com.wyt.searchbox.SearchFragment;
import com.wyt.searchbox.custom.IOnSearchClickListener;

/**
 * https://github.com/wenwenwen888/SearchDialog
 */
public class SearchActivity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener, IOnSearchClickListener, View.OnClickListener {
    private SearchFragment searchFragment;
    private Toolbar toolbar;
    private TextView search_info;
    private Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initView();

        toolbar.setTitle("SearchDialog");//标题
        setSupportActionBar(toolbar);

        searchFragment = SearchFragment.newInstance();

        toolbar.setOnMenuItemClickListener(this);

        searchFragment.setOnSearchClickListener(this);
        searchFragment.setCancelable(true);
    }

    public static void startActivity(Context context) {
        Intent starter = new Intent(context, SearchActivity.class);
        context.startActivity(starter);
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        search_info = (TextView) findViewById(R.id.search_info);
        bt = (Button) findViewById(R.id.bt);
        bt.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //加载菜单文件
        getMenuInflater().inflate(R.menu.menu_search, menu);
        return true;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search://点击搜索
                searchFragment.show(getSupportFragmentManager(), SearchFragment.TAG);
                break;
        }
        return true;
    }

    @Override
    public void OnSearchClick(String keyword) {
        search_info.setText(keyword);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt:
                searchFragment.show(getSupportFragmentManager(), SearchFragment.TAG);
                break;
        }
    }
}
