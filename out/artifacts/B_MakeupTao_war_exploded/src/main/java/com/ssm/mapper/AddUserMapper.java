package com.ssm.mapper;

import com.ssm.pojo.Users;

public interface AddUserMapper {
    Users existUser(String name);
    void insertIntoUsers(Users users);
    void insertIntoUserinfo(int user_id);
}