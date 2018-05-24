package com.example.wanhao.schoolservice.config;

/**
 * Created by szh on 2017/5/6.
 * 网络请求配置文件
 */

public class ApiConfig {

    public static final String QUEST_KEY = "3906a90d6d25bce452fa0c99659ec1c8";

    /********************服务端API**************************/
    public static final String BASE_API_URL = "http://api.tianapi.com/";
    public static final String BASE_URL = "http://118.24.78.125:8080/campusRemote/";

    public static final String LODING_URL = "Login/login";
    public static final String REGISTER_URL = "Consumer/register";

    /********************状态码**************************/

//200    处理成功
//200102 信息匹配
//
//202    处理失败
//202100 账号或密码错误
//202102 用户不存在
//202103 权限不足
//202200 登录信息不可用
//202204 用户名或者密码不正确


}
