package com.huwa.dao;

import com.huwa.entity.Paging;
import com.huwa.entity.Product;

import java.util.List;

public interface ProductDao {
    public Long productTotal() throws  Exception; //查询总记录
    public List<Product> productAll(Integer start ,Integer pageSize) throws  Exception;  //分页查询
    public Product productOne(Long id)throws  Exception; //查询所有
    public List<Product> productStock(Integer start,Integer Size) throws Exception;//查找库存最多
    public List<Product> productSE(String name) throws Exception;//根据姓名模糊搜索
}
