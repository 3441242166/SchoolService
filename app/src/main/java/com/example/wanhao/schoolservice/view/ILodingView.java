package com.example.wanhao.schoolservice.view;

/**
 * Created by wanhao on 2017/11/22.
 */

public interface ILodingView {

    //注册成功接口
    void loginSuccess(String msg);
    //注册失败接口
    void loginFailed(String msg);
    //合法性检验错误
    void validateError(String msg,int type);
    //跳转到选择兴趣界面
    void gotoChooseInterestedCategoryActivity(String msg);

}
