package com.example.wanhao.schoolservice.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.wanhao.schoolservice.R;
import com.example.wanhao.schoolservice.adapter.GridAdapter;
import com.example.wanhao.schoolservice.base.TopBarBaseActivity;
import com.example.wanhao.schoolservice.bean.GridBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class OtherFunctionActivity extends TopBarBaseActivity{

    @BindView(R.id.ac_function_recycler)
    RecyclerView recyclerView;

    List<GridBean> list;
    GridAdapter gridAdapter;


    @Override
    protected int getContentView() {
        return R.layout.activity_other_function;
    }

    @Override
    protected void init(Bundle savedInstanceState) {

        initData();
        initView();
        initEvent();
    }

    private void initData() {
        list = new ArrayList<>();
        list.add(new GridBean(R.drawable.icon_other_0,"校园卡"));
        list.add(new GridBean(R.drawable.icon_other_1,"成绩查询"));
        list.add(new GridBean(R.drawable.icon_other_2,"代取快递"));
        list.add(new GridBean(R.drawable.icon_other_3,"失物招领"));
        list.add(new GridBean(R.drawable.icon_other_4,"表白墙"));
        list.add(new GridBean(R.drawable.icon_other_5,"匿名聊天室"));
        list.add(new GridBean(R.drawable.icon_other_6,"树洞"));
        list.add(new GridBean(R.drawable.icon_other_7,"图书馆查询"));
        list.add(new GridBean(R.drawable.icon_other_8,"课表查询"));
        list.add(new GridBean(R.drawable.icon_other_9,"补习服务"));

    }

    private void initView() {
        setTitle("更多");

        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
        //new PagingScrollHelper().setUpRecycleView(iconRecycler);

        gridAdapter = new GridAdapter(R.layout.item_grid,list);
        recyclerView.setAdapter(gridAdapter);


        recyclerView.setAdapter(gridAdapter);
    }

    private void initEvent() {
        setTopLeftButton(new OnClickListener() {
            @Override
            public void onClick() {
                finish();
            }
        });
    }
}
