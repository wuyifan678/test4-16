package com.example.juc.T1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Reentrantlock {//采用2个队列  Condition

    //在一个锁上去wait是进入了这个锁的等待队列
    public static void main(String[] args) {
        char[] num = "123456789".toCharArray();
        char[] letter = "ABCDEFGHI".toCharArray();

        Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();  //队列1
        Condition condition2 = lock.newCondition();  //队列2

        new Thread(() -> {
            try {
                lock.lock();
                for (char c : num) {
                    System.out.print(c);
                    condition2.signal();
                    condition1.await();
                }
                condition2.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t1").start();

        new Thread(() -> {
            try {
                lock.lock();
                for (char c : letter) {
                    System.out.print(c);
                    condition1.signal();
                    condition2.await();
                }
                condition2.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t").start();


    }
}
//多线程的生产者消费者问题，