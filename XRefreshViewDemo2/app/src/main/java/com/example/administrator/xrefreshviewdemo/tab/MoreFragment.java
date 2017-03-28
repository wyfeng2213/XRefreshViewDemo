package com.example.administrator.xrefreshviewdemo.tab;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.administrator.xrefreshviewdemo.R;
import com.shizhefei.fragment.LazyFragment;

public class MoreFragment extends LazyFragment {
    private ProgressBar progressBar;
    private TextView textView;
    private int tabIndex;
    public static final String INTENT_INT_INDEX = "intent_int_index";

    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);

        setContentView(R.layout.fragment_tabmain_item);
        tabIndex = getArguments().getInt(INTENT_INT_INDEX);
        progressBar = (ProgressBar) findViewById(R.id.fragment_mainTab_item_progressBar);
        textView = (TextView) findViewById(R.id.fragment_mainTab_item_textView);
        textView.setText("界面" + " " + tabIndex + " 加载完毕");
    }

    @Override
    public void onDestroyViewLazy() {
        super.onDestroyViewLazy();
//        handler.removeCallbacksAndMessages(null);
    }

}
