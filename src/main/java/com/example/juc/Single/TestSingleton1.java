package com.example.juc.Single;

public class TestSingleton1 {
    public static void main(String[] args) {
        Singleton1 s = Singleton1.INSTANCE;
        System.out.println(s);
        //com.example.juc.Single.Singleton1@681a9515
        //没有重写tostring所以是哈希码
    }
}
