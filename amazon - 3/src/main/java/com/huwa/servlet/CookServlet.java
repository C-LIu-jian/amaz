package com.huwa.servlet;

import com.alibaba.fastjson.JSON;
import com.huwa.entity.Product;
import com.huwa.serviceImpl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.CookieStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/Cook.do")
public class CookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //历史浏览记录
        //获取保存在cookie中的商品编号
    Cookie[] cookies= request.getCookies();
    boolean flag = false;//默认没有找到指定名字的cookie
    List<Product> list = new ArrayList<>();
       if (cookies !=null && cookies.length >0){
               for (Cookie cookie : cookies){
               if (cookie.getName().equals("hisTroyId")){
               flag=true;
               String value =cookie.getValue();
               String[] ids= value.split("-");
               for (String id : ids){
               Long Id=Long.parseLong(id);
                   try {
                       list.add(new ProductServiceImpl().productOne(Id));
                   } catch (Exception e) {
                       e.printStackTrace();
                   }
               }
               }
               }
               }
        response.getWriter().write(JSON.toJSONString(list));
}


    //拼接方法





    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                   doPost(request,response);
    }
}
