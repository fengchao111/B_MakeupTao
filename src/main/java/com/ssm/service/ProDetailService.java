package com.ssm.service;

import com.ssm.pojo.Collect;
import com.ssm.pojo.Feet;
import com.ssm.pojo.Pro_shop;
import com.ssm.pojo.Products;

import java.util.List;

public interface ProDetailService {
    public List<Pro_shop> findProDetail(int pro_shop_id);
    public void addlook1(int pro_shop_id);
    public void insertIntoFeet(Feet feet);
    public void insertIntoCollect(Collect collect);
}

