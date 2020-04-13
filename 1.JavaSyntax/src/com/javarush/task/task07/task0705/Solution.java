package com.javarush.task.task07.task0705;

/* 
Один большой массив и два маленьких
*/



import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] mas1 = new int[20];
        int[] mas2 = new int[10];
        int[] mas3 = new int[10];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int j = 10;
        for (int i = 0; i < mas1.length; i ++){
            mas1[i] = Integer.parseInt(reader.readLine());
            if (i < mas2.length) {
                mas2[i] = mas1[i];
            } else {
                mas3[i -j] = mas1[i];
            }
        }
        for (int a:mas3
             ) {
            System.out.println(a);

        }
    }
}
