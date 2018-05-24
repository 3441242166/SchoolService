package com.example.wanhao.schoolservice.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.wanhao.schoolservice.R;
import com.example.wanhao.schoolservice.adapter.GridAdapter;
import com.example.wanhao.schoolservice.adapter.PagerAdapter;
import com.example.wanhao.schoolservice.base.TopBarBaseActivity;
import com.example.wanhao.schoolservice.bean.GridBean;
import com.example.wanhao.schoolservice.fragment.ChatListFragment;
import com.example.wanhao.schoolservice.fragment.DynamicFragment;
import com.example.wanhao.schoolservice.fragment.ListFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class InterestActivity extends TopBarBaseActivity {

    @BindView(R.id.ac_interest_tab)
    TabLayout tabLayout;
    @BindView(R.id.ac_interest_viewpager)
    ViewPager viewPager;

    private List<Fragment> fragmentList;

    @Override
    protected int getContentView() {
        return R.layout.activity_interest;
    }

    @Override
    protected void init(Bundle savedInstanceState) {

        initView();
        initEvent();
    }

    private void initEvent() {
        setTopLeftButton(new OnClickListener() {
            @Override
            public void onClick() {
                finish();
            }
        });
    }

    private void initView() {
        setTitle("兴趣圈");
        fragmentList = new ArrayList<>();
        fragmentList.add(new ChatListFragment());
        fragmentList.add(new DynamicFragment());

        String []ar ={"讨论组","动态圈"};
        viewPager.setAdapter(new PagerAdapter<Fragment>(getSupportFragmentManager(),fragmentList,ar));
        tabLayout.setupWithViewPager(viewPager);

        viewPager.setOverScrollMode(viewPager.OVER_SCROLL_NEVER);
        viewPager.setOffscreenPageLimit(10);
    }
}
