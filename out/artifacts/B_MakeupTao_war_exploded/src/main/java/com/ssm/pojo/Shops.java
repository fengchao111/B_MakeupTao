package com.ssm.pojo;

import java.io.Serializable;

public class Shops implements Serializable {
    private int shop_id;
    private String shop_name;
    private String shop_tel;
    private String shop_address;

    public int getShop_id() {
        return shop_id;
    }

    @Override
    public String toString() {
        return "Shops{" + "shop_id=" + shop_id + ", shop_name='" + shop_name + '\'' + ", shop_tel='" + shop_tel + '\'' + ", shop_address='" + shop_address + '\'' + '}';
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getShop_tel() {
        return shop_tel;
    }

    public void setShop_tel(String shop_tel) {
        this.shop_tel = shop_tel;
    }

    public String getShop_address() {
        return shop_address;
    }

    public void setShop_address(String shop_address) {
        this.shop_address = shop_address;
    }
}
