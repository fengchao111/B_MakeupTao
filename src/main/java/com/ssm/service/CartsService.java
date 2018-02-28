package com.ssm.service;

import com.ssm.pojo.Address;
import com.ssm.pojo.Carts;
import com.ssm.pojo.Users;

import java.util.List;

public interface CartsService {
    public void addCarts(Carts carts);
    public List<Carts> selectAll();
    public void updataNum(Carts carts);
    public void updateNum(Carts carts);
    public void deleteCarts(Carts carts);
    public List<Carts> selectOrders(int user_id);
    public List<Carts> selectCarts(Carts carts);
}
