package com.example.administrator.xrefreshviewdemo.calendar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.xrefreshviewdemo.R;

import java.util.Calendar;

import cn.carbs.android.gregorianlunarcalendar.library.data.ChineseCalendar;
import cn.carbs.android.gregorianlunarcalendar.library.view.GregorianLunarCalendarView;
import cn.carbs.android.indicatorview.library.IndicatorView;

public class ActivityMain extends AppCompatActivity implements View.OnClickListener,
        IndicatorView.OnIndicatorChangedListener {

    //indicator view used to indicate and switch gregorien/lunar mode
    private IndicatorView mIndicatorView;
    private GregorianLunarCalendarView mGLCView;
    private TextView mChangedDate;
    private Button mButtonGetData;
    private Button mButtonShowDialog;
    private DialogGLC mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        mGLCView = (GregorianLunarCalendarView) this.findViewById(R.id.calendar_view);
//        mGLCView.init();//init has no scroll effection, to today
//
//        /*Calendar customizedCalendar = Calendar.getInstance();
//        customizedCalendar.set((2012), 11, 12);//eg. 2012-12-12
//        mGLCView.init(customizedCalendar);//to 2012-12-12*/
//
//        mIndicatorView = (IndicatorView) this.findViewById(R.id.indicator_view);
//        mIndicatorView.setOnIndicatorChangedListener(this);
//
//        mButtonGetData = (Button) this.findViewById(R.id.button_get_data);
//        mButtonGetData.setOnClickListener(this);

//        mButtonShowDialog = (Button) this.findViewById(R.id.button_in_dialog);
//        mButtonShowDialog.setOnClickListener(this);

//        mChangedDate = (TextView) this.findViewById(R.id.tv_changed_date);
//        mGLCView.setOnDateChangedListener(new GregorianLunarCalendarView.OnDateChangedListener() {
//            @Override
//            public void onDateChanged(GregorianLunarCalendarView.CalendarData calendarData) {
//                Calendar calendar = calendarData.getCalendar();
//                String showToast = "Gregorian : " + calendar.get(Calendar.YEAR) + "-"
//                        + (calendar.get(Calendar.MONTH) + 1) + "-"
//                        + calendar.get(Calendar.DAY_OF_MONTH) + "\n"
//                        + "Lunar     : " + calendar.get(ChineseCalendar.CHINESE_YEAR) + "-"
//                        + (calendar.get(ChineseCalendar.CHINESE_MONTH)) + "-"
//                        + calendar.get(ChineseCalendar.CHINESE_DATE);
//                mChangedDate.setText(showToast);
//            }
//        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_get_data:
                GregorianLunarCalendarView.CalendarData calendarData = mGLCView.getCalendarData();
                Calendar calendar = calendarData.getCalendar();
                String showToast = "Gregorian : " + calendar.get(Calendar.YEAR) + "-"
                        + (calendar.get(Calendar.MONTH) + 1) + "-"
                        + calendar.get(Calendar.DAY_OF_MONTH) + "\n"
                        + "Lunar     : " + calendar.get(ChineseCalendar.CHINESE_YEAR) + "-"
                        + (calendar.get(ChineseCalendar.CHINESE_MONTH)) + "-"
                        + calendar.get(ChineseCalendar.CHINESE_DATE);
                Toast.makeText(getApplicationContext(), showToast, Toast.LENGTH_LONG).show();
                break;
//            case R.id.button_in_dialog:
//                showInDialog();
//                break;
        }
    }

    private void showInDialog(){
        if(mDialog == null){
            mDialog = new DialogGLC(this);
        }
        if(mDialog.isShowing()){
            mDialog.dismiss();
        }else {
            mDialog.setCancelable(true);
            mDialog.setCanceledOnTouchOutside(true);
            mDialog.show();
            //better initialize NumberPickerView's data (or set a certain value)
            // every time setting up reusable dialog
            mDialog.initCalendar();
        }
    }


    @Override
    public void onIndicatorChanged(int oldSelectedIndex, int newSelectedIndex) {
        if (newSelectedIndex == 0) {
            toGregorianMode();
        } else if (newSelectedIndex == 1) {
            toLunarMode();
        }
    }

    private void toGregorianMode() {
        mGLCView.toGregorianMode();
    }

    private void toLunarMode() {
        mGLCView.toLunarMode();
    }
}

