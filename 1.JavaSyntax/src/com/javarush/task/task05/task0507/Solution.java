package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        double sum = 0, iter = 0;

        while (true) {
            iter = Double.parseDouble(reader.readLine());
            if (iter == -1) break;
            count ++;
            sum += iter;
        }
        System.out.println(sum / count);
    }
}

