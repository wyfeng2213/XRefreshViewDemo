package com.example.administrator.xrefreshviewdemo.databinding;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.xrefreshviewdemo.R;
import com.example.administrator.xrefreshviewdemo.UserBinding;

public class DataBindingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_data_binding);
        UserBinding binding = DataBindingUtil.setContentView(
                this, R.layout.activity_data_binding);
//        User user = new User("万XX", "篮球");
//        binding.setUser(user);
//
//        binding.getUser();
//        ToastUtil.show(this,binding.getUser().getUserName()+","+binding.getUser().getLike());
    }

    public static void startActivity(Context context) {
        Intent starter = new Intent(context, DataBindingActivity.class);
        context.startActivity(starter);
    }
}
