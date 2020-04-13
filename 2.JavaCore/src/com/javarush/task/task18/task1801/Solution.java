package com.javarush.task.task18.task1801;

/* 
Максимальный байт
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream inputStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int maxByte = 0;
        while (inputStream.available() > 0){
            int data = inputStream.read();
                if(data > maxByte) maxByte = data;
        }
        System.out.println(maxByte);
        inputStream.close();
    }
}
