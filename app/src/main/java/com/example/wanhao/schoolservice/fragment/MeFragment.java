package com.example.wanhao.schoolservice.fragment;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.wanhao.schoolservice.R;
import com.example.wanhao.schoolservice.activity.LodingActivity;
import com.example.wanhao.schoolservice.activity.SettingActivity;
import com.example.wanhao.schoolservice.activity.UserMessageActivity;
import com.example.wanhao.schoolservice.adapter.ImageTextAdapter;
import com.example.wanhao.schoolservice.base.LazyLoadFragment;
import com.example.wanhao.schoolservice.bean.GridBean;
import com.example.wanhao.schoolservice.util.MyItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by wanhao on 2018/4/3.
 */

public class MeFragment extends LazyLoadFragment {
    private static final String TAG = "MeFragment";

    @BindView(R.id.fg_me_head)
    CircleImageView imageHead;
    @BindView(R.id.fg_me_fab)
    FloatingActionButton fab;
    @BindView(R.id.fg_me_recycler)
    RecyclerView recyclerView;

    private ImageTextAdapter adapter;

    @Override
    protected int setContentView() {
        return R.layout.fragment_me;
    }

    @Override
    protected void lazyLoad() {

        initView();
        initEvent();

    }

    private void initView() {
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));

        List<GridBean> list = new ArrayList<>();
        GridBean bean = new GridBean(R.drawable.usericon_0,"消息中心");
        list.add(bean);
        bean = new GridBean(R.drawable.usericon_1,"我的关注");
        list.add(bean);
        bean = new GridBean(R.drawable.usericon_2,"积分中心");
        list.add(bean);
        bean = new GridBean(R.drawable.usericon_3,"留言板");
        list.add(bean);
        bean = new GridBean(R.drawable.usericon_4,"设置");
        list.add(bean);
        bean = new GridBean(R.drawable.usericon_5,"退出登录");
        list.add(bean);

        adapter = new ImageTextAdapter(R.layout.item_image_text,list);
        recyclerView.setAdapter(adapter);

    }

    private void initEvent() {
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Log.i(TAG, "onItemChildClick: position = "+ position);
                switch (position){
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        startActivity(new Intent(getActivity(), SettingActivity.class));
                        break;
                    case 5:
                        startActivity(new Intent(getActivity(), LodingActivity.class));
                        break;

                }
        }
    });
        imageHead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), UserMessageActivity.class));
            }
        });
    }
}
