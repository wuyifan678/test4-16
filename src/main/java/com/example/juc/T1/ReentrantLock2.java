package com.example.juc.T1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock2 {//此方法和syn没区别，但可以使用队列，见另一个ReentrantLock示例
    public static void main(String[] args) {
        char[] num = "123456789".toCharArray();
        char[] letter = "ABCDEFGHI".toCharArray();
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        new Thread(() -> {
            try {
                lock.lock();
                for (char c : num) {
                    System.out.print(c);
                    condition.signal();//o.notify
                    condition.await();//o.wait
                }
                condition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                lock.unlock();
            }
        }, "t1").start();

        new Thread(() -> {
            try {
                lock.lock();
                for (char c : letter) {
                    System.out.print(c);
                    condition.signal();
                    condition.await();
                }
                condition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                lock.unlock();
            }
        }, "t2").start();


    }
}
