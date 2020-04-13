package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();

        List<Integer> list = new ArrayList<>();

        InputStream inStream = new FileInputStream(name);
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(inStream));

        while (fileReader.ready()) {
            int n = Integer.parseInt(fileReader.readLine());
            if (n % 2 == 0) {
                list.add(n);
            }
        }
        inStream.close();

        Collections.sort(list);
        for (int z : list) {
            System.out.println(z);
        }

    }
}
