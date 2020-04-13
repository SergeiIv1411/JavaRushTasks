package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double a = Double.parseDouble(reader.readLine());
        double b = Double.parseDouble(reader.readLine());
        double c = Double.parseDouble(reader.readLine());
        double d = Double.parseDouble(reader.readLine());
        System.out.println(max(max(a,b), max(c,d)));
    }
    public static double max(double a, double b){
        if (a >= b) return a;
        else return b;
    }
}
