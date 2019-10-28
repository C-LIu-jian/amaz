package com.huwa.dao;

import com.huwa.entity.News;

import java.util.List;

public interface NewsDao {
    public List<News> newsAll() throws  Exception;  //查找所有
    public  News  newsQuery(Long id) throws  Exception; //根据查找
}
