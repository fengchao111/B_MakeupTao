package com.ssm.service;

import com.ssm.pojo.Users;

public interface AddUserService {
   int insert_user(Users users);
   int check_user(String user_name);
}
