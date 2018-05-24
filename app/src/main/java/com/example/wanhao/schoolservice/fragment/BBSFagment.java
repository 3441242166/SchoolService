package com.example.wanhao.schoolservice.fragment;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.wanhao.schoolservice.R;
import com.example.wanhao.schoolservice.activity.BBSActivity;
import com.example.wanhao.schoolservice.activity.SearchActivity;
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

        list = new ArrayList<>();

        list.add(new BBSItem(R.drawable.icon_school_1,"西安科技大学","简称“西科大”"));
        list.add(new BBSItem(R.drawable.icon_school_2,"西安电子科技大学","简称“西电”或“西军电”"));
        list.add(new BBSItem(R.drawable.icon_school_3,"西安邮电大学","简称“西邮”"));

        adapter = new BBSItemAdapter(list,getContext());
        recyclerView.setAdapter(adapter);

    }


    private void initEvent() {
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(getContext(), BBSActivity.class));
            }
        });

        btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), SearchActivity.class));
            }
        });
    }

}
