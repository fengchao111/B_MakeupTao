package com.ssm.pojo;

import java.io.Serializable;

public class Pro_shop_order implements Serializable {
    private int pro_shop_order_id;
    private int pro_shop_id;
    private int order_id;
    private int pro_shop_order_price;
    private int pro_shop_order_oldprice;
    private int pro_shop_order_number;
    private Pro_shop pro_shop;
    private Orders orders;

    @Override
    public String toString() {
        return "Pro_shop_order{" + "pro_shop_order_id=" + pro_shop_order_id + ", pro_shop_id=" + pro_shop_id + ", order_id=" + order_id + ", pro_shop_order_price=" + pro_shop_order_price + ", pro_shop_order_oldprice=" + pro_shop_order_oldprice + ", pro_shop_order_number=" + pro_shop_order_number + ", pro_shop=" + pro_shop + ", orders=" + orders + ", pro_shop_order_name='" + pro_shop_order_name + '\'' + '}';
    }

    public Pro_shop getPro_shop() {
        return pro_shop;
    }

    public void setPro_shop(Pro_shop pro_shop) {
        this.pro_shop = pro_shop;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public int getPro_shop_order_number() {
        return pro_shop_order_number;
    }

    public void setPro_shop_order_number(int pro_shop_order_number) {
        this.pro_shop_order_number = pro_shop_order_number;
    }

    public int getPro_shop_order_id() {
        return pro_shop_order_id;
    }

    public void setPro_shop_order_id(int pro_shop_order_id) {
        this.pro_shop_order_id = pro_shop_order_id;
    }

    public int getPro_shop_id() {
        return pro_shop_id;
    }

    public void setPro_shop_id(int pro_shop_id) {
        this.pro_shop_id = pro_shop_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getPro_shop_order_price() {
        return pro_shop_order_price;
    }

    public void setPro_shop_order_price(int pro_shop_order_price) {
        this.pro_shop_order_price = pro_shop_order_price;
    }

    public int getPro_shop_order_oldprice() {
        return pro_shop_order_oldprice;
    }

    public void setPro_shop_order_oldprice(int pro_shop_order_oldprice) {
        this.pro_shop_order_oldprice = pro_shop_order_oldprice;
    }

    public String getPro_shop_order_name() {
        return pro_shop_order_name;
    }

    public void setPro_shop_order_name(String pro_shop_order_name) {
        this.pro_shop_order_name = pro_shop_order_name;
    }

    private String pro_shop_order_name;
}