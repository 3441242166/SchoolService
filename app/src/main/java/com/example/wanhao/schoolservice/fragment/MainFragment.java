package com.example.wanhao.schoolservice.fragment;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.wanhao.schoolservice.R;
import com.example.wanhao.schoolservice.adapter.VoteAdapter;
import com.example.wanhao.schoolservice.base.LazyLoadFragment;
import com.example.wanhao.schoolservice.bean.Vote;
import com.example.wanhao.schoolservice.util.ImageLoader;
import com.example.wanhao.schoolservice.util.PagingScrollHelper;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanhao on 2017/11/18.
 */

public class MainFragment extends LazyLoadFragment {

    private Banner banner;

    private RecyclerView voteRecycler;
    private VoteAdapter voteAdapter;

    @Override
    protected int setContentView() {
        return R.layout.fragment_main;
    }

    @Override
    protected void lazyLoad() {

        initView();
        initEvent();
    }

    private void initView() {
        banner = findViewById(R.id.fg_main_banner);
        voteRecycler = findViewById(R.id.fg_main_voterecycle);
        voteRecycler.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL));
        new PagingScrollHelper().setUpRecycleView(voteRecycler);
        voteAdapter = new VoteAdapter(getActivity());
        voteRecycler.setAdapter(voteAdapter);



        List<Vote> documents = new ArrayList<>();
        for(int x=0;x<5;x++){
            Vote document = new Vote();
            document.setTitle("你有被噩梦而惊醒的经历吗？");
            document.setRed(23);
            document.setBlue(77);
            document.setRedString("有过");
            document.setBlueString("没有过");
            document.setParticipant(6481);
            documents.add(document);
        }

        voteAdapter.setData(documents);

        //设置图片加载器
        banner.setImageLoader(new ImageLoader());
        //设置图片集合
        List<Integer> list = new ArrayList<>();
        list.add(R.drawable.ce_0);
        list.add(R.drawable.ce_1);
        list.add(R.drawable.ce_2);
        list.add(R.drawable.ce_3);
        list.add(R.drawable.ce_4);

        banner.setImages(list);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }

    private void initEvent() {

    }


}
