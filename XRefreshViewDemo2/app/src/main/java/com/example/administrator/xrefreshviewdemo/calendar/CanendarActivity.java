package com.example.administrator.xrefreshviewdemo.calendar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrator.xrefreshviewdemo.R;

import java.util.Calendar;

public class CanendarActivity extends AppCompatActivity implements View.OnClickListener {
    private DialogGLC mDialog;
    private Button bt_calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canendar);
        initView();
    }

    public static void startActivity(Context context) {
        Intent starter = new Intent(context, CanendarActivity.class);
        context.startActivity(starter);
    }

    private void initView() {
        bt_calendar = (Button) findViewById(R.id.bt_calendar);
        bt_calendar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_calendar:
                showInDialog();
                break;
        }
    }

    private void showInDialog() {
        if (mDialog == null) {
            mDialog = new DialogGLC(this);
        }
        if (mDialog.isShowing()) {
            mDialog.dismiss();
        } else {
            mDialog.setCancelable(true);
            mDialog.setCanceledOnTouchOutside(true);
            mDialog.show();
            //better initialize NumberPickerView's data (or set a certain value)
            // every time setting up reusable dialog
            mDialog.initCalendar();
        }
        mDialog.setDialogListener(dialogListener);
    }


    CalendarDialogListener dialogListener = new CalendarDialogListener() {
        @Override
        public void getdata(Calendar calendar) {
            String data = calendar.get(Calendar.YEAR) + "-"
                    + (calendar.get(Calendar.MONTH) + 1) + "-"
                    + calendar.get(Calendar.DAY_OF_MONTH);
            Toast.makeText(CanendarActivity.this, data, Toast.LENGTH_SHORT).show();
        }
    };
}
