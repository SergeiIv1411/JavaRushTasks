package com.javarush.task.task07.task0715;

/* 
Продолжаем мыть раму
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("мама");
        strings.add("мыла");
        strings.add("раму");
        strings.add(1, "именно");
        strings.add(3, "именно");
        strings.add("именно");
        for (String s: strings
             ) {
            System.out.println(s);

        }
    }
}
