package com.example.administrator.xrefreshviewdemo.wheelview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.administrator.xrefreshviewdemo.R;

import java.util.Calendar;

import cn.qqtheme.framework.picker.DatePicker;
import cn.qqtheme.framework.picker.TimePicker;
import cn.qqtheme.framework.widget.WheelView;

/**
 * https://github.com/gzu-liyujiang/AndroidPicker
 */
public class WheelActivity extends Activity {


    private LinearLayout layout_time;
    private LinearLayout layout_date;

    public static void startActivity(Context context) {
        Intent starter = new Intent(context, WheelActivity.class);
//        starter.putExtra();
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wheel);
        initTime();
        initDate();
        initSingleWheel();

    }

    public static final int MATCH_PARENT = ViewGroup.LayoutParams.MATCH_PARENT;
    public static final int WRAP_CONTENT = ViewGroup.LayoutParams.WRAP_CONTENT;
    protected int textColorNormal = WheelView.TEXT_COLOR_NORMAL;
    protected int textColorFocus = WheelView.TEXT_COLOR_FOCUS;
    protected int offset = WheelView.ITEM_OFF_SET;
    protected boolean cycleDisable = true;
    protected WheelView.LineConfig lineConfig;

    private void initSingleWheel() {
        WheelView wheelView = (WheelView)findViewById(R.id.wheelview_single);
        wheelView.setItems(new String[]{"少数民族", "贵州穿青人", "不在56个少数民族之列", "第57个民族"}, 1);
        wheelView.setOnWheelListener(new WheelView.OnWheelListener() {
            @Override
            public void onSelected(boolean isUserScroll, int index, String item) {
//                textView.setText("index=" + index + ",item=" + item);
            }
        });
    }


    private void initTime() {
        layout_time = (LinearLayout) findViewById(R.id.layout_time);

        TimePicker picker = new TimePicker(this, TimePicker.HOUR_24);
        picker.setRangeStart(0, 0);//00:00
        picker.setRangeEnd(23, 59);//23:59
//        picker.setCycleDisable(false);//禁用循环
        int currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        int currentMinute = Calendar.getInstance().get(Calendar.MINUTE);
        picker.setSelectedItem(currentHour, currentMinute);
//        picker.setTopLineVisible(false);
//        picker.setLineVisible(false);
        picker.setOnTimePickListener(new TimePicker.OnTimePickListener() {
            @Override
            public void onTimePicked(String hour, String minute) {
                showToast(hour + ":" + minute);
            }
        });
        layout_time.addView(picker.getContentView());
    }

    public void initDate() {
        layout_date = (LinearLayout) findViewById(R.id.layout_date);

        final DatePicker picker = new DatePicker(this);
        picker.setTopPadding(2);
        picker.setRangeStart(2016, 8, 29);
        picker.setRangeEnd(2111, 1, 11);
        picker.setSelectedItem(2050, 10, 14);
        picker.setOnDatePickListener(new DatePicker.OnYearMonthDayPickListener() {
            @Override
            public void onDatePicked(String year, String month, String day) {
                showToast(year + "-" + month + "-" + day);
            }
        });
        picker.setOnWheelListener(new DatePicker.OnWheelListener() {
            @Override
            public void onYearWheeled(int index, String year) {
                picker.setTitleText(year + "-" + picker.getSelectedMonth() + "-" + picker.getSelectedDay());
            }

            @Override
            public void onMonthWheeled(int index, String month) {
                picker.setTitleText(picker.getSelectedYear() + "-" + month + "-" + picker.getSelectedDay());
            }

            @Override
            public void onDayWheeled(int index, String day) {
                picker.setTitleText(picker.getSelectedYear() + "-" + picker.getSelectedMonth() + "-" + day);
            }
        });
        layout_date.addView(picker.getContentView());
    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
