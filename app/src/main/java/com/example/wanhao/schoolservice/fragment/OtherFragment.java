package com.example.wanhao.schoolservice.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.wanhao.schoolservice.R;
import com.example.wanhao.schoolservice.adapter.GridAdapter;
import com.example.wanhao.schoolservice.base.LazyLoadFragment;
import com.example.wanhao.schoolservice.bean.GridBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanhao on 2018/3/20.
 */

public class OtherFragment extends LazyLoadFragment {

    GridView gridView;

    private List<GridBean> dataList;
    private GridAdapter adapter;

    @Override
    protected int setContentView() {
        return R.layout.fragment_other;
    }

    @Override
    protected void lazyLoad() {

        initData();
        initView();
        initEvent();

    }

    private void initData() {

        dataList = new ArrayList<>();
        GridBean bean= new GridBean();
        bean.setImgID(R.drawable.usericon_0);
        bean.setName("留言板");
        dataList.add(bean);

//        for (int i = 0; i <25; i++) {
//            GridBean bean= new GridBean();
//            bean.setImgID(R.drawable.mainicon_0);
//            bean.setName("sss");
//            dataList.add(bean);
//        }

    }

    private void initView() {
        gridView = (GridView) findViewById(R.id.fg_other_grid);

        adapter=new GridAdapter(dataList,getActivity());

        gridView.setAdapter(adapter);
    }

    private void initEvent() {

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        break;
                }
            }
        });

    }

}
