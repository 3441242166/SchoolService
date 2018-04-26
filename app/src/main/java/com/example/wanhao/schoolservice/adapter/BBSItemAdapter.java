package com.example.wanhao.schoolservice.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.wanhao.schoolservice.R;
import com.example.wanhao.schoolservice.bean.BBSItem;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by wanhao on 2018/4/4.
 */

public class BBSItemAdapter extends BaseQuickAdapter<BBSItem,BaseViewHolder> {

    private Context context;

    public BBSItemAdapter(@Nullable List<BBSItem> data, Context context) {
        super(R.layout.item_bbs, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, BBSItem item) {
        helper.setText(R.id.item_bbs_title,item.getTitle());
        helper.setText(R.id.item_bbs_content,item.getContent());
        Glide.with(context).load(item.getImgID()).into((ImageView) helper.getView(R.id.item_bbs_img));
        //helper.setImageResource(R.id.item_bbs_img,item.getImgID());
    }
}