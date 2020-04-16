package com.example.juc.T1;

public class cas {
    enum ReadyToRun {T1, T2}//可以换其他类型，用enum只是好看

    static volatile ReadyToRun r = ReadyToRun.T1;//思考为什么必须使用volatile

    public static void main(String[] args) {
        char[] num = "123456789".toCharArray();
        char[] letter = "ABCDEFGHI".toCharArray();

        new Thread(() -> {
            for (char c : num) {
                while (r != ReadyToRun.T1) {}//    空转/自旋   while不能改if，因为if只执行一次判断
                System.out.print(c);
                r = ReadyToRun.T2;
            }
        }, "t1").start();
        new Thread(() -> {
            for (char c : letter) {
                while (r != ReadyToRun.T2) {}
                System.out.print(c);
                r = ReadyToRun.T1;
            }
        }, "t2").start();



    }
}
