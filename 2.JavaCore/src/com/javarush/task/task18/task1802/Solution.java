package com.javarush.task.task18.task1802;

/* 
Минимальный байт
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream inputStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int minByte = 999999999;
        while (inputStream.available() > 0){
            int data = inputStream.read();
            if(data < minByte) minByte = data;
        }
        System.out.println(minByte);
        inputStream.close();
    }
}
