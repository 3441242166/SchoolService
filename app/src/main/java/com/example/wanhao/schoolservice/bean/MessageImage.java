package com.example.wanhao.schoolservice.bean;

import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanhao on 2018/1/13.
 */

public class MessageImage {
    private String title;   //文章标题

    private List<String> contant;     //文章内容    如果为url 则显示图片

    private int good;       //点赞数

    private UserMessage sendUser;   //发起人

    private Drawable image;

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getContant() {
        return contant;
    }

    public void setContant(List<String> contant) {
        this.contant = contant;
    }

    public void setContant(String contant) {
        this.contant = new ArrayList<>();
        this.contant.add(contant);
    }

    public int getGood() {
        return good;
    }

    public void setGood(int good) {
        this.good = good;
    }

    public UserMessage getSendUser() {
        return sendUser;
    }

    public void setSendUser(UserMessage sendUser) {
        this.sendUser = sendUser;
    }

}
