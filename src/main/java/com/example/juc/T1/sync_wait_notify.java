package com.example.juc.T1;

public class sync_wait_notify {
    public static void main(String[] args) {
        final Object o = new Object();

        char[] num = "123456789".toCharArray();
        char[] letter = "ABCDEFGHI".toCharArray();

        new Thread(() -> {
            synchronized (o) {
                for (char c : num) {
                    System.out.print(c);
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
               o.notify();//必须，否则无法停止程序
            }
        }, "t1").start();

        new Thread(() -> {
            synchronized (o) {
                for (char c : letter) {
                    System.out.print(c);
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();
            }
        }, "t2").start();
    }
}
//如果想保证某一个线程先运行，可与利用countDownlatch或者cas里的那种自旋，