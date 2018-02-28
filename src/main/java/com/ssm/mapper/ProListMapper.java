package com.ssm.mapper;

import com.ssm.pojo.Brands;
import com.ssm.pojo.Kinds;
import com.ssm.pojo.Pro_shop;
import com.ssm.pojo.Products;

import java.sql.Date;
import java.util.List;

public interface ProListMapper {

//分页查询
    List<Pro_shop>selectPage(int start);
    //品牌
    List<Brands> selectBrand();//查询所有品牌
    List<Pro_shop> selectProByBrand(String string); //根据品牌名查询该品牌下的所有商品
    //种类
//    List<Kinds> selectKindMax();
    List<Kinds> selectKindMin(String string);      //根据大类名字查找小类
    List<Pro_shop> selProByKindMin(int kind_id);   //根据小类id查找所有商品
    //上市
    List<Pro_shop> selectProMarket();
    //价格
    List<Pro_shop> selectProPriceASC();
    List<Pro_shop> selectProPriceDESC();
    //销量
    List<Pro_shop> selectProSale();

}
