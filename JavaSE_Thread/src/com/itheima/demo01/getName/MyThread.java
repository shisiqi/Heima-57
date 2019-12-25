package com.itheima.demo01.getName;
/*
1.String getName();使用Thread类中的方法getName()
2.static Thread currentThread()

 */
public class MyThread extends Thread{
    @Override
    public void run() {
        //获取线程的线程名称
//        String name = this.getName();
//        System.out.println(name);


        String name = Thread.currentThread().getName();
        System.out.println(name);
    }
}
