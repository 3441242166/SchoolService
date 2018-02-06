package com.example.wanhao.schoolservice.service;

import com.example.wanhao.schoolservice.config.ApiConstant;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by wanhao on 2018/2/6.
 */

public interface DataService {

    @GET("{type}")
    Observable<Response<ResponseBody>> getMessageData(@Path("type") String owner
            , @Query(ApiConstant.NUM) int sum
            , @Query(ApiConstant.RAND) int rand
            , @Query(ApiConstant.KEY) String key);


}
