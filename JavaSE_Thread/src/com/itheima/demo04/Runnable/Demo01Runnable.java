package com.itheima.demo04.Runnable;
/*
创建多线程的第二种方式：实现Runnable接口
java.lang.Thread类的构造方法
    Thread(Runnable target) 分配新的Thread对象
    Thread(Runnable target,String name)分配新的Thread对象

    实现步骤：
    1.创建Runnable接口的实现类
    2.在接口中重写run方法
    3.创建一个Runnable接口的实现类对象
    4.创建Thread类对象，在构造方法中传入Runnable接口的实现类对象
    5.调用Thread类的start方法来开启新的线程


    使用实现Runnable接口的形式来创建多线程有什么好处？（其实也是实现接口比起继承的好处）
    1.避免了单继承的局限性（一个类去继承了Thread类就不能继承其他类了）
    2.将设置线程任务和开启线程进行了解耦分离
        实现类中，重写run方法，用来设置线程任务
        创建Thread类的对象，调用start方法开启新的线程执行run方法
      当你传递不同的实现类的时候实现的是不同的任务

 */
public class Demo01Runnable  {

    public static void main(String[] args) {
        new Thread(new RunnableImpl()).start();

        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + "--->"+ i);
        }
    }
}
