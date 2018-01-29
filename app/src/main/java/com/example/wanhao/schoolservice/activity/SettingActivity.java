package com.example.wanhao.schoolservice.activity;

import android.os.Bundle;

import com.example.wanhao.schoolservice.R;
import com.example.wanhao.schoolservice.fragment.SettingFragment;

public class SettingActivity extends TopBarBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_setting;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        getFragmentManager().beginTransaction()
                .replace(R.id.ac_setting_fg, new SettingFragment())
                .commit();

        setTopLeftButton(new OnClickListener() {
            @Override
            public void onClick() {
                SettingActivity.this.finish();
            }
        });

        setTopRightButton("保存", new OnClickListener() {
            @Override
            public void onClick() {

            }
        });
    }
}
