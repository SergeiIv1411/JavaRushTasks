package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strings = new ArrayList<>();
        String str;
        int index = 0, length = 0;
        boolean isTrue = true;
        for (int i = 0; i < 10; i++){
            str = reader.readLine();
            strings.add(str);
            if (i == 0) {length = str.length();
            continue;}
            if (isTrue && length <= str.length()) length = str.length();
            else if (isTrue && length > str.length()) {isTrue = false;
            index = i;
            }
        }
        if (!isTrue) System.out.println(index);
    }
}

