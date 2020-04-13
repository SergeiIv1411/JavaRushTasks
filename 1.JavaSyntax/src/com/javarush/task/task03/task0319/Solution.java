package com.javarush.task.task03.task0319;

/* 
Предсказание на будущее
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        String sSal = reader.readLine();
        String sAge = reader.readLine();
        System.out.println(name + " получает " + Integer.parseInt(sSal) + " через " + Integer.parseInt(sAge) + " лет.");

    }
}
