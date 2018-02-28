package com.ssm.pojo;

import java.io.Serializable;

public class Brands implements Serializable {
    private int brand_id;
    private String brand_name;
    private String brand_picture;

    @Override
    public String toString() {
        return "Brands{" + "brand_id=" + brand_id + ", brand_name='" + brand_name + '\'' + ", brand_picture='" + brand_picture + '\'' + '}';
    }

    public String getBrand_picture() {
        return brand_picture;
    }

    public void setBrand_picture(String brand_picture) {
        this.brand_picture = brand_picture;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }
}
