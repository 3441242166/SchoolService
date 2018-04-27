package com.example.wanhao.schoolservice.bean;

import android.text.TextUtils;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.google.gson.annotations.SerializedName;

/**
 * Created by wanhao on 2018/1/20.
 */

public class Message implements MultiItemEntity {

    public static final int NORMAL = 0;
    public static final int IMAGE = 1;

    @SerializedName("title")
    String title;
    @SerializedName("ctime")
    String time;
    @SerializedName("user")
    String user;
    @SerializedName("picUrl")
    String imageUrl;
    @SerializedName("url")
    String contantUrl;

    int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getContantUrl() {
        return contantUrl;
    }

    public void setContantUrl(String contantUrl) {
        this.contantUrl = contantUrl;
    }

    @Override
    public int getItemType() {
        return TextUtils.isEmpty(imageUrl) ? NORMAL:IMAGE;
    }
}
