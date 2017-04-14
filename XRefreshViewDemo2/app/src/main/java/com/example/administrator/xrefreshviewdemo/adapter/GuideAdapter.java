package com.example.administrator.xrefreshviewdemo.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.xrefreshviewdemo.tab.MoreFragment;
import com.shizhefei.view.indicator.IndicatorViewPager;

/**
 * Description:
 * Date：2017/04/13 17:29
 * Author: wangyong
 */

public class GuideAdapter extends IndicatorViewPager.IndicatorFragmentPagerAdapter {
    private String[] names = {"热点", "外科", "口腔科"};
    private LayoutInflater inflate;
    Context mcontext;

    public GuideAdapter(Context context, FragmentManager fragmentManager) {
        super(fragmentManager);
        this.mcontext = context;
        inflate = LayoutInflater.from(mcontext);
    }


    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public View getViewForTab(int position, View convertView, ViewGroup container) {
        if (convertView == null) {
            convertView = new View(mcontext);
            convertView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        }
//        TextView textView = (TextView) convertView;
//        textView.setText(names[position % names.length]);
//        int padding = dipToPix(20);
//        textView.setPadding(padding, 0, padding, 0);
        return convertView;
    }

    @Override
    public Fragment getFragmentForPage(int position) {
        MoreFragment fragment = new MoreFragment();
        Bundle bundle = new Bundle();
//        bundle.putInt(MoreFragment.INTENT_INT_INDEX, position);
//        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getItemPosition(Object object) {
        //这是ViewPager适配器的特点,有两个值 POSITION_NONE，POSITION_UNCHANGED，默认就是POSITION_UNCHANGED,
        // 表示数据没变化不用更新.notifyDataChange的时候重新调用getViewForPage
        return PagerAdapter.POSITION_NONE;
    }

    /**
     * 根据dip值转化成px值
     *
     * @param dip
     * @return
     */
    private int dipToPix(float dip) {
        int size = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip, mcontext.getResources().getDisplayMetrics());
        return size;
    }
}
