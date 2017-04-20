package com.example.administrator.xrefreshviewdemo.toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.administrator.xrefreshviewdemo.R;

/**
 * 使用注意 AppTheme parent="Theme.AppCompat.Light.NoActionBar"
 */
//public class ToolBarTestActivty2 extends AppCompatActivity implements Toolbar.OnMenuItemClickListener  {
public class ToolBarTestActivty2 extends AppCompatActivity {
    public static void startActivity(Context context) {
        Intent starter = new Intent(context, ToolBarTestActivty2.class);
//        starter.putExtra();
        context.startActivity(starter);
    }

    private Toolbar toolbar;
    private boolean isDay = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_bar_activty);

        initToolbar();
    }

    private void initToolbar() {
        toolbar = findView(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
//        toolbar.setTitle("主标题");
//        toolbar.setSubtitle("副标题");
//            toolbar.setLogo(R.mipmap.ic_launcher);
        toolbar.setNavigationIcon(R.mipmap.ic_launcher);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        toolbar.setOnMenuItemClickListener(this);
    }


//        @Override
//        public boolean onCreateOptionsMenu(Menu menu) {
//            // Inflate the menu; this adds items to the action bar if it is present.
//            getMenuInflater().inflate(R.menu.menu_main, menu);
//            return true;
//        }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//            if (id == R.id.action_settings) {
//                return true;
//            }
        if (id == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    private <T extends View> T findView(int id) {
        return (T) findViewById(id);
    }

//        @Override
//        public boolean onMenuItemClick(MenuItem item) {
//
//            switch (item.getItemId()) {
//                case R.id.action_edit:
//                    Toast.makeText(this, "查找按钮", Toast.LENGTH_SHORT).show();
//                    break;
//                case R.id.action_share:
//                    Toast.makeText(this, "分享按钮", Toast.LENGTH_SHORT).show();
//                    break;
//            }
//
//            return false;
//        }
}
