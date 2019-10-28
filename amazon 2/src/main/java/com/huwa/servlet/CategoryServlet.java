package com.huwa.servlet;

import com.alibaba.fastjson.JSON;
import com.huwa.entity.Category;
import com.huwa.service.CategoryService;
import com.huwa.serviceImpl.CategoryServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/Category.do")
public class CategoryServlet extends HttpServlet {
    private CategoryService categoryService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        categoryService =new CategoryServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String param= request.getParameter("param");
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        if ("start".equals(param)){
            try {
             List<Category> categories= categoryService.rentalStart();
             if (categories !=null && categories.size()>0){
              String json=JSON.toJSONString(categories);
                 out.write(json);
             }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                     doPost(request,response);
    }
}
