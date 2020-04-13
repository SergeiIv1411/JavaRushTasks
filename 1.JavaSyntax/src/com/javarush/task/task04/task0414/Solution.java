package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        int x;
        int year = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        if (year % 400 == 0) x = 366;
        else
            if (year % 100 == 0) x = 365;
            else
                if (year % 4 == 0) x = 366;
                else x = 365;
         System.out.println("количество дней в году: " + x);

    }
}