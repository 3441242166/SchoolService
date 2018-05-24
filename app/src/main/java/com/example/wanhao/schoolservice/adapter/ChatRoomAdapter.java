package com.example.wanhao.schoolservice.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.wanhao.schoolservice.R;
import com.example.wanhao.schoolservice.bean.ChatRoomBean;

import java.util.List;

public class ChatRoomAdapter extends BaseQuickAdapter<ChatRoomBean,BaseViewHolder> {

    private Context context;

    public ChatRoomAdapter(@Nullable List<ChatRoomBean> data, Context context) {
        super(R.layout.item_chatroom, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, ChatRoomBean item) {
        helper.setText(R.id.item_chatroom_title,item.getTitle());
        helper.setText(R.id.item_chatroom_time,item.getTime());
        helper.setText(R.id.item_chatroom_message,item.getMessage());
        Glide.with(context).load(item.getImgUrl()).into((ImageView) helper.getView(R.id.item_chatroom_head));
    }
}