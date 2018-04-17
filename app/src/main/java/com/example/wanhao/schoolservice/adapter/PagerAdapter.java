package com.example.wanhao.schoolservice.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by wanhao on 2017/10/3.
 */

public class PagerAdapter <T extends Fragment>extends FragmentPagerAdapter {

    List<T> list;
    String []ar ={"推荐","关注","竞赛","考试","生活"};

    public PagerAdapter(FragmentManager fm, List<T> list) {
        super(fm);
        this.list = list;
    }

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
        return ar[position];
    }
}
