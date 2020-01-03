package cn.itcast.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

@WebServlet("/requestDemo06")
public class RequestDemo06 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //post 获取请求参数
        //根据参数名称获取参数值
//        String username = request.getParameter("username");
//        System.out.println(username);
        //根据参数值名称获取参数值数组
        String[] hoobies = request.getParameterValues("hobby");
//        for (String hooby : hoobies) {
//            System.out.println(hooby);
//        }

        //获取所有请求的参数名称
        Enumeration<String> parameterNames = request.getParameterNames();
//        while (parameterNames.hasMoreElements()){
//            String key = parameterNames.nextElement();
//            System.out.println(key);
//            //根据参数名称获取参数值
//            String value = request.getParameter(key);
//            System.out.println(value);
//            System.out.println("------------------------");
//        }


        //获取所有参数的map集合
        Map<String, String[]> parameterMap = request.getParameterMap();
        //遍历map集合
        //遍历map集合的方式，要么通过entrySet，要么通过keySet
        for (String s : parameterMap.keySet()){
            String[] values = request.getParameterValues(s);
            System.out.println(s);
            //遍历value数组
            for (String value : values) {
                System.out.print(value + " ");
            }
            System.out.println("---------------------------------");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
