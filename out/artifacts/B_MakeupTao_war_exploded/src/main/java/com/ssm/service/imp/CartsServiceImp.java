package com.ssm.service.imp;

import com.ssm.mapper.CartsMapper;
import com.ssm.pojo.Address;
import com.ssm.pojo.Carts;
import com.ssm.service.CartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class CartsServiceImp implements CartsService{
    @Autowired
    private CartsMapper cartsMapper;

    public void addCarts(Carts carts){
        cartsMapper.addCarts(carts);
        System.out.println("添加成功");
    }

    @Override
    public List<Carts> selectAll() {
       List<Carts> lixin=cartsMapper.selectAll();
       System.out.println(lixin);
        return lixin;
    }

    @Override
    public void updataNum(Carts carts) {
        cartsMapper.updataNum(carts);

    }
@Override
    public void updateNum(Carts carts) {
        cartsMapper.updateNum(carts);

    }

    @Override
    public List<Carts> selectCarts(Carts carts) {
        List<Carts> car=cartsMapper.selectCarts(carts);
        return car;
    }

@Override
    public void deleteCarts(Carts carts){
        cartsMapper.deleteCarts(carts);
    }


@Override
public List<Carts> selectOrders(int user_id) {
    List<Carts> carts= cartsMapper.selectOrders(user_id);
    return carts;
}
}
