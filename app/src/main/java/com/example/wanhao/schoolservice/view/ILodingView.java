package com.example.wanhao.schoolservice.view;

import com.example.wanhao.schoolservice.base.IBaseView;

/**
 * Created by wanhao on 2017/11/22.
 */

public interface ILodingView extends IBaseView{

    //跳转到选择兴趣界面
    void gotoChooseInterestedCategoryActivity(String msg);

    void setData(String num,String password);
}
