package com.huwa.servlet;

import com.alibaba.fastjson.JSON;
import com.huwa.entity.*;
import com.huwa.service.OrderService;
import com.huwa.serviceImpl.OrderServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/order.do")
public class OrderServlet extends HttpServlet {
    private OrderService orderService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        orderService =new OrderServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String param = request.getParameter("param");
        Order order =new Order();
        //添加表单
        if ("orderAdd".equals(param)){
            HttpSession session =request.getSession();
           User user=(User)session.getAttribute("user"); //获取用户
           ShoppingCart cart =(ShoppingCart) session.getAttribute("cart"); //获取购物车

            order.setUser(user);  //赋值
            order.setSite(user.getAddress()); //地址
            order.setCreate_time(new Date());
            order.setStatus(1); //订单状态
            order.setMoney(cart.getTotal()); //总价
            //创建订单明细对象
            List<OrderItem> Items = new ArrayList<>();
            for (CartItem cartItem :cart.getCartItems()){
                 OrderItem  orderItem =new OrderItem();
                 orderItem.setQuantity((long) cartItem.getQuantity());
                 orderItem.setMoney(cartItem.getSubTotal());
                 orderItem.setProduct(cartItem.getProduct());
                 Items.add(orderItem);
            }
            order.setOrderItems(Items);
            try {
            boolean flag=orderService.orderAll(order);
                if (flag){
                request.getRequestDispatcher("/result.jsp").forward(request,response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }else if ("load".equals(param)){
            response.setContentType("application/json;charset=utf-8");
            String json = JSON.toJSONString(order);
            response.getWriter().write(json);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                  doPost(request,response);
    }
}
