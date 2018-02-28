package com.ssm.pojo;

import java.io.Serializable;

public class Users implements Serializable{
    private int user_id;
    private String user_name;
    private String user_password;
    private int user_sex;
    private String user_card;
    private String user_tel;
    private String user_photo;
    private String user_email;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }


    public String getUser_card() {
        return user_card;
    }

    public void setUser_card(String user_card) {
        this.user_card = user_card;
    }

    public String getUser_tel() {
        return user_tel;
    }

    public void setUser_tel(String user_tel) {
        this.user_tel = user_tel;
    }

    public String getUser_photo() {
        return user_photo;
    }

    public void setUser_photo(String user_photo) {
        this.user_photo = user_photo;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    @Override
    public String toString() {
        return "Users{" + "user_id=" + user_id + ", user_name='" + user_name + '\'' + ", user_password='" + user_password + '\'' + ", user_sex=" + user_sex + ", user_card='" + user_card + '\'' + ", user_tel='" + user_tel + '\'' + ", user_photo='" + user_photo + '\'' + ", user_email='" + user_email + '\'' + '}';
    }

    public int getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(int user_sex) {
        this.user_sex = user_sex;
    }
}
