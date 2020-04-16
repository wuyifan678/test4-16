package com.example.juc.Single;

public class TestSingleton2 {
    public static void main(String[] args) {
        Singleton2 s=Singleton2.INSTANCE;
        System.out.println(s);
        //INSTANCE
        //返回的是常量对象的名字
    }
}
