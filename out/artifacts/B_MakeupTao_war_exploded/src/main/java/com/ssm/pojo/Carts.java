package com.ssm.pojo;

import java.io.Serializable;

public class Carts implements Serializable {
    private int cart_id;
    private int user_id;
    private int cart_num;
    private int pro_shop_id;
    private Users users;
    private Pro_shop pro_shop;
    private Shops shops;
    private Address address;

    @Override
    public String toString() {
        return "Carts{" +
                "cart_id=" + cart_id +
                ", user_id=" + user_id +
                ", cart_num=" + cart_num +
                ", pro_shop_id=" + pro_shop_id +
                ", users=" + users +
                ", pro_shop=" + pro_shop +
                ", shops=" + shops +
                ", address=" + address +
                '}';
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Shops getShops() {
        return shops;
    }

    public void setShops(Shops shops) {
        this.shops = shops;
    }

    public int getCart_num() {
        return cart_num;
    }

    public void setCart_num(int cart_num) {
        this.cart_num = cart_num;
    }

    public int getPro_shop_id() {
        return pro_shop_id;
    }

    public void setPro_shop_id(int pro_shop_id) {
        this.pro_shop_id = pro_shop_id;
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

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
