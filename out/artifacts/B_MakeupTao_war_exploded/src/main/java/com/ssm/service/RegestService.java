package com.ssm.service;


import com.ssm.po.collectInfo;
import com.ssm.po.feetInfo;
import com.ssm.po.infomix;
import com.ssm.po.usermanager;
import com.ssm.pojo.Address;
import com.ssm.pojo.Userinfo;
import com.ssm.pojo.Users;

import java.util.ArrayList;
import java.util.List;

public interface RegestService {

    public boolean selectByName(String username);

    public void addUser(Users user);

    public boolean selectName(String username, String password);


    public infomix selectinfo(int user_id);

    public void insertInfo(Userinfo userinfo);

    public List<collectInfo> collect(int user_id);

    public ArrayList<Address> address(int user_id);

    public ArrayList<feetInfo> feet(int user_id);

    public void defaultAddress(Address address);

    public void updateTel(Users users);

    public Boolean updatePass(Users users, String oldPassword);

    public int selectuserid(String username);

    public usermanager selectManager(int user_id);

    public void insertAddress(Address address);
}
