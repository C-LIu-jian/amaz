package com.huwa.servlet;

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
import java.util.List;

@WebServlet("/news.do")
public class NewsServlet extends HttpServlet {
    private NewsService newsService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        newsService =new NewsServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // response.setContentType("utf-8");
//       String param= request.getParameter("news");
//       if ("newsAll".equals(param)){
        String param = request.getParameter("param");
        boolean flag = true;
        if ("newsId".equals(param)) {
            Long id = Long.parseLong(request.getParameter("id"));
            try {
                News news = newsService.newsQuery(id);
                request.setAttribute("news", news);
                request.getRequestDispatcher("/news_view.jsp").forward(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
            flag = false;
        }
        if (flag) {
            try {
                List<News> list = newsService.newsAll();
                request.setAttribute("list", list);
                request.getRequestDispatcher("/index_news.jsp").include(request, response);
//            request.getRequestDispatcher("/index_news.jsp").forward(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             doPost(request,response);
    }
}
