package com.example.wanhao.schoolservice.presenter;

import com.example.wanhao.schoolservice.imodel.IMainMessageModel;
import com.example.wanhao.schoolservice.model.MainMessageModel;
import com.example.wanhao.schoolservice.view.IMainMessageView;

/**
 * Created by wanhao on 2017/11/26.
 */

public class MainMessagePresenter implements IMainMessagePresenter{
    private IMainMessageModel iMainMessageModel;
    private IMainMessageView iMainMessageView;

    public MainMessagePresenter(IMainMessageView iMainMessageView){
        this.iMainMessageView =iMainMessageView;
        iMainMessageModel = new MainMessageModel();
    }

    @Override
    public void getData() {

    }
}

interface IMainMessagePresenter{
    void getData();
}
