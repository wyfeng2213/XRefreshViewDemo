package com.example.administrator.xrefreshviewdemo.mpAndroidChart;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.text.DecimalFormat;

/**
 * Description:
 * Date：2017/05/24 16:24
 * Author: wangyong
 */

public class MyTimeXAxisValueFormatter implements IAxisValueFormatter {
    protected DecimalFormat mFormat;

    public MyTimeXAxisValueFormatter() {
        mFormat = new DecimalFormat("###,###");
    }

    @Override
    public String getFormattedValue(float value, AxisBase axis) {
        return mFormat.format(value/60) + ":00";
    }
}
