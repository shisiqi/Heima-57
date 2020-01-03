package cn.itcast.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/requestDemo4")
public class RequestDemo04 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String referer = request.getHeader("referer");
        System.out.println(referer);

        if (referer!=null){
            if (referer.contains("/day14")){
                //能正常访问
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("播放电影");
            }else {
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("看电影，来优酷");
            }
        }

    }
}
