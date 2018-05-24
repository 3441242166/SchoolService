package com.example.wanhao.schoolservice.fragment;

import android.support.v7.widget.RecyclerView;

import com.example.wanhao.schoolservice.R;
import com.example.wanhao.schoolservice.base.LazyLoadFragment;

import butterknife.BindView;

public class DynamicFragment extends LazyLoadFragment{


    @BindView(R.id.fg_dynmic_recycler)
    RecyclerView recyclerView;


    @Override
    protected int setContentView() {
        return R.layout.fragment_dynamic;
    }

    @Override
    protected void lazyLoad() {
        initData();
        initView();
        initEvent();

    }

    private void initData() {

    }

    private void initView() {

    }

    private void initEvent() {

    }
}
