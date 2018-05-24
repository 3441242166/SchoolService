package com.example.wanhao.schoolservice.service;

import com.example.wanhao.schoolservice.config.ApiConfig;
import com.example.wanhao.schoolservice.config.ApiConstant;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by wanhao on 2017/12/6.
 */

public interface LandingRegisterService {
    @FormUrlEncoded
    @POST(ApiConfig.LODING_URL)
    Observable<Response<ResponseBody>> loding(@Field(ApiConstant.USER_NUMBER) String number, @Field(ApiConstant.USER_PASSWORD) String password);

    @POST(ApiConfig.REGISTER_URL)
    Observable<Response<ResponseBody>> register(@Body RequestBody body);
}
