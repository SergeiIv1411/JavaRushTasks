package com.javarush.task.task07.task0727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Меняем функциональность
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        ArrayList<ArrayList<String>> strings = new ArrayList<ArrayList<String>>();
        while (true) {
            String string = reader.readLine();
            if (string == null || string.isEmpty()) break;
            ArrayList<String> list = new ArrayList<>();
            list.add(string);
            strings.add(list);
        }
        for (ArrayList<String> list: strings
             ) {
            str = list.get(0);
            if(str.length() % 2 == 0) list.add(str);
            else {
                list.add(str);
                list.add(str);
            }
        }
        for (ArrayList<String> list: strings
        ) {
            for (String s: list
                 ) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
