package com.ssm.mapper;


import com.ssm.pojo.*;

import java.util.List;

/**
 * 对商品的增删改查方法
 */
public interface ProductMapper {
    //查询商品信息
    public List<Products> SelectAll();
    //   添加商品
    public void InsertPro(Products products);
    //查询商品的详细信息（多表查询）
    public List<Products> SelectPro();
    //添加商品与商家表的数据
    public void InsertShop(Pro_shop pro_shop);

    //返回商品总条数
    public int Total();
    //传入该页的首条数据，和该页面的总条数(多表查询)
    public List<Products> Page(Page page);
    //根据商品ID下架商品 正常状态：1  下架：2   删除：3
    public void DownShop(int product_id);
    //根据商品id删除商品（其实是让商品状态改变为3）
    public void DeleteShop(int product_id);
    //重新上架商品
    public void UpShop(int product_id);
    //修改价格
    public void updatePrice(Pro_shop pro_shop);


    //查询所有的品牌
    public List<Brands> selectBrands();
    //根据大类查询改大类下的所有小类
    public List<Kinds> selectKindMin(String kindMax);
    //根据小类名称查询的ID
    public List<Kinds> selectKindId(String kindMin);
}
