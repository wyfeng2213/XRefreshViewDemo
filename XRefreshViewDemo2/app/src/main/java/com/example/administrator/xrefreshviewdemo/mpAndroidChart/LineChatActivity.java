package com.example.administrator.xrefreshviewdemo.mpAndroidChart;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.xrefreshviewdemo.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class LineChatActivity extends AppCompatActivity implements OnChartValueSelectedListener {

    int dataXcountMax = 24 * 60;
    private LineChart lineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_chat);
        initView();
        initChart();

        String time1 = "1495600415000";
        int data1 = 70;
        MyData myData1 = new MyData(time1, data1);

        String time2 = "1495607615000";
        int data2 = 90;
        MyData myData2 = new MyData(time2, data2);

        String time3 = "1495622015000";
        int data3 = 140;
        MyData myData3 = new MyData(time3, data3);

        ArrayList<MyData> list = new ArrayList<>();
        list.add(myData1);
        list.add(myData2);
        list.add(myData3);

        setData(list);
    }

    public static void startActivity(Context context) {
        Intent starter = new Intent(context, LineChatActivity.class);
//        starter.putExtra();
        context.startActivity(starter);
    }

    private void initChart() {
        lineChart.getDescription().setEnabled(false);
//        lineChart.animateX(3000);
        // 图例设置
        Legend legend = lineChart.getLegend();
        legend.setEnabled(true);
        // 禁用缩放
        lineChart.setScaleEnabled(false);
        //设置mark
        MyMarkerView mv = new MyMarkerView(this, R.layout.custom_marker_view);
        mv.setChartView(lineChart); // For bounds control
        lineChart.setMarker(mv);

        // ==============X坐标设置
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM); // 设置X轴的位置
        xAxis.setDrawGridLines(true);
        xAxis.setAxisMinimum(6 * 60);
        xAxis.setAxisMaximum(dataXcountMax);
        // 4个并且显示平均长度
        xAxis.setLabelCount(4, true);
        // 设置自定义的格式
        xAxis.setValueFormatter(new MyTimeXAxisValueFormatter());

        //================Y左边设置
        YAxis leftAxis = lineChart.getAxisLeft();
        // 该轴最小值总是0
        leftAxis.setDrawZeroLine(true);
        // 设置最大值和最小值
        leftAxis.setAxisMaximum(200f);
        leftAxis.setAxisMinimum(0f);
        leftAxis.setDrawGridLines(true);
        // 4个并且显示平均长度
        leftAxis.setLabelCount(4, false);
        // 绘制虚线
        leftAxis.enableGridDashedLine(10f, 10f, 0f);
        lineChart.getAxisRight().setEnabled(false);
    }

    private void setData(ArrayList<MyData> list) {
        ArrayList<Entry> values = new ArrayList<Entry>();
        for (int i = 0; i < list.size(); i++) {
            MyData myData = list.get(i);
            Calendar calendar = Calendar.getInstance();
            Long timestamp = Long.parseLong(myData.getTime());
            Date date = new java.util.Date(timestamp);
            int hour = date.getHours();
            int minute = date.getMinutes();
            int remainMin = hour * 60 + minute;
            // 获取数据的时和分钟
            values.add(new Entry(remainMin, myData.getData()));
        }


        LineDataSet lineDataSet;
        lineDataSet = new LineDataSet(values, "测试");
        // 设置数值的显示
        lineDataSet.setDrawValues(false);
        lineDataSet.setDrawHighlightIndicators(false);//关闭heightlight

        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        dataSets.add(lineDataSet); // add the datasets
        List<String> quarterStrs = new ArrayList<String>();
        LineData data = new LineData(dataSets);
        lineChart.setData(data);

    }

    private void initView() {
        lineChart = (LineChart) findViewById(R.id.line_chart);
    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }
}
