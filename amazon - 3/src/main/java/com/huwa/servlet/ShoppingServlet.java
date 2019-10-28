package com.huwa.servlet;

import com.huwa.entity.CartItem;
import com.huwa.entity.ShoppingCart;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet("/Shopping.do")
public class ShoppingServlet extends HttpServlet {
     private ShoppingCart shoppingCart;

    @Override
    public void init(ServletConfig config) throws ServletException {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String param = request.getParameter("param");
        ShoppingCart cart= (ShoppingCart)request.getSession().getAttribute("cart");
        if ("proAll".equals(param)){
            Long id=  Long.parseLong(request.getParameter("id"));
            Integer count= Integer.parseInt(request.getParameter("count"));
           boolean flag= cart.productAdd(id,count);

           response.getWriter().print(flag);
        }else if ("remove".equals(param)){
          Long id=  Long.parseLong(request.getParameter("id"));
          if (id !=null ){
             cart.clearItem(id);
             response.getWriter().print("true");
          }
        }else if ("mod".equals(param)){
            Long id=  Long.parseLong(request.getParameter("id"));
            int num=  Integer.parseInt(request.getParameter("num"));
              cart.cartProNum(id,num);
            int i = cart.getCart().get(id).getQuantity();
            response.getWriter().print(i);

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                     doPost(request,response);
    }
}
