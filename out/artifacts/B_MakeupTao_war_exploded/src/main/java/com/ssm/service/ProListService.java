package com.ssm.service;

import com.ssm.pojo.Brands;
import com.ssm.pojo.Kinds;
import com.ssm.pojo.Pro_shop;
import com.ssm.pojo.Products;

import java.util.List;

public interface ProListService {
//    分页
    public List<Pro_shop> findPage(int start);
//品牌
    public List<Brands> findBrand();
    public List<Pro_shop> findProByBrand(String string);
// 种类
//public List<Kinds> findKindMax();
    public List<Kinds> findKindMin(String string);
    public List<Pro_shop> findProByKindMin(int kind_id);
//上市
public List<Pro_shop> findProMarket();
//价格
    public List<Pro_shop> sortByPrice();
    public List<Pro_shop> sortByPriced();
//销量
public List<Pro_shop> findProSale();

}
