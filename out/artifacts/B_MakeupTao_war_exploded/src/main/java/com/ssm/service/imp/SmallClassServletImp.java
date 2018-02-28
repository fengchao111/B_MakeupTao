package com.ssm.service.imp;

import com.ssm.mapper.SmallClassMapper;
import com.ssm.pojo.Kinds;
import com.ssm.service.SmallClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class SmallClassServletImp implements SmallClassService {
    @Autowired
    private SmallClassMapper  smallClassMapper;

    public SmallClassMapper getKindsMapper() {
        return smallClassMapper;
    }

    public void setKindsMapper(SmallClassMapper smallClassMapper) {
        this.smallClassMapper = smallClassMapper;
    }
    @Override
    public void newSmallClass(Kinds  kinds) {
        System.out.println(kinds);
        smallClassMapper.newSmallClass(kinds);
    }

    @Override
    public void deleteSmallClass(String min) {
        smallClassMapper.deleteSmallClass(min);
    }

    @Override
    public List<String> selectSmallClass(String max) {
        List<String> list= smallClassMapper.selectSmallClass(max);
        return list;
    }
}
