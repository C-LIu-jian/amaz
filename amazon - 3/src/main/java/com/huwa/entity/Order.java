package com.huwa.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 订单表
 */
@Data
public class Order {
    private  Long id;
    private  User user;
    private  String site; //地址
    private Date   create_time; //时间
    private Integer status; //状态
    private double money; //价格
    private List<OrderItem> orderItems; //订单项目表集合
}
