package com.itheima.Thread01;

/**
 * 创建多线程的第一种方式，实现步骤：
 *      1。创建一个Thread类的子类
 *      2. 在Thread类的子类中重写Thread类的run方法，设置线程任务（开启线程要做的事）
 *      3. 创建Thread类的子类对象
 *      4.调用Thread类中的start方法，开启新的线程，执行run方法
 *
 */
public class Demo01Thread {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        mt.start();
        //这里需要注意，如果调用的是run方法,只是个单线程的程序，即只有main线程；
        //而调用mt.start()方法会开辟新的栈空间，在这个栈空间中执行run方法

        //main线程内
        for (int i = 0; i < 20; i++) {
            System.out.println("main:" + i);
        }
    }

}
