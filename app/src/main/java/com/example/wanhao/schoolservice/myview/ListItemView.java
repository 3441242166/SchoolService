package com.example.wanhao.schoolservice.myview;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wanhao.schoolservice.R;

/**
 * Created by wanhao on 2017/11/18.
 */

public class ListItemView extends LinearLayout {
    TextView mTextView;
    ImageView mImageView;

    public ListItemView(Context context) {
        super(context);
    }

    public ListItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        // 加载布局
        LayoutInflater.from(context).inflate(R.layout.view_list_item, this);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.imageList);

        String text = ta.getString(R.styleable.imageList_text);
        int id = ta.getResourceId(R.styleable.imageList_background,R.drawable.icon_add);

        // 获取控件
        mTextView = (TextView) findViewById(R.id.list_view_text);
        mImageView = (ImageView) findViewById(R.id.list_view_image);

        mImageView.setImageResource(id);
        mTextView.setText(text);
    }

}
