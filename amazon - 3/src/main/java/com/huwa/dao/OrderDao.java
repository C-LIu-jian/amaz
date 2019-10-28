package com.huwa.dao;

import com.huwa.entity.Order;
import com.huwa.entity.OrderItem;
import com.huwa.util.C3P0Util;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 订单类
 */
public interface OrderDao {
  public int orderAll(Connection conn, Order order) throws  Exception;  //添加订单
  public  int orderItemAll(Connection conn, OrderItem orderItem,Long id) throws  Exception; //添加项目明细订单
  public  Long orderId(Connection conn) throws SQLException;//查询id;
}
