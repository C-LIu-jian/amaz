package com.huwa.daoImpl;

import com.huwa.dao.OrderDao;
import com.huwa.entity.Order;
import com.huwa.entity.OrderItem;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class OrderDaoImpl implements OrderDao {
    QueryRunner qr= new QueryRunner();
    @Override
    public int orderAll(Connection conn, Order order) throws Exception {
        String sql="insert into amz_order(u_id,site,create_time,status,money)  values (?,?,?,?,?)";
        return qr.update(conn,sql,order.getUser().getId(),order.getSite(),order.getCreate_time(),
                order.getStatus(),order.getMoney());

    }
    //提交订单明细
    @Override
    public int orderItemAll(Connection conn, OrderItem orderItem,Long id) throws Exception {
        String sql="insert into amz_orderitem (oid,pid,quantity,money)  values (?,?,?,?)";
      return   qr.update(conn,sql,id,orderItem.getProduct().getId(),
                orderItem.getQuantity(),orderItem.getMoney());
    }

    @Override
    public Long orderId(Connection conn) throws SQLException {
      String sql="select max(id) from amz_order";
        return  qr.query(conn,sql,new ScalarHandler<>());
    }
}
