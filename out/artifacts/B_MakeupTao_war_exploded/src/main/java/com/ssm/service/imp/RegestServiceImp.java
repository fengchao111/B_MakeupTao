package com.ssm.service.imp;

import com.ssm.mapper.Login;
import com.ssm.po.collectInfo;
import com.ssm.po.feetInfo;
import com.ssm.po.infomix;
import com.ssm.po.usermanager;
import com.ssm.pojo.Address;
import com.ssm.pojo.Userinfo;
import com.ssm.pojo.Users;
import com.ssm.service.RegestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegestServiceImp implements RegestService {
    //盐值
    private final String salt = "jsaldjasb@dsak*nasd45";
    @Autowired
    private Login login;

    @Override
    public boolean selectByName(String username) {
        if (login.selectByUsername(username) != null) {
            return false;
        }
        return true;
    }

    /**
     * 注册
     *
     * @param user
     */
    @Override
    @Transactional
    public void addUser(Users user) {
        //1.将密码加盐值并存储
        user.setUser_password(getMD5(user.getUser_password()));
        //2.添加用户
        login.addUser(user);
    }

    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public boolean selectName(String username, String password) {
        String user_pass = login.selectUsername(username);
        //获取md5值
        String pass = getMD5(password);
        System.out.println(pass);
        if (pass.equals(user_pass)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取md5值
     *
     * @param password
     * @return
     */
    private String getMD5(String password) {
        String base = password + "/" + salt;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }

    @Override
    public infomix selectinfo(int user_id) {
        //根据用户id返回用户个人资料信息
        return login.selectInfo(user_id);
    }

    @Override
    public void insertInfo(Userinfo userinfo) {
        //插入用户个人资料
        login.insertInfo(userinfo);
    }

    @Override
    public List<collectInfo> collect(int user_id) {
        //通过用户id返回收藏表
        List<collectInfo> list = login.collect(user_id);
        return list;
    }

    @Override
    public ArrayList<Address> address(int user_id) {
        //通过id查询所有地址，返回将默认地址放第一个
        ArrayList<Address> list = login.selectAddress(user_id);
        int length = list.size();
        for (int i = 0; i < length; i++) {
            //如果第一条数据就会默认地址，直接返回
            if (i == 0 && list.get(i).getAddress_state() == 1) {
                return list;
            }
            //找到那条默认地址，放到第一条
            if(list.get(i).getAddress_state() == 1){
                Address temp= list.get(i);
                list.set(i,list.get(0));
                list.set(0,temp);
            }
        }
        return list;
    }

    @Override
    public ArrayList<feetInfo> feet(int user_id) {
        ArrayList<feetInfo> list=login.selectFeet(user_id);
        return list;
    }

    //修改默认地址
    @Override
    public void defaultAddress(Address address) {
        //直接拿到默认地址
        address.setAddress_state(1);
        Address address3=login.selectDefaultAddress(address);
        //将原先的默认地址改为非默认
        Address address1 =new Address();
        address1.setAddress_id(address3.getAddress_id());
        address1.setUser_id(address.getUser_id());
        address1.setAddress_state(0);
        login.updateDefaultAddress(address1);
        //通过传入的新地址的id,将其设为默认
        Address address2 =new Address();
        address2.setAddress_id(address.getAddress_id());
        address2.setUser_id(address.getUser_id());
        address2.setAddress_state(1);
        login.updateDefaultAddress(address2);
    }

    @Override
    public void updateTel(Users users) {
        //更新电话
        login.updateTel(users);
    }

    @Override
    public Boolean updatePass(Users users,String newPassword) {
        //得到原始密码
        System.out.println("jinru "+users.getUser_id());
        String password = login.selectPass(users.getUser_id());
        //如果原始密码不对，返回false
        System.out.println("数据库的密码："+password);
        System.out.println("旧密码："+getMD5(users.getUser_password()));
        if (!(getMD5(users.getUser_password()) .equals(password))) {
            return false;
        } else {
            System.out.println("加密值："+getMD5(users.getUser_password()));
            //原始密码正确，设置新的密码
            users.setUser_password(getMD5(newPassword));
            login.updatePass(users);
            return true;
        }
    }

    @Override
    public int selectuserid(String username) {
        return login.selectuserid(username);
    }

//    public static void main(String [] args){
//        RegestServiceImp regestServiceImp = new RegestServiceImp();
//        String md5 = regestServiceImp.getMD5("123456");
//        System.out.print(md5);
//
//    }


    @Override
    public usermanager selectManager(int user_id) {
        return login.selectManager(user_id);
    }

    @Override
    public void insertAddress(Address address) {
        System.out.println(address.getUser_id());
        List<Address> list=login.selectAddress(address.getUser_id());
        System.out.println(list);
        if(list.isEmpty())
        {
            address.setAddress_state(1);
        }else
        {
            address.setAddress_state(0);
        }
        System.out.println(address.getAddress_state());
        login.insertAddress(address);
    }
}

