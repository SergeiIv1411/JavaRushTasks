package com.javarush.task.task07.task0703;

/* 
Общение одиноких массивов
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        String[] masStr = new String[10];
        int[] masInt = new int[10];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i ++){
            masStr[i] = reader.readLine();
            masInt[i] = masStr[i].length();
        }
        for (int a:masInt
             ) {
            System.out.println(a);

        }
    }
}
