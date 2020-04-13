package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самая длинная строка
*/

public class Solution {
    private static ArrayList<String> strings;

    public static void main(String[] args) throws Exception {
        strings = new ArrayList<>();
        ArrayList<String> arMaxLength = new ArrayList<>();
        int maxLength = 0;
        String str;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int  i = 0; i < 5; i ++){
            str = reader.readLine();
            strings.add(str);
            if (maxLength == str.length()) arMaxLength.add(str);
            else
                if (maxLength < str.length()) {
                    arMaxLength.clear();
                    maxLength = str.length();
                    arMaxLength.add(str);
                }
        }
        for (String s: arMaxLength
             ) {
            System.out.println(s);

        }

    }
}
