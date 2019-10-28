package com.huwa.daoImpl;

import com.huwa.dao.CategoryDao;
import com.huwa.entity.Category;
import com.huwa.util.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    @Override
    public List<Category> rentalStart() throws Exception {
        String sql="select * from  amz_product_category   where id=parent_id";
        QueryRunner qr =new QueryRunner(C3P0Util.getDs());
        return  qr.query(sql,new BeanListHandler<Category>(Category.class));
    }

    @Override
    public List<Category> rentalSecond(Long id) throws Exception {
        String sql="select * from  amz_product_category  where id !=parent_id and parent_id=?";
        QueryRunner qr =new QueryRunner(C3P0Util.getDs());
        return  qr.query(sql,new BeanListHandler<Category>(Category.class),id);
    }
}
