package com.huwa.servlet;

import com.alibaba.fastjson.JSON;
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

@WebServlet("/Product.do")
public class ProductServlet extends HttpServlet {
    private ProductService productService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        productService =new ProductServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String param= request.getParameter("param");
        //加载页面
      if ("load".equals(param)){
          try {
              Integer pageNo= Integer.parseInt(request.getParameter("pageNo")); //当前页码
              Long  totalRecords =  productService.productTotal(); //总记录
              Integer pageSize=12;
              List<Product> products = productService.productAll(pageNo, pageSize); //当前页面存储信息
              Paging paging = new Paging(totalRecords,pageSize,pageNo,products);
              request.setAttribute("paging",paging);
              request.getRequestDispatcher("/index.jsp").forward(request,response);
          } catch (Exception e) {
              e.printStackTrace();
          }
          //根据id查找
      }else if ("productAllId".equals(param)){
        Long id=Long.parseLong(request.getParameter("id"));
          try {
              Product product = productService.productOne(id);
              if (product !=null){
                  request.setAttribute("product",product);
                  request.getRequestDispatcher("product_view.jsp").forward(request,response);
              }
          } catch (Exception e) {
              e.printStackTrace();
          }
          //加载热卖商品页面
      }else if ("best".equals(param)){
          response.setContentType("application/json;charset=utf-8");
          try {
         List<Product> list= productService.productStock(0,5);
              String json = JSON.toJSONString(list);
          response.getWriter().write(json);

          } catch (Exception e) {
              e.printStackTrace();
          }
      }else if ("SE".equals(param)){
          String qname = request.getParameter("qname");
          try {
              List<Product> list = productService.productSE(qname);
              request.setAttribute("list",list);
              request.getRequestDispatcher("/product_list.jsp").forward(request,response);
          } catch (Exception e) {
              e.printStackTrace();
          }

      }


      }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
