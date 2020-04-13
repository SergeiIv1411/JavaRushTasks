package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        //BufferedReader reader = new BufferedReader(new FileReader(new BufferedReader(new InputStreamReader(System.in)).readLine()));
        Map<String, Double> map = new HashMap<>();
        while(reader.ready()){
            String[] data = reader.readLine().split(" ", -1);
            if(map.containsKey(data[0])){
                Double salary = map.get(data[0]);
                map.put(data[0], salary + Double.parseDouble(data[1]));
            } else map.put(data[0], Double.parseDouble(data[1]));
        }
        reader.close();
        map.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue());
        for (Map.Entry<String, Double> entry: map.entrySet()
             ) {
            System.out.println(entry.getKey() + " " + entry.getValue());

        }
    }
}
