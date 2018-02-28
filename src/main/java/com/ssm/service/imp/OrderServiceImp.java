package com.ssm.service.imp;

import com.ssm.mapper.Order_add;
import com.ssm.pojo.Orders;
import com.ssm.pojo.Pro_shop;
import com.ssm.pojo.Pro_shop_order;
import com.ssm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class OrderServiceImp implements OrderService {
    List<Pro_shop> list=null;
    Pro_shop_order pro_shop_order=new Pro_shop_order();
    private Pro_shop pro_shop=new Pro_shop();
    private Orders orders=new Orders();
    /**
     *
     */
    @Autowired
    private Order_add order_add;
    @Override
    public int order(List<Integer>idlist,List<Integer>numlist,int number,int user_id,Orders orders) {
        System.out.println(order_add);
        for(int i=0;i<number;i++){
            System.out.println(idlist);
            System.out.println(numlist);
            System.out.println(number);
            System.out.println(user_id);
            System.out.println(orders.toString());
            pro_shop.setPro_shop_id(idlist.get(i));
//            System.out.println(pro_shop.getPro_shop_id());
//            System.out.println(order_add.proshop_select(pro_shop.getPro_shop_id()));
            System.out.println(order_add.proshop_select(idlist.get(i)));
            pro_shop=order_add.proshop_select(idlist.get(i));
            String selectname = order_add.selectname(pro_shop.getProduct_id());
            System.out.println(pro_shop);
            pro_shop.toString();
            pro_shop_order.setPro_shop_id(pro_shop.getPro_shop_id());
            pro_shop_order.setPro_shop_order_price(pro_shop.getPro_shop_price());
            pro_shop_order.setPro_shop_order_oldprice(pro_shop.getPro_shop_oldprice());
            pro_shop_order.setPro_shop_order_name(selectname);
            pro_shop_order.setPro_shop_order_number(numlist.get(i));
            System.out.println(orders);
            order_add.insertorder(orders);
            System.out.println(orders.getOrder_id());
            pro_shop_order.setOrder_id(orders.getOrder_id());
            System.out.println(pro_shop_order);
            order_add.insertpro_shop_order(pro_shop_order);
            order_add.deletecarts(pro_shop.getPro_shop_id());
        }
        return orders.getOrder_id();
    }
}
