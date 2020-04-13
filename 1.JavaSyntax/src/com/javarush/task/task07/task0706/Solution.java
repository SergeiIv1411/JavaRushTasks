package com.javarush.task.task07.task0706;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        int[] mas = new int[15];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int countCh = 0, countOdd = 0;
        for (int i = 0; i < mas.length; i ++){
            mas[i] = Integer.parseInt(reader.readLine());
            if (i % 2 == 0 || i == 0) countCh += mas[i];
            else countOdd += mas[i];
        }
        if ((countCh > countOdd)) {
            System.out.println("В домах с четными номерами проживает больше жителей.");
        } else {
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        }
    }
}
