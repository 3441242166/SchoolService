package com.example.wanhao.schoolservice.config;

/**
 * 用户常量
 */

public class Constant {
    /*********************adapterItem类型********************************/
    public static final int  AD_MESSAGE = 0;
    public static final int AD_MESSAGE_IMAGE = 1;
    /*********************adapterItem类型********************************/
    /*********************请求相关********************************/
    //bean的格式
    public static final String  REQUEST_CODE = "code";
    public static final String  REQUEST_MSG = "msg";

    public static final String  REQUEST_DATA = "data";
    //不存在
    public static final String  SOMETHING_DONOT_EXIST = "-1";
    public static final String  SOMETHING_EXIST = "1";
    //请求成功和失败
    public static final String  REQUEST_SUCCESS = "200";
    public static final String  REQUEST_ERROR = "-1";
    //鉴权失败(账户可能被冻结)
    public static final String  OAUTH_FAILED = "400";
    /*********************请求相关********************************/

    /*********************文件命名相关********************************/
    public static final String  SHAREDPREFERENCES_DEFAULT_NAME = "app_prefs";
    public static final String LODING_TOKEN = "token";
    /*********************文件命名相关********************************/



}
