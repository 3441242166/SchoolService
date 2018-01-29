package com.example.wanhao.schoolservice.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.wanhao.schoolservice.R;

public class UserMessageActivity extends AppCompatActivity{

    private ImageView headView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_message);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        init();
    }



    private void init() {
        initView();
        initEvent();
    }

    private void initView() {
        headView = (ImageView) findViewById(R.id.ac_user_head);
    }

    private void initEvent() {

    }
}
