package com.example.wanhao.schoolservice.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.wanhao.schoolservice.R;
import com.example.wanhao.schoolservice.bean.GridBean;

import java.util.List;

/**
 * Created by wanhao on 2018/4/4.
 */

public class ImageTextAdapter extends BaseQuickAdapter<GridBean,BaseViewHolder> {

    public ImageTextAdapter(int layoutResId, @Nullable List<GridBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GridBean item) {
        helper.setText(R.id.item_image_text_text,item.getName());
        helper.setImageResource(R.id.item_image_text_image,item.getImgID());
    }
}

