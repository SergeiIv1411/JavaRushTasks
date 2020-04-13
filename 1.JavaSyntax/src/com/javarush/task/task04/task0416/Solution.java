package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        double t = Double.parseDouble(new BufferedReader(new InputStreamReader(System.in)).readLine());
        t = t % 5;
        if (t < 3) System.out.println("зелёный");
        else {
            if (t>=3 & t < 4) System.out.println("жёлтый");
            else System.out.println("красный");
        }
    }
}