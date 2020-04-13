package com.javarush.task.task03.task0318;

/* 
План по захвату мира
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sAge = reader.readLine();
        String name = reader.readLine();
        int age = Integer.parseInt(sAge);
        System.out.println(name + " захватит мир через " + age + " лет. Му-ха-ха!");

    }
}
