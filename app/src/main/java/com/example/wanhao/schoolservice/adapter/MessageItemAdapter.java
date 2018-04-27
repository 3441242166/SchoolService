package com.example.wanhao.schoolservice.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.wanhao.schoolservice.R;
import com.example.wanhao.schoolservice.bean.Message;
import com.example.wanhao.schoolservice.config.Constant;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;



/**
 * Created by wanhao on 2017/11/26.
 */

public class MessageItemAdapter extends BaseMultiItemQuickAdapter<Message,BaseViewHolder> {

    private Context context;

    public MessageItemAdapter(@Nullable List<Message> data, Context context) {
        super(data);
        this.context = context;
        addItemType(Message.NORMAL, R.layout.item_news);
        addItemType(Message.IMAGE, R.layout.item_news_image);
        Log.i(TAG, "ChatAdapter: ");
    }

    @Override
    protected void convert(BaseViewHolder helper, Message item) {
        Log.i(TAG, "convert: type "+ helper.getItemViewType());
        switch (helper.getItemViewType()) {
            case Message.NORMAL:
                helper.setText(R.id.ad_message_time,item.getTime());
                helper.setText(R.id.ad_message_title, item.getTitle());
                helper.setText(R.id.ad_message_contant, item.getContantUrl());
                break;
            case Message.IMAGE:
                helper.setText(R.id.ad_message_time,item.getTime());
                helper.setText(R.id.ad_message_title, item.getTitle());
                helper.setText(R.id.ad_message_contant, item.getContantUrl());
                Glide.with(context).load(item.getImageUrl()).into((ImageView) helper.getView(R.id.ad_message_image));
                break;
        }


    }
}