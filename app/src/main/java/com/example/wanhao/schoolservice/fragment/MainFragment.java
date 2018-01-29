package com.example.wanhao.schoolservice.fragment;

import com.example.wanhao.schoolservice.R;
import com.example.wanhao.schoolservice.util.ImageLoader;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanhao on 2017/11/18.
 */

public class MainFragment extends LazyLoadFragment{

    private Banner banner;

    @Override
    protected int setContentView() {
        return R.layout.fragment_main;
    }

    @Override
    protected void lazyLoad() {
        banner = findViewById(R.id.fg_main_banner);
        //设置图片加载器
        banner.setImageLoader(new ImageLoader());
        //设置图片集合
        List<Integer> list = new ArrayList<>();
        list.add(R.drawable.ce_0);
        list.add(R.drawable.ce_1);
        list.add(R.drawable.ce_2);
        list.add(R.drawable.ce_3);
        list.add(R.drawable.ce_4);

        banner.setImages(list);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }


}
