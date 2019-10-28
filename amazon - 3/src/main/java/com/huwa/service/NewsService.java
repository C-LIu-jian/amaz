package com.huwa.service;

import com.huwa.entity.News;

import java.util.List;

public interface NewsService {
    public List<News> newsAll() throws  Exception;  //查找所有
    public News newsQuery(Long id) throws  Exception; //根据查找
}
