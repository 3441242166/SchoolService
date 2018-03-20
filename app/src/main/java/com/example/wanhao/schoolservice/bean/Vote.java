package com.example.wanhao.schoolservice.bean;

/**
 * Created by wanhao on 2018/3/20.
 */

public class Vote {

    private String title;

    private int red;

    private int blue;

    private int participant;

    private String redString;

    private String blueString;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public int getParticipant() {
        return participant;
    }

    public void setParticipant(int participant) {
        this.participant = participant;
    }

    public String getRedString() {
        return redString;
    }

    public void setRedString(String redString) {
        this.redString = redString;
    }

    public String getBlueString() {
        return blueString;
    }

    public void setBlueString(String blueString) {
        this.blueString = blueString;
    }
}
