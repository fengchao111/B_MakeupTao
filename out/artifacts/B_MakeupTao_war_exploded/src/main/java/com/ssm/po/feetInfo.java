package com.ssm.po;

import com.ssm.pojo.Feet;

public class feetInfo extends Feet {
    private String pro_shop_pic;
    private int pro_shop_price;

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
}
