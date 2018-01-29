package com.example.wanhao.schoolservice.myview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wanhao.schoolservice.R;


/**
 * Created by wanhao on 2017/11/4.
 */

public class BottomView extends LinearLayout {

    TextView mEditText;
    ImageView mImageView;

    public BottomView(Context context) {
        super(context);
    }

    public BottomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        // 加载布局
        LayoutInflater.from(context).inflate(R.layout.view_bottom, this);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.imageList);

        String text = ta.getString(R.styleable.imageList_text);

        // 获取控件
        mEditText = (TextView) findViewById(R.id.bottom_text);
        mImageView = (ImageView) findViewById(R.id.bottom_image);

        mEditText.setText(text);

    }

    public void setImage(int id){
        mImageView.setImageResource(id);
    }

    public void setTextColor(boolean isClick){
        if(isClick) {
            mEditText.setTextColor(0xFF0000FF);
        }else{
            mEditText.setTextColor(Color.BLACK);
        }
    }
}
