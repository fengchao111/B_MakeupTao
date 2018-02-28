package com.ssm.mapper;

import com.ssm.pojo.Collect;
import com.ssm.pojo.Feet;
import com.ssm.pojo.Pro_shop;

import java.util.List;

public interface ProDetailMapper {
    List<Pro_shop> selectProDetail(int pro_shop_id);
    void addLook(int pro_shop_id);
    void insertFeet(Feet feet);
    void insertCollect(Collect collect);
}
