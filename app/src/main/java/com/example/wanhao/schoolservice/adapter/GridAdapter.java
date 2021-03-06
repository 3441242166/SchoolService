package com.example.wanhao.schoolservice.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.wanhao.schoolservice.R;
import com.example.wanhao.schoolservice.bean.GridBean;

import java.util.List;

/**
 * Created by wanhao on 2018/3/10.
 */

public class GridAdapter extends BaseQuickAdapter<GridBean,BaseViewHolder> {

    public GridAdapter(int layoutResId, @Nullable List<GridBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GridBean item) {
        helper.setText(R.id.item_grid_text,item.getName());
        helper.setImageResource(R.id.item_grid_image,item.getImgID());
    }
}
