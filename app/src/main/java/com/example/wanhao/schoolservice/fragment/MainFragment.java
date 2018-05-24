package com.example.wanhao.schoolservice.fragment;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.wanhao.schoolservice.R;
import com.example.wanhao.schoolservice.activity.InterestActivity;
import com.example.wanhao.schoolservice.activity.OtherFunctionActivity;
import com.example.wanhao.schoolservice.adapter.GridAdapter;
import com.example.wanhao.schoolservice.base.LazyLoadFragment;
import com.example.wanhao.schoolservice.bean.GridBean;
import com.example.wanhao.schoolservice.util.ImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by wanhao on 2017/11/18.
 */

public class MainFragment extends LazyLoadFragment {

    @BindView(R.id.fg_main_banner)
    Banner banner;
    @BindView(R.id.fg_main_icon_recycler)
    RecyclerView iconRecycler;

    private List<GridBean> iconList;
    private GridAdapter gridAdapter;

    @Override
    protected int setContentView() {
        return R.layout.fragment_main;
    }

    @Override
    protected void lazyLoad() {
        initData();
        initView();
        initEvent();
    }

    private void initData() {
        iconList = new ArrayList<>();
        GridBean gridBean = new GridBean(R.drawable.icon_main_fragment_1,"校园市场");
        iconList.add(gridBean);

        gridBean = new GridBean(R.drawable.icon_main_fragment_2,"兴趣圈");
        iconList.add(gridBean);

        gridBean = new GridBean(R.drawable.icon_main_fragment_3,"校园头条");
        iconList.add(gridBean);

        gridBean = new GridBean(R.drawable.icon_main_fragment_4,"周边服务");
        iconList.add(gridBean);

        gridBean = new GridBean(R.drawable.icon_main_fragment_5,"探索模式");
        iconList.add(gridBean);

        gridBean = new GridBean(R.drawable.icon_main_fragment_6,"更多");
        iconList.add(gridBean);
    }

    private void initView() {

        iconRecycler.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
        //new PagingScrollHelper().setUpRecycleView(iconRecycler);

        gridAdapter = new GridAdapter(R.layout.item_grid,null);
        iconRecycler.setAdapter(gridAdapter);


        gridAdapter.setNewData(iconList);

        //设置图片加载器
        banner.setBannerStyle(BannerConfig.NUM_INDICATOR_TITLE);
        banner.setImageLoader(new ImageLoader());
        //设置图片集合
        List<Integer> list = new ArrayList<>();
        list.add(R.drawable.photo_yundong);
        list.add(R.drawable.photo_food);
        list.add(R.drawable.photo_hulianwang);
        list.add(R.drawable.photo_jianshen);
        list.add(R.drawable.photo_xuexi);
        List<String> stringList = new ArrayList<>();
        stringList.add("西安科技大学运动会开始啦！");
        stringList.add("快为你喜欢的美食打call");
        stringList.add("第四届互联网+比赛即将开始");
        stringList.add("小调后街健身房开业咯");
        stringList.add("史上最全的高数学习资源");

        banner.setImages(list);
        banner.setBannerTitles(stringList);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }

    private void initEvent() {
        gridAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                switch (position){
                    case 0:
                        break;
                    case 1:
                        startActivity(new Intent(getContext(), InterestActivity.class));
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        startActivity(new Intent(getContext(), OtherFunctionActivity.class));
                        break;

                }
            }
        });
    }


}
