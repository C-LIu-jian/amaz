package com.huwa.servlet;

import com.huwa.entity.Paging;
import com.huwa.entity.Product;
import com.huwa.service.ProductService;
import com.huwa.serviceImpl.ProductServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 加载首页信息
 */
@WebServlet("/index")
public class indexServlet extends HttpServlet {
    private ProductService productService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        productService =new ProductServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            Long totalRecords = productService.productTotal(); //总记录
            //  pageNo 当前页码    pageSize页面存储数量
            List<Product> products = productService.productAll(1, 12); //当前页面存储信息
            Paging paging = new Paging(totalRecords, 12, 1, products);
            request.setAttribute("paging", paging);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                 doPost(request,response);
    }
}
