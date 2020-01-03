package cn.itcast.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

@WebServlet("/requestDemo07")
public class RequestDemo07 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决乱码问题
            //1.对于get请求的乱码问题，tomcat8已经修复
            //2.post请求的乱码问题解决 request.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        //获取请求参数
        String parameter = request.getParameter("username");
        System.out.println(parameter);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
