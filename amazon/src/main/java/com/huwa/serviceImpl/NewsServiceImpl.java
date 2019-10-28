package com.huwa.serviceImpl;

import com.huwa.dao.NewsDao;
import com.huwa.daoImpl.NewsDaoImpl;
import com.huwa.entity.News;
import com.huwa.service.NewsService;

import java.util.List;

public class NewsServiceImpl implements NewsService {
    private NewsDao newsDao;

    public NewsServiceImpl(){
        newsDao = new NewsDaoImpl();
    }
    //查询所有
    @Override
    public List<News> newsAll() throws Exception {
        return newsDao.newsAll();
    }
    //单个查询
    @Override
    public News newsQuery(Long id) throws Exception {
        return newsDao.newsQuery(id);
    }
}
