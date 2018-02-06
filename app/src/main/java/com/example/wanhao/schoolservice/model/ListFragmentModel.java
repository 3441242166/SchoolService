package com.example.wanhao.schoolservice.model;

import android.text.TextUtils;
import android.util.Log;

import com.example.wanhao.schoolservice.base.IBaseRequestCallBack;
import com.example.wanhao.schoolservice.bean.Message;
import com.example.wanhao.schoolservice.bean.MessageResponse;
import com.example.wanhao.schoolservice.config.ApiConfig;
import com.example.wanhao.schoolservice.config.Constant;
import com.example.wanhao.schoolservice.service.DataService;
import com.example.wanhao.schoolservice.util.RetrofitHelper;
import com.google.gson.Gson;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Response;

/**
 * Created by wanhao on 2018/2/6.
 */

public class ListFragmentModel implements IListFragmentModel{
    private static final String TAG = "ListFragmentModel";


    @Override
    public void getListData(String type,final IBaseRequestCallBack<List<Message>> iBaseRequestCallBack) {
        Log.i(TAG, "getListData: ");
        iBaseRequestCallBack.beforeRequest();
        DataService service =  RetrofitHelper.get(DataService.class);
        service.getMessageData(type,10,1, ApiConfig.QUEST_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Response<ResponseBody>>() {
                    @Override
                    public void accept(Response<ResponseBody> response) throws Exception {
                        Log.i(TAG, "accept: ");
                        Gson gson = new Gson();
                        MessageResponse msg = gson.fromJson(response.body().string(),MessageResponse.class);
                        for(int x=0;x<msg.getAr().size();x++) {
                            Log.i(TAG, "accept: url"+msg.getAr().get(x).getTitle());
                        }
                        for(int x=0;x<msg.getAr().size();x++) {
                            if (TextUtils.isEmpty(msg.getAr().get(x).getImageUrl()))
                                msg.getAr().get(x).setType(Constant.AD_MESSAGE);
                            else
                                msg.getAr().get(x).setType(Constant.AD_MESSAGE_IMAGE);
                        }

                        if(msg.getCode().equals(Constant.REQUEST_SUCCESS)){
                            iBaseRequestCallBack.requestSuccess(msg.getAr());
                            iBaseRequestCallBack.requestComplete();
                        }else {
                            iBaseRequestCallBack.requestError(new Throwable("网络错误"));
                        }

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        iBaseRequestCallBack.requestError(throwable);
                        Log.w(TAG, throwable);
                    }
                });
    }
}

interface IListFragmentModel{
    void getListData(String type, IBaseRequestCallBack<List<Message>> iBaseRequestCallBack);
}
