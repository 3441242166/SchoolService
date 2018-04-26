package com.example.wanhao.schoolservice.bean;

/**
 * Created by wanhao on 2018/4/4.
 */

public class BBSItem {

    int imgID;
    String title;
    String content;

    public BBSItem(int imgID,String title,String content){
        this.imgID = imgID;
        this.title = title;
        this.content = content;
    }


    public int getImgID() {
        return imgID;
    }

    public void setImgID(int imgID) {
        this.imgID = imgID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
