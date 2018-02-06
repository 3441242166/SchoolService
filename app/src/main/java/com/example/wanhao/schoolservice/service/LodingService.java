package com.example.wanhao.schoolservice.service;

import com.example.wanhao.schoolservice.config.ApiConstant;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by wanhao on 2017/12/6.
 */

public interface LodingService {
    @GET("user/login")
    Observable<Response<ResponseBody>> loding(@Query(ApiConstant.LODING_COUNT) String count, @Query(ApiConstant.LODING_PASSWORD) String password);

}
