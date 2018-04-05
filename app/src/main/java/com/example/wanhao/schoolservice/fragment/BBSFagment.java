package com.example.wanhao.schoolservice.fragment;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.TextView;

import com.example.wanhao.schoolservice.R;
import com.example.wanhao.schoolservice.adapter.BBSItemAdapter;
import com.example.wanhao.schoolservice.base.LazyLoadFragment;
import com.example.wanhao.schoolservice.bean.BBSItem;
import com.example.wanhao.schoolservice.util.MyItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by wanhao on 2017/11/18.
 */

public class BBSFagment extends LazyLoadFragment {
    private static final String TAG = "BBSFagment";

    @BindView(R.id.fg_bbs_recycler)
    RecyclerView recyclerView;
    @BindView(R.id.fg_bbs_search)
    TextView btSearch;

    private BBSItemAdapter adapter;
    private List<BBSItem> list;

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

        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
        recyclerView.addItemDecoration(new MyItemDecoration());

        list = new ArrayList<>();
        BBSItem item = new BBSItem();
        for(int x=0;x<10;x++){
            item = new BBSItem();
            item.setImgID(R.drawable.ceshi_head);
            item.setTitle("西安科技大学");
            item.setContent("什么都没有呢");
            list.add(item);
        }

        adapter = new BBSItemAdapter(R.layout.item_bbs,list);
        recyclerView.setAdapter(adapter);

    }


    private void initEvent() {

    }

}
