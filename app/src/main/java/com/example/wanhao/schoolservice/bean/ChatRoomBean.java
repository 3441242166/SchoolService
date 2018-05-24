package com.example.wanhao.schoolservice.bean;

public class ChatRoomBean {


    String title;

    String time;

    String message;

    String imgUrl;

    public ChatRoomBean(String title,String time,String message,String imgUrl){
        this.title = title;
        this.time = time;
        this.imgUrl = imgUrl;
        this.message = message;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
