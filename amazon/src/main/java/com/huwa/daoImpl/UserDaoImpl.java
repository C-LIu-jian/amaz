package com.huwa.daoImpl;

import com.huwa.dao.UserDao;
import com.huwa.entity.User;
import com.huwa.util.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

/**
 * 用户
 */
public class UserDaoImpl implements UserDao {
    //查询
    @Override
    public User userAll(User user) throws Exception {
        String sql="select * from  amz_user where uname=? and pwd= ?";
        QueryRunner qr =new QueryRunner(C3P0Util.getDs());
        return  qr.query(sql,new BeanHandler<User>(User.class),user.getUname(),user.getPwd());
    }

    //注册
    @Override
    public int userAdd(User user) throws Exception {
        String sql="insert into amz_user values(0,?,?,?,?,?,?,?,?,0)";
        QueryRunner qr= new QueryRunner(C3P0Util.getDs());
         return   qr.update(sql,user.getUname(),user.getPwd(),user.getSex(),user.getBirthday(),
                 user.getIdcard(),user.getEmail(),user.getMobile(),user.getAddress());
    }
}
