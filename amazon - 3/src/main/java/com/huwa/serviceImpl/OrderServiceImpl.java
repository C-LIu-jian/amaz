package com.huwa.serviceImpl;

import com.huwa.dao.OrderDao;
import com.huwa.daoImpl.OrderDaoImpl;
import com.huwa.entity.Order;
import com.huwa.entity.OrderItem;
import com.huwa.service.OrderService;
import com.huwa.util.C3P0Util;
import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao;

    public OrderServiceImpl() {
        orderDao = new OrderDaoImpl();
    }

    //添加订单
    @Override
    public boolean orderAll(Order order) {
        Connection conn = C3P0Util.getConnection();
        try {
            conn.setAutoCommit(false);
            orderDao.orderAll(conn, order);
            Long id=orderDao.orderId(conn);
            List<OrderItem> orderItems = order.getOrderItems();
            for (OrderItem orderItem : orderItems) {
                orderDao.orderItemAll(conn, orderItem,id);
            }
            DbUtils.commitAndCloseQuietly(conn);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            //事务回滚
            DbUtils.rollbackAndCloseQuietly(conn);
        }

        return false;
    }
}