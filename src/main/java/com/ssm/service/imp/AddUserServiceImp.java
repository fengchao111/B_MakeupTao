package com.ssm.service.imp;

import com.ssm.mapper.AddUserMapper;
import com.ssm.pojo.Users;
import com.ssm.service.AddUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

@Service
@Transactional
public class AddUserServiceImp implements AddUserService {
    @Autowired
    private AddUserMapper addUserMapper;
    //盐值
    private final String salt = "jsaldjasb@dsak*nasd45";

    @Override
    public int insert_user(Users users){
        if(null!=users.getUser_name() && !("".equals(users.getUser_name()))){
            Users users1 = addUserMapper.existUser(users.getUser_name());
            System.out.println("user1:"+users1);
            if(null!=users1){
                System.out.println("000");
                return 0;
            }else {
                System.out.println("插入用户信息");
                users.setUser_password(getMD5(users.getUser_password()));
                addUserMapper.insertIntoUsers(users);
                System.out.println("用户id:"+users.getUser_id());
                addUserMapper.insertIntoUserinfo(users.getUser_id());
                return 1;
            }
        }else{
            return 0;
        }
    }

    @Override
    public int check_user(String user_name) {
        System.out.println("tcvfygbuh");
        Users users1 = addUserMapper.existUser(user_name);
        System.out.println("user1:"+users1);
        if(null!=users1){
            return 0;
        }else {
            return 1;
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
}
