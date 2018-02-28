package com.ssm.service.imp;

import com.ssm.mapper.ProListMapper;
import com.ssm.pojo.Brands;
import com.ssm.pojo.Kinds;
import com.ssm.pojo.Pro_shop;
import com.ssm.pojo.Products;
import com.ssm.service.ProListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProListServiceImp implements ProListService {
    @Autowired
    //品牌
    private ProListMapper proListMapper;


    @Override
    public List<Pro_shop> findPage(int start) {     //分页

        List<Pro_shop> list = proListMapper.selectPage(start);
        System.out.println(list);
        return list;
    }

    public List<Brands> findBrand() {

        List<Brands> list2 = proListMapper.selectBrand();

        return list2;
    }


    public List<Pro_shop> findProByBrand(String string) {
        System.out.println(string);
        List<Pro_shop> list3 = proListMapper.selectProByBrand(string);
        System.out.println(list3);
        return list3;
    }

//    种类
//public List<Kinds> findKindMax() {  //找出所有大类，存放在list集合中
//    List<Kinds> list=proListMapper.selectKindMax();//自动注入了，service可通过dao层接口调用dao层的方法
//    return list;//返回list集合中的所有大类
//}


    public List<Kinds> findKindMin(String string) { //通过大类名称查找对应的小类
        List<Kinds> list1=proListMapper.selectKindMin(string); //将查询结果存放在list1中
        return list1;
    }

    @Override
    public List<Pro_shop> findProByKindMin(int kind_id) { //根据小类id查找对应商品
       List<Pro_shop> list = proListMapper.selProByKindMin(kind_id);
        return list;
    }

    //排序
    @Override
    public List<Pro_shop> findProMarket() {
        List<Pro_shop> list = proListMapper.selectProMarket();
        return list;
    }
    @Override
    public List<Pro_shop> sortByPrice() {
        System.out.println("价格升---");
        List<Pro_shop> list=proListMapper.selectProPriceASC();
        System.out.println("价格ccc");
        return list;
    }

    @Override
    public List<Pro_shop> sortByPriced() {
        List<Pro_shop>   list1 = proListMapper.selectProPriceDESC();
        return list1;
    }

    @Override
    public List<Pro_shop> findProSale() {
        List<Pro_shop> list2 = proListMapper.selectProSale();
        return list2;
    }

}



