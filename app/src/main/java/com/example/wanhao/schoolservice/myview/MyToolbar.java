package com.example.wanhao.schoolservice.myview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import com.example.wanhao.schoolservice.R;

/**
 * Created by wanhao on 2018/1/13.
 */

public class MyToolbar extends Toolbar {


    public MyToolbar(Context context) {
        super(context);
    }

    public MyToolbar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        // 加载布局
        LayoutInflater.from(context).inflate(R.layout.view_list_item, this);

    }

}
