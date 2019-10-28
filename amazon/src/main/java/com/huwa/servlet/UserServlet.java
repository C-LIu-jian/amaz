package com.huwa.servlet;

import com.alibaba.fastjson.JSON;
import com.huwa.entity.ShoppingCart;
import com.huwa.entity.User;
import com.huwa.service.UserService;
import com.huwa.serviceImpl.UserServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/user.do")
public class UserServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userService = new UserServiceImpl();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        String param = request.getParameter("param"); //查找
        String veryCode = request.getParameter("veryCode");
        HttpSession session = request.getSession();
        String Code = (String) session.getAttribute("code");  //在域对象中获取验证码
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        PrintWriter out = response.getWriter();
        //登陆
        if ("login".equals(param)) {
            // 在域对象中获取登陆信息
            Map<String, Object> map = new HashMap<>();
            //判断登陆条件
            if (Code != null && Code != "") {
                if (Code.equals(veryCode)) {
                    try {
                        User user = new User();
                        user.setUname(name);
                        user.setPwd(pwd);
                        User us = userService.userAll(user); //在数据库中查找
                        if (us == null) {
                            map.put("info", "登陆失败,用户名或密码错误");
                            map.put("login", false);
                        } else {
                            map.put("info", "");  //登陆成功
                            map.put("login", true);
                            session.setAttribute("user", us);
                            session.setAttribute("cart",new ShoppingCart()); //添加购物车
                        }
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                } else {
                    map.put("info", "验证码不正确");
                    map.put("login", false);
                }
            }
            String json = JSON.toJSONString(map);  //转换成json格式
            out.write(json);     //输出
            //注册
        } else if ("register".equals(param)) {
            Map<String, Object> map = new HashMap<>();
            if (Code != null && Code != "") {
                if (Code.equals(veryCode)) {
                    Integer sex = Integer.parseInt(request.getParameter("sex"));
                    String data = request.getParameter("birthday");
                    String identity = request.getParameter("identity");
                    String email = request.getParameter("email");
                    String mobile = request.getParameter("mobile");
                    String address = request.getParameter("address");
                    try {
                        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        Date birthday= dateFormat.parse(data);
                        User user = new User(name, pwd, sex, birthday, identity, email,mobile, address);
                        int i = userService.userAdd(user);
                        if (i == 1) {
                            map.put("info", "");
                            map.put("login", false);
                        } else {
                            map.put("info", "注册失败");
                            map.put("login", false);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } else {
                    map.put("info", "验证码不正确");
                    map.put("login", false);
                }

            }
            String json = JSON.toJSONString(map);
            out.write(json);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
