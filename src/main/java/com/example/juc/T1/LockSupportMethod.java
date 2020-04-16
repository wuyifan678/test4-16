package com.example.juc.T1;

import java.util.concurrent.locks.LockSupport;

public class LockSupportMethod {

    static Thread t1 = null, t2 = null;

    public static void main(String[] args) {
        char[] num = "123456789".toCharArray();
        char[] letter = "ABCDEFGHI".toCharArray();
        //
        t1 = new Thread(() -> {
            for (char c : num) {
                System.out.print(c);
                LockSupport.unpark(t2);//叫醒t2   叫醒指定线程
                LockSupport.park();//t1阻塞   当前线程阻塞
            }
        }, "t1");
//可以先叫醒再睡，先unpark再park。wait和notify不行，一定先wait才能notify
        t2 = new Thread(() -> {
            for (char c : letter) {
                LockSupport.park();//t2阻塞
                System.out.print(c);
                LockSupport.unpark(t1);//叫醒t1
            }
        }, "t2");
        t1.start();
        t2.start();
    }
}
//JUC中的核心类AQS大量使用park和unpark,所以效率挺高
