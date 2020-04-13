package com.javarush.task.task18.task1805;

/* 
Сортировка байт
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Collections.frequency;

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        ArrayList<Integer> list = new ArrayList<>();
        while(fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            if (frequency(list, data) == 0)
                list.add(data);

        }
        int[] mas = new int[list.size()];
        for(int i = 0; i < list.size(); i ++){
            mas[i] = list.get(i);
        }
        Arrays.sort(mas);
        for (int a:mas
             ) {
            System.out.print(a + " ");

        }
        fileInputStream.close();
    }
}
