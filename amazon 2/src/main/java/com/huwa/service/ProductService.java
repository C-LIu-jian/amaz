package com.huwa.service;

import com.huwa.entity.Product;

import java.util.List;

public interface ProductService {
    public Long productTotal() throws  Exception; //查询总记录
    public List<Product> productAll(Integer pageNo , Integer pageSize) throws  Exception;  //分页查询
    public Product productOne(Long id)throws  Exception; //查询所有
}
