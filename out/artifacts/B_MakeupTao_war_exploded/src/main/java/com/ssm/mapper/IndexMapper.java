package com.ssm.mapper;

import com.ssm.pojo.Active;
import com.ssm.pojo.Brands;
import com.ssm.pojo.Kinds;
import com.ssm.pojo.Pro_shop;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
public interface IndexMapper {
     List<Kinds> getAllKindMax();
     List<Kinds> getMinKind(String max_name);
     List<Pro_shop> getHostGoods();
     List<Brands> getBrands();
     List<Active> getIndexSlideshow();
}