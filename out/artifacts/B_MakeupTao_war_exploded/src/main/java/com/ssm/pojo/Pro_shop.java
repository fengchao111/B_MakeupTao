package com.ssm.pojo;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class Pro_shop implements Serializable {
    private int pro_shop_id;

    private String pro_shop_name;

    private int product_id;
    private int shop_id;
    private String pro_shop_pic;
    private int pro_shop_price;
    private int pro_shop_oldprice;
    private int pro_shop_num;
    private int pro_shop_state;
    private String pro_shop_spec;
    private String pro_shop_desc;
    private int pro_shop_sale;
    private Date pro_shop_time;
    private Pro_shop_order pro_shop_orders;

    public Pro_shop_order getPro_shop_orders() {
        return pro_shop_orders;
    }

    public void setPro_shop_orders(Pro_shop_order pro_shop_orders) {
        this.pro_shop_orders = pro_shop_orders;
    }

    @Override
    public String toString() {
        return "Pro_shop{" + "pro_shop_id=" + pro_shop_id + ", pro_shop_name='" + pro_shop_name + '\'' + ", product_id=" + product_id + ", shop_id=" + shop_id + ", pro_shop_pic='" + pro_shop_pic + '\'' + ", pro_shop_price=" + pro_shop_price + ", pro_shop_oldprice=" + pro_shop_oldprice + ", pro_shop_num=" + pro_shop_num + ", pro_shop_state=" + pro_shop_state + ", pro_shop_spec='" + pro_shop_spec + '\'' + ", pro_shop_desc='" + pro_shop_desc + '\'' + ", pro_shop_sale=" + pro_shop_sale + ", pro_shop_time=" + pro_shop_time + ", shops=" + shops + ", products=" + products + ", pro_shop_look=" + pro_shop_look + ", pro_shop_kind='" + pro_shop_kind + '\'' + ", pro_shop_brand='" + pro_shop_brand + '\'' + '}';
    }


    private Shops shops;
    private Products products;

    public Shops getShops() {
        return shops;
    }

    public void setShops(Shops shops) {
        this.shops = shops;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public String getPro_shop_name() {
        return pro_shop_name;
    }

    public void setPro_shop_name(String pro_shop_name) {
        this.pro_shop_name = pro_shop_name;
    }


    private int pro_shop_look;
    private String pro_shop_kind;
    private String pro_shop_brand;

    public int getPro_shop_id() {
        return pro_shop_id;
    }

    public void setPro_shop_id(int pro_shop_id) {
        this.pro_shop_id = pro_shop_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    public String getPro_shop_pic() {
        return pro_shop_pic;
    }

    public void setPro_shop_pic(String pro_shop_pic) {
        this.pro_shop_pic = pro_shop_pic;
    }

    public int getPro_shop_price() {
        return pro_shop_price;
    }

    public void setPro_shop_price(int pro_shop_price) {
        this.pro_shop_price = pro_shop_price;
    }

    public int getPro_shop_oldprice() {
        return pro_shop_oldprice;
    }

    public void setPro_shop_oldprice(int pro_shop_oldprice) {
        this.pro_shop_oldprice = pro_shop_oldprice;
    }

    public int getPro_shop_num() {
        return pro_shop_num;
    }

    public void setPro_shop_num(int pro_shop_num) {
        this.pro_shop_num = pro_shop_num;
    }

    public int getPro_shop_state() {
        return pro_shop_state;
    }

    public void setPro_shop_state(int pro_shop_state) {
        this.pro_shop_state = pro_shop_state;
    }

    public String getPro_shop_spec() {
        return pro_shop_spec;
    }

    public void setPro_shop_spec(String pro_shop_spec) {
        this.pro_shop_spec = pro_shop_spec;
    }

    public String getPro_shop_desc() {
        return pro_shop_desc;
    }

    public void setPro_shop_desc(String pro_shop_desc) {
        this.pro_shop_desc = pro_shop_desc;
    }

    public int getPro_shop_sale() {
        return pro_shop_sale;
    }

    public void setPro_shop_sale(int pro_shop_sale) {
        this.pro_shop_sale = pro_shop_sale;
    }

    public Date getPro_shop_time() {
        return pro_shop_time;
    }

    public void setPro_shop_time(Date pro_shop_time) {
        this.pro_shop_time = pro_shop_time;
    }

    public int getPro_shop_look() {
        return pro_shop_look;
    }

    public void setPro_shop_look(int pro_shop_look) {
        this.pro_shop_look = pro_shop_look;
    }

    public String getPro_shop_kind() {
        return pro_shop_kind;
    }

    public void setPro_shop_kind(String pro_shop_kind) {
        this.pro_shop_kind = pro_shop_kind;
    }

    public String getPro_shop_brand() {
        return pro_shop_brand;
    }

    public void setPro_shop_brand(String pro_shop_brand) {
        this.pro_shop_brand = pro_shop_brand;
    }
}