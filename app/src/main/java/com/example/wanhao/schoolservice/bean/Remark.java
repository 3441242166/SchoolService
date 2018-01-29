package com.example.wanhao.schoolservice.bean;

/**
 * Created by wanhao on 2017/11/26.
 */

public class Remark {
    private UserMessage user;
    private String contant;
    private int good;

    public UserMessage getUser() {
        return user;
    }

    public void setUser(UserMessage user) {
        this.user = user;
    }

    public String getContant() {
        return contant;
    }

    public void setContant(String contant) {
        this.contant = contant;
    }

    public int getGood() {
        return good;
    }

    public void setGood(int good) {
        this.good = good;
    }
}
