package com.itheima.demo03.sleep;
/*

public static void sleep(long millis);使当前正在执行的线程以指定的毫秒数暂停，毫秒数结束之后继续运行

 */
public class Demo01Sleep {
    public static void main(String[] args) {
        for (int i = 1; i <= 60; i++) {
            System.out.println(i);
            //sleep是静态方法，可以直接使用Thread类名进行调用
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
