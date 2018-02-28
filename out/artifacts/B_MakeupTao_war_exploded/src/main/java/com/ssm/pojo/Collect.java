package com.ssm.pojo;

import java.io.Serializable;

public class Collect implements Serializable {
    private int collect_id;
    private int user_id;
    private int pro_shop_id;
    private Users users;
    private Pro_shop pro_shop;

    @Override
    public String toString(){
        return "Collect{" + "collect_id=" + collect_id + ", user_id=" + user_id + ", pro_shop_id=" + pro_shop_id + ", users=" + users + ", pro_shop=" + pro_shop + '}';
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

    public int getCollect_id() {
        return collect_id;
    }

    public void setCollect_id(int collect_id) {
        this.collect_id = collect_id;
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
}
