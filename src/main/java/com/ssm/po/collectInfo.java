package com.ssm.po;

import com.ssm.pojo.Collect;

import java.sql.Date;

public class collectInfo extends Collect{
    private String pro_shop_desc;
    private String pro_shop_pic;
    private int pro_shop_price;
    private Date pro_shop_time;

    public String getPro_shop_desc() {
        return pro_shop_desc;
    }

    public void setPro_shop_desc(String pro_shop_desc) {
        this.pro_shop_desc = pro_shop_desc;
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

    public Date getPro_shop_time() {
        return pro_shop_time;
    }

    public void setPro_shop_time(Date pro_shop_time) {
        this.pro_shop_time = pro_shop_time;
    }
}
