package com.ssm.pojo;


import java.io.Serializable;
import java.sql.Date;

public class Userinfo implements Serializable {
    private int userinfo_id;
    private int user_id;
    private String userinfo_nickname;
    private Date userinfo_bir;
    private String userinfo_sign;
    private Users users;

    @Override
    public String toString() {
        return "Userinfo{" + "userinfo_id=" + userinfo_id + ", user_id=" + user_id + ", userinfo_nickname='" + userinfo_nickname + '\'' + ", userinfo_bir=" + userinfo_bir + ", userinfo_sign='" + userinfo_sign + '\'' + ", users=" + users + '}';
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public int getUserinfo_id() {
        return userinfo_id;
    }

    public void setUserinfo_id(int userinfo_id) {
        this.userinfo_id = userinfo_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUserinfo_nickname() {
        return userinfo_nickname;
    }

    public void setUserinfo_nickname(String userinfo_nickname) {
        this.userinfo_nickname = userinfo_nickname;
    }

    public Date getUserinfo_bir() {
        return userinfo_bir;
    }

    public void setUserinfo_bir(Date userinfo_bir) {
        this.userinfo_bir = userinfo_bir;
    }

    public String getUserinfo_sign() {
        return userinfo_sign;
    }

    public void setUserinfo_sign(String userinfo_sign) {
        this.userinfo_sign = userinfo_sign;
    }
}
