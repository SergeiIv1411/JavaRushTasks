package com.javarush.task.task13.task1319;

/* 
Писатель в файл с консоли
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new FileWriter(reader.readLine()));
        String line;
        while(!(line =reader.readLine()).equals("exit")){
            writer.write(line + '\n');
        }
        writer.write(line);
        reader.close();
        writer.close();
    }
}
