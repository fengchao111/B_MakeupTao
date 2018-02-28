package com.ssm.service.imp;

import com.ssm.mapper.ProDetailMapper;
import com.ssm.pojo.Collect;
import com.ssm.pojo.Feet;
import com.ssm.pojo.Pro_shop;
import com.ssm.pojo.Products;
import com.ssm.service.ProDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ProDetailServiceImp implements ProDetailService {
    @Autowired
    private ProDetailMapper proDetailMapper;

    @Override
    public List<Pro_shop> findProDetail(int pro_shop_id) {
        List<Pro_shop> list = proDetailMapper.selectProDetail(pro_shop_id);
        return list;
    }



    @Override
    public void addlook1(int pro_shop_id) {
        proDetailMapper.addLook(pro_shop_id);
    }

    @Override
    public void insertIntoFeet(Feet feet) {
        proDetailMapper.insertFeet(feet);
    }

    @Override
    public void insertIntoCollect(Collect collect) {
        proDetailMapper.insertCollect(collect);
    }
}
