package com.itheima.demo01.getName;

public class Demo01GetThreadName {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        mt.start();

        new MyThread().start();//使用这种匿名对象的形式开启新的线程
        new MyThread().start();

        //获取一下主线程的名称
        System.out.println(Thread.currentThread().getName());

    }
}
