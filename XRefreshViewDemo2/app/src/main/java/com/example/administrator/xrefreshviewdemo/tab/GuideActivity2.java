package com.example.administrator.xrefreshviewdemo.tab;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.xrefreshviewdemo.R;
import com.shizhefei.view.indicator.Indicator;
import com.shizhefei.view.indicator.IndicatorViewPager;
import com.shizhefei.view.indicator.IndicatorViewPager.IndicatorPagerAdapter;
import com.shizhefei.view.indicator.IndicatorViewPager.IndicatorViewPagerAdapter;

/**
 * 滑动布局文件 自动关闭界面
 */
public class GuideActivity2 extends FragmentActivity implements
        ViewPager.OnPageChangeListener {
    private IndicatorViewPager indicatorViewPager;
    private LayoutInflater inflate;
    public GestureDetector mGestureDetector;
    private int flaggingWidth;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_guide);
        slipToMain();
        //ViewPager,Indicator
        ViewPager viewPager = (ViewPager) findViewById(R.id.guide_viewPager);
        Indicator indicator = (Indicator) findViewById(R.id.guide_indicator);
        indicatorViewPager = new IndicatorViewPager(indicator, viewPager);
        inflate = LayoutInflater.from(getApplicationContext());
        indicatorViewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(this);
//        Toast.makeText(getApplicationContext(), "6秒后更新界面适配器", Toast.LENGTH_SHORT).show();
//        new Thread() {
//            @Override
//            public void run() {
//                super.run();
//                try {
//                    Thread.sleep(6000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        images = new int[]{R.drawable.p3, R.drawable.p4};
//                        adapter.notifyDataSetChanged();
//                    }
//                });
//            }
//        }.start();
    }

    public static void startActivity(Context context) {
        Intent starter = new Intent(context, GuideActivity2.class);
        context.startActivity(starter);
    }

    private int currentItem = 0;

    private void slipToMain() {
        // 获取分辨率
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        flaggingWidth = dm.widthPixels / 3;

        mGestureDetector = new GestureDetector(this,
                new GestureDetector.SimpleOnGestureListener() {

                    @Override
                    public boolean onFling(MotionEvent e1, MotionEvent e2,
                                           float velocityX, float velocityY) {
                        if (currentItem == 3) {
                            if ((e1.getRawX() - e2.getRawX()) >= flaggingWidth) {
//                                Intent intent = new Intent(
//                                        SplashGuideActivity.this,
//                                        MainActivity.class);
//                                startActivity(intent);
                                finish();
                                return true;
                            }
                        }
                        return false;
                    }

                });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mGestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (mGestureDetector.onTouchEvent(event)) {
            event.setAction(MotionEvent.ACTION_CANCEL);
        }
        return super.dispatchTouchEvent(event);
    }

    private int[] images = {};
//    private int[] layoutId = {};
    //    private int[] images = {R.drawable.p1, R.drawable.p2, R.drawable.p3, R.drawable.p4};
    private int[] layoutId = {R.layout.activity_iosdialog, R.layout.activity_iosdialog,
        R.layout.activity_iosdialog, R.layout.activity_iosdialog};
    private IndicatorPagerAdapter adapter = new IndicatorViewPagerAdapter() {

        @Override
        public View getViewForTab(int position, View convertView, ViewGroup container) {
            if (convertView == null) {
                convertView = inflate.inflate(R.layout.tab_guide, container, false);
            }
            return convertView;
        }

        @Override
        public View getViewForPage(int position, View convertView, ViewGroup container) {

            if (convertView == null) {
                convertView = inflate.inflate(layoutId[position], container, false);
            }
            if (position == layoutId.length - 1) {
//                Button bt_finish = (Button) convertView.findViewById(R.id.bt_finish);
//                bt_finish.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        finish();
//                    }
//                });
                convertView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
            }
            return convertView;
        }

        @Override
        public int getItemPosition(Object object) {
            //这是ViewPager适配器的特点,有两个值 POSITION_NONE，POSITION_UNCHANGED，默认就是POSITION_UNCHANGED,
            // 表示数据没变化不用更新.notifyDataChange的时候重新调用getViewForPage
            return PagerAdapter.POSITION_NONE;
        }

        @Override
        public int getCount() {
            return layoutId.length;
        }
    };

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        currentItem = position;
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
