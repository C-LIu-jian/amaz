package com.huwa.servlet;

import com.alibaba.fastjson.JSON;
import com.huwa.entity.News;
import com.huwa.service.NewsService;
import com.huwa.serviceImpl.NewsServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/news.do")
public class NewsServlet extends HttpServlet {
    private NewsService newsService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        newsService =new NewsServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String param = request.getParameter("param");
        if ("newsId".equals(param)) {
            Long id = Long.parseLong(request.getParameter("id"));
            try {
                News news = newsService.newsQuery(id);
                request.setAttribute("news", news);
                request.getRequestDispatcher("/news_view.jsp").forward(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if ("newsAll".equals(param)) {
            try {
                request.setCharacterEncoding("utf-8");
                response.setContentType("application/json;charset=utf-8");
                List<News> list = newsService.newsAll();
                 String json = JSON.toJSONString(list);
                PrintWriter out = response.getWriter();
                   out.write(json);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             doPost(request,response);
    }
}
