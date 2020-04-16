package com.example.juc.T1;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class TransferQueueMethod {
    public static void main(String[] args) {
        char[] num = "123456789".toCharArray();
        char[] letter = "ABCDEFGHI".toCharArray();

        TransferQueue<Character> queue = new LinkedTransferQueue<>();
        //这种队列容量为0，transfer,放进去后，没有人take的话，就在这里不走了

        new Thread(() -> {
            try {
                for (char c : num) {
                    System.out.print(queue.take());
                    queue.transfer(c);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1").start();

        new Thread(() -> {
            try {
                for (char c : letter) {
                    queue.transfer(c);
                    System.out.print(queue.take());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2").start();
    }
    //t1等着take出来打印，t2放进去一个，t1拿出来打印了，又放进去一个，然后t2拿出来打印
}
