package com.huwa.dao;

import com.huwa.entity.User;

/**
 * 用户接口
 */
public interface UserDao {
    public User  userAll(User user) throws Exception; //查询
    public int   userAdd(User user)throws  Exception; //添加
}
