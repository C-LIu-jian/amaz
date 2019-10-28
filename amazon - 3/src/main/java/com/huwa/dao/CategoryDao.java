package com.huwa.dao;

import com.huwa.entity.Category;

import java.util.List;

public interface CategoryDao {
    public List<Category> rentalStart() throws  Exception; //查找一级分类
   public List<Category> rentalSecond(Long id) throws  Exception; //查找二级分类

}
