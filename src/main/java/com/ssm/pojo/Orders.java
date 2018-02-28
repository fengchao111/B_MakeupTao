package com.ssm.pojo;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class Orders implements Serializable {
    private int order_id;
    private int user_id;
    private int order_state;
    private Date order_time;
    private int address_id;
    private String order_message;
    private int order_money;
    private Users users;
    private Address address;
    private Pro_shop pro_shop;
    private Pro_shop_order pro_shop_order;

    private List<Pro_shop> pro_shops;



    public List<Pro_shop> getPro_shops() {
        return pro_shops;
    }

    public void setPro_shops(List<Pro_shop> pro_shops) {
        this.pro_shops = pro_shops;
    }


    @Override
    public String toString() {
        return "Orders{" + "order_id=" + order_id + ", user_id=" + user_id + ", order_state=" + order_state + ", order_time=" + order_time + ", address_id=" + address_id + ", order_message='" + order_message + '\'' + ", order_money=" + order_money + ", users=" + users + ", address=" + address + ", pro_shop=" + pro_shop + ", pro_shop_order=" + pro_shop_order + '}';
    }

    public Pro_shop_order getPro_shop_order() {
        return pro_shop_order;
    }

    public void setPro_shop_order(Pro_shop_order pro_shop_order) {
        this.pro_shop_order = pro_shop_order;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getOrder_state() {
        return order_state;
    }

    public Date getOrder_time() {
        return order_time;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Pro_shop getPro_shop() {
        return pro_shop;
    }

    public void setPro_shop(Pro_shop pro_shop) {
        this.pro_shop = pro_shop;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getUser_id(int user_id) {
        return this.user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getOrder_state(int i) {
        return order_state;
    }

    public void setOrder_state(int order_state) {
        this.order_state = order_state;
    }

    public Date getOrder_time(Date date) {
        return order_time;
    }

    public void setOrder_time(Date order_time) {
        this.order_time = order_time;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public String getOrder_message() {
        return order_message;
    }

    public void setOrder_message(String order_message) {
        this.order_message = order_message;
    }

    public int getOrder_money() {
        return order_money;
    }

    public void setOrder_money(int order_money) {
        this.order_money = order_money;
    }
}
