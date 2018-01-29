package com.example.wanhao.schoolservice.model;

import com.example.wanhao.schoolservice.bean.MessageNormal;
import com.example.wanhao.schoolservice.imodel.IMainMessageModel;

import java.util.List;

/**
 * Created by wanhao on 2017/11/26.
 */

public class MainMessageModel implements IMainMessageModel {


    @Override
    public List<MessageNormal> getFromInternet(String url) {
        return null;
    }

    @Override
    public List<MessageNormal> getFromDocument(String path) {
        return null;
    }
}


