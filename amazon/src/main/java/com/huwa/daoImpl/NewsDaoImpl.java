package com.huwa.daoImpl;

import com.huwa.dao.NewsDao;
import com.huwa.entity.News;
import com.huwa.util.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

/**
 * 新闻类
 */
public class NewsDaoImpl implements NewsDao {
    @Override
    public List<News> newsAll() throws Exception {
        String sql="select * from  amz_news";
        QueryRunner qr=new QueryRunner(C3P0Util.getDs());
        return qr.query(sql,new BeanListHandler<News>(News.class));
    }

    @Override
    public News newsQuery(Long id) throws Exception {
        String sql="select * from  amz_news where id=?";
        QueryRunner qr=new QueryRunner(C3P0Util.getDs());
        return qr.query(sql,new BeanHandler<News>(News.class),id);
    }
}
