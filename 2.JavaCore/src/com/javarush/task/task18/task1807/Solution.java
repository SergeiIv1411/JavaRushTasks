package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

import static java.util.Collections.frequency;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        ArrayList list = new ArrayList();
        while(fileInputStream.available() > 0 ){
            list.add(fileInputStream.read());
        }
        int count = frequency(list,44);
        System.out.println(count);
        fileInputStream.close();
    }
}
