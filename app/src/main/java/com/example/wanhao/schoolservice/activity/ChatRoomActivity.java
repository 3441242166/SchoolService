package com.example.wanhao.schoolservice.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.wanhao.schoolservice.R;
import com.example.wanhao.schoolservice.base.TopBarBaseActivity;

public class ChatRoomActivity extends TopBarBaseActivity {



    @Override
    protected int getContentView() {
        return R.layout.activity_chat_room;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        setTitle("Android交流组");

        setTopLeftButton(new OnClickListener() {
            @Override
            public void onClick() {
                finish();
            }
        });
    }
}
