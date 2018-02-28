package com.ssm.service;

import com.ssm.pojo.Orders;

import java.util.List;

public interface OrderService {
    public int order(List<Integer>idlist,List<Integer>numlist,int number,int user_id,Orders orders);
}
