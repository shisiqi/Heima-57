package com.itheima.demo02.setName;

public class Demo01SetThreadName {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        mt.start();

        //设置主线程的名称
        Thread.currentThread().setName("主线程");
        System.out.println(Thread.currentThread().getName());

        //这里还是使用匿名对象的形式创建线程对象（注意！是使用带参数的构造方法）
        //new MyThread("舒梦珂").start();
    }
}
