package com.huwa.daoImpl;

import com.huwa.dao.ProductDao;
import com.huwa.entity.Paging;
import com.huwa.entity.Product;
import com.huwa.util.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.List;

/***
 * 商品类
 */
public class ProductDaoImpl implements ProductDao {
    //查询总记录
    @Override
    public Long productTotal() throws Exception {
       String sql="select count(*) from amz_product";
        QueryRunner qr =new QueryRunner(C3P0Util.getDs());
        return  qr.query(sql,new ScalarHandler<>());
    }

    //分页查询
    @Override
    public List<Product> productAll(Integer start ,Integer pageSize) throws Exception {
       String sql="select * from amz_product limit ?,?";
        QueryRunner qr = new QueryRunner(C3P0Util.getDs());
        return qr.query(sql,new BeanListHandler<Product>(Product.class),start,pageSize);
    }

    //根据id查询
    @Override
    public Product productOne(Long id) throws Exception {
      String sql ="select * from amz_product where id=?";
      QueryRunner qr =new QueryRunner(C3P0Util.getDs());
      return  qr.query(sql,new BeanHandler<Product>(Product.class),id);
    }
}
