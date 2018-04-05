package com.example.wanhao.schoolservice.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.wanhao.schoolservice.R;
import com.example.wanhao.schoolservice.bean.BBSItem;

import java.util.List;

/**
 * Created by wanhao on 2018/4/4.
 */

public class BBSItemAdapter extends BaseQuickAdapter<BBSItem,BaseViewHolder> {

    public BBSItemAdapter(int layoutResId, @Nullable List<BBSItem> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, BBSItem item) {
        helper.setText(R.id.item_bbs_title,item.getTitle());
        helper.setText(R.id.item_bbs_content,item.getContent());
        helper.setImageResource(R.id.item_bbs_img,item.getImgID());
    }
}