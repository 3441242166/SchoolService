package com.example.wanhao.schoolservice.view;

/**
 * Created by wanhao on 2017/11/22.
 */

public interface IRegisterView {

    //注册成功接口
    void registerSuccess(String msg);
    //注册失败接口
    void registerFailed(String msg);
    //合法性检验错误
    void validateError(String msg);

}
