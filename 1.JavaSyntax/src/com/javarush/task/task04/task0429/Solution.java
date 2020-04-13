package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        int countplus = 0;
        int countotr = 0;
        if (a > 0) countplus ++;
        else if (a < 0) countotr ++;
        if (b > 0) countplus ++;
        else if (b < 0) countotr ++;
        if (c > 0) countplus ++;
        else if (c < 0) countotr ++;
        System.out.println("количество отрицательных чисел: " + countotr);
        System.out.println("количество положительных чисел: " + countplus);
    }
}
