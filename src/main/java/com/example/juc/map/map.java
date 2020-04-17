package com.example.juc.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author:wuyifan
 * @Describe: 遍历map的几种方式
 * @Date:2020-04-17
 * @Time:10:52
 */
public class map {
    public static void main(String[] args) {
        //遍历Map 第一种方式
        Map<String, Integer> map1 = new HashMap<String, Integer>();
        map1.put("jack", 20);
        map1.put("rose", 18);
        map1.put("lucy", 17);
        map1.put("java", 25);

        //第一种：通过 map1.keySet() 获取key  通过key 找到value
        for (String key : map1.keySet()) {
            Integer value = map1.get(key);
            System.out.println("key : " + key + " value : " + value);
        }

        //key : java value : 25
        //key : rose value : 18
        //key : lucy value : 17
        //key : jack value : 20

        //第二种：通过Map.Entry(String,Integer) 获取，然后使用entry.getKey()获取到键，通过entry.getValue()获取到值
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            System.out.println("键 key ：" + entry.getKey() + " 值value ：" + entry.getValue());
        }
        //键 key ：java 值value ：25
        //键 key ：rose 值value ：18
        //键 key ：lucy 值value ：17
        //键 key ：jack 值value ：20

        //第三种：只遍历键或者值，通过加强for循环
        for (String s1 : map1.keySet()) {//遍历map的键
            System.out.println("键key ：" + s1);
        }
        //键key ：java
        //键key ：rose
        //键key ：lucy
        //键key ：jack
        for (Integer s2 : map1.values()) {//遍历map的值
            System.out.println("值value ：" + s2);
        }
        //值value ：25
        //值value ：18
        //值value ：17
        //值value ：20

        //第四种：Iterator遍历获取，然后获取到Map.Entry<String, String>，再得到getKey()和getValue()
        Iterator<Map.Entry<String, Integer>> iterator = map1.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println("key:" + entry.getKey() + ",value:" + entry.getValue());
        }
    }
}