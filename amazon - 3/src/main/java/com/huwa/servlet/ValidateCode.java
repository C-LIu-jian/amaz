package com.huwa.servlet;

import com.huwa.util.CodeUtil;
import javax.imageio.ImageIO;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.RenderedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet("/code")
public class ValidateCode extends HttpServlet {
    private  List<String> words;
    @Override
    public void init(ServletConfig config) throws ServletException {
        words = new ArrayList<>();
        ServletContext context = config.getServletContext();//一个应用程序对应一个上下文
        //上下文看作是一个指针,指向了当前应用程序,通过上下文就能获取应用程序中的所有资源
        String path = context.getRealPath("/WEB-INF/words.txt");
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path),"utf-8"));
            String line=null;
            while((line=reader.readLine())!=null){
                words.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(words+"..........");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    /**
     * 向客户端浏览器生成一张验证码图片
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> map = CodeUtil.code(120, 30, 30, words);
        String code=(String)map.get("code");
        HttpSession session = req.getSession();
        session.setAttribute("code",code);
        //把验证码缓冲区中的数据生成图片写到客户端
        resp.setContentType("image/jpeg");
        ServletOutputStream out = resp.getOutputStream();//字节输出流对象
        ImageIO.write((RenderedImage) map.get("codePic"),"jpeg",out);//把缓冲区中的数据以图片的方式进行输出到客户端
        out.close();
    }
}
