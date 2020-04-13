package com.javarush.task.task07.task0712;

import javax.crypto.spec.PSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> strings = new ArrayList<>();
        int indexMax = 0, indexMin = 0, lengthMin = 0, lengthMax = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        for (int i = 0; i < 10; i ++){
            str = reader.readLine();
            strings.add(str);
            if (i == 0) {
                lengthMin = str.length();
                lengthMax = str.length();
                continue;
            }
            if(lengthMin > str.length()){
                indexMin = i;
                lengthMin = str.length();
            }
            if(lengthMax < str.length()){
                indexMax = i;
                lengthMax = str.length();
            }
        }
        if ((indexMax > indexMin)) {
            System.out.println(strings.get(indexMin));
        } else {
            System.out.println(strings.get(indexMax));
        }
    }
}
