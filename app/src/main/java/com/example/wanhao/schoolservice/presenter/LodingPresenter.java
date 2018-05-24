package com.example.wanhao.schoolservice.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.example.wanhao.schoolservice.bean.HttpResult;
import com.example.wanhao.schoolservice.config.ApiConfig;
import com.example.wanhao.schoolservice.config.ApiConstant;
import com.example.wanhao.schoolservice.service.LandingRegisterService;
import com.example.wanhao.schoolservice.util.JsonUtil;
import com.example.wanhao.schoolservice.util.RetrofitHelper;
import com.example.wanhao.schoolservice.util.SaveDataUtil;
import com.example.wanhao.schoolservice.view.ILodingView;
import com.google.gson.Gson;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Response;

/**
 * Created by wanhao on 2017/11/22.
 */

public class LodingPresenter implements ILoginPresenter{
    private static final String TAG = "LodingPresenter";

    private ILodingView iLoginView;
    private Context mContext;

    public LodingPresenter(ILodingView loginView, Context context) {
        this.iLoginView = loginView;
        this.mContext = context;
    }

    public void initData(){

        iLoginView.setData(SaveDataUtil.getValueFromSharedPreferences(mContext,ApiConstant.USER_NUMBER)
                ,SaveDataUtil.getValueFromSharedPreferences(mContext,ApiConstant.USER_PASSWORD));
    }

    @Override
    public void login(final String phoneNum, final String password) {
        if (TextUtils.isEmpty(phoneNum)){
            iLoginView.loadDataError("账号不能为空");
            return;
        }
        if (TextUtils.isEmpty(password)){
            iLoginView.loadDataError("密码不能为空");
            return;
        }

        //开始向服务器请求
        iLoginView.showProgress();
        LandingRegisterService service = RetrofitHelper.get(LandingRegisterService.class, ApiConfig.BASE_URL);

        service.loding(phoneNum,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Response<ResponseBody>>() {
                    @Override
                    public void accept(Response<ResponseBody> response) throws Exception {
                        String str = response.body().string();
                        Log.i(TAG, "accept: " + str);
                        HttpResult<String> msg = new Gson().fromJson(str,HttpResult.class);

                        if(!msg.getCode().equals("200102")){
                            iLoginView.loadDataError("error");
                            iLoginView.dismissProgress();
                        }
                        SaveDataUtil.saveToSharedPreferences(mContext,ApiConstant.USER_NUMBER, phoneNum);
                        SaveDataUtil.saveToSharedPreferences(mContext,ApiConstant.USER_PASSWORD, password);
                        //token 获取与保存
                        String token = msg.getData();
                        String oldToken = SaveDataUtil.getValueFromSharedPreferences(mContext, ApiConstant.USER_TOKEN);

                        if (TextUtils.isEmpty(oldToken)){
                            iLoginView.dismissProgress();
                            iLoginView.gotoChooseInterestedCategoryActivity("");
                        }else {
                            iLoginView.dismissProgress();
                            iLoginView.loadDataSuccess("");
                        }
                        SaveDataUtil.saveToSharedPreferences(mContext,ApiConstant.USER_TOKEN, token);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        iLoginView.dismissProgress();
                        iLoginView.loadDataError(throwable.toString());
                        Log.w(TAG, throwable);
                    }
                });
    }
}

interface ILoginPresenter{
    void login(String phoneNum, String password);
}