package com.example.wanhao.schoolservice.fragment;

import android.app.ActivityOptions;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.example.wanhao.schoolservice.R;
import com.example.wanhao.schoolservice.activity.CareActivity;
import com.example.wanhao.schoolservice.activity.LodingActivity;
import com.example.wanhao.schoolservice.activity.MessageActivity;
import com.example.wanhao.schoolservice.activity.SettingActivity;
import com.example.wanhao.schoolservice.activity.UserMessageActivity;
import com.example.wanhao.schoolservice.base.LazyLoadFragment;
import com.example.wanhao.schoolservice.myview.ListItemView;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by wanhao on 2017/11/18.
 */

public class UserFragment extends LazyLoadFragment {
    private static final String TAG = "UserFragment";

    private ListItemView listExit;
    private ListItemView listNotify;
    private ListItemView listSetting;
    private ListItemView listCare;
    private CircleImageView headView;
    private TextView textName;

    @Override
    protected int setContentView() {
        return R.layout.fragment_user;
    }

    @Override
    protected void lazyLoad() {
        listExit = (ListItemView) findViewById(R.id.fg_user_exit);
        listNotify = (ListItemView) findViewById(R.id.fg_user_notify);
        listSetting = (ListItemView) findViewById(R.id.fg_user_setting);
        listCare = (ListItemView) findViewById(R.id.fg_user_care);
        headView = (CircleImageView) findViewById(R.id.fg_user_head);
        textName = (TextView) findViewById(R.id.fg_user_name);

        initEvent();
    }

    private void initEvent() {
        listExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), LodingActivity.class));
            }
        });

        listNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MessageActivity.class));
            }
        });

        listSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SettingActivity.class));
            }
        });

        listCare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), CareActivity.class));
            }
        });

        headView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), UserMessageActivity.class),
                        ActivityOptions.makeSceneTransitionAnimation(getActivity(),
                                headView, "userHead").toBundle());
            }
        });
    }
}
