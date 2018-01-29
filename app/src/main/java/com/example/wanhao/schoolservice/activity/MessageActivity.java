package com.example.wanhao.schoolservice.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.wanhao.schoolservice.R;
import com.example.wanhao.schoolservice.fragment.BBSNotifyFragment;
import com.example.wanhao.schoolservice.fragment.OtherNotifyFragment;

import java.util.ArrayList;
import java.util.List;

public class MessageActivity extends TopBarBaseActivity {
    private static final String TAG = "MessageActivity";

    ViewPager viewPager;
    TabLayout tabLayout;
    List<Fragment> list = new ArrayList<>();
    FragmentPagerAdapter adapter;
    BBSNotifyFragment bbsNotifyFragment;
    OtherNotifyFragment otherNotifyFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_message;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        viewPager = (ViewPager)findViewById(R.id.ac_notify_viewpager);
        tabLayout = (TabLayout)findViewById(R.id.ac_notify_tab);

        bbsNotifyFragment = new BBSNotifyFragment();
        otherNotifyFragment = new OtherNotifyFragment();
        list.add(bbsNotifyFragment);
        list.add(otherNotifyFragment);
        final List<String> title = new ArrayList<>();
        title.add("论坛通知");
        title.add("其他通知");

        adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
            @Override
            public CharSequence getPageTitle(int position) {
                return title.get(position);
            }
        };
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        initEvent();
    }

    private void initEvent() {
        setTopLeftButton(new OnClickListener() {
            @Override
            public void onClick() {
                MessageActivity.this.finish();
            }
        });
    }
}
