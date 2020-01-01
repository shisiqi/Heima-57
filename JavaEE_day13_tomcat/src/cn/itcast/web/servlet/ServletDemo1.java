package cn.itcast.web.servlet;

import javax.servlet.*;
import java.io.IOException;
/*
Servlet快速入门
 */
public class ServletDemo1 implements Servlet {
    //在servlet被创建时执行，只会执行一次
    //说明Servlet在内存中只存在一个对象，是单例的
    //尽量不要定义成员变量，不要修改成员变量的值
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    //提供服务的方法，每一次servlet被访问都会去执行，执行多次
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Hello Servlet");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    //在服务器被正常关闭的时候去执行
    @Override
    public void destroy() {

    }
}
