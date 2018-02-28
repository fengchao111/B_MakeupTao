package com.ssm.mapper;

import com.ssm.pojo.Kinds;

import java.util.List;

public interface SmallClassMapper {
    //添加小类
    public void newSmallClass(Kinds kinds);
    //删除小类
    public void deleteSmallClass(String min);
    //查看小类
    public List<String> selectSmallClass(String max);
}
