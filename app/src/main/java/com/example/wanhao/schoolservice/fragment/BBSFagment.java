package com.example.wanhao.schoolservice.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.wanhao.schoolservice.R;
import com.example.wanhao.schoolservice.base.LazyLoadFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanhao on 2017/11/18.
 */

public class BBSFagment extends LazyLoadFragment {
    private static final String TAG = "BBSFagment";

    ViewPager viewPager;
    TabLayout tabLayout;
    List<Fragment> fragmentList;
    FragmentPagerAdapter adapter;
    BBSEntertainFragment fgHot;
    StudyBBSFragment studyBBSFragment;

    @Override
    protected int setContentView() {
        return R.layout.fragment_bbs;
    }

    @Override
    protected void lazyLoad() {
        initView();
        initEvent();
    }

    private void initView() {
        viewPager =  findViewById(R.id.fg_bbs_pager);
        tabLayout =  findViewById(R.id.fg_bbs_tab);

        fragmentList = new ArrayList<>();
        fgHot = new BBSEntertainFragment();
        studyBBSFragment = new StudyBBSFragment();
        fragmentList.add(fgHot);
        fragmentList.add(studyBBSFragment);

        final List<String> title = new ArrayList<>();
        title.add("娱乐");
        title.add("学习交流");
        adapter = new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return fragmentList.size();
            }

            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }
            @Override
            public CharSequence getPageTitle(int position) {
                return title.get(position);
            }
        };
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }


    private void initEvent() {

    }

}
