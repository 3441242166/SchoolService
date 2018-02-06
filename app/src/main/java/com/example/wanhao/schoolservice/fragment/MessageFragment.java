package com.example.wanhao.schoolservice.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.example.wanhao.schoolservice.R;
import com.example.wanhao.schoolservice.adapter.PagerAdapter;
import com.example.wanhao.schoolservice.base.LazyLoadFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanhao on 2017/11/18.
 */

public class MessageFragment extends LazyLoadFragment{

    private TabLayout tabLayout;

    private ViewPager viewPager;
    private List<ListFragment> fragmentList;


    @Override
    protected int setContentView() {
        return R.layout.fragment_message;
    }

    @Override
    protected void lazyLoad() {
        initView();
    }


    private void initView() {
        tabLayout = findViewById(R.id.fg_message_tab);
        viewPager = findViewById(R.id.fg_message_viewpager);

        fragmentList = new ArrayList<>();
        for(int x=0;x<5;x++)
            fragmentList.add(new ListFragment());

        viewPager.setAdapter(new PagerAdapter<ListFragment>(getActivity().getSupportFragmentManager(),fragmentList));
        tabLayout.setupWithViewPager(viewPager);

        viewPager.setOverScrollMode(viewPager.OVER_SCROLL_NEVER);
        viewPager.setOffscreenPageLimit(10);
    }

}
