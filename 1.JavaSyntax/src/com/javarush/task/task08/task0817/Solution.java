package com.javarush.task.task08.task0817;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static Map<String, String> createMap() {
        Map<String, String> map = new HashMap<>();
        int j = 0 , k = 0;
        for (int i = 0; i < 10; i++){
            if (k == 2){k = 0; j++;}
            map.put("LastName " + i, "Name" + j);
            k++;

        }
        return map;
    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        for (String v : map.values()){
            if (Collections.frequency(map.values(), v) > 1)
                removeItemFromMapByValue(map, v);
        }

    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {
        Map<String, String> map = createMap();
        for (Map.Entry<String,String> entry: map.entrySet()
             ) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        removeTheFirstNameDuplicates(map);
        for (Map.Entry<String,String> entry: map.entrySet()
        ) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
