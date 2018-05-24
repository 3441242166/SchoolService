package com.example.wanhao.schoolservice.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.wanhao.schoolservice.R;
import com.example.wanhao.schoolservice.activity.ChatRoomActivity;
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
        list.add(new ChatRoomBean("Android交流组","凌晨 00:02","[图片]","https://gss0.baidu.com/7Po3dSag_xI4khGko9WTAnF6hhy/zhidao/pic/item/267f9e2f0708283868ad490fba99a9014c08f10d.jpg"));
        list.add(new ChatRoomBean("高数交流组","10:42","划重点","https://gss0.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/zhidao/pic/item/503d269759ee3d6dc4fd13d041166d224f4adef6.jpg"));
        list.add(new ChatRoomBean("街舞交流组","03:02","大哥 厉害了","https://gss0.baidu.com/9fo3dSag_xI4khGko9WTAnF6hhy/zhidao/pic/item/29381f30e924b899d3e8ec236c061d950b7bf6d1.jpg"));
        list.add(new ChatRoomBean("健身交流组","18:02","一起去健身的有没有","https://gss0.baidu.com/-4o3dSag_xI4khGko9WTAnF6hhy/zhidao/pic/item/faedab64034f78f0a3fe0fe87b310a55b3191c37.jpg"));
        list.add(new ChatRoomBean("LOL交流组","10:17","[图片]","https://gss0.baidu.com/-fo3dSag_xI4khGko9WTAnF6hhy/zhidao/pic/item/c83d70cf3bc79f3de6fd702bb8a1cd11728b2988.jpg"));
        list.add(new ChatRoomBean("前端交流组","06:01","你这是那什么工具开发的？","https://gss0.baidu.com/-fo3dSag_xI4khGko9WTAnF6hhy/zhidao/pic/item/8cb1cb13495409232347f7659058d109b3de49fb.jpg"));
        list.add(new ChatRoomBean("足球交流组","22:23","[图片]","https://gss0.baidu.com/-Po3dSag_xI4khGko9WTAnF6hhy/zhidao/pic/item/8b82b9014a90f6031079095c3b12b31bb151ede4.jpg"));

        adapter = new ChatRoomAdapter(list,getContext());

        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(getContext(), ChatRoomActivity.class));
            }
        });
    }
}
