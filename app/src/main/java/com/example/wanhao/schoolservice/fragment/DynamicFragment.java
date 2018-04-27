package com.example.wanhao.schoolservice.fragment;

import com.example.wanhao.schoolservice.R;
import com.example.wanhao.schoolservice.base.LazyLoadFragment;

public class DynamicFragment extends LazyLoadFragment{
    @Override
    protected int setContentView() {
        return R.layout.fragment_dynamic;
    }

    @Override
    protected void lazyLoad() {

    }
}
