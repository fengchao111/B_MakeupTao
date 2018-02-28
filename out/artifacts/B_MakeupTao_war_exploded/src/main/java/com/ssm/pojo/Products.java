package com.ssm.pojo;

import java.io.Serializable;

public class Products implements Serializable {
        private int product_id;
        private String product_name;
        private int brand_id;
        private int kind_id;
        private Kinds kinds;
        private Pro_shop pro_shop;
        private Brands brands;

    @Override
    public String toString() {
        return "Products{" + "product_id=" + product_id + ", product_name='" + product_name + '\'' + ", brand_id=" + brand_id + ", kind_id=" + kind_id + ", kinds=" + kinds + ", pro_shop=" + pro_shop + '}';
    }

    public Pro_shop getPro_shop() {
        return pro_shop;
    }

    public void setPro_shop(Pro_shop pro_shop) {
        this.pro_shop = pro_shop;
    }

    public Brands getBrands() {
        return brands;
    }

    public void setBrands(Brands brands) {
        this.brands = brands;
    }

    public Kinds getKinds() {
        return kinds;
    }

    public void setKinds(Kinds kinds) {
        this.kinds = kinds;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public int getKind_id() {
        return kind_id;
    }

    public void setKind_id(int kind_id) {
        this.kind_id = kind_id;
    }
}
