package com.huwa.serviceImpl;

import com.huwa.dao.CategoryDao;
import com.huwa.daoImpl.CategoryDaoImpl;
import com.huwa.entity.Category;
import com.huwa.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private CategoryDao categoryDao;

    public  CategoryServiceImpl(){
        categoryDao =new CategoryDaoImpl();
    }
    @Override
    public List<Category> rentalStart() throws Exception {
        return categoryDao.rentalStart();
    }

    @Override
    public List<Category> rentalSecond(Long id) throws Exception {
        return categoryDao.rentalSecond(id);
    }
}
