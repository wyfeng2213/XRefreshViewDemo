package com.example.administrator.xrefreshviewdemo.tab.health;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shizhefei.view.indicator.IndicatorViewPager;

/**
 * Description:
 * Date：2017/04/13 15:33
 * Author: wangyong
 */

public class CoupeAdapter extends IndicatorViewPager.IndicatorFragmentPagerAdapter {
    private String[] names = {"热点", "外科", "口腔科", "妇产科", "儿科", "眼科", "口腔科", "骨科", "泌尿外科", "心血管内科", "神经内科"};
    private LayoutInflater inflate;
    Context mcontext;

    public CoupeAdapter(Context context, FragmentManager fragmentManager) {
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
//        if (convertView == null) {
//            convertView = inflate.inflate(R.layout.tab_top, container, false);
//        }
//        TextView textView = (TextView) convertView;
//        textView.setText(names[position % names.length]);
//        int padding = dipToPix(20);
//        textView.setPadding(padding, 0, padding, 0);

        //========== 正确保留写法
//        if (convertView == null) {
//            convertView = inflate.inflate(R.layout.tab_guide, container, false);
//        }
//        return convertView;
        return convertView;
    }

    @Override
    public Fragment getFragmentForPage(int position) {
//        CoupeContentFragment fragment = new CoupeContentFragment();
//        Bundle bundle = new Bundle();
////        bundle.putInt(MoreFragment.INTENT_INT_INDEX, position);
////        fragment.setArguments(bundle);
//        return fragment;

        return new Fragment();
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
