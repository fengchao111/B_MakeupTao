package com.ssm.service.imp;

import com.ssm.mapper.ProductMapper;
import com.ssm.pojo.*;
import com.ssm.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ProductsServiceImp implements ProductsService{
    @Autowired
    private ProductMapper  productMapper;


    @Override
    public List<Products> SelectAll() {
       List<Products> list= productMapper.SelectAll();
        return list;
    }

    @Override
    public void InsertPro(Products products) {
//        System.out.println(products);
        productMapper.InsertPro(products);
    }

    @Override
    public List<Products> SelectPro() {
        List<Products> list=productMapper.SelectPro();
        return  list;
    }

    @Override
    public void InsertShop(Pro_shop pro_shop) {
        productMapper.InsertShop(pro_shop);
    }

    @Override
    public int Total() {
        int total=productMapper.Total();
        return total;
    }

    @Override
    public List<Products> Page(Page page) {
       List<Products> list= productMapper.Page(page);
       return list;
    }

    @Override
    public void DownShop(int product_id) {
        productMapper.DownShop(product_id);
    }

    @Override
    public void DeleteShop(int product_id) {
        productMapper.DeleteShop(product_id);
    }

    @Override
    public void UpShop(int product_id) {
        productMapper.UpShop(product_id);
    }

    @Override
    public void updatePrice(Pro_shop pro_shop) {
        productMapper.updatePrice(pro_shop);
    }

    @Override
    public List<Brands> selectBrands() {
       List<Brands> list= productMapper.selectBrands();
       return list;
    }

    @Override
    public List<Kinds> selectKindMin(String kindMax) {
       List<Kinds> list= productMapper.selectKindMin(kindMax);
       return list;
    }

    @Override
    public List<Kinds> selectKindId(String kindMin) {
       List<Kinds> list= productMapper.selectKindId(kindMin);
       return list;
    }

    public ProductMapper getProductMapper() {
        return productMapper;
    }

    public void setProductMapper(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }
}
