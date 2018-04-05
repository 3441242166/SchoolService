package com.example.wanhao.schoolservice.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.wanhao.schoolservice.R;
import com.example.wanhao.schoolservice.bean.ListBean;

import java.util.List;

/**
 * Created by wanhao on 2018/4/3.
 */

public class ListAdapter extends BaseQuickAdapter<ListBean,BaseViewHolder> {

    public ListAdapter(int layoutResId, @Nullable List<ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ListBean item) {
        helper.setText(R.id.item_grid_text,item.getContent());
        helper.setImageResource(R.id.item_grid_image,item.getImgID());
    }
}
