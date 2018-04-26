package com.example.wanhao.schoolservice.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.wanhao.schoolservice.R;
import com.example.wanhao.schoolservice.base.TopBarBaseActivity;

public class UserMessageActivity extends TopBarBaseActivity {



    @Override
    protected int getContentView() {
        return R.layout.activity_user_message;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        setTitle("个人信息");
        setTopLeftButton(new OnClickListener() {
            @Override
            public void onClick() {
                finish();
            }
        });
    }
}
