package com.javarush.task.task07.task0709;

/* 
Выражаемся покороче
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<String> arMinLength = new ArrayList<>();
        int minLength = 0;
        String str;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int  i = 0; i < 5; i ++){
            str = reader.readLine();
            strings.add(str);
            if (i == 0) {
                minLength = str.length();
                arMinLength.add(str);
                continue;
            }
            if (minLength == str.length()) arMinLength.add(str);
            else
            if (minLength > str.length()) {
                arMinLength.clear();
                minLength = str.length();
                arMinLength.add(str);
            }
        }
        for (String s: arMinLength
        ) {
            System.out.println(s);
        }
    }
}
