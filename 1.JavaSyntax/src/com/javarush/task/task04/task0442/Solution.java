package com.javarush.task.task04.task0442;

/* 
Суммирование
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        int count;
        while (true){
            count = Integer.parseInt(reader.readLine());
            if(count == -1) {
                sum += count;
                break;
            }
            sum += count;
        }
        System.out.println(sum);
    }
}
