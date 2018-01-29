package com.example.wanhao.schoolservice.bean;

import android.graphics.drawable.Drawable;

/**
 * Created by wanhao on 2017/11/21.
 */

public class UserMessage {
    private String name;
    private Drawable head;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Drawable getHead() {
        return head;
    }

    public void setHead(Drawable head) {
        this.head = head;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
