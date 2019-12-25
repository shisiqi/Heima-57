package com.itheima.demo02.setName;
/*设置线程名称
1.使用Thread类中的方法setName(名字)
    void setName(String name)改变线程的名称，使之与参数名称name相同
2.创建一个带参数的构造方法，参数传递线程的名称；调用父类的带参构造方法，把线程名称传递给父类，让父类（Thread）给子线程起一个名字
    Thread(String name)
 */
public class MyThread extends Thread{

    //使用第二种方式来设置线程名称
    //给带参数的构造方法中传入你想定义的线程名称


    @Override
    public void run() {
        this.setName("shisiqi的线程");
        System.out.println(Thread.currentThread().getName());
    }
}
