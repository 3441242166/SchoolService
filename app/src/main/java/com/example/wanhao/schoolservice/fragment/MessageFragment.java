package com.example.wanhao.schoolservice.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.wanhao.schoolservice.R;
import com.example.wanhao.schoolservice.adapter.GridAdapter;
import com.example.wanhao.schoolservice.adapter.PagerAdapter;
import com.example.wanhao.schoolservice.base.LazyLoadFragment;
import com.example.wanhao.schoolservice.bean.GridBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by wanhao on 2017/11/18.
 */

public class MessageFragment extends LazyLoadFragment{
    private static final String TAG = "MessageFragment";

    @BindView(R.id.fg_message_icon_recycler)
    RecyclerView iconRecycler;
    @BindView(R.id.fg_message_tab)
    TabLayout tabLayout;
    @BindView(R.id.fg_message_viewpager)
    ViewPager viewPager;

    private GridAdapter gridAdapter;
    private List<ListFragment> fragmentList;
    private List<GridBean> iconList;

    @Override
    protected int setContentView() {
        return R.layout.fragment_message;
    }

    @Override
    protected void lazyLoad() {
        initData();
        initView();
    }

    private void initData() {
        iconList = new ArrayList<>();
        GridBean gridBean = new GridBean(R.drawable.icon_main_fragment_1,"考试");
        iconList.add(gridBean);

        gridBean = new GridBean(R.drawable.icon_main_fragment_2,"竞赛");
        iconList.add(gridBean);

        gridBean = new GridBean(R.drawable.icon_main_fragment_3,"招聘");
        iconList.add(gridBean);

        gridBean = new GridBean(R.drawable.icon_main_fragment_4,"社团");
        iconList.add(gridBean);
    }


    private void initView() {

        iconRecycler.setLayoutManager(new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL));

        gridAdapter = new GridAdapter(R.layout.item_grid,null);
        iconRecycler.setAdapter(gridAdapter);


        gridAdapter.setNewData(iconList);

        fragmentList = new ArrayList<>();
        for(int x=0;x<5;x++)
            fragmentList.add(new ListFragment());

        String []ar ={"推荐","关注","竞赛","考试","生活"};
        viewPager.setAdapter(new PagerAdapter<ListFragment>(getActivity().getSupportFragmentManager(),fragmentList,ar));
        tabLayout.setupWithViewPager(viewPager);

        viewPager.setOverScrollMode(viewPager.OVER_SCROLL_NEVER);
        viewPager.setOffscreenPageLimit(10);
    }

}
