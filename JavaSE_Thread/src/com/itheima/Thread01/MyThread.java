package com.itheima.Thread01;
//1.创建一个Thread类的子类
public class MyThread extends Thread {
    //2.重写Thread类中的run方法

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("run:" +i);
        }
    }
}
