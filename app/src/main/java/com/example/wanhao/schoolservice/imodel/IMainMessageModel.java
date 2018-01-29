package com.example.wanhao.schoolservice.imodel;

import com.example.wanhao.schoolservice.bean.MessageNormal;

import java.util.List;

/**
 * Created by wanhao on 2017/11/26.
 */

public interface IMainMessageModel {

    List<MessageNormal> getFromInternet(String url);

    List<MessageNormal> getFromDocument(String path);

}
