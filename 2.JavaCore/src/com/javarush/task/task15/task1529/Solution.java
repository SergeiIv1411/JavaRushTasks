package com.javarush.task.task15.task1529;

/* 
Осваивание статического блока
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {

    }

    static {
        reset();
    }

    public static CanFly result;

    public static void reset() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = null;
        try {
            name = reader.readLine();
            if (name.equals("helicopter")) result = new Helicopter();
            else if (name.equals("plane")) {
                int count = Integer.parseInt(reader.readLine());
                result = new Plane(count);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
