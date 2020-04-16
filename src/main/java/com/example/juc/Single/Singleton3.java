package com.example.juc.Single;

import java.util.Properties;
//静态代码块，不懂，不完全
public class Singleton3 {
    public static final Singleton3 INSTANCE;
    private String info;

    static {
        Properties pro=new Properties();
        INSTANCE = new Singleton3();
    }

    private Singleton3() {
        this.info = info;
    }
}
