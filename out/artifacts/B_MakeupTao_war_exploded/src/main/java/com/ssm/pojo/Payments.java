package com.ssm.pojo;

import java.io.Serializable;
import java.sql.Date;

public class Payments implements Serializable {
    private int payment_id;
    private int payment_money;
    private Date peyment_time;
    private int pro_shop_order_id;
    private int user_id;
    private Users users;
    private Pro_shop_order pro_shop_order;
    @Override
    public String toString() {
        return "Payments{" + "payment_id=" + payment_id + ", payment_money=" + payment_money + ", peyment_time=" + peyment_time + ", pro_shop_order_id=" + pro_shop_order_id + ", user_id=" + user_id + ", users=" + users + ", pro_shop_order=" + pro_shop_order + '}';
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Pro_shop_order getPro_shop_order() {
        return pro_shop_order;
    }

    public void setPro_shop_order(Pro_shop_order pro_shop_order) {
        this.pro_shop_order = pro_shop_order;
    }

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public int getPayment_money() {
        return payment_money;
    }

    public void setPayment_money(int payment_money) {
        this.payment_money = payment_money;
    }

    public Date getPeyment_time() {
        return peyment_time;
    }

    public void setPeyment_time(Date peyment_time) {
        this.peyment_time = peyment_time;
    }

    public int getPro_shop_order_id() {
        return pro_shop_order_id;
    }

    public void setPro_shop_order_id(int pro_shop_order_id) {
        this.pro_shop_order_id = pro_shop_order_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}