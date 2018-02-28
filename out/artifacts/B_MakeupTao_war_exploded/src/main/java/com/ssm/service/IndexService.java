package com.ssm.service;

import com.ssm.pojo.Active;
import com.ssm.pojo.Brands;
import com.ssm.pojo.Kinds;
import com.ssm.pojo.Pro_shop;

import java.util.List;
import java.util.Map;

public interface IndexService {
     List<Kinds> getMaxMessage();
     List<Kinds> getKindMin(String max_name);
     List<Pro_shop> get_host_goods();
     List<Brands> get_brands();
     List<Active> get_slideshow();
}
