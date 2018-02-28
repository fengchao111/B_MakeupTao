package com.ssm.mapper;

import com.ssm.pojo.Orders;
import com.ssm.pojo.Pro_shop_order;
import com.ssm.pojo.Users;

import java.util.List;

public interface OrdersMapper {
//    List<Pro_shop_order> selectOrders(Users users);
    List<Orders> selectSomeOrder(Users users);
    List<Orders> selectOrderDetails(Orders orders);
    void cancleOrder(Orders orders);
    void sureOrder(Orders orders);
    void deleteOrder(Orders orders);
}
