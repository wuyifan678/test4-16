package com.example.juc.Single;
//懒汉式

/**
 * 懒汉式：延迟创建这个实例对象
 * 1，构造器私有化
 * 2，静态变量保存这个唯一实例
 * 3,提供静态方法获取对象
 */
public class Singleton4 {
    private static Singleton4 instance;

    private Singleton4() {

    }

    public static Singleton4 getInstance() {
        if (instance == null) {
            //休眠是为了演示多线程情况下创建了不同对象
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new Singleton4();
        }
        return instance;
    }

}
