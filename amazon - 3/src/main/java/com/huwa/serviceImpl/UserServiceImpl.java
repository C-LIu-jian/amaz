package com.huwa.serviceImpl;

import com.huwa.dao.UserDao;
import com.huwa.daoImpl.UserDaoImpl;
import com.huwa.entity.User;
import com.huwa.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl(){
        userDao =new UserDaoImpl();
    }

    //登录
    @Override
    public User userAll(User user) throws Exception {
        return userDao.userAll(user);
    }

    //注册
    @Override
    public int userAdd(User user) throws Exception {
        return  userDao.userAdd(user);
    }
}
