package com.javarush.task.task07.task0707;

/* 
Что за список такой?
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> arrayList = new ArrayList<>();
        for(int i = 0; i < 5; i ++){
            arrayList.add("rgegergerg");
        }
        System.out.println(arrayList.size());
        for (String s:arrayList
             ) {
            System.out.println(s);

        }
    }
}
