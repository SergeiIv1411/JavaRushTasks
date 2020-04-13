package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static Map<String, Integer> createMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("wfwe0", 300);
        map.put("wfwe1", 300);
        map.put("wfwe2", 300);
        map.put("wfwe3", 300);
        map.put("wfwe4", 300);
        map.put("wfwe5", 300);
        map.put("wfwe6", 300);
        map.put("wfwe7", 300);
        map.put("wfwe8", 300);
        map.put("wfwe9", 300);
        return map;
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
        Map<String, Integer> removeMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry: map.entrySet())
             {
                 if(entry.getValue() < 500)
                     removeMap.put(entry.getKey(), entry.getValue());
             }
        for (Map.Entry<String, Integer> entry: removeMap.entrySet()){
            map.remove(entry.getKey(),entry.getValue());
        }
    }

    public static void main(String[] args) {

    }
}