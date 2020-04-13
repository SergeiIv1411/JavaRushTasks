package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(reader.readLine()));
        reader.close();
        while (fileReader.ready()){
            String data = fileReader.readLine();
            Pattern pattern = Pattern.compile("\\.");
            Matcher matcher = pattern.matcher(data);
            String newStr = matcher.replaceAll("!");
            fileWriter.write(newStr + "\n");

        }
        fileReader.close();
        fileWriter.close();
    }
}
