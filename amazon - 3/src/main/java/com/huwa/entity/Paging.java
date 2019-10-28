package com.huwa.entity;

import java.util.List;

public class Paging {
    private Long totalRecords; //总记录
    private Integer totalPages; //总页数
    private Integer pageSize; //当前页面显示记录
    private Integer pageNo;  //当前页码
    private Integer prePage; //上一页
    private Integer nextPage;//下一页
    private List<Product> products; //当前页面存储信息

    public Paging() {
    }

    public Paging(Long totalRecords, Integer pageSize, Integer pageNo, List<Product> products) {
        this.totalRecords = totalRecords;
        this.pageSize = pageSize;
        this.pageNo = pageNo;
        this.products = products;
    }

    public Long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Long totalRecords) {
        this.totalRecords = totalRecords;
    }
    //总页数
    public Integer getTotalPages() {
        totalPages = (int) (totalRecords / pageSize);
        if (totalRecords % pageSize != 0) {
            totalPages += 1;
        }
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }
    //每页记录
    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }
    //上一页
    public Integer getPrePage() {
        if (pageNo <= 1) {
            prePage = 1;
        } else {
            prePage = pageNo - 1;
        }
        return prePage;
    }

    public void setPrePage(Integer prePage) {
        this.prePage = prePage;
    }

    public Integer getNextPage() {
        if(pageNo>=getTotalPages()){
            nextPage=getTotalPages();
        }else{
            nextPage= pageNo+1;
        }
        return nextPage;
    }

    public void setNextPage(Integer nextPage) {
        this.nextPage = nextPage;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
