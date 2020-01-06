package cn.itcast.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/cookieTest")
public class CookieTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应的消息体
        response.setContentType("text/html;charset=utf-8");
        //设置标记位：当没有cookie的名字是lastTime的时候,flag=false
        boolean flag = false;
        //先获取所有的cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0){
            for (Cookie cookie : cookies) {
                //获取cookie的名字
                String name = cookie.getName();
                //判断cookie的名称是否是lastTime
                if ("lastTime".equals(name)){
                    //说明有该cookie，不是第一次访问
                    flag = true;
                    //获取上一次从浏览器端带过来的cookie值

                    //获取当前时间
                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日-HH:mm:ss");
                    String str_date = simpleDateFormat.format(date);
                    System.out.println("编码前:" + str_date);
                    //URL编码
                    URLEncoder.encode(str_date,"utf-8");
                    System.out.println("编码后：" + str_date);
                    cookie.setValue(str_date);
                    //设置cookie的存活时间
                    cookie.setMaxAge(60 * 60 * 24 * 30);
                    response.addCookie(cookie);

                    //响应数据
                    String value = cookie.getValue();
                    System.out.println("解码前:" + value);
                    //URL解码
                    URLDecoder.decode(value,"utf-8");
                    System.out.println("解码后:" + value);
                    response.getWriter().write("<h1>欢迎回来，你上次访问的时间为" + value + "</h1>");

                    break;


                }


            }
        }

        if (cookies == null || cookies.length == 0 ||  flag == false){//满足这3个条件的任何一项都说明第一次访问

            //设置cookie的value
            //获取当前时间的字符串，重新设置Cookie的值，重新发送cookie
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日-HH:mm:ss");
            String str_date = sdf.format(date);
            //先输出编码前的日期看一下
            System.out.println(str_date);
            //对日期先进行编码
            str_date = URLEncoder.encode(str_date, "utf-8");
            //在输出编码后的日期看一下
            System.out.println(str_date);

            Cookie  cookie = new Cookie("lastTime",str_date);
            //设置cookie的存活时间
            cookie.setMaxAge(60 * 60 * 24 * 30);//一个月
            response.addCookie(cookie);
            //回写到页面
            response.getWriter().write("<h1>你好，欢迎首次访问</h1>");

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
