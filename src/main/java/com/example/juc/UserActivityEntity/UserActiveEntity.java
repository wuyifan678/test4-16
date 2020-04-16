package com.example.juc.UserActivityEntity;

import lombok.*;

import java.io.Serializable;
import java.util.HashMap;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserActiveEntity implements Serializable {
    private Double value;
    private String time;
    public static HashMap<String,Object> getmap(UserActiveEntity userActiveEntity){
        HashMap<String,Object> map=new HashMap<>();
        map.put("value", userActiveEntity.getValue());
        map.put("time",userActiveEntity.getTime());
        return map;
    };

    public static void main(String[] args) {
        //这是我强行理解的他这个map
        //可以直接得到收到的这个UserActiveEntity对象的两个值
        HashMap<String,Object> map=UserActiveEntity.getmap(new UserActiveEntity(12d,"123"));
        System.out.println(map.get("value"));
        System.out.println(map.get("time"));
        //得到
        // 12.0
        //123
    }
}
