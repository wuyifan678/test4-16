package com.example.juc.Single;

/**
 * 饿汉式：在类初始化时直接创建实例对象
 *
 *
 *
 * 1构造器私有化
 * 2 自行创建，并且用静态变量保存
 * 3 向外提供这个实例
 * 4 强调这个是单例，用finally修饰
 */
public class Singleton1 {
    public static final Singleton1 INSTANCE = new Singleton1();

    private Singleton1() {

    }


}
