package com.javarush.task.task13.task1318;

/* 
Чтение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputStream inStream = new FileInputStream(reader.readLine());

        while (inStream.available() > 0)
        {
            int data = inStream.read();
            char ch = (char) data;
            System.out.print(ch);
        }

        inStream.close(); //закрываем потоки
        reader.close();
    }
    }
