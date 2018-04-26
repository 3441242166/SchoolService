package com.example.wanhao.schoolservice.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.wanhao.schoolservice.R;
import com.example.wanhao.schoolservice.base.TopBarBaseActivity;

public class BBSActivity extends TopBarBaseActivity {



    @Override
    protected int getContentView() {
        return R.layout.activity_bbs;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        setTopLeftButton(new OnClickListener() {
            @Override
            public void onClick() {
                finish();
            }
        });
    }
}
