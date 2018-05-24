package com.example.wanhao.schoolservice.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by wanhao on 2017/5/13.
 */

public class HttpResult<T> {
    @SerializedName("code")
    String code;
    @SerializedName("msg")
    String msg;
    @SerializedName("data")
    private T data;

    public String getCode() {
        return code;
    }

    public HttpResult<T> setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public HttpResult<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public HttpResult<T> setData(T data) {
        this.data = data;
        return this;
    }
}
