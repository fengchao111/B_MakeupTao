package com.ssm.service;

import com.ssm.pojo.Kinds;

import java.util.List;

public interface SmallClassService {
    public void newSmallClass(Kinds kinds);
    public void deleteSmallClass(String min);
    public  List<String> selectSmallClass(String max);
}
