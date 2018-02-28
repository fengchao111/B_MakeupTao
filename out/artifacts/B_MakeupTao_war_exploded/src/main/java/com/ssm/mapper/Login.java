package com.ssm.mapper;

import com.ssm.po.collectInfo;
import com.ssm.po.feetInfo;
import com.ssm.po.infomix;
import com.ssm.po.usermanager;
import com.ssm.pojo.Address;
import com.ssm.pojo.Userinfo;
import com.ssm.pojo.Users;

import java.util.ArrayList;
import java.util.List;

/**
 * 登录相关实现
 */
public interface Login {
    /**
     * 根据用户名在数据库中查找，确保用户名不能重复
     * @param username
     * @return
     */
    public Users selectByUsername(String username);

    /**
     * 添加一条用户信息
     * @param users
     */
    public void addUser(Users users);


    /**
     * 登录时，通过传入的用户名来验证密码是否正确
     * @param user_name
     */
    public String selectUsername(String user_name);

    /**
     * 根据uer_id查询用户个人资料
     * @param user_id
     * @return
     */
    public infomix selectInfo(int user_id);

    /**
     * 插入个人资料
     * @param userinfo
     */
    public void insertInfo(Userinfo userinfo);

    /**
     * 根据用户id查询收藏信息
     * @param user_id
     * @return
     */
    public List<collectInfo> collect(int user_id);

    /**
     * 根据用户id查询地址信息
     * @param user_id
     * @return
     */
    public ArrayList<Address> selectAddress(int user_id);

    /**
     * 根据用户id查询足迹表
     * @param user_id
     * @return
     */
    public ArrayList<feetInfo> selectFeet(int user_id);

    /**
     * 该用户的默认地址
     * @param address
     */
    public void updateDefaultAddress(Address address);

    /**
     * 根据用户id和地址id检查是否是默认
     * @param address
     * @return
     */
    public Address selectDefaultAddress(Address address);

    /**
     * 根据用户id改手机号
     * @param users
     */
    public void updateTel(Users users);

    /**
     * 根据用户id改密码
     * @param users
     */
    public void updatePass(Users users);

    /**
     * 根据用户id查密码
     * @param user_id
     * @return
     */
    public String selectPass(int user_id);

    /**
     * 根据用户名查用户id
     * @param user_name
     * @return
     */
    public int selectuserid(String user_name);

    /**
     * 根据用户id查询相应的账户管理信息
     * @param user_id
     * @return
     */
    public usermanager selectManager(int user_id);

    /**
     * 插入一条地址信息
     * @param address
     */
    public void insertAddress(Address address);

}
