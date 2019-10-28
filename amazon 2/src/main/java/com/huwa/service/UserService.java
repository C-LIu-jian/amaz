package com.huwa.service;

import com.huwa.entity.User;

public interface UserService {
    public User userAll(User user) throws Exception; //登录   查询
    public int   userAdd(User user)throws  Exception; //注册  添加
}
