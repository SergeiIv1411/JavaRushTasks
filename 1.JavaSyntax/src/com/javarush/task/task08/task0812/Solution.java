package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List <Integer> list   = new ArrayList<>(10);
        for (int i = 0; i  < 10; i++)

            list.add(Integer.parseInt(reader.readLine()));
        int longer = 1;
        for (int i = 0; i < list.size()-1; i++){
            int counter = 1;
            for (int j = i+1; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j)))
                    counter++;
                else break;
            }
            if (counter > longer)
                longer = counter;
        }
        System.out.println(longer);

    }
}