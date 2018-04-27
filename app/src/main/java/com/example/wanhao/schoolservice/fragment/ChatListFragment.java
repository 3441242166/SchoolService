package com.example.wanhao.schoolservice.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.wanhao.schoolservice.R;
import com.example.wanhao.schoolservice.adapter.ChatRoomAdapter;
import com.example.wanhao.schoolservice.base.LazyLoadFragment;
import com.example.wanhao.schoolservice.bean.ChatRoomBean;
import com.example.wanhao.schoolservice.util.MyItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ChatListFragment extends LazyLoadFragment{
    private static final String TAG = "ChatListFragment";

    @BindView(R.id.fg_chatlist_recycler)
    RecyclerView recyclerView;

    private ChatRoomAdapter adapter;
    private List<ChatRoomBean> list;

    @Override
    protected int setContentView() {
        return R.layout.fragment_chatlist;
    }

    @Override
    protected void lazyLoad() {
        init();
    }

    private void init() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        //recyclerView.addItemDecoration(new MyItemDecoration());
        list = new ArrayList<>();
        list.add(new ChatRoomBean("Android交流组","凌晨 00:02","[图片]"));
        list.add(new ChatRoomBean("高数交流组","凌晨 00:42","划重点"));
        list.add(new ChatRoomBean("街舞交流组","凌晨 01:02","大哥 厉害了"));
        list.add(new ChatRoomBean("健身交流组","凌晨 03:02","一起去健身的有没有"));
        list.add(new ChatRoomBean("LOL交流组","凌晨 00:17","[图片]"));
        list.add(new ChatRoomBean("前端交流组","凌晨 00:01","你这是那什么工具开发的？"));
        list.add(new ChatRoomBean("足球交流组","凌晨 00:23","[图片]"));

        adapter = new ChatRoomAdapter(list,getContext());

        recyclerView.setAdapter(adapter);
    }
}
