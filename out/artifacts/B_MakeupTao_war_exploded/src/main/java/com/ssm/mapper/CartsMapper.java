package com.ssm.mapper;

import com.ssm.pojo.*;


import java.util.List;

public interface CartsMapper {
    //增加商品
    public void addCarts(Carts carts);
    //查询所有商品
    public List<Carts> selectAll();
    //增加相同商品时修改数量
    public void updataNum(Carts carts);
    //修改商品数量
    public void updateNum(Carts carts);
    //删除购物车商品信息
    public void deleteCarts(Carts carts);
    //显示购物车商品传递给前端
    public List<Carts> selectCarts(Carts carts);
    //显示订单信息传递给前端
    public List<Carts> selectOrders(int user_id);
}
