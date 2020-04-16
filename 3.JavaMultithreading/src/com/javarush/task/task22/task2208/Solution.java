package com.javarush.task.task22.task2208;

import java.util.LinkedHashMap;
import java.util.Map;

/*
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("name", null);
        map.put("country", null);
        map.put("city", null);
        map.put("age", null);
        System.out.println(getQuery(map));
    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder("");
        if (params == null || params.isEmpty()) return sb.toString();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (entry.getValue() == null || entry.getKey() == null){
                continue;
            }
            sb.append(" and " + entry.getKey() + " = '" + entry.getValue() + "'");
        }
        String s = sb.toString();
        if (s.equals("")) return "";
        else
        return s.substring(s.indexOf("and") + 4).trim();
    }
}
