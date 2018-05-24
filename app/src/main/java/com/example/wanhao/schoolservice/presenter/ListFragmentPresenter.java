package com.example.wanhao.schoolservice.presenter;

import android.content.Context;
import android.util.Log;

import com.example.wanhao.schoolservice.base.BasePresenterImp;
import com.example.wanhao.schoolservice.base.IBaseRequestCallBack;
import com.example.wanhao.schoolservice.base.IBaseView;
import com.example.wanhao.schoolservice.bean.Message;
import com.example.wanhao.schoolservice.config.ApiConstant;
import com.example.wanhao.schoolservice.model.ListFragmentModel;

import java.util.List;

/**
 * Created by wanhao on 2018/2/6.
 */

public class ListFragmentPresenter extends BasePresenterImp<IBaseView<List<Message>>,List<Message>> {
    private static final String TAG = "ListFragmentModel";

    Context context;
    IBaseView<List<Message>> iBaseView;
    ListFragmentModel model;

    /**
     * @param view 具体业务的视图接口对象
     * @descriptoin 构造方法
     * @author dc
     * @date 2017/2/16 15:12
     */
    public ListFragmentPresenter(IBaseView view, Context context) {
        super(view);
        this.context = context;
        this.iBaseView = view;
        model = new ListFragmentModel();
    }


    public void getList(){
        getListByInternet();
    }

    public void getListByInternet() {
        IBaseRequestCallBack<List<Message>> callBack = new IBaseRequestCallBack<List<Message>>() {
            @Override
            public void beforeRequest() {
                iBaseView.showProgress();
            }

            @Override
            public void requestError(Throwable throwable) {
                iBaseView.loadDataError(throwable.toString());
            }

            @Override
            public void requestComplete() {
                iBaseView.dismissProgress();
            }

            @Override
            public void requestSuccess(List<Message> data) {
                Log.i(TAG, "requestSuccess: ");
                iBaseView.loadDataSuccess(data);
            }


        };

        model.getListData(ApiConstant.TYPE_SOCIAL,callBack);
    }
}
