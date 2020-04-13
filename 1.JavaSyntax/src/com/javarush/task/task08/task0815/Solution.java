package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static Map<String, String> createMap() {
        Map<String, String> map = new HashMap<>();
        map.put("a1", "a");
        map.put("a2", "a");
        map.put("a3", "a");
        map.put("a4", "a");
        map.put("a5", "a");
        map.put("a6", "a");
        map.put("a7", "a");
        map.put("a8", "a");
        map.put("a9", "a");
        map.put("a0", "a");
        return map;
    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        int count = 0;
        for (Map.Entry<String,String> entry: map.entrySet()
             ) {
            if(entry.getValue().equals(name)) count ++;
        }
        return count;
    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        int count = 0;
        for (Map.Entry<String,String> entry: map.entrySet()
        ) {
            if(entry.getKey().equals(lastName)) count ++;
        }
        return count;

    }

    public static void main(String[] args) {

    }
}
