package com.huwa.service;

import com.huwa.entity.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> rentalStart() throws  Exception; //查找分类
    public List<Category> rentalSecond(Long id) throws  Exception; //查找二级分类
}
