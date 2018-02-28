package com.ssm.pojo;

public class Active {
    private int active_id;
    private int pro_shop_id;
    private Pro_shop pro_shop;

    public int getActive_id() {
        return active_id;
    }

    public void setActive_id(int active_id) {
        this.active_id = active_id;
    }

    public int getPro_shop_id() {
        return pro_shop_id;
    }

    public void setPro_shop_id(int pro_shop_id) {
        this.pro_shop_id = pro_shop_id;
    }

    public Pro_shop getPro_shop() {
        return pro_shop;
    }

    public void setPro_shop(Pro_shop pro_shop) {
        this.pro_shop = pro_shop;
    }
}
