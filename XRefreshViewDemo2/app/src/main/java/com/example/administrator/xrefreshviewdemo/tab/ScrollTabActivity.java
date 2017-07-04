package com.example.administrator.xrefreshviewdemo.tab;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.LayoutInflater;

import com.example.administrator.xrefreshviewdemo.R;
import com.example.administrator.xrefreshviewdemo.adapter.MyAdapter;
import com.shizhefei.view.indicator.IndicatorViewPager;
import com.shizhefei.view.indicator.ScrollIndicatorView;
import com.shizhefei.view.indicator.slidebar.DrawableBar;
import com.shizhefei.view.indicator.slidebar.ScrollBar;
import com.shizhefei.view.indicator.transition.OnTransitionTextListener;

/**
 * 红色背景样式
 */
public class ScrollTabActivity extends AppCompatActivity {

    private ScrollIndicatorView moretab_indicator;
    private ViewPager moretab_viewPager;
    private IndicatorViewPager indicatorViewPager;
    private String[] names = {"CUPCAKE", "DONUT", "FROYO", "GINGERBREAD", "HONEYCOMB", "ICE CREAM SANDWICH", "JELLY BEAN", "KITKAT"};

    private LayoutInflater inflate;
    private int unSelectTextColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_tab);
        initView();
    }

    private void initView() {
        moretab_indicator = (ScrollIndicatorView) findViewById(R.id.moretab_indicator);
        moretab_viewPager = (ViewPager) findViewById(R.id.moretab_viewPager);

        moretab_indicator.setBackgroundColor(Color.RED);
        // 设置是否自动布局
        moretab_indicator.setSplitAuto(true);

        moretab_indicator.setScrollBar(new DrawableBar(this, R.drawable.round_border_white_selector, ScrollBar.Gravity.CENTENT_BACKGROUND) {
            @Override
            public int getHeight(int tabHeight) {
                return tabHeight - dipToPix(12);
            }

            @Override
            public int getWidth(int tabWidth) {
                return tabWidth - dipToPix(12);
            }
        });

        unSelectTextColor = Color.WHITE;
        // 设置滚动监听
        moretab_indicator.setOnTransitionListener(new OnTransitionTextListener().setColor(Color.RED, unSelectTextColor));

        moretab_viewPager.setOffscreenPageLimit(2);
        indicatorViewPager = new IndicatorViewPager(moretab_indicator, moretab_viewPager);
        inflate = LayoutInflater.from(getApplicationContext());
        indicatorViewPager.setAdapter(new MyAdapter(this, getSupportFragmentManager(), names));
    }

    public static void startActivity(Context context) {
        Intent starter = new Intent(context, ScrollTabActivity.class);
        context.startActivity(starter);
    }

    /**
     * 根据dip值转化成px值
     *
     * @param dip
     * @return
     */
    private int dipToPix(float dip) {
        int size = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip, getResources().getDisplayMetrics());
        return size;
    }
}
