package com.example.wanhao.schoolservice.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.example.wanhao.schoolservice.view.ILodingView;

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
            iLoginView.validateError("账号不能为空",0);
            return;
        }
        if (TextUtils.isEmpty(password)){
            iLoginView.validateError("密码不能为空",1);
            return;
        }

    }
}

interface ILoginPresenter{
    void login(String phoneNum, String password);
}