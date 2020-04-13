package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        String result = "";
        String[] strMas = string.split(" ");
        for (String s: strMas
             ) {
            if (s.isEmpty()) continue;
            result += s.substring(0, 1).toUpperCase() + s.substring(1) + " ";
        }
        System.out.println(result);
    }
}
