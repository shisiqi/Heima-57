package com.itheima.test;

import com.itheima.dao.IUserDao;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    /*
    Mybatis的入门案例
     */
    public static void main(String[] args) throws IOException {
        //1.读取配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建一个sqlSessionFactory工厂
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        //3.使用工厂生产一个sqlSession对象
        SqlSession Session = sqlSessionFactory.openSession();
        //4.使用sqlSessionFactory创建dao接口的代理对象
        IUserDao userDao = Session.getMapper(IUserDao.class);
        //5.使用代理对象执行方法
        List<User> list = userDao.findAll();
        for (User user:
             list) {
            System.out.println(user);
        }
        //6.释放资源
        Session.close();
        inputStream.close();
    }
}
