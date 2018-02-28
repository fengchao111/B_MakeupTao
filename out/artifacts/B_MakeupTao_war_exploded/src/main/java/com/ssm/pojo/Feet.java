package com.ssm.pojo;

import java.io.Serializable;
import java.sql.Date;

public class Feet implements Serializable {
    private int feet_id;
    private int user_id;
    private int pro_shop_id;
    private Date feet_time;
    private Users users;
    private Pro_shop pro_shop;

    @Override
    public String toString() {
        return "Feet{" + "feet_id=" + feet_id + ", user_id=" + user_id + ", pro_shop_id=" + pro_shop_id + ", feet_time=" + feet_time + ", users=" + users + ", pro_shop=" + pro_shop + '}';
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Pro_shop getPro_shop() {
        return pro_shop;
    }

    public void setPro_shop(Pro_shop pro_shop) {
        this.pro_shop = pro_shop;
    }

    public int getFeet_id() {
        return feet_id;
    }

    public void setFeet_id(int feet_id) {
        this.feet_id = feet_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getPro_shop_id() {
        return pro_shop_id;
    }

    public void setPro_shop_id(int pro_shop_id) {
        this.pro_shop_id = pro_shop_id;
    }

    public Date getFeet_time() {
        return feet_time;
    }

    public void setFeet_time(Date feet_time) {
        this.feet_time = feet_time;
    }
}
