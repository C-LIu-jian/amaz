package com.huwa.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

@WebServlet("/Cook.do")
public class CookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
              String id=request.getParameter("Id");
             Cookie[] cookies =request.getCookies();
             String hisTroyId=null;
             boolean flag=false; //默认没有找到指定名字的cook;
          if (cookies == null ||flag == false){  //第一次访问
              hisTroyId = id;
          }

        //非第一次访问
        if (cookies !=null && cookies.length>0){
            for (Cookie cookie: cookies) {
                if (cookie.getName().equals("hisTroyId"));
                hisTroyId =cookie.getValue(); //1-2-3
                  flag=true;
                  break;
            }
        }
        LinkedList<String> list = new LinkedList<String>(Arrays.asList(hisTroyId.split("-")));
       //假如长度不满4冲突,先删除冲突的id,再把id添加到头部,不冲突,直接添加到头部
        if (list.size()<4){
            if (list.contains(id)){
                list.remove(id); //先删除
            }
        }
        if (list.size()==4){
            if (list.contains(id)==false){  //没有冲突id
                list.removeLast();      //删除最后一个
            }else {
                list.remove(id);  //反之删除冲突id
            }
        }
        list.addFirst(id); //添加到头部
       //动态拼接
       StringBuilder sb = new StringBuilder();
        for (int i = 0; i <list.size() ; i++) {
            if (i>0){
                sb.append(list.get(i));
            }
        }
         hisTroyId =sb.toString();
        Cookie cookie = new Cookie("hisToryId",hisTroyId);
        cookie.setMaxAge(60*60*24*10);
        response.addCookie(cookie);
        response.setHeader("refresh","2;url="+request.getContextPath() + "/browsing.jsp");





    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                   doPost(request,response);
    }
}
