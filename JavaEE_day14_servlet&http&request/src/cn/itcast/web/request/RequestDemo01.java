package cn.itcast.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*
演示request对象获取请求行数据
 */
@WebServlet("/requestDemo01")
public class RequestDemo01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*

        方法：
            1. 获取请求方式 ：GET
                * String getMethod()
            2. (*)获取虚拟目录：/day14
                * String getContextPath()
            3. 获取Servlet路径: /demo1
                * String getServletPath()
            4. 获取get方式请求参数：name=zhangsan
                * String getQueryString()
            5. (*)获取请求URI：/day14/demo1
                * String getRequestURI():		/day14/demo1
                * StringBuffer getRequestURL()  :http://localhost/day14/demo1

                * URL:统一资源定位符 ： http://localhost/day14/demo1	中华人民共和国
                * URI：统一资源标识符 : /day14/demo1					共和国

            6. 获取协议及版本：HTTP/1.1
                * String getProtocol()

            7. 获取客户机的IP地址：
                * String getRemoteAddr()
         */

        //1.获取请求方式
        String method = request.getMethod();
        System.out.println(method);
        //2.获取虚拟目录
        String contextPath = request.getContextPath();
        System.out.println(contextPath);
        //3.获取servlet路径
        String path = request.getServletPath();
        System.out.println(path);
        //4.获取get方式请求参数
        String queryString = request.getQueryString();
        System.out.println(queryString);

        //5.获取请求的URI
        String URI = request.getRequestURI();
        System.out.println(URI);

        //6.获取URL
        StringBuffer url = request.getRequestURL();
        System.out.println(url);
        //7.获取获取协议及版本
        String protocol = request.getProtocol();
        System.out.println(protocol);
        //8.获取客户机的IP地址
        String addr = request.getRemoteAddr();
        System.out.println(addr);

    }
}
