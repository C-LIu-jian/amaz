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
    private  QueryRunner qr= new QueryRunner(C3P0Util.getDs());
    //查询总记录
    @Override
    public Long productTotal() throws Exception {
       String sql="select count(*) from amz_product";
        return  qr.query(sql,new ScalarHandler<>());
    }

    //分页查询
    @Override
    public List<Product> productAll(Integer start ,Integer pageSize) throws Exception {
       String sql="select * from amz_product limit ?,?";
        return qr.query(sql,new BeanListHandler<Product>(Product.class),start,pageSize);
    }

    //根据id查询
    @Override
    public Product productOne(Long id) throws Exception {
      String sql ="select * from amz_product where id=?";
      return  qr.query(sql,new BeanHandler<Product>(Product.class),id);
    }

    @Override
    public List<Product> productStock(Integer start, Integer Size) throws Exception {
          String sql="select * from amz_product order by stock desc limit ? ,?";
          return  qr.query(sql, new BeanListHandler<Product>(Product.class),start,Size);
    }
    //根据姓名模糊搜素
    @Override
    public List<Product> productSE(String name) throws Exception {
        String sql="select * from amz_product  where name like '%"+name+"%' ";
        return  qr.query(sql,new BeanListHandler<Product>(Product.class));
    }
    //二级分类查找
    @Override
    public List<Product> minorAll(Long minor) throws Exception {
        String sql ="select * from amz_product where minor_id=?";
      return    qr.query(sql,new BeanListHandler<Product>(Product.class),minor);
    }
    //一级分类查找
    @Override
    public List<Product> majorAll(Long major) throws Exception {
        String sql ="select * from amz_product where major_id=?";
        return  qr.query(sql,new BeanListHandler<Product>(Product.class),major);
    }
}
