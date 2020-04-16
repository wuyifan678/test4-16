package com.example.juc.Single;

import java.util.concurrent.*;

public class TestSingleton4 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
       /* //单线程情况下
        Singleton4 s1=Singleton4.getInstance();
        Singleton4 s2=Singleton4.getInstance();
        //为了演示时同一个对象
        System.out.println(s1==s2);
        System.out.println(s2);
        System.out.println(s1);
        //true
        //com.example.juc.Single.Singleton4@681a9515
        //com.example.juc.Single.Singleton4@681a9515*/
        /**
         * 多线程情况下
         * 演示不安全
         */
        //使用匿名内部类开启线程
        Callable<Singleton4> c = new Callable<Singleton4>() {
            @Override
            public Singleton4 call() throws Exception {
                return Singleton4.getInstance();
            }
        };
        //创建线程池
        ExecutorService es = Executors.newFixedThreadPool(2);
        Future<Singleton4> f1 = es.submit(c);
        Future<Singleton4> f2 = es.submit(c);

        Singleton4 s1 = f1.get();
        Singleton4 s2 = f2.get();

        System.out.println(s1 == s2);
        System.out.println(s2);
        System.out.println(s1);
//false  创建了不同对象
//com.example.juc.Single.Singleton4@1c20c684
//com.example.juc.Single.Singleton4@1fb3ebeb

        es.shutdown();
    }
}
