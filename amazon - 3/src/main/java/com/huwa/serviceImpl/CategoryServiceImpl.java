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
         List<Category> list= categoryDao.rentalStart();
        for (Category category : list) {
          List<Category> categoryS=categoryDao.rentalSecond(category.getParent_id());
            category.setCategories(categoryS);;
        }
        return list;
    }
  //子分类
    @Override
    public List<Category> rentalSecond(Long id) throws Exception {
        return categoryDao.rentalSecond(id);
    }
}
