package com.example.administrator.xrefreshviewdemo.expandablelist.normallistview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.administrator.xrefreshviewdemo.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kehan on 16-7-19.
 */
public class ExpandableListViewTestActivity extends AppCompatActivity {

    private final String tag = "ExpandableListViewTest";

    private ExpandableListView listview;
    private MyExpandableListViewAdapter adapter;

    private Map<String, List<String>> dataset = new HashMap<>();
    private String[] parentList = new String[]{"first", "second", "third"};
    private List<String> childrenList1 = new ArrayList<>();
    private List<String> childrenList2 = new ArrayList<>();
    private List<String> childrenList3 = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expandable_layout);
        listview = (ExpandableListView) findViewById(R.id.expandablelistview);
        initialData();
        adapter = new MyExpandableListViewAdapter(this, dataset, parentList);
        listview.setAdapter(adapter);
        listview.setGroupIndicator(null);
        listview.expandGroup(0);

        listview.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view,
                                        int parentPos, int childPos, long l) {
                Toast.makeText(ExpandableListViewTestActivity.this,
                        dataset.get(parentList[parentPos]).get(childPos), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                String content = "";
                if ((int) view.getTag(R.layout.child_item) == -1) {
                    content = "父类第" + view.getTag(R.layout.parent_item) + "项" + "被长按了";
                } else {
                    content = "父类第" + view.getTag(R.layout.parent_item) + "项" + "中的"
                            + "子类第" + view.getTag(R.layout.child_item) + "项" + "被长按了";
                }
                Toast.makeText(ExpandableListViewTestActivity.this, content, Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }

    /**
     * 初始化数据
     */
    private void initialData() {
        childrenList1.add(parentList[0] + "-" + "first");
        childrenList1.add(parentList[0] + "-" + "second");
        childrenList1.add(parentList[0] + "-" + "third");
        childrenList2.add(parentList[1] + "-" + "first");
        childrenList2.add(parentList[1] + "-" + "second");
        childrenList2.add(parentList[1] + "-" + "third");
        childrenList3.add(parentList[2] + "-" + "first");
        childrenList3.add(parentList[2] + "-" + "second");
        childrenList3.add(parentList[2] + "-" + "third");
        dataset.put(parentList[0], childrenList1);
        dataset.put(parentList[1], childrenList2);
        dataset.put(parentList[2], childrenList3);
    }

    public static void startActivity(Context context) {
        Intent starter = new Intent(context, ExpandableListViewTestActivity.class);
//        starter.putExtra();
        context.startActivity(starter);
    }

}
