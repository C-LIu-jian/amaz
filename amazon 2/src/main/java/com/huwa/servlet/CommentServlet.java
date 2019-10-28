package com.huwa.servlet;

import com.huwa.entity.Comment;
import com.huwa.service.CommentService;
import com.huwa.serviceImpl.CommentServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

@WebServlet("/Comment.do")
public class CommentServlet extends HttpServlet {
    private CommentService commentService;
    @Override
    public void init(ServletConfig config) throws ServletException {
       commentService =new CommentServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                 doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String param = request.getParameter("param");
        //查询所有留言
        if ("login".equals(param)){
            try {
                List<Comment> comments = commentService.commentAll();
                if (comments !=null){
                    request.setAttribute("comments",comments);
                    request.getRequestDispatcher("/guestbook.jsp").forward(request,response);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }


        }else if ("commentAdd".equals(param)){
         //nick_name reply content create_time
         String nick_name=request.getParameter("nick_name");
         String reply=request.getParameter("reply");
         String content=request.getParameter("content");
            try {
                Date create_time = new Date();
                Date reply_time= create_time;
                Comment comment =new Comment(reply,content,create_time,reply_time,nick_name);
               int i= commentService.commentAdd(comment);
               if (i==1){
                   PrintWriter out = response.getWriter();
                   out.write("true");
               }
            } catch (Exception e) {
                e.printStackTrace();
            }





        }


    }
}
