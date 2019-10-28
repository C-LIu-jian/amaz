package com.huwa.servlet;

import com.alibaba.fastjson.JSON;
import com.huwa.entity.Paging;
import com.huwa.entity.Product;
import com.huwa.service.ProductService;
import com.huwa.serviceImpl.ProductServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
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
        //分页
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
        Long  id=Long.parseLong(request.getParameter("id"));
          //添加浏览记录
//          Cookie[] cookies =request.getCookies();
//          String hisTroyId=null;
//          boolean flag=false; //默认没有找到指定名字的cook;
//          if (cookies == null ||flag == false){  //第一次访问
//              hisTroyId = id;
//          }
//
//          //非第一次访问
//          if (cookies !=null && cookies.length>0){
//              for (Cookie cookie: cookies) {
//                  if (cookie.getName().equals("hisTroyId"));
//                  hisTroyId =cookie.getValue(); //1-2-3
//                  flag=true;
//                  break;
//              }
//          }
//          LinkedList<String> list = new LinkedList<String>(Arrays.asList(hisTroyId.split("-")));
//          //假如长度不满4冲突,先删除冲突的id,再把id添加到头部,不冲突,直接添加到头部
//          if (list.size()<4){
//              if (list.contains(id)){
//                  list.remove(id); //先删除
//              }
//          }
//          if (list.size()==4){
//              if (list.contains(id)==false){  //没有冲突id
//                  list.removeLast();      //删除最后一个
//              }else {
//                  list.remove(id);  //反之删除冲突id
//              }
//          }
//          list.addFirst(id); //添加到头部
//          //动态拼接
//          StringBuilder sb = new StringBuilder();
//          for (int i = 0; i <list.size() ; i++) {
//              if (i>0){
//                  sb.append(list.get(i));
//              }
//          }
//          hisTroyId =sb.toString();
//          Cookie cookie = new Cookie("hisToryId",hisTroyId);
//          cookie.setMaxAge(60*60*24*10);
//          response.addCookie(cookie);
          //根据id查找
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
          //模糊搜素
      }else if ("SE".equals(param)){
          String qname = request.getParameter("qname");
          try {
              List<Product> list = productService.productSE(qname);
              request.setAttribute("list",list);
              request.getRequestDispatcher("/product_list.jsp").forward(request,response);
          } catch (Exception e) {
              e.printStackTrace();
          }
       //查找二级商品分类
      }else if("minor".equals(param)){
       Long minor=Long.parseLong( request.getParameter("parent"));
          try {
              List<Product> list = productService.minorAll(minor);
              if (list !=null && list.size()>0){
                  request.setAttribute("list",list);
                  request.getRequestDispatcher("/product_list.jsp").forward(request,response);
              }
          } catch (Exception e) {
              e.printStackTrace();
          }


          //查找一级分类
      }else if ("major".equals(param)){
       Long major=Long.parseLong( request.getParameter("parent"));
          try {
              List<Product> list = productService.majorAll(major);
              if (list !=null && list.size()>0){
                  request.setAttribute("list",list);
                  request.getRequestDispatcher("/product_list.jsp").forward(request,response);
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
