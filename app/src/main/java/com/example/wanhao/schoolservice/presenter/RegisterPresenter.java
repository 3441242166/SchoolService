package com.example.wanhao.schoolservice.presenter;

import android.content.Context;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;

import com.example.wanhao.schoolservice.R;
import com.example.wanhao.schoolservice.bean.HttpResult;
import com.example.wanhao.schoolservice.config.ApiConfig;
import com.example.wanhao.schoolservice.config.ApiConstant;
import com.example.wanhao.schoolservice.service.LandingRegisterService;
import com.example.wanhao.schoolservice.util.RetrofitHelper;
import com.example.wanhao.schoolservice.view.IRegisterView;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Response;

/**
 * Created by wanhao on 2017/11/22.
 */

public class RegisterPresenter {
    private static final String TAG = "RegisterPresenter";

    private IRegisterView iRegisterView;
    private Context mContext;

    public RegisterPresenter(IRegisterView loginView, Context context) {
        this.iRegisterView = loginView;
        this.mContext = context;
    }
    //获取手机验证码
    public void getVerificationCode(final String phoneNum, final TextView getCodeTv, final CountDownTimer timer) {
        if (TextUtils.isEmpty(phoneNum)) {
            return;
        }
        getCodeTv.setClickable(false);
        timer.start();
    }

    //注册
    public void register(String phoneNum, String password, String code){
        if (TextUtils.isEmpty(phoneNum)){
            iRegisterView.loadDataError(mContext.getString(R.string.str_phone_num_cannot_empty));
            return;
        }
        if (TextUtils.isEmpty(password)){
            iRegisterView.loadDataError(mContext.getString(R.string.str_password_cannot_empty));
            return;
        }
        iRegisterView.showProgress();

        LandingRegisterService service = RetrofitHelper.get(LandingRegisterService.class, ApiConfig.BASE_URL);

        JSONObject jsonObject = new JSONObject();
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        try {
            jsonObject.put(ApiConstant.USER_NUMBER, phoneNum);
            jsonObject.put("userpwd", password);
            jsonObject.put(ApiConstant.USER_TARGET, "0");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.i(TAG, "register: " + jsonObject.toString());
        RequestBody body = RequestBody.create(JSON, jsonObject.toString());
        service.register(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Response<ResponseBody>>() {
                    @Override
                    public void accept(Response<ResponseBody> response) throws Exception {
                        String str = response.body().string();
                        Log.i(TAG, "accept: " + str);
                        HttpResult msg = new Gson().fromJson(str,HttpResult.class);

                        if (msg.getCode().equals("200101")){
                            iRegisterView.loadDataSuccess("注册成功");
                        }else{
                            iRegisterView.loadDataError("未知错误");
                        }
                        iRegisterView.dismissProgress();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.i(TAG, "accept: " + throwable.toString());
                        iRegisterView.loadDataError("网络异常");
                        iRegisterView.dismissProgress();
                    }
                });

    }
}
