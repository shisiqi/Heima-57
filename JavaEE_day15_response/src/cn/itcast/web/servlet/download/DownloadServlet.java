package cn.itcast.web.servlet.download;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数，文件名称
        String fileName = request.getParameter("filename");
        //找到文件在服务器中的路径
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/img/" + fileName);
        //使用字节流关联
        FileInputStream fis = new FileInputStream(realPath);
        //设置response的响应头
        //获取文件的mime类型
        String mimeType = servletContext.getMimeType(fileName);
        response.setHeader("content-type",mimeType);
        response.setHeader("content-disposition","attachment;filename=" + fileName);
        //将输入流的数据写出到输出流中
        ServletOutputStream outputStream = response.getOutputStream();
        byte[] buff = new byte[1024 * 8];
        int len = 0;
        while ((len =fis.read(buff))!= -1){
            outputStream.write(buff,0,len);
        }
        fis.close();


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
