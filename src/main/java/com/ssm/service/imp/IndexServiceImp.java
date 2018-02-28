package com.ssm.service.imp;

import com.ssm.mapper.IndexMapper;
import com.ssm.pojo.Active;
import com.ssm.pojo.Brands;
import com.ssm.pojo.Kinds;
import com.ssm.pojo.Pro_shop;
import com.ssm.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class IndexServiceImp implements IndexService{
    @Autowired
    private IndexMapper indexMapper;

    @Override
    public List<Kinds> getMaxMessage() {
        System.out.println(indexMapper);
        List<Kinds> allKindMax = indexMapper.getAllKindMax();
        System.out.println(allKindMax);
        return allKindMax;
    }

    @Override
    public List<Kinds> getKindMin(String max_name) {
        List<Kinds> minKind = indexMapper.getMinKind(max_name);
        return minKind;
    }

    @Override
    public List<Pro_shop> get_host_goods() {
        List<Pro_shop> hostGoods = indexMapper.getHostGoods();
        return hostGoods;
    }

    @Override
    public List<Brands> get_brands() {
        List<Brands> brands = indexMapper.getBrands();
        return brands;
    }

    @Override
    public List<Active> get_slideshow() {
        List<Active> indexSlideshow = indexMapper.getIndexSlideshow();
        return indexSlideshow;
    }
}
