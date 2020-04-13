package com.javarush.task.task07.task0714;

/* 
Слова в обратном порядке
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 5; i ++) {
            strings.add(reader.readLine());
        }
        strings.remove(2);
        for (int j = strings.size() - 1; j >= 0; j--){
            System.out.println(strings.get(j));
        }
    }
}
