package com.example.wanhao.schoolservice.service;

import com.example.wanhao.schoolservice.bean.UserMessage;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by wanhao on 2017/12/6.
 */

public interface LodingService {
    @FormUrlEncoded
    @POST("user/login")
    Observable<UserMessage> login(@Field("phone") String telNum,       //url ApiConstant.TEL_NUM = telNum
                                  @Field("password") String password);
}
