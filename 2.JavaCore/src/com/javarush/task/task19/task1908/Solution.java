package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        FileWriter writer = new FileWriter(reader.readLine());
        reader.close();
        StringBuffer stringBuffer = new StringBuffer();
        while (fileReader.ready()) {
            stringBuffer.append((char) fileReader.read());
        }
        fileReader.close();

        Pattern p = Pattern.compile("\\b([0-9])\\b");
        Matcher m = p.matcher(stringBuffer);

    }
}
