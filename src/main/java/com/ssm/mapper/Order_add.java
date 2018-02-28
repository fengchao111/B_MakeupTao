package com.ssm.mapper;

import com.ssm.pojo.Orders;
import com.ssm.pojo.Pro_shop;
import com.ssm.pojo.Pro_shop_order;

public interface Order_add {
    Pro_shop proshop_select(int pro_shop_id);
    void insertorder(Orders orders);
    void insertpro_shop_order(Pro_shop_order pro_shop_order);
    void deletecarts(int pro_shop);
    String selectname(int product_id);
}
