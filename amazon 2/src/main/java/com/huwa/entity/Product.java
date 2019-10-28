package com.huwa.entity;

import lombok.Data;

@Data
public class Product {
    private  Long id;
    private  String name;
    private  String description; //描述
    private  double price;  //价格
    private  Long stock;    //库存
    private  Long major_id;
    private  Long  minor_id;
    private  String  img_source;  //路径
}
