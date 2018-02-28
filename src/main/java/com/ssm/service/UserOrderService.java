package com.ssm.service;

import com.ssm.pojo.Orders;
import com.ssm.pojo.Users;

import java.util.List;

public interface UserOrderService {
//  List queryAllOrder(Users users);
  List querySomeOrder(Users users);
  List queryOrderDetails(Orders orders);
  void cancleOrder(Orders orders);
  void sureOrder(Orders orders);
  void deleteOrder(Orders orders);
}
