package com.example.administrator.xrefreshviewdemo.calendar;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.administrator.xrefreshviewdemo.R;

import java.util.Calendar;

import cn.carbs.android.gregorianlunarcalendar.library.view.GregorianLunarCalendarView;
import cn.carbs.android.indicatorview.library.IndicatorView;


/**
 * Created by carbs on 2016/7/12.
 */

public class DialogGLC extends Dialog implements View.OnClickListener, IndicatorView.OnIndicatorChangedListener {

    private Context mContext;
    private IndicatorView mIndicatorView;
    private GregorianLunarCalendarView mGLCView;
    private Button mButtonGetData;
    CalendarDialogListener dialogListener;

    public DialogGLC(Context context) {
        super(context, R.style.dialog);
        mContext = context;
    }

    public void setDialogListener(CalendarDialogListener listener) {
        this.dialogListener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_glc);
        initWindow();

        mGLCView = (GregorianLunarCalendarView) this.findViewById(R.id.calendar_view);
//        mGLCView.init();//init has no scroll effect, to today
        mIndicatorView = (IndicatorView) this.findViewById(R.id.indicator_view);
        mIndicatorView.setOnIndicatorChangedListener(this);

        mButtonGetData = (Button) this.findViewById(R.id.button_get_data);
        mButtonGetData.setOnClickListener(this);
    }

    public void initCalendar() {
        mGLCView.init();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_get_data:
                GregorianLunarCalendarView.CalendarData calendarData = mGLCView.getCalendarData();
                Calendar calendar = calendarData.getCalendar();
//                String showToast = "Gregorian : " + calendar.get(Calendar.YEAR) + "-"
//                        + (calendar.get(Calendar.MONTH) + 1) + "-"
//                        + calendar.get(Calendar.DAY_OF_MONTH) + "\n"
//                        + "Lunar     : " + calendar.get(ChineseCalendar.CHINESE_YEAR) + "-"
//                        + (calendar.get(ChineseCalendar.CHINESE_MONTH)) + "-"
//                        + calendar.get(ChineseCalendar.CHINESE_DATE);
//                Toast.makeText(mContext.getApplicationContext(), showToast, Toast.LENGTH_LONG).show();
                dialogListener.getdata(calendar);
                this.dismiss();
                break;
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

    private void initWindow() {
        Window win = this.getWindow();
        win.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams lp = win.getAttributes();
        lp.width = (int) (0.90 * getScreenWidth(getContext()));
        if (lp.width > dp2px(getContext(), 480)) {
            lp.width = dp2px(getContext(), 480);
        }
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.CENTER;
        win.setAttributes(lp);
    }

    private int getScreenWidth(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        return wm.getDefaultDisplay().getWidth();
    }

    private int dp2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }
}