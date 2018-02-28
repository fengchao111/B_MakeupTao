package com.ssm.service.imp;

import com.ssm.mapper.OrdersMapper;
import com.ssm.pojo.Orders;
import com.ssm.pojo.Pro_shop_order;
import com.ssm.pojo.Users;
import com.ssm.service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserOrderServiceImp implements UserOrderService {
    @Autowired
    private OrdersMapper ordersMapper;

//    @Override
//    public List<Pro_shop_order> queryAllOrder(Users users) {
//        List orders = ordersMapper.selectOrders(users);
//        return orders;
//    }

    @Override
    public List<Orders> querySomeOrder(Users users) {
        List<Orders> someOrder = ordersMapper.selectSomeOrder(users);
        return someOrder;
    }

    @Override
    public List queryOrderDetails(Orders orders) {
        List<Orders> orderDetails = ordersMapper.selectOrderDetails(orders);
        return orderDetails;
    }

    @Override
    public void cancleOrder(Orders orders) {
        ordersMapper.cancleOrder(orders);
    }

    @Override
    public void sureOrder(Orders orders) {
        ordersMapper.sureOrder(orders);
    }

    @Override
    public void deleteOrder(Orders orders) {
        ordersMapper.deleteOrder(orders);
    }

}
