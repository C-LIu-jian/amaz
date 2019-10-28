package com.huwa.entity;
/**
 * 订单项目表
 */

import lombok.Data;

@Data
public class OrderItem {
    private Long id;
    private Order order; //商品订单
    private Product product; //商品
    private  Long quantity; //数量
    private  double money;// 小计单价

}
