package com.example.wanhao.schoolservice.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.example.wanhao.schoolservice.bean.HttpResult;
import com.example.wanhao.schoolservice.config.ApiConstant;
import com.example.wanhao.schoolservice.config.Constant;
import com.example.wanhao.schoolservice.service.LodingRegisterService;
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

    @Override
    public void login(String phoneNum, String password) {
        Log.i(TAG, "login: "+phoneNum+password);
        if (TextUtils.isEmpty(phoneNum)){
            iLoginView.loadDataError("账号不能为空");
            return;
        }
        if (TextUtils.isEmpty(password)){
            iLoginView.loadDataError("密码不能为空");
            return;
        }
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put(ApiConstant.LODING_COUNT,phoneNum);
        hashMap.put(ApiConstant.LODING_PASSWORD,password);

        //开始向服务器请求
        iLoginView.showProgress();
        LodingRegisterService service = RetrofitHelper.get(LodingRegisterService.class);

        service.loding(JsonUtil.getJsonBody(hashMap))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Response<ResponseBody>>() {
                    @Override
                    public void accept(Response<ResponseBody> response) throws Exception {
                        Log.i(TAG, "accept: ");
                        Gson gson = new Gson();
                        HttpResult result = gson.fromJson(response.body().string(),HttpResult.class);
                        //token 获取与保存
                        String token = (String) result.getData();
                        String oldToken = SaveDataUtil.getValueFromSharedPreferences(mContext, Constant.SHAREDPREFERENCES_DEFAULT_NAME, ApiConstant.OAUTH_TOKEN);
                        if (TextUtils.isEmpty(oldToken)){
                            iLoginView.disimissProgress();
                            iLoginView.gotoChooseInterestedCategoryActivity("");
                        }else {
                            iLoginView.disimissProgress();
                            iLoginView.loadDataSuccess("");
                        }
                        SaveDataUtil.saveToSharedPreferences(mContext, Constant.SHAREDPREFERENCES_DEFAULT_NAME,ApiConstant.OAUTH_TOKEN, token);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        iLoginView.disimissProgress();
                        iLoginView.loadDataError(throwable.toString());
                        Log.w(TAG, throwable);
                    }
                });
    }
}

interface ILoginPresenter{
    void login(String phoneNum, String password);
}